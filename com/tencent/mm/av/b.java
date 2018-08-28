package com.tencent.mm.av;

import android.util.Base64;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.map.swlocation.api.LocationUpdateListener;
import com.tencent.map.swlocation.api.ServerMessageListener;
import com.tencent.mm.a.o;
import com.tencent.mm.ar.k;
import com.tencent.mm.c.f;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b {
    private static final byte[] edN = "@wechat*weixin!!".getBytes();
    private static b edO;
    private boolean edP = false;
    private ah edQ;
    int edR = 5000;
    int edS = 5000;
    int edT = 30000;
    private int edU = 3600;
    private c edV;
    private List<d> edW = new ArrayList();
    private List<d> edX = new ArrayList();
    private c edY = new 3(this);
    private al edZ;
    private LocationUpdateListener eea;
    private int eeb;
    private ServerMessageListener eec;
    private long startTime = 0;

    static /* synthetic */ boolean a(b bVar, int i, float f, float f2) {
        List<d> list = i == 1 ? bVar.edW : bVar.edX;
        if (list == null || list.size() <= 0) {
            x.i("MicroMsg.SenseWhereHelper", "it has not report location, do not start sense where.");
            return false;
        }
        boolean z;
        long VG = bi.VG();
        for (d dVar : list) {
            x.d("MicroMsg.SenseWhereHelper", "loc[%f, %f], config[%f, %f], dis[%f, %f]", new Object[]{Float.valueOf(f2), Float.valueOf(f), Double.valueOf(dVar.latitude), Double.valueOf(dVar.longitude), Double.valueOf(TencentLocationUtils.distanceBetween(dVar.latitude, dVar.longitude, (double) f2, (double) f)), Double.valueOf(dVar.ees)});
            if (TencentLocationUtils.distanceBetween(dVar.latitude, dVar.longitude, (double) f2, (double) f) <= dVar.ees) {
                z = true;
                break;
            }
        }
        z = false;
        x.i("MicroMsg.SenseWhereHelper", "check location[%d, %f, %f] finish %b, cost time %d", new Object[]{Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f), Boolean.valueOf(z), Long.valueOf(bi.bI(VG))});
        return z;
    }

    static /* synthetic */ void e(b bVar) {
        bVar.edW.clear();
        bVar.edX.clear();
        String str = (String) g.Ei().DT().get(a.sUb, "");
        if (bi.oW(str)) {
            x.i("MicroMsg.SenseWhereHelper", "sense where location xml is null.");
            return;
        }
        Map z = f.z(str, "SenseWhere");
        if (z == null) {
            x.w("MicroMsg.SenseWhereHelper", "parseLocation maps is null, xml[%s]", new Object[]{str});
            return;
        }
        int i = 0;
        while (true) {
            String str2 = ".SenseWhere.item" + (i == 0 ? "" : Integer.valueOf(i));
            str = (String) z.get(str2 + ".$gpstype");
            if (bi.oW(str)) {
                h.mEJ.a(345, 6, 1, false);
                x.i("MicroMsg.SenseWhereHelper", "parse location finish earth[%d] mars[%d]", new Object[]{Integer.valueOf(bVar.edX.size()), Integer.valueOf(bVar.edW.size())});
                return;
            }
            d dVar = new d();
            dVar.eer = str;
            dVar.longitude = bi.getDouble((String) z.get(str2 + ".$longitude"), 0.0d);
            dVar.latitude = bi.getDouble((String) z.get(str2 + ".$latitude"), 0.0d);
            dVar.ees = bi.getDouble((String) z.get(str2 + ".$distance"), 0.0d);
            if (dVar.ees > 5500000.0d) {
                dVar.ees = 5500000.0d;
            }
            if ("1".equals(dVar.eer)) {
                bVar.edW.add(dVar);
            } else {
                bVar.edX.add(dVar);
            }
            i++;
        }
    }

    static /* synthetic */ void l(b bVar) {
        if (bVar.edQ != null) {
            bVar.edQ.lnJ.quit();
        }
        bVar.edQ = null;
    }

    static /* synthetic */ void n(b bVar) {
        if (bVar.startTime > 0) {
            x.d("MicroMsg.SenseWhereHelper", "reportCollectionTime time %d, res %d", new Object[]{Long.valueOf((bi.VG() - bVar.startTime) / 1000), Integer.valueOf(bi.f((Integer) h.a((int) ((bi.VG() - bVar.startTime) / 1000), new int[]{5, 10, 20, 30}, 10, 14)))});
            h.mEJ.a(345, (long) r0, 1, false);
        }
    }

    static /* synthetic */ int o(b bVar) {
        int i = bVar.eeb + 1;
        bVar.eeb = i;
        return i;
    }

    public static b Qv() {
        if (edO == null) {
            edO = new b();
        }
        return edO;
    }

    public b() {
        g.Ek();
        this.edZ = new al(g.Em().lnJ.getLooper(), new 4(this), false);
        this.eea = new 5(this);
        this.eeb = 0;
        this.eec = new 6(this);
    }

    private static String Qw() {
        String zy = q.zy();
        g.Eg();
        try {
            x.i("MicroMsg.SenseWhereHelper", "create encrypt imei[%s], original imei[%s]", new Object[]{new String(Base64.encode(new ag().encrypt((zy + "_" + new o(com.tencent.mm.kernel.a.Df()).toString()).getBytes("UTF-8"), edN), 0), "UTF-8"), bi.Xf(r1)});
            return new String(Base64.encode(new ag().encrypt((zy + "_" + new o(com.tencent.mm.kernel.a.Df()).toString()).getBytes("UTF-8"), edN), 0), "UTF-8");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SenseWhereHelper", e, "", new Object[0]);
            x.e("MicroMsg.SenseWhereHelper", "create imei error: " + e.toString());
            return "";
        }
    }

    public final void Qx() {
        g.Ek();
        g.Em().H(new 2(this));
    }

    private boolean Qy() {
        g.Eg();
        if (new o(com.tencent.mm.kernel.a.Df()).longValue() < 1000000) {
            x.i("MicroMsg.SenseWhereHelper", "it boss uin do not start sense where.");
            return false;
        }
        String value = com.tencent.mm.k.g.AT().getValue("AndroidSenseWhereArgs");
        if (bi.oW(value)) {
            x.i("MicroMsg.SenseWhereHelper", "it has no config do not start sense where.");
            return false;
        }
        try {
            x.d("MicroMsg.SenseWhereHelper", "sense where config : " + value);
            String[] split = value.split(";");
            int i = bi.getInt(split[0], 0);
            g.Eg();
            if (com.tencent.mm.a.h.aM(com.tencent.mm.kernel.a.Df() + 5, 100) > i) {
                x.d("MicroMsg.SenseWhereHelper", "do not start sense where.uinhash %d, percent %d", new Object[]{Integer.valueOf(com.tencent.mm.a.h.aM(com.tencent.mm.kernel.a.Df() + 5, 100)), Integer.valueOf(i)});
                return false;
            }
            this.edS = bi.getInt(split[1], 5000);
            this.edR = bi.getInt(split[2], 5000);
            this.edT = bi.getInt(split[3], 30000);
            this.edU = bi.getInt(split[4], 3600);
            x.i("MicroMsg.SenseWhereHelper", "check sense where report args[%d, %d, %d, %d]", new Object[]{Integer.valueOf(this.edS), Integer.valueOf(this.edR), Integer.valueOf(this.edT), Integer.valueOf(this.edU)});
            if (bi.bG(((Long) g.Ei().DT().get(a.sUd, Long.valueOf(0))).longValue()) > ((long) this.edU)) {
                return true;
            }
            x.i("MicroMsg.SenseWhereHelper", "it is not time out. diff[%d], collection interval[%d]", new Object[]{Long.valueOf(bi.bG(((Long) g.Ei().DT().get(a.sUd, Long.valueOf(0))).longValue())), Integer.valueOf(this.edU)});
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SenseWhereHelper", e, "", new Object[0]);
            x.e("MicroMsg.SenseWhereHelper", "check sense where config error: " + e.toString());
            x.i("MicroMsg.SenseWhereHelper", "it default do not start sense where.");
            return false;
        }
    }

    public static void Qz() {
        if (bi.bG(bi.a((Long) g.Ei().DT().get(a.sUc, null), 0)) * 1000 > 21600000) {
            x.i("MicroMsg.SenseWhereHelper", "update sense where location package list.");
            g.Eh().dpP.a(new k(36), 0);
            g.Ei().DT().a(a.sUc, Long.valueOf(bi.VE()));
        }
    }
}
