    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<!DOCTYPE html>
<html>
<head>
<title>Student Management</title>
<style>
    body{
   
        width: 100%;
        height: 100vh;
margin: 0;
        padding: 0;
        box-sizing: border-box;
       background-color: rgb(255, 255, 255);
    
    }
.container{
        width: 100%;
        height: 100vh;
        display: flex;
     
        flex-direction: column;
        align-items: center;
        justify-items: center;

        table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}
tr:nth-child(even) {background-color: #f2f2f2;}
td a ,a{
    border: 1px solid green;
    padding: 7px 15px;
    text-decoration: none;
    color: black;
}
#a1{
    background-color: green;
}#a2{
    background-color: red;
}
</style>
</head>
  <body>

        <div class="container">  <h1>Students List</h1>
            <table border="2" width="70%" cellpadding="2">
            <tr><th>Id</th><th>Name</th><th>Email</th><th>Number</th><th>Address<th>Edit</th><th>Delete</th></tr>
            <c:forEach var="student" items="${list}"> 
            <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.number}</td>
            <td>${student.address}</td>
            <td><a id="a1" href="editstudent/${student.id}">Edit</a></td>
            <td  ><a id="a2" href="deletestudent/${student.id}">Delete</a></td>
            </tr>
            </c:forEach>
            </table>
            <br/>
            <a id="a" href="studentform">Add New Student</a></div>
        
                
        
    </body>
    </html>
