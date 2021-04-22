package reg.cli;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

import reg.Db;
import reg.executor.Execute;

/**
 *
 * @author knightsong
 */
public class Navigation {
	private final static String EXIT = "exit";
	private final static String LIST = "ls";;
	private final static String INFO = "info";;
	private final static String TEST = "test";

	static Execute exec = new Execute();

	public static void travel() {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Reg4J#:");
		try {

			String cmd = bf.readLine().trim();
			while (!cmd.equalsIgnoreCase(EXIT)) {
				navigation(cmd);
				System.out.print("Reg4J#:");
				cmd = bf.readLine().trim();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void navigation(String cmd) {
		String[] params = cmd.split(" ");
		try {
			if (params[0].equalsIgnoreCase(LIST)) {
				Db.bugs.stream().forEach(System.out::println);
			} else if (params[0].equalsIgnoreCase(TEST)) {
				String bugid = params[1];
				String version = params[2];
				exec.execPrintln("docker start " + bugid + ";docker exec " + bugid + " bash " + version + "_test.sh");
			} else {
				System.err.println("what ???");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
