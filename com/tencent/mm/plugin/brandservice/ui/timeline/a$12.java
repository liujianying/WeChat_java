package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.q;

class a$12 implements Runnable {
    final /* synthetic */ q her;
    final /* synthetic */ a hqX;

    a$12(a aVar, q qVar) {
        this.hqX = aVar;
        this.her = qVar;
    }

    public final void run() {
        if (this.her != null) {
            bd GE = ((i) g.l(i.class)).bcY().GE(this.her.field_talker);
            if (GE != null && GE.field_msgId == this.her.field_msgId) {
                ((i) g.l(i.class)).FW().Ys(this.her.field_talker);
            }
        }
    }
}
