package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.g;

public final class j extends BaseAdapter {
    m lTx;
    String lTy;
    private Context mContext;

    public j(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.lTx.lRW != null ? this.lTx.lRW.size() : 0;
    }

    private h uA(int i) {
        return (h) this.lTx.lRW.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final boolean isEnabled(int i) {
        return uA(i).lRP;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        h uA = uA(i);
        if (view == null || view.getTag() == null) {
            inflate = View.inflate(this.mContext, g.product_select_sku_cell, null);
        } else {
            inflate = view;
        }
        CheckBox checkBox = (CheckBox) inflate;
        checkBox.setText(uA.name);
        checkBox.setEnabled(uA.lRP);
        checkBox.setChecked(uA.id.equals(this.lTy));
        if (!uA.lRP) {
            inflate.setBackgroundResource(e.product_sku_bg_disable);
        } else if (uA.id.equals(this.lTy)) {
            inflate.setBackgroundResource(e.product_sku_bg_selected);
        } else {
            inflate.setBackgroundResource(e.product_sku_bg_normal);
        }
        inflate.setTag(new Pair(this.lTx.lRU, uA.id));
        return inflate;
    }
}
