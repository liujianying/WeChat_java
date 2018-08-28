package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.sandbox.updater.AppUpdaterUI.1;
import com.tencent.mm.sdk.platformtools.x;

class AppUpdaterUI$1$1 implements OnClickListener {
    final /* synthetic */ 1 sDy;

    AppUpdaterUI$1$1(1 1) {
        this.sDy = 1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.AppUpdaterUI", "go to WebView");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
        intent.addFlags(268435456);
        this.sDy.sDx.startActivity(intent);
    }
}
