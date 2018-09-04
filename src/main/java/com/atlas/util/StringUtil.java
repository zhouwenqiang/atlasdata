package com.atlas.util;

/**
 * Created by Administrator on 2018/3/29.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil
{
    public static boolean empty(String param)
    {
        return (param == null) || (param.trim().length() < 1);
    }

    public static String fillstr(String src, int len, char defaultchar)
    {
        int srclen = src.length();
        StringBuffer targetstr = new StringBuffer(src);
        for (int i = srclen; i < len; i++) {
            targetstr.insert(0, defaultchar);
        }
        return targetstr.toString();
    }

    public static String parseObject(Object obj)
    {
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    public static Long parseLong(String s)
    {
        if (empty(s)) {
            return Long.valueOf(0L);
        }
        return new Long(s);
    }

    public static Long parseLong2(Object obj)
    {
        if (obj == null) {
            return null;
        }
        return new Long(obj.toString());
    }

    public static Date parseDate(Object obj)
    {
        if (obj == null) {
            return null;
        }
        return (Date)obj;
    }

    public static List<String> splitString(String str, int n)
    {
        List<String> strList = new ArrayList();
        Pattern p = Pattern.compile("^[\\u4e00-\\u9fa5]$");
        int end = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++)
        {
            String c = str.substring(i, i + 1);

            Matcher m = p.matcher(c);
            int tmp = m.find() ? 2 : 1;
            if (n == end + tmp)
            {
                sb.append(c);
                strList.add(sb.toString());
                sb = new StringBuffer();
                end = 0;
            }
            else if (n < end + tmp)
            {
                strList.add(sb.toString());
                sb = new StringBuffer();
                sb.append(c);
                end = tmp;
            }
            else
            {
                sb.append(c);
                end += tmp;
            }
        }
        if (!empty(sb.toString())) {
            strList.add(sb.toString());
        }
        return strList;
    }

    public static int getZhLength(Object obj)
    {
        return parseObject(obj).replaceAll("[��-��]", "**").length();
    }

    public static String fen2Yuan(String fen)
    {
        float yuan = Float.parseFloat(fen) / 100.0F;
        String str = String.valueOf(yuan);
        return str.replaceAll("(\\.(0)+)$", "");
    }

    public static String yuan2Fen(String yuan)
    {
        float fen = Float.parseFloat(yuan) * 100.0F;
        String str = String.valueOf(fen);
        return str.replaceAll("(\\.(0)+)$", "");
    }

    public static boolean isNumeric(String str)
    {
        boolean ret = false;
        if (str != null)
        {
            Pattern pattern = Pattern.compile("^[0-9]+$");
            ret = pattern.matcher(str.toLowerCase()).matches();
        }
        return ret;
    }

    public static String getSourceFromRequestUrl(String sourceUrl)
    {
        String sourceSign = "";
        int start = sourceUrl.indexOf("?");
        int end = sourceUrl.lastIndexOf("&");
        sourceSign = sourceUrl.substring(start, end);
        return sourceSign;
    }

    public static String sortOrginReqStr(String orginReqStr)
    {
        String[] strArray = orginReqStr.split("&");
        Arrays.sort(strArray);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strArray.length; i++)
        {
            sb.append(strArray[i]);
            if (i < strArray.length - 1) {
                sb.append("&");
            }
        }
        return sb.toString();
    }
}