package Model;

public class User {
	public String FirstName;
	public String LastName;
	public String Username;
	public String Password;
	public String Phone;
	public String Email;

	public User(String firstName, String lastName, String username, String passeord, String phone, String email) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Username = username;
		Password = passeord;
		Phone = phone;
		Email = email;
	}

}