package com.example.avistamento;

import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.ContentMaker;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.PartMaker;
import com.google.cloud.vertexai.generativeai.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/gemini")
@RequiredArgsConstructor
public class GeminiProVisionController {

    private final GenerativeModel generativeModel;

    @PostMapping
    public String file(@RequestParam("file") MultipartFile file) throws IOException {
        String question = "Que animal é, se não for um animal poderia retornar uma mansagem padrão de erro?";
        GenerateContentResponse generateContentResponse = this.generativeModel.generateContent(
                ContentMaker.fromMultiModalData(
                        PartMaker.fromMimeTypeAndData(file.getContentType(), file.getBytes()),
                        question
                )
        );
        return ResponseHandler.getText(generateContentResponse);
    }
}
