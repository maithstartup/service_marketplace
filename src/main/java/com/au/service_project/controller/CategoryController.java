package com.au.service_project.controller;

import com.au.service_project.entity.Category;
import com.au.service_project.service.CategoryService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<Object> addCategory(@RequestBody Category category){

        String response=categoryService.addCategory(category);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("not able to create category", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/image/{id}")
    public ResponseEntity<Object> handleImagePost(@PathVariable Integer id, @RequestParam("imagefile") MultipartFile file){

        String response = categoryService.saveImageFile(id, file);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("not able to create category", HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/all")
    public ResponseEntity<Object> getCategoryAll(){
        List<Category> categorySet = categoryService.getCategoryAll();
        if(categorySet != null)
            return new ResponseEntity<>(categorySet, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able list category", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/allname")
    public ResponseEntity<Object> getCategoryAllName(){
        List<String> categoryNames = categoryService.getCategoryAllName();
        if(categoryNames != null)
            return new ResponseEntity<>(categoryNames, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able list category", HttpStatus.BAD_REQUEST);

    }


//    @GetMapping("/")
//
//    public ResponseEntity<Object> getCategoryByIdOrName(@RequestParam("id")  Integer id ,
//                                                  @RequestParam("name") String name)
//    {
//        Category category= null ;
//        if(id != null)
//            category = categoryService.getCategoryById(id);
//        else if(name!= null)
//            category = categoryService.getCategoryByName(name);;
//
//        if(category != null)
//            return new ResponseEntity<>(category, HttpStatus.OK);
//        else
//            return new ResponseEntity<>("not able to find category", HttpStatus.BAD_REQUEST);
//
//    }

    @GetMapping("/id/{categoryId}")
    public ResponseEntity<Object> getCategoryById(@PathVariable("categoryId") Integer categoryId){
        Category category = categoryService.getCategoryById(categoryId);
        if(category != null)
            return new ResponseEntity<>(category, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to find category", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/get/name/{categoryName}")
    public ResponseEntity<Object> getCategoryByName(@PathVariable("categoryName") String categoryName){
        Category category = categoryService.getCategoryByName(categoryName);
        if(category != null)
            return new ResponseEntity<>(category, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to find category", HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/image/{categoryId}")
    public String renderImageFromDB(@PathVariable Integer categoryId, HttpServletResponse response) throws IOException {
        Category category =categoryService.getCategoryById(categoryId);
        if (category != null && category.getCategoryPic()!=null) {
            byte[] byteArray = new byte[category.getCategoryPic().length];
            int i = 0;

            for (Byte wrappedByte : category.getCategoryPic() ){
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
            return "image found";
        }
        else
            return "no image";
    }

    @PutMapping("/id/{categoryId}")
    public ResponseEntity<Object> updateCategoryById(@PathVariable("categoryId") Integer categoryId, @RequestBody Category category){
        Category categoryResponse = categoryService.updateCategoryById(categoryId,category);
        if(categoryResponse != null)
            return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to update category", HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/name/{categoryName}")
    public ResponseEntity<Object> updateCategoryByName(@PathVariable("categoryName") String categoryName, @RequestBody Category category){
        Category categoryResponse = categoryService.updateCategoryByName(categoryName,category);
        if(categoryResponse != null)
            return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to update category", HttpStatus.BAD_REQUEST);

    }
    
    
    @DeleteMapping("/id/{categoryId}")
    public ResponseEntity<Object> deleteCategoryById(@PathVariable("categoryId") Integer categoryId){
    	String response= categoryService.deleteCategoryById(categoryId);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to delete category", HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/name/{categoryName}")
    public ResponseEntity<Object> deleteCategoryByName(@PathVariable("categoryName") String categoryName){
    	String response= categoryService.deleteCategoryByName(categoryName);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to delete category", HttpStatus.BAD_REQUEST);
    }
    
    //Query
    @GetMapping("/categorybycity/{city}")
    public ResponseEntity<Object> getCategoryByCity(@PathVariable("city") String city){
        System.out.println(city);
        Set<String> categories= categoryService.getCategoryByCity(city);
    	if(categories != null)
            return new ResponseEntity<>(categories, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able to get categories by city", HttpStatus.BAD_REQUEST);
    }



    

}
