package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.x;

class w$1 implements Runnable {
    final /* synthetic */ w mdY;

    w$1(w wVar) {
        this.mdY = wVar;
    }

    public final void run() {
        if (au.HX()) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = new s();
            if (sVar.mds.lap.size() > 0) {
                for (int i = 0; i < sVar.mds.lap.size(); i++) {
                    s.JW(((q) sVar.mds.lap.get(i)).mck);
                }
                sVar.mds.lap.clear();
                sVar.save();
            }
            x.i("SubCoreQQMail", "summeranrt onAccountPostReset notifyAllFail take[%d]ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }
}
