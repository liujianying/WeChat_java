package com.tencent.mm.pluginsdk.ui.chat;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.pluginsdk.ui.chat.i.4;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ak;

class i$2 extends ag {
    final /* synthetic */ i qMU;

    i$2(i iVar, Looper looper) {
        this.qMU = iVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        i iVar = this.qMU;
        if (iVar.bRk != null && iVar.qMP != null && iVar.bitmap != null && iVar.qMQ != null && iVar.nHH != null && iVar.kHl != null) {
            iVar.bRk.setImageBitmap(iVar.bitmap);
            int i = iVar.qMR ? 83 : 85;
            int i2 = iVar.qMR ? 0 : 10;
            int yFromBottom = iVar.qMS != null ? iVar.qMS.getYFromBottom() : iVar.kHl.getHeight();
            if (VERSION.SDK_INT >= 21) {
                Rect cqU = ak.cqU();
                i2 = iVar.qMR ? 0 : i2 + cqU.right;
                yFromBottom += cqU.bottom;
                x.i("MicroMsg.RecentImageBubble", "recent bubble navbar height %s %s", new Object[]{Integer.valueOf(cqU.right), Integer.valueOf(cqU.bottom)});
            }
            iVar.qMQ.showAtLocation(iVar.nHH, i, i2, yFromBottom);
            new al(new 4(iVar), false).J(10000, 10000);
        }
    }
}
