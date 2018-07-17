package br.com.everton.neg.apps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.everton.neg.apps.models.Header;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "/tmp/";

    @GetMapping("/header")
    public String index() {
        return "header";
    }

    @PostMapping("/header") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("retorno", "Por favor selecione um arquivo.");
            return "redirect:/header";
        }

        try {

            // Get the file and save it somewhere
    	    byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

            Files.write(path, bytes);
            

			Header entrada = new Header();
			String buffer = Header.preparaArquivo(path.toString());
            redirectAttributes.addFlashAttribute("retorno","" + entrada.getHeader(buffer));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/header";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}