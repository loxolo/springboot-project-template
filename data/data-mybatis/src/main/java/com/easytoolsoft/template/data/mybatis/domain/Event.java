package com.easytoolsoft.template.data.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用户操作事件或日志(ezrpt_member_event表)持久化类
 *
 * @author zhiwei.deng
 * @date 2017-03-25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Event implements Serializable {
    /**
     * 日志标识
     */
    private Integer id;
    /**
     * 日志来源
     */
    private String source;
    /**
     * 操作用户id
     */
    private Integer userId;
    /**
     * 操作用户账号
     */
    @NotEmpty
    private String account;
    /**
     * 日志级别
     */
    private String level;
    /**
     * 日志信息
     */
    @NotEmpty
    private String message;
    /**
     * url
     */
    private String url;
    /**
     * 日志发生的时间
     */
    private Date gmtCreated;
}
