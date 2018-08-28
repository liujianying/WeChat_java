package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class e$20 implements OnClickListener {
    final /* synthetic */ e oSe;

    e$20(e eVar) {
        this.oSe = eVar;
    }

    public final void onClick(View view) {
        h.mEJ.h(11618, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
        if (!(this.oSe.oQd == null || this.oSe.oQd.get() == null)) {
            ((c) this.oSe.oQd.get()).iP(true);
            if (e.h(this.oSe)) {
                this.oSe.oQr.removeView(this.oSe.oRM);
            } else {
                this.oSe.oQr.removeView(this.oSe.oRL);
            }
            e.a(this.oSe, false);
        }
        if (this.oSe.oQw != null) {
            this.oSe.bKB();
            this.oSe.oQw.H(false, true);
        }
    }
}
