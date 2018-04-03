$(document).ready(function(){
	var inputBlur = function(element, template) {
		element.blur(function(event){
			var target = event.target
			if(target.value == '') {
				$('.login-input').prepend(template)
			}
			target.placeholder = ''
		})
	}

	var inputFocus = function(element, placeholder, className) {
		element.focus(function(event){
			var target = event.target
			 $(className).remove()
			target.placeholder = placeholder
		})
	}
	//两个文本框操作
	var doInputs = function() {
		var doLogin = $('#id-input-1')
		var doPwd = $('#id-input-2')
		inputBlur(doLogin, '<div class="re login-remind">请输入用户名</div>')
		inputFocus(doLogin, '用户名...', '.login-remind')
		inputBlur(doPwd, '<div class="re pwd-remind">请输入密码</div>')
		inputFocus(doPwd, '密码...', '.pwd-remind')
	}
	
	//获取登录注册按钮
	var getButtonValue = function() {
		var page = ''
		var value = $('#id-button-bottom').html()
		if(value === '注册') {
			page = 'regiter'
		} else if(value = '登录') {
			page = 'login'
		}
		return page
	}
	
	//设置登录注册按钮
	var setButtonValue = function(pageName) {
		$('#id-button-bottom').html(pageName)
	}
	
	//设置注册界面
	var setRePage = function() {
		$('.login-input').hide()
		$('.inner').prepend(regiterPage())
		$('.login-button-login').html('注册')
	}
	
	//设置注册界面模板
	var regiterPage = function() {
		console.log('beforeend', 1)
		var temp = `
		<div class="regiter-input">
			<input class="d" id="id-input-3" placeholder="用户名..." type="text" name="user"><br>
			<input id="id-input-4" placeholder="创建密码..." type="password" name="pwd">
			<input id="id-input-5" placeholder="确认密码..." type="password" name="pwd">
		</div>
		`
			return temp
	}
	//设置登录界面
	var setLoPage = function() {
		$('.login-input').show()
		$('.regiter-input').hide()
		$('.login-button-login').html('登录')
	}
	var __main = function() {
		doInputs()
		$('#id-button-bottom').click(function() {
			if(getButtonValue() == 'regiter') {
				setButtonValue('登录')
				setRePage()
			}else if(getButtonValue() == 'login') {
				setButtonValue('注册')
				setLoPage()
			}
		})
	}
	
	__main()
})