package com.wtxy.familyeducation.bean;

/**
 * @Author: yiwenhui
 * @Date: 2020/4/12
 * @Describe:
 */
public class ClassInfo extends BaseItemBean{

    private int class_id;
    private String class_name;

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public String getShowTitle() {
        return class_name;
    }
}
