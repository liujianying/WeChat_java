package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.product.b.n.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

public final class l extends BaseAdapter {
    List<a> lTC;
    private Context mContext;

    public l(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.lTC != null ? this.lTC.size() : 0;
    }

    private a uC(int i) {
        return (a) this.lTC.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        y.a aVar;
        a uC = uC(i);
        if (view == null || view.getTag() == null) {
            m mVar = new m();
            view = View.inflate(this.mContext, g.product_sold_out_cell, null);
            mVar.eBO = (TextView) view.findViewById(f.mall_product_sold_out_cell_price_iv);
            mVar.gxd = (ImageView) view.findViewById(f.mall_product_sold_out_cell_img_iv);
            view.setTag(mVar);
            aVar = mVar;
        } else {
            m aVar2 = (m) view.getTag();
        }
        aVar2.lTD = uC;
        aVar2.eBO.setText(uC.title);
        aVar2.gxd.setImageBitmap(y.a(new c(uC.iconUrl)));
        y.a(aVar2);
        return view;
    }
}
