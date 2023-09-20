package com.example.demo.service;

import com.example.demo.model.Element;
import com.example.demo.repository.ElementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ElementService {
    private final ElementRepository elementRepository;

    public List<Element> getAllByArr(Long id) {
        return elementRepository.getAllByArr(id);
    }
    public List<Element> getAll() {
        return elementRepository.findAll();
    }
    public void save(Element element) {
        elementRepository.save(element);
    }
    public Long getMaxArr() { return elementRepository.getMaxArr(); }
}