package com.lll.md.core;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lll.md.core.activity.PersonInfoActivity;
import com.lll.md.core.activity.ProductInfoActivity;
import com.lll.md.core.base.BaseActivity;
import com.lll.md.core.util.Shakespeare;

public class MainActivity extends BaseActivity {
    private SlidingPaneLayout mSlidingLayout;
    //    private ListView mList;
    private TextView mContent;
    private NavigationView mNavigationView;

//    private ActionBarHelper mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initView();
        initNavigationView();

    }

    private void initView() {
        mContent = (TextView) findViewById(R.id.content_text);
        mNavigationView = (NavigationView) findViewById(R.id.nv);


        mSlidingLayout = (SlidingPaneLayout) findViewById(R.id.sliding_pane_layout);
        mSlidingLayout.setPanelSlideListener(new SliderListener());
        mSlidingLayout.openPane();
        mSlidingLayout.getViewTreeObserver().addOnGlobalLayoutListener(new FirstLayoutListener());
//        mList = (ListView) findViewById(R.id.left_pane);
//        mList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
//                Shakespeare.TITLES));
//        mList.setOnItemClickListener(new ListItemClickListener());

    }

    private void initNavigationView(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCornerRadius(100);
        ImageView head = new ImageView(this);
        head.setImageDrawable(roundedBitmapDrawable);
        mNavigationView.addHeaderView(head);

//        mNavigationView.addView();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*
         * The action bar up action should open the slider if it is currently closed,
         * as the left pane contains content one level up in the navigation hierarchy.
         */
        if (item.getItemId() == android.R.id.home && !mSlidingLayout.isOpen()) {
            mSlidingLayout.smoothSlideOpen();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * This list item click listener implements very simple view switching by changing
     * the primary content text. The slider is closed when a selection is made to fully
     * reveal the content.
     */
    private class ListItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mContent.setText(Shakespeare.DIALOGUE[position]);

            mSlidingLayout.smoothSlideClosed();
        }
    }

    /**
     * This panel slide listener updates the action bar accordingly for each panel state.
     */
    private class SliderListener extends SlidingPaneLayout.SimplePanelSlideListener {
        @Override
        public void onPanelOpened(View panel) {
//            mActionBar.onPanelOpened();
        }

        @Override
        public void onPanelClosed(View panel) {
//            mActionBar.onPanelClosed();
        }
    }

    /**
     * This global layout listener is used to fire an event after first layout occurs
     * and then it is removed. This gives us a chance to configure parts of the UI
     * that adapt based on available space after they have had the opportunity to measure
     * and layout.
     */
    private class FirstLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        @Override
        public void onGlobalLayout() {
            mSlidingLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }


}
