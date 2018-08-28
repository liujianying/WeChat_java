package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.os.Bundle;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;

class j$1 implements a {
    final /* synthetic */ int eeg;
    final /* synthetic */ Bundle iMY;
    final /* synthetic */ String qct;
    final /* synthetic */ j qcu;
    final /* synthetic */ String val$url;

    j$1(j jVar, String str, int i, String str2, Bundle bundle) {
        this.qcu = jVar;
        this.val$url = str;
        this.eeg = i;
        this.qct = str2;
        this.iMY = bundle;
    }

    public final void a(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
        requestFloatWindowPermissionDialog.finish();
        j.a(this.qcu, this.val$url, this.eeg, this.qct, this.iMY);
        j.a(this.qcu);
    }

    public final void b(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
        requestFloatWindowPermissionDialog.finish();
    }
}
