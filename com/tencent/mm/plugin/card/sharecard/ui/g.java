package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class g extends BaseAdapter {
    c hzI;
    List<b> hzT;
    Context mContext;

    public final int getCount() {
        return this.hzT.size();
    }

    /* renamed from: nE */
    public final b getItem(int i) {
        return (b) this.hzT.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.hzI.a(i, view, getItem(i));
    }
}
