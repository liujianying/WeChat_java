package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1;
import com.tencent.mm.sdk.platformtools.bi;

class AppBrandIDCardUI$1$2 implements OnClickListener {
    final /* synthetic */ int bFr;
    final /* synthetic */ String dJG;
    final /* synthetic */ 1 gxC;

    AppBrandIDCardUI$1$2(1 1, int i, String str) {
        this.gxC = 1;
        this.bFr = i;
        this.dJG = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("intent_err_code", bi.p(Integer.valueOf(this.bFr), 0));
        intent.putExtra("intent_err_msg", bi.oV(this.dJG));
        this.gxC.gxB.setResult(1, intent);
        this.gxC.gxB.finish();
    }
}
