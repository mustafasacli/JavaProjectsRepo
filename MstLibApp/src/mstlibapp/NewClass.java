/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mstlibapp;

import mst.utils.StringUtilities;

/**
 *
 * @author eww
 */
public class NewClass {

    public static void main(String[] args) throws Throwable {
        System.out.println(String.valueOf(Long.MAX_VALUE));
        String snc = StringUtilities.multiplyTwoString(String.valueOf(Long.MAX_VALUE), String.valueOf(Long.MAX_VALUE)); //"546532132132132", "546874321321321");

        System.out.println(snc);

        boolean x = StringUtilities.Matches("ali", "ali");
        System.out.println(x ? "Uyuştu." : "Uyuşmadı.");
    }
}
