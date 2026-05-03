<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Library System</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
        th { background-color: #f4f4f4; }
        .btn { padding: 8px 15px; background: #28a745; color: white; text-decoration: none; border-radius: 5px; }
        .btn-edit { background: #007bff; }
    </style>
</head>
<body>
    <h2>Library Book List</h2>
    
    <!-- Link to add a new book -->
    <a href="/books/add" class="btn">Add New Book</a>

    <table>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Author Name</th>
            <th>Actions</th>
        </tr>
        <!-- This loop goes through the books we sent from the Controller -->
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.genre}</td>
                <td>${book.author.name}</td>
                <td>
                    <!-- Link to edit this specific book -->
                    <a href="/books/edit/${book.id}" class="btn btn-edit">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>