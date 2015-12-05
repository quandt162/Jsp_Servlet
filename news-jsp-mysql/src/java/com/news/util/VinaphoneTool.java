/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Designer Nguyễn
 */
public class VinaphoneTool {

    public static String getMSISDN(HttpServletRequest request) {
        Pattern F5IPPattern = Pattern.compile("(^(10)(\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])){3}$)|(^(113\\.185\\.)([1-9]|1[0-9]|2[0-9]|3[0-1])(\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])))");
        Pattern WAPGWIPPattern = Pattern.compile("(^172.16.30.1[1-2]$)|(113.185.0.16)");

        String remoteip = request.getRemoteAddr();
        String msisdn = request.getHeader("msisdn");
        String xipaddress = request.getHeader("X-ipaddress");
        String xforwarded = request.getHeader("X-Forwarded-For");
        String xwapmsisdn = request.getHeader("X-Wap-MSISDN");
        String userip = request.getHeader("User-IP");
        String msisdn_ = "";

        if (F5IPPattern.matcher(remoteip).matches()) { //đi qua F5
            if (msisdn != null && msisdn.startsWith("84")) {
                msisdn_ = msisdn;
            }
        } else if (WAPGWIPPattern.matcher(remoteip).matches()) { //đi qua WAPGW
            if (xwapmsisdn != null && xwapmsisdn.startsWith("84")) {
                msisdn_ = xwapmsisdn;
            } else {

            }
        }
        if (msisdn_.startsWith("84") && SMSTool.isValidMobileNumber(msisdn_)) {	//Hệthốngđãxácthựcsố MSISDN, lưuvào session
            HttpSession session = request.getSession(true);
            session.setAttribute("msisdn", msisdn_);
        } else {
            //Can notget MSISDN by MIM1STEP
            //process next step: SSO, WAPID or OTP
        }
        return msisdn_;
    }

    public static String getMSISDNOperaMini(HttpServletRequest request) {
        Pattern F5IPPattern = Pattern.compile("(^(10)(\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])){3}$)|(^(113\\.185\\.)([1-9]|1[0-9]|2[0-9]|3[0-1])(\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])))");
        Pattern WAPGWIPPattern = Pattern.compile("(^172.16.30.1[1-2]$)|(113.185.0.16)");
        String[] operaIPs = {"37.228.104.0/21", "58.67.157.0/24", "59.151.95.128/25", "59.151.98.128/27",
            "59.151.106.224/27", "59.151.120.32/27", "80.84.1.0/24", "80.239.242.0/23",
            "82.145.208.0/20", "91.203.96.0/22", "116.58.209.36/27", "116.58.209.128/27",
            "141.0.8.0/21", "195.189.142.0/23", "203.81.19.0/24", "209.170.68.0/24",
            "217.212.230.0/23", "217.212.226.0/24", "185.26.180.0/22", "2001:4c28::/32"};

        String remoteip = request.getRemoteAddr();
        String msisdn = request.getHeader("msisdn");
        String xipaddress = request.getHeader("X-ipaddress");
        String xforwarded = request.getHeader("X-Forwarded-For");
        String xwapmsisdn = request.getHeader("X-Wap-MSISDN");
        String userip = request.getHeader("User-IP");
        String msisdn_ = "";

        boolean checkOperaIP = false;
        for (String operaIP : operaIPs) {
            if (operaIP.equals(remoteip)) {
                checkOperaIP = true;
                break;
            }
        }
        if (checkOperaIP) {
            if (F5IPPattern.matcher(xipaddress).matches()) { //đi qua F5
                if (msisdn != null && msisdn.startsWith("84")) {
                    msisdn_ = msisdn;
                }
            } else if (WAPGWIPPattern.matcher(userip).matches()) { //đi qua WAPGW
                if (xwapmsisdn != null && xwapmsisdn.startsWith("84")) {
                    msisdn_ = xwapmsisdn;
                } else {

                }
            }
        }

        if (msisdn_.startsWith("84") && SMSTool.isValidMobileNumber(msisdn_)) {	//Hệthốngđãxácthựcsố MSISDN, lưuvào session
            HttpSession session = request.getSession(true);
            session.setAttribute("msisdn", msisdn_);
        } else {
            //Can notget MSISDN by MIM1STEP
            //process next step: SSO, WAPID or OTP
        }
        return msisdn_;
    }
    
    public static String hash(String messages) throws Exception {
        if (messages == null) {
            throw new NullPointerException();
        }
        StringBuffer result = null;
        byte[] data = messages.getBytes();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(data);
            byte[] msgDigest = md.digest();
            result = new StringBuffer();
            for (int i = 0; i < msgDigest.length; i++) {
                String hex = Integer.toHexString(0xff & msgDigest[i]);
                if (hex.length() == 1) {
                    result.append('0');
                }
                result.append(hex);
            }
        } catch (NoSuchAlgorithmException ex) {
            throw new Exception(ex.toString());
        }
        return result.toString();
    }
    
    public final static String GETOTP_SUCCESS = "0|success";
    public final static String GETOTP_UNKNOWN_IP = "1|unknown ip";
    public final static String GETOTP_INVALID_SUBCRIBER = "2|invalid subscriber";
    public final static String GETOTP_OTPAREDY_SENT = "3|otpaready sent";
    public final static String GETOTP_OTHER_ERROR = "4|other error";
    
    public static String getOTP(String msissn, String servicename){        
        return SendRequest.excutePost("http://otpserver/otp/getotp?msisdn="+msissn+"&servicename="+servicename+"","");
    }
    
    public final static String CHECKOTP_MSISDN = "0|MSISDN";
    public final static String CHECKOTP_UNKNOWN_IP = "1|unknown ip";
    public final static String CHECKOTP_WRONG_OTP_TOKEN = "2|wrong otp token";
    public final static String CHECKOTP_MAX_RETRY = "3|max retry";
    public final static String CHECKOTP_OTHER_ERROR = "4|other error";
    
    public static String checkOTP(String msissn, String otpToken, String servicename){
        return SendRequest.excutePost("http://otpserver/otp/checkotp?msisdn="+msissn+"&otptoken="+otpToken+"&servicename="+servicename+"","");
    }
}
