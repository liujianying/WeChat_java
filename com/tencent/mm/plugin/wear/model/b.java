package com.tencent.mm.plugin.wear.model;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.z;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.protocal.c.cec;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

public final class b implements e {
    com.tencent.mm.sdk.e.m.b jtB = new 3(this);
    boolean pIW;
    c pIX = new 1(this);
    al pIY = new al(Looper.getMainLooper(), new 4(this), true);

    public b() {
        a.sFg.b(this.pIX);
        au.HU();
        com.tencent.mm.model.c.FR().a(this.jtB);
    }

    public final void connect() {
        cec cec = a.bSl().pIM.pJd.pJT;
        if (cec == null) {
            x.e("MicroMsg.Wear.WearBizLogic", "get connect wear data error");
        } else if (!bSm()) {
            au.HU();
            x.i("MicroMsg.Wear.WearBizLogic", "auto focus biz contact %b", new Object[]{Boolean.valueOf(((Boolean) com.tencent.mm.model.c.DT().get(327825, Boolean.valueOf(false))).booleanValue())});
            if (!((Boolean) com.tencent.mm.model.c.DT().get(327825, Boolean.valueOf(false))).booleanValue()) {
                if (bi.fU(ad.getContext())) {
                    x.i("MicroMsg.Wear.WearBizLogic", "oversea user, forbid biz auto focus logic");
                    return;
                }
                a.bSl().pIS.a(new a(this, (byte) 0));
                a.bSl().pIS.a(new b(this, cec));
            }
        } else if (!PJ(cec.szd)) {
            x.i("MicroMsg.Wear.WearBizLogic", "start to register device %s", new Object[]{cec.szd});
            a.bSl().pIS.a(new b(this, cec));
        } else if (this.pIW) {
            if (this.pIY.ciq()) {
                x.i("MicroMsg.Wear.WearBizLogic", "start step count timer");
                this.pIY.J(3600000, 3600000);
            } else {
                x.i("MicroMsg.Wear.WearBizLogic", "stop timer and restart step count timer");
                this.pIY.SO();
                this.pIY.J(3600000, 3600000);
            }
            a(cec);
        } else {
            x.i("MicroMsg.Wear.WearBizLogic", "start to auth device %s", new Object[]{cec.szd});
            String str = cec.szd;
            String str2 = "gh_43f2581f6fd6";
            if (!this.pIW && PJ(str)) {
                x.i("MicroMsg.Wear.WearBizLogic", "auth device, deviceId=%s | deviceType=%s", new Object[]{str, str2});
                tq tqVar = new tq();
                tqVar.cfq.bIH = 7;
                tqVar.cfq.byN = str;
                tqVar.cfq.bKv = str2;
                a.sFg.m(tqVar);
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        String str2;
        if (lVar instanceof com.tencent.mm.plugin.wear.model.d.a) {
            au.DF().b(1091, this);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wear.model.d.a aVar = (com.tencent.mm.plugin.wear.model.d.a) lVar;
                String str3 = aVar.byN;
                str2 = aVar.bKv;
                tq tqVar = new tq();
                tqVar.cfq.bIH = 1;
                tqVar.cfq.byN = str3;
                tqVar.cfq.bKv = str2;
                a.sFg.m(tqVar);
                return;
            }
            x.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        } else if (lVar instanceof m) {
            au.DF().b(30, this);
            if (i == 0 && i2 == 0) {
                str2 = ((m) lVar).cby();
                x.i("MicroMsg.Wear.WearBizLogic", "bind fitness contact %s success", new Object[]{str2});
                au.HU();
                ab Yg = com.tencent.mm.model.c.FR().Yg("gh_43f2581f6fd6");
                if (Yg == null || bi.oW(str2)) {
                    x.e("MicroMsg.Wear.WearBizLogic", "respUsername == " + str2 + ", contact = " + Yg);
                } else {
                    d dVar = null;
                    if (s.hd(Yg.field_username)) {
                        String oV = bi.oV(Yg.field_username);
                        dVar = f.kH(oV);
                        if (dVar != null) {
                            dVar.field_username = str2;
                        }
                        z.MY().delete(oV);
                        Yg.dD(oV);
                    }
                    Yg.setUsername(str2);
                    if (((int) Yg.dhP) == 0) {
                        au.HU();
                        com.tencent.mm.model.c.FR().U(Yg);
                    }
                    if (((int) Yg.dhP) <= 0) {
                        x.e("MicroMsg.Wear.WearBizLogic", "addContact : insert contact failed");
                    } else {
                        s.p(Yg);
                        au.HU();
                        ab Yg2 = com.tencent.mm.model.c.FR().Yg(Yg.field_username);
                        if (dVar != null) {
                            z.MY().d(dVar);
                        } else {
                            dVar = f.kH(Yg2.field_username);
                            if (dVar == null || dVar.LS()) {
                                x.d("MicroMsg.Wear.WearBizLogic", "shouldUpdate");
                                am.a.dBr.R(Yg2.field_username, "");
                                com.tencent.mm.aa.c.jN(Yg2.field_username);
                            } else if (Yg2.ckZ()) {
                                x.d("MicroMsg.Wear.WearBizLogic", "update contact, last check time=%d", new Object[]{Integer.valueOf(Yg2.csR)});
                                am.a.dBr.R(Yg2.field_username, "");
                                com.tencent.mm.aa.c.jN(Yg2.field_username);
                            }
                        }
                    }
                }
                z.MY().e(z.MY().kA(Yg.field_username));
                au.HU();
                com.tencent.mm.model.c.DT().set(327825, Boolean.valueOf(true));
                connect();
                return;
            }
            x.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 4 && i2 == -24 && !bi.oW(str)) {
                Toast.makeText(ad.getContext(), str, 1).show();
            }
        }
    }

    static boolean PJ(String str) {
        tq tqVar = new tq();
        tqVar.cfq.bIH = 3;
        tqVar.cfq.byN = str;
        tqVar.cfq.bKv = "gh_43f2581f6fd6";
        a.sFg.m(tqVar);
        x.i("MicroMsg.Wear.WearBizLogic", "isRegister: %b", new Object[]{Boolean.valueOf(tqVar.cfq.bLW)});
        return tqVar.cfq.bLW;
    }

    static boolean bSm() {
        au.HU();
        return com.tencent.mm.l.a.gd(com.tencent.mm.model.c.FR().Yg("gh_43f2581f6fd6").field_type);
    }

    public static void a(cec cec) {
        if (cec != null) {
            tq tqVar = new tq();
            tqVar.cfq.bIH = 6;
            tqVar.cfq.byN = cec.szd;
            a.sFg.m(tqVar);
            return;
        }
        x.i("MicroMsg.Wear.WearBizLogic", "request is null");
    }
}
