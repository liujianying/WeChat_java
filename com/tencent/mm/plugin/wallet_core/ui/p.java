package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import java.util.ArrayList;

public final class p extends BaseAdapter {
    private Context mContext;
    ArrayList<x> mData = null;
    x pyE = null;

    public p(Context context, ArrayList<x> arrayList) {
        this.mContext = context;
        this.mData = arrayList;
    }

    public final int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    /* renamed from: zv */
    public final x getItem(int i) {
        if (this.mData == null || getCount() <= i) {
            return null;
        }
        return (x) this.mData.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.mContext, g.wallet_switch_wallet_kind_item, null);
            a aVar2 = new a(this, (byte) 0);
            aVar2.eGX = (TextView) view.findViewById(f.title);
            aVar2.pyF = (ImageView) view.findViewById(f.selected_icon);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        x zv = getItem(i);
        if (zv != null) {
            aVar.eGX.setText(zv.field_wallet_name);
            if (zv.field_wallet_selected == 1) {
                this.pyE = zv;
                aVar.pyF.setImageResource(h.radio_on);
            } else {
                aVar.pyF.setImageResource(h.radio_off);
            }
        }
        return view;
    }
}
