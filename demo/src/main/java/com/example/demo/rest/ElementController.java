package com.example.demo.rest;

import com.example.demo.model.Element;
import com.example.demo.service.ElementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ElementController {
    @Autowired
    private final ElementService elementService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Element>> getAllByArr(@PathVariable("id") Long id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Element> elements = this.elementService.getAllByArr(id);
        return new ResponseEntity<>(elements, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Element>> getAll() {

        List<Element> elements = this.elementService.getAll();
        return new ResponseEntity<>(elements, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Element> saveElement(@RequestBody Element element) {
        HttpHeaders headers = new HttpHeaders();

        if (element == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.elementService.save(element);
        return new ResponseEntity<>(element, headers, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/maxArr", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Long> getMaxArr() {

        Long maxArr = this.elementService.getMaxArr();
        return new ResponseEntity<>(maxArr, HttpStatus.OK);
    }

}
