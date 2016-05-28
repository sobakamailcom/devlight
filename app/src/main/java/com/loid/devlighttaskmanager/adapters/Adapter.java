package com.loid.devlighttaskmanager.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.loid.devlighttaskmanager.R;
import com.loid.devlighttaskmanager.models.Task;

import java.util.ArrayList;

/**
 * Created by LOID on 28.05.2016.
 */
public class Adapter extends BaseAdapter {

    ArrayList<Task> tasksArray = new ArrayList<>();
    LayoutInflater layoutInflater;

    public Adapter(ArrayList<Task> useArray, Activity activity) {
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.tasksArray = useArray;
    }

    @Override
    public int getCount() {
        return tasksArray.size();
    }

    @Override
    public Object getItem(int position) {
        return tasksArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.adapter, null);
            viewHolder.title = (TextView) convertView.findViewById(R.id.taskTitleTextView);
            viewHolder.comment = (TextView) convertView.findViewById(R.id.commentTextView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Task task = (Task) getItem(position);
        if (task != null) {
            viewHolder.title.setText(task.getName());
            viewHolder.comment.setText(task.getComment());
        }
        return convertView;
    }

    class ViewHolder {
        TextView title;
        TextView comment;

    }
}

