package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Resources;
import com.tencent.mm.R;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.svg.a.e;
import com.tencent.mm.svg.b.c.a;

public final class o {
    private static Class<?> bzf = null;
    private static Application bzg;
    private static Resources bzh;
    private static String mPackageName = null;

    public static void h(Class<?> cls) {
        bzf = cls;
    }

    public static void cQ(String str) {
        mPackageName = str;
    }

    public static void ve() {
        boolean z = true;
        x.i("MicroMsg.SVGInit", "SVG initSVGPreload");
        e.a(new a() {
            public final void i(String str, String str2, Object... objArr) {
                x.i(str, str2, objArr);
            }

            public final void e(String str, String str2, Object... objArr) {
                x.e(str, str2, objArr);
            }

            public final void d(String str, String str2, Object... objArr) {
                x.d(str, str2, objArr);
            }

            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                x.printErrStackTrace(str, th, str2, objArr);
            }
        });
        e.h(bzf);
        e.a(bzg, bzh, mPackageName);
        try {
            boolean z2 = bzg.getBaseContext().getResources().getDrawable(R.k.actionbar_icon) != null;
            b EY = b.EY();
            if (z2) {
                z = false;
            }
            EY.dtj = z;
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.SVGInit", th, "not support get svg from application context", new Object[0]);
        } finally {
            b.EY().dtj = true;
        }
    }

    public static void a(Application application, Resources resources) {
        e.d(application, mPackageName);
        bzg = application;
        bzh = resources;
    }
}
