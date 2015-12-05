package com.news.util;

//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;
//import com.sun.jersey.core.util.MultivaluedMapImpl;
//import com.viettel.iwebgate.rsa.encrypt.EncryptManager;
////import inet.db.tre_vn.VtelChargeLogDAO;
//import java.io.*;
//import java.net.SocketTimeoutException;
//import java.net.URLDecoder;
//import java.net.URLEncoder;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.MultivaluedMap;

public class MPSChargeTool {

//    public static String PRO = "INET";
//    public static int STT = 0;
//    public static String CP_CODE = "022";
//    public static String SER = "OLYMPIA";
//    public static String SUB = "OLYMPIA_DAILY";
//    static String pub_key_inet = null;
//    static String pri_key_inet = null;
//    static String pub_key_VT = null;
//    public static String MPS_CHARGE_URL = "http://125.235.32.12/MPS/charge.html";
//    public static String MPS_MOBILE_URL = "http://125.235.32.12/MPS/mobile.html";
//    public static String CMD_MUA1 = "MUA1";
//    public static String CMD_MUA2 = "MUA2";
//    public static String CMD_MUA3 = "MUA3";
//    public static String CMD_REG = "REGISTER";
//    public static String CMD_CANCEL = "CANCEL";
//    public static String CMD_DEPOSIT = "DEPOSIT";
//    public static String CMD_MONFEE = "MONFEE";
//    public static String CMD_MO = "MO";
//    public static int PRICE_DK = 1000;
//    public static int PRICE_MUA1 = 500;
//    public static int PRICE_MO = 100;
//    //public static String MPS_MOBILE_URL=null;
//
//    static {
//        pub_key_inet = readKey("conf/PublicKeyCP.pem");
//        pri_key_inet = readKey("conf/PrivateKeyCP.pem");
//        pub_key_VT = readKey("conf/PublicKeyVT.pem");
//    }
//    static VtelChargeLogDAO chargeLogDAO = new VtelChargeLogDAO();
//    static Logger logger = new Logger("MPSChargeTool");
//
//    public static String readKey(String keyFile) {
//        String key = "";
//        try {
//            BufferedReader in = new BufferedReader(new FileReader(keyFile));
//            String line = in.readLine();
//            for (; line != null; line = in.readLine()) {
//                if (line != null) {
//                    key = key + line + "\n";
//                }
//            }
//        } catch (FileNotFoundException e) {
//            try {
//                BufferedReader in = new BufferedReader(new InputStreamReader(MPSChargeTool.class.getResourceAsStream(keyFile)));
//                String line = in.readLine();
//                for (; line != null; line = in.readLine()) {
//                    if (line != null) {
//                        key = key + line + "\n";
//                    }
//                }
//            } catch (Exception e1) {
//                // TODO: handle exception
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return key;
//    }
//
//    public static String[] buildParamStringForGetMsisdn(String session, String src) {
//        String req = createCPRequestId();
//        String[] response = new String[2];
//        String encryptedValue = null;
//        String data = null;
//        String signature = null;
//        String sRequest = "PRO=" + PRO + "&SER=" + SER + "&SUB=" + SUB;
//        String value = "SUB=" + SUB + "&REQ=" + req + "&SESS=" + session + "&SOURCE=" + src;
//        System.out.println("value=" + value);
//        try {
//            String keyAES = EncryptManager.AESKeyGen();
//            encryptedValue = EncryptManager.encryptAES(value, keyAES);
//            encryptedValue = "value=" + encryptedValue + "&key=" + keyAES;
//            //	System.out.println("encryptedValue="+encryptedValue);
//            data = EncryptManager.encryptRSA(encryptedValue, pub_key_VT);
//            signature = URLEncoder.encode(EncryptManager.createMsgSignature(data, pri_key_inet), "UTF-8");
//            sRequest = sRequest + "&DATA=" + URLEncoder.encode(data, "UTF-8") + "&SIG=" + signature;
//            response[0] = req;
//            response[1] = sRequest;
//        } catch (Exception e) {
//            logger.error(e);
//        }
//        return response;
//    }
//
//    public static String[] buildParamStringForRegisterByWap() {
//        String req = createCPRequestId();
//        String[] response = new String[2];
//        String value = "SUB=" + SUB + "&CATE=" + "&IMEI=123&ITEM=" + "&SUB_CP=" + "&CONT=DANG KY QUA WAP&PRICE=" + PRICE_DK + "&REQ=" + req + "&MOBILE=&SOURCE=WAP";
//        System.out.println("-------------registerByWap=" + value);
//        String data = null;
//        String signature = null;
//        String sRequest = "PRO=" + PRO + "&CMD=" + MPSChargeTool.CMD_REG + "&SER=" + SER + "&SUB=" + SUB;
//        String encryptedValue = null;
//        try {
//            String keyAES = EncryptManager.AESKeyGen();
//            encryptedValue = EncryptManager.encryptAES(value, keyAES);
//            encryptedValue = "value=" + encryptedValue + "&key=" + keyAES;
//            data = EncryptManager.encryptRSA(encryptedValue, pub_key_VT);
//            signature = URLEncoder.encode(EncryptManager.createMsgSignature(data, pri_key_inet), "UTF-8");
//            sRequest = sRequest + "&DATA=" + URLEncoder.encode(data, "UTF-8") + "&SIG=" + signature;
//            System.out.println("-------------registerByWap1=" + sRequest);
//            response[0] = req;
//            response[1] = sRequest;
//        } catch (Exception e) {
//            logger.error(e);
//        }
//        return response;
//    }
//
//    public static Map<String, String> parseResponse(String sResponse) {
//        Map<String, String> params = parseQueryString(sResponse);
//        Map<String, String> resParams = null;
//        String resData = params.get("DATA");
//        String resSig = params.get("SIG");
//        String resValue = null;
//        String resKeyAES = null;
//        if (resData != null && resSig != null) {
//            try {
//                resSig = URLDecoder.decode(resSig, "UTF-8");
//            } catch (Exception e) {
//                // TODO: handle exception
//            }
//
//            Boolean verify = EncryptManager.verifyMsgSignature(resSig, pub_key_VT, resData);
//            if (verify) {
//                resData = EncryptManager.decryptRSA(resData, pri_key_inet);
//                //System.out.println("resData="+resData);
//                resParams = parseQueryString(resData);
//                resValue = resParams.get("VALUE");
//                resKeyAES = resParams.get("KEY");
//                if (resValue != null && resKeyAES != null) {
//                    try {
//                        resValue = EncryptManager.decryptAES(resValue, resKeyAES);
//                        System.out.println("resValue=" + resValue);
//                        if (resValue != null) {
//                            resParams = parseQueryString(resValue);
//                        } else {
//                            logger.error("resValue=" + resValue);
//                        }
//                    } catch (Exception e) {
//                        // TODO: handle exception
//                    }
//
//                } else {
//                    logger.error("resData=" + resData);
//                }
//            }
//        }
//        return resParams;
//
//    }
//
//    public static int charge(String cmd, String desc, int price, String mobile, String src, int type) {
//        String req = createCPRequestId();
//        mobile = MobileTool.getMobileNumberWithoutPre(mobile);
//        String value = "SUB=" + SUB + "&CATE=" + "&IMEI=123&ITEM=" + "&SUB_CP=" + "&CONT=" + desc + "&PRICE=" + price + "&REQ=" + req + "&MOBILE=" + mobile + "&SOURCE=" + src;
//        logger.log("value=" + value);
//        String data = null;
//        String signature = null;
//        String sRequest = "PRO=" + PRO + "&CMD=" + cmd + "&SER=" + SER + "&SUB=" + SUB;
//        String url = MPS_CHARGE_URL;
//
//        String sResponse = null;
//        int[] chargeResult = new int[]{-1, 0};
//        String encryptedValue = null;
//        long startTime = 0;
//        long endTime = 0;
//        startTime = System.currentTimeMillis();
//
//        try {
//            String keyAES = EncryptManager.AESKeyGen();
//            encryptedValue = EncryptManager.encryptAES(value, keyAES);
//            encryptedValue = "value=" + encryptedValue + "&key=" + keyAES;
//            data = EncryptManager.encryptRSA(encryptedValue, pub_key_VT);
//            signature = URLEncoder.encode(EncryptManager.createMsgSignature(data, pri_key_inet), "UTF-8");
//            sRequest = sRequest + "&DATA=" + URLEncoder.encode(data, "UTF-8") + "&SIG=" + signature;
//            url = url + "?" + sRequest;
//
//            try {
//                Client client = new Client();
//                WebResource r = client.resource(MPS_CHARGE_URL);
//                MultivaluedMap<String, String> map = new MultivaluedMapImpl();
//                map.add("PRO", PRO);
//                map.add("CMD", cmd);
//                map.add("SER", SER);
//                map.add("SUB", SUB);
//                map.add("DATA", URLEncoder.encode(data, "UTF-8"));
//                map.add("SIG", signature);
//                ClientResponse clientResponse = r.queryParams(map).type(MediaType.TEXT_PLAIN).get(ClientResponse.class);
//                if (clientResponse.getStatus() != 200) {
//                    logger.error(clientResponse.getStatus() + "");
//                    try {
//                        logger.error("Response from server: " + clientResponse.getEntity(String.class));
//                    } catch (Exception ex) {
//                        logger.error(ex);
//                    }
//
//                } else {
//                    sResponse = clientResponse.getEntity(String.class);
//                    if (sResponse != null && sResponse.toUpperCase().startsWith("NULL?")) {
//                        sResponse = sResponse.substring(5);
//                    }
//                    Map<String, String> params = parseQueryString(sResponse);
//                    String resData = params.get("DATA");
//                    String resSig = params.get("SIG");
//                    String resValue = null;
//                    String resKeyAES = null;
//                    if (resData != null && resSig != null) {
//                        resSig = URLDecoder.decode(resSig, "UTF-8");
//                        Boolean verify = EncryptManager.verifyMsgSignature(resSig, pub_key_VT, resData);
//                        if (verify) {
//                            resData = EncryptManager.decryptRSA(resData, pri_key_inet);
//
//                            Map<String, String> resParams = parseQueryString(resData);
//                            resValue = resParams.get("VALUE");
//                            resKeyAES = resParams.get("KEY");
//                            String notEncrypt = resValue;
//                            if (resValue != null && resKeyAES != null) {
//
//                                resValue = EncryptManager.decryptAES(resValue, resKeyAES);
//                                //System.out.println("resValue="+resValue);
//                                if (resValue != null) {
//                                    resParams = parseQueryString(resValue);
//                                    String sChargeResult = resParams.get("RES");
//                                    String sPrice = resParams.get("PRICE");
//                                    if (sChargeResult != null) {
//                                        try {
//                                            chargeResult[0] = Integer.parseInt(sChargeResult);
//                                            chargeResult[1] = Integer.parseInt(sPrice);
//                                        } catch (Exception e) {
//                                            // TODO: handle exception
//                                            logger.error("chargeResult k phai la so ,chargeResult=" + chargeResult);
//                                        }
//                                    } else {
//                                        logger.error("Khong tim thay tham so RES.Gia tri giai ma la" + resValue);
//                                    }
//                                } else {
//                                    logger.error("KEY=" + resValue);
//                                    logger.error("VALUE=" + notEncrypt);
//                                }
//                            } else {
//                                logger.error("resData=" + resData);
//                            }
//                        } else {
//                            logger.error("Verify khong thanh cong ");
//                            logger.error("DATA=" + resData);
//                            logger.error("SIG=" + resSig);
//                        }
//                    } else {
//                        logger.error("Response =" + sResponse);
//
//                    }
//                }
//
//
//            } catch (SocketTimeoutException e) {
//                logger.error(e);
//                endTime = System.currentTimeMillis();
//                logger.error("Time out " + (endTime - startTime) / 1000);
//                logger.error("SocketTimeoutException[" + value + "]");
//            } catch (IOException e) {
//                logger.error(e);
//                endTime = System.currentTimeMillis();
//                logger.error("Time out " + (endTime - startTime) / 1000);
//                logger.error("IOException[" + value + "]");
//            }
//            chargeLogDAO.insertRow(MobileTool.getStandardMobileNumber(mobile), cmd, chargeResult[1], chargeResult[0] + "", type, desc, req);
//        } catch (Exception e) {
//            logger.error(e);
//        }
//        return chargeResult[0];
//
//
//    }
//
//    public static int charge(String cmd, String desc, int price, String mobile, String src, int type, String parnerCode) {
//        String req = createCPRequestId();
//        mobile = MobileTool.getMobileNumberWithoutPre(mobile);
//        String value = "SUB=" + SUB + "&CATE=" + "&IMEI=123&ITEM=" + "&SUB_CP=" + "&CONT=" + desc + "&PRICE=" + price + "&REQ=" + req + "&MOBILE=" + mobile + "&SOURCE=" + src;
//        logger.log("value=" + value);
//        String data = null;
//        String signature = null;
//        String sRequest = "PRO=" + PRO + "&CMD=" + cmd + "&SER=" + SER + "&SUB=" + SUB;
//        String url = MPS_CHARGE_URL;
//
//        String sResponse = null;
//        int[] chargeResult = new int[]{-1, 0};
//        String encryptedValue = null;
//        long startTime = 0;
//        long endTime = 0;
//        startTime = System.currentTimeMillis();
//
//        try {
//            String keyAES = EncryptManager.AESKeyGen();
//            encryptedValue = EncryptManager.encryptAES(value, keyAES);
//            encryptedValue = "value=" + encryptedValue + "&key=" + keyAES;
//            data = EncryptManager.encryptRSA(encryptedValue, pub_key_VT);
//            signature = URLEncoder.encode(EncryptManager.createMsgSignature(data, pri_key_inet), "UTF-8");
//            sRequest = sRequest + "&DATA=" + URLEncoder.encode(data, "UTF-8") + "&SIG=" + signature;
//            url = url + "?" + sRequest;
//
//            try {
//                Client client = new Client();
//                WebResource r = client.resource(MPS_CHARGE_URL);
//                MultivaluedMap<String, String> map = new MultivaluedMapImpl();
//                map.add("PRO", PRO);
//                map.add("CMD", cmd);
//                map.add("SER", SER);
//                map.add("SUB", SUB);
//                map.add("DATA", URLEncoder.encode(data, "UTF-8"));
//                map.add("SIG", signature);
//
//                ClientResponse clientResponse = null;
//
//                clientResponse = r.queryParams(map).type(MediaType.TEXT_PLAIN).get(ClientResponse.class);
//                if (clientResponse.getStatus() != 200) {
//                    logger.error(clientResponse.getStatus() + "");
//                    try {
//                        logger.error("Response from server: " + clientResponse.getEntity(String.class));
//                    } catch (Exception ex) {
//                        logger.error(ex);
//                    }
//
//                } else {
//                    sResponse = clientResponse.getEntity(String.class);
//                    if (sResponse != null && sResponse.toUpperCase().startsWith("NULL?")) {
//                        sResponse = sResponse.substring(5);
//                    }
//                    Map<String, String> params = parseQueryString(sResponse);
//                    String resData = params.get("DATA");
//                    String resSig = params.get("SIG");
//                    String resValue = null;
//                    String resKeyAES = null;
//                    if (resData != null && resSig != null) {
//                        resSig = URLDecoder.decode(resSig, "UTF-8");
//                        Boolean verify = EncryptManager.verifyMsgSignature(resSig, pub_key_VT, resData);
//                        if (verify) {
//                            resData = EncryptManager.decryptRSA(resData, pri_key_inet);
//
//                            Map<String, String> resParams = parseQueryString(resData);
//                            resValue = resParams.get("VALUE");
//                            resKeyAES = resParams.get("KEY");
//                            String notEncrypt = resValue;
//                            if (resValue != null && resKeyAES != null) {
//
//                                resValue = EncryptManager.decryptAES(resValue, resKeyAES);
//                                //System.out.println("resValue="+resValue);
//                                if (resValue != null) {
//                                    resParams = parseQueryString(resValue);
//                                    String sChargeResult = resParams.get("RES");
//                                    String sPrice = resParams.get("PRICE");
//                                    if (sChargeResult != null) {
//                                        try {
//                                            chargeResult[0] = Integer.parseInt(sChargeResult);
//                                            chargeResult[1] = Integer.parseInt(sPrice);
//                                        } catch (Exception e) {
//                                            // TODO: handle exception
//                                            logger.error("chargeResult k phai la so ,chargeResult=" + chargeResult);
//                                        }
//                                    } else {
//                                        logger.error("Khong tim thay tham so RES.Gia tri giai ma la" + resValue);
//                                    }
//                                } else {
//                                    logger.error("KEY=" + resValue);
//                                    logger.error("VALUE=" + notEncrypt);
//                                }
//                            } else {
//                                logger.error("resData=" + resData);
//                            }
//                        } else {
//                            logger.error("Verify khong thanh cong ");
//                            logger.error("DATA=" + resData);
//                            logger.error("SIG=" + resSig);
//                        }
//                    } else {
//                        logger.error("Response =" + sResponse);
//
//                    }
//                }
//
//            } catch (Exception e) {
//                logger.error(e);
//                endTime = System.currentTimeMillis();
//                logger.error("Time out " + (endTime - startTime) / 1000);
//                logger.error("SocketTimeoutException[" + value + "]");
//            }
//            logger.log("result=" + chargeResult[0]);
//            chargeLogDAO.insertRow(MobileTool.getStandardMobileNumber(mobile), cmd, chargeResult[1], chargeResult[0] + "", type, desc, req, parnerCode);
//        } catch (Exception e) {
//            logger.error(e);
//        }
//        return chargeResult[0];
//
//
//    }
//
//    public static String buildQueryString(Map<String, String> params) {
//        Set<String> names = params.keySet();
//        Iterator<String> nameIterator = names.iterator();
//        String name = null;
//        String value = null;
//        String sQuery = null;
//        while (nameIterator.hasNext()) {
//            name = nameIterator.next();
//            value = params.get(name);
//            if (sQuery == null) {
//                sQuery = name + "=" + value;
//            } else {
//                sQuery += "&" + name + "=" + value;
//            }
//
//        }
//        return sQuery;
//    }
//
//    public static Map<String, String> parseQueryString(String sQuery) {
//        Map<String, String> params = new HashMap<String, String>();
//        Vector cParams = (Vector) StringTool.parseString(sQuery, "&");
//        String param = null;
//        String name = null;
//        String value = null;
//        for (int i = 0; i < cParams.size(); i++) {
//            param = (String) cParams.get(i);
//            if (param.indexOf("=") <= 0) {
//                continue;
//            }
//            name = param.substring(0, param.indexOf("="));
//            value = param.substring(param.indexOf("=") + 1);
//            params.put(name, value);
//        }
//        return params;
//    }
//
//    public static String createCPRequestId() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
//        String created = sdf.format(Calendar.getInstance().getTime());
//        String cpRequestId = CP_CODE + created;
//        cpRequestId = cpRequestId + chargeLogDAO.getOrderId();
//        //cpRequestId=cpRequestId+"001";
//        return cpRequestId;
//    }
//
//    public static void main(String[] arg) {
//        //System.out.println(SendRequest.excuteGet("http://lichvansu.wap.vn"));
//	    	/*
//         * for(int i=0;i<5;i++){
//         * //System.out.println(MPSChargeTool.charge2("MO", "Test", 100,
//         * "84982567818", "CLIENT", 2)); try { Thread.sleep(2000); } catch
//         * (Exception e) { // TODO: handle exception } }
//         */
//        try {
//            System.out.println(URLEncoder.encode("http://xoso.wap.vn", "UTF-8"));
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//
//    }
}
