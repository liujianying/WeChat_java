package com.tencent.mm.plugin.profile.ui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.ui.base.h;

class a$1 implements a {
    final /* synthetic */ a lYp;

    a$1(a aVar) {
        this.lYp = aVar;
    }

    public final boolean vD() {
        if (!this.lYp.bOb.isFinishing()) {
            a aVar = this.lYp;
            Context context = this.lYp.bOb;
            this.lYp.bOb.getString(R.l.app_tip);
            aVar.jnR = h.a(context, this.lYp.bOb.getString(R.l.app_waiting), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    au.DF().c(a$1.this.lYp.lYn);
                    a$1.this.lYp.jnR = null;
                }
            });
        }
        return false;
    }
}
