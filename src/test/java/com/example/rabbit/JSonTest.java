package com.example.rabbit;

import java.net.*;
import java.io.*;
import net.sf.json.JSONObject;

public class JSonTest {

	// 查看端口被占用的tcp 的 PID
	// netstat -ano | findstr 50000
	// 杀死tcp
	// taskkill /pid 11360 /f
	private static Socket socket;
	private static BufferedReader in;
	private static PrintWriter out;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("Name", "liangyongs");
		jsonObj.put("Id", 33);
		String[] hobby = { "java", "golang", "clang","php" };
		jsonObj.put("Hobby", hobby);
		System.out.println("Object before sending to golang side:");
		System.out.println(jsonObj);
		try {
			socket = new Socket("127.0.0.1", 50000);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			out.println(jsonObj);
			String line = in.readLine();
			System.out.println("Object read from golang side:");
			jsonObj = JSONObject.fromObject(line);
			System.out.println(jsonObj.toString());
			//System.out.println("changed id is : "+jsonObj.get("id"));
			socket.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
