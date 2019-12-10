
public class user {

	private String Nickname; //nickname
	private String Fullname; //fullname
    private String Password; //password
    private String Email; //email
    private int IsAdmin; //isAdmin

	
	
	
	public user(String Nickname,String Fullname,String Password,String Email,int IsAdmin) {
    	this.Nickname=Nickname;
    	this.Fullname=Fullname;
    	this.Password=Password;
    	this.Email=Email;
    	this.IsAdmin=IsAdmin;
    }
    
    public String get_Nickname() {
    	return Nickname;
    }
    public String get_Fullname() {
    	return Fullname;
    }
    public String get_Password() {
    	return Password;
    }
    public String get_Email() {
    	return Email;
    }
    public int get_IsAdmin() {
    	return IsAdmin;
    }
    
	
	
}
