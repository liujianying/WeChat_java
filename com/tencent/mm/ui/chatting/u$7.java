package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.i.a;

class u$7 implements a {
    final /* synthetic */ u tKV;

    u$7(u uVar) {
        this.tKV = uVar;
    }

    public final void uX(int i) {
        this.tKV.tKO = i;
        this.tKV.ctU();
    }

    public final void boB() {
        this.tKV.tKL.setText(R.l.chatfooter_mail_without_unread_count);
    }
}
