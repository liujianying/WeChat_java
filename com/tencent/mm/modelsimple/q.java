package com.tencent.mm.modelsimple;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.a.o;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.l.a;
import com.tencent.mm.ab.l.b;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.ar;
import com.tencent.mm.protocal.c.asq;
import com.tencent.mm.protocal.c.ass;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.brj;
import com.tencent.mm.protocal.c.bup;
import com.tencent.mm.protocal.c.ccn;
import com.tencent.mm.protocal.c.cge;
import com.tencent.mm.protocal.c.fi;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Iterator;

public final class q extends l implements k {
    public String account;
    public final com.tencent.mm.network.q dJM;
    private int dJp;
    e diJ;
    private String efK;
    private String efL;
    private boolean efM;
    private boolean efN;
    private int efO;
    private int efP;
    public String efQ;
    private boolean efR;
    private int errCode;
    private int errType;

    public q(int i, String str, String str2, String str3) {
        this("", "", i, str, str2, str3, 0, "", false, false);
    }

    public q(String str, String str2, String str3, int i) {
        this(str, str2, 0, "", "", "", i, str3, false, false);
    }

    public q(String str, String str2, String str3, String str4) {
        this(str2, str3, 0, "", "", "", 0, str4, true, false);
        this.efQ = str;
    }

    public q(String str, String str2, int i, String str3, String str4, String str5, int i2, String str6, boolean z, boolean z2) {
        this.efK = "";
        this.efL = "";
        this.account = "";
        this.efM = false;
        this.efN = false;
        this.errType = 0;
        this.errCode = 0;
        this.dJp = 3;
        this.efO = 0;
        this.efP = 0;
        this.efR = false;
        x.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth this: " + this + " account: " + str + " secCodetype: " + i + " secCode: " + str3 + " sid: " + str4 + " encryptKey: " + str5 + " inputType: " + i2 + " authTicket: " + str6 + " useRawPwd: " + z + " isMobileAutoLogin: " + z2 + " stack: " + bi.cjd());
        this.efN = z2;
        this.account = str;
        this.dJM = new av(701);
        d dVar = (d) this.dJM.KV();
        int i3 = av.Ib().getInt("key_auth_update_version", 0);
        x.d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(com.tencent.mm.protocal.d.qVN)});
        if (i3 == 0) {
            dVar.qWw = 1;
            f.mDy.a(148, 0, 1, false);
            dVar.qWl = true;
        } else if (i3 < com.tencent.mm.protocal.d.qVN) {
            dVar.qWw = 16;
            f.mDy.a(148, 1, 1, false);
        } else {
            dVar.qWw = 1;
        }
        dVar.eK(0);
        ass ass = new ass();
        asq asq = new asq();
        dVar.qWk.rUY = ass;
        dVar.qWk.rUZ = asq;
        asq.rUX = i2;
        fi fiVar = new fi();
        asq.reP = fiVar;
        fiVar.reE = str6;
        fiVar.rgn = 0;
        fiVar.rez = new bhy().bq(new byte[0]);
        fiVar.rey = new bhy().bq(new byte[0]);
        ccn ccn = new ccn();
        fiVar.rgl = ccn;
        ccn.rhW = "";
        ccn.rhV = "";
        ccn.syo = "";
        cge cge = new cge();
        fiVar.rgm = cge;
        cge.rKZ = "";
        cge.rKY = "";
        if (i == 1) {
            ccn.rhW = str3;
            ccn.rhV = str4;
            ccn.syo = str5;
            cge.rKZ = "";
            cge.rKY = "";
        } else if (i == 3) {
            ccn.rhW = "";
            ccn.rhV = "";
            ccn.syo = "";
            cge.rKZ = str3;
            cge.rKY = str4;
        }
        if (bi.oW(str) && g.Eg().Dx()) {
            f.mDy.a(148, 2, 1, false);
            this.efK = (String) g.Ei().DT().get(3, null);
            this.efL = (String) g.Ei().DT().get(19, null);
            i.e eVar = (i.e) this.dJM.Id();
            str = bi.oV((String) g.Ei().DT().get(2, null));
            if (bi.oW(str)) {
                str = new o(bi.a((Integer) g.Ei().DT().get(9, null), 0)).toString();
            } else {
                eVar.erW = str;
            }
        } else if (z || z2) {
            this.efK = str2;
            this.efL = str2;
        } else {
            this.efK = bi.WN(bi.oV(str2));
            this.efL = bi.WO(bi.oV(str2));
        }
        ass.hbL = str;
        byte[] bArr = null;
        if (!(i == 1 || i == 3)) {
            if (i == 2) {
                bArr = g.Eg().Dp().c(bi.getLong(str, 0), str3);
            } else if (bi.WE(str)) {
                bArr = g.Eg().Dp().a(bi.getLong(str, 0), this.efL, true);
            }
        }
        String str7 = "MicroMsg.NetSceneManualAuth";
        String str8 = "summerauth loginbuf len:%d content:[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[1] = bi.Xf(bi.bB(bArr));
        x.i(str7, str8, objArr);
        bhy bhy = new bhy();
        if (bi.bC(bArr)) {
            bArr = new byte[0];
        }
        fiVar.rgk = bhy.bq(bArr);
        ass.rhI = this.efL;
        ass.rhU = this.efK;
    }

    public final void mW(String str) {
        d dVar = (d) this.dJM.KV();
        dVar.qWk.rUY.rhI = str;
        dVar.qWk.rUY.rhU = str;
        dVar.qWk.rUZ.reP.rgk = new bhy().bq(new byte[0]);
        this.efK = str;
        this.efL = str;
    }

    public final int getType() {
        return 701;
    }

    protected final int Cc() {
        return 5;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return b.dJm;
    }

    protected final void a(a aVar) {
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dJM, this);
    }

    public final q Rc() {
        this.efR = true;
        return this;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        int i4;
        d dVar = (d) qVar.KV();
        i.e eVar = (i.e) qVar.Id();
        if (eVar.qWn == null || eVar.qWn.srN == null) {
            x.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual not set as ret:%s", new Object[]{Integer.valueOf(eVar.qWB)});
        } else {
            i4 = eVar.qWn.srN.reI;
            x.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual:%s", new Object[]{Integer.valueOf(i4)});
            g.Ek();
            g.Ei().dqk.set(47, Integer.valueOf(i4));
            com.tencent.mm.network.e eVar2 = g.Eh().dpP.dJs;
            if (eVar2 != null) {
                eVar2.bF((i4 & 1) == 0);
            }
        }
        this.errType = i2;
        this.errCode = i3;
        bup bup = eVar.qWn;
        if (bup == null) {
            x.w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
            this.diJ.a(4, -1, "", this);
            f.mDy.a(148, 3, 1, false);
            return;
        }
        x.i("MicroMsg.NetSceneManualAuth", "summerauth errType:%d, errCode:%d, errMsg:%s unifyAuthResp:%s, unifyFlag:%d, auth:%s, acct:%s, network:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, bup, Integer.valueOf(bup.srM), bup.srN, bup.srO, bup.srP});
        if (i2 == 0 && i3 == 0) {
            if ((i4 & 2) != 0) {
                ar arVar = bup.srO;
                if (arVar == null || bi.oW(arVar.hbL)) {
                    x.w("MicroMsg.NetSceneManualAuth", "summerauth UserName is null and return false!");
                    this.diJ.a(4, -1, "", this);
                    return;
                } else if (av.b(qVar) == 2) {
                    f.mDy.a(148, 7, 1, false);
                    x.d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", new Object[]{Integer.valueOf(this.efP)});
                    this.efP++;
                    if (this.efP > 1) {
                        this.diJ.a(4, -1, "", this);
                        return;
                    }
                    ((d) this.dJd.KV()).qWk.rUZ.reP.rgn = 1;
                    a(this.dIX, this.diJ);
                    return;
                } else {
                    x.d("MicroMsg.NetSceneManualAuth", "summerauth decode succeed!");
                    g.Em().uW();
                    x.d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", new Object[]{Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid()))});
                    z.a(eVar.qWn, false);
                    ((PluginAuth) g.n(PluginAuth.class)).getHandleAuthResponseCallbacks().a(dVar, eVar, false);
                    if (!bi.oW(this.account)) {
                        g.Ei().DT().a(aa.a.sZN, this.account);
                        at.dBv.T("login_user_name", this.account);
                    }
                    if (this.efN) {
                        g.Ei().DT().set(2, dVar.qWk.rUY.hbL);
                    }
                    g.Eh().dpP.a(new bg(new 2(this, eVar)), 0);
                    if (bi.f((Integer) g.Ei().DT().get(15, null)) != 0) {
                        ((com.tencent.mm.plugin.zero.b.b) g.l(com.tencent.mm.plugin.zero.b.b.class)).PM().id(10);
                    }
                    if ((bup.srN.reH & 8) == 0) {
                        Object GF = com.tencent.mm.model.q.GF();
                        if (!TextUtils.isEmpty(GF)) {
                            g.Eh().dpP.a(new m(GF), 0);
                        }
                    } else {
                        x.i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", new Object[]{Integer.valueOf(bup.srN.reH)});
                        f.mDy.a(148, 9, 1, false);
                    }
                    int i5 = 4;
                    if (dVar.qWk.rUZ.reP.rgk != null && dVar.qWk.rUZ.reP.rgk.siI > 0) {
                        i5 = 1;
                    } else if (dVar.qWk.rUZ.rUX == 1) {
                        i5 = 2;
                    }
                    com.tencent.mm.plugin.report.b.d.n(1, i5, dVar.qWk.rUY.hbL);
                    if (i2 == 0 && i3 == 0) {
                        x.i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
                        ji jiVar = new ji();
                        jiVar.bSN.bGZ = true;
                        com.tencent.mm.sdk.b.a.sFg.m(jiVar);
                    }
                    g.Em().cik();
                    this.diJ.a(i2, i3, str, this);
                    return;
                }
            }
            x.w("MicroMsg.NetSceneManualAuth", "summerauth acct resp is null and return false!");
            this.diJ.a(4, -1, "", this);
        } else if (i2 == 4 && i3 == -301) {
            x.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
            f.mDy.a(148, 4, 1, false);
            if (bup == null || bup.srP == null) {
                x.w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
            } else {
                av.a(true, bup.srP.rhK, bup.srP.rhL, bup.srP.rhJ);
            }
            this.dJp--;
            if (this.dJp <= 0) {
                x.w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
                this.diJ.a(3, -1, "", this);
                return;
            }
            x.i("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", new Object[]{Integer.valueOf(this.dJp)});
            a(this.dIX, this.diJ);
        } else if (!this.efR && i2 == 4 && i3 == -102) {
            f.mDy.a(148, 5, 1, false);
            final int i6 = qVar.KV().qWA.ver;
            x.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(i6)});
            g.Em().H(new Runnable() {
                public final void run() {
                    new i().a(q.this.dIX, new 1(this));
                }

                public final String toString() {
                    return super.toString() + "|onGYNetEnd1";
                }
            });
        } else if (i2 == 4 && i3 == -217) {
            this.diJ.a(i2, i3, str, this);
            f.mDy.a(148, 47, 1, false);
        } else if (i2 == 4 && i3 == -218) {
            this.diJ.a(i2, i3, str, this);
            f.mDy.a(148, 53, 1, false);
        } else if (i2 == 4 && i3 == -240) {
            x.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[]{Integer.valueOf(this.dJp)});
            this.dJp--;
            if (this.dJp <= 0) {
                this.diJ.a(3, -1, "", this);
                return;
            }
            f.mDy.a(148, 57, 1, false);
            a(this.dIX, this.diJ);
        } else {
            x.w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2), str});
            this.diJ.a(i2, i3, str, this);
            f.mDy.a(148, 6, 1, false);
        }
    }

    public final String Rd() {
        return ((i.e) this.dJM.Id()).qWn.srN == null ? "" : ((i.e) this.dJM.Id()).qWn.srN.reC;
    }

    public final String Re() {
        if (((i.e) this.dJM.Id()).qWn.srN == null) {
            return "";
        }
        int secCodeType = getSecCodeType();
        if (secCodeType == 3) {
            if (((i.e) this.dJM.Id()).qWn.srN.rex != null) {
                return bi.oV(((i.e) this.dJM.Id()).qWn.srN.rex.rKY);
            }
        } else if (secCodeType == 1 && ((i.e) this.dJM.Id()).qWn.srN.rew != null) {
            return bi.oV(((i.e) this.dJM.Id()).qWn.srN.rew.rhV);
        }
        return "";
    }

    public final byte[] Rf() {
        if (((i.e) this.dJM.Id()).qWn.srN == null) {
            return new byte[0];
        }
        int secCodeType = getSecCodeType();
        if (secCodeType == 3) {
            if (((i.e) this.dJM.Id()).qWn.srN.rex != null) {
                return ab.a(((i.e) this.dJM.Id()).qWn.srN.rex.rLb, new byte[0]);
            }
        } else if (secCodeType == 1) {
            if (((i.e) this.dJM.Id()).qWn.srN.rew != null) {
                return ab.a(((i.e) this.dJM.Id()).qWn.srN.rew.rcn, new byte[0]);
            }
        } else if (secCodeType == 2 && ((d) this.dJM.KV()).qWk.rUY != null) {
            g.Eg().Dp().a(bi.getLong(((d) this.dJM.KV()).qWk.rUY.hbL, 0), ab.a(((i.e) this.dJM.Id()).qWn.srN.rev));
            return g.Eg().Dp().ba(bi.getLong(((d) this.dJM.KV()).qWk.rUY.hbL, 0));
        }
        return new byte[0];
    }

    public final int getSecCodeType() {
        if (((i.e) this.dJM.Id()).qWn.srN == null) {
            x.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR AuthSectResp or WxVerifyCodeRespInfo is null");
            return 0;
        } else if (this.errType != 4) {
            x.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR errType :%d", new Object[]{Integer.valueOf(this.errType)});
            return 0;
        } else if (this.errCode == -311) {
            return 2;
        } else {
            if (this.errCode == -6) {
                return 1;
            }
            return this.errCode == -310 ? 3 : 0;
        }
    }

    public final String Rg() {
        if (((i.e) this.dJM.Id()).qWn.srN == null) {
            return "";
        }
        if (getSecCodeType() != 1 || ((i.e) this.dJM.Id()).qWn.srN.rew == null) {
            return "";
        }
        return ((i.e) this.dJM.Id()).qWn.srN.rew.syo != null ? ((i.e) this.dJM.Id()).qWn.srN.rew.syo : null;
    }

    public final String Ok() {
        return ((i.e) this.dJM.Id()).qWn.srN.reE;
    }

    public final String Rh() {
        return ((i.e) this.dJM.Id()).qWn.srO.raA;
    }

    public final int Ri() {
        if (((i.e) this.dJM.Id()).qWn.srN == null) {
            return 0;
        }
        int i;
        bnp bnp = ((i.e) this.dJM.Id()).qWn.srN.reD;
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 11) {
                    i = bi.getInt(brj.spx, 0);
                    break;
                }
            }
        }
        i = 0;
        return i;
    }

    public final BindWordingContent Rj() {
        if (((i.e) this.dJM.Id()).qWn.srN == null) {
            return null;
        }
        String str;
        BindWordingContent mV;
        bnp bnp = ((i.e) this.dJM.Id()).qWn.srN.reD;
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 12) {
                    str = brj.spx;
                    break;
                }
            }
        }
        str = null;
        if (str != null) {
            a aVar = new a();
            try {
                mV = a.mV(str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneManualAuth", e, "", new Object[0]);
                mV = null;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.NetSceneManualAuth", e2, "", new Object[0]);
            }
            return mV;
        }
        mV = null;
        return mV;
    }

    public final String Rk() {
        if (((i.e) this.dJM.Id()).qWn.srN == null) {
            return "";
        }
        bnp bnp = ((i.e) this.dJM.Id()).qWn.srN.reD;
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 16) {
                    return brj.spx;
                }
            }
        }
        return "";
    }

    public final int Rl() {
        if (((i.e) this.dJM.Id()).qWn.srN == null) {
            return 0;
        }
        int i;
        bnp bnp = ((i.e) this.dJM.Id()).qWn.srN.reD;
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 13) {
                    i = bi.getInt(brj.spx, 0);
                    break;
                }
            }
        }
        i = 0;
        return i;
    }

    public final boolean Rm() {
        if (((i.e) this.dJM.Id()).qWn.srN == null) {
            return true;
        }
        bnp bnp = ((i.e) this.dJM.Id()).qWn.srN.reD;
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 18) {
                    if (bi.getInt(brj.spx, 0) == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
