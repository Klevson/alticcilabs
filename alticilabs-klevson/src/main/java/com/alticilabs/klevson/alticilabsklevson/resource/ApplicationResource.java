package com.alticilabs.klevson.alticilabsklevson.resource;

import com.alticilabs.klevson.alticilabsklevson.config.ApplicationConfigConstants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Klevson
 */
@RestController
@RequestMapping(ApplicationConfigConstants.API_VERSION)
public class ApplicationResource {
    
    private List<Integer> arrayValues;

    public ApplicationResource() {
        this.arrayValues = new ArrayList<Integer>(Arrays.asList(0,1,1));
    }
    
    
    
    @GetMapping(path = "/alticci/{input}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "input", value = "The index of a requested list param", dataType = "integer", paramType = "path")
    })
    @CrossOrigin(origins = {"http://localhost:80", "http://localhost:4200", "http://localhost/"})
    public Integer getArrayCalculated(@PathVariable(required = true, value = "input") Integer input){
        return this.calculate(input);
    }
    
    
    private Integer calculate(Integer value){
        Integer returnValue;
        
        if (arrayValues.size() >= (value + 1)) {
            returnValue = arrayValues.get(value);
        } else {
            Integer nextValue;
            for (int i = arrayValues.size(); i <= value; i++) {
                nextValue = arrayValues.get(i-3) + arrayValues.get(i-2);
                arrayValues.add(i, nextValue);
            }
            returnValue = arrayValues.get(value);
        }

        System.out.println(arrayValues);
        return returnValue;
    }
}
