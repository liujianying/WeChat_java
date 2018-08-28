package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.card.a;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"UseValueOf"})
public final class g extends BaseAdapter {
    private OnClickListener eZF = new 1(this);
    private boolean hEU = false;
    List<Boolean> hEV = new ArrayList();
    a hEW;
    private boolean hwd = true;
    c hzI;
    List<CardInfo> hzT = new ArrayList();
    Context mContext;

    public g(Context context) {
        this.hzI = new l(context, this);
        this.mContext = context;
    }

    public final int getCount() {
        return this.hzT.size();
    }

    /* renamed from: nQ */
    public final CardInfo getItem(int i) {
        return (CardInfo) this.hzT.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        CardInfo nQ = getItem(i);
        nQ.hwd = this.hwd;
        View a = this.hzI.a(i, view, nQ);
        if (this.hEU && nQ.avY()) {
            this.hzI.w(a, 0);
            if (((Boolean) this.hEV.get(i)).booleanValue()) {
                this.hzI.v(a, a.c.card_add_selected_btn_bg);
            } else {
                this.hzI.v(a, a.c.card_add_unselected_btn_bg);
            }
            this.hzI.a(a, i, this.eZF);
        } else {
            this.hzI.w(a, 8);
        }
        return a;
    }
}
