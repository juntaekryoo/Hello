
package com.suwonsmartapp.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.suwonsmartapp.hello.activity.ActivityExamActivity;
import com.suwonsmartapp.hello.activity.EditTextActivity;
import com.suwonsmartapp.hello.activity.FirstActivity;
import com.suwonsmartapp.hello.activity.FrameLayoutActivity;
import com.suwonsmartapp.hello.activity.RelativeLayoutExamActivity;
import com.suwonsmartapp.hello.activity.SecondActivity;
import com.suwonsmartapp.hello.activity.TableLayoutActivity;
import com.suwonsmartapp.hello.challenge.challenge01.ImageExamActivity;
import com.suwonsmartapp.hello.challenge.challenge02.SMSActivity;
import com.suwonsmartapp.hello.challenge.challenge05.Mission05MainActivity;
import com.suwonsmartapp.hello.challenge.challenge06.Mission06MainActivity;
import com.suwonsmartapp.hello.event.TouchEventActivity;
import com.suwonsmartapp.hello.listview.ListViewExam01Activity;
import com.suwonsmartapp.hello.listview.ListViewExam02Activity;

/**
 * Created by junsuk on 15. 3. 19..
 */
public class SubActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private static final String[] ACTIVITY_ITEMS = {
            "Activity 예제",
            "EditTextActivity",
            "FirstActivity",
            "FrameLayout",
            "RelativeLayout",
            "SecondActivity",
            "TableLayout"
    };
    private static final Class[] ACTIVITY_CLASSES = {
            ActivityExamActivity.class,
            EditTextActivity.class,
            FirstActivity.class,
            FrameLayoutActivity.class,
            RelativeLayoutExamActivity.class,
            SecondActivity.class,
            TableLayoutActivity.class
    };

    private static final String[] CHALLENGE_ITEMS = {
            "Challenge01",
            "Challenge02",
            "Challenge04",
            "Challenge05",
            "Challenge06"
    };

    private static final Class[] CHALLENGE_CLASSES = {
            ImageExamActivity.class,
            SMSActivity.class,
            MainActivity.class,
            Mission05MainActivity.class,
            Mission06MainActivity.class
    };

    private static final String[] EVENT_ITEMS = {
            "TouchEvent"
    };

    private static final Class[] EVENT_CLASSES = {
            TouchEventActivity.class
    };

    private static final String[] LISTVIEW_ITEMS = {
            "ArrayAdapter",
            "CustomAdapter"
    };

    private static final Class[] LISTVIEW_CLASSES = {
            ListViewExam01Activity.class,
            ListViewExam02Activity.class
    };

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_exam01);

        mListView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, getItems().first);

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
    }

    private Pair<String[], Class[]> getItems() {
        Pair<String[], Class[]> result = null;

        String menu = getIntent().getStringExtra("menu");
        switch (menu) {
            case "Activity":
                result = new Pair(ACTIVITY_ITEMS, ACTIVITY_CLASSES);
                break;
            case "Challenge":
                result = new Pair(CHALLENGE_ITEMS, CHALLENGE_CLASSES);
                break;
            case "Event":
                result = new Pair(EVENT_ITEMS, EVENT_CLASSES);
                break;
            case "ListView":
                result = new Pair(LISTVIEW_ITEMS, LISTVIEW_CLASSES);
                break;
        }
        return result;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(getApplicationContext(), getItems().second[position]));

        // Class.forName 으로 정보 가져오는 방법
//        Class c = null;
//        try {
//            c = Class.forName("com.suwonsmartapp.hello.activity.ActivityExamActivity");
//            startActivity(new Intent(getApplicationContext(), c));
//        } catch (ClassNotFoundException e) {
//            Toast.makeText(getApplicationContext(), "없다", Toast.LENGTH_SHORT).show();
//        }
    }
}
