package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.f;

class p$4 implements OnClickListener {
    final /* synthetic */ int hdX;
    final /* synthetic */ Activity mr;
    final /* synthetic */ p tli;

    p$4(p pVar, int i, Activity activity) {
        this.tli = pVar;
        this.hdX = i;
        this.mr = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.hdX == 33) {
            f.mDy.a(462, 12, 1, true);
        } else if (this.hdX == 97) {
            f.mDy.a(462, 13, 1, true);
        } else {
            f.mDy.a(462, 14, 1, true);
        }
        Intent intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
        intent.addFlags(268435456);
        this.mr.startActivity(intent);
        dialogInterface.dismiss();
        this.tli.eLU = true;
        MMAppMgr.h(this.mr, true);
        this.mr.finish();
    }
}
