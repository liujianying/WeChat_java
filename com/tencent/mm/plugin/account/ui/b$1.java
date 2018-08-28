package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.ui.base.h;

class b$1 implements OnClickListener {
    final /* synthetic */ Context ePr;
    final /* synthetic */ b ePs;

    b$1(b bVar, Context context) {
        this.ePs = bVar;
        this.ePr = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        final l a = this.ePs.a(this.ePs.ePq, this.ePs.eIX.getSecImgCode());
        g.DF().a(a, 0);
        Context context = this.ePr;
        this.ePr.getString(j.app_tip);
        h.a(context, this.ePr.getString(j.login_logining), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                g.DF().c(a);
            }
        });
    }
}
