package dto; //20240104

public class Pagination {
	// 한 화면에 표시할 행의 개수
	private int rows = 10;
	// 페이지 내비게이션에 한번에 표시할 페이지번호 개수
	private int pages = 5;
	// 전체 행의 개수
	private int totalRows;
	// 전체 페이지 개수
	private int totalPages;
	// 전체 블록 개수
	private int totalBlocks;
	
	// 현재 페이지번호
	private int currentPage;
	// 현재 블록번호
	private int currentBlock;
	
	// 게시글 조회범위
	private int begin;
	private int end;
	
	// 페이지 내비게이션 출력범위
	private int beginPage;
	private int endPage;
	
	// 첫 페이지인지, 마지막 페이지인지 판단할 기준
	private boolean isFirst;
	private boolean isLast;
	
	public Pagination(int currentPage, int totalRows) {
		this.currentPage = currentPage;
		this.totalRows = totalRows;
		init();
	}
	public Pagination(int currentPage, int totalRows, int rows) {
		this.currentPage = currentPage;
		this.totalRows = totalRows;
		this.rows = rows;
		init();
	}
	public Pagination(int currentPage, int totalRows, int rows, int pages) {
		this.currentPage = currentPage;
		this.totalRows = totalRows;
		this.rows = rows;
		this.pages = pages;
		init();
	}
	private void init() {
		if (totalRows > 0) {
			// 전체 페이지 개수 계산하기
			this.totalPages = (int) Math.ceil((double) totalRows/rows);
			// 전체 페이지 블록 개수 계산하기
			this.totalBlocks = (int) Math.ceil((double) totalPages/pages);
			// 현재 블록 계산하기
			this.currentBlock = (int) Math.ceil((double) currentPage/pages);
			
			// 게시글 조회범위 계산하기
			this.begin = (currentPage - 1)*rows + 1;
			this.end = currentPage*rows;
			
			// 페이지 내비게이션 출력 범위 계산하기
			this.beginPage = (currentBlock - 1)*pages + 1;
			this.endPage = currentBlock*pages;
			if (currentBlock == totalBlocks) {
				this.endPage = this.totalPages;
			}
			
			if (currentPage == 1) {
				this.isFirst = true;
			}
			
			if (currentPage == totalPages) {
				this.isLast = true;
			}
		}
	}
	public int getRows() {
		return rows;
	}
	public int getPages() {
		return pages;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public int getTotalBlocks() {
		return totalBlocks;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getCurrentBlock() {
		return currentBlock;
	}
	public int getBegin() {
		return begin;
	}
	public int getEnd() {
		return end;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	
	public boolean isFirst() {
		return isFirst;
	}
	
	public boolean isLast() {
		return isLast;
	}
	@Override
	public String toString() {
		return "Pagination [rows=" + rows + ", pages=" + pages + ", totalRows=" + totalRows + ", totalPages="
				+ totalPages + ", totalBlocks=" + totalBlocks + ", currentPage=" + currentPage + ", currentBlock="
				+ currentBlock + ", begin=" + begin + ", end=" + end + ", beginPage=" + beginPage + ", endPage="
				+ endPage + ", isFirst=" + isFirst + ", isLast=" + isLast + "]";
	}
	
}
