import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class MySQL_connect {
	private Connection connect = null;// bedzie trzymala nasze polaczenie
	//mozna sie laczyc z wieloma bazami jednoczesnie
private Statement statement = null;
private PreparedStatement preparedStatement = null;
private ResultSet resultSet = null;


///potrzebne sa: adres serwera bazy, uzytkownik oraz haslo
final private String host = "localhost";//localhost wlasny komputer
final private String user = "root";
final private String passwd = "";

public void readDataBase() throws Exception {
try { //blok try trzyma wszystkie operacje niebezpieczne
//np brak bazy danych
// This will load the MySQL driver, each DB has its own driver

//ladujemy sterownik obslugi konkretnej bazy danych
Class.forName("com.mysql.jdbc.Driver");

// laczenie sie do bazy danych
connect = DriverManager
.getConnection("jdbc:mysql://" + host + "/localhost/test?"
+ "user=" + user + "&password=" + passwd );

//getConnection wymaga podania danych logowania i wybrania samej bazy
//odbc to analogiczny sterownik do jezykow typu C++/C#
}catch (Exception e) {
    System.out.println("Blad polaczenia z baza");
  } 


}


}
