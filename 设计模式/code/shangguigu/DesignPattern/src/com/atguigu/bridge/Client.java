package com.atguigu.bridge;

public class Client {

	public static void main(String[] args) {

		// ��ȡ�۵�ʽ�ֻ� (��ʽ + Ʒ�� )
		Phone phone1 = new FoldedPhone(new XiaoMi());
		phone1.open();
		phone1.call();
		phone1.close();

		System.out.println("==============");

		UpRightPhone phone4 = new UpRightPhone(new Vivo());
		phone4.open();
		phone4.call();
		phone4.close();
	}

}
