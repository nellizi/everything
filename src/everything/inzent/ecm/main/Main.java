package everything.inzent.ecm.main;

import everything.inzent.ecm.frame.Frame;

public class Main {

	public static void main(String[] args) {
		/*
		 * 1. 프레임 띄우기
		 * 	=====프레임=====
		 * 	1) 디렉토리 입력 텍스트 필드
		 * 	2) 검색 버튼 추가
		 * 	3) 검색 버튼 클릭시 1) 텍스트필드의 값 파일 리스트 불러오는 메서드에 매개변수로 값 넘기기
		 * 		3-1) 매개변수로 넘어온 경로에 있는 모든 파일 리스트 불러오기
		 * 		3-2) 파일 리스트에서 파일명, 날짜 등 필요한 정보 객체에 담기
		 * 		3-3) 객체를 이차원 배열에 값 입력하고 JTable로 넘기기
		 *  4) JTable 띄우기 
		 *  	4-1) 검색어 입력 필드 추가하기
		 *  	4-2) 입력된 검색어만 필터링 돼서 테이블로 값 띄워주기  
		 * */

		new Frame();
	}

}
