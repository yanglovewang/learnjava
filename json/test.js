

$(document).ready(function() {
	 $('#input-sub').click(function(event) {
		 var name = $('#input-name').val()
		 console.log(name)
		 var pwd = $('#input-pwd').val()
		 o = {
			 name: name,
			 pwd: pwd,
		 }
		 var data = JSON.stringify(o)
		/* $.get("Aservlet?data=", function(data) {
			 alert(data)
		 } )*/
		 
		 $.post('Aservlet', "data="+data, function(data) {
			var o = JSON.parse(data)
			console.log(o.yang)  //传递过来的json的属性
		 })
	 })
});