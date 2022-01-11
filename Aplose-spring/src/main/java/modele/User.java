package modele;

public class User {
	
	private String firstName;
	private String lastName;
	private String login;
	private String pwd;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String login, String pwd) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.pwd = pwd;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



}
