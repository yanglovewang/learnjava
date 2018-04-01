

// 用自己实现的 e 替代 document.querySelector
// 因为这个东西太长了
var e = function(selector) {
    return document.querySelector(selector)
}


var addClick = function() {
    console.log(1)
    var add = e('#id-button-add')
    var todoCell = e('.todo-cells')
    add.addEventListener('click', function(){
    var value = e('#id-input-todo').value
    console.log('value', value)
    insertTodo(value, todoCell)   //false 表示不使用样式
    saveTodos()
})
}


var insertTodo = function(value, cell) {
    var temp = tempTodo(value, false) //false 表示是否给模板加上样式
    cell.insertAdjacentHTML('beforeend', temp)

}

var loadInsert = function(o, cell) {
    console.log('o.done', o.done)
     var temp = tempTodo(o.name, o.done) //false 表示是否给模板加上样式
    cell.insertAdjacentHTML('beforeend', temp)
}
var deleteTodo = function() {
    var todoCell = e('.todo-cells')
    todoCell.addEventListener('click', function(event){
        var target = event.target
        if(target.classList.contains('todo-delete')) {
            target.parentNode.remove()
        }
        saveTodos()
    }) 
}

var compelete = function() {
    var todoCell = e('.todo-cells')
    todoCell.addEventListener('click', function(event){
        var target = event.target
        target.parentNode.classList.toggle('doLine')
        saveTodos()
    }) 
}

var saveTodos = function() {
    var arr = []
    var done = false
    var todoContent = document.querySelectorAll('.todo-content')
    for (var i = 0; i < todoContent.length; i++) {
        var parent = todoContent[i].parentNode
        if(parent.classList.contains('doLine')) {
            done = true
        }else {
            done = false
        }
        var o = {
            done: done,
            name: todoContent[i].innerHTML,
        }
        arr.push(o)
    }
    save(arr)
}

var save = function(arr) {
    var s = JSON.stringify(arr)
    localStorage.todos = s
}

var reLoad = function() {
    var todos = load()
    console.log('reLoad todos',todos)
    var cell = e('.todo-cells')
    for (var i = 0; i < todos.length; i++) {
        var o = todos[i]
        loadInsert(o, cell)
    }

}
var load = function() {
    var arr = JSON.parse(localStorage.todos)
    return arr
}

//参数：插入的内容，是否添加参数
var tempTodo = function(todo, done) {
    var status = ''
    if(done) {
        status = 'doLine'
    }
    var t = `
        <div class='todo-cell ${status}'>
            <button class='todo-done'>完成</button>
            <button class='todo-delete'>删除</button>
            <span class='todo-content' contenteditable='true'>${todo}</span>
        </div>
    `
    return t
}
addClick()
deleteTodo()
compelete()
reLoad()

/*
    事件是不用被调用就可实时监听
    所以如果把事件写在一个函数里面就要把这个函数
    调用后才能使用监听器，但是函数只是被触发一次
    只要有事件触动就会有事件函数
*/