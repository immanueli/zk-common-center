package com.zkdn.zk.common.core.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * @Description:
 * @Author:Brain
 * @Date:2018/12/28
 **/
@Slf4j
public class ClientUtil {

    /**
     * 获取客户端真实ip
     * @param request
     * @return
     */
    public static String getClientIp(HttpServletRequest request){
        String ip = request.getHeader("X-Forwarded-For");
        String key = ",";
        if (ip != null && ip.indexOf(key) > 0) {
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            ip = ip.substring(0, ip.indexOf(","));
        }
        key = "unknown";
        if (StringUtils.isBlank(ip) || key.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || key.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || key.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(ip) || key.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(ip) || key.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (StringUtils.isBlank(ip) || key.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        String localhostIp = "127.0.0.1";
        String remoteIp = "0:0:0:0:0:0:0:1";
        if (localhostIp.equals(ip) || remoteIp.equals(ip)) {
            Enumeration<NetworkInterface> netInterfaces = null;
            try {
                netInterfaces = NetworkInterface.getNetworkInterfaces();
                a:
                while (netInterfaces.hasMoreElements()) {
                    NetworkInterface ni = netInterfaces.nextElement();
                    if(log.isDebugEnabled()) {
                        log.debug("DisplayName:[{}]" ,ni.getDisplayName());
                        log.debug("Name:[{}]" ,ni.getName());
                    }
                    Enumeration<InetAddress> ips = ni.getInetAddresses();
                    while (ips.hasMoreElements()) {
                        ip = ips.nextElement().getHostAddress();
                        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
                            break a;
                        }
                    }
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        if(log.isDebugEnabled()) {
            log.debug("getRemoteAddr ip: [{}]" ,ip);
        }
        return ip;
    }

}
