package com.example.sundy_android_test.chapter5;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.sundy_android_test.R;

import java.util.ArrayList;

/**
 * @author xiads
 * @date 14-7-10
 */
public class LargeListView extends ListActivity {

    ArrayList<String> mData = new ArrayList<>();
    static ArrayList<String> sTxtData = new ArrayList<>();
    static ArrayList<Boolean> sCkbData = new ArrayList<>();
    {
        for(int i = 0; i < 1000000; i++) {
            mData.add("A");
            sTxtData.add("");
            sCkbData.add(Boolean.FALSE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        long start = System.currentTimeMillis();
        super.onCreate(savedInstanceState);
        this.setListAdapter(new MyAdapter(this));
        this.getListView().setFastScrollEnabled(true);
        long end = System.currentTimeMillis();
        Log.v("TAG", "elapsed time:" + (end - start) + "ms...");
    }

    class MyAdapter extends BaseAdapter {

        Context mContext;
        LayoutInflater mInflater;

        MyAdapter(Context mContext) {
            this.mContext = mContext;
            this.mInflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if(convertView == null) {
                convertView = mInflater.inflate(R.layout.chapter1_1, null);
                holder = new ViewHolder();
                holder.btn = (Button) convertView.findViewById(R.id.chapter1_1_btn);
                holder.txt = (TextView) convertView.findViewById(R.id.chapter1_1_txt);
                holder.ckb = (CheckBox) convertView.findViewById(R.id.chapter1_1_ckb);
                convertView.setTag(holder);
                Log.v("TAG", "refresh view!!! [position:" + position + ",sCkbData.get(" + position + "):" + sCkbData.get(position) + "]");
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            Log.v("TAG", "[position:" + position + ",sCkbData.get(" + position + "):" + sCkbData.get(position) + "]");
            holder.txt.setText(sTxtData.get(position));
            holder.ckb.setChecked(sCkbData.get(position));
            holder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sTxtData.set(position, "Hello Sam");
                    notifyDataSetChanged();
                }
            });
            holder.ckb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean currentChecked = sCkbData.get(position);
                    sCkbData.set(position, !currentChecked);
                    Log.v("TAG", "checked changed!!! [position:" + position +
                            "sCkbData.get("+position+"):" + sCkbData.get(position) + "]");
                    notifyDataSetChanged();
                }
            });
            holder.ckb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                }
            });
            return convertView;
        }
    }

    static class ViewHolder {
        Button btn;
        TextView txt;
        CheckBox ckb;
    }
}

