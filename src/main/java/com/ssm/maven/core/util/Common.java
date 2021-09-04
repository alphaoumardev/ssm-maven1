package com.ssm.maven.core.util;

import java.util.List;

public class Common
{
    public static boolean isEmpty(List<String> noCacheMethod)
    {
        return noCacheMethod == null || noCacheMethod.size() < 1;
    }

    public static boolean isEmpty(Object[] args)
    {
        return args == null || args.length < 1;
    }

}
