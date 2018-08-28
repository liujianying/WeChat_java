package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsHeader.1;
import com.tencent.mm.ui.base.h.c;

class SnsHeader$1$1 implements c {
    final /* synthetic */ long nWp;
    final /* synthetic */ 1 nWq;

    SnsHeader$1$1(1 1, long j) {
        this.nWq = 1;
        this.nWp = j;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                if (!SnsHeader.g(this.nWq.nWo)) {
                    SnsHeader.a(this.nWq.nWo, this.nWp);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
