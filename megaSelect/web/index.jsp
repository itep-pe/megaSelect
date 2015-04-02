<%-- 
    Document   : index
    Created on : 02/04/2015, 08:47:07
    Author     : jefferson.lima
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="./js/jquery-1.11.2.min.js"></script>
        <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>
        <script src="js/requisicao.js"></script>
    </head>
    <body>
        <p>Preencha os dados seguintes de acordo com a solicitação desejada.</p>

        <form id="myAjaxRequestForm">
            <fieldset>
                <legend>Empreendimento</legend>
                <!-- <label for="nome">Departamento</label> -->
                <select name="sltempreendimento">
                    <option selected> -- Selecione --</option>
                    <option value="E1"> Emprrendimento 01 </option>
                    <option value="E2"> Emprrendimento 02 </option>
                    <option value="E3"> Emprrendimento 03 </option>
                </select>                               
            </fieldset>
            <fieldset>
                <legend>Contrato</legend>
                <!-- <label for="nome">Carros</label> -->
                <div id="ajaxResponse1"></div>
                <select name="contrato">
                    <option selected> -- Selecione --</option>
                </select><br>
            </fieldset>

            <fieldset>
                <legend>Eixo</legend>
                <!-- <label for="nome">Carros</label> -->
                <div id="ajaxResponse2"></div>
                <select name="eixo">
                    <option selected> -- Selecione --</option>
                </select><br>
            </fieldset>

            <fieldset>
                <legend>Serviço</legend>
                <!-- <label for="nome">Carros</label> -->
                <div id="ajaxResponse3"></div>
                <select name="servico">
                    <option selected> -- Selecione --</option>
                </select><br>
            </fieldset>

            <fieldset>
                <legend>Campanha</legend>
                <!-- <label for="nome">Carros</label> -->
                <div id="ajaxResponse4"></div>
                <select name="campanha">
                    <option selected> -- Selecione --</option>
                </select><br>
            </fieldset>
        </form>
    </body>
</html>
