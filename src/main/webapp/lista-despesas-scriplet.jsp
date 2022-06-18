<%@ page import="java.sql.Connection" %>
<%@ page import="br.com.codandosimples.infra.ConnectionFactory" %>
<%@ page import="br.com.codandosimples.dao.DespesaDAO" %>
<%@ page import="br.com.codandosimples.model.Despesa" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Lista de depesas</title>
    <style>
        table{
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th{
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even){
            background-color: #dddddd;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>Descrição</th>
            <th>Data</th>
            <th>Valor</th>
            <th>Categoria</th>
        </tr>


    <%
//        String mensagem = "Aprendendo scriptlet";
        Connection connection = ConnectionFactory.getConnection();
        DespesaDAO dao = new DespesaDAO(connection);
        List<Despesa> despesas = dao.findAll();

        for(Despesa despesa : despesas){
    %>
        <tr>
            <td><%=despesa.getDescricao()%></td>
            <td><%=despesa.getData()%></td>
            <td><%=despesa.getValor()%></td>
            <td><%=despesa.getCategoria()%></td>
        </tr>
    <%
        }
    %>
    </table>


    <h1>
<%--        <%--%>
<%--            out.println(mensagem);--%>
<%--        %>--%>
<%--        <%= mensagem%>--%>
    </h1>

</body>
</html>
