package com.tencent.mm.modelcdntran;

import android.os.Looper;
import android.os.Message;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;

class c$1 extends ag {
    final /* synthetic */ c dPb;

    c$1(c cVar, Looper looper) {
        this.dPb = cVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (ao.isConnected(ad.getContext())) {
            x.i("MicroMsg.CdnTransportService", "cdntra mm on network change to get dns.");
            h.mEJ.a(546, 5, 1, true);
            BaseEvent.onNetworkChange();
        }
    }
}
