package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.ui.base.h;

class r$1 implements a {
    final /* synthetic */ r mMB;

    r$1(r rVar) {
        this.mMB = rVar;
    }

    public final boolean vD() {
        r rVar = this.mMB;
        Context context = this.mMB.context;
        this.mMB.context.getString(R.l.app_tip);
        rVar.jnR = h.a(context, this.mMB.context.getString(R.l.app_waiting), true, new 1(this));
        return false;
    }
}
