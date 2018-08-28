package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class e$21 implements OnClickListener {
    final /* synthetic */ e oSe;

    e$21(e eVar) {
        this.oSe = eVar;
    }

    public final void onClick(View view) {
        h.mEJ.h(11619, new Object[]{Integer.valueOf(2)});
        if (this.oSe.oQd != null && this.oSe.oQd.get() != null) {
            ((c) this.oSe.oQd.get()).bKH();
        }
    }
}
