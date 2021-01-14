package java8.inaction.chapter08.observer;

public interface Subject {
	public void registerObserver(Observer o);
	public void notifyObservers(String tweet);
}
