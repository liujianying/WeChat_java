package com.tencent.d.b.f;

import com.tencent.d.b.f.h.a;

class h$a$1 implements Runnable {
    final /* synthetic */ int vmP;
    final /* synthetic */ CharSequence vmQ;
    final /* synthetic */ a vmR;

    h$a$1(a aVar, int i, CharSequence charSequence) {
        this.vmR = aVar;
        this.vmP = i;
        this.vmQ = charSequence;
    }

    public final void run() {
        if (this.vmR.vmN.vmH != null) {
            this.vmR.vmN.vmH.onAuthenticationError(this.vmP, this.vmQ);
        }
    }
}
