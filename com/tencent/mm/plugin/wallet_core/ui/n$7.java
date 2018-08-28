package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class n$7 implements OnClickListener {
    final /* synthetic */ n pxQ;
    final /* synthetic */ OnCancelListener pxT;

    n$7(n nVar, OnCancelListener onCancelListener) {
        this.pxQ = nVar;
        this.pxT = onCancelListener;
    }

    public final void onClick(View view) {
        if (this.pxT != null) {
            this.pxT.onCancel(null);
        }
        if (this.pxQ.pxy != null) {
            this.pxQ.pxy.blf();
        }
        this.pxQ.cancel();
        if (this.pxQ.pxD.isShown()) {
            h.mEJ.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            return;
        }
        h.mEJ.h(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
    }
}
