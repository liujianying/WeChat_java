package com.tencent.mm.pluginsdk;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.protocal.c.bua;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;

class d$4 implements a {
    final /* synthetic */ ProgressDialog qye;
    final /* synthetic */ Context val$context;

    d$4(ProgressDialog progressDialog, Context context) {
        this.qye = progressDialog;
        this.val$context = context;
    }

    public final void a(int i, int i2, String str, l lVar, boolean z) {
        x.i("MicroMsg.DeepLinkHelper", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z)});
        if (this.qye != null && this.qye.isShowing()) {
            this.qye.dismiss();
        }
        if (lVar != null && i != 0 && i2 != 0 && (lVar instanceof aa)) {
            bua Rw = ((aa) lVar).Rw();
            if (Rw != null && this.val$context != null) {
                s.makeText(this.val$context, this.val$context.getString(R.l.app_tip) + " : " + bi.oV(Rw.srt), 0).show();
            }
        }
    }
}
