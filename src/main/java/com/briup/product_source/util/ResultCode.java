package com.briup.product_source.util;

/**
 * 响应信息的枚举类：
 */
public enum ResultCode {
    SUCCESS(1,"操作成功"),
    ERROR(0,"操作失败"),

    //操作成功：2000-2999
    ADD_SUCCESS(2000,"新增成功"),
    UPDATE_SUCCESS(2000,"修改成功"),
    DELETE_SUCCESS(2000,"删除成功"),


    //参数错误： 4000-4999
    USER_ID_ERROR(4000,"用户ID不合法"),
    USER_NAME_REPET(4001,"用户名重复"),
    USER_PASSWORD_NULL(4002,"密码不能为空"),
    USER_PASSWORD_LENGTH(4003,"密码长度不能小于6位"),
    PAGE_PARGNUM_EORROR(4004,"分页参数不合法"),




    //服务器内部错误  5000-5999
    SERVER_INTER_ERROR(5000,"程序内部错误,请联系管理员");



    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    //为了获取具体的响应信息，不提供set方法，防止被其他地方修改

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
