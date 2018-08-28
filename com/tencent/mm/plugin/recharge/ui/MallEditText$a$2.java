package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.recharge.ui.MallEditText.a;
import java.util.LinkedList;

class MallEditText$a$2 implements OnClickListener {
    final /* synthetic */ a mpr;

    MallEditText$a$2(a aVar) {
        this.mpr = aVar;
    }

    public final void onClick(View view) {
        com.tencent.mm.plugin.recharge.a.a.bpV().bP(null);
        this.mpr.mpl.setInput(null);
        MallEditText.d(this.mpr.mpl).bP(new LinkedList());
        MallEditText.d(this.mpr.mpl).notifyDataSetChanged();
    }
}
