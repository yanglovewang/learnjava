package cn.itcast.bean;

public class User {
	
	
	public User() {
			System.out.println("User对象空参构造方法!!!!");
	}
	private String name;
	private Integer age;
	private Car car;
	
	
	
	public User(String name, Car car) {
		System.out.println("User(String name, Car car)!!");
		this.name = name;
		this.car = car;
	}
	
	public User(Car car,String name) {
		System.out.println("User(Car car,String name)!!");
		this.name = name;
		this.car = car;
	}
	
	public User(Integer name, Car car) {
		System.out.println("User(Integer name, Car car)!!");
		this.name = name+"";
		this.car = car;
	}
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public void init(){
		System.out.println("我是初始化方法!");
	}
	public void destory(){
		System.out.println("我是销毁方法!");
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
}
