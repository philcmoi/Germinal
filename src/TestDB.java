import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 public  class TestDB {

    public  static  void main (String[] args) {
       try {
          // chargement de la classe par son nom
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         Driver pilote = (Driver)c.newInstance() ;
          // enregistrement du pilote aupr�s du DriverManager
         DriverManager.registerDriver(pilote);
          // Protocole de connexion
         String protocole =  "jdbc:mysql:" ;
          // Adresse IP de l�h�te de la base et port
         String ip =  "localhost" ;  // d�pend du contexte
         String port =  "3306" ;  // port MySQL par d�faut
          // Nom de la base ;
         String nomBase =  "germinal" ;  // d�pend du contexte
          // Cha�ne de connexion
         String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "root" ;  // d�pend du contexte
         String motDePasse =  "L099339RWFH" ;  // d�pend du contexte
          // Connexion
         Connection con = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;

          // Envoi d�un requ�te g�n�rique
         String sql =  "select pseudo from membre" ;
         Statement smt = con.createStatement() ;
         ResultSet rs = smt.executeQuery(sql) ;
          while (rs.next()) {
            System.out.println(rs.getString("pseudo")) ;
         }
      }  catch (Exception e) {
          // gestion des exceptions
      }
   }
}