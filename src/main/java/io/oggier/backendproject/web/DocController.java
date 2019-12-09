package io.oggier.backendproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DocController {
    @RequestMapping("/")
    public @ResponseBody
    String documentation() {
        return "Documentation";
    }
}
