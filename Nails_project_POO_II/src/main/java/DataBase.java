import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
    public Connection getConnection() {
        Connection conexao = null; //declarando a variavel que receberah a conexao com o mysql.
        try{
            //Carregando o driver jdbc do mysql
            Class.forName("com.mysql.jdbc.Driver"); //este driver estah como dependencia no arquivo pom.xml

            //abrindo a conexao propriamente dita
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/POO2BDTI","root","aluno123");
        }catch(Exception e){
            System.out.println(e);
        }
        return conexao;
    }

    public static void main(String[] args) {
        Connection c = new DataBase().getConnection();
        System.out.println(c);
    }
}
