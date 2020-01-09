package co.jessie.countries;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		List<CountryDto> list = new ArrayList<CountryDto>();
		CountryDto dto = new CountryDto();
		CountryServiceImpl country = new CountryServiceImpl();
		list = country.allSelect();
		toPrint(list);
//		searchSelect();
//		counInsert();
//		list = country.allSelect();
//		toPrint(list);
		counUpdate();
		list = country.allSelect();
		toPrint(list);
//		counDelete();
//		list = country.allSelect();
//		toPrint(list);
	}

	public static void toPrint(List<CountryDto> list) { // static 붙이면 stack에올라간다.
		for (CountryDto dto : list) {
			System.out.print(dto.getCountry_id() + " : ");
			System.out.print(dto.getCountry_name() + " : ");
			System.out.println(dto.getRegion_id());
		}
	}

	public static void searchSelect() {
		CountryServiceImpl country = new CountryServiceImpl();
		CountryDto dto = new CountryDto();
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 나라 키워드(ID)를 입력하세요.");
		String key = sc.nextLine();
		try {
			dto = country.select(key);
			System.out.println(dto.getCountry_id() + " : " +dto.getCountry_name() + " : " + dto.getRegion_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}

	public static void counInsert() {
		CountryServiceImpl country = new CountryServiceImpl();
		CountryDto dto = new CountryDto();
		dto.setCountry_id("AU");
		dto.setCountry_name("Austrailia");
		dto.setRegion_id(4);
		try {
			int n = country.insert(dto);
			if (n != 0)
				System.out.println("정상적으로 입력되었습니다.");
			else
				System.out.println("입력되지 않았습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void counUpdate() {
		CountryServiceImpl country = new CountryServiceImpl();
		CountryDto dto = new CountryDto();
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 나라 키워드(ID)를 입력하세요.");
		String key = sc.nextLine();
		try {
			dto = country.select(key);
			System.out.println(dto.getCountry_id() + " : " +dto.getCountry_name() + " : " + dto.getRegion_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("업데이트 할 나라키워드(ID)를 입력하세요.");
		dto.setCountry_id(sc.nextLine());
		System.out.println("업데이트 할 나라 이름을 입력하세요.");
		dto.setCountry_name(sc.nextLine());
		System.out.println("업데이트 할 나라 지역 ID를 입력하세요.");
		dto.setRegion_id(sc.nextInt());
		try {
			int n = country.update(dto);
			if (n != 0)
				System.out.println("정상적으로 업데이트 되었습니다.");
			else
				System.out.println("업데이트에 실패하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}

	public static void counDelete() {
		CountryServiceImpl country = new CountryServiceImpl();
		CountryDto dto = new CountryDto();
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제 할 나라 키워드(ID)를 입력하세요.");
		dto.setCountry_id(sc.nextLine());
		try {
			int n = country.delete(dto);
			if (n != 0)
				System.out.println("정상적으로 삭제 되었습니다.");
			else
				System.out.println("삭제 되지 않았습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
