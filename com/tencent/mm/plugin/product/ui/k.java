package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

public final class k extends BaseAdapter {
    OnItemClickListener lTs;
    List<n> lTz;
    private Context mContext;

    public k(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.lTz != null ? this.lTz.size() : 0;
    }

    private n uB(int i) {
        return (n) this.lTz.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        n uB = uB(i);
        if (view == null || view.getTag() == null) {
            a aVar2 = new a(this);
            view = View.inflate(this.mContext, g.product_sold_out_item, null);
            aVar2.lTt = (TextView) view.findViewById(f.mall_product_sold_out_item_title);
            aVar2.lTu = (MaxGridView) view.findViewById(f.mall_product_sold_out_item_gv);
            aVar2.lTA = new l(this.mContext);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.lTt.setText(uB.name);
        aVar.lTu.setOnItemClickListener(this.lTs);
        aVar.lTA.lTC = uB.lRw;
        aVar.lTA.notifyDataSetChanged();
        aVar.lTu.setAdapter(aVar.lTA);
        return view;
    }
}
