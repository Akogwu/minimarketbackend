package edu.miu.minimarket.controller;

import edu.miu.minimarket.dto.user.AdminDto;
import edu.miu.minimarket.service.user.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
//@CrossOrigin("http://localhost:3000/")

public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping
    public void addAdmin(@RequestBody AdminDto adminDto) {
        adminService.save(adminDto);
    }

}