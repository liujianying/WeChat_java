package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.collect.b.e;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.y;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class a extends BaseAdapter {
    List<com.tencent.mm.plugin.collect.b.a> hWN = new ArrayList();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.hWN.size();
    }

    public final Object getItem(int i) {
        return this.hWN.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = y.gq(this.mContext).inflate(g.collect_bill_item, viewGroup, false);
            view.setTag(new a(view));
        }
        com.tencent.mm.plugin.collect.b.a aVar = (com.tencent.mm.plugin.collect.b.a) this.hWN.get(i);
        a aVar2 = (a) view.getTag();
        aVar2.hWO.setText(new SimpleDateFormat(this.mContext.getString(i.collect_bill_item_date_day_format)).format(new Date(aVar.timestamp * 1000)));
        aVar2.hWP.setText(e.os(aVar.fee));
        if (bi.oW(aVar.desc)) {
            aVar2.hVS.setVisibility(8);
        } else {
            aVar2.hVS.setText(aVar.desc);
            aVar2.hVS.setVisibility(0);
        }
        return view;
    }
}
