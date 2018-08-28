package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.aa.f.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.chatting.c.a;

class s$3 implements c {
    final /* synthetic */ s tQv;

    s$3(s sVar) {
        this.tQv = sVar;
    }

    public final void jX(final String str) {
        a.cwt().postDelayed(new Runnable() {
            public final void run() {
                if (!bi.oW(s.d(s$3.this.tQv)) && !bi.oW(str) && str.equals(s.d(s$3.this.tQv))) {
                    s$3.this.tQv.cvq();
                }
            }
        }, 1000);
    }
}
