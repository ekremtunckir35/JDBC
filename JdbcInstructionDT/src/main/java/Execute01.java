import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.ADIM : Veri tabanı sürücü sınıfını kaydetmekle başlayabiliriz.
        //JDBC API hangi veri tabanı sürücüsüyle çalışacağını bilmelidir.
        //Driver veritabanı sunucusu ile olan iletişimi idare eder.

        Class.forName("org.postgresql.Driver");//Java 7 ile birlikte gerek kalmadi.


        // 2.ADIM : Baglantiyi olusturma:db url,kullanici adi,password
        //DriverManager: Veritabanı sürücülerinin bir listesini yönetir.
        // Java uygulamasından gelen bağlantı istekleri ile uygun
        // veritabanı sürücüsünü eşleştirir ve bağlantı oluşturur.

        // Connection: Bu arayüz, bir veritabanı ile iletişim kurmak
        // için tüm yöntemleri içerir. Connection, yani veritabanıyla
        // yapılan tüm iletişim yalnızca bağlantı nesnesi aracılığıyla yapılır.

    Connection connection =DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_dt","techpro","password");

     //3.ADIM : Statement olusturma :SQL iafedelerini veritabanina iletir ve calistirir.

        Statement st =connection.createStatement();
        System.out.println("Success");


        //4.ADIM : Sorguyu olusturma ve calistirma
         /*
        execute:tüm sorguları çalıştırmak için kullanılır
         sorgunun sonucunda ResultSet alınıyorsa TRUE döndürür, aksi halde FALSE döndürür.
         1-DDL(data definition language) -->FALSE
         2-DQL(data query language SELECT komutu) -->TRUE
        genellikle DDL için kullanılır.
         */

        //ÖRNEK 1:"workers" adında bir tablo oluşturup "worker_id,worker_name,salary" sütunlarını ekleyiniz.

        //CREATE TABLE IF NOT EXIST workers(worker_id INT,worker_name VARCHAR(50), salary REAL)
        boolean sql1=st.
                execute("CREATE TABLE IF NOT EXISTS workers(worker_id INT,worker_name VARCHAR(50), salary REAL)");

        System.out.println("sql1: "+sql1);

        //ÖRNEK 2:"workers" tablosuna VARCHAR(20) tipinde "city" sütununu ekleyiniz.
        //tekrar calisinda ayni sutunu eklemeye calisir.Comment e alalim
        //boolean sql2= st.execute("ALTER  TABLE workers ADD COLUMN  city VARCHAR(20)");
        //System.out.println("sql2 = "+ sql2);

        // //ÖRNEK 3:"workers" tablosunu SCHEMAdan siliniz.

        st.execute("DROP TABLE  workers");



        //5.ADIM : Kaynaklari kapatma

        st.close();
        connection.close();













    }
}