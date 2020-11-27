<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: leeminjee
  Date: 2020/11/01
  Time: 3:32 오후
  To change this template use File | Settings | File Templates.
--%>

<c:set var="date" value="title"></c:set>
<html>
<head>
    <title>

        상품 목록조회 : 상품관리

    </title>

    <link rel="stylesheet" href="/css/admin.css" type="text/css">

    <script type="text/javascript">

        function fncGetProductList() {
            document.detailForm.submit();
        }

    </script>
</head>

<body bgcolor="#ffffff" text="#000000">

<div style="width:98%; margin-left:10px;">

    <form name="detailForm" action="/listProduct.do?menu=search" method="post">

        <table width="100%" height="37" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td width="15" height="37">
                    <img src="/images/ct_ttl_img01.gif" width="15" height="37"/>
                </td>
                <td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="93%" class="ct_ttl01">

                                <c:choose>
                                    <c:when test="${manu eq '상품관리'}">

                                    </c:when>

                                    <c:when test="${manu eq '상품목록조회'}">

                                    </c:when>
                                </c:choose>
<%--                                1) eq (==)--%>
<%--                                2) ne ( !=)--%>
<%--                                3. empty ( == null)--%>

                                <%--                                <% title = menu.equals("manage") ? "상품 관리" : "상품 목록조회";%>--%>
                                <%--                                <%=title%>--%>

                            </td>
                        </tr>
                    </table>
                </td>
                <td width="12" height="37">
                    <img src="/images/ct_ttl_img03.gif" width="12" height="37"/>
                </td>
            </tr>
        </table>


        <table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
            <tr>
                <c:if test="${search.SearchCondition eq not null}"></c:if>

                <%--                <%--%>
                <%--                    if (search.getSearchCondition() != null) {--%>
                <%--                %>--%>


                <td align="right">
                    <select name="searchCondition" class="ct_input_g" style="width:80px">
                        <c:choose>
                            <c:when test="${search.SearchCondition eq '0'}">

                            </c:when>

<%--                        <c:if test="${search.SearchCondition eq '0'}"></c:if>--%>
<%--                        <%--%>
<%--                            if (search.getSearchCondition().equals("0")) {--%>
<%--                        %>--%>
                        <option value="0" selected>상품번호</option>
                        <option value="1">상품명</option>
                        <option value="2">상품가격</option>
                            <c:when test="${search.SearchCondition eq '1'}">

                            </c:when>
<%--                        <%--%>
<%--                        } else if (search.getSearchCondition().equals("1")) {--%>
<%--                        %>--%>

                        <option value="0">상품번호</option>
                        <option value="1" selected>상품명</option>
                        <option value="2">상품가격</option>
                            <c:otherwise>
                                ${search.SearchCondition eq '2'}
                            </c:otherwise>
<%--                        <%--%>
<%--                        } else {--%>
<%--                        %>--%>
                        <option value="0">상품번호</option>
                        <option value="1">상품명</option>
                        <option value="2" selected>상품가격</option>
                        </c:choose>
<%--                        <%--%>
<%--                            }--%>
<%--                        %>--%>

                    </select>
                    <input type="text" name="searchKeyword" class="ct_input_g" style="width:200px; height:19px"/>
                </td>
<%--                <%--%>
<%--                } else { //처음검색--%>
<%--                %>--%>
                <td align="right">
                    <select name="searchCondition" class="ct_input_g" style="width:80px">
                        <option value="0">상품번호</option>
                        <option value="1">상품명</option>
                        <option value="2">상품가격</option>
                    </select>
                    <input type="text" name="searchKeyword" class="ct_input_g" style="width:200px; height:19px">
                </td>
<%--                <%--%>
<%--                    }--%>
<%--                %>--%>
                <td align="right" width="70">
                    <table border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="17" height="23">
                                <img src="/images/ct_btnbg01.gif" width="17" height="23">
                            </td>
                            <td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
                                <a href="javascript:fncGetProductList();">검색</a>
                            </td>
                            <td width="14" height="23">
                                <img src="/images/ct_btnbg03.gif" width="14" height="23">
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>


        <table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
            <tr>
                <td colspan="11">
                    전체  ${resultPage.totalCount } 건수, 현재 ${resultPage.currentPage}  페이지
                </td>
            </tr>
            <tr>
                <td class="ct_list_b" width="100">No</td>
                <td class="ct_line02"></td>
                <td class="ct_list_b" width="150">상품명</td>
                <td class="ct_line02"></td>
                <td class="ct_list_b" width="150">가격</td>
                <td class="ct_line02"></td>
                <td class="ct_list_b">등록일</td>
                <td class="ct_line02"></td>
                <td class="ct_list_b">현재상태</td>
            </tr>
            <tr>
                <td colspan="11" bgcolor="808285" height="1"></td>
            </tr>

<%--            <%--%>
<%--                for(int i=0; i<list.size(); i++) {--%>
<%--                    ProductVO vo = list.get(i);--%>
<%--            %>--%>
            <c:set var="i" value="0" />
            <c:forEach var="user" items="${list}">
            <c:set var="i" value="${ i+1 }" />

            <tr class="ct_list_pop">
                <td align="center">${ i }
                </td>
                <td></td>
                <td align="left">

<%--                  get controller에서 해줌--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${menu eq 'menuge'}">--%>
<%--                    <a href="/updateProductView?prodNo=${product.prodNo}${param.menu}">${product.prodNo}</a>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                    <a href="/getProduct?prodNo=${product.prodNo}${param.menu}">${product.prodNo}</a>--%>
<%--                    </c:otherwise>--%>
<%--                    </c:choose>--%>
    <a href="../product/getProduct?prodNo=${product.prodNo}&menu=${menu}">${product.prodName}</a>

                <td align="left">
                </td>
                <td></td>
                <td align="left">${product.prodName}
                </td>
                <td></td>
                <td align="left">${product.price}
                </td>
            </tr>
            <tr>
                <td colspan="11" bgcolor="D6D7D6" height="1"></td>
            </tr>
        </table>

        <!-- PageNavigation Start... -->
        <table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
            <tr>
                <td align="center">
                    <input type="hidden" id="currentPage" name="currentPage" value=""/>
<%--                    <% if( resultPage.getCurrentPage() <= resultPage.getPageUnit() ){ %>--%>
<%--                    --%>
<%--                    ◀ 이전--%>
<%--                    <% }else{ %>--%>
<%--                    <a href="javascript:fncGetUserList('<%=resultPage.getCurrentPage()-1%>')">◀ 이전</a>--%>
<%--                    <% } %>--%>

<%--                    <%	for(int i=resultPage.getBeginUnitPage();i<= resultPage.getEndUnitPage() ;i++){	%>--%>
<%--                    <a href="javascript:fncGetUserList('<%=i %>');"><%=i %>--%>
<%--                    </a>--%>
<%--                    <% 	}  %>--%>

<%--                    <% if( resultPage.getEndUnitPage() >= resultPage.getMaxPage() ){ %>--%>
<%--                    이후 ▶--%>
<%--                    <% }else{ %>--%>
<%--                    <a href="javascript:fncGetUserList('<%=resultPage.getEndUnitPage()+1%>')">이후 ▶</a>--%>
<%--                    <% } %>--%>
                    <jsp:include page="../common/pageNavigator.jsp"/>

                </td>
            </tr>
        </table>
        <!-- PageNavigation End... -->

    </form>
</div>

</body>
</html>