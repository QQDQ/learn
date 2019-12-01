package com.atguigu.mediator.smarthouse;

import java.util.HashMap;

//������н�����
public class ConcreteMediator extends Mediator {
	//���ϣ��������е�ͬ�¶���
	private HashMap<String, Colleague> colleagueMap;
	private HashMap<String, String> interMap;

	public ConcreteMediator() {
		colleagueMap = new HashMap<String, Colleague>();
		interMap = new HashMap<String, String>();
	}

	@Override
	public void register(String colleagueName, Colleague colleague) {
		colleagueMap.put(colleagueName, colleague);

		if (colleague instanceof Alarm) {
			interMap.put("Alarm", colleagueName);
		} else if (colleague instanceof CoffeeMachine) {
			interMap.put("CoffeeMachine", colleagueName);
		} else if (colleague instanceof TV) {
			interMap.put("TV", colleagueName);
		} else if (colleague instanceof Curtains) {
			interMap.put("Curtains", colleagueName);
		}
	}

	//�����н��ߵĺ��ķ���
	//1. ���ݵõ���Ϣ����ɶ�Ӧ����
	//2. �н��������������Э�����������ͬ�¶����������
	@Override
	public void getMessage(int stateChange, String colleagueName) {
		
		//�������ӷ�������Ϣ
		if (colleagueMap.get(colleagueName) instanceof Alarm) {
			if (stateChange == 0) {
				((Alarm)(colleagueMap.get(interMap.get("Alarm")))).ringing();
				((CoffeeMachine) (colleagueMap.get(interMap.get("CoffeeMachine")))).startCoffee();
				((Curtains) (colleagueMap.get(interMap.get("Curtains")))).fallCurtains();
				((TV) (colleagueMap.get(interMap.get("TV")))).startTv();
			} else if (stateChange == 1) {
				((TV) (colleagueMap.get(interMap.get("TV")))).stopTv();
			}

		} else if (colleagueMap.get(colleagueName) instanceof CoffeeMachine) {
			
		} else if (colleagueMap.get(colleagueName) instanceof TV) {//���TV������Ϣ

		} else if (colleagueMap.get(colleagueName) instanceof Curtains) {
			//������Դ�����������Ϣ�����ﴦ��...
		}

	}

	@Override
	public void sendMessage() {}
}
