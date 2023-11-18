package com.example.springdeployapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class ApiController {
    @GetMapping("/api/container")
    public String getContainerName(){
        String containerName = "";
        try {
            containerName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "Container name: " + containerName;
    }
}
