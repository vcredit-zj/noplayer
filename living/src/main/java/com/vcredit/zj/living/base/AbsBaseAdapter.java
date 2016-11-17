package com.vcredit.zj.living.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.vcredit.zj.living.R;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import butterknife.ButterKnife;


/**
 * 项目名称：noplayer
 * 类描述：适配器的基类
 * 创建人：伍跃武
 * 创建时间：2016/11/17 13:58
 */
public abstract class AbsBaseAdapter<T, VH extends AbsBaseAdapter.AbsHolder> extends BaseAdapter {

    final static Collection nuCon = new Vector();

    /**
     * 上下文对象
     */
    protected Context context;
    /**
     * 集合数据
     */
    protected List<T> data;

    static {
        nuCon.addAll(null);
    }


    public AbsBaseAdapter(Context context, List<T> data) {
        this.context = context;
        this.data = data;
        //除去所有的空数据
        data.removeAll(nuCon);
    }


    @Override
    public int getCount() {
        if (data != null) {
            data.removeAll(nuCon);
            return data.size();
        } else {
            return 0;
        }
    }

    @Override
    public T getItem(int position) {
        return (data != null && position >= 0 && position < data.size()) ? data.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VH helper = getHelper(convertView, parent, getItemViewType(position));
        onBindViewHolder(helper, position);
        return helper.convertView;
    }

    protected VH getHelper(View convertView, ViewGroup parent, int viewType) {
        if (convertView != null) {
            Object obj = convertView.getTag(R.id.adapter_holder_id + viewType * 16);
            if (null != obj) {
                VH holder = (VH) obj;
                holder.convertView = convertView;
                return holder;
            }
        }
        VH holder = onCreateViewHolder(parent, viewType);
        holder.convertView.setTag(R.id.adapter_holder_id + viewType * 16, holder);
        return holder;
    }

    /**
     * 创建viewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    /**
     * 设置view
     *
     * @param holder
     * @param position
     */
    public abstract void onBindViewHolder(VH holder, int position);

    /**
     * holder 基类
     */
    public static class AbsHolder {
        protected View convertView;

        public AbsHolder(View view) {
            this.convertView = view;
            ButterKnife.bind(this, view);
        }

        public View getConvertView() {
            return convertView;
        }
    }
}
