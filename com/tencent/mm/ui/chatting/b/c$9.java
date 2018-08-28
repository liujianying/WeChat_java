package com.tencent.mm.ui.chatting.b;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.b.c.a;

class c$9 implements a {
    final /* synthetic */ c tOm;

    c$9(c cVar) {
        this.tOm = cVar;
    }

    public final boolean cuF() {
        if (c.a(this.tOm) == null) {
            i.a(this.tOm.bAG.tTq, R.h.viewstub_bizwait);
            c.a(this.tOm, (RelativeLayout) this.tOm.bAG.findViewById(R.h.bizwait));
            c.a(this.tOm, (TextView) this.tOm.bAG.findViewById(R.h.bizwait_msg));
            c.b(this.tOm).setText(R.l.chatfooter_getting);
        }
        c.a(this.tOm).setVisibility(0);
        com.tencent.mm.ui.chatting.c.a.cwt().postDelayed(new 1(this), 5000);
        return true;
    }
}
