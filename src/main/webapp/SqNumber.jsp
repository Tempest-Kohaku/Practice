<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sum of Square Number</title>
    </head>
    <body>
        <form method = "get">
            Enter a Number: <input type = "number" name = "num"/>
            <input type = "submit" value = "Find"/>
        </form>
        <%
            String numstr = request.getParameter("num");
            int sum = 0;
            if (numstr != null && !numstr.isEmpty()) {
                int num = Integer.parseInt(numstr);
                for (int i = 1; i <= num; i++) {
                    sum += i*i;
                }
                out.println("Sum of squares of: " + num + " integers is: " + sum);
            }
        %>
    </body>
</html>
