package com.unifacisa.Exercicio04;


import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unifacisa.Exercicio04.Pessoa;

public class App 
{
    public static void main( String[] args ) throws JsonGenerationException, JsonMappingException, IOException {
    	
    	ObjectMapper mapper = new ObjectMapper();

        // Serialize
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, getPessoas());
        System.out.println(writer);
        
        File jsonFile = new File("pessoas.json");
        mapper.writeValue(jsonFile, getPessoas());

        // Deserialize
        String jsonInput = "[{\"id\":1,\"nome\":\"Lucas\",\"idade\":25,\"email\":\"lucas@example.com\",\"cidade\":\"Sao Paulo\"},"
                + "{\"id\":2,\"nome\":\"Maria\",\"idade\":30,\"email\":\"maria@example.com\",\"cidade\":\"Rio de Janeiro\"},"
                + "{\"id\":3,\"nome\":\"Jose\",\"idade\":28,\"email\":\"jose@example.com\",\"cidade\":\"Recife\"}]";
        List<Pessoa> p = mapper.readValue(jsonInput, new TypeReference<List<Pessoa>>() {});
        System.out.println("Pessoa: " + p);
    }
    private static List<Pessoa> getPessoas() {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        Pessoa p1 = new Pessoa();
        p1.setId(1);
        p1.setNome("Lucas");
        p1.setIdade(25);
        p1.setEmail("lucas@example.com");
        p1.setCidade("Sao Paulo");

        Pessoa p2 = new Pessoa();
        p2.setId(2);
        p2.setNome("Maria");
        p2.setIdade(30);
        p2.setEmail("maria@example.com");
        p2.setCidade("Rio de Janeiro");

        Pessoa p3 = new Pessoa();
        p3.setId(3);
        p3.setNome("Jose");
        p3.setIdade(28);
        p3.setEmail("jose@example.com");
        p3.setCidade("Recife");

        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);

        return pessoas;
    }
}
