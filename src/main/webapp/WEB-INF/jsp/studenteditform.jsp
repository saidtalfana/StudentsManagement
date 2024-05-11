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
        justify-content: center;
        flex-direction: column;
        align-items: center;
        justify-items: center;

        .firstform{
            width: 50%;
        }
        table{
        background-image: url("https://images.pexels.com/photos/311039/pexels-photo-311039.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
background-attachment: fixed;
background-position: center;
background-repeat: no-repeat;
background-size: contain;
            background-color: rgb(117, 203, 222);
            border-radius: 12px;
            /* border-style: none; */
            width: 100%;
              height: 100%; 
               

        } 
       table tr{
           height: 70px;
           width: 100%;
           display: flex;
           justify-content: space-evenly;
           align-items: center;
        }
      table tr td   {
  text-align: center;
  width: 100%;
  height: 20px;
  
}
.input {
    width: 91%;
    height: 100%;
    background-color: none;
    border-style: none;
}

</style>
</head>
  <body>

    <div class="container">
		<h1>Edit Student</h1>
       <form:form class="firstform" method="POST" action="/Student/editsave">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="id" /></td>
         </tr> 
         <tr>  
          <td>Name : </td> 
          <td><form:input class="input" path="name"  /></td>
         </tr>  
         <tr>  
          <td>Email :</td>  
          <td><form:input class="input" path="email" /></td>
         </tr> 
          <tr>  
          <td>Number :</td>  
          <td><form:input class="input" path="number" /></td>
         </tr> 
         <tr>  
          <td>Address :</td>  
          <td><form:input class="input" path="address" /></td>
         </tr> 
         
         <tr>  
          <td> </td>  
          <td><input class="input" type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form> </div>
    
            
    
  </body>
</html> 
