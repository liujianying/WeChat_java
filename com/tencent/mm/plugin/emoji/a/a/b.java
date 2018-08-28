package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.emoji.a.a.f.a;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.pluginsdk.model.h$a;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    public static void a(c cVar, h$a h_a) {
        if (q.GR() && cVar != null && cVar.size() > 0 && h_a != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = cVar.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (!(fVar == null || fVar.iey == a.ieH)) {
                    ts tsVar = fVar.iez;
                    boolean b = e.b(tsVar);
                    boolean a = e.a(tsVar);
                    if (!(b || a)) {
                        arrayList.add(tsVar.rem);
                        ao zd = cVar.zd(tsVar.rem);
                        if (zd != null) {
                            zd.taW = 11;
                        }
                    }
                }
            }
            Context context = ad.getContext();
            if (arrayList.size() > 0) {
                h.a(context, (String[]) arrayList.toArray(new String[arrayList.size()]), h_a);
            }
        }
    }

    public static void a(ArrayList<n> arrayList, c cVar) {
        if (q.GR() && cVar != null && arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                if (nVar != null) {
                    ao zd = cVar.zd(nVar.bKk);
                    if (zd != null) {
                        int i;
                        if (nVar.qzg == 10232) {
                            zd.taY = nVar.qzd;
                            zd.taW = 12;
                            i = zd.taU;
                            if (!(oH(i) || oI(i))) {
                                zd.Dl(4);
                            }
                        } else {
                            zd.taW = 10;
                            zd.taX = nVar.qzg;
                            i = zd.taU;
                            if (!(oH(i) || oI(i))) {
                                if ((i == 3 ? 1 : null) == null) {
                                    zd.Dl(10);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean oH(int i) {
        return i == 7;
    }

    private static boolean oI(int i) {
        return i == 6;
    }
}
