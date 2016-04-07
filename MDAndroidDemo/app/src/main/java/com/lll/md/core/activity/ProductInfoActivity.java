package com.lll.md.core.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lll.md.core.R;

/**
 *  scrollerView 里面嵌入listView
 */
public class ProductInfoActivity extends AppCompatActivity {

    public static final String[] TITLES =
            {
                    "Henry IV (1)",
                    "Henry V",
                    "Henry VIII",
                    "Richard II",
                    "Richard III",
                    "Merchant of Venice",
                    "Othello",
                    "King Lear",
                    "Henry IV (1)",
                    "Henry V",
                    "Henry VIII",
                    "Richard II",
                    "Richard III",
                    "Merchant of Venice",
                    "Othello",
                    "King Lear",
                    "Henry IV (1)",
                    "Henry V",
                    "Henry VIII",
                    "Richard II",
                    "Richard III",
                    "Merchant of Venice",
                    "Othello",
                    "King Lear",
                    "Henry IV (1)",
                    "Henry V",
                    "Henry VIII",
                    "Richard II",
                    "Richard III",
                    "Merchant of Venice",
                    "Othello",
                    "King Lear"
            };
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        mListView = (ListView) findViewById(R.id.lv);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, TITLES);
        mListView.setAdapter(arrayAdapter);
    }


}
