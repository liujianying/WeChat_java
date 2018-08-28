package com.tencent.mm.plugin.boots.b;

import com.tencent.mm.plugin.downloader.model.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class b$1 implements l {
    final /* synthetic */ b hjF;

    b$1(b bVar) {
        this.hjF = bVar;
    }

    public final void onTaskStarted(long j, String str) {
        if (this.hjF.hjD.contains(Long.valueOf(j))) {
            x.i("MicroMsg.Boots.LuggageLogic", "onTaskStarted id:%d path:%s", new Object[]{Long.valueOf(j), str});
        }
    }

    public final void b(long j, String str, boolean z) {
        if (this.hjF.hjD.contains(Long.valueOf(j))) {
            x.i("MicroMsg.Boots.LuggageLogic", "onTaskStarted id:%d path:%s", new Object[]{Long.valueOf(j), str});
            this.hjF.hjD.remove(Long.valueOf(j));
            if (new c(ad.getContext()).D(new File(str))) {
                x.i("MicroMsg.Boots.LuggageLogic", "check file success.");
            } else {
                x.w("MicroMsg.Boots.LuggageLogic", "check file failed.");
            }
        }
    }

    public final void b(long j, int i, boolean z) {
        if (this.hjF.hjD.contains(Long.valueOf(j))) {
            x.i("MicroMsg.Boots.LuggageLogic", "onTaskFailed id:%d errCode:%d hasChangeUrl", new Object[]{Long.valueOf(j), Integer.valueOf(i), Boolean.valueOf(z)});
            this.hjF.hjD.remove(Long.valueOf(j));
        }
    }

    public final void onTaskRemoved(long j) {
        if (this.hjF.hjD.contains(Long.valueOf(j))) {
            x.i("MicroMsg.Boots.LuggageLogic", "onTaskRemoved id:%d", new Object[]{Long.valueOf(j)});
            this.hjF.hjD.remove(Long.valueOf(j));
        }
    }

    public final void onTaskPaused(long j) {
    }

    public final void bP(long j) {
    }

    public final void h(long j, String str) {
    }
}
