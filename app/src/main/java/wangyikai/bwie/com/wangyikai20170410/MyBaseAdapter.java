package wangyikai.bwie.com.wangyikai20170410;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * date: 2017/4/10.
 * author: 王艺凯 (lenovo )
 * function:适配器
 */

public class MyBaseAdapter extends BaseAdapter {
    private MyBean mBean;
    private Context mContext;

    public MyBaseAdapter(MyBean bean, Context context) {
        mBean = bean;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mBean.getResult().getData().size();
    }

    @Override
    public Object getItem(int position) {
        return mBean.getResult().getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //优化
        ViewHolder vh;
        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.lv_neirong, null);
            vh = new ViewHolder();
             vh.title = (TextView) convertView.findViewById(R.id.title);
            vh.com = (TextView) convertView.findViewById(R.id.com);
            vh.mImageView = (ImageView) convertView.findViewById(R.id.iv);

            convertView.setTag(vh);
        }else  {
         vh = (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(mBean.getResult().getData().get(position).getThumbnail_pic_s(),vh.mImageView);

        vh.title.setText(mBean.getResult().getData().get(position).getTitle());
        vh.com.setText(mBean.getResult().getData().get(position).getAuthor_name());
        return convertView;
    }

    class ViewHolder {

        ImageView mImageView;
        TextView title, com;
    }
}
