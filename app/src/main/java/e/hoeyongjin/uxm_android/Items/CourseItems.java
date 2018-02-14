package e.hoeyongjin.uxm_android.Items;

import e.hoeyongjin.uxm_android.Items.Items;

/**
 * Created by sky64 on 2018-02-14.
 */

public class CourseItems extends Items {

    private String courseNum;
    private String courseName;
    private String professor;

    public CourseItems(String courseNum, String courseName, String professor) {
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.professor = professor;
    }

    public String getNum() { return courseNum; }

    public String getName() { return courseName; }

    public String getProfessor() { return professor; }

    public void setName(String courseName) { this.courseName = courseName; }

    public void setNum(String courseNum) { this.courseNum = courseNum; }

    public void setProfessor(String professor) { this.professor = professor;  }
}
