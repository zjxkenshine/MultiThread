package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Test5_02_2 {
	//��Timer��Ϊ�ػ��߳�
	
	/**
	 * �������к�������ֹ������ִ��TimerTask�е�����,��Ϊ�����Ѿ���ֹ��
	 */

	private static Timer time=new Timer(true);            //��ʼΪ�ػ��߳�
	
	static public class MyTask extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("������,ʱ��Ϊ"+System.currentTimeMillis());
		}
	}
	
	public static void main(String[] args) {
		try{
			MyTask tsk=new MyTask();
			SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			String dateString="2017-10-10 21:04:00";
			Date dt=sdf.parse(dateString);
			System.out.println("�ַ���ʱ�䣺"+dt.toLocaleString()+"��ǰʱ�䣺"+new Date().toLocaleString());
			time.schedule(tsk, dt);
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}