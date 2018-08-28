package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.ui.base.h;

class StartUnbindQQ$2 implements OnClickListener {
    final /* synthetic */ StartUnbindQQ eJj;

    StartUnbindQQ$2(StartUnbindQQ startUnbindQQ) {
        this.eJj = startUnbindQQ;
    }

    public final void onClick(View view) {
        if (StartUnbindQQ.a(this.eJj) == null) {
            StartUnbindQQ.a(this.eJj, h.a(this.eJj, this.eJj.getString(a$j.setting_unbinding_confirm), null, new 1(this), new 2(this)));
        } else {
            StartUnbindQQ.a(this.eJj).show();
        }
    }
}
