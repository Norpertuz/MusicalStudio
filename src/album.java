
public class album {

	private String nazwa_utworu; //Nazwa_utworu
	private String nazwa_albumu; //Nazwa_albumu
    private String date; //Data
    private String Autor; //Autor
    private String Gatunek; //Gatunek
    private String Opis; //Opis
    private String Image; //Image

    
    
    
    public album(String nazwa_utworu,String nazwa_albumu,String date,String Autor,String Gatunek,String Opis,String Image) {
    	this.nazwa_utworu=nazwa_utworu;
    	this.nazwa_albumu=nazwa_albumu;
    	this.date=date;
    	this.Autor=Autor;
    	this.Gatunek=Gatunek;
    	this.Opis=Opis;
    	this.Image=Image;
    }
    
    public String get_nazwa_albumu() {
    	return nazwa_albumu;
    }
    public String get_nazwa_utworu() {
    	return nazwa_utworu;
    }
    public String get_date() {
    	return date;
    }
    public String get_Autor() {
    	return Autor;
    }
    public String get_Gatunek() {
    	return Gatunek;
    }
    public String get_Opis() {
    	return Opis;
    }
    public String get_Image() {
    	return Image;
    }
    
}
