package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.sz$b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class v extends c<sz> implements e {
    private boolean cdT;
    private boolean cdU;
    private boolean jgq;
    private sz pqW;

    public v() {
        this.jgq = false;
        this.cdT = false;
        this.cdU = false;
        this.sFo = sz.class.getName().hashCode();
    }

    private boolean a(sz szVar) {
        if (szVar instanceof sz) {
            this.jgq = false;
            this.pqW = szVar;
            this.cdT = szVar.cdR.cdT;
            this.cdU = szVar.cdR.cdU;
            x.i("MicroMsg.WalletGetUserInfoEventListener", "mustNotifyAfterNetEnd: %s", new Object[]{Boolean.valueOf(this.cdU)});
            g.Ek();
            g.Eh().dpP.a(385, this);
            g.Ek();
            g.Eh().dpP.a(1518, this);
            ag bOW;
            if (o.bOW().bPr()) {
                x.i("MicroMsg.WalletGetUserInfoEventListener", "data is invalid. doScene");
                if (q.GS()) {
                    g.Ek();
                    g.Eh().dpP.a(new a(), 0);
                } else {
                    g.Ek();
                    g.Eh().dpP.a(new y(null, zl(szVar.cdR.scene) ? szVar.cdR.scene : 0), 0);
                }
            } else if (szVar.cdR.cdT) {
                x.i("MicroMsg.WalletGetUserInfoEventListener", "use cache");
                bOW = o.bOW();
                x.i("MicroMsg.WalletUserInfoManger", "checkCacheTimeout, nowSecs: %s, cacheDeadTime: %s", new Object[]{Long.valueOf(bi.VE()), Long.valueOf(bOW.prI)});
                Object obj = (bOW.prI <= 0 || bi.VE() > bOW.prI) ? 1 : null;
                if (obj == null) {
                    if (!this.cdU) {
                        this.jgq = true;
                    }
                    x.i("MicroMsg.WalletGetUserInfoEventListener", "cache data is ok. doCallback");
                    a(0, "", null, false);
                    if (q.GS()) {
                        g.Ek();
                        g.Eh().dpP.a(new a(), 0);
                    } else {
                        g.Ek();
                        g.Eh().dpP.a(new y(null, zl(szVar.cdR.scene) ? szVar.cdR.scene : 0), 0);
                    }
                } else {
                    x.i("MicroMsg.WalletGetUserInfoEventListener", "cache timeout, do NetSceneTenpayQueryBoundBankcard");
                    if (q.GS()) {
                        g.Ek();
                        g.Eh().dpP.a(new a(), 0);
                    } else {
                        g.Ek();
                        g.Eh().dpP.a(new y(null, zl(szVar.cdR.scene) ? szVar.cdR.scene : 0), 0);
                    }
                }
            } else {
                long bG = bi.bG(o.bOW().prH);
                x.i("MicroMsg.WalletUserInfoManger", "dead time : %d, nowSec: %d, pass time " + bG, new Object[]{Long.valueOf(bOW.prH), Long.valueOf(System.currentTimeMillis() / 1000)});
                if ((bG > 0 ? 1 : null) != null) {
                    x.i("MicroMsg.WalletGetUserInfoEventListener", "data is checkTimeOut, do NetSceneTenpayQueryBoundBankcard");
                    if (q.GS()) {
                        g.Ek();
                        g.Eh().dpP.a(new a(), 0);
                    } else {
                        g.Ek();
                        g.Eh().dpP.a(new y(null, zl(szVar.cdR.scene) ? szVar.cdR.scene : 0), 0);
                    }
                } else {
                    this.jgq = true;
                    x.i("MicroMsg.WalletGetUserInfoEventListener", "data is ok. doCallback");
                    a(0, "", null, false);
                }
            }
            return true;
        }
        x.f("MicroMsg.WalletGetUserInfoEventListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), lVar});
        if ((lVar instanceof y) || (lVar instanceof a)) {
            g.Ek();
            g.Eh().dpP.b(385, this);
            g.Ek();
            g.Eh().dpP.b(1518, this);
            if (!this.cdU && this.cdT && this.jgq) {
                x.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, useCache and event end");
                return;
            }
            this.jgq = true;
            a(i2, str, lVar, true);
        }
    }

    private void a(int i, String str, l lVar, boolean z) {
        boolean z2 = false;
        if (this.pqW != null) {
            int i2;
            String str2;
            this.pqW.cdS.errCode = i;
            this.pqW.cdS.Yy = str;
            this.pqW.cdS.cdV = o.bOW().bPs();
            sz$b sz_b = this.pqW.cdS;
            ag bOW = o.bOW();
            boolean z3 = (bOW.prC != null && bOW.prC.bPj()) || (bOW.pda != null && bOW.pda.size() > 0);
            z3 = z3 ? false : bOW.pcZ == null || bOW.pcZ.size() <= 0;
            sz_b.cdW = z3;
            sz_b = this.pqW.cdS;
            ag bOW2 = o.bOW();
            ArrayList arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            bOW2.f(arrayList, arrayList2);
            if (ag.cD(arrayList2)) {
                z3 = true;
            } else {
                z3 = false;
            }
            sz_b.cdX = z3;
            this.pqW.cdS.cdY = o.bOW().bPw().bPj();
            this.pqW.cdS.cdZ = o.bOW().bPv();
            this.pqW.cdS.cea = o.bOW().aCl();
            this.pqW.cdS.ceb = o.bOW().bPt();
            this.pqW.cdS.cec = o.bOW().bPw().bPm();
            this.pqW.cdS.ced = "";
            sz_b = this.pqW.cdS;
            bOW2 = o.bOW();
            if (bOW2.prA == null) {
                z3 = false;
            } else if (bOW2.prA.field_paymenu_use_new == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            sz_b.cer = z3;
            if (lVar != null && (lVar instanceof y)) {
                this.pqW.cdS.ced = ((y) lVar).ced;
                this.pqW.cdS.cee = ((y) lVar).cee;
                this.pqW.cdS.cef = ((y) lVar).cef;
                this.pqW.cdS.ceg = ((y) lVar).ceg;
                this.pqW.cdS.ceh = ((y) lVar).ceh;
                this.pqW.cdS.scene = ((y) lVar).scene;
                this.pqW.cdS.cei = ((y) lVar).cei;
                this.pqW.cdS.cej = ((y) lVar).cej;
                this.pqW.cdS.cek = ((y) lVar).cek;
                this.pqW.cdS.cel = ((y) lVar).cel;
                this.pqW.cdS.cem = ((y) lVar).cem;
                this.pqW.cdS.cen = ((y) lVar).cen;
                this.pqW.cdS.ceo = ((y) lVar).ceo;
                this.pqW.cdS.title = ((y) lVar).title;
                this.pqW.cdS.cep = ((y) lVar).cep;
                this.pqW.cdS.ceq = ((y) lVar).ceq;
            }
            this.pqW.cdS.ces = o.bOW().bPC() ? 1 : 0;
            sz_b = this.pqW.cdS;
            bOW2 = o.bOW();
            if (bOW2.prA != null) {
                i2 = bOW2.prA.field_is_show_lqb;
            } else {
                i2 = 0;
            }
            sz_b.cet = i2;
            sz$b sz_b2 = this.pqW.cdS;
            ag bOW3 = o.bOW();
            if (bOW3.prA != null && bOW3.prA.field_is_open_lqb == 1) {
                z2 = true;
            }
            sz_b2.ceu = z2;
            sz$b sz_b3 = this.pqW.cdS;
            bOW2 = o.bOW();
            if (bOW2.prA != null) {
                str2 = bOW2.prA.field_lqb_open_url;
            } else {
                str2 = null;
            }
            sz_b3.cev = str2;
            this.pqW.cdS.cew = z;
            x.d("MicroMsg.WalletGetUserInfoEventListener", "mUserInfo needBind : " + this.pqW.cdS.cdW + " hasNewTips : " + this.pqW.cdS.cdX + " swipeOn : " + this.pqW.cdS.cdY);
            if (this.pqW.bJX != null) {
                this.pqW.bJX.run();
            }
            if (this.pqW.cdS.cdN != null) {
                this.pqW.cdS.cdN.run();
            }
        }
        if (this.jgq) {
            this.pqW = null;
        }
    }

    private static boolean zl(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 6 || i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23) {
            return true;
        }
        return false;
    }
}
