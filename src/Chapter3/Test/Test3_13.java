package Chapter3.Test;

import Chapter3.Object.C3_12;
import Chapter3.Object.MyStack3_12;
import Chapter3.Object.P3_12;
import Chapter3.Thread.Thread3_12A;
import Chapter3.Thread.Thread3_12B;

public class Test3_13 {
	//多生产与一消费： 【操作栈】
	public static void main(String[] args) {
		MyStack3_12 ms=new MyStack3_12();
		P3_12 p1=new P3_12(ms);
		P3_12 p2=new P3_12(ms);
		P3_12 p3=new P3_12(ms);
		P3_12 p4=new P3_12(ms);
		P3_12 p5=new P3_12(ms);
		C3_12 c=new C3_12(ms);
		Thread3_12A tp1=new Thread3_12A(p1);
		Thread3_12A tp2=new Thread3_12A(p2);
		Thread3_12A tp3=new Thread3_12A(p3);
		Thread3_12A tp4=new Thread3_12A(p4);
		Thread3_12A tp5=new Thread3_12A(p5);
		tp1.start();
		tp2.start();
		tp3.start();
		tp4.start();
		tp5.start();
		
		Thread3_12B tc=new Thread3_12B(c);
		tc.start();
	}
	


}
