package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import com.tencent.mm.model.au;
import com.tencent.mm.ui.chatting.b.b.af;
import com.tencent.mm.ui.chatting.b.b.m;
import com.tencent.mm.ui.widget.DrawedCallBackLinearLayout$a;

class ae$1 implements DrawedCallBackLinearLayout$a {
    final /* synthetic */ Intent heh;
    final /* synthetic */ int ms;
    final /* synthetic */ String tRM;
    final /* synthetic */ m tRN;
    final /* synthetic */ ae tRO;

    ae$1(ae aeVar, Intent intent, String str, m mVar, int i) {
        this.tRO = aeVar;
        this.heh = intent;
        this.tRM = str;
        this.tRN = mVar;
        this.ms = i;
    }

    public final void aRL() {
        au.Em().h(new Runnable() {
            public final void run() {
                au.Em().uW();
                ae.a(ae$1.this.tRO, ae$1.this.heh, ae$1.this.tRM);
                ((af) ae$1.this.tRO.bAG.O(af.class)).ax(ae$1.this.heh);
                if (ae$1.this.tRN.cvc() != null) {
                    ae$1.this.tRN.cvc().k(ae$1.this.ms, ae$1.this.heh);
                }
                au.Em().cik();
            }
        }, 100);
    }
}
