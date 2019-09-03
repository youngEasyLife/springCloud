这时Spring Cloud Ribbon就派上用场了。Ribbon就是专门解决这个问题的。
它的作用是负载均衡，会帮你在每次请求时选择一台机器，均匀的把请求分发到各个机器上
Ribbon的负载均衡默认使用的最经典的Round Robin轮询算法。这是啥？
简单来说，就是如果订单服务对库存服务发起10次请求，那就先让你请求第1台机器、然后是第2台机器、第3台机器、第4台机器、第5台机器，
接着再来—个循环，第1台机器、第2台机器。。。以此类推。
 
 此外，Ribbon是和Feign以及Eureka紧密协作，完成工作的，具体如下：
首先Ribbon会从 Eureka Client里获取到对应的服务注册表，也就知道了所有的服务都部署在了 哪些机器上，在监听哪些端口号。
然后Ribbon就可以使用默认的Round Robin算法，从中选择一台机器
Feign就会针对这台机器，构造并发起请求。

Hystrix的本意是指 豪猪 的动物，它身上长满了很长的较硬的空心尖刺,当受到攻击时，通过后退的方式使其尖刺刺入敌方的身体。
作为这种特征的引申，Netflix公司在分布式微服务架构的践行下，将其保护服务的稳定性而设计的客户端熔断和断路器的解决方案，称之为Hystrix。

但是我们思考一下，就算积分服务挂了，订单服务也可以不用挂啊！为什么？
我们结合业务来看：支付订单的时候，只要把库存扣减了，然后通知仓库发货就OK了
如果积分服务挂了，大不了等他恢复之后，慢慢人肉手工恢复数据！为啥一定要因为一个积分服务挂了，就直接导致订单服务也挂了呢？不可以接受！
 
 
现在问题分析完了，如何解决？
这时就轮到Hystrix闪亮登场了。Hystrix是隔离、熔断以及降级的一个框架。啥意思呢？说白了，Hystrix会搞很多个小小的线程池，
比如订单服务请求库存服务是一个线程池，请求仓储服务是一个线程池，请求积分服务是一个线程池。每个线程池里的线程就仅仅用于请求那个服务。
 
 
打个比方：现在很不幸，积分服务挂了，会咋样？
当然会导致订单服务里的那个用来调用积分服务的线程都卡死不能工作了啊！但是由于订单服务调用库存服务、
仓储服务的这两个线程池都是正常工作的，所以这两个服务不会受到任何影响。
 
 
这个时候如果别人请求订单服务，订单服务还是可以正常调用库存服务扣减库存，调用仓储服务通知发货。只不过调用积分服务的时候
，每次都会报错。但是如果积分服务都挂了，每次调用都要去卡住几秒钟干啥呢？有意义吗？当然没有！所以我们直接对积分服务熔断不就得了，
比如在5分钟内请求积分服务直接就返回了，不要去走网络请求卡住几秒钟，这个过程，就是所谓的熔断！
 
 
那人家又说，兄弟，积分服务挂了你就熔断，好歹你干点儿什么啊！别啥都不干就直接返回啊？没问题，咱们就来个降级：每次调用积分服务，
你就在数据库里记录一条消息，说给某某用户增加了多少积分，因为积分服务挂了，导致没增加成功！这样等积分服务恢复了，
你可以根据这些记录手工加一下积分。这个过程，就是所谓的降级。
