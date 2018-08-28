package com.tencent.mm.plugin.voip.ui;

import android.content.Intent;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;

class g$1 implements a {
    final /* synthetic */ a oSQ;
    final /* synthetic */ g oSR;
    final /* synthetic */ Intent val$intent;

    g$1(g gVar, a aVar, Intent intent) {
        this.oSR = gVar;
        this.oSQ = aVar;
        this.val$intent = intent;
    }

    public final void a(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
        requestFloatWindowPermissionDialog.finish();
        if (this.oSQ.aWU()) {
            g.a(this.oSR, this.val$intent);
        }
    }

    public final void b(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
        requestFloatWindowPermissionDialog.finish();
    }
}
