package com.tencent.f;

import android.content.Context;
import com.tencent.f.b.b;
import com.tencent.f.b.d;
import com.tencent.pb.common.c.c;

public final class i {
    private static i vwM;
    private boolean mg;
    private Context rc;

    private static i cHs() {
        if (vwM == null) {
            synchronized (i.class) {
                if (vwM == null) {
                    vwM = new i();
                }
            }
        }
        return vwM;
    }

    public static void if(Context context) {
        i cHs = cHs();
        if (!cHs.mg) {
            cHs.rc = context;
            try {
                b a = f.a(new d("EventCenter", com.tencent.f.a.b.class.getName()));
                if (a != null) {
                    a.start();
                }
            } catch (Throwable th) {
                c.x("service", new Object[]{th});
            }
        }
    }
}
