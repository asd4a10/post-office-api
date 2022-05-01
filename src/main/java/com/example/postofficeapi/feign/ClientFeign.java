package com.example.postofficeapi.feign;

import com.example.postofficeapi.model.ClientModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "client-core-api")
public interface ClientFeign {
    @GetMapping("/client/check")
    String checkClientCoreApi();

    @GetMapping("/client/all")
    List<ClientModel> getAllClients();

    @GetMapping("/client")
    ClientModel getClientById(@RequestParam String clientId);

    @PostMapping("/client")
    ClientModel createClient(ClientModel clientModel);

    @PutMapping("/client")
    ClientModel updateClientById(@RequestParam String clientId, ClientModel clientModel);

    @DeleteMapping("/client")
    ClientModel deleteClientById(@RequestParam String clientId);
}
