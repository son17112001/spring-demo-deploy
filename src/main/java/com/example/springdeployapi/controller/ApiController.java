package com.example.springdeployapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class ApiController {
    @GetMapping("/api/container")
    public ResponseEntity getContainerName(){
        String containerName = "Undefine";
        try {
            containerName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return new ResponseEntity(false, "404", containerName);
        }

        return new ResponseEntity(true, "400",  containerName);
    }
}
