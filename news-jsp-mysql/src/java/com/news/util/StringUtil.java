package com.news.util;

import java.io.CharArrayWriter;
import java.io.Reader;
import java.sql.Clob;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Replace/remove character in a String
 */
public class StringUtil {

    static final char NINE = (char) 0x39;
    static final char ZERO = (char) 0x30;
    static final char CH_a = (char) 'a';
    static final char CH_z = (char) 'z';
    static final char CH_A = (char) 'A';
    static final char CH_Z = (char) 'Z';

    public static String youtubeUrlToEmbed(String youtubeUrl) {
        String embed = youtubeUrl.replace("www.youtube.com/watch?v=", "//www.youtube.com/v/");
        embed = embed.replace("youtu.be/", "youtube.com/v/");
        return embed;
    }

    public static String appendString(String oldS, int pos, String s) {
        return (oldS.substring(0, pos) + s + oldS.substring(pos));
    }

    // To replace a character at a specified position
    public static String replaceCharAt(String s, int pos, char c) {
        // return s.substring(0, pos) + c + s.substring(pos + 1);
        StringBuffer buf = new StringBuffer(s);
        buf.setCharAt(pos, c);
        return buf.toString();
    }

    // replace char with string
    public static String replaceChar(String s, char a, String b) {
        if (s == null) {
            return null;
        }

        StringBuffer newString = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == a) {
                newString.append(b);
            } else {
                newString.append(cur);
            }
        }
        return newString.toString();
    }

    // To remove a character
    public static String removeChar(String s, char c) {
        if (s == null) {
            return null;
        }

        StringBuffer newString = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur != c) {
                newString.append(cur);
            }
        }
        return newString.toString();
    }

    // To remove a character at a specified position
    public static String removeCharAt(String s, int pos) {
        // return s.substring(0, pos) + s.substring(pos + 1);
        StringBuffer buf = new StringBuffer(s.length() - 1);
        buf.append(s.substring(0, pos)).append(s.substring(pos + 1));
        return buf.toString();
    }

    // .,*/abc --> abc
    public static String removeSpecialCharsInFront(String s) {
        if (s == null) {
            return null;
        }
        String result = "";
        char currChar;
        for (int i = 0; i < s.length(); i++) {
            currChar = s.charAt(i);
            if ((currChar >= ZERO && currChar <= NINE)
                    || (currChar >= CH_a && currChar <= CH_z)
                    || (currChar >= CH_A && currChar <= CH_Z)) {
                result = s.substring(i);
                break;
            }
        }
        return result;
    }

    public static String formatString(String s) {
        s = s.replaceFirst("Lo?i m�y", "<b>Lo?i m�y</b>");
        s = s.replaceFirst("\n", "<br>");
        return s;
    }

    // "a.b-c" --> "abc"
    public static String removeSpecialCharsInString(String s) {
        if (s == null) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if ((ch >= ZERO && ch <= NINE) || (ch >= CH_a && ch <= CH_z)
                    || (ch >= CH_A && ch <= CH_Z)) {
                buffer.append(ch);
            }
        }
        return buffer.toString();
    }

    public static String only2SpaceBetweenWords(String text) {
        if (text == null) {
            return null;
        }

        StringBuffer buffer = new StringBuffer();
        boolean lastCharIsSpace = false;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == 0x20) {
                if (lastCharIsSpace) {
                    continue;
                } else {
                    lastCharIsSpace = true;
                }
            } else if (lastCharIsSpace) {
                lastCharIsSpace = false;
            }
            buffer.append(ch);
        }
        return buffer.toString();
    }

    /*
     * In text: a string having some seperator(s) Out a collection of elements
     * without (between) seperator
     */
    public static Collection parseString(String text, String seperator) {
        Vector vResult = new Vector();
        if (text == null || "".equals(text)) {
            return vResult;
        }

        String tempStr = text.trim();
        String currentLabel = null;

        int index = tempStr.indexOf(seperator);
        while (index != -1) {
            currentLabel = tempStr.substring(0, index).trim();
            // Only accept not null element
            if (!"".equals(currentLabel)) {
                vResult.addElement(currentLabel);
            }
            tempStr = tempStr.substring(index + seperator.length());
            index = tempStr.indexOf(seperator);
        }
        // Last label
        currentLabel = tempStr.trim();
        if (!"".equals(currentLabel)) {
            vResult.addElement(currentLabel);
        }
        return vResult;
    }

    public static Collection parseString(Collection vResult, String text,
            String seperator) {

        if (text == null || "".equals(text)) {
            return vResult;
        }

        String tempStr = text.trim();
        String currentLabel = null;

        int index = tempStr.indexOf(seperator);
        while (index != -1) {
            currentLabel = tempStr.substring(0, index).trim();
            // Only accept not null element
            if (!"".equals(currentLabel)) {
                vResult.add(currentLabel);
            }
            tempStr = tempStr.substring(index + 1);
            index = tempStr.indexOf(seperator);
        }
        // Last label
        currentLabel = tempStr.trim();
        if (!"".equals(currentLabel)) {
            vResult.add(currentLabel);
        }
        return vResult;
    }
    final static String[] seperators = {" ", ".", ",", "-", "_", "=", "\n", "'"};

    public static Collection parseString(String text) {
        Vector vResult = new Vector();
        if (text == null || "".equals(text)) {
            return vResult;
        }

        String tempStr = text.trim();
        String currentLabel = null;

        int index = getNextIndex(tempStr);
        while (index != -1) {
            currentLabel = tempStr.substring(0, index).trim();
            // Only accept not null element
            if (!"".equals(currentLabel)) {
                vResult.addElement(currentLabel);
            }
            tempStr = tempStr.substring(index + 1);
            index = getNextIndex(tempStr);
        }
        // Last label
        currentLabel = tempStr.trim();
        if (!"".equals(currentLabel)) {
            vResult.addElement(currentLabel);
        }
        return vResult;
    }

    public static Collection parseString(Collection vResult, String text) {

        if (text == null || "".equals(text)) {
            return vResult;
        }

        String tempStr = text.trim();
        String currentLabel = null;

        int index = getNextIndex(tempStr);
        while (index != -1) {
            currentLabel = tempStr.substring(0, index).trim();
            // Only accept not null element
            if (!"".equals(currentLabel)) {
                vResult.add(currentLabel);
            }
            tempStr = tempStr.substring(index + 1);
            index = getNextIndex(tempStr);
        }
        // Last label
        currentLabel = tempStr.trim();
        if (!"".equals(currentLabel)) {
            vResult.add(currentLabel);
        }
        return vResult;
    }

    private static int getNextIndex(String text) {
        int index = 0;
        int newIdx = 0;
        boolean hasOne = false;
        for (int i = 0; i < seperators.length; i++) {
            newIdx = text.indexOf(seperators[i]);
            if (!hasOne) {
                if (newIdx != -1) {
                    index = newIdx;
                    hasOne = true;
                }
            } else if (newIdx != -1) {
                if (newIdx < index) {
                    index = newIdx;
                }
            }
        }
        if (!hasOne) {
            index = -1;
        }
        return index;
    }

    /*
     * Seperator is any charactor not in rage of (0-9), (a-z), (A-Z)
     */
    public static Collection parseStringEx(String text) {
        Vector vResult = new Vector();
        if (text == null || "".equals(text)) {
            return vResult;
        }
        Vector data = new Vector();
        String tempStr = text.trim();
        String currLabel = "";
        char currChar = 0;
        for (int i = 0; i < tempStr.length(); i++) {
            currChar = tempStr.charAt(i);
            if ((currChar >= ZERO && currChar <= NINE)
                    || (currChar >= CH_a && currChar <= CH_z)
                    || (currChar >= CH_A && currChar <= CH_Z)) {
                currLabel = currLabel + currChar;
            } else if (currLabel.length() > 0) {
                vResult.add(currLabel);
                currLabel = new String("");
            }
        }
        // last label
        if (currLabel.length() > 0) {
            vResult.add(currLabel);
        }
        return vResult;
    }

    public static boolean isNumberic(String sNumber) {
        if (sNumber == null || "".equals(sNumber)) {
            return false;
        }
        char ch_max = (char) 0x39;
        char ch_min = (char) 0x30;

        for (int i = 0; i < sNumber.length(); i++) {
            char ch = sNumber.charAt(i);
            if ((ch < ch_min) || (ch > ch_max)) {
                return false;
            }
        }
        return true;
    }
    /**
     * ***********************************************************************
     */
    /*
     * GENERATE RANDOM STRING OF CHARACTERS
     */
    /**
     * ***********************************************************************
     */
    private static char[] charArray = null; // Holds an array of character (used
    // to get the random character for
    // the random string)
    private static Random random = null; // random object
    // Create an arrays of characters (A--Z, 0--9)

    static {
        int numOfChars = 'Z' - 'A' + 1;
        int numOfDigits = '9' - '0' + 1;

        random = new Random(); // create a random object

        charArray = new char[numOfChars + numOfDigits];
        for (int i = 0; i < numOfChars; i++) {
            charArray[i] = (char) ('A' + i);
        }
        for (int i = 0; i < numOfDigits; i++) {
            charArray[numOfChars + i] = (char) ('0' + i);
        }
        // System.out.println(charArray);
    }

    // returns a random string of chars: A--Z, 0--9
    public static String generateRandomString(int length) {
        char[] ch = new char[length];
        for (int i = 0; i < length; i++) {
            ch[i] = charArray[random.nextInt(charArray.length)];
        }
        return new String(ch);
    }

    public static String nvl(Object input, String nullValue) {
        if (input == null) {
            return nullValue;
        }
        return input.toString();
    }

    public static String[] toStringArray(String strSource, String strSeparator) {
        Vector vtReturn = toStringVector(strSource, strSeparator);
        String strReturn[] = new String[vtReturn.size()];
        for (int iIndex = 0; iIndex < strReturn.length; iIndex++) {
            strReturn[iIndex] = (String) vtReturn.elementAt(iIndex);
        }

        return strReturn;
    }

    public static Vector toStringVector(String strSource, String strSeparator) {
        Vector vtReturn = new Vector();
        int iIndex = 0;
        int iLastIndex;
        for (iLastIndex = 0; (iIndex = strSource.indexOf(strSeparator,
                iLastIndex)) >= 0; iLastIndex = iIndex + strSeparator.length()) {
            vtReturn.addElement(strSource.substring(iLastIndex, iIndex).trim());
        }

        if (iLastIndex <= strSource.length()) {
            vtReturn.addElement(strSource.substring(iLastIndex,
                    strSource.length()).trim());
        }
        return vtReturn;
    }

    public static String[] toStringArray(String strSource) {
        return toStringArray(strSource, ",");
    }

    public static String format(Date dtImput, String strPattern) {
        if (dtImput == null) {
            return null;
        } else {
            SimpleDateFormat fmt = new SimpleDateFormat(strPattern);
            return fmt.format(dtImput);
        }
    }

    public static String format(long input) {
        DecimalFormat df = new DecimalFormat("#,###,###");
        return df.format(input);
    }

    public static String getString(Clob clobData) {
        if (clobData == null) {
            return null;
        }
        String content = "";
        try {
            Reader reader = clobData.getCharacterStream();
            CharArrayWriter writer = new CharArrayWriter();
            int i = -1;
            while ((i = reader.read()) != -1) {
                writer.write(i);
            }
            content = new String(writer.toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    public static String implodeStringArray(String[] inputArray, String glueString, String wrapperElementCharacter) {

        /**
         * Output variable
         */
        String output = "";

        if (inputArray.length > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(wrapperElementCharacter + inputArray[0].toUpperCase() + wrapperElementCharacter);

            for (int i = 1; i < inputArray.length; i++) {
                sb.append(glueString);
                sb.append(wrapperElementCharacter + inputArray[i].toUpperCase() + wrapperElementCharacter);
            }

            output = sb.toString();
        }

        return output;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    private static char[] SPECIAL_CHARACTERS = {
        'À', 'Á', 'Â', 'Ã', 'È', 'É', 'Ê', 'Ì', 'Í', 'Ò', 'Ó', 'Ô', 'Õ',
        'Ù', 'Ú', 'Ý', 'à', 'á', 'â', 'ã', 'è', 'é', 'ê', 'ì', 'í', 'ò',
        'ó', 'ô', 'õ', 'ù', 'ú', 'ý', 'Ă', 'ă', 'Đ', 'đ', 'Ĩ', 'ĩ', 'Ũ',
        'ũ', 'Ơ', 'ơ', 'Ư', 'ư', 'Ạ', 'ạ', 'Ả', 'ả', 'Ấ', 'ấ', 'Ầ', 'ầ',
        'Ẩ', 'ẩ', 'Ẫ', 'ẫ', 'Ậ', 'ậ', 'Ắ', 'ắ', 'Ằ', 'ằ', 'Ẳ', 'ẳ', 'Ẵ',
        'ẵ', 'Ặ', 'ặ', 'Ẹ', 'ẹ', 'Ẻ', 'ẻ', 'Ẽ', 'ẽ', 'Ế', 'ế', 'Ề', 'ề',
        'Ể', 'ể', 'Ễ', 'ễ', 'Ệ', 'ệ', 'Ỉ', 'ỉ', 'Ị', 'ị', 'Ọ', 'ọ', 'Ỏ',
        'ỏ', 'Ố', 'ố', 'Ồ', 'ồ', 'Ổ', 'ổ', 'Ỗ', 'ỗ', 'Ộ', 'ộ', 'Ớ', 'ớ',
        'Ờ', 'ờ', 'Ở', 'ở', 'Ỡ', 'ỡ', 'Ợ', 'ợ', 'Ụ', 'ụ', 'Ủ', 'ủ', 'Ứ',
        'ứ', 'Ừ', 'ừ', 'Ử', 'ử', 'Ữ', 'ữ', 'Ự', 'ự', 'ỵ', 'Ỵ', 'ỷ', 'Ỷ',
        'ý', 'Ý', 'ỳ', 'Ỳ', 'ỹ', 'Ỹ'
    };
    private static char[] REPLACEMENTS = {
        'A', 'A', 'A', 'A', 'E', 'E', 'E', 'I', 'I', 'O', 'O', 'O', 'O',
        'U', 'U', 'Y', 'a', 'a', 'a', 'a', 'e', 'e', 'e', 'i', 'i', 'o',
        'o', 'o', 'o', 'u', 'u', 'y', 'A', 'a', 'D', 'd', 'I', 'i', 'U',
        'u', 'O', 'o', 'U', 'u', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a',
        'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A',
        'a', 'A', 'a', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e',
        'E', 'e', 'E', 'e', 'E', 'e', 'I', 'i', 'I', 'i', 'O', 'o', 'O',
        'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o',
        'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'U', 'u', 'U', 'u', 'U',
        'u', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u', 'y', 'Y', 'y', 'Y',
        'y', 'Y', 'y', 'Y', 'y', 'Y'};

    public static char utf82ascii(char ch) {
        int index = Arrays.binarySearch(SPECIAL_CHARACTERS, ch);
        if (index >= 0) {
            ch = REPLACEMENTS[index];
        }
        return ch;
    }

    public static String utf82ascii(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, utf82ascii(sb.charAt(i)));
        }
        return sb.toString();
    }
    
    private static Map<Integer, String> mDay = new HashMap<Integer, String>();
    private static Map<Integer, String> mMonth = new HashMap<Integer, String>();
    static{
        mDay.put(1, "Chủ nhật");
        mDay.put(2, "Thứ hai");
        mDay.put(3, "Thứ ba");
        mDay.put(4, "Thứ tư");
        mDay.put(5, "Thứ năm");
        mDay.put(6, "Thứ sáu");
        mDay.put(7, "Thứ bảy");        
        
        mMonth.put(1, "Tháng một");
        mMonth.put(2, "Tháng hai");
        mMonth.put(3, "Tháng ba");
        mMonth.put(4, "Tháng tư");
        mMonth.put(5, "Tháng năm");
        mMonth.put(6, "Tháng sáu");
        mMonth.put(7, "Tháng bảy");
        mMonth.put(8, "Tháng tám");
        mMonth.put(9, "Tháng chín");
        mMonth.put(10, "Tháng mười");
        mMonth.put(11, "Tháng mười một");
        mMonth.put(12, "Tháng mười hai");
    }
    public static String date2StringSpecialPattern(long time){        
        Calendar c=Calendar.getInstance();
        c.setTimeInMillis(time);
        String strTime = mDay.get(c.get(Calendar.DAY_OF_WEEK)) + ", ";
        strTime += c.get(Calendar.DAY_OF_MONTH) + " " + mMonth.get(c.get(Calendar.MONTH) + 1) + " " + c.get(Calendar.YEAR) + ", " 
                + (c.get(Calendar.HOUR) < 10 ? "0" + c.get(Calendar.HOUR) : c.get(Calendar.HOUR)) 
                + ":" + (c.get(Calendar.MINUTE) < 10 ? "0" + c.get(Calendar.MINUTE) : c.get(Calendar.MINUTE)) 
                + " " + (c.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM");
        return strTime;
    }

}
