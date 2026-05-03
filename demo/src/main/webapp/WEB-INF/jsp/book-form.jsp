<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Form</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        input[type="text"], select { width: 300px; padding: 8px; }
        button { padding: 10px 15px; background: #28a745; color: white; border: none; border-radius: 5px; cursor: pointer; }
    </style>
</head>
<body>
    <h2>Save Book Details</h2>

    <!-- The form sends data to our /books/save URL in the Controller -->
    <form action="/books/save" method="post">
        
        <!-- Hidden ID field so Spring knows if it's updating an existing book or making a new one -->
        <input type="hidden" name="id" value="${book.id}" />

        <div class="form-group">
            <label>Title:</label>
            <input type="text" name="title" value="${book.title}" required />
        </div>

        <div class="form-group">
            <label>Genre:</label>
            <input type="text" name="genre" value="${book.genre}" required />
        </div>

        <div class="form-group">
            <label>Author:</label>
            <select name="author.id" required>
                <!-- Loop to create a dropdown list of authors -->
                <c:forEach var="author" items="${authors}">
                    <option value="${author.id}" ${author.id == book.author.id ? 'selected' : ''}>
                        ${author.name} (${author.nationality})
                    </option>
                </c:forEach>
            </select>
        </div>

        <button type="submit">Save Book</button>
        <a href="/books" style="margin-left: 10px; text-decoration: none; color: #dc3545;">Cancel</a>
    </form>
</body>
</html>