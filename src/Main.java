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

    public static void insert????lemi() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = dbHelper.getConnection();//Ba??lant?? a??ma
            statement = connection.prepareStatement
                    ("insert into city (Name,CountryCode,District,Population) values('D??zce2','TUR','Ankara',45000) ");//????mleyi haz??rla
            //value i??indeki de??erler Kullan??c??dan al??n??r genelde,Kullan??c?? taraf??ndan g??nderilir
            // String sql = insert into city (Name,CountryCode,District,Population) values('?','?','?',?) normal de b??yle g??r??r??z buray??
            // ve a??a????daki gibi ilerlereyerek insert i??lemini yapar??z.
            //**************??NEML?????? SORU ????ARETLER?? SIRAYI BEL??RLER**************
            // statement.setString( parametreindex 1, name = "D??zce");
            // statement.setString( parametreindex 2, Countrycode = "TUR");
            // statement.setString( parametreindex 3, District = "Ankara");
            // statement.setInt( parametreindex 4, Population = 45000);
            //As??l kullan??m ??ekli bu dur.
            statement.executeUpdate();//??al????t??rma

            System.out.println("Kay??t eklendi");


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

            // normalde buda parametre olarak al??n??r
            // String sql = "update city set population= 85000 where id = ?";
            //b??yle g??z??k??r ve
            //statement.setInt(parametreindex 1, 85000) olarak yap??l??r
            //**************??NEML?????? SORU ????ARETLER?? SIRAYI BEL??RLER**************

            connection = dbHelper.getConnection();//Ba??lant?? a??ma
            String sql = "update city set population= 85000 where id = 4081";// birden fazla g??ncelleme i??in vilg??l ile ay??r??r??z
            statement = connection.prepareStatement(sql);


            statement.executeUpdate();//??al????t??rma

            System.out.println("Kay??t g??ncellendi");


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

            // normalde buda parametre olarak al??n??r
            // String sql = "delete from city id = ?";
            //b??yle g??z??k??r ve
            //statement.setInt(parametreindex 1, (??ehir id yeri)4081) olarak yap??l??r
            //**************??NEML?????? SORU ????ARETLER?? SIRAYI BEL??RLER**************
            connection = dbHelper.getConnection();//Ba??lant?? a??ma
            String sql = "delete from city id = 4081";// birden fazla g??ncelleme i??in vilg??l ile ay??r??r??z
            statement = connection.prepareStatement(sql);


            statement.executeUpdate();//??al????t??rma

            System.out.println("Kay??t Silindi");


        } catch (SQLException exception) {

            dbHelper.showErrorMessage(exception);

        } finally {
            statement.close();
            connection.close();
        }
    }


}
