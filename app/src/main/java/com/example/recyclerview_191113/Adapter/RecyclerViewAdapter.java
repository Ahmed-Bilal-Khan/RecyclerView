package com.example.recyclerview_191113.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_191113.Model.Student;
import com.example.recyclerview_191113.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    static List<Student> studentList;

    public RecyclerViewAdapter() {
    }

    public RecyclerViewAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.txtViewStudentName.setText("Student Name: "+student.getName());
        holder.txtViewRollNo.setText("Student Roll No.: "+student.getRollNo());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        TextView txtViewStudentName, txtViewRollNo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtViewStudentName= itemView.findViewById(R.id.txtviewname);
            txtViewRollNo= itemView.findViewById(R.id.txtviewrollno);

            itemView.setOnLongClickListener(this);
        }


        @Override
        public boolean onLongClick(View v) {
            int position = getAdapterPosition();
            Toast.makeText(itemView.getContext(),"Removed: "+studentList.get(position).getName(),Toast.LENGTH_LONG).show();
            studentList.remove(position);
            notifyItemRemoved(position);
            return false;
        }
    }


    private void removeAt(int position) {
        studentList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, studentList.size());
    }
}
