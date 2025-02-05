package com.chessgg.chessapp.maven.controller;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        ServletWebRequest webRequest = new ServletWebRequest(request);

        // Retrieve detailed error attributes
        Map<String, Object> errorDetails = errorAttributes.getErrorAttributes(
                webRequest,
                ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE, ErrorAttributeOptions.Include.EXCEPTION)
        );

        // Add error details to the model
        model.addAttribute("timestamp", errorDetails.getOrDefault("timestamp", "N/A"));
        model.addAttribute("status", errorDetails.getOrDefault("status", "N/A"));
        model.addAttribute("error", errorDetails.getOrDefault("error", "Unknown Error"));
        model.addAttribute("message", errorDetails.getOrDefault("message", "No additional details available."));
        model.addAttribute("path", errorDetails.getOrDefault("path", "Unknown"));
        model.addAttribute("trace", errorDetails.getOrDefault("trace", "No trace available."));

        return "error"; // Render the error.html template
    }
}
