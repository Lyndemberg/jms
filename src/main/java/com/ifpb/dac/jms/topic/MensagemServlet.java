package com.ifpb.dac.jms.topic;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lyndemberg
 */
public class MensagemServlet extends HttpServlet {

    @Inject
    private EnviarMensagem produtor;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String setor = request.getParameter("setor");
        String mensagem = request.getParameter("mensagem");
        this.produtor.enviar(setor, mensagem);
    }
    
}
