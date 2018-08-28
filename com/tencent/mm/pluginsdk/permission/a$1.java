package com.tencent.mm.pluginsdk.permission;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.a;

class a$1 implements OnClickListener {
    final /* synthetic */ Activity mr;
    final /* synthetic */ int ms;
    final /* synthetic */ String qBf;

    a$1(Activity activity, String str, int i) {
        this.mr = activity;
        this.qBf = str;
        this.ms = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        a.a(this.mr, new String[]{this.qBf}, this.ms);
    }
}
