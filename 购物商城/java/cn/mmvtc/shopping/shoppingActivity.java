package cn.mmvtc.shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
//import android.R;
import java.util.List;

import cn.mmvtc.shopping.bean.ShopBean;

public class shoppingActivity extends AppCompatActivity implements View.OnClickListener
{
   ImageView gw;
    private ListView mListView;
    private int[] id={1,2,3,4,5,6,7,8,9,10};
    private String[] titles={
            "板鞋","帆布鞋","篮球鞋","跑步鞋","休闲鞋","运动长裤","户外服装","小米手机","蓝牙耳机","手机壳"
    };
    private  String[] prices={
            "799元","499元","899元","299"+"元","199元","280元","520元","2999元","1299元","26元"
    };
    private int[] icons={R.drawable.banxie,R.drawable.fbx,R.drawable.
            lqx,R.drawable.pbx,R.drawable.xxx,R.drawable.ydck,
            R.drawable.hwfz,R.drawable.xmsj,R.drawable.lyej,R.drawable.sjk};
    List < ShopBean > list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingmall);
        mListView=(ListView)findViewById(R.id.lv);
        gw=(ImageView) findViewById(R.id.gwc_1);
        gw.setOnClickListener(this);
        MyBaseAdapter mAdapter = new MyBaseAdapter();
        mListView.setAdapter(mAdapter);
        CilckItem();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){


            case  R.id.gwc_1:
                Intent int1=new Intent(this,ShopCar.class);
                startActivity(int1);
                break;
        }
    }

    class MyBaseAdapter extends BaseAdapter  {
        @Override
        public int getCount(){
            return titles.length;
        }
        @Override
        public Object getItem(int position){
            return titles[position];
        }
        @Override
        public long getItemId(int position){
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ShopAdapter holder ;
            if (convertView == null) {
                convertView = View.inflate(shoppingActivity.this, R.layout.list_item, null);
                holder = new ShopAdapter();
                holder.title = (TextView) convertView.findViewById(R.id.title);
                holder.price = (TextView) convertView.findViewById(R.id.price);
                holder.iv = (ImageView) convertView.findViewById(R.id.iv);
                convertView.setTag(holder);
            } else {
                holder = (ShopAdapter) convertView.getTag();
            }
            holder.title.setText(titles[position]);
            holder.price.setText(prices[position]);
            holder.iv.setBackgroundResource(icons[position]);
            return convertView;
        }
    }
    protected void CilckItem(){
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(shoppingActivity.this,Content.class);
                intent.putExtra("name",titles[position]);
                intent.putExtra("price",prices[position]);
                intent.putExtra("picture",icons[position]);

                startActivity(intent);
            }
        });
    }
}
