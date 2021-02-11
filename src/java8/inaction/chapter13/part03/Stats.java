package java8.inaction.chapter13.part03;

public class Stats {
	int goldCount;
	
	public Stats() {
		goldCount = 0;
	}
	
	public void incrementFor(String str) {
		if ("gold".equals(str)) {
			goldCount++;
		}
	}

}
