package co.jessie.newInterface;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface InterfaceService {
	default void run() { // 인터페이스에서 몸체(구현된 것)를 가질 수 있다.
		System.out.println("인터페이스가 가지고 있는 메소드");
	}

	List<?> allSelect()throws IOException; //인터페이스에서는 IO예외처리 다 써주기.
	Object select(Object o)throws IOException, SQLException;
	int insert(Object o)throws IOException;
	int update(Object o)throws IOException;
	int delete(Object o)throws IOException;
}
