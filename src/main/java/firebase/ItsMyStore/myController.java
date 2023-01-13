/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firebase.ItsMyStore;

import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.myService;
import entity.myStore;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author eunannana
 */
@RestController
@RequestMapping("/api")
public class myController {
   
    @Autowired
    private myService myService;
    
    public myController(myService myService){
        this.myService = myService;
    }
    
    @PostMapping("/create")
    public String addmyStore(@RequestBody myStore mystore) throws InterruptedException, ExceptionInInitializerError, ExecutionException{
        return myService.addmyStore(mystore);
    }
    
    @GetMapping("/get")
    public myStore getmyStore(@RequestParam String productID) throws InterruptedException, ExceptionInInitializerError, ExecutionException{
        return myService.getmyStore(productID);
    }
    
    @GetMapping("/getAll")
    public List<myStore> viewmyStoreAll() throws InterruptedException, ExecutionException{
        return myService.getmyStoreAll();
    }
    
    @PutMapping("/update")
    public String updatemyStore(@RequestBody myStore mystore) throws InterruptedException, ExceptionInInitializerError, ExecutionException{
        return myService.updatemyStore(mystore);
    }
    
    @DeleteMapping("/delete")
    public String deletemyStore(@RequestParam String productID) throws InterruptedException, ExceptionInInitializerError{
        return myService.deletemyStore(productID);
    }
    
    @GetMapping("/test")
    public ResponseEntity<String> testGetEndPoint(){
        return ResponseEntity.ok("Test get endpoint is working");
    }
}
