package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import com.tencent.mm.e.b.c.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements a {
    final /* synthetic */ a gjh;

    a$1(a aVar) {
        this.gjh = aVar;
    }

    public final void s(byte[] bArr, int i) {
        x.i("MicroMsg.Record.AppBrandRecorder", "onRecPcmDataReady()");
        if (this.gjh.gjf != null) {
            this.gjh.gjf.s(bArr, i);
        }
    }

    public final void aN(int i, int i2) {
        x.e("MicroMsg.Record.AppBrandRecorder", "state:%d, detailState:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.gjh.gjf != null) {
            this.gjh.gjf.aN(i, i2);
        }
    }
}
