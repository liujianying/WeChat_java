package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;

class g$1 implements OnClickListener {
    final /* synthetic */ g hEX;

    g$1(g gVar) {
        this.hEX = gVar;
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        g gVar = this.hEX;
        if (((Boolean) gVar.hEV.get(intValue)).booleanValue()) {
            gVar.hEV.set(intValue, Boolean.valueOf(false));
        } else {
            gVar.hEV.set(intValue, Boolean.valueOf(true));
        }
        gVar.notifyDataSetChanged();
    }
}
