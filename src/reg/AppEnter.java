/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg;

import reg.cli.Navigation;
import reg.utils.Utils;

/**
 *
 * @author knightsong
 */
public class AppEnter {

	public static void main(String[] args) {
		System.out.println("Supported just three feature: test <bugid> <version>,"
				+ "ls, exit.\n that version include{working,bic,bfc}\\n");
		Db.bugs = Utils.readFileByLines("bugs.csv");
		try {
			Navigation.main(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
