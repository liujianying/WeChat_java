package com.tencent.mm.plugin.game.model.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.l;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements l {
    public final void onTaskStarted(long j, String str) {
        c("onTaskStarted", j, true);
    }

    public final void b(long j, String str, boolean z) {
        x.i("MicroMsg.GameSilentDownloadCallback", "onTaskFinished");
        a cs = c.cs(j);
        if (cs != null && cs.field_autoDownload) {
            e.U(cs.field_appId, 0, 0);
            DA(cs.field_appId);
        }
    }

    public final void b(long j, int i, boolean z) {
        x.i("MicroMsg.GameSilentDownloadCallback", "onTaskFailed, errCode:%d", new Object[]{Integer.valueOf(i)});
        if (i != com.tencent.mm.plugin.downloader.a.a.ibf) {
            a cs = c.cs(j);
            if (cs != null && cs.field_autoDownload) {
                e.U(cs.field_appId, 1, i);
                DA(cs.field_appId);
            }
        }
    }

    public final void onTaskRemoved(long j) {
        x.i("MicroMsg.GameSilentDownloadCallback", "onTaskRemoved");
        a cs = c.cs(j);
        if (cs != null && cs.field_autoDownload) {
            e.U(cs.field_appId, 2, 0);
            DA(cs.field_appId);
        }
    }

    public final void onTaskPaused(long j) {
        c("onTaskPaused", j, false);
    }

    public final void bP(long j) {
        x.d("MicroMsg.GameSilentDownloadCallback", "onTaskProgressChanged");
    }

    public final void h(long j, String str) {
        c("onTaskResumed", j, true);
    }

    private static void DA(String str) {
        c cVar = new c();
        cVar.field_appId = str;
        boolean a = ((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSl().a(cVar, new String[0]);
        x.i("MicroMsg.GameSilentDownloadCallback", "removeSilentDownloadTask, appid:%s, ret:%b", new Object[]{str, Boolean.valueOf(a)});
    }

    private static void c(String str, long j, boolean z) {
        x.i("MicroMsg.GameSilentDownloadCallback", str);
        a cs = c.cs(j);
        if (cs != null && cs.field_autoDownload) {
            boolean ay = ((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSl().ay(cs.field_appId, z);
            x.i("MicroMsg.GameSilentDownloadCallback", "%s. appid:%s, ret:%b", new Object[]{str, cs.field_appId, Boolean.valueOf(ay)});
        }
    }
}
