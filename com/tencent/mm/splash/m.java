package com.tencent.mm.splash;

import android.app.Application;
import com.tencent.mm.sdk.platformtools.x;

public final class m {
    private static String bqA;
    private static Application sMx;
    private static boolean sNu = false;
    private static a sNv;
    private static boolean sNw = false;
    private static com.tencent.mm.splash.o.a sNx;

    public interface a {
        void a(com.tencent.mm.splash.o.a aVar);

        void b(Application application, String str);

        void vj();
    }

    public static void a(Application application, String str, final String str2) {
        boolean z = true;
        sMx = application;
        bqA = str;
        h.a(new o() {
            public final void d(com.tencent.mm.splash.o.a aVar) {
                x.i("MicroMsg.SplashInit", "do one more thing");
                m.sNx = aVar;
                m.XC(str2);
                m.ckm();
            }
        });
        h.ckd().mStartTimestamp = System.currentTimeMillis();
        if (!application.getPackageName().equals(str)) {
            h.b("MicroMsg.SplashInit", "not main process(%s), no hack, do fallback.", str);
        } else if (h.f(application)) {
            z = false;
            h.cjY();
        } else {
            h.ckd().f(675, 5, 1);
            h.gf(application);
            h.b("MicroMsg.SplashInit", "hack failed, do fallback logic.", new Object[0]);
        }
        sNu = z;
        if (h.sMB != null) {
            h.sMB.vi();
        }
        if (z) {
            if (a.fZ(application)) {
                try {
                    a.gb(application);
                    h.b("MicroMsg.SplashInit", "block checking dex opt result: %s", Boolean.valueOf(a.gd(application)));
                    if (!a.gd(application)) {
                        h.b("MicroMsg.SplashInit", "dexopt service return failed or timeout. kill self.", new Object[0]);
                        h.cjX();
                    }
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
            a.ga(application);
        }
        if (f.lY || z) {
            XC(str2);
        }
    }

    private static void XC(String str) {
        if (sNv == null) {
            a XD = XD(str);
            XD.b(sMx, bqA);
            sNv = XD;
        }
    }

    private static void ckm() {
        if (sNw && sNx != null) {
            sNv.a(sNx);
        }
    }

    public static void ckn() {
        h.b("MicroMsg.SplashInit", "applicationOnCreate", new Object[0]);
        h.cjT();
        sNw = true;
        if (sNu) {
            sNv.vj();
        } else {
            ckm();
        }
    }

    private static a XD(String str) {
        try {
            return (a) Class.forName(str).newInstance();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SplashInit", e, "%s has problem!", str);
            throw new RuntimeException(e);
        }
    }
}
