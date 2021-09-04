package com.ssm.maven.core.util;

public class StringUtil
{
    public static boolean isEmpty(String str)
    {
        return str == null || "".equals(str.trim());
    }

    public static boolean isNotEmpty(String str)
    {
        return (str != null) && !"".equals(str.trim());
    }

    public static String formatLike(String str)
    {
        if (isNotEmpty(str))
        {
            return "%" + str + "%";
        }
        else
        {
            return null;
        }
    }
}
