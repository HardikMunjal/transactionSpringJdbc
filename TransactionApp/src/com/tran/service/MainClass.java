package com.tran.service;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;


import com.tran.manager.AccuntManager;

import com.tran.service.MyBeanFactory;

public class MainClass {
public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		System.out.println("Enter Source A/C:");
		int src=in.nextInt();
		System.out.println("Enter Target A/C:");
		int target=in.nextInt();
		System.out.println("Enter Amount:");
		int amt=in.nextInt();
		in.close();
		
		ApplicationContext ctx=MyBeanFactory.getAppContext();
		AccuntManager am=(AccuntManager)ctx.getBean("am");
		
		try
		{
			am.transfer(src, target, amt);
			System.out.println("successfully transferred.");
		}catch(Exception ex)
		{
			System.out.println(ex);
					}
		
		
	}
}

