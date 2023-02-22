package ru.geekbrains.carts.utils;

import javax.servlet.http.HttpServletRequest;

public class WebUtils
{
    private WebUtils() { }

    public static final String IMAGES_PREFIX = "/products/images/";

    public static String getURLWithContextPath(HttpServletRequest request)
    {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath();
    }
}

