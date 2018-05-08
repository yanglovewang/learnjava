package daili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
	
	public static void main(String[] args) {
		ProxyTest p = new ProxyTest();
		ClassLoader loader = p.getClass().getClassLoader();
		Class[] interfaces = {Waiter.class};
		Waiter w = new ManWaiter();
		InvocationHandler h = new WaiterInvocationHandler(w);
		Waiter man = (Waiter)Proxy.newProxyInstance(loader, interfaces, h);
		man.server();
	}

}

class WaiterInvocationHandler  implements InvocationHandler{

	private Waiter w;
	public WaiterInvocationHandler(Waiter w) {
		this.w = w;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("开始服务。。。");
		w.server();
		System.out.println("结束。。。");
		return null;
	}
	
}
