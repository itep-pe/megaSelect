$(document).ready(function () {
    $("#myAjaxRequestForm").submit(function (e) {
        e.preventDefault();
    });
    $('select[name=sltempreendimento]').on('change', function () {
        dataString = $("#myAjaxRequestForm").serialize();
        var empreendimento = $('select[name=sltempreendimento]').val();
        dataString = "empreendimento=" + empreendimento;
        $.ajax({
            type: "POST",
            url: "megaSelect",
            data: dataString,
            success: function (data, textStatus, jqXHR) {
                $("select[name=contrato] option").remove();
                $("select[name=eixo] option").remove();
                $("select[name=servico] option").remove();
                $("select[name=campanha] option").remove();
                var pegadados = data.split("/");
                for (var i = 0; i < pegadados.length - 1; i++) {
                    var idContrato = pegadados[i].split("-")[0];
                    var descricaoContrato = pegadados[i].split("-")[1];
//                    var placa = pegadados[i].split("-")[2];
                    $("select[name=contrato]").append("<option id='" + i + "'value='" + idContrato + "'>" + "ID: " + idContrato + " - " + "Descrição: " + descricaoContrato + '</option>');
                }
            },
            //If there was no resonse from the server
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("Algo ruim aconteceu: " + textStatus);
                $("#ajaxResponse1").html(jqXHR.responseText);
            },
            //capture the request before it was sent to server
            beforeSend: function (jqXHR, settings) {
                //adding some Dummy data to the request
                settings.data += "&dummyData=whatever";
                //disable the button until we get the response
            },
            //this is called after the response or error functions are finsihed
            //so that we can take some action
            complete: function (jqXHR, textStatus) {
                //enable the button 
            }
        });
    });

    $('select[name=contrato]').on('change', function () {
        dataString = $("#myAjaxRequestForm").serialize();
        var contrato = $('select[name=contrato]').val();
        dataString = "contrato=" + contrato;
        $.ajax({
            type: "POST",
            url: "megaSelect",
            data: dataString,
            success: function (data, textStatus, jqXHR) {
                $("select[name=eixo] option").remove();
                $("select[name=servico] option").remove();
                $("select[name=campanha] option").remove();
                var pegadados = data.split("/");
                for (var i = 0; i < pegadados.length - 1; i++) {
                    var idEixo = pegadados[i].split("-")[0];
                    var descricaoEixo = pegadados[i].split("-")[1];
//                    var placa = pegadados[i].split("-")[2];
                    $("select[name=eixo]").append("<option id='" + i + "'value='" + idEixo + "'>" + "ID: " + idEixo + " - " + "Descrição: " + descricaoEixo + '</option>');
                }
            },
            //If there was no resonse from the server
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("Algo ruim aconteceu: " + textStatus);
                $("#ajaxResponse2").html(jqXHR.responseText);
            },
            //capture the request before it was sent to server
            beforeSend: function (jqXHR, settings) {
                //adding some Dummy data to the request
                settings.data += "&dummyData=whatever";
                //disable the button until we get the response
            },
            //this is called after the response or error functions are finsihed
            //so that we can take some action
            complete: function (jqXHR, textStatus) {
                //enable the button 
            }
        });
    });

    $('select[name=eixo]').on('change', function () {
        dataString = $("#myAjaxRequestForm").serialize();
        var eixo = $('select[name=eixo]').val();
        dataString = "eixo=" + eixo;
        $.ajax({
            type: "POST",
            url: "megaSelect",
            data: dataString,
            success: function (data, textStatus, jqXHR) {
                $("select[name=servico] option").remove();
                $("select[name=campanha] option").remove();
                var pegadados = data.split("/");
                for (var i = 0; i < pegadados.length - 1; i++) {
                    var idServico = pegadados[i].split("-")[0];
                    var descricaoServico = pegadados[i].split("-")[1];
//                    var placa = pegadados[i].split("-")[2];
                    $("select[name=servico]").append("<option id='" + i + "'value='" + idServico + "'>" + "ID: " + idServico + " - " + "Descrição: " + descricaoServico + '</option>');
                }
            },
            //If there was no resonse from the server
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("Algo ruim aconteceu: " + textStatus);
                $("#ajaxResponse3").html(jqXHR.responseText);
            },
            //capture the request before it was sent to server
            beforeSend: function (jqXHR, settings) {
                //adding some Dummy data to the request
                settings.data += "&dummyData=whatever";
                //disable the button until we get the response
            },
            //this is called after the response or error functions are finsihed
            //so that we can take some action
            complete: function (jqXHR, textStatus) {
                //enable the button 
            }
        });
    });

    $('select[name=servico]').on('change', function () {
        dataString = $("#myAjaxRequestForm").serialize();
        var servico = $('select[name=servico]').val();
        dataString = "servico=" + servico;
        $.ajax({
            type: "POST",
            url: "megaSelect",
            data: dataString,
            success: function (data, textStatus, jqXHR) {
                $("select[name=campanha] option").remove();
                var pegadados = data.split("/");
                for (var i = 0; i < pegadados.length - 1; i++) {
                    var idCampanha = pegadados[i].split("-")[0];
                    var descricaoCampanha = pegadados[i].split("-")[1];
//                    var placa = pegadados[i].split("-")[2];
                    $("select[name=campanha]").append("<option id='" + i + "'value='" + idCampanha + "'>" + "ID: " + idCampanha + " - " + "Descrição: " + descricaoCampanha + '</option>');
                }
            },
            //If there was no resonse from the server
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("Algo ruim aconteceu: " + textStatus);
                $("#ajaxResponse4").html(jqXHR.responseText);
            },
            //capture the request before it was sent to server
            beforeSend: function (jqXHR, settings) {
                //adding some Dummy data to the request
                settings.data += "&dummyData=whatever";
                //disable the button until we get the response
            },
            //this is called after the response or error functions are finsihed
            //so that we can take some action
            complete: function (jqXHR, textStatus) {
                //enable the button 
            }
        });
    });
});