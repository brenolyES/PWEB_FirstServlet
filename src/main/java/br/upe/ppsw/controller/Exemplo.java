package br.upe.ppsw.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.upe.ppsw.model.Cep;

@WebServlet("/exemplo")
public class Exemplo extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.adviceslip.com/advice";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter print = resp.getWriter();
        print.println(response.getBody());
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RestTemplate restTemplate = new RestTemplate();
        Cep cep = new Gson().fromJson(req.getReader(), Cep.class);
        String url = "https://viacep.com.br/ws/" + cep.getCep() + "/json/";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter print = resp.getWriter();
        print.println(response.getBody());
    }

}
