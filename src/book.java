
public class book {
	
	/**
	 * 
	 * 
	 * 
	 * java多线程编程核心技术
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	/**第一章：多线程基础
	 * 
	 * -----------基础测试----------------
	 * 1_1: 调用的随机性测试
	 * 1_2: 线程的随机性测试
	 * 1_3: 线程不确定性：调用Start方法顺序不是线程执行顺序
	 * 1_4: 线程的另一种实现方式：实现runnable接口
	 * 
	 * -----------线程安全----------------
	 * 1_5: 线程间：数据不共享
	 * 1_6: 数据共享：非线程安全，两个线程同时对数据处理
	 * 1_7: 数据共享：synchornized排队处理，线程安全
	 * 				 synchornized也可以修饰servlet中的方法
	 * 1_8: i--与println合用没用synchornized时出现非线程安全
	 * 
	 * -----------常用方法----------------
	 * 1_9: currentThread()方法：返回代码段正在被哪个线程调用
	 * 1_10: this.getName()与thread.currentThread.getName()的区别
	 * 1_11：isAlive()方法：判断线程是否处于活动状态
	 * 1_12: isAlive()的复杂情况，this.isAlive()
	 * 1_13: sleep()方法，使this.currentThread()(正在执行的线程)休眠指定毫秒
	 * 1_14: getId()方法，获取线程的唯一标识
	 * 
	 * -----------线程中断与判断----------------
	 * 1_15: 线程停止标记：Thread.interrupt()停止标记，无法停止线程
	 * 1_16: this.interrupted():判断当前线程（运行该方法的线程）是否中断，
	 * 					执行后 清除 中断标记，静态方法
	 * 1_17: this.isInterrupted():非静态方法，测试线程对象（非当前线程）是否中断，
	 * 					但不清除中断状态标记
	 * 
	 * -----------线程停止三种方法----------------
	 * 1_18: 异常法停止线程（推荐使用）throw new InterruptException
	 * 1_19: 在sleep()状态下使用interrput() 或相反，抛出异常从而停止线程（推荐使用）
	 * 1_20: stop()方法暴力停止（不推荐使用） stop方法已不再使用
	 * 1_21: interrupt()与return结合使用实现停止线程（可以使用）
	 * 
	 * -----------线程暂停与恢复----------------
	 * 1_22: 暂停线程：suspend()挂起，resume()恢复     (过期作废仍可使用的方法)
	 * 1_23: suspend()与resume()缺点一：独占（公共同步对象，独占锁等）
	 * 1_24: suspend()与resume()缺点二：导致数据不同步
	 * 1_25: yield()方法：使线程放弃当前CPU资源，将它让给其他任务去占用cpu执行时间
	 * 					但放弃的时间不确定，可能刚放弃又获得时间片了。
	 * 
	 * -----------线程优先级----------------
	 * 1_26: 线程优先级的继承性
	 * 1_27: 线程优先级的规则性
	 * 1_28: 线程优先级的随机性
	 * 1_29: 线程优先级高运行得快
	 * 
	 * -----------守护线程----------------
	 * 1_30：守护线程与用户线程
	 * 
	 */
	
	
	/**第二章：对象及变量的并发访问
	 * 
	 * -----------synchronized同步方法----------------
	 * 2_01: 方法内的变量为线程安全
	 * 2_02: 实例变量非线程安全
	 * 2_03: 多个对象会产生多个锁
	 * 2_04: synchronized方法锁的是实例对象而非方法
	 * 2_05: 脏读（dirtyRead）
	 * 2_06: synchronized锁的重入
	 * 2_07: 代码出现异常时，其所持有的锁会自动释放
	 * 2_08: 同步不具有继承性
	 * 
	 * -----------synchronized(this)同步语句块----------------
	 * 2_09: synchronized方法的弊端--长时间排队
	 * 2_10: synchronized(this)同步代码块的使用
	 * 2_11: synchronized(this)解决同步方法的弊端
	 * 2_12: 同步代码块一半同步一半异步
	 * 2_13: synchronized(this)代码块间的同步性
	 * 2_14: 验证synchronized(this)代码块是锁定当前对象的
	 * 
	 * -----------synchronized(任意非this对象)同步语句块----------------
	 * 2_15: 将任意非this对象x作为【对象监视器】   synchronized(任意非this对象)
	 * 2_16: synchronized(任意非this对象x)解决脏读问题
	 * 2_17: synchronized(任意非this对象x)结论验证1：
	 *            多个线程同时执行synchronized(x){}同步代码块时呈同步效果
	 * 2_18: synchronized(任意非this对象x)结论验证2：
	 *           当其他线程执行x对象中的synchronized同步方法时呈同步效果
	 * 2_19: synchronized(任意非this对象x)结论验证3：
	 *           当其他线程执行x对象中的synchronized(this)同步代码块时呈同步效果
	 * 
	 * -----------synchronized一些其他知识点----------------     
	 * 2_20: 静态同步synchronized方法
	 * 2_21: synchronized(class)代码块
	 * 2_22: 【String常量池的特性】给synchronized(String)带来的例外,使用obj对象做监视器
	 * 2_23: 同步synchronized方法无限等待与解决    
	 * 2_24: 多线程的死锁
	 * 2_25: 内置类与静态内置类
	 * 2_26: 内置类与同步实验1
	 * 2_27: 内置类与同步实验2
	 * 2_28: 锁对象的改变
	 * 
	 * -----------volatile关键字---------------- 
	 * 2_29: volatile关键字与死循环
	 * 2_30: volatile解决同步死循环
	 * 2_31: volatile解决异步死循环（volatile与synchronized的比较）
	 * 2_32: volatile的非原子特性
	 *           
	 * -----------原子类与其他----------------           
	 * 2_33: 使用原子类对i++进行操作
	 * 2_34: 原子类也并非完全安全
	 * 2_35: synchronized代码块有volatile同步功能          
	 *           
	 *           
	 */
	
	
	/**第三章：线程间通信
	 * 
	 * -----------等待/通知机制----------------
	 * 3_01: 不使用等待/通知机制实现线程通信
	 * 3_02: 等待/通知机制的实现（wait/notify方法）*
	 * 3_03: 方法wait()锁释放与notify()锁不释放
	 * 3_04: interrupt方法遇到wait方法
	 * 3_05: 调用方法notify一次只能通知一个线程并唤醒，notifyAll通知所有
	 * 3_06: wait(long)方法的使用
	 * 3_07: 通知过早
	 * 3_08: 等待wait的条件发生变化
	 * 
	 * -----------生产者/消费者模式的实现----------------
	 * 3_09: 一生产者与一消费者：【操作值】
	 * 3_10: 多生产与多消费：【操作值】---出现假死
	 * 3_11: 一生产与一消费：【操作栈】
	 * 3_12: 一生产与多消费：【操作栈】---解决条件改变与假死
	 * 3_13: 多生产与一消费：【操作栈】
	 * 3_14: 多生产与多消费：【操作栈】
	 * 
	 * -----------管道通信及交叉备份----------------
	 * 3_15: 通过管道进行线程间通信：字节流 byte
	 * 3_16： 通过管道进行线程间通信：字符流char
	 * 3_17： 实战：等待/通知交叉备份
	 * 
	 * -----------join方法----------------
	 * 3_18: 学习join前的铺垫
	 * 3_19: 使用join()方法
	 * 3_20: 方法join与interrupt异常
	 * 3_21: 方法join(long)的使用
	 * 3_22: join(long)与sleep(long)的区别
	 * 3_23: 方法join()后面的代码提前运行：出现意外及解释
	 * 
	 * -----------类ThreadLocal的使用----------------
	 * 3_24: get()方法与null 
	 * 3_25: 验证线程变量的隔离性
	 * 3_26: 解决get返回初始值为null的问题
	 * 3_27: 验证多个线程的初始值
	 * 
	 * -----------类InheritableThreadLocal的使用----------------
	 * 3_28: InheritableThreadLocal值继承
	 * 3_29: 值继承再修改
	 * 
	 */
	

	/**第四章：Lock的使用
	 * 
	 * -----------使用ReentratLock类----------------
	 * 4_01: 使用ReentratLock实现同步：测试1
	 * 4_02: 使用ReentratLock实现同步：测试2
	 * 
	 * -----------Condition实现等待/通知----------------
	 * 4_03: 使用Condition实现等待/通知：错误的用法及解决
	 * 4_04: 正确使用Condition实现等待/通知
	 * 4_05: 使用多个Condition实现通知部分线程时的错误用法
	 * 4_06: 正确使用多个Condition实现通知部分线程
	 * 4_07: 实现生产者/消费者模式：一对一打印
	 * 4_08: 实现生产者/消费者模式：多对多打印
	 * 
	 * -----------公平锁与非公平锁----------------
	 * 4_09: 公平锁与非公平锁
	 * 
	 * -----------Lock的其他方法和操作----------------
	 * 4_10: 方法getHoldCount(),getQueueLength()和getWaitQueueLength()
	 * 4_11: 方法hasQueueThread(),hasQueueThreads()和hasWaiters()
	 * 4_12: 方法isFair(),isHeldByCurrentThread()和isLocked()
	 * 4_13: 方法lockInterruptibly(),tryLock()和tryLock(long timeout,TimeUnit unit)
	 * 4_14: 方法awaitUninterruptibly()的使用
	 * 4_15: 方法awaitUntil()的使用
	 * 4_16: 用Condition实现顺序执行
	 * 
	 * -----------ReentrantReadWriteLock类----------------
	 * 4_17: ReentrantReadWriteLock类的使用：【读读共享】
	 * 4_18: ReentrantReadWriteLock类的使用：【写写互斥】
	 * 4_19: ReentrantReadWriteLock类的使用：【读写互斥】
	 * 4_20: ReentrantReadWriteLock类的使用：【写读互斥】
	 * 
	 */
	
	
	/**第五章：定时器Timer的使用
	 * 
	 * 5_01: Timer简介
	 * 
	 * -----------方法schedule(TimeTask task,Date time)测试----------------
	 * 5_02: 执行任务的时间晚于当前时间：在未来执行的效果
	 * 5_03: 计划时间早于当前时间： 提前执行的效果
	 * 5_04: 多个TimerTask任务及延时的测试
	 * 
	 * -----------方法schedule(TimeTask task,Date firstTime,long period)测试----------------
	 * 5_05: 执行任务的时间晚于当前时间：在未来执行的效果
	 * 5_06: 计划时间早于当前时间： 提前执行的效果
	 * 5_07: 任务执行时间被延时
	 * 5_08: TimerTask类中的cancel()方法
	 * 5_09: Timer类中的cancel()方法
	 * 5_10: Timer类中的cancel()方法的注意事项
	 * 
	 * -----------方法schedule(TimeTask task,long delay)以及schedule(TimeTask task,long delay,long period)测试----------------
	 * 5_11: 方法schedule(TimeTask task,long delay)测试
	 * 5_12: 方法schedule(TimeTask task,long delay,long period)测试
	 * 
	 * -----------方法scheduleAtFixedRate(TimeTask task,Date firstTime,long period)测试----------------
	 * 5_13: 方法scheduleAtFixedRate和schedule的区别
	 * 5_14: 测试schedule方法任务不延时
	 * 5_15: 测试schedule方法任务延时
	 * 5_16: 测试方法scheduleAtFixedRate任务不延时
	 * 5_17: 测试方法scheduleAtFixedRate任务延时
	 * 5_18: 验证schedule不具有任务追赶性
	 * 5_19: 验证scheduleAtFixedRate具有任务追赶性
	 * 
	 * 
	 */
	

	/**第六章：单例模式与多线程
	 * 
	 * 6_01: 简介
	 * 
	 * -----------立即加载/饿汉模式----------------
	 * 6_02: 立即加载/饿汉模式
	 * 
	 * -----------延迟加载/懒汉模式----------------
	 * 6_03: 延迟加载/懒汉模式解析
	 * 6_04: 延迟加载/懒汉模式的缺点
	 * 6_05: 延迟加载/懒汉模式的缺点的解决方法1：声明synchronize关键字
	 * 6_06: 延迟加载/懒汉模式的缺点的解决方法2：使用同步代码块
	 * 6_07: 延迟加载/懒汉模式的缺点的解决方法3：部分同步
	 * 6_08: 延迟加载/懒汉模式的缺点的解决方法4：DCL双检查锁机制(Double-Check Locking)
	 * 
	 * -----------使用其他方法实现单例模式----------------
	 * 6_09: 使用静态内置类实现单例模式
	 * 6_10: 序列化与反序列化的单例模式实现
	 * 6_11: 使用static代码实现单例模式
	 * 
	 * -----------用enum枚举类实现单例模式----------------
	 * 6_12: 使用enum枚举数据类型实现单例模式
	 * 6_13: 完善使用enum枚举数据类型实现单例模式
	 * 
	 */
	
	
	/**第七章：拾遗增补
	 * 
	 * 对前面章节的知识点补充
	 * 
	 * -----------线程的状态----------------
	 * 7_01: 验证NEW,RUNNABLE和TERMINATED状态
	 * 7_02: 验证TIMED_WAITING状态
	 * 7_03: 验证BLOCKED状态
	 * 7_04: 验证WAITING状态
	 * 
	 * -----------线程组----------------
	 * 7_05: 线程对象关联线程组：一级关联
	 * 7_06: 线程对象关联线程组：多级关联
	 * 7_07: 线程组的自动归属特性
	 * 7_08: 获取根线程组
	 * 7_09: 线程组里加线程组
	 * 7_10: 线程组内的线程批量停止
	 * 7_11: 递归与非递归取得组内对象
	 * 
	 * -----------使线程具有有序性----------------
	 * 7_12: 使线程具有有序性
	 * 
	 * -----------SimpleDateFormat非线程安全----------------
	 * 7_13: SimpleDateFormat出现异常的情况
	 * 7_14: 解决异常方法1：创建多个SimpleDateFormat对象
	 * 7_15: 解决异常方法2： 使用ThreadLocal类
	 * 
	 * -----------其他异常处理----------------
	 * 7_16: 线程中出现异常的处理
	 * 7_17: 线程组内处理异常
	 * 7_18: 线程异常处理的传递
	 * 
	 * 
	 */
}
