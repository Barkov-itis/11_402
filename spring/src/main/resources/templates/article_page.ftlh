<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Articles of User</title>
</head>
<body>
<h1>Add New Article for User #${userId}</h1>
<div>
    <form action="/users/${userId}/articles" method="post">
        <input name="name" type="text" placeholder="Name">
        <input name="text" type="text" placeholder="Description">
        <input type="submit" value="ADD">
    </form>
</div>
<div>
    <table>
        <tr>
            <th>Article</th>
            <th>text</th>
            <th>click</th>
            <th>likes</th>
        </tr>
        <#list articles as article>
            <tr>
                <td>${article.id}</td>
                <td>${article.text}</td>
                <td><form action="/users/${userId}/article/${article.id}/like" method="post">
                        <input type="submit" value="Like">
                    </form></td>
                <td>${article.likesCount}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>