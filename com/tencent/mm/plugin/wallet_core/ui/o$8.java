package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class o$8 implements OnClickListener {
    final /* synthetic */ OnCancelListener pxT;
    final /* synthetic */ o pxX;

    o$8(o oVar, OnCancelListener onCancelListener) {
        this.pxX = oVar;
        this.pxT = onCancelListener;
    }

    public final void onClick(View view) {
        if (this.pxT != null) {
            this.pxT.onCancel(null);
        }
        if (this.pxX.pxV != null) {
            this.pxX.pxV.blf();
        }
        this.pxX.cancel();
        if (this.pxX.pxD.isShown()) {
            h.mEJ.h(11977, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            return;
        }
        h.mEJ.h(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
    }
}
