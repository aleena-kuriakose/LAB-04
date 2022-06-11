<%-- 
    Document   : editnote
    Created on : Jun 9, 2022, 11:09:15 PM
    Author     : Aleena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=<device-width>, initial-scale=1.0">
    <title>Edit Title</title>
</head>
<body>
    <form action="note" method="POST">
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <div>
            <label>Title:</label>
            <input type="text" name="edit_title" value="${notes.title}">
            <br>
            <label> Contents: </label>
            <textarea name="edit_note" placeholder="${notes.content}"></textarea>
            <br>
            <br>
            <input type="submit"  value="Save">
        </div>
    </form>
</body>
</html>
