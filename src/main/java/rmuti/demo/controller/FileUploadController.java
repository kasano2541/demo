package rmuti.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rmuti.demo.model.service.DatabaseFileService;
import rmuti.demo.model.table.DatabaseFile;
import rmuti.demo.model.table.Response;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



@RestController
public class FileUploadController {

    // example อาจารย์---------------------------------------------------------------------------------

//
//    @PostMapping("/savingFile")
//    public Object saveImage(@RequestParam MultipartFile file) {
//        File fileContent = new File("path D:/Work/images");
//        BufferedOutputStream buf = new BufferedOutputStream(new FileOutputStream(fileContent));
//        byte[] bytes = file.getBytes();
//        buf.write(bytes);
//        buf.close();
//        return "hello";
//    }

    //-------------------------------------------------------------------------------------------------

    @Autowired
    private DatabaseFileService fileStorageService;

    @PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam("image") MultipartFile file) {
        DatabaseFile fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName.getFileName())
                .toUriString();

        return new Response(fileName.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List< Response > uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }





}
