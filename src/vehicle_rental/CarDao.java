package vehicle_rental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarDao {
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String id = "SCOTT";
	private static String password = "TIGER";
	
	public List<Car> showCarList(){
		List<Car> list = new ArrayList<Car>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, id, password);
			String sql = "select * from carTable";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Car car = new Car();
				car.setNumberPlate(rs.getString("number_plate"));
				car.setModel(rs.getString("model"));
				car.setRentalStatus(rs.getString("rental_status"));
				Date regDate = rs.getDate("registered_date");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sdf.format(regDate);
				car.setRegisteredDate(regDate);
				
				list.add(car);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return list;
	}
	
	
	public void insertCar(Car car) {
		int result;
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection(url, id, password);
			String sql = "insert into carTable values(?, ?, sysdate, ?)"; // number_plate, model, registerd_date,
																			// rental_status
			ps = conn.prepareStatement(sql);
			ps.setString(1, car.getNumberPlate());
			ps.setString(2, car.getModel());
			ps.setString(3, car.getRentalStatus());

			result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("성공적으로 차량등록을 마쳤습니다.");
			} else {
				System.out.println("차량등록에 실패하였습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e2) {
					// TODO: handle exception
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					// TODO: handle exception
				}
			}
		}

	}
	
	

}
