package Chapter2.Thread;

import Chapter2.Object.Object2_23;

public class Thread2_23A extends Thread{
	//ͬ��synchronized�������޵ȴ�����  
	
	private Object2_23 obj;
	
	public Thread2_23A(Object2_23 obj){
		this.obj=obj;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		obj.methodA();
	}

}