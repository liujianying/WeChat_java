package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.bind.a.d;
import com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ.2;
import com.tencent.mm.ui.base.h;

class StartUnbindQQ$2$1 implements OnClickListener {
    final /* synthetic */ 2 eJk;

    StartUnbindQQ$2$1(2 2) {
        this.eJk = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.DF().a(new d(""), 0);
        StartUnbindQQ startUnbindQQ = this.eJk.eJj;
        StartUnbindQQ startUnbindQQ2 = this.eJk.eJj;
        this.eJk.eJj.getString(j.app_tip);
        StartUnbindQQ.a(startUnbindQQ, h.a(startUnbindQQ2, this.eJk.eJj.getString(j.setting_unbinding_qq), true, null));
    }
}
