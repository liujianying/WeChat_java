package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.ac.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;

public final class w implements t {
    l bKq;
    public Context mContext;
    public a qAa;
    public p tipDialog;

    public w(Context context, a aVar) {
        this.mContext = context;
        this.qAa = aVar;
    }

    public final void a(int i, int i2, String str, x xVar) {
        x.i("MicroMsg.LoadAppInfoAfterLogin", "OnScenEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        a.bmi().b(7, this);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.qAa != null) {
            this.qAa.Zq();
        }
        g.cbM();
    }
}
