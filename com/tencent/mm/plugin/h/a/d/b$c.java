package com.tencent.mm.plugin.h.a.d;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.h.a.d.b.d;
import com.tencent.mm.plugin.h.a.d.b.f;
import com.tencent.mm.plugin.h.a.d.b.h;
import com.tencent.mm.plugin.h.a.d.b.i;
import com.tencent.mm.plugin.h.a.d.b.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class b$c extends ag {
    private WeakReference<b> hgm = null;

    public b$c(Looper looper, b bVar) {
        super(looper);
        this.hgm = new WeakReference(bVar);
    }

    public final void handleMessage(Message message) {
        b bVar = (b) this.hgm.get();
        if (bVar == null) {
            x.w("MicroMsg.exdevice.BluetoothSDKManager", "null == BluetoothSdkManager");
            return;
        }
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "handleMessage Message.What = " + message.what);
        switch (message.what) {
            case 0:
                j jVar = (j) message.obj;
                bVar.hjg.j(jVar.hjk, jVar.hjl);
                return;
            case 1:
                h hVar = (h) message.obj;
                bVar.hjg.b(hVar.mSessionId, hVar.hfA);
                return;
            case 2:
                bVar.hjg.na(message.arg1);
                return;
            case 3:
                i iVar = (i) message.obj;
                bVar.hjg.a(iVar.hjn, iVar.fNv, message.arg1, iVar.fNP, iVar.hjo);
                return;
            case 4:
                f fVar = (f) message.obj;
                bVar.hjg.i(fVar.hjk, fVar.hjl);
                return;
            case 5:
                bVar.hjg.bY(((b$g) message.obj).mSessionId);
                return;
            case 6:
                d dVar = (d) message.obj;
                bVar.hjg.b(dVar.mSessionId, dVar.hjj, dVar.hfR);
                return;
            default:
                return;
        }
    }
}
