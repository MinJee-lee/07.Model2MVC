package com.model2.mvc.web.product;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.Product.ProductService;
import com.model2.mvc.service.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/product/*")
public class ProductController {

    ///Field
    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService;
    //setter Method 구현 않음

    public ProductController() {
        System.out.println(this.getClass());
    }

    public String addProduct() throws Exception {

        System.out.println("/product/addProduct : GET");

        return "redirect:/product/addProduct.jsp";
    }

    //@RequestMapping("/addProduct.do")
    @RequestMapping(value = "addProduct", method = RequestMethod.POST)

    //@ModelAttribute 는 request objectScope 에 담아 .jsp와 product field에 맞는 값을 찾기
    public String addProduct(@ModelAttribute("product") Product product) throws Exception {

        System.out.println("/product/addProductView : POST");
        //Business Logic
        productService.addProduct(product);

        return "redirect:/product/addProductView.jsp";
    }

//    @RequestMapping(value = "addProduct", method = RequestMethod.GET)//@RequestParam 는 req로 맞는 정보 가져오겠다
//    public String getProduct(@RequestParam("prodNo") int prodNo, Model model) throws Exception {
//
//        System.out.println("/product/getProduct : GET");
//        //Business Logic
//        Product product = productService.getProduct(prodNo);
//        // Model 과 View 연결
//        model.addAttribute("product", product);
//
//        return "forward:/product/addProductView.jsp";
//    }


//
//        @RequestMapping(value = "addProduct", method=RequestMethod.GET)
//        public ModelAndView addProduct (HttpSession session){
//        System.out.println("\n::==>addProduct() start");
//
//        String message ="addProduct";
//
//        ModelAndView medelAndView = new ModelAndView();
//        medelAndView.setViewName("/product/addproductview.jsp");
//        medelAndView.setObject("message",message);
//
//        System.out.println("\n::==>addProduct() end");
//        return medelAndView;
//}

    //@RequestMapping("/getProduct.do")
    //@RequestMapping( value="getProduct") 모두 바꿀 수 있음
    //@RequestParam 한가지만 가져오기
    @RequestMapping(value = "getProduct", method = RequestMethod.GET)//@RequestParam 는 req로 맞는 정보 가져오겠다
    public String getProduct(@RequestParam("prodNo") int prodNo, Model model, HttpServletRequest request) throws Exception {

        String menu = request.getParameter("menu"); //menu의 속성을 가진 data를 가져와야 하기 때문에 ""을 씀
        System.out.println("menu 값을 확인" + menu);

        //Model(key value) view에 data를 넣기 위해 설정
        //HttpServletRequest view에서 menu값을 받아오기 위해서 지정해줌
        System.out.println("/product/getProduct : GET");
        //Business Logic
        Product product = productService.getProduct(prodNo);
        // Model 과 View 연결
        model.addAttribute("product", product);

        //검색(search) or 수정(update) 인지 확인
        //"search"라는 문자열을 가지고 있는가
        if (menu != null && menu == "search") {
            return "forward:/product/getProduct.jsp";
        }
        //화면으로 바로 쏘기 때문에 .jsp
        return "forward:/product/updateProductView.jsp";
    }

    //@RequestMapping("/updateProductView.do")
    //public String updateProductView( @RequestParam("prodNo") String ProdNo , Model model ) throws Exception{
    @RequestMapping(value = "updateProduct", method = RequestMethod.GET)

    //@ModelAttribute("product") Product product 는 @ModelAttribut requestScope 으로 받아서 set 해줌
    //또한 Domain으로 받을 수 있음
    public String updateProduct(@ModelAttribute("product") Product product, Model model) throws Exception {

        System.out.println("/product/updateProduct : GET");

        productService.updateProduct(product);
        // Model 과 View 연결
        model.addAttribute("product", product);

        //product controller안에 getProduct로 접근하겠다
        return "forward:/product/getProduct";
    }


    @RequestMapping(value = "listProduct")
    public String listProduct
            (@ModelAttribute("search") Search search, Model model, HttpServletRequest request) throws Exception {

        //상품상세조회 상품관리로 나눠주기 위헤 menu설정
        String menu = request.getParameter("menu");

        System.out.println("/product/listProductView : GET / POST");

        if (search.getCurrentPage() == 0) {
            search.setCurrentPage(1);
        }
        search.setPageSize(pageSize);

        // Business logic 수행
        Map<String, Object> map = productService.getproductList(search);

        Page resultPage = new Page(search.getCurrentPage(), ((Integer) map.get("totalCount")).intValue(), pageUnit, pageSize);
        System.out.println(resultPage);

        // Model 과 View 연결
        model.addAttribute("list", map.get("list"));
        model.addAttribute("resultPage", resultPage);
        model.addAttribute("search", search);
        model.addAttribute("menu", menu);

        return "forward:/user/listProductView.jsp";
    }
}