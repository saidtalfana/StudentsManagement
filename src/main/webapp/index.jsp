<!DOCTYPE html>
<html>
<head>
<title>Student Management</title>
<style>
    body{
margin: 0;
padding: 0;
box-sizing: border-box;
background-image: url("https://images.pexels.com/photos/743986/pexels-photo-743986.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
background-attachment: fixed;
background-position: center;
background-repeat: no-repeat;
background-size: contain;
background-color: rgb(255, 255, 255);
    }
    }
h1{
    text-align: center;
}
ul.list{
     
  list-style-type: none;
  display: flex;
  justify-content: center;

}
ul li{
    display: flex;
    justify-content: space-evenly;
    padding: 20px 30px;
       }
       ul li a {
    background-color:#cdd4de;
    background-color: none;
    text-decoration: none;
    border: 2px solid blue;
    padding: 7px 21px;
    border-radius: 12px;
       }
</style>
</head>
  <body>
    <h1>The Student Management System</h1>
    <ul class="list">
      <li><a href="studentform">Add Student</a></li>
      <li><a href="viewstudent">View Student</a></li>
    </ul>
  </body>
</html>
