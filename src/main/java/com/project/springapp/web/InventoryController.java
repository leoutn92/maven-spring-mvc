package com.project.springapp.web;

import com.project.springapp.domain.Product;
import com.project.springapp.service.ProductManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class InventoryController {
    protected final Log logger = LogFactory.getLog(getClass());
    private Date now = new Date();
    @Autowired
    private ProductManager productManager;

    @RequestMapping(value="/hello.html")
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)
     throws ServerException,IOException{
        String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);
        Map<String,Object> myModel = new HashMap<String, Object>();
        myModel.put("now",now);
        myModel.put("products",this.productManager.getProducts());
        return "hello";
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
}