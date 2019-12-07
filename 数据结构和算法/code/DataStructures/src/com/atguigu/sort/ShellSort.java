package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		System.out.println("����ǰ");
		System.out.println(Arrays.toString(arr));

		 shellSort0(arr); // ����ʽ �Ƶ�����
//		shellSort1(arr); // ����ʽ ����
		// shellSort2(arr);// ϣ�� �������� �Ƶ�����
//		 shellSort3(arr);// ϣ����������

		System.out.println("�����");
		System.out.println(Arrays.toString(arr));

		// ����Ҫ��80000�������������
		// int[] arr = new int[8000000];
		// for (int i = 0; i < 8000000; i++) {
		// arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
		// }
		//
		// System.out.println("����ǰ");
		// Date data1 = new Date();
		// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd
		// HH:mm:ss");
		// String date1Str = simpleDateFormat.format(data1);
		// System.out.println("����ǰ��ʱ����=" + date1Str);
		//
		// // shellSort0(arr); //����ʽ �Ƶ�����
		// // shellSort1(arr);// ϣ�� ����ʽ ����
		// // shellSort2(arr);//ϣ�� �������� �Ƶ�����
		// shellSort3(arr);// ϣ����������
		//
		// Date data2 = new Date();
		// String date2Str = simpleDateFormat.format(data2);
		// System.out.println("����ǰ��ʱ����=" + date2Str);

	}

	// Ч�ʱ�ֱ�Ӳ�������Ҫ���ܶ� �������˽���
	public static void shellSort0(int[] arr) {
		int temp = 0;

		// ϣ������ĵ�1������
		// ��Ϊ��1�������ǽ�10�����ݷֳ��� 5��
		for (int i = 5; i < arr.length; i++) {
			// �������������е�Ԫ��(��5�飬ÿ����2��Ԫ��), ����5
			for (int j = i - 5; j >= 0; j -= 5) {
				// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
				if (arr[j] > arr[j + 5]) {
					temp = arr[j];
					arr[j] = arr[j + 5];
					arr[j + 5] = temp;
				}
			}
		}

		System.out.println("ϣ�� ����1�ֺ�=" + Arrays.toString(arr));//

		// ϣ������ĵ�2������
		// ��Ϊ��2�������ǽ�10�����ݷֳ��� 5/2 = 2��
		for (int i = 2; i < arr.length; i++) {
			// �������������е�Ԫ��(��2�飬ÿ����5��Ԫ��), ����2
			for (int j = i - 2; j >= 0; j -= 2) {
				// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
				if (arr[j] > arr[j + 2]) {
					temp = arr[j];
					arr[j] = arr[j + 2];
					arr[j + 2] = temp;
				}
			}
		}

		System.out.println("ϣ�� ����2�ֺ�=" + Arrays.toString(arr));//

		// ϣ������ĵ�3������
		// ��Ϊ��3�������ǽ�10�����ݷֳ��� 2/2 = 1��
		for (int i = 1; i < arr.length; i++) {
			// �������������е�Ԫ��(��1�飬ÿ����10��Ԫ��), ����1
			for (int j = i - 1; j >= 0; j -= 1) {
				// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		System.out.println("ϣ�� ����3�ֺ�=" + Arrays.toString(arr));//

	}

	// ʹ�����Ƶ��ķ�ʽ����дϣ������
	// ϣ������ʱ�� �����������ڲ���ʱ���ý�����,
	// ˼·(�㷨) ===> ����
	public static void shellSort1(int[] arr) {

		int temp = 0;
		int count = 0;
		// ����ǰ����𲽷�����ʹ��ѭ������
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				// �������������е�Ԫ��(��gap�飬ÿ���и�Ԫ��), ����gap
				for (int j = i - gap; j >= 0; j -= gap) {
					// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
			System.out.println("ϣ�� ������" + (++count) + "�� =" + Arrays.toString(arr));
		}

	}

	//
	public static void shellSort2(int[] arr) {

		// ϣ������ĵ�1������
		// ��Ϊ��1�������ǽ�10�����ݷֳ��� 5��(0,5)(1,6)(2,7)(3,8)(4,9) ÿһ�����ֱ������
		for (int i = 5; i < arr.length; i++) {

			int insertVal = arr[i];
			int insertIndex = i - 5; // ��arr[5]��ǰ����������±�
			while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
				arr[insertIndex + 5] = arr[insertIndex];// arr[insertIndex]
				insertIndex -= 5;
			}
			// ���˳�whileѭ��ʱ��˵�������λ���ҵ�, insertIndex + 5
			arr[insertIndex + 5] = insertVal;

		}

		System.out.println("ϣ������1�ֺ�=" + Arrays.toString(arr));//

		// ϣ������ĵ�2������
		// ��Ϊ��2�������ǽ�10�����ݷֳ��� 5/2 = 2��(0,2,4,6,8)(1,3,5,7,9)ÿһ�����ֱ������
		for (int i = 2; i < arr.length; i++) {

			int insertVal = arr[i];
			int insertIndex = i - 2; // ��arr[2]��ǰ����������±�
			while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
				arr[insertIndex + 2] = arr[insertIndex];// arr[insertIndex]
				insertIndex -= 2;
			}
			// ���˳�whileѭ��ʱ��˵�������λ���ҵ�, insertIndex + 2
			arr[insertIndex + 2] = insertVal;
		}

		System.out.println("ϣ������2�ֺ�=" + Arrays.toString(arr));//

		// ϣ������ĵ�3������
		// ��Ϊ��3�������ǽ�10�����ݷֳ��� 2/2 = 1��
		for (int i = 1; i < arr.length; i++) {
			int insertVal = arr[i];
			int insertIndex = i - 1; // ��arr[1]��ǰ����������±�
			while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
				insertIndex -= 1;
			}
			// ���˳�whileѭ��ʱ��˵�������λ���ҵ�, insertIndex + 1
			arr[insertIndex + 1] = insertVal;
		}

		System.out.println("ϣ������3�ֺ�=" + Arrays.toString(arr));//

	}

	public static void shellSort3(int[] arr) {

		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {

				int insertVal = arr[i];
				int insertIndex = i - gap; // ��arr[gap]��ǰ����������±�
				while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
					arr[insertIndex + gap] = arr[insertIndex];// arr[insertIndex]
					insertIndex -= gap;
				}
				// ���˳�whileѭ��ʱ��˵�������λ���ҵ�, insertIndex + gap
				arr[insertIndex + gap] = insertVal;
			}
			System.out.println("ϣ������ ���Ϊ" + gap + "�� =" + Arrays.toString(arr));
		}

	}

}
