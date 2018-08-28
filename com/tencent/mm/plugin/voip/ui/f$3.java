package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class f$3 implements OnClickListener {
    final /* synthetic */ f oSK;

    f$3(f fVar) {
        this.oSK = fVar;
    }

    public final void onClick(View view) {
        h.mEJ.h(11619, new Object[]{Integer.valueOf(3)});
        if (this.oSK.oQd != null && this.oSK.oQd.get() != null) {
            ((c) this.oSK.oQd.get()).bKH();
        }
    }
}
