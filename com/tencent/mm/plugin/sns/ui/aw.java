package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.WindowManager;
import com.tencent.mm.kiss.widget.textview.c;
import com.tencent.mm.kiss.widget.textview.f;
import com.tencent.mm.l.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.am$a;
import com.tencent.mm.plugin.sns.model.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.plugin.sns.ui.widget.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.bj;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.bou;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.protocal.c.vu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ay;
import com.tencent.mm.vending.a.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aw extends b<ay, n> {
    private boolean DEBUG = false;
    ay dDg;
    volatile String iKw = "";
    Context mContext;
    volatile String nQU = "";
    String ocI;
    av odV;
    private int odW = ((int) (System.currentTimeMillis() / 1000));
    private a odX;
    private boolean odY = false;
    volatile boolean odZ = false;
    byte[] oea = new byte[0];
    protected HashMap<String, String> oeb = new HashMap();
    public HashMap<String, Boolean> oec = new HashMap();
    private String oed = "";
    private String oee = "";

    protected final /* synthetic */ void applyChangeSynchronized(Object obj) {
        Cursor cursor = (Cursor) obj;
        aYc();
        this.yV = cursor;
    }

    public aw() {
        super(new n());
        cBs();
    }

    public final void bDI() {
        long j;
        looperCheckForVending();
        if (this.mCount == 0) {
            j = 0;
        } else {
            int i = this.mCount - 1;
            int i2 = 0;
            while (true) {
                n nVar = (n) getItem(i);
                if (nVar != null && !nVar.xb(32) && nVar.field_snsId != 0) {
                    x.i("MicroMsg.SnsTimeLineVendingSide", "get list last not ad item %s %s", new Object[]{Long.valueOf(nVar.field_snsId), nVar.field_stringSeq});
                    j = r4;
                    break;
                }
                i2++;
                int i3 = i - 1;
                if (i3 < 0 || i2 > 500) {
                    j = 0;
                } else {
                    i = i3;
                }
            }
            j = 0;
        }
        this.odZ = true;
        synchronized (this.oea) {
            this.iKw = r(j, this.iKw);
        }
    }

    final String r(long j, String str) {
        x.d("MicroMsg.SnsTimeLineVendingSide", "updateLitmitSeq %s %s", new Object[]{Integer.valueOf(af.bye().byM()), str});
        String eG = i.eG(af.byo().e(j, str.equals("") ? af.bye().byM() / 2 : af.bye().byM(), false));
        String str2 = this.nQU;
        if (!str2.equals("") && eG.compareTo(str2) >= 0) {
            eG = str2;
        }
        vu bAV = af.bys().Np("@__weixintimtline").bAV();
        if (bAV.rzb == 0) {
            return eG;
        }
        str2 = i.eG(bAV.rzb);
        if (eG.equals("")) {
            return str2;
        }
        if (str2.compareTo(eG) > 0) {
            return str2;
        }
        return eG;
    }

    private ay xB(int i) {
        if (i < 0) {
            return null;
        }
        x.i("MicroMsg.SnsTimeLineVendingSide", "resolveAsynchronous %s", new Object[]{Integer.valueOf(i)});
        long currentTimeMillis = System.currentTimeMillis();
        ay ayVar = new ay();
        n nVar = (n) super.getItem(i);
        if (nVar == null) {
            x.printErrStackTrace("MicroMsg.SnsTimeLineVendingSide", new Throwable(), "mSnsInfo is null, index %s, count %s, why?", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mCount)});
            return ayVar;
        }
        int width;
        f Fa;
        String str;
        ab Yf;
        boolean z;
        String f;
        atf bAW;
        long currentTimeMillis2;
        bsu bAJ = nVar.bAJ();
        boy n = aj.n(nVar);
        int d = av.d(bAJ);
        ayVar.Xe = d;
        ayVar.oew = nVar.field_snsId;
        ayVar.oeA = nVar.field_likeFlag;
        ayVar.oeB = nVar.bBa();
        ayVar.oeC = nVar.bBn();
        ayVar.nhc = nVar;
        ayVar.nhg = bAJ;
        ayVar.nhb = n;
        String str2 = ayVar.nhg.spZ;
        Context context = this.mContext;
        d.bEY();
        k a = e.a(context, str2, d.getTextSize());
        ayVar.oet = a;
        int viewWidth = d.bEY().getViewWidth();
        if (i < this.odV.getCount()) {
            n nVar2 = (n) super.getItem(i);
            if (nVar2 != null && nVar2.xb(32)) {
                com.tencent.mm.plugin.sns.storage.b bAF = nVar2.bAF();
                if (bAF != null && bAF.nze == 1) {
                    String BL;
                    Iterator it;
                    ab Yf2;
                    width = (((((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bp.a.fromDPToPix(this.mContext, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mContext, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mContext, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mContext, 12);
                    if (this.DEBUG) {
                        x.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsPostDesc position " + i + " viewWidth: " + width + " desc:" + str2);
                    }
                    Fa = com.tencent.mm.kiss.widget.textview.d.a(a, width, d.bEY().getTextViewConfig()).Fa();
                    c.dtC.a(d.bEY().getTextViewConfig(), Fa);
                    if (Fa.duh.getLineCount() > 6) {
                        c.dtC.a(d.bEY().bEZ(), com.tencent.mm.kiss.widget.textview.d.a(a, width, d.bEY().bEZ()).Fa());
                    }
                    a(i, ayVar);
                    if (ayVar.nhc.xb(32)) {
                        af.byl().a(nVar, null);
                    } else {
                        af.byl().b(nVar, null);
                    }
                    f(ayVar.nhg);
                    str = nVar.field_userName;
                    Yf = this.dDg.Yf(str);
                    if (str != null) {
                        a aVar;
                        if (!str.equals(this.ocI)) {
                            aVar = Yf;
                        } else if (this.odX == null) {
                            this.odX = Yf;
                            aVar = Yf;
                        } else {
                            aVar = this.odX;
                        }
                        BL = aVar == null ? str : aVar.BL();
                        if (nVar.xb(32) && bi.oW(BL)) {
                            com.tencent.mm.plugin.sns.storage.b bAF2 = nVar.bAF();
                            if (!(bAF2 == null || bi.oW(bAF2.nickname))) {
                                BL = bAF2.nickname;
                            }
                        }
                        ayVar.gtX = str;
                        ayVar.oeK = BL;
                        ayVar.nLv = nVar.xb(32);
                        ayVar.nMU = nVar.bBe();
                        z = aVar == null ? true : ((int) aVar.dhP) == 0;
                        ayVar.oeL = z;
                        ayVar.oeu = aVar;
                    }
                    ayVar.oev = nVar.bAK();
                    ayVar.oex = bAJ.spZ;
                    ayVar.oey = bAJ.sqe;
                    ayVar.oez = nVar.field_createTime;
                    ayVar.oeD = az.g(this.mContext, ((long) ayVar.oez) * 1000);
                    ayVar.oeN = false;
                    if (!(d != 11 || q.GF().equals(bAJ.hbL) || n.smZ == null || n.smZ.snB == 0)) {
                        ayVar.oeO = n.smZ.snB;
                        ayVar.oeN = true;
                    }
                    if (ayVar.nLv) {
                        BL = bAJ.sqa == null ? null : bAJ.sqa.eJJ;
                        str = bAJ.sqa == null ? null : bAJ.sqa.kFa;
                        if (bi.oW(str)) {
                            ayVar.oeQ = BL;
                            ayVar.oeR = false;
                        } else {
                            if (nVar.field_snsId != 0 || bi.oW(BL)) {
                                ayVar.oeQ = str;
                            } else {
                                ayVar.oeQ = BL + "·" + str;
                            }
                            ayVar.oeR = true;
                        }
                    } else {
                        com.tencent.mm.plugin.sns.storage.a bAH = nVar.bAH();
                        if (bAH != null) {
                            ayVar.oeQ = bAH.nyc;
                            if (bi.oW(bAH.nyd)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            ayVar.oeR = z;
                        }
                    }
                    f = f(bAJ);
                    if (!com.tencent.mm.plugin.sns.c.a.ezo.cT(f) && g(bAJ)) {
                        ayVar.oeS = true;
                        if (bAJ.sqb == null) {
                            z = false;
                        } else if (!this.oec.containsKey(bAJ.sqb.ksA)) {
                            boolean z2;
                            if (!g.cU(bAJ.sqb.ksA)) {
                                z = g.SS(bAJ.sqb.ksA);
                                if (z) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                            } else if (bAJ.sqb.rdh == 0) {
                                z = false;
                                z2 = false;
                            } else {
                                z = true;
                                z2 = true;
                            }
                            this.oec.put(bAJ.sqb.ksA, Boolean.valueOf(z));
                            z = z2;
                        } else if (((Boolean) this.oec.get(bAJ.sqb.ksA)).booleanValue()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ayVar.mAppName = f;
                        ayVar.oeU = z;
                    } else if (bi.oW(bAJ.sqd) && g(bAJ)) {
                        ayVar.mAppName = f;
                        ayVar.oeT = true;
                        ayVar.oeW = bAJ.qIc;
                        ayVar.oeV = bAJ.sqd;
                    } else {
                        ayVar.oeS = false;
                        ayVar.oeT = false;
                    }
                    if (!(bAJ.nsD == null || bi.oW(bAJ.nsD.pLr))) {
                        ayVar.mAppName = this.mContext.getString(j.top_story_share_app_brand_name);
                        ayVar.oeS = true;
                    }
                    z = ayVar.gtX == null && ayVar.gtX.equals(this.ocI);
                    ayVar.oeM = z;
                    ayVar.oeY = nVar.bBg();
                    ayVar.oeZ = nVar.bAW().rWj;
                    ayVar.ofa = false;
                    if (n != null && ayVar.oeM) {
                        width = n.rXx;
                        if (width == 3 || width == 5) {
                            ayVar.ofa = true;
                        }
                    }
                    if (n != null) {
                        Object obj;
                        bon bon;
                        com.tencent.mm.vending.d.b.a aVar2;
                        ab Yf3;
                        if (n.smR.size() <= 0) {
                            ayVar.ofb = false;
                        } else if (!this.ocI.equals(n.rdS)) {
                            Iterator it2 = n.smR.iterator();
                            while (it2.hasNext()) {
                                if (this.ocI.equals(((bon) it2.next()).rdS)) {
                                    ayVar.ofb = true;
                                    ayVar.ofd = true;
                                    break;
                                }
                            }
                        } else {
                            ayVar.ofb = true;
                            StringBuffer stringBuffer = new StringBuffer();
                            it = n.smR.iterator();
                            obj = null;
                            while (it.hasNext()) {
                                bon = (bon) it.next();
                                if (obj == null) {
                                    obj = 1;
                                    stringBuffer.append("  ");
                                } else {
                                    stringBuffer.append(",  ");
                                }
                                if (bon.rTW != null) {
                                    stringBuffer.append(bon.rTW);
                                } else {
                                    Yf2 = this.dDg.Yf(bon.rdS);
                                    stringBuffer.append(Yf2 == null ? bon.rdS : Yf2.BL());
                                }
                            }
                            ayVar.ofc = stringBuffer.toString();
                        }
                        if (n.smZ != null && q.GF().equals(bAJ.hbL) && n.smZ.snB > 0) {
                            ayVar.ofh = ((double) m.b(nVar, n)) * 1.0d;
                            ayVar.ofg = n.smZ.snB;
                            ayVar.ofe = true;
                            aVar2 = new com.tencent.mm.vending.d.b.a();
                            it = n.smZ.snC.iterator();
                            while (it.hasNext()) {
                                bou bou = (bou) it.next();
                                Yf3 = this.dDg.Yf(bou.rdS);
                                if (Yf3 != null) {
                                    obj = bi.oV(Yf3.BL());
                                } else {
                                    obj = bi.oV(bou.rdS);
                                }
                                aVar2.u(new com.tencent.mm.vending.j.a[]{com.tencent.mm.vending.j.a.x(bou.rdS, obj)});
                            }
                            ayVar.ofi = aVar2.cBD();
                        }
                        if (n.smL.size() > 0) {
                            aVar2 = new com.tencent.mm.vending.d.b.a();
                            it = n.smL.iterator();
                            while (it.hasNext()) {
                                bon = (bon) it.next();
                                Yf3 = this.dDg.Yf(bon.rdS);
                                if (Yf3 != null) {
                                    obj = bi.oV(Yf3.BL());
                                } else {
                                    obj = bi.oV(bon.rdS);
                                }
                                aVar2.u(new com.tencent.mm.vending.j.a[]{com.tencent.mm.vending.j.a.x(bon.rdS, obj)});
                            }
                            ayVar.ofj = aVar2.cBD();
                        }
                        if (n.smO.size() > 0) {
                            com.tencent.mm.vending.d.b.a aVar3 = new com.tencent.mm.vending.d.b.a();
                            Iterator it3 = n.smO.iterator();
                            while (it3.hasNext()) {
                                a Yf4;
                                bon = (bon) it3.next();
                                long j = bon.smh != 0 ? (long) bon.smh : bon.smk;
                                String str3 = bon.rdS;
                                if (!bon.rdS.equals(this.ocI)) {
                                    Yf4 = this.dDg.Yf(bon.rdS);
                                } else if (this.odX == null) {
                                    Yf4 = this.dDg.Yf(bon.rdS);
                                    this.odX = Yf4;
                                } else {
                                    Yf4 = this.odX;
                                }
                                str = Yf4 != null ? Yf4.BL() : bon.rTW != null ? bon.rTW : bon.rdS;
                                str2 = str;
                                String str4 = bon.jSA;
                                CharSequence charSequence = (CharSequence) ayVar.oes.nkP.get(bon.smh + "-" + bon.smk + "-" + bon.jSA);
                                com.tencent.mm.vending.j.f[] fVarArr = new com.tencent.mm.vending.j.a[1];
                                Long valueOf = Long.valueOf(j);
                                com.tencent.mm.vending.j.f fVar = new com.tencent.mm.vending.j.f();
                                fVar.uRO = new Object[]{valueOf, str3, str2, str4, charSequence};
                                fVarArr[0] = fVar;
                                aVar3.u(fVarArr);
                            }
                            ayVar.ofk = aVar3.cBD();
                        }
                    }
                    ag.a(this.mContext, ayVar, bAJ.nsB);
                    if (ayVar.nLv) {
                        ayVar.oeE = nVar.bAH();
                        ayVar.oeF = nVar.bAF();
                        bAF = nVar.bAF();
                        ayVar.oeG = bAF != null ? bAF.nyD : "";
                    }
                    if (ayVar.nLv) {
                        com.tencent.mm.plugin.sns.storage.a aVar4 = ayVar.oeE;
                        if (ayVar.oeE.nye == com.tencent.mm.plugin.sns.storage.a.nxQ) {
                            ayVar.oeH = aVar4.nyf;
                        } else if (aVar4.nye == com.tencent.mm.plugin.sns.storage.a.nxR && !bi.oW(aVar4.nyf)) {
                            str = "";
                            it = aVar4.nyh.iterator();
                            while (it.hasNext()) {
                                BL = (String) it.next();
                                Yf2 = af.byc().Yf(BL);
                                if (Yf2 != null) {
                                    String BL2 = Yf2.BL();
                                    if (bi.oW(BL2)) {
                                        str = str + BL;
                                    } else {
                                        str = str + BL2;
                                    }
                                } else {
                                    str = str + BL;
                                }
                                if (aVar4.nyh.getLast() != BL) {
                                    str = str + ",";
                                }
                            }
                            ayVar.oeJ = str;
                            ayVar.oeI = String.format(aVar4.nyf, new Object[]{str});
                        }
                    }
                    bAW = nVar.bAW();
                    ayVar.ofn = bAW;
                    if (!(bAW == null || q.GF().equals(bAJ.hbL) || !m.a(nVar, n))) {
                        ayVar.oeP = true;
                    }
                    currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    x.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2)});
                    return ayVar;
                }
            }
        }
        width = viewWidth;
        if (this.DEBUG) {
            x.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsPostDesc position " + i + " viewWidth: " + width + " desc:" + str2);
        }
        Fa = com.tencent.mm.kiss.widget.textview.d.a(a, width, d.bEY().getTextViewConfig()).Fa();
        c.dtC.a(d.bEY().getTextViewConfig(), Fa);
        if (Fa.duh.getLineCount() > 6) {
            c.dtC.a(d.bEY().bEZ(), com.tencent.mm.kiss.widget.textview.d.a(a, width, d.bEY().bEZ()).Fa());
        }
        a(i, ayVar);
        if (ayVar.nhc.xb(32)) {
            af.byl().a(nVar, null);
        } else {
            af.byl().b(nVar, null);
        }
        f(ayVar.nhg);
        str = nVar.field_userName;
        Yf = this.dDg.Yf(str);
        if (str != null) {
            a aVar5;
            if (!str.equals(this.ocI)) {
                aVar5 = Yf;
            } else if (this.odX == null) {
                this.odX = Yf;
                aVar5 = Yf;
            } else {
                aVar5 = this.odX;
            }
            BL = aVar5 == null ? str : aVar5.BL();
            if (nVar.xb(32) && bi.oW(BL)) {
                com.tencent.mm.plugin.sns.storage.b bAF22 = nVar.bAF();
                if (!(bAF22 == null || bi.oW(bAF22.nickname))) {
                    BL = bAF22.nickname;
                }
            }
            ayVar.gtX = str;
            ayVar.oeK = BL;
            ayVar.nLv = nVar.xb(32);
            ayVar.nMU = nVar.bBe();
            z = aVar5 == null ? true : ((int) aVar5.dhP) == 0;
            ayVar.oeL = z;
            ayVar.oeu = aVar5;
        }
        ayVar.oev = nVar.bAK();
        ayVar.oex = bAJ.spZ;
        ayVar.oey = bAJ.sqe;
        ayVar.oez = nVar.field_createTime;
        ayVar.oeD = az.g(this.mContext, ((long) ayVar.oez) * 1000);
        ayVar.oeN = false;
        ayVar.oeO = n.smZ.snB;
        ayVar.oeN = true;
        if (ayVar.nLv) {
            BL = bAJ.sqa == null ? null : bAJ.sqa.eJJ;
            str = bAJ.sqa == null ? null : bAJ.sqa.kFa;
            if (bi.oW(str)) {
                ayVar.oeQ = BL;
                ayVar.oeR = false;
            } else {
                if (nVar.field_snsId != 0 || bi.oW(BL)) {
                    ayVar.oeQ = str;
                } else {
                    ayVar.oeQ = BL + "·" + str;
                }
                ayVar.oeR = true;
            }
        } else {
            com.tencent.mm.plugin.sns.storage.a bAH2 = nVar.bAH();
            if (bAH2 != null) {
                ayVar.oeQ = bAH2.nyc;
                if (bi.oW(bAH2.nyd)) {
                    z = false;
                } else {
                    z = true;
                }
                ayVar.oeR = z;
            }
        }
        f = f(bAJ);
        if (!com.tencent.mm.plugin.sns.c.a.ezo.cT(f)) {
        }
        if (bi.oW(bAJ.sqd)) {
        }
        ayVar.oeS = false;
        ayVar.oeT = false;
        ayVar.mAppName = this.mContext.getString(j.top_story_share_app_brand_name);
        ayVar.oeS = true;
        if (ayVar.gtX == null) {
        }
        ayVar.oeM = z;
        ayVar.oeY = nVar.bBg();
        ayVar.oeZ = nVar.bAW().rWj;
        ayVar.ofa = false;
        width = n.rXx;
        ayVar.ofa = true;
        if (n != null) {
            Object obj2;
            bon bon2;
            com.tencent.mm.vending.d.b.a aVar22;
            ab Yf32;
            if (n.smR.size() <= 0) {
                ayVar.ofb = false;
            } else if (!this.ocI.equals(n.rdS)) {
                Iterator it22 = n.smR.iterator();
                while (it22.hasNext()) {
                    if (this.ocI.equals(((bon) it22.next()).rdS)) {
                        ayVar.ofb = true;
                        ayVar.ofd = true;
                        break;
                    }
                }
            } else {
                ayVar.ofb = true;
                StringBuffer stringBuffer2 = new StringBuffer();
                it = n.smR.iterator();
                obj2 = null;
                while (it.hasNext()) {
                    bon2 = (bon) it.next();
                    if (obj2 == null) {
                        obj2 = 1;
                        stringBuffer2.append("  ");
                    } else {
                        stringBuffer2.append(",  ");
                    }
                    if (bon2.rTW != null) {
                        stringBuffer2.append(bon2.rTW);
                    } else {
                        Yf2 = this.dDg.Yf(bon2.rdS);
                        stringBuffer2.append(Yf2 == null ? bon2.rdS : Yf2.BL());
                    }
                }
                ayVar.ofc = stringBuffer2.toString();
            }
            if (n.smZ != null && q.GF().equals(bAJ.hbL) && n.smZ.snB > 0) {
                ayVar.ofh = ((double) m.b(nVar, n)) * 1.0d;
                ayVar.ofg = n.smZ.snB;
                ayVar.ofe = true;
                aVar22 = new com.tencent.mm.vending.d.b.a();
                it = n.smZ.snC.iterator();
                while (it.hasNext()) {
                    bou bou2 = (bou) it.next();
                    Yf32 = this.dDg.Yf(bou2.rdS);
                    if (Yf32 != null) {
                        obj2 = bi.oV(Yf32.BL());
                    } else {
                        obj2 = bi.oV(bou2.rdS);
                    }
                    aVar22.u(new com.tencent.mm.vending.j.a[]{com.tencent.mm.vending.j.a.x(bou2.rdS, obj2)});
                }
                ayVar.ofi = aVar22.cBD();
            }
            if (n.smL.size() > 0) {
                aVar22 = new com.tencent.mm.vending.d.b.a();
                it = n.smL.iterator();
                while (it.hasNext()) {
                    bon2 = (bon) it.next();
                    Yf32 = this.dDg.Yf(bon2.rdS);
                    if (Yf32 != null) {
                        obj2 = bi.oV(Yf32.BL());
                    } else {
                        obj2 = bi.oV(bon2.rdS);
                    }
                    aVar22.u(new com.tencent.mm.vending.j.a[]{com.tencent.mm.vending.j.a.x(bon2.rdS, obj2)});
                }
                ayVar.ofj = aVar22.cBD();
            }
            if (n.smO.size() > 0) {
                com.tencent.mm.vending.d.b.a aVar32 = new com.tencent.mm.vending.d.b.a();
                Iterator it32 = n.smO.iterator();
                while (it32.hasNext()) {
                    a Yf42;
                    bon2 = (bon) it32.next();
                    long j2 = bon2.smh != 0 ? (long) bon2.smh : bon2.smk;
                    String str32 = bon2.rdS;
                    if (!bon2.rdS.equals(this.ocI)) {
                        Yf42 = this.dDg.Yf(bon2.rdS);
                    } else if (this.odX == null) {
                        Yf42 = this.dDg.Yf(bon2.rdS);
                        this.odX = Yf42;
                    } else {
                        Yf42 = this.odX;
                    }
                    str = Yf42 != null ? Yf42.BL() : bon2.rTW != null ? bon2.rTW : bon2.rdS;
                    str2 = str;
                    String str42 = bon2.jSA;
                    CharSequence charSequence2 = (CharSequence) ayVar.oes.nkP.get(bon2.smh + "-" + bon2.smk + "-" + bon2.jSA);
                    com.tencent.mm.vending.j.f[] fVarArr2 = new com.tencent.mm.vending.j.a[1];
                    Long valueOf2 = Long.valueOf(j2);
                    com.tencent.mm.vending.j.f fVar2 = new com.tencent.mm.vending.j.f();
                    fVar2.uRO = new Object[]{valueOf2, str32, str2, str42, charSequence2};
                    fVarArr2[0] = fVar2;
                    aVar32.u(fVarArr2);
                }
                ayVar.ofk = aVar32.cBD();
            }
        }
        ag.a(this.mContext, ayVar, bAJ.nsB);
        if (ayVar.nLv) {
            ayVar.oeE = nVar.bAH();
            ayVar.oeF = nVar.bAF();
            bAF = nVar.bAF();
            ayVar.oeG = bAF != null ? bAF.nyD : "";
        }
        if (ayVar.nLv) {
            com.tencent.mm.plugin.sns.storage.a aVar42 = ayVar.oeE;
            if (ayVar.oeE.nye == com.tencent.mm.plugin.sns.storage.a.nxQ) {
                ayVar.oeH = aVar42.nyf;
            } else if (aVar42.nye == com.tencent.mm.plugin.sns.storage.a.nxR && !bi.oW(aVar42.nyf)) {
                str = "";
                it = aVar42.nyh.iterator();
                while (it.hasNext()) {
                    BL = (String) it.next();
                    Yf2 = af.byc().Yf(BL);
                    if (Yf2 != null) {
                        String BL22 = Yf2.BL();
                        if (bi.oW(BL22)) {
                            str = str + BL;
                        } else {
                            str = str + BL22;
                        }
                    } else {
                        str = str + BL;
                    }
                    if (aVar42.nyh.getLast() != BL) {
                        str = str + ",";
                    }
                }
                ayVar.oeJ = str;
                ayVar.oeI = String.format(aVar42.nyf, new Object[]{str});
            }
        }
        bAW = nVar.bAW();
        ayVar.ofn = bAW;
        ayVar.oeP = true;
        currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        x.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2)});
        return ayVar;
    }

    private String f(bsu bsu) {
        if (bsu.sqc.ruz == 26) {
            return this.mContext.getString(j.favorite);
        }
        if (bsu.sqb == null) {
            return "";
        }
        if (bi.oW(bsu.sqb.ksA)) {
            return "";
        }
        if (this.oeb.containsKey(bsu.sqb.ksA)) {
            return (String) this.oeb.get(bsu.sqb.ksA);
        }
        String b = g.b(this.mContext, g.cP(bsu.sqb.ksA, bi.getInt(bsu.sqb.hcr, 0)), null);
        if (bi.oW(b)) {
            return b;
        }
        this.oeb.put(bsu.sqb.ksA, b);
        return b;
    }

    private static boolean g(bsu bsu) {
        if (!bi.oW(bsu.sqd) && (am$a.byN() & 2) > 0) {
            return false;
        }
        return true;
    }

    private void a(int i, ay ayVar) {
        List<bon> list = ayVar.nhb.smO;
        com.tencent.mm.kiss.widget.textview.a.a textViewConfig = com.tencent.mm.plugin.sns.ui.widget.b.bEX().getTextViewConfig();
        ayVar.oes = new com.tencent.mm.plugin.sns.data.d();
        if (this.DEBUG) {
            x.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsComment position " + i + " commentInfoList: " + list.size() + " commentData:" + ayVar.oes.nkP.size());
        }
        for (bon bon : list) {
            String str;
            Object obj;
            c cVar = c.dtC;
            Context context = this.mContext;
            String str2 = ayVar.nhc.field_userName;
            String str3 = "";
            String a = com.tencent.mm.plugin.sns.ui.widget.c.a(bon);
            String str4 = bon.jSA;
            ab abVar = null;
            if (!bi.oW(str2)) {
                com.tencent.mm.kernel.g.Ek();
                abVar = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Ye(str2);
            }
            if (bon.smm == 1) {
                if (abVar != null) {
                    str = (a + context.getString(j.sns_at)) + (abVar == null ? str2 : abVar.BL());
                }
                str = a;
            } else {
                if (!bi.oW(bon.smB)) {
                    abVar = af.byc().Yf(bon.smB);
                    str = (a + context.getString(j.sns_reply)) + (abVar == null ? bon.smB : abVar.BL());
                }
                str = a;
            }
            CharSequence charSequence = (str3 + str + ": ") + str4;
            if (textViewConfig != null) {
                com.tencent.mm.kiss.widget.textview.b bVar = (com.tencent.mm.kiss.widget.textview.b) cVar.dtD.get(Integer.valueOf(c.a(textViewConfig)));
                if (bVar != null) {
                    LinkedList linkedList = (LinkedList) bVar.dtB.get(charSequence.toString());
                    if (linkedList == null || linkedList.size() == 0) {
                        obj = null;
                    } else {
                        int obj2 = 1;
                    }
                    if (obj2 == null) {
                        ayVar.oes.a(bon, com.tencent.mm.plugin.sns.ui.widget.c.a(this.mContext, bon, this.odV, ayVar.nhc.field_type, ayVar.nhc.field_userName));
                    } else {
                        CharSequence a2 = com.tencent.mm.plugin.sns.ui.widget.c.a(this.mContext, bon, this.odV, ayVar.nhc.field_type, ayVar.nhc.field_userName);
                        ayVar.oes.a(bon, a2);
                        int viewWidth = com.tencent.mm.plugin.sns.ui.widget.b.bEX().getViewWidth();
                        if (viewWidth > 0) {
                            c.dtC.a(textViewConfig, com.tencent.mm.kiss.widget.textview.d.a(a2, viewWidth, textViewConfig).Fa());
                        }
                    }
                }
            }
            obj2 = null;
            if (obj2 == null) {
                CharSequence a22 = com.tencent.mm.plugin.sns.ui.widget.c.a(this.mContext, bon, this.odV, ayVar.nhc.field_type, ayVar.nhc.field_userName);
                ayVar.oes.a(bon, a22);
                int viewWidth2 = com.tencent.mm.plugin.sns.ui.widget.b.bEX().getViewWidth();
                if (viewWidth2 > 0) {
                    c.dtC.a(textViewConfig, com.tencent.mm.kiss.widget.textview.d.a(a22, viewWidth2, textViewConfig).Fa());
                }
            } else {
                ayVar.oes.a(bon, com.tencent.mm.plugin.sns.ui.widget.c.a(this.mContext, bon, this.odV, ayVar.nhc.field_type, ayVar.nhc.field_userName));
            }
        }
    }

    protected final Cursor bEl() {
        if (!this.odY) {
            synchronized (this.oea) {
                this.iKw = r(0, this.iKw);
            }
            this.odY = true;
        }
        int Ny = af.byo().Ny(this.iKw);
        x.i("MicroMsg.SnsTimeLineVendingSide", "create time sql %s to %s getLimitSeq() %s", new Object[]{Integer.valueOf(this.odW), Integer.valueOf(Ny), this.iKw});
        if (this.odW != Ny) {
            com.tencent.mm.plugin.sns.storage.f byr = af.byr();
            String str = ("select *,rowid from AdSnsInfo  where createTime > " + Ny + " and createTime <= " + this.odW) + " order by  createTime desc";
            x.d("MicroMsg.AdSnsInfoStorage", "getAdInTime " + str);
            Cursor rawQuery = byr.diF.rawQuery(str, null);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                LinkedList linkedList = new LinkedList();
                do {
                    int i;
                    com.tencent.mm.plugin.sns.storage.e eVar = new com.tencent.mm.plugin.sns.storage.e();
                    eVar.d(rawQuery);
                    n bAL = eVar.bAL();
                    StringBuilder stringBuilder = new StringBuilder("ad xml ");
                    com.tencent.mm.plugin.sns.storage.e bBp = bAL.bBp();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(bAL.field_stringSeq);
                    stringBuffer.append(bBp.field_adxml);
                    stringBuffer.append(" <createtime " + bAL.field_createTime + ">");
                    stringBuffer.append(" <exposuretime " + bBp.field_exposureTime + ">");
                    stringBuffer.append(" <adcreatetime " + bBp.field_createAdTime + "> ");
                    stringBuffer.append(bBp.bAJ().spZ);
                    x.d("MicroMsg.SnsTimeLineVendingSide", stringBuilder.append(stringBuffer.toString()).toString());
                    long j = 21600;
                    com.tencent.mm.plugin.sns.storage.a bAH = bAL.bAH();
                    int i2 = bAL.field_createTime;
                    boolean z = (eVar.field_localFlag & 128) > 0;
                    if (bAH == null) {
                        i = i2;
                    } else if (z) {
                        j = 60 * bAH.nxU;
                        i = eVar.field_exposureTime;
                    } else {
                        j = 60 * bAH.nxT;
                        i = eVar.field_createAdTime;
                    }
                    long bG = bi.bG((long) i);
                    if (bG >= j) {
                        Object obj;
                        boy n = aj.n(bAL);
                        if (bAL.field_likeFlag == 0) {
                            Iterator it = n.smO.iterator();
                            while (it.hasNext()) {
                                bon bon = (bon) it.next();
                                if (bon == null || bi.oW(bon.rdS) || !bon.rdS.equals(this.ocI)) {
                                }
                            }
                            obj = null;
                            if (obj == null) {
                                af.byr().delete(bAL.field_snsId);
                                x.i("MicroMsg.SnsTimeLineVendingSide", "~~addelete the item " + bAL.field_snsId + " exposureTime: " + j + " field_createTime: " + bAL.field_createTime + " checktime: " + bG + " gettime: " + i + " isexposure " + z + " exposureTime " + eVar.field_exposureTime + " adCreateTIme:" + eVar.field_createAdTime);
                                if (!z) {
                                    linkedList.add(eVar);
                                }
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            af.byr().delete(bAL.field_snsId);
                            x.i("MicroMsg.SnsTimeLineVendingSide", "~~addelete the item " + bAL.field_snsId + " exposureTime: " + j + " field_createTime: " + bAL.field_createTime + " checktime: " + bG + " gettime: " + i + " isexposure " + z + " exposureTime " + eVar.field_exposureTime + " adCreateTIme:" + eVar.field_createAdTime);
                            if (!z) {
                                linkedList.add(eVar);
                            }
                        }
                    }
                    long j2 = bAL.field_snsId;
                    x.i("MicroMsg.SnsTimeLineVendingSide", "try to update snsid " + j2);
                    if (com.tencent.mm.plugin.sns.model.m.eK(j2)) {
                        com.tencent.mm.plugin.sns.model.m mVar = new com.tencent.mm.plugin.sns.model.m(j2, 1, bAL.bAH().nyt);
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Eh().dpP.a(mVar, 0);
                    }
                } while (rawQuery.moveToNext());
                if (linkedList.size() > 0) {
                    LinkedList linkedList2 = new LinkedList();
                    Iterator it2 = linkedList.iterator();
                    while (it2.hasNext()) {
                        com.tencent.mm.plugin.sns.storage.e eVar2 = (com.tencent.mm.plugin.sns.storage.e) it2.next();
                        bj bjVar = new bj();
                        bjVar.rbJ = 13298;
                        bjVar.rbK = new com.tencent.mm.bk.b(eVar2.bAH().ntU.getBytes());
                        bjVar.rbL = System.currentTimeMillis() / 1000;
                        linkedList2.add(bjVar);
                    }
                    com.tencent.mm.kernel.g.Ek();
                    com.tencent.mm.kernel.g.Eh().dpP.a(new l(linkedList2), 0);
                }
            }
            if (rawQuery != null) {
                x.d("MicroMsg.SnsTimeLineVendingSide", "test for adcount " + rawQuery.getCount());
                rawQuery.close();
            }
        }
        this.odW = Ny;
        Cursor ch = af.byo().ch(this.iKw, Ny);
        x.d("MicroMsg.SnsTimeLineVendingSide", "onCursorResetFinish");
        com.tencent.mm.modelsns.b io = com.tencent.mm.modelsns.b.io(500);
        if (io.Rz()) {
            int i3 = this.mCount;
            if (i3 == 0) {
                io.ir(0).ir(0).ir(0);
                io.RD();
            } else {
                int i4 = i3 - 1;
                String g = i.g((n) getItem(1));
                String g2 = i.g((n) getItem(i4));
                if (!(g.equals(this.oed) && g2.equals(this.oee))) {
                    this.oed = g;
                    this.oee = g2;
                    io.ir(i3).nb(g).nb(g2);
                    io.RD();
                }
            }
        }
        return ch;
    }

    public final void destroyAsynchronous() {
        super.destroyAsynchronous();
        c.dtC.EZ();
        this.oec.clear();
    }
}
