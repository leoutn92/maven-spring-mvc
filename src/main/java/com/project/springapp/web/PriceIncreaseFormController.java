package com.project.springapp.web;

import com.project.springapp.service.PriceIncrease;
import com.project.springapp.service.ProductManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by developer on 13/10/16.
 */
@Controller
@RequestMapping(value="/priceincrease.html")
public class PriceIncreaseFormController {
    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    private ProductManager productManager;
    @RequestMapping(method= RequestMethod.POST)
    public String onSubmit(@Valid PriceIncrease priceIncrease, BindingResult result) {
        if (result.hasErrors()) {
            return "priceincrease";
        }
        int increase = priceIncrease.getPercentage();
        logger.info("Increaseing prices by "+ increase + "%.");
        productManager.increasePrice(increase);
        return "redirect:/hello.html";
    }
    @RequestMapping(method= RequestMethod.GET)
    protected PriceIncrease formBackingObject(HttpServletRequest request)
            throws ServletException {
        PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage(15);
        return priceIncrease;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
}
