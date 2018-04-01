
$(document).ready(function(){
   $('.button-regiter').click(function(event) {
  		changePage()
  		console.log(1)
  })

  var changePage = function() {
  	var inputs = $('input')
  	changInput(inputs[0], '手机号')
  	changInput(inputs[1], '输入6位短信验证码')
  }

  var changInput = function(element, value) {
  	element.placeholder = value
  }
});