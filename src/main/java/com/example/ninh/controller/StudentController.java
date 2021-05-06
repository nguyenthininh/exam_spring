package com.example.ninh.controller;

import com.example.ninh.entity.StudentEntity;
import com.example.ninh.model.BaseResponse;
import com.example.ninh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
        @Autowired StudentService studentService;
    @GetMapping("/list")
    public String getStudent(ModelMap modelMap) {
        List<StudentEntity> list = (List<StudentEntity>) studentService.findAll();
        modelMap.addAttribute("students",studentService.findAll());
        return "index";
    }
    @GetMapping("/create")
    public String createStudent(ModelMap modelMap) {
        return "create";
    }
    @PostMapping("/create")
    public String create(Model model, @RequestParam Map<String, String> params) {

        String studentid = params.get("studentid");
        String name = params.get("name");
        Integer gender = Integer.valueOf(params.get("gender"));
        String email = params.get("email");
        Integer phone = Integer.valueOf(params.get("phone"));
        String birth = params.get("birth");
        String nativeland = params.get("nativeland");
        String password = params.get("password");
        if(studentid.isEmpty()||name.isEmpty()||gender == null||email.isEmpty()||phone == null||birth.isEmpty()||nativeland.isEmpty()||password.isEmpty()){
            String result = " field are empty!";
            model.addAttribute("result", result);
            return "result";
        }
        else {
            StudentEntity p = new StudentEntity(name,studentid,gender,email,birth,phone,nativeland,password);
            studentService.createStudent(p);
            String result = "Success";
            model.addAttribute("result", result);
            return "result";
        }

    }

//
//    @PostMapping
//    public BaseResponse createProduct(@RequestBody StudentService product) {
//        BaseResponse res = new BaseResponse();
//        res.data = studentService.createProduct(product);
//        return res;
//    }
//
//    @DeleteMapping("/delete")
//    public BaseResponse deleteProduct(@RequestParam("id") Integer id){
//        BaseResponse res = new BaseResponse();
//        studentService.DeleteByid(id);
//        return res;
//    }

}
