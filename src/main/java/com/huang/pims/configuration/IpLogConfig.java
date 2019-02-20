package com.huang.pims.configuration;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.huang.pims.Constants.Constants;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Objects;

/**
 * 获取IP工具类 打印日志使用
 *
 * @author lius
 */
public class IpLogConfig extends ClassicConverter {

    private static String firstLocalHostIp = null;

    @Override
    public String convert(ILoggingEvent event) {
        String ip = null;
        try {
            ip = getFirstLocalHostIp();
        } catch (SocketException e) {
            // do nothing
        }
        return ip;
    }

    private static String getFirstLocalHostIp() throws SocketException {
        if (!Objects.isNull(firstLocalHostIp)) {
            return firstLocalHostIp;
        }
        Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip ;
        String ipStr = Constants.LOCALHOST_IP;
        while (allNetInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = allNetInterfaces.nextElement();
            Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                ip = addresses.nextElement();
                if (ip instanceof Inet4Address && !ipStr.equals(ip.getHostAddress())) {
                    firstLocalHostIp = ip.getHostAddress();
                    ipStr = ip.getHostAddress();
                    break;
                }
            }
            if (!Objects.isNull(firstLocalHostIp)) {
                break;
            }
        }
        return ipStr;
    }
}
