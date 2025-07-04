package com.example.common.base;

public class BaseVo {
//	paging
	private int thisPage = 1;									// 현재 페이지
	private int rowNumToShow = 8;								// 화면에 보여줄 데이터 줄 갯수
	private int pageNumToShow = 5;								// 화면에 보여줄 페이징 번호 갯수

	private int totalRows;										// 전체 데이터 갯수
	private int totalPages;										// 전체 페이지 번호
	private int startPage;										// 시작 페이지 번호
	private int endPage;										// 마지막 페이지 번호
	
	private int startRnumForMysql = 0;							// 쿼리 시작 row
	
//	paging new
	private int thisPageNew = 1;									// 현재 페이지
	private int rowNumToShowNew = 5;								// 화면에 보여줄 데이터 줄 갯수
	private int pageNumToShowNew = 5;								// 화면에 보여줄 페이징 번호 갯수
	
	private int totalRowsNew;										// 전체 데이터 갯수
	private int totalPagesNew;										// 전체 페이지 번호
	private int startPageNew;										// 시작 페이지 번호
	private int endPageNew;										// 마지막 페이지 번호
	
	private int startRnumForMysqlNew = 0;							// 쿼리 시작 row
	
	private String shOptionOrder;

	//	search
	private Integer shUseNy = 1; 								/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private Integer shDelNy = 0; 								/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private Integer shOptionDate;							/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String shDateStart;
	private String shDateEnd;
	private Integer shOption;									/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private Integer shOption1;
	private String shValue;
	
	private String shStatus;
	
	private String searchKeyword;
    private String searchOption;
    
    public void setParamsPaging(int totalRows) {
        this.setTotalRows(totalRows);
        if (this.getTotalRows() == 0) {
            this.setTotalPages(0);
            this.setStartPage(1);
            this.setEndPage(1);
            this.setThisPage(1);
        } else {
            this.setTotalPages((this.getTotalRows() - 1) / this.getRowNumToShow() + 1);
            if (this.getThisPage() > this.getTotalPages() && this.getTotalPages() > 0) {
                this.setThisPage(this.getTotalPages());
            }
            if (this.getThisPage() < 1) {
                this.setThisPage(1);
            }
            this.setStartPage(((this.getThisPage() - 1) / this.getPageNumToShow()) * this.getPageNumToShow() + 1);
            this.setEndPage(Math.min(this.getStartPage() + this.getPageNumToShow() - 1, this.getTotalPages()));
        }
        this.setStartRnumForMysql((this.getThisPage() - 1) * this.getRowNumToShow());
    }
//	-----

	public int getThisPage() {
		return thisPage;
	}

	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}

	public int getRowNumToShow() {
		return rowNumToShow;
	}

	public void setRowNumToShow(int rowNumToShow) {
		this.rowNumToShow = rowNumToShow;
	}

	public int getPageNumToShow() {
		return pageNumToShow;
	}

	public void setPageNumToShow(int pageNumToShow) {
		this.pageNumToShow = pageNumToShow;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
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

	public int getStartRnumForMysql() {
		return startRnumForMysql;
	}

	public void setStartRnumForMysql(int startRnumForMysql) {
		this.startRnumForMysql = startRnumForMysql;
	}

	public int getThisPageNew() {
		return thisPageNew;
	}

	public void setThisPageNew(int thisPageNew) {
		this.thisPageNew = thisPageNew;
	}

	public int getRowNumToShowNew() {
		return rowNumToShowNew;
	}

	public void setRowNumToShowNew(int rowNumToShowNew) {
		this.rowNumToShowNew = rowNumToShowNew;
	}

	public int getPageNumToShowNew() {
		return pageNumToShowNew;
	}

	public void setPageNumToShowNew(int pageNumToShowNew) {
		this.pageNumToShowNew = pageNumToShowNew;
	}

	public int getTotalRowsNew() {
		return totalRowsNew;
	}

	public void setTotalRowsNew(int totalRowsNew) {
		this.totalRowsNew = totalRowsNew;
	}

	public int getTotalPagesNew() {
		return totalPagesNew;
	}

	public void setTotalPagesNew(int totalPagesNew) {
		this.totalPagesNew = totalPagesNew;
	}

	public int getStartPageNew() {
		return startPageNew;
	}

	public void setStartPageNew(int startPageNew) {
		this.startPageNew = startPageNew;
	}

	public int getEndPageNew() {
		return endPageNew;
	}

	public void setEndPageNew(int endPageNew) {
		this.endPageNew = endPageNew;
	}

	public int getStartRnumForMysqlNew() {
		return startRnumForMysqlNew;
	}

	public void setStartRnumForMysqlNew(int startRnumForMysqlNew) {
		this.startRnumForMysqlNew = startRnumForMysqlNew;
	}

	public String getShOptionOrder() {
		return shOptionOrder;
	}

	public void setShOptionOrder(String shOptionOrder) {
		this.shOptionOrder = shOptionOrder;
	}

	public Integer getShUseNy() {
		return shUseNy;
	}

	public void setShUseNy(Integer shUseNy) {
		this.shUseNy = shUseNy;
	}

	public Integer getShDelNy() {
		return shDelNy;
	}

	public void setShDelNy(Integer shDelNy) {
		this.shDelNy = shDelNy;
	}

	public Integer getShOptionDate() {
		return shOptionDate;
	}

	public void setShOptionDate(Integer shOptionDate) {
		this.shOptionDate = shOptionDate;
	}

	public String getShDateStart() {
		return shDateStart;
	}

	public void setShDateStart(String shDateStart) {
		this.shDateStart = shDateStart;
	}

	public String getShDateEnd() {
		return shDateEnd;
	}

	public void setShDateEnd(String shDateEnd) {
		this.shDateEnd = shDateEnd;
	}

	public Integer getShOption() {
		return shOption;
	}

	public void setShOption(Integer shOption) {
		this.shOption = shOption;
	}

	public Integer getShOption1() {
		return shOption1;
	}

	public void setShOption1(Integer shOption1) {
		this.shOption1 = shOption1;
	}

	public String getShValue() {
		return shValue;
	}

	public void setShValue(String shValue) {
		this.shValue = shValue;
	}

	public String getShStatus() {
		return shStatus;
	}

	public void setShStatus(String shStatus) {
		this.shStatus = shStatus;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSearchOption() {
		return searchOption;
	}

	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

}
