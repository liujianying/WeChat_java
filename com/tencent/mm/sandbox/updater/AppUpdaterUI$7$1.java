package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.sandbox.updater.AppUpdaterUI.7;
import com.tencent.mm.sdk.platformtools.ad;

class AppUpdaterUI$7$1 implements OnClickListener {
    final /* synthetic */ 7 sDz;

    AppUpdaterUI$7$1(7 7) {
        this.sDz = 7;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(AppUpdaterUI.e(this.sDz.sDx).sDK[0]));
        intent.addFlags(268435456);
        ad.getContext().startActivity(intent);
        AppUpdaterUI.f(this.sDz.sDx);
    }
}
