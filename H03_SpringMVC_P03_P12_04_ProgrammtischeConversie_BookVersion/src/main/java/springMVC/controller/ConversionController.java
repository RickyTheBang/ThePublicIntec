package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/convert")
public class ConversionController {
    @GetMapping
    public String forward() {
        return "convert";
    }

    @PostMapping
    public String handleForm(@RequestParam("number") String value,
                             BindingResult br) {
        try {
            double number = Double.parseDouble (value);

        } catch (NumberFormatException ex) {
            br.addError (new ObjectError ("number", "error.number"));

        }
        return "convert";
    }
}