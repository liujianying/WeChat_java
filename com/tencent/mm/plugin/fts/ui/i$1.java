package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class i$1 extends ag {
    final /* synthetic */ i jwH;

    i$1(i iVar, Looper looper) {
        this.jwH = iVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                x.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is true");
                if (!i.a(this.jwH) && this.jwH.getCount() > 0) {
                    ((n) g.n(n.class)).getFTSImageLoader().aPO();
                    com.tencent.mm.plugin.sns.b.n.nkx.start();
                    this.jwH.notifyDataSetChanged();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
