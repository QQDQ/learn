package com.atguigu.facade;

public class Client {

	public static void main(String[] args) {
		//����ֱ�ӵ��á��� ���鷳, ���������ģʽ����
		HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
		homeTheaterFacade.ready();
		System.out.println("-----------");
		homeTheaterFacade.play();
		System.out.println("-----------");
		homeTheaterFacade.end();
	}
}
