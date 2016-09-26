<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>title</title>
  </head>

  <body>
  <h2>signin</h2>
  <form method="post" action="/auth/signin">
    <input type="text" name="j_username" id="j_username" value="user" /><br />
    <input type="password" name="j_password" id="j_password" value="password" /><br />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" />
  </form>
  <hr/>
  </body>
</html>