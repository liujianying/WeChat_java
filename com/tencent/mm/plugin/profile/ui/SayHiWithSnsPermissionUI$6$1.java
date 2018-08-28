package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.openim.b.f;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.6;

class SayHiWithSnsPermissionUI$6$1 implements OnCancelListener {
    final /* synthetic */ f lYj;
    final /* synthetic */ 6 lYk;

    SayHiWithSnsPermissionUI$6$1(6 6, f fVar) {
        this.lYk = 6;
        this.lYj = fVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.lYj);
    }
}
