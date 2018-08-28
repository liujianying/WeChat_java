package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import com.tencent.mm.ui.widget.snackbar.a.a;
import com.tencent.mm.ui.widget.snackbar.a.c;

public final class b {
    private static boolean uMJ = false;

    public static void d(Activity activity, String str, String str2) {
        a aVar = new a(activity);
        aVar.kjg = str;
        aVar.uMv = str2;
        a(aVar.a(Short.valueOf((short) 2500)), null, null);
    }

    public static void a(Context context, View view, String str, String str2) {
        a aVar = new a(context, view);
        aVar.kjg = str;
        aVar.uMv = str2;
        a(aVar.a(Short.valueOf((short) 2500)), null, null);
    }

    public static void a(Activity activity, String str, String str2, com.tencent.mm.ui.widget.snackbar.a.b bVar, c cVar) {
        a aVar = new a(activity);
        aVar.kjg = str;
        aVar.uMv = str2;
        a(aVar.a(Short.valueOf((short) 2500)), bVar, cVar);
    }

    public static void a(Fragment fragment, String str, String str2, com.tencent.mm.ui.widget.snackbar.a.b bVar, c cVar) {
        a aVar = new a(fragment.getContext(), fragment.getView());
        aVar.kjg = str;
        aVar.uMv = str2;
        a(aVar.a(Short.valueOf((short) 2500)), bVar, cVar);
    }

    public static void a(Context context, View view, String str) {
        a aVar = new a(context, view);
        aVar.kjg = str;
        aVar.a(Short.valueOf((short) 1500)).cBa();
    }

    public static void h(Activity activity, String str) {
        a aVar = new a(activity);
        aVar.kjg = str;
        a(aVar.a(Short.valueOf((short) 1500)), null, null);
    }

    private static void a(a aVar, com.tencent.mm.ui.widget.snackbar.a.b bVar, c cVar) {
        if (bVar != null) {
            aVar.uMH.uMB = bVar;
        }
        if (cVar != null) {
            aVar.uMH.uMC = cVar;
        }
        aVar.cBa();
    }

    public static boolean aKp() {
        return uMJ;
    }

    public static void mH(boolean z) {
        uMJ = z;
    }
}
