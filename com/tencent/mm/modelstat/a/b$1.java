package com.tencent.mm.modelstat.a;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ Bundle bAE;

    public b$1(Bundle bundle) {
        this.bAE = bundle;
    }

    public final void run() {
        try {
            a aVar = (a) Class.forName(this.bAE.getString("mm_event_class")).newInstance();
            x.i("MicroMsg.WebViewMMReportUtil", "webview callback report className[%s]", new Object[]{this.bAE.getString("mm_event_class")});
            aVar.k(this.bAE);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebViewMMReportUtil", e, "receiveWebViewCallback error", new Object[0]);
        }
    }
}
