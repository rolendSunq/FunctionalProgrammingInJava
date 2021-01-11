package java8.inaction.chapter08;

public class LambdaByAnonymousClass {
	public static void main(String[] args) {
		/**
		 * 단일 추상 메서드를 구현하는 익명 클래스는 람다 표현식으로 리팩토링할 수 있다.
		 */
		// 익명 클래스를 사용한 기존 코드
		Runnable r1	= new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello");
			}
		};
		r1.run();
		
		// 람다 표현식을 사용한 코드
		Runnable r2 = () -> System.out.println("Hello Lambda");
		r2.run();
		
		/**
		 * 모든 익명 클래스를 람다 표현식으로 변환할 수 있는 것은 아니다.
		 * 1. 익명 클래스의 this와 super는 람다 표현식에서 다른 의미이다.
		 * 2. (shadow variable) 익명 클래스는 감싸고 있는 클래스의 변수를 
		 * 가릴 수 있다. 그러나 람다 표현식에서는 가릴 수 없다.
		 * 아래의 코드는 컴파일 되지 않는다.
		 */
		int a = 10;
		Runnable r3 = () -> {
			// 컴파일 에러 - 그림자 변수가 되지 않는다.
			//int a = 2;
			System.out.println(a);
		};
		r3.run();
		
		Runnable r4 = new Runnable() {
			
			@Override
			public void run() {
				// 정상 작동된다.
				int a = 2;
				System.out.println(a);
			}
		};
		r4.run();
		
		/**
		 * 3. 익명 클래스를 람다 표현식으로 바꾸면 콘텍스트 오버로딩에 따른
		 * 모호함이 초래될 수 있다.
		 * 익명 클래스는 인스턴스화할 때 명시적으로 형식이 정해지는 반면
		 * 람다의 형식은 콘텍스트에 따라 달라진다.
		 * interface Task {
		 *     public void execute();
		 * }
		 * public static void doSomething(Runnable r) { r.run(); }
		 * public static void doSomething(Task a) { a.execute(); } 
		 */
		// Task를 구현하는 익명 클래스를 전달할 수 있다.
		doSomething(new Task() {

			@Override
			public void execute() {
				System.out.println("Danger danger!!");
			}
			
		});
		
		// 문제는 익명 클래스를 람다 표현식으로 바꾸면 메서드를 호출할때 
		// Runnable과 Task가 모두 대상 형식이 될 수 있으므로 모호함이 발생한다.
		// doSomething(() -> System.out.println("Danger danger!!"));
		
		// 명시적 형변환 (Task)를 이용해서 모호함을 제거할 수 있다.
		doSomething((Task)() -> System.out.println("Danger danger!!"));
	}
	
	public static void doSomething(Runnable r) { r.run(); }
	public static void doSomething(Task a) { a.execute(); }
}
