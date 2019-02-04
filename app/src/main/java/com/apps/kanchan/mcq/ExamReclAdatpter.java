package com.apps.kanchan.mcq;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 25/1/19.
 */

public class ExamReclAdatpter extends RecyclerView.Adapter<ExamReclAdatpter.ExamViewHolder> {

    private ArrayList<String> examNameList;
    private static ExamOnClickHelper sExamOnClickHelper = ExamOnClickHelper.getInstance();
    public ExamReclAdatpter(ArrayList<String> examNameList) {
        this.examNameList = examNameList;
    }

    @Override
    public ExamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View examView = LayoutInflater.from(parent.getContext()).inflate(R.layout.exam_cardview,parent,false);
        return new ExamViewHolder(examView);
    }

    @Override
    public void onBindViewHolder(ExamViewHolder holder, int position) {
        holder.vExamName.setText(examNameList.get(position));
        holder.vItemView.setTag(position);
        Log.i("Info"," "+position+":onBindViewHolder.vExamName :"+holder.vExamName);
        if(MainActivity.SELECTED_EXAM.equals(examNameList.get(position)) ) {
            sExamOnClickHelper.processOnlick(holder.itemView);
        }
    }

    @Override
    public int getItemCount() {
        return examNameList.size();
    }

    public static class ExamViewHolder extends RecyclerView.ViewHolder{
        protected TextView vExamName;
        protected View vItemView;

        public ExamViewHolder(View itemView) {
            super(itemView);
            this.vItemView = itemView;
            vExamName = itemView.findViewById(R.id.examNameTextView);
            Log.i("Info"," "+":ExamViewHolder.vExamName :"+vExamName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("Info"," :"+vExamName.getText()+" "+vItemView.getTag());
                    sExamOnClickHelper.processOnlick(view);
                }
            });
        }
    }
}
