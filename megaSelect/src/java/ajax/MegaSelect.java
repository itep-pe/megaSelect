/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jefferson.lima
 */
@WebServlet(name = "MegaSelect", urlPatterns = {"/megaSelect"})
public class MegaSelect extends HttpServlet {

    public final class Empreendimento implements Serializable {

        private String id;
        private String descricao;

        public Empreendimento(String id, String descricao) {
            this.setId(id);
            this.setDescricao(descricao);
        }

        public String getId() {
            return this.id;
        }

        public String getDescricao() {
            return this.descricao;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
    }

    public final class Contrato implements Serializable {

        private String id;
        private String descricao;
        private Empreendimento empreendimento;

        public Contrato(String id, String descricao, Empreendimento empreendimento) {
            this.setId(id);
            this.setDescricao(descricao);
        }

        public String getId() {
            return this.id;
        }

        public String getDescricao() {
            return this.descricao;
        }

        public Empreendimento getEmpreendimento() {
            return this.empreendimento;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public void setEmpreendimento(Empreendimento empreendimento) {
            this.empreendimento = empreendimento;
        }
    }

    public final class Eixo implements Serializable {

        private String id;
        private String descricao;
        private Contrato contrato;

        public Eixo(String id, String descricao, Contrato contrato) {
            this.id = id;
            this.descricao = descricao;
            this.contrato = contrato;
        }

        public String getId() {
            return this.id;
        }

        public String getDescricao() {
            return this.descricao;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public Contrato getContrato() {
            return contrato;
        }

        public void setContrato(Contrato contrato) {
            this.contrato = contrato;
        }
    }

    public final class Servico implements Serializable {

        private String id;
        private String descricao;
        private Eixo eixo;

        public Servico(String id, String descricao, Eixo eixo) {
            this.id = id;
            this.descricao = descricao;
            this.eixo = eixo;
        }

        public String getId() {
            return this.id;
        }

        public String getDescricao() {
            return this.descricao;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public Eixo getEixo() {
            return eixo;
        }

        public void setEixo(Eixo eixo) {
            this.eixo = eixo;
        }
    }

    public final class Campanha implements Serializable {

        private String id;
        private String descricao;
        private Servico servico;

        public Campanha(String id, String descricao, Servico servico) {
            this.id = id;
            this.descricao = descricao;
            this.servico = servico;
        }

        public Campanha(String id, String descricao) {
            this.setId(id);
            this.setDescricao(descricao);
            this.servico = null;
        }

        public String getId() {
            return this.id;
        }

        public String getDescricao() {
            return this.descricao;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public Servico getServico() {
            return servico;
        }

        public void setServico(Servico servico) {
            this.servico = servico;
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        StringBuilder stringBuilderContrato = new StringBuilder("");
        StringBuilder stringBuilderEixo = new StringBuilder("");
        StringBuilder stringBuilderServico = new StringBuilder("");
        StringBuilder stringBuilderCampanha = new StringBuilder("");

        String empreendimento = request.getParameter("empreendimento");
        String contrato = request.getParameter("contrato");
        String eixo = request.getParameter("eixo");
        String servico = request.getParameter("servico");
        String campanha = request.getParameter("campanha");

        if (empreendimento != null) {
            List<Contrato> listaContrato = this.manipulaContratoEEmpreedimento(empreendimento);

            for (int i = 0; i < listaContrato.size(); i++) {
                stringBuilderContrato.append(listaContrato.get(i).getId() + "-" + listaContrato.get(i).getDescricao() + "/");
            }
            out.write(stringBuilderContrato.toString());
            out.close();

        } else if (contrato != null) {
            List<Contrato> listaContrato = this.manipulaContratoEEmpreedimento(empreendimento);
            List<Eixo> listaEixo = this.manipulaEixo(contrato, listaContrato);

            for (int i = 0; i < listaEixo.size(); i++) {
                stringBuilderEixo.append(listaEixo.get(i).getId() + "-" + listaEixo.get(i).getDescricao() + "/");
            }
            out.write(stringBuilderEixo.toString());
            out.close();

        } else if (eixo != null) {
            List<Contrato> listaContrato = this.manipulaContratoEEmpreedimento(empreendimento);
            List<Eixo> listaEixo = this.manipulaEixo(contrato, listaContrato);
            List<Servico> listaServico = this.manipulaServico(eixo, listaEixo);

            for (int i = 0; i < listaServico.size(); i++) {
                stringBuilderServico.append(listaServico.get(i).getId() + "-" + listaServico.get(i).getDescricao() + "/");
            }
            out.write(stringBuilderServico.toString());
            out.close();

        } else if (servico != null) {
            List<Contrato> listaContrato = this.manipulaContratoEEmpreedimento(empreendimento);
            List<Eixo> listaEixo = this.manipulaEixo(contrato, listaContrato);
            List<Servico> listaServico = this.manipulaServico(eixo, listaEixo);
            List<Campanha> listaCampanha = this.manipulaCampanha(servico, listaServico);

            for (int i = 0; i < listaCampanha.size(); i++) {
                stringBuilderCampanha.append(listaCampanha.get(i).getId() + "-" + listaCampanha.get(i).getDescricao() + "/");
            }
            out.write(stringBuilderCampanha.toString());
            out.close();
        }

    }

    private List<Contrato> manipulaContratoEEmpreedimento(String idEmpreendimento) {
        List<Empreendimento> empreendimento = new ArrayList<Empreendimento>();

        empreendimento.add(new Empreendimento("E1", "Emprrendimento 01"));
        empreendimento.add(new Empreendimento("E2", "Emprrendimento 02"));
        empreendimento.add(new Empreendimento("E3", "Emprrendimento 03"));
        System.out.println("Aqui " +  empreendimento.get(0).getId());

        List<Contrato> contrato = new ArrayList<Contrato>();

        contrato.add(new Contrato("C1", "Contrato 01", empreendimento.get(0)));
        contrato.add(new Contrato("C2", "Contrato 02", empreendimento.get(1)));
        contrato.add(new Contrato("C3", "Contrato 03", empreendimento.get(2)));

        List<Contrato> novoContrato = new ArrayList<Contrato>();
        
        System.out.println("Agora " + contrato.get(0).getDescricao());
//        System.out.println("Agora será? " + contrato.get(0).getEmpreendimento().getDescricao());

        for (int i = 0; i < contrato.size(); i++) {
            novoContrato.add(contrato.get(i));
            
        }

        return novoContrato;
    }

    private List<Eixo> manipulaEixo(String idContrato, List<Contrato> listaContrato) {
        List<Eixo> eixo = new ArrayList<Eixo>();

        eixo.add(new Eixo("E1", "Eixo 01", listaContrato.get(0)));
        eixo.add(new Eixo("E2", "Eixo 02", listaContrato.get(1)));
        eixo.add(new Eixo("E3", "Eixo 03", listaContrato.get(2)));

        List<Eixo> novoEixo = new ArrayList<Eixo>();

        for (int i = 0; i < eixo.size(); i++) {
            novoEixo.add(eixo.get(i));
//            if (eixo.get(i).getContrato().getId().equals(idContrato)) {
//                novoEixo.add(eixo.get(i));
//            }
        }

        return novoEixo;
    }

    private List<Servico> manipulaServico(String idEixo, List<Eixo> listaEixo) {
        List<Servico> servico = new ArrayList<Servico>();

        servico.add(new Servico("S1", "Serviço 01", listaEixo.get(0)));
        servico.add(new Servico("S2", "Serviço 02", listaEixo.get(1)));
        servico.add(new Servico("S3", "Serviço 03", listaEixo.get(2)));

        List<Servico> novoServico = new ArrayList<Servico>();

        for (int i = 0; i < servico.size(); i++) {
            novoServico.add(servico.get(i));
//            if (servico.get(i).getEixo().getId().equals(idEixo)) {
//                novoServico.add(servico.get(i));
//            }
        }

        return novoServico;
    }

    private List<Campanha> manipulaCampanha(String idServico, List<Servico> listaServico) {
        List<Campanha> campanha = new ArrayList<Campanha>();

        campanha.add(new Campanha("C1", "Campanha 01", listaServico.get(0)));
        campanha.add(new Campanha("C2", "Campanha 02", listaServico.get(1)));
        campanha.add(new Campanha("C3", "Campanha 03", listaServico.get(2)));

        List<Campanha> novaCampanha = new ArrayList<Campanha>();

        for (int i = 0; i < campanha.size(); i++) {
            novaCampanha.add(campanha.get(i));
//            if (campanha.get(i).getServico().getId().equals(idServico)) {
//                novaCampanha.add(campanha.get(i));
//            }
        }

        return novaCampanha;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
