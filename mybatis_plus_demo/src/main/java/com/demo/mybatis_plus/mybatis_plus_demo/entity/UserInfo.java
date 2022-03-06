package com.demo.mybatis_plus.mybatis_plus_demo.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author jyz
 * @since 2022-03-06
 */

@Data
@TableName("user_info")
@ApiModel(value = "UserInfo对象", description = "用户信息")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @ApiModelProperty("用户登录名")
    private String userLoginName;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户密码")
    private String userPassword;

    @ApiModelProperty("用户密码加盐")
    private String userPasswordSalt;

    @ApiModelProperty("用户手机号码")
    private String userPhone;

    @ApiModelProperty("用户邮箱")
    private String userLoginEmail;

    @ApiModelProperty("用户状态(0-已删除,1-正常,2-禁止登录)")
    @TableLogic(delval = "0",value = "1")
    private Integer userStatus;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("用户登录最后一次ip")
    private String userLastLoginIp;

    @ApiModelProperty("用户登录次数")
    private Integer userLoginCount;

    @ApiModelProperty("用户最后登录时间")
    private LocalDateTime userLastLoginTime;

    @ApiModelProperty("用户部门")
    private String userDepartment;

    @ApiModelProperty("用户联系地址")
    private String userContactAddress;

    @ApiModelProperty("身份证号/工号")
    private String userIdCard;

    @ApiModelProperty("安全防护级别(1,2,3,4,5)")
    private String safetyProtectionLevel;

    @ApiModelProperty("安全防护状态(1,OPEN;2,CLOSE)")
    private Boolean safetyProtectionStatus;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("用户答题状态(0,正常；1，答题中)")
    private Boolean userTemplateStatus;


}
