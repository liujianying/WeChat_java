package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import java.util.List;
import junit.framework.Assert;

public class i$a extends BaseAdapter {
    List<Integer> jWl = null;
    OnClickListener kyW;
    private Context mContext;

    public i$a(Context context) {
        Assert.assertTrue(context != null);
        this.mContext = context;
    }

    public final int getCount() {
        return this.jWl == null ? 0 : this.jWl.size();
    }

    public final Object getItem(int i) {
        if (this.jWl != null) {
            return this.jWl.get(i);
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.i.ipcall_share_grid_view_item, viewGroup, false);
            aVar = new a(this);
            aVar.kyY = (RelativeLayout) view.findViewById(R.h.layout);
            aVar.kyZ = (TextView) view.findViewById(R.h.ipcall_share_item_title);
            aVar.kza = (ImageView) view.findViewById(R.h.ipcall_share_item_icon);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            aVar.id = ((Integer) item).intValue();
            IPCallShareCouponCardUI.a(this.mContext, aVar.id, aVar.kyZ, aVar.kza);
            aVar.kyY.setOnClickListener(new 1(this));
        }
        return view;
    }
}
