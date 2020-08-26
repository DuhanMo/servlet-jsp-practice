package com.kh.ajax.model.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserListUtil {
	// 팩토리 디자인 패턴
	// 여러 클래스에서 특정 객체를 사용하고자 할때
	// 해당 객체에 대한 기본 설정들을 미리 맞춰놓고 
	// 제공하는 코딩 디자인 설계 방
	private List<UserVo> list;
	private HashMap<String, UserVo> map;
	private static UserListUtil instance;
	
	private UserListUtil() { }
	
	public static UserListUtil getInstance() {
		if(instance == null) {
			instance = new UserListUtil();
		} 
		
		return instance;
	}
	
	public List<UserVo> getUserList() {
		list = new ArrayList<UserVo>();
		
		UserVo user1 = new UserVo(1, "박보검", "남", "010-3333-1004");
		UserVo user2 = new UserVo(2, "송중기", "남", "010-1111-2222");
		UserVo user3 = new UserVo(3, "송영민", "남", "010-9189-9817");
		UserVo user4 = new UserVo(4, "이한솔", "남", "010-4938-0982");
		UserVo user5 = new UserVo(5, "홍석준", "남", "010-4763-3054");
		UserVo user6 = new UserVo(6, "송효근", "남", "010-4149-4719");
		UserVo user7 = new UserVo(7, "강원석", "남", "010-2361-0915");
		UserVo user8 = new UserVo(8, "홍정호", "남", "010-6565-4109");
		UserVo user9 = new UserVo(9, "배수지", "여", "010-1234-1234");
		UserVo user10 = new UserVo(10, "오재원", "남", "010-4444-0123");
		
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		list.add(user5);
		list.add(user6);
		list.add(user7);
		list.add(user8);
		list.add(user9);
		list.add(user10);
		
		return list;
	}
	
	public HashMap<String, UserVo> getUserMap(){
		map = new HashMap<String, UserVo>();
		
		UserVo user1 = new UserVo(1, "박보검", "남", "010-3333-1004");
		UserVo user2 = new UserVo(2, "송중기", "남", "010-1111-2222");
		UserVo user3 = new UserVo(3, "송영민", "남", "010-9189-9817");
		UserVo user4 = new UserVo(4, "이한솔", "남", "010-4938-0982");
		UserVo user5 = new UserVo(5, "홍석준", "남", "010-4763-3054");
		UserVo user6 = new UserVo(6, "송효근", "남", "010-4149-4719");
		UserVo user7 = new UserVo(7, "강원석", "남", "010-2361-0915");
		UserVo user8 = new UserVo(8, "홍정호", "남", "010-6565-4109");
		UserVo user9 = new UserVo(9, "배수지", "여", "010-1234-1234");
		UserVo user10 = new UserVo(10, "오재원", "남", "010-4444-0123");
		
		map.put(user1.getUserName(), user1);
		map.put(user2.getUserName(), user2);
		map.put(user3.getUserName(), user3);
		map.put(user4.getUserName(), user4);
		map.put(user5.getUserName(), user5);
		map.put(user6.getUserName(), user6);
		map.put(user7.getUserName(), user7);
		map.put(user8.getUserName(), user8);
		map.put(user9.getUserName(), user9);
		map.put(user10.getUserName(), user10);
		
		return map;
	}
	
}
