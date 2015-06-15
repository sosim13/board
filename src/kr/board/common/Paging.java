package kr.board.common;

import org.apache.ibatis.type.Alias;

@Alias("Paging")
public class Paging {
	/** 보여질 데이터 수 */
	private final int viewData = 10;
	/** 보여질 페이지 수 */
	private final int viewPage = 10;
	/** 현재 페이지 */
	private int currentPage = 1;
	/** 전체페이지 수 */
	private int totalPage = 0;
	/** 시작페이지 번호 */
	private int startPage = 0;
	/** 끝 페이지 번호 */
	private int endPage = 0;
	
	/** 데이터 시작 번호 */
	private int startNum = 1;
	/** 데이터 종료 번호 */
	private int endNum = 10;
	
	/** 전체 데이터 수 */
	private int totalCnt = 0;
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	//전체 데이터 수를 기준으로 페이징 계산
	public void setPaging(){
		//전체 페이지
		if(getTotalCnt() % viewPage == 0){	//viewPage 배수(10, 20, 30)
			setTotalPage(getTotalCnt()/viewPage);
		}else{	//viewPage 배수 아님(1,2,3, 12, 15, 26...)
			setTotalPage(getTotalCnt()/viewPage + 1);
		}
		
		//시작페이지
		setStartPage((((getCurrentPage()-1) / viewPage) * viewPage) +1);
		
		//마지막 페이지
		int nowLastPage = getStartPage() + viewPage -1;
		if(nowLastPage < getTotalPage()){	//마지막페이지가 전체 페이지보다 작은 경우
			setEndPage(nowLastPage);
		}else{
			setEndPage(getTotalPage());
		}
	}

	public void setCurrentPage(int currentPage) {
		//페이지 변동시 마다 데이터시작/종료 번호 변경 
		this.currentPage = currentPage;
		
		//데이터시작/종료 번호 변경
		setStartNum(currentPage * viewData - 9);
		setEndNum(currentPage * viewData);
		
		setPaging();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getViewData() {
		return viewData;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
		setPaging();
	}

	public int getViewPage() {
		return viewPage;
	}
	
	
}
