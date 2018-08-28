package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.os.Message;
import com.tencent.mm.bb.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

class n$2 extends ag {
    final /* synthetic */ n qwa;

    n$2(n nVar) {
        this.qwa = nVar;
    }

    public final void handleMessage(Message message) {
        if (n.a(this.qwa).qpd) {
            n.b(this.qwa).removeMessages(Downloads.RECV_BUFFER_SIZE);
            return;
        }
        n.c(this.qwa).setText(" " + a.v(ad.getContext(), n.a(this.qwa).qpr).toString());
        sendEmptyMessageDelayed(Downloads.RECV_BUFFER_SIZE, 500);
    }
}
