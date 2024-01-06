package com.example.cms.controller;
import com.example.cms.controller.dto.ShoeDto;
import com.example.cms.controller.exceptions.ShoeNotFoundException;
import com.example.cms.model.entity.Shoe;
import com.example.cms.model.repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ShoeController {
    @Autowired
    private final ShoeRepository repository;

    public ShoeController(ShoeRepository repository) {
        this.repository = repository;
    }

    @GetMapping({"/shoes"})
    List<Shoe> retrieveAllShoes() {
        return this.repository.findAll();
    }


    @GetMapping({"/shoes/{shoeId}"})
    List<Shoe> retreiveShoe(@PathVariable("shoeId") Long shoeId) { return this.repository.findShoeList(shoeId);}
    /*
    @GetMapping({"/shoes/brand/{brand}"})
    List<Shoe> searchShoe(@PathVariable("brand") String brand) {
        return this.repository.findBrand(brand);
    }
    @GetMapping({"/shoes/gender/{gender}"})
    List<Shoe> searchGender(@PathVariable("gender") String gender) {
        return this.repository.findGender(gender);
    }
    @GetMapping({"/shoes/type/{type}"})
    List<Shoe> searchType(@PathVariable("type") String type) {
        return this.repository.findType(type);
    }

    @GetMapping({"/shoes/price/{lowerP}-{upperP}"})
    List<Shoe> searchPrice(@PathVariable("lowerP") float lowerP,@PathVariable("upperP") float upperP) {
        return this.repository.findPriceRange(lowerP,upperP);
    }

    @GetMapping({"/shoes/color/{color}"})
    List<Shoe> searchColor(@PathVariable("color") String searchColor) {
        return this.repository.findColor(searchColor);
    }

    @GetMapping({"/shoes/size/{size}"})
    List<Shoe> searchSize(@PathVariable("size") float size) {
        return this.repository.findSize(size);
    }

     */
}

