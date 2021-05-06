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
    @PostMapping("/create")
    public String create(Model model, @RequestParam Map<String, String> params) {

        String studentid = params.get("studentid");
        String name = params.get("name");
        String gender = params.get("gender");
        String email = params.get("email");
        String phone = params.get("phone");
        String birth = params.get("birth");
        String nativeland = params.get("nativeland");
        String password = params.get("password");
        if(studentid.isEmpty()||name.isEmpty()||gender.isEmpty()||email.isEmpty()||phone.isEmpty()||birth.isEmpty()||nativeland.isEmpty()||password.isEmpty()){
            String result = "Some field are empty!";
            model.addAttribute("result", result);
            return "result";
        }
        else {
            StudentEntity p = new StudentEntity(name,studentid,gender,email,phone,password,birth,nativeland);
            studentService.create(p);
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
