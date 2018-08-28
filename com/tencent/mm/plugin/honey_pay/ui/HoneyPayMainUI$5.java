package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.amn;

class HoneyPayMainUI$5 implements OnClickListener {
    final /* synthetic */ HoneyPayMainUI klC;
    final /* synthetic */ amn klF;

    HoneyPayMainUI$5(HoneyPayMainUI honeyPayMainUI, amn amn) {
        this.klC = honeyPayMainUI;
        this.klF = amn;
    }

    public final void onClick(View view) {
        HoneyPayMainUI.a(this.klC, this.klF.rIw, this.klF.hwg);
    }
}
