package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mm.plugin.appbrand.media.record.record_imp.a.a;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements a {
    final /* synthetic */ e giH;

    e$1(e eVar) {
        this.giH = eVar;
    }

    public final void s(byte[] bArr, int i) {
        if (e.a(this.giH) != null && e.b(this.giH) != null) {
            e eVar = this.giH;
            int c = e.c(this.giH);
            com.tencent.mm.plugin.appbrand.media.record.record_imp.a b = e.b(this.giH);
            e.a(eVar, (b.bDp != null ? b.bDp.bDL : 20) + c);
            try {
                if (!e.a(this.giH).a(e.d(this.giH), bArr, i)) {
                    x.e("MicroMsg.Record.AudioRecordMgr", "encode pcm fail!");
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "onRecPcmDataReady", new Object[0]);
                if (e.e(this.giH) != null && "mp3".equalsIgnoreCase(e.e(this.giH).fIJ)) {
                    h.li(19);
                } else if (e.e(this.giH) != null && "aac".equalsIgnoreCase(e.e(this.giH).fIJ)) {
                    h.li(23);
                }
            }
        }
    }

    public final void aN(int i, int i2) {
        x.i("MicroMsg.Record.AudioRecordMgr", "onRecError state:%d, detailState:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.giH.onError(1);
    }
}
