package com.huang.pims.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 网络工具类
 */
public class NetworkUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(NetworkUtil.class);

    private static final String UNKNOWN = "unknown";

    public final static String getIpAddress(HttpServletRequest request) throws IOException {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
        String ip = request.getHeader("X-Forwarded-For");
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);
        }

        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);
                }
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!(UNKNOWN.equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }

}
