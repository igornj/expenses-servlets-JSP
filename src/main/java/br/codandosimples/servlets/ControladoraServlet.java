package br.codandosimples.servlets;

import br.codandosimples.acoes.Acao;
import br.codandosimples.acoes.AdicionaDespesa;
import br.codandosimples.acoes.ListaDespesas;
import br.codandosimples.acoes.RemoveDespesa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controladora")
public class ControladoraServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try {
            String acaoNome = req.getParameter("acao");
            String pacote = "br.codandosimples.acoes."; //the dot here it's important, otherwise it won't find the class inside package;

            System.out.println("A ação executada foi: " + acaoNome);
            System.out.println("Path da classForname: " + pacote + acaoNome);
            Class<?> classe = Class.forName(pacote + acaoNome);
            Acao acao = (Acao) classe.newInstance();

            String resultado = acao.executa(req, res);

            RequestDispatcher dispatcher = req.getRequestDispatcher(resultado);
            dispatcher.forward(req, res);

//            if(acao.equals("ListaDespesas")){
//                new ListaDespesas().executa(req, res);
//            } else if(acao.equals("AdicionaDespesa")){
//                new AdicionaDespesa().executa(req, res);
//            } else if(acao.equals("RemoveDespesa")){
//                new RemoveDespesa().executa(req, res);
//            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }


    }
}
