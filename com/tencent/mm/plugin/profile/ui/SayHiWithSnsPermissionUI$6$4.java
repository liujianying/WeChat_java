package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.6;
import com.tencent.mm.pluginsdk.model.m;

class SayHiWithSnsPermissionUI$6$4 implements OnCancelListener {
    final /* synthetic */ 6 lYk;
    final /* synthetic */ m lYl;

    SayHiWithSnsPermissionUI$6$4(6 6, m mVar) {
        this.lYk = 6;
        this.lYl = mVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.lYl);
    }
}
