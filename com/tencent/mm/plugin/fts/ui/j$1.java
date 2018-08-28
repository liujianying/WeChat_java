package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ag;

class j$1 extends ag {
    final /* synthetic */ j jwU;

    j$1(j jVar, Looper looper) {
        this.jwU = jVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (!j.f(this.jwU) && this.jwU.getCount() > 0) {
                    ((n) g.n(n.class)).getFTSImageLoader().aPO();
                    com.tencent.mm.plugin.sns.b.n.nkx.start();
                    this.jwU.notifyDataSetChanged();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
