package com.wtxy.familyeducation.presenter;

import com.wtxy.familyeducation.httpresult.LoadStudentScoreListHttpResult;
import com.wtxy.familyeducation.iview.IStudentListView;
import com.wtxy.familyeducation.task.LoadStudentScoreListTask;
import com.wtxy.familyeducation.user.HomeworkInfo;
import com.zhy.http.okhttp.requestBase.TaskListener;

import java.util.ArrayList;
import java.util.List;

public class StudentListPresenter {

    private IStudentListView studentListView;

    public StudentListPresenter(IStudentListView studentListView) {
        this.studentListView = studentListView;
    }


    public void loadStudentGradeData(int studentId) {
        LoadStudentScoreListTask loadStudentScoreListTask = new LoadStudentScoreListTask(new TaskListener<LoadStudentScoreListHttpResult>() {
            @Override
            public void onTaskStart(TaskListener<LoadStudentScoreListHttpResult> listener) {

            }

            @Override
            public void onTaskComplete(TaskListener<LoadStudentScoreListHttpResult> listener, LoadStudentScoreListHttpResult result, Exception e) {
                if (result != null && result.isSuccess()) {
                    if (studentListView != null) {
                        studentListView.refreshGrandList(result.getResult());
                    }
                }
            }
        }, LoadStudentScoreListHttpResult.class);
        loadStudentScoreListTask.setStudentId(studentId);
        loadStudentScoreListTask.execute();
    }

    public void loadStudentHomewordData() {
        getTestHomeworkDate();
    }

    private void getTestHomeworkDate() {
        List<HomeworkInfo> list = new ArrayList<>();
        HomeworkInfo homeworkInfo1 = new HomeworkInfo();
        homeworkInfo1.homeword_id = 1001;
        homeworkInfo1.homeword_name = "2019年第一周作业";
        homeworkInfo1.homeword_desc = "做一个小型商店管理系统，能够实现对商店货物的增删改查操作";
        homeworkInfo1.homeword_time = "2019-09-21";
        homeworkInfo1.homeword_course = "数据结构";
        list.add(homeworkInfo1);
        HomeworkInfo homeworkInfo2 = new HomeworkInfo();
        homeworkInfo2.homeword_id = 1002;
        homeworkInfo2.homeword_name = "2019年第二周作业";
        homeworkInfo2.homeword_desc = "做一个小型游戏界面，能够实现游戏任务的走路前进和后退";
        homeworkInfo2.homeword_time = "2019-09-28";
        homeworkInfo2.homeword_course = "Java";
        list.add(homeworkInfo2);
        if (studentListView != null) {
            studentListView.refreshHomeworkList(list);
        }
    }

}
