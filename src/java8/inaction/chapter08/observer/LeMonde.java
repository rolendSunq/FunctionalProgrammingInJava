package java8.inaction.chapter08.observer;

public class LeMonde implements Observer {

	@Override
	public void notify(String tweet) {
		if (tweet != null && tweet.contains("wine")) {
			System.out.println("Today cheese, wine and news! " + tweet);
		}
	}

}
