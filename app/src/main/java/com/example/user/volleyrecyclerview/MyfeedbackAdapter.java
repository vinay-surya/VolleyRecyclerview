package com.example.user.volleyrecyclerview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Manju 619 on 19-06-2017.
 */

class MyfeedbackAdapter extends RecyclerView.Adapter<MyfeedbackAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<ModuleClassfeedback> dataList;


    public MyfeedbackAdapter(Context context, ArrayList<ModuleClassfeedback> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.row_message, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {


        holder.txtAnnMessage.setText(dataList.get(position).ConsumerNAme);
        holder.txtMessageBody.setText(dataList.get(position).ConsumerGEnder);
        holder.txtMessageSubject.setText(dataList.get(position).Comment);
        holder.txtPhoneNumber.setText(dataList.get(position).DealName);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtMessageSubject, txtAnnMessage,txtMessageBody,txtPhoneNumber;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtMessageSubject = (TextView) itemView.findViewById(R.id.txt_message_subject);
            txtMessageBody = (TextView) itemView.findViewById(R.id.txt_message_body);
            txtPhoneNumber = (TextView) itemView.findViewById(R.id.doj);
            txtAnnMessage = (TextView) itemView.findViewById(R.id.lyt_ann_message);
        }
    }
}
