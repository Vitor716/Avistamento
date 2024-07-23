package com.example.avistamento;

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfig {

    @Bean
    public VertexAI vertexAI(){
        return new VertexAI("gemini-test-430314", "southamerica-east1");
    }

    @Bean
    public GenerativeModel generativeModel(VertexAI vertexAI){
        return new GenerativeModel("gemini-pro-vision", vertexAI);
    }
}
