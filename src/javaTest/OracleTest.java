package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class OracleTest {
	static Logger logger = LogManager.getLogger("mylog1");
	//static Logger logger = LogManager.getLogger("LogManager.ROOT_LOGGER_NAME");
	public static Connection DBConnection(){
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.15.100:1521:ecom","cime","cime");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args){
		Connection conn = DBConnection();
		ResultSet rs = null;
		String sql = "select * from substation where substation_type = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"变电站");
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd =  rs.getMetaData();
			int cc = rsmd.getColumnCount();
			while(rs.next()){
				String str = "  ";
				for(int i=0;i<cc;i++){
					str = rs.getString(i+1)+str;
				}
				logger.info(str);
			}
			if(rs!=null)     rs.close();
			if(pstmt!=null)  pstmt.close();
			if(conn!=null)   conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
