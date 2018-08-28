package com.tencent.d.b.f;

import com.tencent.d.b.f.h.a;

class h$a$2 implements Runnable {
    final /* synthetic */ a vmR;
    final /* synthetic */ int vmS;
    final /* synthetic */ CharSequence vmT;

    h$a$2(a aVar, int i, CharSequence charSequence) {
        this.vmR = aVar;
        this.vmS = i;
        this.vmT = charSequence;
    }

    public final void run() {
        if (this.vmR.vmN.vmH != null) {
            this.vmR.vmN.vmH.onAuthenticationHelp(this.vmS, a.T(this.vmT));
        }
    }
}
