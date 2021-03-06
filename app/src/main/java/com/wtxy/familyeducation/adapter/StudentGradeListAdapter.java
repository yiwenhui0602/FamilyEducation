package com.wtxy.familyeducation.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.wtxy.familyeducation.R;
import com.wtxy.familyeducation.bean.BaseItemBean;
import com.wtxy.familyeducation.bean.ScoreInfo;
import com.wtxy.familyeducation.user.GradeInfo;
import com.wtxy.familyeducation.user.HomeworkInfo;

import java.util.List;

/**
 * @Author: yiwenhui
 * @Date: 2020/4/11
 * @Describe:
 */
public class StudentGradeListAdapter<T extends BaseItemBean> extends CommonAdapter<BaseItemBean> {


    public StudentGradeListAdapter(Context context, List<BaseItemBean> mDatas, int itemLayoutId) {
        super(context, mDatas, itemLayoutId);
    }

    @Override
    public void convert(ViewHolder helper, BaseItemBean item, int postion) {
        if (item instanceof ScoreInfo) {
            ScoreInfo gradeInfo = (ScoreInfo) item;
            ((TextView) helper.getView(R.id.tv_title)).setText(gradeInfo.exam_name);
            ((TextView) helper.getView(R.id.tv_subtitle)).setText(gradeInfo.subject_name);
            ((TextView) helper.getView(R.id.tv_right)).setText(gradeInfo.score_num + "");
        } else if (item instanceof HomeworkInfo) {
            HomeworkInfo homeworkInfo = (HomeworkInfo) item;
            ((TextView) helper.getView(R.id.tv_title)).setText(homeworkInfo.hw_title);
            ((TextView) helper.getView(R.id.tv_subtitle)).setText(homeworkInfo.hw_detail);
            ((TextView) helper.getView(R.id.tv_right)).setText(homeworkInfo.hw_time);
        }

    }
}
