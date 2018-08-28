package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Looper;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.plugin.appbrand.media.record.a.c.a;
import com.tencent.mm.sdk.platformtools.x;

class e$4 implements a {
    final /* synthetic */ e giH;

    e$4(e eVar) {
        this.giH = eVar;
    }

    public final void c(byte[] bArr, int i, boolean z) {
        e eVar = this.giH;
        x.i("MicroMsg.Record.AudioRecordMgr", "onFrameRecorded  buffSize:%d, isLastFrameL:%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        lk lkVar = new lk();
        lkVar.bVK.state = "frameRecorded";
        if (eVar.giw != null) {
            lkVar.bVK.appId = eVar.giw.appId;
        }
        lkVar.bVK.action = 5;
        Object obj = new byte[i];
        System.arraycopy(bArr, 0, obj, 0, i);
        lkVar.bVK.bVL = obj;
        lkVar.bVK.bVM = z;
        com.tencent.mm.sdk.b.a.sFg.a(lkVar, Looper.getMainLooper());
    }
}
