package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.f;

class p$5 implements OnClickListener {
    final /* synthetic */ int hdX;
    final /* synthetic */ Activity mr;
    final /* synthetic */ p tli;

    p$5(p pVar, int i, Activity activity) {
        this.tli = pVar;
        this.hdX = i;
        this.mr = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.hdX == 33) {
            f.mDy.a(462, 15, 1, true);
        } else if (this.hdX == 97) {
            f.mDy.a(462, 16, 1, true);
        } else {
            f.mDy.a(462, 17, 1, true);
        }
        dialogInterface.dismiss();
        this.tli.eLU = true;
        MMAppMgr.h(this.mr, true);
        this.mr.finish();
    }
}
