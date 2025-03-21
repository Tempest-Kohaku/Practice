<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fibonacci Series</title>
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
                int n1 = 0;
                int n2 = 1;
                int n3;
                for (int i = 1; i <= num; i++) {
                    if (i == 1) {
                        out.println(n1 + " " + n2 + " ");
                    }
                    n3 = n1 + n2;
                    out.println(n3 + " ");
                    n1 = n2;
                    n2 = n3;
                }
            }
        %>
    </body>
</html>
