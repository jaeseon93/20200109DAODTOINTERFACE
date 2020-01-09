package co.jessie.methodExam;

public class MethodCall {
	public void run() { // 다른 클래스에서 만든 메소드를 불러오려면 메소드안에서 호출해야한다.
		ExamMethod exam = new ExamMethod();
		exam.exam01();  //리턴타입이 없는 void. 프로시저수행.

		int result = exam.sum(10, 5);
		int n = 20;
		int m = 60;
		int hap = exam.sum(n, m);
		
		
		String msg = exam.str();
		
		System.out.println("처음 호출한 결과 : " + result);
		System.out.println("두번째 호출한 결과: " + hap);
		System.out.println("str() 호출한 결과: " + msg);

	}

}
