package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.s.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pluginsdk.g.a.c.m;
import java.util.ArrayList;
import java.util.Locale;

public final class d implements b {

    private static final class a implements com.tencent.mm.plugin.appbrand.appcache.s.a {
        private ArrayList<IDKey> ffR;
        private long ffS;
        private long ffT;
        private final ar fvu;
        private int fvv;

        /* synthetic */ a(ar arVar, byte b) {
            this(arVar);
        }

        private a(ar arVar) {
            this.ffS = 0;
            this.ffT = 0;
            this.fvu = arVar;
        }

        private void kb(int i) {
            if (this.ffR == null) {
                this.ffR = new ArrayList();
            }
            this.ffR.add(new IDKey(640, i, 1));
        }

        private void abI() {
            try {
                f.mDy.b(this.ffR, false);
                this.ffR.clear();
            } catch (Exception e) {
            }
        }

        public final void abs() {
            int i = 0;
            if (com.tencent.mm.plugin.appbrand.appcache.d.a.jC(this.fvu.bPh)) {
                int i2;
                if (((c) g.l(c.class)).aaN() == null) {
                    i2 = 1;
                } else {
                    ap aaN = ((c) g.l(c.class)).aaN();
                    String str = this.fvu.appId;
                    int i3 = this.fvu.bPh;
                    Cursor b = aaN.fhY.b(String.format(Locale.US, "select count(%s) from %s where %s=? and %s=?", new Object[]{"version", "AppBrandWxaPkgManifestRecord", "appId", "debugType"}), new String[]{str, String.valueOf(i3)}, 2);
                    if (b == null) {
                        i2 = 0;
                    } else {
                        if (b.moveToFirst()) {
                            i2 = b.getInt(0);
                        } else {
                            i2 = 0;
                        }
                        b.close();
                    }
                }
                this.fvv = i2 > 1 ? a.fvx : a.fvw;
            } else {
                this.fvv = a.fvw;
            }
            switch (1.fvt[this.fvv - 1]) {
                case 1:
                    i = 1;
                    break;
                case 2:
                    i = 10;
                    break;
            }
            kb(i);
            this.ffS = SystemClock.elapsedRealtime();
        }

        public final void abt() {
            kb(32);
        }

        public final void abu() {
            kb(31);
        }

        public final void a(m mVar) {
            int i;
            boolean z = true;
            int i2 = 2;
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.ffS;
            if (elapsedRealtime <= 1000) {
                i = 0;
            } else if (elapsedRealtime <= 2000) {
                i = 1;
            } else if (elapsedRealtime <= 3000) {
                i = 2;
            } else if (elapsedRealtime <= 4000) {
                i = 3;
            } else if (elapsedRealtime <= 5000) {
                i = 4;
            } else {
                i = 5;
            }
            f.mDy.a(665, (long) i, 1, false);
            f.mDy.a(665, 6, 1, false);
            if (mVar == null || mVar.status != 2) {
                z = false;
            }
            switch (1.fvt[this.fvv - 1]) {
                case 1:
                    if (!z) {
                        i2 = 3;
                    }
                    kb(i2);
                    break;
                case 2:
                    kb(z ? 11 : 12);
                    break;
            }
            abI();
        }

        public final void abv() {
        }

        public final void jD(int i) {
        }

        public final void abw() {
        }

        public final void abx() {
            this.ffT = SystemClock.elapsedRealtime();
            switch (1.fvt[this.fvv - 1]) {
                case 1:
                    kb(5);
                    return;
                case 2:
                    kb(14);
                    return;
                default:
                    return;
            }
        }

        public final void ct(boolean z) {
            int i;
            SystemClock.elapsedRealtime();
            switch (1.fvt[this.fvv - 1]) {
                case 1:
                    if (!z) {
                        i = 7;
                        break;
                    } else {
                        i = 6;
                        break;
                    }
                case 2:
                    if (!z) {
                        i = 16;
                        break;
                    } else {
                        i = 15;
                        break;
                    }
                default:
                    i = 0;
                    break;
            }
            kb(i);
            abI();
        }
    }

    public final com.tencent.mm.plugin.appbrand.appcache.s.a a(com.tencent.mm.plugin.appbrand.appcache.base.a aVar) {
        if (ar.class == aVar.getClass()) {
            return new a((ar) aVar, (byte) 0);
        }
        return null;
    }
}
