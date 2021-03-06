package com.wtxy.familyeducation.biz;

import com.wtxy.familyeducation.ibiz.IPubBiz;
import com.wtxy.familyeducation.task.PublishNewsTask;
import com.wtxy.familyeducation.task.PublishNoticeTask;
import com.zhy.http.okhttp.requestBase.HttpResult;
import com.zhy.http.okhttp.requestBase.TaskListener;

/**
 * @Author: yiwenhui
 * @Date: 2020/2/29
 * @Describe:
 */
public class PubBiz implements IPubBiz {
    @Override
    public void pushLishNews(String title, String otherTitle, String link, TaskListener<HttpResult> taskListener) {
        PublishNewsTask publishNewsTask = new PublishNewsTask(taskListener,HttpResult.class);
        publishNewsTask.setParam(title,otherTitle,link);
        publishNewsTask.execute();
    }

    @Override
    public void pushLishNotices(String title, String otherTitle, TaskListener<HttpResult> taskListener) {
        PublishNoticeTask publishNoticeTask = new PublishNoticeTask(taskListener,HttpResult.class);
        publishNoticeTask.setParam(title,otherTitle);
        publishNoticeTask.execute();
    }
}
