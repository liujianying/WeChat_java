package com.tencent.mm.plugin.appbrand.ipc;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

class AppBrandProcessProxyUI$2 extends ResultReceiver {
    final /* synthetic */ OnClickListener fDY;
    final /* synthetic */ OnClickListener fDZ;
    final /* synthetic */ OnClickListener fEa;

    AppBrandProcessProxyUI$2(Handler handler, OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3) {
        this.fDY = onClickListener;
        this.fDZ = onClickListener2;
        this.fEa = onClickListener3;
        super(handler);
    }

    protected final void onReceiveResult(int i, Bundle bundle) {
        if (-1 == i && this.fDY != null) {
            this.fDY.onClick(null, i);
        }
        if (-2 == i && this.fDZ != null) {
            this.fDZ.onClick(null, i);
        }
        if (-3 == i && this.fEa != null) {
            this.fEa.onClick(null, i);
        }
    }
}
