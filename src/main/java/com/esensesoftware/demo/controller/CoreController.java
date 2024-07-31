package com.esensesoftware.demo.controller;

import com.esensesoftware.demo.entity.Category;
import com.esensesoftware.demo.service.CategoryService;
import com.esensesoftware.demo.service.ItemService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author KTartir
 * @version 1.0
 */
@RestController
@RequestMapping("categories/")
@AllArgsConstructor
@Slf4j
public class CoreController {
    private HttpServletResponse response;
    private CategoryService categoryService;

    @GetMapping("/getCategories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/createCategories")
    public List<Category> createCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
        return categoryService.getAllCategories();
    }

    @PostMapping("/updateCategories/{id}")
    public List<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        categoryService.updateCategory(id, categoryDetails);
        return categoryService.getAllCategories();
    }

    @GetMapping("/exportEMartDataPdf")
    public void exportEMartDataPdf() throws JRException, IOException {
        categoryService.exportEMartDataPdf(response);
    }

}//CoreController
