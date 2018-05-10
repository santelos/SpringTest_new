package com.example.SpringTest.Controllers;

import com.example.SpringTest.Storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService){
        this.storageService = storageService;
    }

//    @GetMapping("/upload")
//    public String listUploadedFiles(Model model){
//
//        model.addAttribute("files",storageService.loadAll().map(
//                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
//                        "serveFile",path.getFileName().toString()).build().toString()));
//
//        return "uploadForm";
//    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        System.out.println("trying to download file " + filename);
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object handleFileUpload(@RequestParam("file") MultipartFile file){
        storageService.store(file);

        Map<String,String> responseMap = new HashMap<>();
        responseMap.put("message","uploaded");
        responseMap.put("file",file.getOriginalFilename());

        return responseMap;
    }

    @RequestMapping(value = "/deleteFile", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public Object handleFileDelete(String filename){

        System.out.println("DELETE - " + filename);
        storageService.delete(filename);

        return "deleted";
    }

}
