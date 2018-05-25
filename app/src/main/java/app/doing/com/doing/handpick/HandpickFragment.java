package app.doing.com.doing.handpick;

import android.app.Fragment;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import app.doing.com.doing.R;
import app.doing.com.doing.customView.ImageButtonCustom;
import app.doing.com.doing.handpick.adapter.GymItemAdapter;
import app.doing.com.doing.handpick.item.GymItem;


/**
 * Created by cherry on 18-5-21.
 */

public class HandpickFragment extends Fragment implements View.OnClickListener{
    private ImageButtonCustom gym_ibc;
    private ImageButtonCustom course_ibc;
    private ImageButtonCustom coach_ibc;

    //展示的4个精选场馆
    private List<GymItem> gymItemList = new ArrayList<>();


    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState){
        View handpickFragment = layoutInflater.inflate(R.layout.handpick_fragment,container,false);
        initViews(handpickFragment);

        getGymItemList();
        RecyclerView recyclerView = handpickFragment.findViewById(R.id.handpick_gym_list);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);

        GymItemAdapter gymItemAdapter = new GymItemAdapter(gymItemList);
        recyclerView.setAdapter(gymItemAdapter);

        return handpickFragment;
    }

    private void initViews(View view){
        gym_ibc = view.findViewById(R.id.gym_image);
        course_ibc = view.findViewById(R.id.course_image);
        coach_ibc = view.findViewById(R.id.coach_image);

        gym_ibc.setOnClickListener(this);
        course_ibc.setOnClickListener(this);
        coach_ibc.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //判断点击的按钮
        Intent intent;
        switch (v.getId()){
            case R.id.gym_image:
                intent = new Intent(getActivity(),GymListActivity.class);
                startActivity(intent);
                break;
            case R.id.course_image:
                intent = new Intent(getActivity(),CourseListActivity.class);
                startActivity(intent);
                break;
            case R.id.coach_image:
                intent = new Intent(getActivity(),CoachListActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }

    private void getGymItemList(){
        GymItem gymItem1 = new GymItem(R.drawable.gtm_item_pic,"宝力豪健身","特别好");
        gymItemList.add(gymItem1);
        GymItem gymItem2 = new GymItem(R.drawable.gtm_item_pic,"宝力豪健身","特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好");
        gymItemList.add(gymItem2);
        GymItem gymItem3 = new GymItem(R.drawable.gtm_item_pic,"宝力豪健身","特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好");
        gymItemList.add(gymItem3);
        GymItem gymItem4 = new GymItem(R.drawable.gtm_item_pic,"宝力豪健身","特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好特别好");
        gymItemList.add(gymItem4);
    }
}