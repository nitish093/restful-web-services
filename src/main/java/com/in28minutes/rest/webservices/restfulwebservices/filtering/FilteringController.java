package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering()
    {
        return new SomeBean("val1","val2","val3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList()
    {
        return Arrays.asList(new SomeBean("val1","val2","val3"),
                new SomeBean("val1","val20","val30"),
                new SomeBean("val15","val25","val33"));
    }
}
