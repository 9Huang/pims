package com.huang.pims.demo.controller;

import com.huang.pims.demo.beans.Demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping(value = "/thymeleafDemo")
public class ThymeleafDemoController {

    @GetMapping("/sayHello")
    public String sayHello(Model model) {
        model.addAttribute("javaString", "simple java string");

        model.addAttribute("labelString","<span style='color:red'>Jerry</span>");

        Demo demo = new Demo("弦乐", 12, new Date());
        model.addAttribute("demo", demo);

        List<String> stringList = new ArrayList<>(4);
        stringList.add("huang0");
        stringList.add("chen");
        stringList.add("hello");
        stringList.add("xian");
        model.addAttribute("stringList",stringList);

        List<Demo> demoList = new ArrayList<>(3);
        demoList.add(demo);
        demoList.add(demo);
        model.addAttribute("demoList", demoList);

        Set<String> stringSet = new HashSet<>();
        stringSet.add("huang0");
        stringSet.add("chen");
        stringSet.add("hello");
        stringSet.add("xian");
        model.addAttribute("stringSet", stringSet);

        Set<Demo> demoSet = new HashSet<>();
        demoSet.add(demo);
        Demo demo02 = new Demo("hello", 22, new Date());
        demoSet.add(demo02);
        model.addAttribute("demoSet", demoSet);

        Map<String, String> stringMap = new HashMap<>(3);
        stringMap.put("name", "world");
        stringMap.put("sex", "1");
        stringMap.put("age", "12");
        model.addAttribute("stringMap", stringMap);

        Map<String, Demo> demoMap = new HashMap<>(2);
        demoMap.put("demo01", demo);
        demoMap.put("demo02", demo02);
        model.addAttribute("demoMap", demoMap);

        model.addAttribute("calendarDate", Calendar.getInstance());



        return "demo/index";
    }

}
