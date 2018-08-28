package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Vector;

public final class b {
    private static Vector<l> ibI = new Vector();
    private static l ibJ;

    public static void a(l lVar) {
        if (lVar != null && !ibI.contains(lVar)) {
            ibI.add(lVar);
        }
    }

    public static void b(l lVar) {
        if (lVar != null) {
            ibI.remove(lVar);
        }
    }

    public static void c(l lVar) {
        ibJ = lVar;
    }

    public static void aCP() {
        ibJ = null;
    }

    public final void i(long j, String str) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskStarted: %d, %s", Long.valueOf(j), str);
        ah.A(new 1(this, j, str));
    }

    public final void j(long j, String str) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskResumed: %d, %s", Long.valueOf(j), str);
        ah.A(new 2(this, j, str));
    }

    public final void cp(long j) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskRemoved: %d", Long.valueOf(j));
        ah.A(new 3(this, j));
    }

    public final void c(long j, String str, boolean z) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFinished: %d", Long.valueOf(j));
        ah.A(new 4(this, j, str, z));
    }

    public final void c(long j, int i, boolean z) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFailed: %d, errCode : %d", Long.valueOf(j), Integer.valueOf(i));
        ah.A(new 5(this, j, i, z));
    }

    public final void cq(long j) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskPaused: %d", Long.valueOf(j));
        ah.A(new 6(this, j));
    }

    public final void cr(long j) {
        ah.A(new 7(this, j));
    }
}
