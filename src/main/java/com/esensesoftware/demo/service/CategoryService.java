package com.esensesoftware.demo.service;

import com.esensesoftware.demo.entity.Category;
import com.esensesoftware.demo.repository.CategoryRepository;
import com.esensesoftware.demo.utils.CommonUtils;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;
    private DataSource dataSource;


    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long categoryId, Category categoryDetails) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            if (categoryDetails.getCategoryName() != null) {
                category.setCategoryName(categoryDetails.getCategoryName());
            }
            return categoryRepository.save(category);
        } else {
            throw new RuntimeException("Category not found with id " + categoryId);
        }
    }

    public void exportEMartDataPdf(HttpServletResponse response) throws JRException, IOException {
        Map<String, Object> params = new HashMap<>();
        try {
            CommonUtils.generateJasperPdf(response,params,dataSource.getConnection(), "static/reports/demoObjective.jasper");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}//CategoryService