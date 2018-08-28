package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements Runnable {
    final /* synthetic */ d ghy;

    d$1(d dVar) {
        this.ghy = dVar;
    }

    public final void run() {
        new Runnable() {
            public final void run() {
                x.i("MicroMsg.AppBrand.Precondition.FromClientPreconditionProcess", "finish(), before send result, ui finishing %b, ui destroyed %b", new Object[]{Boolean.valueOf(d$1.this.ghy.isFinishing()), Boolean.valueOf(d$1.this.ghy.akY())});
                ResultReceiver resultReceiver = (ResultReceiver) d.a(d$1.this.ghy).getParcelableExtra("extra_result_receiver");
                if (resultReceiver != null) {
                    resultReceiver.send(-1, Bundle.EMPTY);
                }
                d.b(d$1.this.ghy);
            }
        }.run();
    }
}
