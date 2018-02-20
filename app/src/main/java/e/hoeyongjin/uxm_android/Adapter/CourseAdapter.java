package e.hoeyongjin.uxm_android.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



import java.util.List;

import e.hoeyongjin.uxm_android.Items.CourseItems;
import e.hoeyongjin.uxm_android.R;

/**
 * Created by 630su on 2018-02-04.
 */

public class CourseAdapter extends BaseAdapter{
    
    private Context context;
    private List<CourseItems> courseList;
    
    TextView courseNumTextView;
    TextView courseNameTextView;
    TextView professorTextView;
    
    public CourseAdapter(Context context, List<CourseItems> courseList) {
        this.context = context;
        this.courseList = courseList;
    }
    
    @Override
    public int getCount() {
        return this.courseList.size();
    }
    
    @Override
    public Object getItem(int index) {
        return this.courseList.get(index);
    }
    
    @Override
    public long getItemId(int index) {
        return index;
    }
    
    @Override
    public View getView(int index, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.course_list, null);
    
        courseNumTextView = (TextView) view.findViewById(R.id.courseNumTextView);
        courseNameTextView = (TextView) view.findViewById(R.id.courseNameTextView);
        professorTextView = (TextView) view.findViewById(R.id.professorTextView);
    
        courseNumTextView.setText(String.valueOf(courseList.get(index).getNum()));
        courseNameTextView.setText(courseList.get(index).getName());
        professorTextView.setText(courseList.get(index).getProfessor());
    
        return view;
    }
}
