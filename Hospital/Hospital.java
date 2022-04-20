import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Hospital {

    public static Connection getConnection() {
       Connection postGresConn = null;
       try {
         postGresConn = DriverManager.getConnection("jdbc:postgresql://pgsql3.mif/studentu", "aule6352", "[Programmer2570]") ;
       }
       catch (SQLException sqle) {
         System.out.println("Neimanoma prisijungti prie duomenu bazes !");
         sqle.printStackTrace();
         return null ;
       }
       System.out.println("Sekmingai prisijungta prie Postgres duomenu bazes");

       return postGresConn ;
    }

    /********************************************************/
    public static void loadDriver()
    {
       try {
         Class.forName("org.postgresql.Driver");
       }
       catch (ClassNotFoundException cnfe) {
         System.out.println("Couldn't find driver class!");
         cnfe.printStackTrace();
         System.exit(1);
       }
    }
    /********************************************************/
    /********************************************************/
    public static void RodytiGydytojus(Connection postGresConn)
    {
      Statement stmt = null ;
      ResultSet rs = null ;
      try {
        stmt = postGresConn.createStatement();
        rs = stmt.executeQuery("SELECT * from Gydytojas");
         while (rs.next()) 
		 {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getDate(5) + " " + rs.getString(6) + " " + rs.getFloat(7) + " " + rs.getString(8));
         }      
		  }
      catch (SQLException e) {
        System.out.println("SQL klaida! Nepavyko parodyti gydytoju saraso" );
        e.printStackTrace();
      }
      finally {
        try {
          if(null != rs)
            rs.close() ;
          if(null != stmt)
            stmt.close() ;
        }
        catch (SQLException exp) {
          System.out.println("Nenumatyta SQL klaida!");
          exp.printStackTrace();
        }
      }
    }
    public static int IeskotiPagalVarda(String vardas,Connection postGresConn){
      int gydytojukiekis = -1;
      Statement stmt = null ;
      ResultSet rs = null ;
      try {
			stmt = postGresConn.createStatement();
			String sql = "SELECT * from Gydytojas WHERE Vardas = '" + vardas + "'";
			rs = stmt.executeQuery(sql);
         while (rs.next()) 
			{
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
		            } 
	
			stmt = postGresConn.createStatement();
			String sql1 = "SELECT COUNT(*) from Gydytojas WHERE Vardas = '" + vardas + "'";
			rs = stmt.executeQuery(sql1);
			rs.next();
			gydytojukiekis = rs.getInt(1);
     
	}
      catch (SQLException e) {
        System.out.println("SQL klaida! Nepavyko rasti Gydytojo pagal varda");
        e.printStackTrace();
	closeConnection(postGresConn);
	System.exit(0);
      }
      finally {
        try 
		{
          if(null != rs)
            rs.close();
          if(null != stmt)
            stmt.close();
        }
        catch (SQLException exp) {
          System.out.println("SQL klaida. Nepavyko uzdaryti Sql klasiu");
          exp.printStackTrace();
        }
      }
return gydytojukiekis ;
    }

public static int CountPagalId(String id,Connection postGresConn){

	int count = -1;
  Statement stmt = null ;
      ResultSet rs = null ;
      try 
	  {
        stmt = postGresConn.createStatement();
        String sql = "SELECT COUNT(*) from Gydytojas WHERE Nr = '" + id + "'";
        rs = stmt.executeQuery(sql);
         rs.next();
	count = rs.getInt(1);
     
	  }
      catch (SQLException e) {
        System.out.println("SQL klaida! Nepavyko rasti gydytojo pagal Nr");
        e.printStackTrace();
	closeConnection(postGresConn);
	System.exit(0);

      }
      finally {
        try 
		{
          if(null != rs)
            rs.close() ;
          if(null != stmt)
            stmt.close() ;
        }
        catch (SQLException exp) {
          System.out.println("SQL klaida! Nepavyko uzdaryti sql klasiu");
          exp.printStackTrace();
        }
      }
return count;


}

 public static void IeskotiPagalId(String id,Connection postGresConn){
      
	  Statement stmt = null ;
      ResultSet rs = null ;
      try 
	  {
        stmt = postGresConn.createStatement();
        String sql = "SELECT * from Gydytojas WHERE Nr = '" + id + "'";
        rs = stmt.executeQuery(sql);
         while (rs.next()) 
		 {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getDate(5) + " " + rs.getString(6) + " " + rs.getFloat(7) + " " +rs.getString(8));
         }      
	  }
      catch (SQLException e) {
        System.out.println("SQL klaida! Nepavyko rasti gydytojo pagal Nr");
        e.printStackTrace();
	closeConnection(postGresConn);
	System.exit(0);

      }
      finally {
        try 
		{
          if(null != rs)
            rs.close() ;
          if(null != stmt)
            stmt.close() ;
        }
        catch (SQLException exp) {
          System.out.println("SQL klaida! Nepavyko uzdaryti sql klasiu");
          exp.printStackTrace();
        }
      }
    }

 public static int GetId(String id,Connection postGresConn){
      int ID = -1;
	  Statement stmt = null ;
      ResultSet rs = null ;
      try 
	  {
        stmt = postGresConn.createStatement();
        String sql = "SELECT Nr from Gydytojas WHERE Nr = '" + id + "'";
        rs = stmt.executeQuery(sql);
         rs.next();
	ID = rs.getInt(1);
     
	  }
      catch (SQLException e) {
        System.out.println("SQL klaida! Nepavyko rasti gydytojo pagal Nr");
        e.printStackTrace();
	closeConnection(postGresConn);
	System.exit(0);

      }
      finally {
        try 
		{
          if(null != rs)
            rs.close() ;
          if(null != stmt)
            stmt.close() ;
        }
        catch (SQLException exp) {
          System.out.println("SQL klaida! Nepavyko uzdaryti sql klasiu");
          exp.printStackTrace();
        }
      }
return ID;
    }



 public static void RodytiPacientuSarasa(Connection postGresConn)
{
      Statement stmt = null ;
      ResultSet rs = null ;
      try 
	{
        stmt = postGresConn.createStatement();
        rs = stmt.executeQuery("SELECT * from Pacientas");
         while (rs.next()) 
		 {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getInt(6) + " " + rs.getString(7) + " " + rs.getDate(8) + " "  + rs.getString(9));
         }      
	}
      catch (SQLException e) {
        System.out.println("SQL klaida! Neimanoma parodyti Pacientu saraso");
        e.printStackTrace();
	closeConnection(postGresConn);
	System.exit(0);

      }
      finally {
        try {
          if(null != rs)
            rs.close() ;
          if(null != stmt)
            stmt.close() ;
        }
        catch (SQLException exp) {
          System.out.println("Nenumatyta SQL klaida!");
          exp.printStackTrace();
        }
      }
    }

public static void PacientoLigosIrasas(String ID, Connection postGresConn)
{
      Statement stmt = null ;
      ResultSet rs = null ;
      try
	  {
        stmt = postGresConn.createStatement();
        rs = stmt.executeQuery("SELECT * from" + "\"Medicininis irasas\"" + " WHERE " +  "\"Paciento Nr\"" + " = " +" '" + ID  + "'");
         while (rs.next()) 
		 {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDate(3) + " " + rs.getString(4));
         }      
	  }
      catch (SQLException e) {
        System.out.println("SQL klaida! Neimanoma rasti paciento ligu saraso");
        e.printStackTrace();
      }
      finally {
        try {
          if(null != rs)
            rs.close() ;
          if(null != stmt)
            stmt.close() ;
        }
        catch (SQLException exp) {
          System.out.println("Nenumatyta SQL klaida!");
          exp.printStackTrace();
        }
      }
    }

public static void LigosIdejimas(String paciento_id, String id, String liga, Connection postGresConn)
{
      Statement stmt = null ;
      ResultSet rs = null ;
      try {
        stmt = postGresConn.createStatement();
        String sql = "INSERT INTO" + "\"Medicininis irasas\"" + "(Nr, Liga," +"\"Paciento Nr\"" + ")" + "VALUES (" + "'" + id +"'," +"'" + liga +"'," + "'" + paciento_id +"')";
        stmt.executeUpdate(sql);
		System.out.println("Liga sekmingai irasyta i ligos istorija");
    }
      catch (SQLException e) {
        System.out.println("SQL klaida! Ligos irasyti i ligos istorija nepavyko");
        e.printStackTrace();
		closeConnection(postGresConn);
	System.exit(0);

      }
      finally {
        try {
          if(null != rs)
            rs.close() ;
          if(null != stmt)
            stmt.close() ;
        }
        catch (SQLException exp) {
          System.out.println("Nenumatyta SQL klaida!");
          exp.printStackTrace();
        }
      }
    }

public static void RodytiMedicininisIrasas(Connection postGresConn)
{
      Statement stmt = null ;
      ResultSet rs = null ;
      try 
	  {
        stmt = postGresConn.createStatement();
        rs = stmt.executeQuery("SELECT * from" + "\"Medicininis irasas\"");
         while (rs.next()) 
		 {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDate(3) + " " + rs.getInt(4));
         }      
	  }
      catch (SQLException e) {
        System.out.println("SQL klaida! Neimanoma parodyt Ligu saraso ");
        e.printStackTrace();
      }
      finally {
        try {
          if(null != rs)
            rs.close() ;
          if(null != stmt)
            stmt.close() ;
        }
        catch (SQLException exp) {
          System.out.println("Nenumatyta SQL klaida!");
          exp.printStackTrace();
        }
      }
    }
public static void RodytiLigonine(Connection postGresConn)
{
      Statement stmt = null ;
      ResultSet rs = null ;
      try 
	  {
        stmt = postGresConn.createStatement();
        rs = stmt.executeQuery("SELECT * from Ligonine");
         while (rs.next()) 
		 {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
         }      
	  }
      catch (SQLException e) {
        System.out.println("SQL klaida! Nepavyko parodyti irasu is lenteles Ligonine");
        e.printStackTrace();
      }
      finally {
        try {
          if(null != rs)
            rs.close() ;
          if(null != stmt)
            stmt.close() ;
        }
        catch (SQLException exp) {
          System.out.println("SQL klaida! Nepavyko uzdaryti klasiu");
          exp.printStackTrace();
        }
      }
    }

public static void DarboVietosAtnaujinimas(String gydNr, String buvusidarboviete, String naujadarboviete, Connection postGresConn)
{
      Statement stmt = null ;
      ResultSet rs = null ;
      try {
         stmt = postGresConn.createStatement();
        String sql = "UPDATE " + "\"Gydytojo Ligonine\""  +  "SET " + "\"Registracijos Nr\"" + " = '" + naujadarboviete + "'"  + "WHERE " +  "\"Gydytojo Nr\"" + " = '" +  gydNr + "'" + "AND " + "\"Registracijos Nr\""  + " = " + "'" + buvusidarboviete + "'";
        stmt.executeUpdate(sql);
		System.out.println("Nauja darbo vieta atnaujinta ");
     }
      catch (SQLException e) {
        System.out.println("SQL klaida! Nepavyko atnaujinti gydytojo darbo vietos");
        e.printStackTrace();
	closeConnection(postGresConn);
	System.exit(0);

      }
      finally {
        try {
          if(null != rs)
            rs.close() ;
          if(null != stmt)
            stmt.close() ;
        }
        catch (SQLException exp) {
          System.out.println("Nenumatyta SQL klaida!");
          exp.printStackTrace();
        }
      }
    }
public static void RodytiGydytojoLigonine(Connection postGresConn)
{
      Statement stmt = null ;
      ResultSet rs = null ;
      try {
        stmt = postGresConn.createStatement();
        rs = stmt.executeQuery("SELECT * from " + "\"Gydytojo Ligonine\"");
         while (rs.next()) 
		 {
                System.out.println(rs.getInt(1) + " " + rs.getInt(2));
         }      
		   }
      catch (SQLException e) {
        System.out.println("SQL klaida! Neimanoma parodyti Gydytojo sasaju su ligonine");
        e.printStackTrace();
      }
      finally {
        try {
          if(null != rs)
            rs.close() ;
          if(null != stmt)
            stmt.close() ;
        }
        catch (SQLException exp) {
          System.out.println("Nenumatyta SQL klaida!");
          exp.printStackTrace();
        }
      }
    }
public static void PacientoIsrasymas(String pacientoNr, String LigoninesNr, Connection postGresConn)
{
      Statement stmt = null ;
      ResultSet rs = null ;
      try {
        stmt = postGresConn.createStatement();
        String sql = "DELETE FROM " + "\"Paciento Ligonine\""  +  "WHERE " +  "\"Paciento Nr\"" + " = '" +  pacientoNr + "'" + "AND " + "\"Registracijos Nr\""  + " = " + "'" + LigoninesNr+ "';";
        stmt.executeUpdate(sql);
		System.out.println("Pacientas israsytas is ligonines");
     }
      catch (SQLException e) {
        System.out.println("SQL klaida! Paciento nepavyko isregistruoti");
        e.printStackTrace();
		closeConnection(postGresConn);
	System.exit(0);

      }
      finally {
        try {
          if(null != rs)
            rs.close() ;
          if(null != stmt)
            stmt.close() ;
        }
        catch (SQLException exp) {
          System.out.println("Nenumatyta SQL klaida!");
          exp.printStackTrace();
        }
      }
    }
public static void RodytiPacientoLigonine(Connection postGresConn)
{
      Statement stmt = null ;
      ResultSet rs = null ;
      try 
	{
        stmt = postGresConn.createStatement();
        rs = stmt.executeQuery("SELECT * from " + "\"Paciento Ligonine\"");
         while (rs.next()) 
		 {
                System.out.println(rs.getInt(1) + " " + rs.getInt(2));
         }      
	}
      catch (SQLException e) {
        System.out.println("SQL klaida! Neimanoma parodyti Paciento sasaju su ligonine");
        e.printStackTrace();
	closeConnection(postGresConn);
	System.exit(0);

      }
      finally {
        try {
          if(null != rs)
            rs.close() ;
          if(null != stmt)
            stmt.close() ;
        }
        catch (SQLException exp) {
          System.out.println("Nenumatyta SQL klaida!");
          exp.printStackTrace();
        }
      }
    }


public static void RodytiLigonineBYNR(String id, Connection postGresConn)
{
      Statement stmt = null ;
      ResultSet rs = null ;
      try 
	  {
        stmt = postGresConn.createStatement();
        rs = stmt.executeQuery("SELECT Nr, Pavadinimas, Adresas from Ligonine, " + "\"Paciento Ligonine\"" + " WHERE " + "\"Paciento Nr\"" + " = " + "'" + id + "'" + " AND " + "\"Registracijos Nr\"" + " = Nr ");
         while (rs.next()) 
		 {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
         }      
	  }
      catch (SQLException e) {
        System.out.println("SQL klaida! Nepavyko parodyti irasu is lenteles Ligonine");
        e.printStackTrace();
      }
      finally {
        try {
          if(null != rs)
            rs.close() ;
          if(null != stmt)
            stmt.close() ;
        }
        catch (SQLException exp) {
          System.out.println("SQL klaida! Nepavyko uzdaryti klasiu");
          exp.printStackTrace();
        }
      }
    }
public static void  PacientoIdejimas(String vardas, String pavarde, String AK, String gatve, String namas, String butas, String data, String telefono_nr, String ligoninesID,Connection postGresConn){

      Statement stmt = null ;
      ResultSet rs = null ;
      try {
	// *****************************
	postGresConn.setAutoCommit(false);
        stmt = postGresConn.createStatement();
        String sql = "INSERT INTO Pacientas " + "(Vardas, Pavarde, AK, Gatve, Namas, Butas," + "\"Gimimo data\"" + "," +"\"Telefono Nr\"" + ")" + "VALUES (" + "'" + vardas +"'," +"'" + pavarde +"'," + "'" + AK +"'," + "'" + gatve +"'," + "'" + namas +"',"  + "'" + butas +"',"  + "'" + data +"'," +"'" + telefono_nr +"');";
        stmt.executeUpdate(sql);
	
	// ************
	String sentence = "SELECT Nr FROM Pacientas WHERE Vardas = " + "'" + vardas + "'" + "AND Pavarde = " +  "'" + pavarde + "'" + "AND AK = " +  "'" + AK + "'" + "AND Gatve = " +  "'" + gatve + "'" + "AND Namas = " +  "'" + namas + "'" + "AND Butas = " +  "'" + butas  + "'" + "AND " + "\"Gimimo data\"" + " = " +  "'" + data + "'" +  "AND " + "\"Telefono Nr\"" + " = " +  "'" + telefono_nr + "'"; //prideti daugiau parametru
        stmt = postGresConn.createStatement();
        String sql1 = "INSERT INTO" + "\"Paciento Ligonine\"" + " (" +"\"Paciento Nr\"" + " , "  + "\"Registracijos Nr\"" + ")" + " VALUES (" + " (" +sentence + ") "  + " , "  +"'" + ligoninesID + "'" + ");";
        stmt.executeUpdate(sql1);
		
	System.out.println("Pacientas yra uzregistruotas");
	postGresConn.commit();
	
    }
      catch (SQLException e) {
	try {
		System.out.println("SQL klaida su duomenu ivedimu");
		
       	e.printStackTrace();
		postGresConn.rollback();
	

	}
	catch (SQLException ex) {
        ex.printStackTrace();
	

	}
	closeConnection(postGresConn);
	System.exit(0);
	
      }
      finally {
		
        try {
	postGresConn.setAutoCommit(true);
          if(null != rs)
            rs.close() ;
          if(null != stmt)
            stmt.close() ;
        }
        catch (SQLException exp) {
          System.out.println("Nenumatyta SQL klaida!");
          exp.printStackTrace();
        }
      }
    }

public static void Rodytiligoninebygydytojas(String id, Connection postGresConn)
{
      Statement stmt = null ;
      ResultSet rs = null ;
      try 
	  {
        stmt = postGresConn.createStatement();
        rs = stmt.executeQuery("SELECT Nr, Pavadinimas, Adresas from Ligonine, " + "\"Gydytojo Ligonine\"" + " WHERE " + "\"Gydytojo Nr\"" + " = " + "'" + id + "'" + " AND " + "\"Registracijos Nr\"" + " = Nr ");
         while (rs.next()) 
		 {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
         }      
	  }
      catch (SQLException e) {
        System.out.println("SQL klaida! Nepavyko parodyti irasu is lenteles Ligonine");
        e.printStackTrace();
      }
      finally {
        try {
          if(null != rs)
            rs.close() ;
          if(null != stmt)
            stmt.close() ;
        }
        catch (SQLException exp) {
          System.out.println("SQL klaida! Nepavyko uzdaryti klasiu");
          exp.printStackTrace();
        }
      }
    }

public static int PacientoLiguKiekis(String ID, Connection postGresConn)
{
      int pacientoligos = -1;
      Statement stmt = null ;
      ResultSet rs = null ;
      try
	  {
        stmt = postGresConn.createStatement();
        rs = stmt.executeQuery("SELECT COUNT(*) from" + "\"Medicininis irasas\"" + " WHERE " +  "\"Paciento Nr\"" + " = " +" '" + ID  + "'");
	rs.next();
	pacientoligos  = rs.getInt(1);      
	  }
      catch (SQLException e) {
        System.out.println("SQL klaida! Neimanoma rasti paciento ligu saraso");
        e.printStackTrace();
      }
      finally {
        try {
          if(null != rs)
            rs.close() ;
          if(null != stmt)
            stmt.close() ;
        }
        catch (SQLException exp) {
          System.out.println("Nenumatyta SQL klaida!");
          exp.printStackTrace();
        }
      }
	return pacientoligos;
    }



public static void Gydytojas(Connection postGresConn, int pirmas, int antras, int trecias, int ketvirtas, int penktas, int sestas)
{
	System.out.println("Jus esate prisijunges kaip gydytojas");
    	System.out.println("Iveskite savo varda:");
    	String vardas  = System.console().readLine();
	int gydytojukiekis = IeskotiPagalVarda(vardas,postGresConn);
	if(gydytojukiekis > 0){
	System.out.println("Pasirinkite kuris gydytojas esate (id)");
	String id  = System.console().readLine();
	if(CountPagalId(id,postGresConn) > 0){
		System.out.println("Jus esate prisijunges kaip gydytojas: ");
		IeskotiPagalId(id,postGresConn);
		System.out.println();
		GydytojoFunkcijos(id,pirmas, antras, trecias, ketvirtas, penktas,sestas, postGresConn);
	}
	else {
		System.out.println("Gydytojo su tokiu ID nera ");        
		closeConnection(postGresConn);

		}
	}
	else {
		System.out.println("Tokio gydytojo nera ");        
		closeConnection(postGresConn);
	}
	

}

public  static void GydytojoFunkcijos(String id,int pirmas, int antras, int trecias, int ketvirtas, int penktas,int sestas, Connection postGresConn)
{
	System.out.println("Gydytojo funkcijos:");
	System.out.println(pirmas+ ". Uzregistruoti nauja pacienta");
	System.out.println(antras+ ". Paziureti konkretaus paciento ligos istorija");
	System.out.println(trecias+ ". Pacientui diagnozuoti nauja liga");
	System.out.println(ketvirtas + ". Keisti savo darbo vieta");   
	System.out.println(penktas + ". Israsyti pacienta is ligonines");
	System.out.println(sestas +  " . Iseiti? "); 
	String pasirinkimas  = System.console().readLine();
	switch(pasirinkimas)
	{
	case "1":
	PacientoRegistravimas(id,pirmas,antras,trecias,ketvirtas,penktas,sestas,postGresConn);
	break;

	case "2":
	PacientoLigosIstorija(id,pirmas,antras,trecias,ketvirtas,penktas,sestas,postGresConn);
	break;

	case "3":
	NaujaDiagnoze(id,pirmas,antras,trecias,ketvirtas,penktas,sestas,postGresConn);
	break;

	case "4":
	NaujaDarboviete(id,pirmas,antras,trecias,ketvirtas,penktas,sestas,postGresConn);
	break;

	case "5":
	PacientoIsregistravimas(id,pirmas,antras,trecias,ketvirtas,penktas,sestas,postGresConn);
	break;

	case "6":
	Exit(id,pirmas,antras,trecias,ketvirtas,penktas,sestas, postGresConn);
	break;

	}
}


public static void PacientoIsregistravimas(String id,int pirmas, int antras, int trecias, int ketvirtas, int penktas, int sestas, Connection postGresConn)
{
		RodytiPacientuSarasa(postGresConn);
		System.out.println("Pasirinkite kuris pacientas pasveiko (Nr) :  ");	
		String pacientoID  = System.console().readLine();
		RodytiLigonineBYNR(pacientoID,postGresConn);
		System.out.println("Pasirinkite is kurios ligonines pacientas yra israsomas (Nr) : ");
		String ligoninesID  = System.console().readLine();
		PacientoIsrasymas(pacientoID, ligoninesID, postGresConn);
		RodytiPacientoLigonine(postGresConn);
		GydytojoFunkcijos(id,pirmas, antras, trecias, ketvirtas, penktas,sestas, postGresConn);

}

public static void NaujaDiagnoze (String ID,int pirmas, int antras, int trecias, int ketvirtas, int penktas, int sestas, Connection postGresConn)
{
		RodytiPacientuSarasa(postGresConn);
		System.out.println("Pasirinkite kuriam pacientui yra diagnozuota liga: (Nr)");
		String pacientoId  = System.console().readLine();
		RodytiMedicininisIrasas(postGresConn);
		System.out.println("Iveskite nauja ligos id");
		String id  = System.console().readLine();
		System.out.println("Iveskite liga:");
		String liga  = System.console().readLine();
		LigosIdejimas(pacientoId,id,liga, postGresConn);
		RodytiMedicininisIrasas(postGresConn);
		GydytojoFunkcijos(ID,pirmas, antras, trecias, ketvirtas, penktas,sestas, postGresConn);
		//Exit(pirmas,antras,trecias,ketvirtas,penktas,sestas, postGresConn);

}

public static void NaujaDarboviete(String id,int pirmas, int antras, int trecias, int ketvirtas, int penktas, int sestas,Connection postGresConn)
{
		Rodytiligoninebygydytojas(id,postGresConn);
		System.out.println("Pasirinkite buvusia darbo vieta: ");
		String buvusidarboviete  = System.console().readLine();
		RodytiLigonine(postGresConn);
		System.out.println("Nauja darbo vieta: ");                
		String naujadarboviete  = System.console().readLine();
		DarboVietosAtnaujinimas(id,buvusidarboviete,naujadarboviete , postGresConn);
		RodytiGydytojoLigonine(postGresConn);
		GydytojoFunkcijos(id,pirmas, antras, trecias, ketvirtas, penktas,sestas, postGresConn);


}


public static void PacientoRegistravimas(String ID,int pirmas, int antras, int trecias, int ketvirtas, int penktas, int sestas, Connection postGresConn)
{
	System.out.println("Iveskite paciento duomenis:");
	System.out.println("Iveskite varda:");
	String vardas  = System.console().readLine();
	System.out.println("Iveskite pavarde:");
    String pavarde  = System.console().readLine();
	System.out.println("Iveskite asmens koda:");
    String AK  = System.console().readLine();
	System.out.println("Iveskite gatve:");
    String gatve  = System.console().readLine();
	System.out.println("Iveskite nama:");
    String namas  = System.console().readLine();
    System.out.println("Iveskite buta:");
    String butas  = System.console().readLine();
	System.out.println("Iveskite gimimo data:");
    String data  = System.console().readLine();
	System.out.println("Iveskite telefono numeri:");
    String telefono_nr  = System.console().readLine();
	System.out.println("Pasirinkite kurioje ligonineje pacientas bus gydomas: ");  
	RodytiLigonine(postGresConn);
	String ligoninesID  = System.console().readLine();
	
	PacientoIdejimas(vardas,pavarde,AK,gatve,namas,butas,data,telefono_nr,ligoninesID,postGresConn);
	RodytiPacientuSarasa(postGresConn);
	RodytiPacientoLigonine(postGresConn);
    	GydytojoFunkcijos(ID,pirmas, antras, trecias, ketvirtas, penktas,sestas, postGresConn);
	
	
	
}

public static void Exit(String ID, int pirmas, int antras, int trecias, int ketvirtas, int penktas, int sestas,Connection postGresConn)
{
	System.out.println("Ar norite baigti darba?");
	System.out.println("Taip");
	System.out.println("Ne");
	String exit  = System.console().readLine();
	switch(exit)
	{
		case "Taip":
		closeConnection(postGresConn);
		break;
		
		case "taip":
		closeConnection(postGresConn);
		break;
		
		case "Ne":
		GydytojoFunkcijos(ID,pirmas,antras,trecias,ketvirtas,penktas,sestas, postGresConn);
		break;
		
		case "ne":
		GydytojoFunkcijos(ID,pirmas,antras,trecias,ketvirtas,penktas, sestas, postGresConn);
		break;
	}

}


public static void PacientoLigosIstorija(String ID,int pirmas, int antras, int trecias, int ketvirtas, int penktas, int sestas,Connection postGresConn)
{
		RodytiPacientuSarasa(postGresConn);
		System.out.println("Pasirinkite kurio paciento ligos istorija norite pamatyti: (Nr)");
		String pacientoNr  = System.console().readLine();
		if (PacientoLiguKiekis(pacientoNr, postGresConn) > 0)
		{
			PacientoLigosIrasas(pacientoNr, postGresConn);
		}
		else
		{
			System.out.println("Neimanoma parodyti paciento ligos irasu");
		}
		GydytojoFunkcijos(ID,pirmas,antras,trecias,ketvirtas,penktas,sestas, postGresConn);

}
public static void closeConnection(Connection postGresConn)
{
	if( null != postGresConn) {
	try 
	{
          System.out.println("Closed connection!");
          postGresConn.close() ;

        }
        catch (SQLException exp) 
	{
          System.out.println("Can not close connection!");
          exp.printStackTrace();

        }
}

}

    /********************************************************/
    public static void main(String[] args)
    {
      int pirmas = 1, antras = 2, trecias = 3, ketvirtas = 4, penktas = 5, sestas = 6;
      loadDriver() ;
      Connection con = getConnection() ;
      System.out.println("Sveiki atvyke i ligonines informacine sistema");
      Gydytojas(con,pirmas,antras,trecias,ketvirtas,penktas,sestas);  
    }
    /********************************************************/
}
