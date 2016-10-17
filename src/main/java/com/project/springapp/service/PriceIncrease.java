package com.project.springapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by developer on 13/10/16.
 */
@Service
public class PriceIncrease {
    protected final Log logger = LogFactory.getLog(getClass());
    @Min(0)
    @Max(50)
    private int percentage;

    public void setPercentage(int i) {
        percentage = i;
        logger.info("Porcentage set to " +1);
    }

    public int getPercentage() {
        return percentage;
    }

}
