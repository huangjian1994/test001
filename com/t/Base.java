package t;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author hj
 * @date 2017-7-18
 * 
 */
public class Base {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	public Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String dbName = "orcl";
		String userName = "xxbz";
		String passWord = "xxbz";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
		try {
	        
			Class.forName(driver);
			System.out.println("开始尝试连接数据库！");
			conn = DriverManager.getConnection(url, userName,
					passWord);
			System.out.println("连接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public PreparedStatement getPreparedStatement(String sql) {
		if(conn == null) {
			conn = getConnection();
		}
		try {
			return conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Entity> getData() {
	
		List<Entity> list = new ArrayList<Entity>();
		String sql = "select * from base_dm";
		PreparedStatement preparedStatement = getPreparedStatement(sql);
		if(preparedStatement == null) {
			return list;
		}
		try {
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				list.add(Entity.getEntityByResult(rs));
			}
			close(rs, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	public static class Entity {
		
		private String id;
		private String DMXZWMC;
		private String DMXLX;
		private String DMXCD;
		
		public static Entity getEntityByResult(ResultSet rs) {
			Entity entity = new Entity();
			Class claz = entity.getClass();
			
			// 这个是获取所有的属性，包括private的
			Field[] fields = claz.getDeclaredFields();
			for(Field field : fields) {
				try {
					// 这个是给属性设置值，基本上只需要用这个，可以，等一下，我去开会
					field.set(entity, rs.getString(field.getName()));
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return entity;
		}

		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getDMXZWMC() {
			return DMXZWMC;
		}

		public void setDMXZWMC(String dMXZWMC) {
			DMXZWMC = dMXZWMC;
		}

		public String getDMXLX() {
			return DMXLX;
		}

		public void setDMXLX(String dMXLX) {
			DMXLX = dMXLX;
		}

		public String getDMXCD() {
			return DMXCD;
		}

		public void setDMXCD(String dMXCD) {
			DMXCD = dMXCD;
		}
		
	}

	

}
