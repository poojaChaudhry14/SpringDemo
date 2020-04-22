package com.project.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "demo")
public class DemoController {
    static List<String> names = new ArrayList<>();

    @Autowired
    private DemoRepository demoRepository;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<String> demo(){
        Iterable<DemoEntity> demoEntities = demoRepository.findAll();
        return new ResponseEntity(demoEntities, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<String> demoPOST(@RequestBody DemoEntity demoEntity){
        demoRepository.save(demoEntity);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{name}")
    ResponseEntity<String> demoByName(@PathVariable String name){
        List<DemoEntity> demoEntities = demoRepository.findByName(name);
        return new ResponseEntity(demoEntities, HttpStatus.OK);
    }
}
