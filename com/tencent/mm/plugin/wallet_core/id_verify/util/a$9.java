package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.x;

class a$9 implements OnClickListener {
    final /* synthetic */ Activity ews;
    final /* synthetic */ boolean plf;
    final /* synthetic */ String val$url;

    a$9(String str, Activity activity, boolean z) {
        this.val$url = str;
        this.ews = activity;
        this.plf = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.val$url);
        intent.putExtra("showShare", false);
        d.b(this.ews, "webview", ".ui.tools.WebViewUI", intent);
        dialogInterface.dismiss();
        if (this.plf) {
            this.ews.finish();
        }
    }
}
