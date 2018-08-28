package com.tencent.mm.plugin.account.friend.ui;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class i$1 extends ag {
    final /* synthetic */ i eNG;

    i$1(i iVar) {
        this.eNG = iVar;
    }

    public final void handleMessage(Message message) {
        if ((i.a(this.eNG) == null || i.a(this.eNG).isShowing()) && !i.b(this.eNG)) {
            i.a(this.eNG, i.c(this.eNG) + 1);
            i.d(this.eNG).setProgress(i.c(this.eNG));
            if (i.c(this.eNG) < i.d(this.eNG).getMax() - 2) {
                sendEmptyMessageDelayed(0, 1000);
                return;
            }
            i.e(this.eNG);
            i.d(this.eNG).setIndeterminate(true);
            if (!i.f(this.eNG)) {
                if (i.a(this.eNG) != null) {
                    i.a(this.eNG).dismiss();
                }
                i.a(this.eNG, new Bundle());
            }
        }
    }
}
