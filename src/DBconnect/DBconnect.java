package DBconnect;
import java.sql.*;
public class DBconnect {
    static String url="jdbc:mysql://localhost:3306/test";
    static String user="root";
    static String password="root";
    static Connection conn=null;
    static PreparedStatement ps=null;
    static ResultSet rs=null;
    static Statement st=null;

    //初始化
    public static void init() throws SQLException,ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            System.out.println("初始化失败！");
            e.printStackTrace();
        }
    }
    //执行增删改操作
    public static int addUpdateDelete(String sql) throws SQLException,ClassNotFoundException{
        int i=0;
        try {
                ps=conn.prepareStatement(sql);
                boolean flag= ps.execute();
                if(flag==false){
                    i++;
                }
        }catch (Exception e){
            System.out.println("数据库增删改异常");
            e.printStackTrace();
        }
        return i;
    }
    //执行查询语句
    public static ResultSet selectSql(String sql) {
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
        }catch (Exception e){
            System.out.println("数据库查询异常");
            e.printStackTrace();
        }
        return rs;
    }
    //执行关闭连接操作
    public static void closeConn() throws SQLException{
        try {
            conn.close();
        }catch (Exception e){
            System.out.println("数据库关闭异常");
            e.printStackTrace();
        }
    }
    //执行关闭对象操作
    public static void closeStmt(){
        try {
            st.close();
        }catch (SQLException e){
            System.out.println("对象关闭异常");
            e.printStackTrace();
        }
    }
    //获取数据连接
    public Connection getConn(){
        return this.conn;
    }
}
