/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mst.utils;

import java.security.InvalidParameterException;

/**
 *
 * @author Mustafa SACLI
 */
public class StringUtilities {

    public static boolean isValidString(String str) {

        if (null != str) {
            return str.trim().length() > 0;
        } else {
            return false;
        }

    }

    public static boolean isNullOrEmpty(String str) {
        if (str == null) {
            return true;
        } else {
            return str.length() == 0;
        }
    }

    public static boolean isNullOrWhiteSpace(String str) {
        if (str == null) {
            return true;
        } else {
            return str.trim().length() == 0;
        }
    }

    public static boolean Matches(String str1, String str2) {
        if (str1 != null && str2 != null) {
            if (str1.length() == str2.length()) {
                int len = str1.length();
                boolean _state = true;
                char[] ch1 = str1.toCharArray();
                char[] ch2 = str2.toCharArray();
                for (int i = 0; i < len; i++) {
                    _state = ch1[i] == ch2[i];
                    if (_state == false) {
                        break;
                    }
                }
                return _state;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static String MultiConcat(String... strings) {
        StringBuilder strBuilder = new StringBuilder();
        if (null != strings) {

            for (String item : strings) {

                if (null != item) {
                    strBuilder.append(item);
                } else {
                    throw new InvalidParameterException("string will be concated can not be null.");
                }
            }
        }
        return strBuilder.toString();
    }

    public static String ReverseString(String willBeReversed) {
        try {
            if (willBeReversed != null) {
                StringBuilder strBuilder = new StringBuilder();
                switch (willBeReversed.length()) {
                    case 0:
                        return "";
                    case 1:
                        return willBeReversed;
                    case 2: {
                        strBuilder.append(willBeReversed.charAt(1));
                        strBuilder.append(willBeReversed.charAt(0));
                        return strBuilder.toString();
                    }
                    default: {
                        strBuilder.append(willBeReversed.charAt(willBeReversed.length() - 1));
                        strBuilder.append(ReverseString(willBeReversed.substring(1, willBeReversed.length() - 1)));
                        strBuilder.append(willBeReversed.charAt(0));
                        return strBuilder.toString();
                    }
                }
            } else {
                throw new InvalidParameterException("String object can not be null!.");
            }

        } catch (Exception exc) {
            throw exc;
        }
    }

    public static boolean isNumber(String strNumber) {
        try {
            if (strNumber == null) {
                throw new NullPointerException("strNumber object is null.");
            } else {
                int len = strNumber.length();
                boolean retBool = false;
                for (int i = 0; i < len; i++) {
                    retBool |= Character.isDigit(strNumber.charAt(i));
                    if (false == retBool) {
                        break;
                    }
                }
                return retBool;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static String multiplyTwoString(String str1, String str2) {
        try {
            if (isNumber(str1) && isNumber(str2)) {
                String rvrsStr1 = ReverseString(str1);
                // System.out.println(rvrsStr1);
                String rvrsStr2 = ReverseString(str2);
                // System.out.println(rvrsStr2);
                int len1 = rvrsStr1.length();
                int len2 = rvrsStr2.length();
                int returnLength = len1 + len2;
                int[] IntArray = new int[returnLength];

                for (int i = 0; i < len2; i++) {
                    for (int j = 0; j < len1; j++) {
                        int sayi1 = MathUtilities.Convert2IntWithExc(rvrsStr1.charAt(j));
                        int sayi2 = MathUtilities.Convert2IntWithExc(rvrsStr2.charAt(i));

                        int say = sayi1 * sayi2;
                        int index = i + j;
                        IntArray[index] += say;
                        for (int k = index; k < returnLength - 1; k++) {
                            if (IntArray[k] > 9) {
                                IntArray[k + 1] += (IntArray[k] / 10);
                                IntArray[k] %= 10;
                            } else {
                                break;
                            }
                        }

                    }
                }

                String rtStr = StringFromIntArray(IntArray);
                String st = ReverseString(rtStr);

                return st.charAt(0) == '0' ? st.substring(1, st.length()) : st;
            } else {
                throw new IllegalArgumentException("Parameters only consist of numbers.");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static String StringFromIntArray(int[] array) {
        try {
            if (array != null) {
                StringBuilder strBuilder = new StringBuilder(array.length);
                boolean isFirst = true;
                for (int i : array) {
                    if (isFirst) {
                        isFirst = false;
                        if (i != 0) {
                            strBuilder.append(i);
                        }
                    } else {
                        strBuilder.append(i);
                    }
                }
                return strBuilder.toString();
            } else {
                throw new NullPointerException("array can noıt be null.");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
