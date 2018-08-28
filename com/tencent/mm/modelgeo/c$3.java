package com.tencent.mm.modelgeo;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class c$3 implements Runnable {
    final /* synthetic */ a dSE;
    final /* synthetic */ c dSu;

    c$3(c cVar, a aVar) {
        this.dSu = cVar;
        this.dSE = aVar;
    }

    public final void run() {
        List<WeakReference> arrayList = new ArrayList();
        for (WeakReference weakReference : this.dSu.avD) {
            if (weakReference == null || weakReference.get() == null || ((a) weakReference.get()).equals(this.dSE)) {
                arrayList.add(weakReference);
            }
        }
        for (WeakReference weakReference2 : arrayList) {
            this.dSu.avD.remove(weakReference2);
        }
        x.i("MicroMsg.LocationGeo", "stop listeners size %d", new Object[]{Integer.valueOf(this.dSu.avD.size())});
        if (this.dSu.avD.size() == 0 && this.dSu.dSd != null) {
            g.OF();
        }
    }
}
