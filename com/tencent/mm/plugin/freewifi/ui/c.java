package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    static String TAG = "MicroMsg.FreeWifi.FreeWifiGetLocation";
    boolean bgH;
    a fRk;
    com.tencent.mm.modelgeo.a jnm;
    ag jnn;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.c$1 */
    class AnonymousClass1 implements a {
        final /* synthetic */ a jno;

        AnonymousClass1(a aVar) {
            this.jno = aVar;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return true;
            }
            x.v(c.TAG, "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2)});
            if (c.this.jnm != null) {
                c.this.jnm.c(c.this.fRk);
            }
            if (c.this.fRk == null) {
                x.w(c.TAG, "already callback");
                return false;
            }
            c.this.fRk = null;
            this.jno.H(f, f2);
            return false;
        }
    }

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
        this.jnm = null;
        this.fRk = null;
        this.jnn = null;
        this.bgH = false;
    }

    public static c aPC() {
        return b.aPD();
    }
}
