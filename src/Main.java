import java.sql.*;
import java.util.ArrayList;
import org.json.*;
public class Main {

    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {

            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select Code,Name,Continent,Region from country ");
            ArrayList<Country> countries = new ArrayList<Country>();
            while (resultSet.next()) {
                countries.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region")));
            }


        } catch (SQLException exception) {

            dbHelper.showErrorMessage(exception);


        } finally {
            statement.close();
            connection.close();
        }


    }

    public static void selectDemo() throws SQLException {

        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {

            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select Code,Name,Continent,Region from country ");
            ArrayList<Country> countries = new ArrayList<Country>();
            while (resultSet.next()) {
                countries.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region")));
            }


        } catch (SQLException exception) {

            dbHelper.showErrorMessage(exception);


        } finally {
            statement.close();
            connection.close();
        }

    }

    public static void insertİşlemi() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = dbHelper.getConnection();//Bağlantı açma
            statement = connection.prepareStatement
                    ("insert into city (Name,CountryCode,District,Population) values('Düzce2','TUR','Ankara',45000) ");//Çümleyi hazırla
            //value içindeki değerler Kullanıcıdan alınır genelde,Kullanıcı tarafından gönderilir
            // String sql = insert into city (Name,CountryCode,District,Population) values('?','?','?',?) normal de böyle görürüz burayı
            // ve aşağıdaki gibi ilerlereyerek insert işlemini yaparız.
            //**************ÖNEMLİİİ SORU İŞARETLERİ SIRAYI BELİRLER**************
            // statement.setString( parametreindex 1, name = "Düzce");
            // statement.setString( parametreindex 2, Countrycode = "TUR");
            // statement.setString( parametreindex 3, District = "Ankara");
            // statement.setInt( parametreindex 4, Population = 45000);
            //Asıl kullanım şekli bu dur.
            statement.executeUpdate();//Çalıştırma

            System.out.println("Kayıt eklendi");


        } catch (SQLException exception) {

            dbHelper.showErrorMessage(exception);

        } finally {
            statement.close();
            connection.close();
        }
    }

    public static void UPDATE() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {

            // normalde buda parametre olarak alınır
            // String sql = "update city set population= 85000 where id = ?";
            //böyle gözükür ve
            //statement.setInt(parametreindex 1, 85000) olarak yapılır
            //**************ÖNEMLİİİ SORU İŞARETLERİ SIRAYI BELİRLER**************

            connection = dbHelper.getConnection();//Bağlantı açma
            String sql = "update city set population= 85000 where id = 4081";// birden fazla güncelleme için vilgül ile ayırırız
            statement = connection.prepareStatement(sql);


            statement.executeUpdate();//Çalıştırma

            System.out.println("Kayıt güncellendi");


        } catch (SQLException exception) {

            dbHelper.showErrorMessage(exception);

        } finally {
            statement.close();
            connection.close();
        }
    }

    public static void DELETE() throws SQLException {

        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {

            // normalde buda parametre olarak alınır
            // String sql = "delete from city id = ?";
            //böyle gözükür ve
            //statement.setInt(parametreindex 1, (şehir id yeri)4081) olarak yapılır
            //**************ÖNEMLİİİ SORU İŞARETLERİ SIRAYI BELİRLER**************
            connection = dbHelper.getConnection();//Bağlantı açma
            String sql = "delete from city id = 4081";// birden fazla güncelleme için vilgül ile ayırırız
            statement = connection.prepareStatement(sql);


            statement.executeUpdate();//Çalıştırma

            System.out.println("Kayıt Silindi");


        } catch (SQLException exception) {

            dbHelper.showErrorMessage(exception);

        } finally {
            statement.close();
            connection.close();
        }
    }


}
