package e.hoeyongjin.uxm_android.Activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import e.hoeyongjin.uxm_android.Adapter.CourseAdapter;
import e.hoeyongjin.uxm_android.Constants.Constants;
import e.hoeyongjin.uxm_android.Items.CourseItems;
import e.hoeyongjin.uxm_android.R;
import e.hoeyongjin.uxm_android.SetList;

import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by sky64 on 2018-02-14.
 */

public class CourseListActivity extends AppCompatActivity {
    private DefaultHttpClient httpClient;
    private HttpPost httpPost;
    private ArrayList<NameValuePair> nameValuePairArrayList;
    private ListView myCourseListView;
    private ListView allCourseListView;
    private CourseAdapter courseAdapter;
    private CourseAdapter failedAdapter;
    private List<CourseItems> menuItemListAll;
    private List<CourseItems> menuItemListMyCourse;
    private Button add_course_btn;
    public SetList setlist = new SetList();
    ResponseHandler<String> responseHandler;
    String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        class getData extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                try {
                    String success = "success";
                    menuItemListMyCourse = new ArrayList<CourseItems>();

                    allCourseListView = findViewById(R.id.listview_all_course);
                    httpClient = new DefaultHttpClient();
                    httpPost = new HttpPost(Constants.linkHTTP + Constants.courseList);
                    responseHandler = new BasicResponseHandler();
                    response = httpClient.execute(httpPost, responseHandler);
                    JSONArray jsonArray2 = new JSONObject(response).getJSONArray("all_course");
                    System.out.println(jsonArray2);
                    setlist.setCourse(response,
                            "all_course",
                            menuItemListMyCourse,
                            allCourseListView,
                            courseAdapter);
                    return success;
                } catch (Exception e) {
                    return new String("Exception: " + e.getMessage());
                }
            }
            @Override
            protected void onPostExecute(String result) {
                if(result.equals("success")) {
                    System.out.println("Successfully connected");
                } else {
                    System.out.println("Error in connect");
                }
            }
        }
    }

    /* UI for responsive */
    public void setListViewHeightBaseOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;

        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
