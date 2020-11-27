package com.model2.mvc.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
//==> PageNavigation 을 위한 Bean
public class Page {
	
	///Field
	private int currentPage;		// 현재페이지
	private int totalCount;			// 총 게시물 수
	private int pageUnit;			// 하단 페이지 번호 화면에 보여지는 수
	private int pageSize;			// 한 페이지당 보여지는 게시물수
	private int maxPage;			// 최대 페이지 번호(전체 페이지)
	private int beginUnitPage;	//화면에 보여지는 페이지 번호의 최소수
	private int endUnitPage;		//화면에 보여지는 페이지 번호의 최대수
	

	public Page( int currentPage, int totalCount,	int pageUnit, int pageSize ) {
		this.totalCount = totalCount;
		this.pageUnit = pageUnit;
		this.pageSize = pageSize;
		
		this.maxPage = (pageSize == 0) ? totalCount :  (totalCount-1)/pageSize +1;
		this.currentPage = ( currentPage > maxPage) ? maxPage : currentPage;
		
		this.beginUnitPage = ( (currentPage-1) / pageUnit ) * pageUnit +1 ;
		
		if( maxPage <= pageUnit ){
			this.endUnitPage = maxPage;
		}else{
			this.endUnitPage = beginUnitPage + (pageUnit -1);
			if( maxPage <= endUnitPage){
				this.endUnitPage = maxPage;
			}
		}
	}
	

}