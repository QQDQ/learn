package com.atguigu.strategy.improve;

public abstract class Duck {

	//����, ���Խӿ�
	FlyBehavior flyBehavior;
	//��������<->���Խӿ�
	QuackBehavior quackBehavior;
	
	public Duck() {}

	public abstract void display();//��ʾѼ����Ϣ
	
	public void fly() {
		//�Ľ�
		if(flyBehavior != null) {
			flyBehavior.fly();
		}
	}
	
	public void quck() {
		if(quackBehavior!= null) {
			quackBehavior.quack();
		}
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}
	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
}
