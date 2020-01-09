package co.jessie.newInterface;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class InterfaceServiceImpl implements InterfaceService {
	public PreparedStatement psmt;
	public ResultSet rs;
	
	private String SELECT = "select * from countries where country_id = ?";
	@Override
	public List<?> allSelect() throws IOException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object select(Object o) throws SQLException {
		CountryDao dao = new CountryDao();
		CountryDto dto = new CountryDto();
		psmt = dao.conn.prepareStatement(SELECT);
		psmt.setString(1, (String) o); //강제 형변환
		rs = psmt.executeQuery();
		if(rs.next()) {
			dto.setCountry_id(rs.getString("country_id"));
			dto.setCountry_name(rs.getString("country_name"));
			dto.setRegion_id(rs.getInt("region_id"));
		}
		
		return dto;
		
	}

	@Override
	public int insert(Object o)throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Object o) throws IOException{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object o) throws IOException{
		// TODO Auto-generated method stub
		return 0;
	}

}
