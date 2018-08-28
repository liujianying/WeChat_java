package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Looper;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.wallet_core.ui.g;

public final class a {
    private Dialog eXG = null;
    private Context mContext;
    a pfr = null;

    public a(Context context, a aVar) {
        this.mContext = context;
        this.pfr = aVar;
    }

    public final void release() {
        this.pfr = null;
        this.mContext = null;
    }

    public final void a(boolean z, int i, String str) {
        gv gvVar = new gv();
        gvVar.bPX = null;
        gvVar.bPW.bPY = z;
        if (z && (this.eXG == null || !(this.eXG == null || this.eXG.isShowing()))) {
            if (this.eXG != null) {
                this.eXG.dismiss();
            }
            this.eXG = g.a(this.mContext, false, new 2(this));
        }
        gvVar.bPW.bPZ = i;
        gvVar.bPW.bQa = str;
        gvVar.bJX = new 1(this, gvVar);
        com.tencent.mm.sdk.b.a.sFg.a(gvVar, Looper.getMainLooper());
    }

    public final void bNx() {
        if (this.eXG != null) {
            this.eXG.dismiss();
            this.eXG = null;
        }
    }
}
