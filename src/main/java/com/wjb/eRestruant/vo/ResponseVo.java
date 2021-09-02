package com.wjb.eRestruant.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wjb.eRestruant.enums.ResponseEnum;
import lombok.Data;
import org.springframework.validation.BindingResult;

import java.util.Objects;

@Data
//@JsonSerialize(include = )
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseVo<E> {

    private Integer status;

    private String msg;

    private E data;

    private ResponseVo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ResponseVo(Integer status, E data) {
        this.status = status;
        this.data = data;
    }

    public static <E>ResponseVo successByMsg(String msg) {
        return new ResponseVo<E>(ResponseEnum.SUCCESS.getCode(), msg);
    }

    public static <E>ResponseVo success(E data) {
        return new ResponseVo<E>(ResponseEnum.SUCCESS.getCode(), data);
    }

    public static <E>ResponseVo success() {
        return new ResponseVo<E>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg());
    }

    public static <E>ResponseVo error(ResponseEnum responseEnum) {
        return new ResponseVo<E>(responseEnum.getCode(), responseEnum.getMsg());
    }

    public static <E>ResponseVo error(ResponseEnum responseEnum,String msg) {
        return new ResponseVo<E>(responseEnum.getCode(), msg);
    }

    public static <E>ResponseVo error(ResponseEnum responseEnum, BindingResult bindingResult) {
        return new ResponseVo<E>(responseEnum.getCode(),

                Objects.requireNonNull(bindingResult.getFieldError().getField())
                        +""
                        +bindingResult.getFieldError().getDefaultMessage());
    }

}
