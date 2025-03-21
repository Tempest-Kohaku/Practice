<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Even Odd Checker</title>
    </head>
    <body>
        <form method = "get">
            Enter a Number: <input type = "number" name = "num"/>
            <input type = "submit" value = "Find"/>
        </form>
        <%
            String numstr = request.getParameter("num");
            if (numstr != null && !numstr.isEmpty()){    
                int num = Integer.parseInt(numstr);
                if (num % 2 == 0){
                    out.println("The given number: " + num + " is an Even Number");
                } else {
                    out.println("The given number: " + num + " is an Odd Number");
                }
            }
        %>
    </body>
</html>
