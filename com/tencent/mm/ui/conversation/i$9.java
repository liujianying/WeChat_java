package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class i$9 implements Runnable {
    final /* synthetic */ i uqR;

    i$9(i iVar) {
        this.uqR = iVar;
    }

    public final void run() {
        String str = "MicroMsg.InitHelper";
        String str2 = "dkinit showProgressDlg t:%d initScene:%d";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(i.f(this.uqR).Ad());
        objArr[1] = Integer.valueOf(i.g(this.uqR) == null ? -2 : i.g(this.uqR).hashCode());
        x.d(str, str2, objArr);
        if (i.h(this.uqR) != null && i.h(this.uqR).isShowing()) {
            i.h(this.uqR).dismiss();
        }
        i iVar = this.uqR;
        Context a = i.a(this.uqR);
        i.a(this.uqR).getString(R.l.app_tip);
        i.a(iVar, h.a(a, i.a(this.uqR).getString(R.l.app_loading_data), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                au.DF().c(i.g(i$9.this.uqR));
                if (n.nky != null) {
                    n.nky.bwT();
                }
            }
        }));
        au.Em().uW();
    }
}
