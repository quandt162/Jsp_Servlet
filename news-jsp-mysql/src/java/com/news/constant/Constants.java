/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.constant;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrator
 */
public class Constants {

    public static boolean THREAD_RUNNING = true;
    public static final String DATABASE = "yte";
    public static final String UNDER_SCORE = "_";
    public static final String COMMA = ",";
    public static final long FIVE_SECONDS = 5 * 1000;
    public static final long FIVE_MINUS = 5 * 60 * 1000;
    public static final long ONE_MINUS = 1 * 60 * 1000;
    public static final long TEN_MINUS = 10 * 60 * 1000;
    public static final long ONE_HOUR = 6 * TEN_MINUS;
    public static final long ONE_DAY = 24 * ONE_HOUR;
    public static final long ONE_MONTH = 30 * ONE_DAY;

    //for DEMO
    public static final String DEMOS = "DEMOS";
    public static final String COUNT_ALL = "COUNT_ALL";
    public static final String PARTNERS = "PARTNERS";
    public static final String NEWSCATEGORYS = "NEWSCATEGORYS";
    public static final String POSTCATEGORYS = "POSTCATEGORYS";
    public static final String GET_POST_BY_URL = "GET_POST_BY_URL";
    public static final String GET_POST_BY_ID = "GET_POST_BY_ID";
    public static final String DISPLAY_POST_HOME_PAGE = "DISPLAY_POST_HOME_PAGE";
    public static final String LIST_CHILD_POST = "LIST_CHILD_POST";
    
    public static final String SYSTEMCONFIG = "SYSTEMCONFIG";
    public static final String ALL = "ALL";
    public static final String PARTNER_SERCICES = "PARTNER_SERCICES";
    public static final Integer PARTNER_SERCICES_STATUS_ACTIVE = 1;
    public static final Integer PARTNER_SERCICES_STATUS_INACTIVE = 0;
    public static final Integer PARTNER_STATUS_ACTIVE = 1;
    public static final Integer PARTNER_STATUS_INACTIVE = 0;
    public static final String PARTNER_ID = "PARTNER_ID";
    public static final String ADVERTISEMENT = "ADVERTISEMENT";
    public static final Integer ADVERTISEMENT_STATUS_DISPLAY = 1;
    public static final Integer ADVERTISEMENT_STATUS_DISABLE = 0;
    public static final String NEWSMEDICAMENT = "NEWSMEDICAMENT";
     public static final String POST_VIDEO = "POST_VIDEO";

    public static final String MEDICATEMENT_SELECT_ITEM = "MEDICATEMENT_SELECT_ITEM";
    
    public static final String VIDEO_SELECT_ITEM = "VIDEO_SELECT_ITEM";
    //for Login
    public static final String LOGIN_SESSION = "LOGIN_SESSION";

    // advertisement position
    public static final Map<Integer, String> mapPosition = new HashMap<>();
    public static final Map<Integer, String> mapPositionSize = new HashMap<>();
    public static final Integer ADVERTISEMENT_POSITION_VALUE_1 = 1;
    public static final Integer ADVERTISEMENT_POSITION_VALUE_2 = 2;
    public static final Integer ADVERTISEMENT_POSITION_VALUE_3 = 3;
    public static final Integer ADVERTISEMENT_POSITION_VALUE_4 = 4;
    public static final String ADVERTISEMENT_POSITION_1 = "Trang chủ trái 1";
    public static final String ADVERTISEMENT_POSITION_2 = "Trang chủ trái 2";
    public static final String ADVERTISEMENT_POSITION_3 = "Trang chủ trái 3";
    public static final String ADVERTISEMENT_POSITION_4 = "Trang chủ trái 4";
    public static final String ADVERTISEMENT_POSITION_SIZE_1 = "Kích cỡ ảnh là 295 x 325";
    public static final String ADVERTISEMENT_POSITION_SIZE_2 = "Kích cỡ ảnh là 280 x 185";
    public static final String ADVERTISEMENT_POSITION_SIZE_3 = "Kích cỡ ảnh là 280 x 185";
    public static final String ADVERTISEMENT_POSITION_SIZE_4 = "Kích cỡ ảnh là 280 x 185";

    static {
        mapPosition.put(ADVERTISEMENT_POSITION_VALUE_1, ADVERTISEMENT_POSITION_1);
        mapPosition.put(ADVERTISEMENT_POSITION_VALUE_2, ADVERTISEMENT_POSITION_2);
        mapPosition.put(ADVERTISEMENT_POSITION_VALUE_3, ADVERTISEMENT_POSITION_3);
        mapPosition.put(ADVERTISEMENT_POSITION_VALUE_4, ADVERTISEMENT_POSITION_4);
        mapPositionSize.put(ADVERTISEMENT_POSITION_VALUE_1, ADVERTISEMENT_POSITION_SIZE_1);
        mapPositionSize.put(ADVERTISEMENT_POSITION_VALUE_2, ADVERTISEMENT_POSITION_SIZE_2);
        mapPositionSize.put(ADVERTISEMENT_POSITION_VALUE_3, ADVERTISEMENT_POSITION_SIZE_3);
        mapPositionSize.put(ADVERTISEMENT_POSITION_VALUE_4, ADVERTISEMENT_POSITION_SIZE_4);

    }

    public static final String NEWS = "NEWS";
    public static final String NEWS_DISPLAY = "NEWS_DISPLAY";
    public static final String NEWS_DETAIL = "NEWS_DETAIL";
    
    public static final String POST = "POST";
    public static final String POST_SPECIAL = "POST_SPECIAL";
    public static final String POST_DISPLAY = "POST_DISPLAY";
    public static final String POST_DETAIL = "POST_DETAIL";
    public static final String MEDICAMENT = "MEDICAMENT";
    public static final String MEDICAMENT_BESTBUY = "MEDICAMENT_BESTBUY";
    public static final String MEDICAMENT_BESTNEWS = "MEDICAMENT_BESTNEWS";
    public static final String MEDICAMENT_BESTNEWS_ALL = "MEDICAMENT_BESTNEWS_ALL";
    
    public static final String VIDEO = "VIDEO";
    public static final String VIDEO_BESTBUY = "VIDEO_BESTBUY";
    public static final String VIDEO_BESTNEWS = "VIDEO_BESTNEWS";
    public static final String VIDEO_BESTNEWS_ALL = "VIDEO_BESTNEWS_ALL";
    
    
    public static final String DISCOUNT_PERCENT = "DISCOUNT_PERCENT";
    public static final String DISCOUNT_PERCENT_All = "DISCOUNT_PERCENT_ALL";
    public static final String MEDICAMENT_BY_CATEGORY_ID = "MEDICAMENT_BY_CATEGORY_ID";
    public static final String MEDICAMENT_BY_ID = "MEDICAMENT_BY_ID";
    public static final String MEDICAMENT_SLIDE = "MEDICAMENT_SLIDE";
    public static final String MEDICAMENT_COUNT_ALL_BY_CATEGORY_ID = "MEDICAMENT_COUNT_ALL_BY_CATEGORY_ID";
    public static final String MEDICAMENT_COUNT_BEST_BUY = "MEDICAMENT_COUNT_BEST_BUY";
    public static final String MEDICAMENT_COUNT_BEST_NEW = "MEDICAMENT_COUNT_BEST_NEW";
    public static final String MEDICAMENT_COUNT_DISCOUNT_PERCENT = "MEDICAMENT_COUNT_DISCOUNT_PERCENT";
    public static final String SLIDE_DISPLAY = "SLIDE_DISPLAY";
    public static final String MEDICAMENT_DETAIL = "MEDICAMENT_DETAIL";
    
    public static final String VIDEO_DETAIL = "VIDEO_DETAIL";
    public static final String VIDEO_BY_CATEGORY_ID = "VIDEO_BY_CATEGORY_ID";
    public static final String VIDEO_BY_ID = "VIDEO_BY_ID";
    public static final String VIDEO_SLIDE = "VIDEO_SLIDE";
    public static final String VIDEO_COUNT_ALL_BY_CATEGORY_ID = "VIDEO_COUNT_ALL_BY_CATEGORY_ID";
    public static final String VIDEO_COUNT_BEST_BUY = "VIDEO_COUNT_BEST_BUY";
    public static final String VIDEO_COUNT_BEST_NEW = "VIDEO_COUNT_BEST_NEW";
    public static final String VIDEO_COUNT_DISCOUNT_PERCENT = "VIDEO_COUNT_DISCOUNT_PERCENT";
    

    public static final String SALE_OFF = "SALE_OFF";

    public static final int NEWS_STATUS_DISABLE = 0;
    public static final int NEWS_STATUS_DISPLAY = 1;
    public static final int NEWS_STATUS_UN_DISPLAY = 2;
    
    
     public static final int POST_STATUS_DISABLE = 0;
    public static final int POST_STATUS_DISPLAY = 1;
    public static final int POST_STATUS_UN_DISPLAY = 2;
    public static final int POST_SHARE_STATUS_DISABLE = 0;
    public static final int POST_SHARE_STATUS_DISPLAY = 1;
    public static final int POST_SHARE_STATUS_UN_DISPLAY = 2;
    
     public static final int NEWS_CATEGORY_STATUS_DISABLE = 0;
    public static final int NEWS_CATEGORY_STATUS_DISPLAY = 1;
    public static final int NEWS_CATEGORY_STATUS_UN_DISPLAY = 2;
    
    public static final int POST_CATEGORY_STATUS_DISABLE = 0;
    public static final int POST_CATEGORY_STATUS_DISPLAY = 1;
    public static final int POST_CATEGORY_STATUS_UN_DISPLAY = 2;

    public static final int SALE_OFF_STATUS_DISABLE = 0;
    public static final int SALE_OFF_STATUS_DISPLAY = 1;
    public static final int SALE_OFF_STATUS_UN_DISPLAY = 2;
    public static final String SALE_OFF_DETAIL = "SALE_OFF_DETAIL";

    public static final int MEDICAMENT_STATUS_DISABLE = 0;
    public static final int MEDICAMENT_DISPLAY = 1;
    public static final int MEDICAMENT_HOT = 2;
    public static final int MEDICAMENT_DISPLAY_SLIDE = 3;
    public static final int MEDICAMENT_BEST_BUY = 4;
    
    public static final int VIDEO_CATEGORY_STATUS_DISABLE = 0;
    public static final int VIDEO_CATEGORY_STATUS_DISPLAY = 1;
    public static final int VIDEO_STATUS_DISABLE = 0;
    public static final int VIDEO_DISPLAY = 1;
    public static final int VIDEO_HOT = 2;
    public static final int VIDEO_DISPLAY_SLIDE = 3;
    public static final int VIDEO_BEST_BUY = 4;
    public static final int VIDEO_NEW = 4;
    public static final Integer SLIDE_POSITION_1 = 1;
    public static final int VIDEO_SPECIAL_STATUS = 1;
    public static final int VIDEO_REPRESENT_STATUS = 1;
     public static final int POST_SHARE_REPRESENT_STATUS = 1;

    //for ADMIN
    public static final int RIGHT_ADMIN = 0;
    public static final int RIGHT_POSTER = 1;
    public static final int RIGHT_APPROVER = 2;
    public static final int RIGHT_PARTNER = 3;
    public static final int RIGHT_POSTER_NEWS = 4;
    public static final int RIGHT_POSTER_MEDICANMENT = 5;
    public static final int RIGHT_POSTER_SMS = 6;
    public static final int RIGHT_AFF = 7;

    //for menu client
    public static final String ALL_MENU = "ALL_MENU";
    public static final String MED_CATEGORY_HOME_PAGE = "MED_CATEGORY_HOME_PAGE";
    public static final String VIDEO_CATEGORY_HOME_PAGE = "VIDEO_CATEGORY_HOME_PAGE";

    public static final int START_ROW = 1;
    public static final int LIMIT_ROW_DETAIL = 4;
    //for session cart
    public static final String CART_SESSION = "CART_SESSION";
    //for session user
    public static final String USER_SESSION = "USER_SESSION";
    //for session edit order
    public static final String EDIT_ORDER_SESSION = "EDIT_ORDER_SESSION";

    public static final int MEDICATEMENT_COMMENT_DISABLE = 0;
    public static final int MEDICATEMENT_COMMENT_DISPLAY = 1;
    //for login google
    //local
//    public static final String GOOGLE_REDIRECT_URL = "http://localhost:8084/thuoc/dang-nhap/google";
    public static final String GOOGLE_REDIRECT_URL = "http://thuoc.net/dang-nhap/google";
    //for payment type
    public static final int PAYTYPE_SKNH = 0;
    public static final int PAYTYPE_CK = 1;
    public static final int PAYTYPE_INET_PAY = 2;
    public static final int MEDICAMENT_COMMENT_DISPLAY = 1;
    public static final int MEDICAMENT_COMMENT_DISABLE = 0;
    
    public static final int VIDEO_COMMENT_DISABLE = 0;
    //for affliate session
    public static final String AFF_SESSION = "AFF_SESSION";
    public static final String MEDICAMENT_RELATIONSHIP = "MEDICAMENT_RELATIONSHIP";
    public static final String VIDEO_RELATIONSHIP = "VIDEO_RELATIONSHIP";
    public static final String MEDICAMENT_RELATIONSHIP_EDIT = "MEDICAMENT_RELATIONSHIP_EDIT";
    //for upload images - folder
    public static final String NEWS_FOLDER = "news";
    public static final String SPEAKER_FOLDER = "speaker"; 
    public static final String SALE_OFF_FOLDER = "sale-off";    
    public static final String MEDICAMENT_FOLDER = "medicament";    
    public static final String ADVERTISEMENT_FOLDER = "advertisement";    
    public static final String SLIDE_FOLDER = "slide";   
    public static final String POST_FOLDER = "post";   
    public static final String PRODUCT_FOLDER = "product";   
    public static final String VIDEO_FOLDER = "video";
    public static final String TH_PACKAGE = "TH"; 
    //for POST TYPE
    public static final String POST_TYPE_TAI_LIEU = "TAILIEU"; 
    public static final String POST_TYPE_KHOA_HOC = "KHOAHOC"; 
    public static final String POST_TYPE_TIN_TUC = "TINTUC";
    public static final String POST_TYPE_SLIDE = "SLIDE";
    public static final String POST_TYPE_PRODUCT = "PRODUCT";
    
    
    public static final int POST_SPECIAL_STATUS = 1; 
    public static final int POST_TYPE_SPEAKER = 2; 
    public static final int FEATURED_ACTION = 0;
    public static final int APPROVAL_ACTION = 1;
    public static final int DELETE_ACTION = 2;
    
    public static final int FEATURD_STT = 1;
    public static final int UN_FEATURD_STT = 0;
    
    public static final int STT_ACTIVE = 1;
    public static final int STT_SMS = 2;
    public static final int STT_REGIST = 3;
    
    // log
    public static final String LOG_LOGIN = "Đăng nhập";
    public static final String LOG_LOGOUT = "Đăng xuất";
    public static final String LOG_REGIST = "Đăng ký";
    public static final String LOG_CANCEL = "Hủy dịch vụ";
    public static final String LOG_VIEW_VIDEO = "Xem video";
    public static final String CHANNEL_WEB = "Web";
    public static final String CHANNEL_WAP = "Wap";
    //for cart
    public static final String CART_PRODUCTS = "CART_PRODUCTS";
}
