package pers.xsy.security.utils;

/**
 * @ClassName CodeEnum
 * @Description: 返回码
 * @Author XsYounG. Tribute to Alan Turing
 * @Date 2020/4/5
 * @Version V1.0
 **/
public enum CodeEnum {
    SUCCESS(0),
    ERROR(1);

    private Integer code;

    CodeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
