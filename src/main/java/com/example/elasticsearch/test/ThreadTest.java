package com.example.elasticsearch.test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

import org.springframework.objenesis.instantiator.util.UnsafeUtils;

import sun.misc.Unsafe;

@SuppressWarnings("restriction")
public class ThreadTest {

	// setup to use Unsafe.compareAndSwapInt for updates
	private static final Unsafe unsafe = UnsafeUtils.getUnsafe();
	private static final long valueOffset;

	static {
		try {
			valueOffset = unsafe.objectFieldOffset(ThreadTest.class.getDeclaredField("value"));
		} catch (Exception ex) {
			throw new Error(ex);
		}
	}
	
	@SuppressWarnings("unused")
	private volatile int value;
	
	public final int incrementAndGet() {
        return unsafe.getAndAddInt(this, valueOffset, 1) + 1;
    }

	public static void main(String[] args) throws InterruptedException {
		
		
		
		

		// 5-Attach Listener
		// 4-Signal Dispatcher //分发处理发送给JVM信号的线程
		// 3-Finalizer //调用对象的finalize方法的线程，就是垃圾回收的线程
		// 2-Reference Handler //清除reference的线程
		// 1-main //主线程

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				ThreadTest test = new ThreadTest();
				long sum = 0;
				for (int i = 0; i < 10000000; i++) {
					sum +=test.incrementAndGet();
				}
				
				System.out.println("value is: "+sum);
			}
		}, "My-Thread");

		System.out.println(t.getState().name());
		t.start();
		Thread.sleep(200l);

		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] dumpAllThreads = threadMXBean.dumpAllThreads(false, false);
		for (ThreadInfo threadInfo : dumpAllThreads) {
			System.out.println(threadInfo.getThreadId() + ":" + threadInfo.getThreadName());
		}

		Thread hook = new Thread(new Runnable() {

			@Override
			public void run() {
				long sum = 0;
				for (int i = 0; i < 10000000; i++) {
					sum += i;
				}
				System.out.println("sum:" + sum);
				System.out.println("shut down jvm...");
			}
		}, "My-Thread2");

		Runtime.getRuntime().addShutdownHook(hook);

	}

}
