package com.youlai.laboratory.spring.constructor;

/**
 * 说明描述
 *
 * @author <a href="mailto:2256222053@qq.com">zc</a>
 * @Date 2022-03-15 11:59
 */
public class D {

    public static D create(){
        System.out.println("factory");
        return new D();
    }

}
