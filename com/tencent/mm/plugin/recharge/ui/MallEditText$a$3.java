package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.recharge.ui.MallEditText.a;

class MallEditText$a$3 implements OnClickListener {
    final /* synthetic */ a mpr;

    MallEditText$a$3(a aVar) {
        this.mpr = aVar;
    }

    public final void onClick(View view) {
        MallEditText.a(this.mpr.mpl).dismissDropDown();
    }
}
