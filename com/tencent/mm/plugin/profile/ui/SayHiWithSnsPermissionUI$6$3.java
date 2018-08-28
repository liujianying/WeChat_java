package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.openim.b.g;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.6;

class SayHiWithSnsPermissionUI$6$3 implements OnCancelListener {
    final /* synthetic */ 6 lYk;
    final /* synthetic */ g lYm;

    SayHiWithSnsPermissionUI$6$3(6 6, g gVar) {
        this.lYk = 6;
        this.lYm = gVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.lYm);
    }
}
