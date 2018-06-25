<!DOCTYPE html>
<html>
 <head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <title>RestFul Form Test </title>
 </head>
<body>
	<h2>RestFul Web Service - Form Test</h2>
        <form action="../RestFul/webapi/restfulpath/formpath" method="POST">
        <label for="firstName">First Name :</label>
        <input name="firstName" />
        <br/>
        <label for="firstName">Last Name :</label>
        <input name="lastName" />
        <br/>
        <input type="submit" value="Submit" />
        </form>
        <input type="button" onclick="sendData()" value="Send Data using Ajax" ></input>
</body>

<script type="text/javascript">
function sendData(){
	//alert("Clicked")
	var testdata = JSON.stringify({ "id":123, "firstName":"Rajesh", "lastName" : "Kawali" });
	$.ajax({
	    url: "http://localhost:8080/RestFul/webapi/restpath",
	    type: 'post',
	    data: testdata,
	    headers: {
	        "Content-type": "application/json"
	    },
	    dataType: 'json',
	    success: function (data) {
	        console.info(data);
	    }
	});
}

</script>

</html>