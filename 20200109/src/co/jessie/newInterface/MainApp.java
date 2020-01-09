package co.jessie.newInterface;

import java.sql.SQLException;

public class MainApp {

	public static void main(String[] args) {
		InterfaceServiceImpl service = new InterfaceServiceImpl();
		CountryDto dto = new CountryDto();
		try {
			dto = (CountryDto) service.select("CA"); // service.select리턴타입이 object타입이지만 dto와 타입을 맞추기위해 형변환
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.print(dto.getCountry_id() + " ");
		System.out.print(dto.getCountry_name() + " ");
		System.out.print(dto.getRegion_id() + " ");

	}

}
