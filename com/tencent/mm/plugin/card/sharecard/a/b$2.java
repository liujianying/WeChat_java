package com.tencent.mm.plugin.card.sharecard.a;

import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements Runnable {
    b$2() {
    }

    public final void run() {
        x.i("MicroMsg.ShareCardDataMgr", "begin to delelteAllIllegalStatusCard()");
        k axq = am.axq();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where (status=1 OR status=2 OR status=3 OR status=4 OR status=6)");
        x.i("MicroMsg.ShareCardInfoStorage", "delelteAllIllegalStatusCard updateRet is " + (axq.diF.fV("ShareCardInfo", new StringBuilder("delete from ShareCardInfo").append(stringBuilder.toString()).toString()) ? 1 : 0));
        x.i("MicroMsg.ShareCardDataMgr", "end to delelteAllIllegalStatusCard()");
    }
}
