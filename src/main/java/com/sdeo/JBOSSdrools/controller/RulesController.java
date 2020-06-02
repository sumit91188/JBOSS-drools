package com.sdeo.JBOSSdrools.controller;

import com.sdeo.JBOSSdrools.model.Product;
import com.sdeo.JBOSSdrools.service.ReloadDroolsRulesService;
import org.kie.api.runtime.KieSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author Sumit Deo
 */

@RequestMapping("/rules")
@Controller
public class RulesController {

    @Resource
    private ReloadDroolsRulesService rules;

    @ResponseBody
    @GetMapping(value = "/{type}")
    public ResponseEntity<Product> getDiscount(@PathVariable String type){
        Product product = new Product();
        product.setType(type);

        KieSession kieSession = ReloadDroolsRulesService.kieContainer.newKieSession();

        kieSession.insert(product);
        int ruleFiredCount = kieSession.fireAllRules();
        kieSession.destroy();
        System.out.println("Number of rules fired: " + ruleFiredCount);

        if(product.getDiscount() == 0){
            System.out.println("No rule available for " + type);
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/reload")
    public ResponseEntity<String> reload() throws IOException {
        rules.reload();
        return new ResponseEntity<>("Rules Updated!", HttpStatus.OK);
    }
}
