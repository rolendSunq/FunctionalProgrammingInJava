package java8.inaction.lambda;

import java.util.List;

public class Movie {
	
	private String name;
	private String directorName;
	private List<String> cast;
	
	public Movie(String name, String directorName, List<String> cast) {
		this.name = name;
		this.directorName = directorName;
		this.cast = cast; 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public List<String> getCast() {
		return cast;
	}
	public void setCast(List<String> cast) {
		this.cast = cast;
	}
}
