package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class n {
    boolean lgD = false;
    a lgE;
    final Object lock = new byte[0];

    n() {
    }

    public final a s(Context context, int i) {
        if (context == null) {
            return null;
        }
        long VF = bi.VF();
        long id = Thread.currentThread().getId();
        synchronized (this.lock) {
            this.lgD = false;
            this.lgE = null;
            e.post(new 1(this, id, VF, context, i), "SightCamera_openCamera");
            try {
                this.lock.wait(30000);
            } catch (InterruptedException e) {
                x.e("MicroMsg.SightCamera.OpenCameraThread", "Lock wait failed e:%s", e.getMessage());
            }
            if (this.lgE == null || this.lgE.ddt == null) {
                this.lgD = true;
                x.e("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Timeout:%d", Long.valueOf(bi.VF() - VF));
                return null;
            }
            x.i("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Succ thread:%d Time:%d camera:%s", Long.valueOf(id), Long.valueOf(bi.VF() - VF), this.lgE.ddt);
            a aVar = this.lgE;
            return aVar;
        }
    }
}
