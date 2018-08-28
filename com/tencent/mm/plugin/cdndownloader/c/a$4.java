package com.tencent.mm.plugin.cdndownloader.c;

import com.tencent.mm.plugin.cdndownloader.a.b.a;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.sdk.platformtools.x;

class a$4 extends a {
    final /* synthetic */ a hKi;

    a$4(a aVar) {
        this.hKi = aVar;
    }

    public final void e(String str, int i, int i2, String str2) {
        x.i("MicroMsg.CDNDownloadClient", "onDownloadStateChange, mediaId = %s, state = %d, errCode = %d, errMsg = %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        if (i != 1) {
            this.hKi.hKc.remove(new CDNTaskInfo(str));
        }
        if (this.hKi.hKd != null) {
            this.hKi.hKd.f(str, i, i2, str2);
        }
    }

    public final void k(String str, long j, long j2) {
        x.d("MicroMsg.CDNDownloadClient", "onDownloadProgressChange, mediaId = %s, receiveLen = %d, totalLen = %d", new Object[]{str, Long.valueOf(j), Long.valueOf(j2)});
        if (this.hKi.hKd != null) {
            this.hKi.hKd.l(str, j, j2);
        }
    }
}
