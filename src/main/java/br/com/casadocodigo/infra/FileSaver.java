package br.com.casadocodigo.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Component
public class FileSaver {

    @Autowired
    private HttpServletRequest httpServletRequest;

    public String write(String baseFolder, MultipartFile multipartFile) {
        try {
            String realPath = httpServletRequest.getServletContext().getRealPath("/" + baseFolder);
            String path = realPath + "/" + multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File(path));
            return path;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
