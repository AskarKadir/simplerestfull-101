/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.askar.pws.askar101;

import com.askar.pws.askar101.product.Product;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author STRIX
 */
@RestController
public class ProductServiceController {
    private static Map<String, Product> productRepo = new HashMap<>();
    
    //mmembuat data awal ketika menggunakan GET JSON
    static {
      Product honey = new Product();
      honey.setId("1");
      honey.setName("Madu");
      honey.setQuantity("3");
      honey.setPrice("5000");
      productRepo.put(honey.getId(), honey);
      
      Product almond = new Product();
      almond.setId("2");
      almond.setName("Almod");
      almond.setQuantity("5");
      almond.setPrice("3000");
      productRepo.put(almond.getId(), almond);
   }
    
    //membuat method untuk menampilkan data yang ada pada JSON
   @RequestMapping(value = "/products")
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
   }
   
   //membuat method untuk delete data dengan id tertentu
   @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> delete(@PathVariable("id")String id){
       productRepo.remove(id);
       return new ResponseEntity<>("Product is deleted Successfully", HttpStatus.OK);
   }
   
   //membuat method untuk update data dengan id tertentu
   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Object> updateProduct(@PathVariable("id")String id, @RequestBody Product product){
       if(!productRepo.containsKey(id)){
           return new ResponseEntity<>("Product is not assigned", HttpStatus.OK);
           //kondisi jika id tidak ditemukan akan menampilkan pesan "Product is not assigned"
       }else{
           productRepo.remove(id);
           product.setId(id);
           productRepo.put(id, product);
           return new ResponseEntity<>("Product is updated Successfully", HttpStatus.OK);
           //kondisi jika id ditemukan akan menampilakan "Product is updated Successfully"
       }
       
   }
   
   //membuat method untuk menambahkan data
   @RequestMapping(value = "/products", method = RequestMethod.POST)
   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
       if(productRepo.containsKey(product.getId())){
           return new ResponseEntity<>("Product Key can not duplicated", HttpStatus.CREATED);
           //kondisi jika id ada yang sama akan menampilakan pesan "Product Key can not duplicated"
       }else{
           productRepo.put(product.getId(), product);
           return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
           //kondisi jika id tidak ada yang sama akan menampilkan pesan "Product is created successfully"
       }
   }
   
}
