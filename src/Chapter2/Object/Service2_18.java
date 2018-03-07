package Chapter2.Object;

public class Service2_18 {
	//synchronized(任意非this对象x)结论验证2：       当其他线程执行x对象中的synchronized同步方法时呈同步效果
	
	public void MethodB(Object2_18 obj) throws InterruptedException{
		synchronized (obj) {
			System.out.println("service对象方法MethodB 得到锁 时间："+System.currentTimeMillis()+"运行线程="+Thread.currentThread().getName());
			Thread.sleep(3000);
			System.out.println("service对象方法MethodB 释放锁 时间："+System.currentTimeMillis()+"运行线程="+Thread.currentThread().getName());
		}
	}

}
