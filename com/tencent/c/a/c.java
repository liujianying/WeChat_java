package com.tencent.c.a;

import android.content.Context;
import com.tencent.c.b.a;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private static a vhP = null;

    public static void a(Context context, a aVar) {
        int i = 0;
        if (vhP == null) {
            vhP = new a(context);
        }
        a aVar2 = vhP;
        try {
            List hs = com.tencent.c.f.a.hs(aVar2.mContext);
            if (hs.size() == 0) {
                aVar.f(-10, null);
                return;
            }
            com.tencent.c.c.b.a aVar3 = new com.tencent.c.c.b.a();
            aVar3.viy = a.cFc();
            aVar3.viw = new com.tencent.c.c.b.c();
            aVar3.viw.viZ = 6;
            aVar3.viw.viq = 1;
            aVar3.viw.requestType = 0;
            aVar3.viw.vja = 0;
            aVar3.viw.vjb = 0;
            aVar3.viw.vjc = null;
            aVar3.viw.vjd = 0;
            aVar3.viw.vjh = 1;
            aVar3.vix = new ArrayList();
            while (true) {
                int i2 = i;
                if (i2 >= hs.size()) {
                    break;
                }
                aVar3.vix.add(a.a(aVar2.mContext, (a) hs.get(i2), i2));
                i = i2 + 1;
            }
            byte[] a = aVar2.vhS.a(aVar3);
            if (a == null) {
                aVar.f(-20, null);
            } else {
                aVar.f(0, a);
            }
        } catch (Throwable th) {
            aVar.f(-100, null);
        }
    }
}
