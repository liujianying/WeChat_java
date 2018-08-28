package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class a$8 implements OnClickListener {
    final /* synthetic */ Activity ews;
    final /* synthetic */ boolean plf;

    a$8(boolean z, Activity activity) {
        this.plf = z;
        this.ews = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click cancel");
        dialogInterface.dismiss();
        if (this.plf) {
            this.ews.finish();
        }
    }
}
