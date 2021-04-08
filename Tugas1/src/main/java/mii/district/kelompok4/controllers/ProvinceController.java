/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.district.kelompok4.controllers;

import mii.district.kelompok4.models.Province;
import mii.district.kelompok4.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("province")
public class ProvinceController {
    
    @Autowired
    private ProvinceService provinceService;
    
    @GetMapping
    public String getAll(Model model){
        model.addAttribute("provinces", provinceService.getAll());
        return "province";
    }
    
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("province", provinceService.getById(id));
        return "form-edit-province";
    }
    
    @GetMapping("/add")
    public String addForm(Model model) {
        Province province = new Province();
        model.addAttribute("province", province);
        return "form-edit-province";
    }
    
    @PostMapping("/add")
    public String create(@ModelAttribute("province") Province province) {
        provinceService.create(province);
        return "redirect:/province";
    }
    
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("province") Province province) {
        provinceService.update(id,province);
        return "redirect:/province";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable ("id") Integer id,@ModelAttribute("province") Province province){
        provinceService.delete(id);
        return "redirect:/province";
    }
}