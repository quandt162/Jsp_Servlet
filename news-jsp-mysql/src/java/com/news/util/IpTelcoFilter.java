package com.news.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ThangDT
 *
 */
public class IpTelcoFilter {
//	10.0.0.0 netmask 255.0.0.0 gateway 10.58.56.254
//
//	171.224.0.0 netmask 255.255.0.0 gateway 10.58.56.254
//	171.225.0.0 netmask 255.255.0.0 gateway 10.58.56.254
//	171.228.0.0 netmask 255.255.0.0 gateway 10.58.56.254
//	171.232.0.0 netmask 255.255.0.0 gateway 10.58.56.254
//	171.233.0.0 netmask 255.255.0.0 gateway 10.58.56.254
//	171.234.0.0 netmask 255.255.0.0 gateway 10.58.56.254
//	171.236.0.0 netmask 255.255.0.0 gateway 10.58.56.254
//	171.240.0.0 netmask 255.255.0.0 gateway 10.58.56.254
//	171.241.0.0 netmask 255.255.0.0 gateway 10.58.56.254
//	171.244.0.0 netmask 255.255.0.0 gateway 10.58.56.254
//	171.248.0.0 netmask 255.255.0.0 gateway 10.58.56.254
//	171.249.0.0 netmask 255.255.0.0 gateway 10.58.56.254
//	171.250.0.0 netmask 255.255.0.0 gateway 10.58.56.254

    //Update 13/03/2011
    //v-Internet
    //27.64.0.0/16	
    //27.65.0.0/16
    //27.76.0.0/16
    //27.77.0.0/16
    //171.224.0.0/16
    //171.225.0.0/16
    //171.228.0.0/16
    //171.230.0.0/16
    //171.231.0.0/16
    //171.232.0.0/16
    //171.233.0.0/16
    //171.234.0.0/16
    //171.236.0.0/16
    //171.238.0.0/16
    //171.240.0.0/16
    //171.241.0.0/16
    //171.244.0.0/16
    //171.248.0.0/16
    //171.249.0.0/16
    //171.250.0.0/16
    //v-wap
    //125.234.49.48/28
    //125.235.49.48/28	
    //Update ngày 08/10/2012
//	27.64.0.0/16
//	27.65.0.0/16
//	27.76.0.0/16
//	27.77.0.0/16
//	171.224.0.0/16
//	171.225.0.0/16
//	171.228.0.0/16
//	171.230.0.0/16
//	171.231.0.0/16
//	171.232.0.0/16
//	171.233.0.0/16
//	171.234.0.0/16
//	10.156.0.0/15
//	10.158.0.0/15
//	10.148.0.0/14
//	10.152.0.0/14
//	10.136.0.0/15
//	10.138.0.0/15
//	10.193.0.0/16
//
//	171.236.0.0/16
//	171.238.0.0/16
//	171.240.0.0/16
//	171.241.0.0/16
//	171.241.128.0/17
//	171.243.0.0/16
//	171.244.0.0/16
//	171.248.0.0/16
//	171.247.0.0/16 
//	171.249.0.0/16
//	171.250.0.0/16
//	171.251.64.0/18
//	171.251.128.0/17
//	10.140.0.0/14
//	10.206.0.0/15
//	10.168.0.0/15
//	10.170.0.0/16
//	10.135.0.0/16
//	10.144.0.0/14
//
//
//	125.235.49.48/28
//	125.234.49.48/28
    private static String listIpViettel = "(27.64.|27.65.|27.66.|27.67.|27.68.|27.69.|27.70."
            + "|27.71.|27.72.|27.73.|27.74.|27.75.|27.76.|27.77.|27.78."
            + "|171.224.|171.225.|171.226.|171.227.|171.228.|171.229."
            + "|171.230.|171.231.|171.232.|171.233.|171.234.|171.235.|171.236.|171.237.|171.238.|171.239."
            + "|171.240.|171.241.|171.242.|171.243.|171.244.|171.245.|171.246.|171.247.|171.248.|171.249."
            + "|171.250.|171.251.|171.252.|171.255."
            + "|10.180.|10.182.|10.183.|10.184.|10.188.|10.189.|10.190.|10.191.|10.131.|10.134.|10.207.|171.253." + // tuyentt update 11.04
            "|10.23.|10.24.|10.25.|10.28.|10.29.|10.233.|10.172.|10.176.|10.160." + // tuyentt update 11.04
            "|10.135.|10.136.|10.137.|10.138.|10.139."
            + "|10.140.|10.141.|10.142.|10.143.|10.144.|10.145.|10.146.|10.147.|10.148.|10.149."
            + "|10.150.|10.151.|10.152.|10.153.|10.154.|10.155.|10.156.|10.157.|10.158.|10.159."
            + "|10.168.|10.169."
            + "|10.170.|10.171."
            + "|10.193."
            + "|10.206."
            + "|123.234.49."
            + ").*";
    //113.185.0-31.x 
    private static String listIpVinaphoneExt =
            "(113.185.0.|113.185.1.|113.185.2.|113.185.3.|113.185.4."
            + "|113.185.5.|113.185.6.|113.185.7.|113.185.8.|113.185.9."
            + "|113.185.10.|113.185.11.|113.185.12.|113.185.13.|113.185.14."
            + "|113.185.15.|113.185.16.|113.185.17.|113.185.18.|113.185.19."
            + "|113.185.20.|113.185.21.|113.185.22.|113.185.23.|113.185.24."
            + "|113.185.25.|113.185.26.|113.185.27.|113.185.28.|113.185.29."
            + "|113.185.30.|113.185.31.).*";

    public static boolean isTrueIpVietel(String ipAddress) {
        //System.out.println("IpTelcoFilter - check ip Viettel: "+ipAddress);
		/*
         * if(ipAddress==null) return false;
         * if(ipAddress.startsWith("125.234.49") ||
         * ipAddress.startsWith("125.235.49")){ //v-wap //125.234.49.48/28
         * //125.235.49.48/28 try{ int e =
         * Integer.parseInt(ipAddress.substring(ipAddress.lastIndexOf(".")+1));
         * if(e>=49 && e<=62){ return true; } }catch (Exception ex) {}
         *
         * } else { //v-internet if(ipAddress.matches(listIpViettel)) return
         * true; } return false;
         */


        if (ipAddress == null) {
            return false;
        }
        if (ipAddress.startsWith("27.66.")
                || ipAddress.startsWith("27.67.")
                || ipAddress.startsWith("171.255.")
                || ipAddress.startsWith("125.234.")
                || ipAddress.startsWith("125.235.")
                || ipAddress.matches(listIpViettel)) {
            return true;
        }
        return false;

    }

    public static boolean isTrueIpVinaphone(String ipAddress) {
        if (ipAddress == null) {
            return false;
        }
        if (ipAddress.startsWith("113.185.")) {
            //113.185.0-31.x 
            try {
                int e = Integer.parseInt(ipAddress.substring(8, ipAddress.lastIndexOf(".")));
                //System.out.println("e = "+e);
                if (e >= 0 && e <= 31) {
                    return true;
                }
            } catch (Exception ex) {
            }

        }
        return false;
    }

    //MOBIFONE
//	27.64.0.0/14
//	27.68.0.0/14
//	27.72.0.0/14
//	26.76.0.0/14
//	171.224.0.0/14
//	171.228.0.0/14
//	171.232.0.0/14
//	171.236.0.0/14
//	171.240.0.0/14
//	171.244.0.0/14
//	171.248.0.0/14
//	171.252.0.0/14
    public static boolean isTrueIpMobifone(String ipAddress) {
        if (ipAddress == null) {
            return false;
        }
        if (ipAddress.startsWith("27.64.")
                || ipAddress.startsWith("27.68.")
                || ipAddress.startsWith("27.72.")
                || ipAddress.startsWith("26.76.")
                || ipAddress.startsWith("171.224.")
                || ipAddress.startsWith("171.228.")
                || ipAddress.startsWith("171.232.")
                || ipAddress.startsWith("171.236.")
                || ipAddress.startsWith("171.240.")
                || ipAddress.startsWith("171.244.")
                || ipAddress.startsWith("171.248.")
                || ipAddress.startsWith("171.252.")) {
            return true;

        }
        return false;
    }
    private static final String PATTERN_IP_V4 =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    private static final String PATTERN_IP_VIETTEL =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$"
            + " | a\\.b\\.c";

    public static boolean validateIpViettel(final String ip) {
        Pattern pattern = Pattern.compile(PATTERN_IP_VIETTEL);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(validateIpViettel("a.b.c"));

//		System.out.println(isTrueIpVietel("10.0.0.12"));
//		System.out.println(isTrueIpVietel("171.231.0.232"));
//		System.out.println(isTrueIpVietel("171.254.0.232"));
//		System.out.println(isTrueIpVietel("125.234.49.49"));
//		System.out.println(isTrueIpVietel("125.234.65.56"));
//		System.out.println(SMSTool.buildMobileOperator(MobileTool.getStandardMobileNumber("0975266155")));

//		System.out.println(isTrueIpVinaphone("113.185.0.10"));
//		System.out.println(isTrueIpVinaphone("113.185.11.10"));
//		System.out.println(isTrueIpVinaphone("113.185.31.10"));
//		System.out.println(isTrueIpVinaphone("113.185.111.10"));
//		System.out.println(isTrueIpVinaphone("113.186.4.10"));

        try {
            System.out.println(URLEncoder.encode("http://ole.vn/wap/users/infor", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
