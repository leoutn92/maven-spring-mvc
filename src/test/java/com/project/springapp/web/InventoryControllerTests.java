package com.project.springapp.web;

import com.project.springapp.domain.Product;
import com.project.springapp.repository.InMemoryProductDao;
import com.project.springapp.service.SimpleProductManager;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class InventoryControllerTests {
    @Test
    public void testHandleRequestView() throws Exception {
        InventoryController controller = new InventoryController();
        SimpleProductManager spm = new SimpleProductManager();
        spm.setProductDao(new InMemoryProductDao(new ArrayList<Product>()));
        controller.setProductManager(spm);
        //controller.setProductManager(new SimpleProductManager());
        ModelAndView modelAndView = controller.handleRequest(null,null);
        assertEquals("hello",modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        Map<String,Object> modelMap = (Map<String,Object>) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }

}