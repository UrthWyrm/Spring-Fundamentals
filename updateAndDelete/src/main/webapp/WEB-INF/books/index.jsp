<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<!DOCTYPE html>  
<div class="container">
<h1>All Books</h1>
<table class="table table-striped">
    <thead>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Language</th>
            <th># of Pages</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.title}</td>
            <td>${book.description}</td>
            <td>${book.language}</td>
            <td>${book.numberOfPages}</td>
            <td>
            <a href="/books/${book.id}/show" class="btn btn-secondary btn-sm" role="button" aria-pressed="true">Show</a>
            <a href="/books/${book.id}/update" class="btn btn-primary btn-sm" role="button" aria-pressed="true">Update</a>
            <a href="/books/${book.id}/delete" class="btn btn-dark btn-sm" role="button" aria-pressed="true">Delete</a>
            </td>
            
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/books/new">New Book</a>
</div>