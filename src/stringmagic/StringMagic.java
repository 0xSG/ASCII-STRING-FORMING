/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringmagic;

import java.awt.Toolkit;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sooryagangarajk
 */
public class StringMagic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useDelimiter("");
        String s = in.nextLine();
        int[] cia = new int[s.length()];
        int[] ans = new int[s.length()];
        int[] ciaf = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cia[i] = (int) s.charAt(i);
            ciaf[i] = 0;
            ans[i] = 32;
        }
        System.out.println("---------");
        for (int j = 0; j < 255; j++) {
            int flag = 0, count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (ciaf[i] == 0) {
                    if (ans[i] != cia[i]) {
                        ans[i]++;
                        Toolkit.getDefaultToolkit().beep();
                    } else {
                        ciaf[i] = 1;
                    }

                }
                System.out.print((char) ans[i]);
            }
            try {
                Thread.sleep(500);
                for (int clear = 0; clear < 1000; clear++) {
                    System.out.println("\b");
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(StringMagic.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < s.length(); i++) {
                if (ciaf[i] == 1) {
                    count++;
                }
                if (count == s.length()) {
                    flag = 1;
                    break;
                }

            }
            if (flag == 1) {
                break;
            }

        }
        System.out.print(s + " ");

    }
}
