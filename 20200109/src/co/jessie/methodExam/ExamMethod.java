package co.jessie.methodExam;

public class ExamMethod {
	public void  exam01() {
		System.out.println("리턴 타입이 없는 기본메소드 입니다.");
	}
	public int sum (int n , int m) {  //()매개변수는 {}실행 구문안에서 바로쓰면된다.
		System.out.println("전달인자 두개를 합함");
		int result =  n+m;
		System.out.println("전달된 N값:" + n);
		return result;
	}
	 public String str() {
		 System.out.println("문자열을 돌래주는 메소드");
		 String msg = "문자만 돌려줘요";
		 return msg;
	 }
}
