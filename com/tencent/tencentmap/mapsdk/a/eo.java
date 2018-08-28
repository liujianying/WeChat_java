package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;

public final class eo implements en {
    private static eo a = null;

    public static synchronized eo a() {
        eo eoVar;
        synchronized (eo.class) {
            if (a == null) {
                a = new eo();
            }
            eoVar = a;
        }
        return eoVar;
    }

    public static void a(fn fnVar) {
        Map a = ee.a(fnVar);
        a.put("B64", fnVar.A);
        a.put("B79", fnVar.J);
        if (!TextUtils.isEmpty(fnVar.G)) {
            a.put("B73", fnVar.A);
        }
        a.put("B65", fnVar.u);
        a.put("B66", fnVar.y);
        a.put("B75", fnVar.v);
        a.put("B67", fnVar.B);
        a.put("B70", fnVar.F);
        a.put("B72", fnVar.C);
        a.put("B74", fnVar.D);
        a.put("B68", fnVar.E);
        a.put("B80", fnVar.K);
        a.put("B81", fnVar.L);
        a.put("B77", fnVar.H);
        a.put("B82", fnVar.M);
        a.put("B83", fnVar.l);
        a.put("B84", fnVar.f);
        try {
            fo.a("B_ACSDK_SDKExt_Result", true, 0, 0, a, true);
        } catch (Throwable th) {
        }
    }

    public final void a(eb ebVar) {
        fx.b("AccessSchedulerStatistics", "AccessSchedulerStatistics...onAccessSchedulerFinished, do sdk report...");
        fn fnVar = new fn();
        fnVar.a = ebVar.b();
        fnVar.b = ebVar.c();
        fnVar.c = ebVar.d();
        fnVar.d = ebVar.a();
        fnVar.e = ebVar.e();
        fnVar.h = ebVar.h();
        if (fnVar.h == 1) {
            fnVar.g = fw.a();
        } else {
            fnVar.f = fw.a();
        }
        fnVar.i = ebVar.i();
        List<String> f = ebVar.f();
        if (f == null || f.size() <= 0) {
            fnVar.j = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (String append : f) {
                stringBuilder.append(append);
                stringBuilder.append(";");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            fnVar.j = stringBuilder.toString();
        }
        fnVar.k = ebVar.k();
        fnVar.m = ebVar.l() ? 1 : 0;
        fnVar.n = ebVar.m();
        fnVar.o = ebVar.n();
        fnVar.p = ebVar.o();
        fnVar.q = ebVar.p();
        fnVar.s = ebVar.r();
        fnVar.r = ebVar.q();
        fnVar.t = ebVar.s();
        fnVar.w = ebVar.t();
        fnVar.z = ebVar.u();
        fx.b("AccessSchedulerStatistics", "AccessSchedulerFinished：" + fnVar.toString());
        el.a().a(new a(this, fnVar));
    }
}
