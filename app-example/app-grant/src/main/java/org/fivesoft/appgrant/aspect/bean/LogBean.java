package org.fivesoft.appgrant.aspect.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * log实体
 * @author wenx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LogBean {

    private String url;
    private String method;
    private String action;
    private String params;
    private String response;
    private String ip;
}
