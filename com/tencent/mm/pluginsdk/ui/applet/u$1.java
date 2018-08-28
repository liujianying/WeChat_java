package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.ui.base.h;

class u$1 implements a {
    final /* synthetic */ u qJQ;

    u$1(u uVar) {
        this.qJQ = uVar;
    }

    public final boolean vD() {
        u uVar = this.qJQ;
        Context context = this.qJQ.context;
        this.qJQ.context.getString(R.l.app_tip);
        uVar.jnR = h.a(context, this.qJQ.context.getString(R.l.app_waiting), true, new 1(this));
        return false;
    }
}
