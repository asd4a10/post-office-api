package com.example.postofficeapi.controller;

import com.example.postofficeapi.feign.ClientFeign;
import com.example.postofficeapi.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post-office/client")
public class ClientController {
    @Autowired
    ClientFeign clientFeign;

    @GetMapping("/check")
    public String checkClientFeign() {
        return clientFeign.checkClientCoreApi();
    }

    @GetMapping("/all")
    public List<ClientModel> getAllClients() {
        return clientFeign.getAllClients();
    }

    @GetMapping
    public ClientModel getClientById(@RequestParam String clientId) {
        return clientFeign.getClientById(clientId);
    }

    @PostMapping
    public ClientModel createClient(@RequestBody ClientModel clientModel) {
        return clientFeign.createClient(clientModel);
    }

    @PutMapping
    public ClientModel updateClientById(@RequestParam String clientId, @RequestBody ClientModel clientModel) {
        return clientFeign.updateClientById(clientId, clientModel);
    }

    @DeleteMapping
    public ClientModel deleteClientById(@RequestParam String clientId) {
        return clientFeign.deleteClientById(clientId);
    }
}
