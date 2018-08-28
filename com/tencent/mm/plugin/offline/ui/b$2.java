package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.wallet_core.ui.e;

class b$2 implements OnClickListener {
    final /* synthetic */ String lKY;
    final /* synthetic */ Activity mr;

    b$2(String str, Activity activity) {
        this.lKY = str;
        this.mr = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.lKY);
        d.b(this.mr, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        e.He(3);
        dialogInterface.dismiss();
    }
}
