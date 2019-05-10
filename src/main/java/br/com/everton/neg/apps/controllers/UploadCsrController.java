package br.com.everton.neg.apps.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.everton.neg.apps.models.Header;

@Controller
public class UploadCsrController {

    //Salva o upload em uma pasta temporaria
	// atencao no heroku , tem que usar tmp
	
    private static String UPLOADED_FOLDER = "/tmp/";
    
    @GetMapping("/csr")
    public String csr() {
        return "csr";
    }
    
    @PostMapping("/csr") //
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("retorno", "Por favor selecione um arquivo.");
            return "redirect:/csr";
        }

        try {

            // Pega o arquivo e salva em /tmp
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
}
