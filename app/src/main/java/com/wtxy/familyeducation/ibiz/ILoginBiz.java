package com.wtxy.familyeducation.ibiz;

import com.wtxy.familyeducation.httpresult.LoginHttpResult;
import com.zhy.http.okhttp.requestBase.TaskListener;

/**
 * @Author: yiwenhui
 * @Date: 2020/2/23
 * @Describe:
 */
public interface ILoginBiz {
    public void login(int loginType, String loginName, String pwd, TaskListener<LoginHttpResult> taskListener);
    public void regist(int registType,String loginName,String pwd,TaskListener<LoginHttpResult> taskListener);
}
