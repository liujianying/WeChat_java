package com.tencent.mm.plugin.card.sharecard.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.sharecard.model.h;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ a hyd;

    a$1(a aVar) {
        this.hyd = aVar;
    }

    public final void run() {
        x.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene after 5s");
        g.Eh().dpP.a(new h(), 0);
    }
}
