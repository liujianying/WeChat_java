package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.m;
import java.io.Closeable;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ao {
    public static final String[] fgM = af.fgM;
    private static final Map<g, ao> fhS = new HashMap();
    private static final ao fhT = new ao() {
        protected final <T> T f(String str, Class<T> cls) {
            return null;
        }
    };
    private final n fhU;
    private final String mAppId;

    private static final class a implements b<byte[]> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final /* synthetic */ Object c(String str, InputStream inputStream) {
            return c.p(inputStream);
        }
    }

    /* synthetic */ ao() {
        this(null);
    }

    static /* synthetic */ void b(ao aoVar) {
        if (aoVar.fhU != null) {
            aoVar.fhU.close();
        }
    }

    public static void l(g gVar) {
        ao n = n(gVar);
        if (n != null && n.fhU != null) {
            n.fhU.abJ();
        }
    }

    public static n m(g gVar) {
        return n(gVar).fhU;
    }

    public static String a(g gVar, String str) {
        return bi.oV((String) n(gVar).f(str, String.class));
    }

    public static boolean b(g gVar, String str) {
        Closeable d = d(gVar, str);
        if (d == null) {
            return false;
        }
        bi.d(d);
        return true;
    }

    public static m c(g gVar, String str) {
        return (m) n(gVar).f(str, m.class);
    }

    public static InputStream d(g gVar, String str) {
        return (InputStream) n(gVar).f(str, InputStream.class);
    }

    public static byte[] e(g gVar, String str) {
        return (byte[]) n(gVar).f(str, byte[].class);
    }

    public static String f(g gVar, String str) {
        return p.a(n(gVar).fhU.qH("__APP__"), str);
    }

    private static ao n(g gVar) {
        if (gVar == null) {
            return fhT;
        }
        ao aoVar;
        synchronized (fhS) {
            aoVar = (ao) fhS.get(gVar);
            if (aoVar == null) {
                aoVar = new ao(gVar);
                fhS.put(gVar, aoVar);
            }
        }
        return aoVar;
    }

    private ao(g gVar) {
        if (gVar == null) {
            this.fhU = null;
            this.mAppId = null;
            return;
        }
        this.mAppId = gVar.mAppId;
        this.fhU = new n(gVar.fcu.frm);
        this.fhU.abJ();
        e.a(this.mAppId, new 2(this, gVar));
    }

    protected <T> T f(String str, Class<T> cls) {
        T t = null;
        boolean z = true;
        boolean z2 = bi.oW(str) ? true : s.fj(str, "about:blank") ? true : c.vN(str);
        if (!z2) {
            InputStream qI;
            String qC = a.qC(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (com.tencent.mm.compatible.loader.a.a(fgM, qC)) {
                qI = WxaCommLibRuntimeReader.qI(qC);
            } else {
                ag qG = this.fhU.qG(qC);
                qI = qG == null ? null : qG.qN(qC);
            }
            if (qI != null) {
                t = ((b) a.fhW.get(cls)).c(qC, qI);
            }
            String str2 = "MicroMsg.WxaPkgRuntimeReader";
            String str3 = "openRead, appId = %s, reqURL = %s, null(%B), type = %s, cost = %dms";
            Object[] objArr = new Object[5];
            objArr[0] = this.mAppId;
            objArr[1] = qC;
            if (t != null) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = cls.getName();
            objArr[4] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
            x.i(str2, str3, objArr);
        }
        return t;
    }
}
