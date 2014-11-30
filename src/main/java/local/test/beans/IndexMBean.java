package local.test.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class IndexMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;

	public IndexMBean() {
		System.out.println("Constructor called");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Post construct called");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
