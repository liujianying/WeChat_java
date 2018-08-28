package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class h {
    private static Map<Long, Long> iVF = new HashMap();
    private static Map<Long, Long> iVG = new HashMap();

    public static final void pH(int i) {
        f.mDy.a(802, (long) i, 1, false);
    }

    public static final void pI(int i) {
        f.mDy.a(802, 4, (long) i, false);
    }

    public static void dq(long j) {
        if (!iVF.containsKey(Long.valueOf(j))) {
            iVF.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static long dr(long j) {
        Long l = (Long) iVF.get(Long.valueOf(j));
        return l == null ? -1 : System.currentTimeMillis() - l.longValue();
    }

    public static void ds(long j) {
        if (!iVG.containsKey(Long.valueOf(j))) {
            iVG.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static int cA(int i, int i2) {
        if (i2 == -401) {
            return -4;
        }
        if (i == 4) {
            return -2;
        }
        return -1;
    }

    public static String a(a aVar) {
        int i = 1;
        x.v("MicroMsg.Fav.FavReportApiLogic", "reportDetailObj %s", new Object[]{aVar.toString()});
        f.mDy.k(15098, r0);
        String str = "scene[%s],index[%s],favId[%s],type[%s],infoLength[%s],source[%s],timestamp[%s],detailPeriod[%s],subDetailPeriod[%s],needOpenOtherApp[%s],subDetailCount[%s],shareFriendCount[%s],shareSnsCount[%s],editContentCount[%s],editTagCount[%s],isDelete[%s],isScrollBottom[%s],subScene[%s]";
        Object[] objArr = new Object[18];
        objArr[0] = Integer.valueOf(aVar.scene);
        objArr[1] = Integer.valueOf(aVar.index);
        objArr[2] = Long.valueOf(aVar.iVH);
        objArr[3] = Integer.valueOf(aVar.type);
        objArr[4] = aVar.iVI;
        objArr[5] = Integer.valueOf(aVar.source);
        objArr[6] = Long.valueOf(aVar.timestamp);
        objArr[7] = Long.valueOf(aVar.iVJ);
        objArr[8] = Long.valueOf(aVar.iVK);
        objArr[9] = Integer.valueOf(aVar.iVL ? 1 : 0);
        objArr[10] = Integer.valueOf(aVar.iVM);
        objArr[11] = Integer.valueOf(aVar.iVN);
        objArr[12] = Integer.valueOf(aVar.iVO);
        objArr[13] = Integer.valueOf(aVar.iVP);
        objArr[14] = Integer.valueOf(aVar.iVQ);
        objArr[15] = Integer.valueOf(aVar.iVR ? 1 : 0);
        if (!aVar.iVS) {
            i = 0;
        }
        objArr[16] = Integer.valueOf(i);
        objArr[17] = Integer.valueOf(aVar.iVT);
        return String.format(str, objArr);
    }

    public static void f(long j, int i, int i2) {
        g dy = ((ae) g.n(ae.class)).getFavItemInfoStorage().dy(j);
        if (dy != null) {
            int i3 = dy.field_favProto.rBG.bJt;
            String str = dy.field_favProto.rBG.bSS;
            int i4 = i == 1 ? s.fq(dy.field_favProto.rBG.bSS) ? 2 : 1 : 0;
            com.tencent.mm.plugin.report.service.h.mEJ.h(10651, new Object[]{Integer.valueOf(dy.field_type), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(dy.field_id), b.r(dy), Long.valueOf(dy.field_updateTime / 1000), Integer.valueOf(i3), str, Integer.valueOf(i4), ""});
        }
    }

    public static void g(long j, int i, int i2) {
        if (((ae) g.n(ae.class)).getFavItemInfoStorage().dz(j) != null) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(11122, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(((ae) g.n(ae.class)).getFavTagSetMgr().aLn()), Integer.valueOf(i2), Integer.valueOf(r1.field_type), b.r(r1), Long.valueOf(r1.field_updateTime), Integer.valueOf(r1.field_favProto.rBG.bJt), r1.field_favProto.rBG.bSS});
        }
    }
}
