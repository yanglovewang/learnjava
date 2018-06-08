var checkForm = function() {
	var userName = document.querySelector('#input-userName').value
	var password = document.querySelector('#input-Password').value
	console.log(userName)
	if(userName == null || password == null ||userName == '' || password == '') {
		alert("用户名密码不能为空")
		return false
	} else {
		return true
	}
}

var clear = function() {
	var clear = document.querySelector('#button-clear')
	clear.addEventListener('click', function(event) {
		document.querySelector('#input-userName').value = ''
		document.querySelector('#input-Password').value = ''
	})
}

var closeEar = function(ear) {
	ear.className = "glyphicon glyphicon-eye-close"
	var pwd = document.querySelector('#input-Password').type = "password"
}

var openEar = function(ear) {
	ear.className = "glyphicon glyphicon-eye-open"
	var pwd = document.querySelector('#input-Password').type = "text"
}

var toggle = function() {
	var ear = document.querySelector('#span-ear')
	ear.addEventListener('click', function(event){
		if(ear.className == "glyphicon glyphicon-eye-open"){
			closeEar(ear)
		} else {
			openEar(ear)
		}
	} )
}

var __main = function() {
	clear()
	toggle()
}


__main()




