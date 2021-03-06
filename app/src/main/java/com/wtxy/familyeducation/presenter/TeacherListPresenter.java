package com.wtxy.familyeducation.presenter;

import com.wtxy.familyeducation.bean.EducationManageInfo;
import com.wtxy.familyeducation.httpresult.LoadExamListResult;
import com.wtxy.familyeducation.httpresult.LoadTeacherListResult;
import com.wtxy.familyeducation.biz.HomeWorkBiz;
import com.wtxy.familyeducation.httpresult.LoadHomeWorkListResult;
import com.wtxy.familyeducation.ibiz.IHomeWorkBiz;
import com.wtxy.familyeducation.iview.ITeacherListView;
import com.wtxy.familyeducation.task.LoadHomeWorkListTask;
import com.wtxy.familyeducation.task.LoadExamListTask;
import com.wtxy.familyeducation.user.GradeInfo;
import com.wtxy.familyeducation.user.HomeworkInfo;
import com.zhy.http.okhttp.requestBase.TaskListener;

import java.util.ArrayList;
import java.util.List;

public class TeacherListPresenter {

    private ITeacherListView teacherListView;
    private IHomeWorkBiz homeWorkBiz;

    public TeacherListPresenter(ITeacherListView teacherListView) {
        this.teacherListView = teacherListView;
        this.homeWorkBiz = new HomeWorkBiz();
    }

    public void loadData(int manageType) {
        switch (manageType) {
            case EducationManageInfo.MANAGE_TYPE_TEAHCER_GRADE:
                LoadExamListTask loadExamListTask = new LoadExamListTask(loadExamListResultTaskListener, LoadExamListResult.class);
                loadExamListTask.execute();
                break;
            case EducationManageInfo.MANAGE_TYPE_MANAGER_HOMEWORK:
                this.homeWorkBiz.loadHomeWorkList(taskListener,0);
                break;
        }
    }

    private TaskListener<LoadExamListResult> loadExamListResultTaskListener = new TaskListener<LoadExamListResult>() {
        @Override
        public void onTaskStart(TaskListener<LoadExamListResult> listener) {

        }

        @Override
        public void onTaskComplete(TaskListener<LoadExamListResult> listener, LoadExamListResult result, Exception e) {
            if (result != null && result.isSuccess()) {
                if (teacherListView != null) {
                    teacherListView.refreshGrandList(result.getResult());
                }
            }
        }
    };

    private void getTestGradeData() {
//        List<GradeInfo> list = new ArrayList<>();
//        GradeInfo gradeInfo1 = new GradeInfo();
//        gradeInfo1.grade_id = 100001;
//        gradeInfo1.grade_college = "计算机院";
//        gradeInfo1.grade_name = "2019年上学期计算机考试成绩";
//        list.add(gradeInfo1);
//        GradeInfo gradeInfo2 = new GradeInfo();
//        gradeInfo2.grade_id = 100002;
//        gradeInfo2.grade_college = "计算机院";
//        gradeInfo2.grade_name = "2019年上学期高等数学考试成绩";
//        list.add(gradeInfo2);
//        if (teacherListView != null) {
//            teacherListView.refreshGrandList(list);
//        }
    }

    private TaskListener<LoadHomeWorkListResult> taskListener = new TaskListener<LoadHomeWorkListResult>() {
        @Override
        public void onTaskStart(TaskListener<LoadHomeWorkListResult> listener) {

        }

        @Override
        public void onTaskComplete(TaskListener<LoadHomeWorkListResult> listener, LoadHomeWorkListResult result, Exception e) {
            if (result != null && result.isSuccess()) {
                teacherListView.refreshHomeworkList(result.getResult());
            }
        }
    };

    private void getTestHomeworkDate() {

    }

}
