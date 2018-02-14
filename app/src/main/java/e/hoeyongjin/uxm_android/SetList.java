package e.hoeyongjin.uxm_android;

import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import e.hoeyongjin.uxm_android.Adapter.CourseAdapter;
import e.hoeyongjin.uxm_android.Items.CourseItems;

/**
 * Created by sky64 on 2018-02-14.
 */

public class SetList extends AppCompatActivity {
    public void setCourse(String response, String jsonName, List<CourseItems> listCourse, ListView listView, CourseAdapter adapter) throws Exception {
        JSONArray jsonArray = new JSONObject(response).getJSONArray(jsonName);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String course_no = jsonObject.optString("course_no");
            String course_name = jsonObject.optString("course_name");
            String professor = jsonObject.optString("professor");
            listCourse.add(new CourseItems(course_no, course_name, professor));
        }
        adapter = new CourseAdapter(getApplicationContext(), listCourse);
        listView.setAdapter(adapter);
    }
}
