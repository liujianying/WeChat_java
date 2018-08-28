package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class p$6 implements Runnable {
    final /* synthetic */ p mLr;
    final /* synthetic */ Activity mr;

    p$6(p pVar, Activity activity) {
        this.mLr = pVar;
        this.mr = activity;
    }

    public final void run() {
        p pVar = this.mLr;
        Context context = this.mr;
        this.mr.getString(R.l.app_tip);
        pVar.eHw = h.a(context, this.mr.getString(R.l.qrcode_reading_file), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                p$6.this.mLr.mLh = false;
                p$6.this.mLr.mLg.set(false);
                p$6.this.mLr.mLi = false;
            }
        });
    }
}
