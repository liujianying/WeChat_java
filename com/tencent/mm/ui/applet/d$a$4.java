package com.tencent.mm.ui.applet;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.applet.d.a;

class d$a$4 extends ag {
    final /* synthetic */ a tse;

    d$a$4(a aVar) {
        this.tse = aVar;
    }

    public final void handleMessage(Message message) {
        if (this.tse.jWm.getVisibility() != 0) {
            this.tse.tsc = 0;
            return;
        }
        a aVar = this.tse;
        aVar.tsc++;
        this.tse.crd();
        super.handleMessage(message);
    }
}
