package com.tencent.mm.plugin.appbrand.launching;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;

public enum x {
    ;

    public static void lc(int i) {
        um(ad.getResources().getString(i));
    }

    public static void um(final String str) {
        ah.A(new Runnable() {
            public final void run() {
                Toast.makeText(ad.getContext(), str, 0).show();
            }
        });
    }

    public static String getMMString(int i, Object... objArr) {
        return c.getMMString(i, objArr);
    }
}
