package com.tencent.mm.plugin.ipcall.a;

import android.content.Context;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bv;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.ipcall.a.c.a;
import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.plugin.ipcall.a.g.j;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.HashMap;
import java.util.Map;

public final class i implements ar {
    private static i koM = null;
    private static HashMap<Integer, d> kpf;
    private g koN = new g();
    private a koO = new a();
    private b koP = new b();
    private com.tencent.mm.plugin.ipcall.a.b.b koQ = new com.tencent.mm.plugin.ipcall.a.b.b();
    private f koR = new f();
    private c koS = new c();
    private com.tencent.mm.plugin.ipcall.a.g.d koT;
    private l koU;
    private j koV;
    private h koW;
    private com.tencent.mm.plugin.voip.video.i koX;
    private com.tencent.mm.plugin.voip.video.d koY;
    private Context koZ;
    private long kpa;
    private com.tencent.mm.sdk.b.c kpb = new 1(this);
    private com.tencent.mm.sdk.b.c kpc = new 4(this);
    private com.tencent.mm.sdk.b.c kpd = new 5(this);
    private com.tencent.mm.sdk.b.c kpe = new 6(this);
    private bv.a kpg = new 11(this);
    private bv.a kph = new bv.a() {
        public final void a(com.tencent.mm.ab.d.a aVar) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOutMsg onRecieveMsg");
            by byVar = aVar.dIN;
            String a = ab.a(aVar.dIN.rcl);
            if (a == null || a.length() == 0) {
                x.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, msgContent is null");
                return;
            }
            Map z = bl.z(a, "sysmsg");
            if (z == null) {
                x.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, values is null");
                return;
            }
            int i;
            h aXy = i.aXy();
            long j = (long) byVar.rci;
            if (z != null) {
                g gVar = new g();
                gVar.field_svrId = j;
                gVar.field_title = (String) z.get(".sysmsg.WeChatOutMsg.Title");
                if (gVar.field_title == null) {
                    gVar.field_title = "";
                }
                gVar.field_content = (String) z.get(".sysmsg.WeChatOutMsg.Content");
                if (gVar.field_content == null) {
                    gVar.field_content = "";
                }
                int i2 = bi.getInt((String) z.get(".sysmsg.WeChatOutMsg.MsgType"), 0);
                gVar.field_msgType = i2;
                gVar.field_pushTime = bi.getLong((String) z.get(".sysmsg.WeChatOutMsg.PushTime"), 0);
                gVar.field_descUrl = (String) z.get(".sysmsg.WeChatOutMsg.DescUrl");
                if (gVar.field_descUrl == null) {
                    gVar.field_descUrl = "";
                }
                x.i("MicroMsg.IPCallMsgStorage", "insertNewXml svrId:%s,title:%s,content:%s,msgType:%s,pushTime:%s,descUrl=%s", new Object[]{gVar.field_svrId, gVar.field_title, gVar.field_content, gVar.field_msgType, gVar.field_pushTime, gVar.field_descUrl});
                aXy.b(gVar);
                i = i2;
            } else {
                i = -1;
            }
            if (i != -1) {
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.sRl, Integer.valueOf(i));
            }
            au.HU();
            com.tencent.mm.model.c.DT().a(aa.a.sRk, Boolean.valueOf(true));
            com.tencent.mm.plugin.report.service.h.mEJ.h(13254, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(i), Integer.valueOf(-1)});
        }
    };
    private bv.a kpi = new 3(this);

    static {
        HashMap hashMap = new HashMap();
        kpf = hashMap;
        hashMap.put(Integer.valueOf("IPCallAddressItem".hashCode()), new 7());
        kpf.put(Integer.valueOf("IPCallRecord".hashCode()), new 8());
        kpf.put(Integer.valueOf("IPCallPopularCountry".hashCode()), new d() {
            public final String[] xb() {
                return j.diD;
            }
        });
        kpf.put(Integer.valueOf("IPCallMsg".hashCode()), new 10());
    }

    public static i aXo() {
        if (koM == null) {
            koM = new i();
            au.HN().a("plugin.ipcall", koM);
        }
        return koM;
    }

    public static g aXp() {
        return aXo().koN;
    }

    public static a aXq() {
        return aXo().koO;
    }

    public static b aXr() {
        return aXo().koP;
    }

    public static com.tencent.mm.plugin.ipcall.a.b.b aXs() {
        return aXo().koQ;
    }

    public static f aXt() {
        return aXo().koR;
    }

    public static c aXu() {
        return aXo().koS;
    }

    public static com.tencent.mm.plugin.ipcall.a.g.d aXv() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aXo().koT == null) {
            i aXo = aXo();
            au.HU();
            aXo.koT = new com.tencent.mm.plugin.ipcall.a.g.d(com.tencent.mm.model.c.FO());
        }
        return aXo().koT;
    }

    public static l aXw() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aXo().koU == null) {
            i aXo = aXo();
            au.HU();
            aXo.koU = new l(com.tencent.mm.model.c.FO());
        }
        return aXo().koU;
    }

    public static j aXx() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aXo().koV == null) {
            i aXo = aXo();
            au.HU();
            aXo.koV = new j(com.tencent.mm.model.c.FO());
        }
        return aXo().koV;
    }

    public static h aXy() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aXo().koW == null) {
            i aXo = aXo();
            au.HU();
            aXo.koW = new h(com.tencent.mm.model.c.FO());
        }
        return aXo().koW;
    }

    public static com.tencent.mm.plugin.voip.video.i aXz() {
        if (aXo().koX == null) {
            aXo().koX = new com.tencent.mm.plugin.voip.video.i(ad.getContext());
        }
        return aXo().koX;
    }

    public static com.tencent.mm.plugin.voip.video.d aXA() {
        if (aXo().koY == null) {
            aXo().koY = new com.tencent.mm.plugin.voip.video.d(ad.getContext());
        }
        return aXo().koY;
    }

    public final HashMap<Integer, d> Ci() {
        return kpf;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        g gVar = this.koN;
        gVar.koy.init();
        gVar.koz.init();
        gVar.koA.init();
        gVar.koB.init();
        gVar.koC.init();
        gVar.koD.init();
        gVar.koE.init();
        gVar.koF.init();
        gVar.koy.kpk = gVar;
        gVar.koA.kpk = gVar;
        gVar.koB.kpk = gVar;
        gVar.koD.kpk = gVar;
        gVar.koF.kpk = gVar;
        gVar.koz.kpm = gVar;
        gVar.koC.kpm = gVar;
        au.a(gVar.koJ);
        b.init();
        com.tencent.mm.sdk.b.a.sFg.b(d.aXf().kom);
        com.tencent.mm.sdk.b.a.sFg.b(e.aXi().eOh);
        au.getSysCmdMsgExtension().a("WeChatOut", this.kpg, true);
        au.getSysCmdMsgExtension().a("WeChatOutMsg", this.kph, true);
        au.getSysCmdMsgExtension().a("WCONotify", this.kpi, true);
        com.tencent.mm.sdk.b.a.sFg.b(this.kpb);
        com.tencent.mm.sdk.b.a.sFg.b(this.kpc);
        com.tencent.mm.sdk.b.a.sFg.b(this.kpd);
        com.tencent.mm.sdk.b.a.sFg.b(this.kpe);
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        if (this.koR.aXj()) {
            this.koS.cK(0, 0);
        }
        g gVar = this.koN;
        gVar.koy.destroy();
        gVar.koz.destroy();
        gVar.koA.destroy();
        gVar.koB.destroy();
        gVar.koC.destroy();
        gVar.koE.destroy();
        au.b(gVar.koJ);
        b.release();
        d aXf = d.aXf();
        au.DF().b(159, aXf);
        au.DF().b(160, aXf);
        com.tencent.mm.sdk.b.a.sFg.c(aXf.kom);
        com.tencent.mm.sdk.b.a.sFg.c(e.aXi().eOh);
        au.getSysCmdMsgExtension().b("WeChatOut", this.kpg, true);
        au.getSysCmdMsgExtension().b("WeChatOutMsg", this.kph, true);
        au.getSysCmdMsgExtension().b("WCONotify", this.kpi, true);
        com.tencent.mm.sdk.b.a.sFg.c(this.kpb);
        com.tencent.mm.sdk.b.a.sFg.c(this.kpc);
        com.tencent.mm.sdk.b.a.sFg.c(this.kpd);
        com.tencent.mm.sdk.b.a.sFg.c(this.kpe);
    }
}
