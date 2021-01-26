package java8.inaction.chapter09.part03;

public class Optional_MultipleMethod {
	/*
	public interface Iterator<E> {
	    boolean hasNext();

	    E next();
	    
	    // 디폴트 메서드의 선택형 메서드 Optional Method
	    // 인터페이스의 구현 클래스의 메서드의 내용이 비여있는 것을 볼 수 있을 것이다.
	    // 자바 8이전에 remove기능은 사용 빈도가 적거나 무시했었고 결국 remove의 빈 구현을 제공하게 되었다.
	    // 디폴트 메서드를 사용하게 되면 클래스에서 빈 구현을 할 필요가 없다.
	    default void remove() {
	        throw new UnsupportedOperationException("remove");
	    }

	    default void forEachRemaining(Consumer<? super E> action) {
	        Objects.requireNonNull(action);
	        while (hasNext())
	            action.accept(next());
	    }
	}
	
	AbstractList 상속 받으며, 3개이 인터페이스를 구현한다.
	public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable
	{...}
	*/
	
	
}
