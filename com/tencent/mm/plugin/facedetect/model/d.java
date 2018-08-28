package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class d {
    private static volatile d iNk = null;
    public static final Object mLock = new Object();
    public List<a> iNl = null;

    private class a {
        public byte[] data;
        public b iNm;

        a(b bVar) {
            this.iNm = bVar;
        }
    }

    public static final d aJB() {
        if (iNk != null) {
            return iNk;
        }
        d dVar;
        synchronized (mLock) {
            if (iNk == null) {
                iNk = new d();
            }
            dVar = iNk;
        }
        return dVar;
    }

    public final synchronized void a(b bVar) {
        if (bVar == null) {
            x.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: invalid callbacker");
        } else {
            synchronized (mLock) {
                if (this.iNl == null) {
                    this.iNl = Collections.synchronizedList(new ArrayList(5));
                }
                this.iNl.add(new a(bVar));
            }
        }
    }

    public final void b(b bVar) {
        synchronized (mLock) {
            if (this.iNl != null) {
                this.iNl.remove(bVar);
            }
        }
    }
}
