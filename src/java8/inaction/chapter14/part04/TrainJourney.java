package java8.inaction.chapter14.part04;

public class TrainJourney {
	public int price;
	public TrainJourney onward;
	
	public TrainJourney(int price, TrainJourney onward) {
		super();
		this.price = price;
		this.onward = onward;
	}
	
	public static TrainJourney link(TrainJourney a, TrainJourney b) {
		if (a == null) {
			return b;
		}
		
		TrainJourney t = a;
		
		while (t.onward != null) {
			t = t.onward;
		}
		
		t.onward = b;
		return a;
	}
	
	public static TrainJourney append(TrainJourney a, TrainJourney b) {
		return a == null ? b : new TrainJourney(a.price, append(a.onward, b));
	}
}
