package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class g {
    public static boolean a(String str, LinkedList<vx> linkedList, long j) {
        if (str.length() == 0) {
            x.e("MicroMsg.FavPostLogic", "postNote null");
            return false;
        }
        com.tencent.mm.plugin.fav.a.g a;
        if (-1 == j) {
            a = a(linkedList, j);
        } else {
            a = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(j);
        }
        b.B(a);
        return true;
    }

    public static com.tencent.mm.plugin.fav.a.g a(LinkedList<vx> linkedList, long j) {
        com.tencent.mm.plugin.fav.a.g gVar = null;
        if (j != -1) {
            gVar = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(j);
            if (gVar == null) {
                com.tencent.mm.plugin.fav.a.g gVar2 = new com.tencent.mm.plugin.fav.a.g();
                gVar2.field_type = 18;
                gVar2.field_sourceType = 6;
                String GF = q.GF();
                wr wrVar = new wr();
                wrVar.Vw(GF);
                wrVar.Vx(GF);
                wrVar.CO(gVar2.field_sourceType);
                wrVar.fU(bi.VF());
                gVar2.field_favProto.a(wrVar);
                gVar2.field_fromUser = wrVar.bSS;
                gVar2.field_toUser = wrVar.toUser;
                gVar2.field_favProto.CN(1);
                gVar2.field_favProto.CM(127);
                gVar2.field_edittime = bi.VE();
                gVar2.field_updateTime = bi.VF();
                gVar2.field_favProto.fT(gVar2.field_edittime);
                gVar2.field_favProto.rBG.fU(bi.VF());
                gVar2.field_itemStatus = 9;
                gVar2.field_localId = j;
                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().y(gVar2);
                gVar = gVar2;
            }
            gVar.field_favProto.rBI.clear();
        }
        if (gVar == null) {
            gVar = new com.tencent.mm.plugin.fav.a.g();
            gVar.field_type = 18;
            gVar.field_sourceType = 6;
            E(gVar);
            gVar.field_favProto.CN(1);
            gVar.field_favProto.CM(127);
        }
        gVar.field_edittime = bi.VE();
        gVar.field_updateTime = bi.VF();
        gVar.field_favProto.fT(gVar.field_edittime);
        gVar.field_favProto.rBG.fU(bi.VF());
        gVar.field_favProto.ar(linkedList);
        return gVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<java.lang.String> bd(java.util.List<java.lang.String> r7) {
        /*
        if (r7 == 0) goto L_0x0008;
    L_0x0002:
        r0 = r7.size();
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return r7;
    L_0x0009:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r3 = new com.tencent.mm.sdk.platformtools.MMBitmapFactory$DecodeResultLogger;
        r3.<init>();
        r4 = r7.iterator();
    L_0x0017:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x005b;
    L_0x001d:
        r0 = r4.next();
        r0 = (java.lang.String) r0;
        r2 = 0;
        r2 = com.tencent.mm.vfs.d.openRead(r0);	 Catch:{ Exception -> 0x005d, all -> 0x0056 }
        if (r2 != 0) goto L_0x002e;
    L_0x002a:
        com.tencent.mm.sdk.platformtools.bi.d(r2);
        goto L_0x0017;
    L_0x002e:
        r5 = com.tencent.mm.sdk.platformtools.MMBitmapFactory.checkIsImageLegal(r2, r3);	 Catch:{ Exception -> 0x0050, all -> 0x0056 }
        if (r5 == 0) goto L_0x003b;
    L_0x0034:
        r1.add(r0);	 Catch:{ Exception -> 0x0050, all -> 0x0056 }
    L_0x0037:
        com.tencent.mm.sdk.platformtools.bi.d(r2);
        goto L_0x0017;
    L_0x003b:
        r0 = r3.getDecodeResult();	 Catch:{ Exception -> 0x0050, all -> 0x0056 }
        r5 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        if (r0 < r5) goto L_0x0037;
    L_0x0043:
        r0 = 5;
        r0 = com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper.getKVStatString(r2, r0, r3);	 Catch:{ Exception -> 0x0050, all -> 0x0056 }
        r5 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x0050, all -> 0x0056 }
        r6 = 12712; // 0x31a8 float:1.7813E-41 double:6.2806E-320;
        r5.k(r6, r0);	 Catch:{ Exception -> 0x0050, all -> 0x0056 }
        goto L_0x0037;
    L_0x0050:
        r0 = move-exception;
        r0 = r2;
    L_0x0052:
        com.tencent.mm.sdk.platformtools.bi.d(r0);
        goto L_0x0017;
    L_0x0056:
        r0 = move-exception;
        com.tencent.mm.sdk.platformtools.bi.d(r2);
        throw r0;
    L_0x005b:
        r7 = r1;
        goto L_0x0008;
    L_0x005d:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.ui.g.bd(java.util.List):java.util.List<java.lang.String>");
    }

    public static boolean be(List<String> list) {
        List<String> bd = bd(list);
        if (bd == null || bd.size() == 0) {
            x.e("MicroMsg.FavPostLogic", "postImgs path null");
            return false;
        }
        com.tencent.mm.plugin.fav.a.g gVar = new com.tencent.mm.plugin.fav.a.g();
        gVar.field_type = 2;
        gVar.field_sourceType = 6;
        E(gVar);
        for (String str : bd) {
            vx vxVar = new vx();
            vxVar.UP(str);
            vxVar.UO(b.bm(vxVar.toString(), 2));
            c.c(str, 150, 150, CompressFormat.JPEG, 90, b.c(vxVar));
            vxVar.UQ(b.c(vxVar));
            vxVar.CF(2);
            gVar.field_favProto.rBI.add(vxVar);
        }
        b.B(gVar);
        h.mEJ.h(10648, new Object[]{Integer.valueOf(2), Integer.valueOf(bd.size())});
        return true;
    }

    static void E(com.tencent.mm.plugin.fav.a.g gVar) {
        String GF = q.GF();
        wr wrVar = new wr();
        wrVar.Vw(GF);
        wrVar.Vx(GF);
        wrVar.CO(gVar.field_sourceType);
        wrVar.fU(bi.VF());
        gVar.field_favProto.a(wrVar);
        gVar.field_fromUser = wrVar.bSS;
        gVar.field_toUser = wrVar.toUser;
    }
}
