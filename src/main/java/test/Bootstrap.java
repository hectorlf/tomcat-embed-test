package test;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

public class Bootstrap {

	public static void main(String[] args) {
		System.out.println("Starting Tomcat");
		Tomcat t = new Tomcat();
		t.setPort(8123);
		try {
			File base = new File(System.getProperty("java.io.tmpdir"));
			System.out.println("Root context basedir: " + base.getAbsolutePath());
			Context rootCtx = t.addContext("", base.getAbsolutePath());
			System.out.println("Tomcat start()");
			t.start();
			System.out.println("Tomcat started");
			//t.getServer().await();
			System.out.println("Stopping Tomcat");
			t.stop();
			System.out.println("Tomcat stopped");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
