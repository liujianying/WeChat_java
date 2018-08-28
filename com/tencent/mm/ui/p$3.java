package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.f;

class p$3 implements OnClickListener {
    final /* synthetic */ int hdX;
    final /* synthetic */ Activity mr;
    final /* synthetic */ p tli;

    p$3(p pVar, int i, Activity activity) {
        this.tli = pVar;
        this.hdX = i;
        this.mr = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.hdX == 32) {
            f.mDy.a(462, 6, 1, true);
        } else if (this.hdX == 96) {
            f.mDy.a(462, 7, 1, true);
        } else {
            f.mDy.a(462, 8, 1, true);
        }
        dialogInterface.dismiss();
        MMAppMgr.h(this.mr, true);
        this.mr.finish();
    }
}
