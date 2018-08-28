package com.tencent.mm.modelsimple;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.a.o;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.aq.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.av;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.brj;
import com.tencent.mm.protocal.u;
import com.tencent.mm.protocal.u.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s extends l implements k {
    public q dJM;
    private int dJp = 2;
    e diJ;
    private final String efZ;
    private final String ega;
    private final String egb;
    private final String egc;
    private final String egd;
    private final String ege;
    private final int egf;
    private final int egg;
    private boolean egh = true;
    public boolean egi = false;

    public s(String str, String str2, String str3, int i, String str4, String str5, String str6, int i2) {
        x.d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + str + " nickname = " + str3);
        x.d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + i + "bindEmail = " + str4 + " bindMobile = " + str5);
        x.d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = " + i2 + " ticket: " + str6);
        this.egg = i2;
        this.dJM = new ax();
        a aVar = (a) this.dJM.KV();
        aVar.eK(0);
        aVar.qWY.hbL = str;
        aVar.qWY.rhI = bi.WN(str2);
        if (i2 == 4) {
            aVar.qWY.rhI = str6;
            x.w("MicroMsg.NetSceneReg", "dkreg rand:" + str6 + " reqMd5:" + aVar.qWY.rhI);
        }
        aVar.qWY.hcS = str3;
        aVar.qWY.ray = i;
        aVar.qWY.raz = str4;
        aVar.qWY.raA = str5;
        aVar.qWY.rwj = str6;
        aVar.qWY.rLa = i2;
        aVar.qWY.iwO = bi.ciX();
        aVar.qWY.rwh = com.tencent.mm.compatible.e.q.getSimCountryIso();
        aVar.qWY.iwP = w.chP();
        aVar.qWY.reR = 0;
        aVar.qWY.rYY = 0;
        aVar.qWY.rYZ = com.tencent.mm.compatible.e.q.getAndroidId();
        aVar.qWY.ryW = com.tencent.mm.compatible.e.q.zB();
        aVar.qWY.rZa = ad.getContext().getSharedPreferences(ad.chY(), 0).getString("installreferer", "");
        aVar.qWY.rZb = b.lFJ.ub(2);
        aVar.qWY.rZc = ad.getContext().getSharedPreferences(ad.chY() + "_google_aid", 4).getString("getgoogleaid", "");
        this.efZ = str;
        this.ega = str2;
        this.egb = str3;
        this.egc = str4;
        this.egd = str5;
        this.egf = i;
        this.ege = "";
        boolean z = (str6 == null || str6.length() <= 0) && str4.length() <= 0;
        this.egh = z;
        aVar.qWY.reS = com.tencent.mm.kernel.a.DA();
    }

    public s(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10, String str11, boolean z, boolean z2) {
        x.i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", new Object[]{str, bi.Xf(str2), str3, Integer.valueOf(i), str4, str5, str6, str7, str8, Integer.valueOf(i2), str9, str11, str10, Boolean.valueOf(z), Boolean.valueOf(z2)});
        this.egg = i2;
        this.dJM = new ax();
        a aVar = (a) this.dJM.KV();
        aVar.eK(0);
        aVar.qWY.hbL = str;
        aVar.qWY.rhI = bi.WN(str2);
        if (i2 == 4) {
            aVar.qWY.rhI = str8;
            x.w("MicroMsg.NetSceneReg", "dkreg rand:" + str8 + " reqMd5:" + aVar.qWY.rhI);
        }
        aVar.qWY.hcS = str3;
        aVar.qWY.ray = i;
        aVar.qWY.raz = str4;
        aVar.qWY.raA = str5;
        aVar.qWY.rwj = str8;
        aVar.qWY.rLa = i2;
        aVar.qWY.iwO = bi.ciX();
        aVar.qWY.rwh = com.tencent.mm.compatible.e.q.getSimCountryIso();
        aVar.qWY.iwP = w.chP();
        aVar.qWY.reR = 0;
        aVar.qWY.eJM = str9;
        aVar.qWY.rKZ = str11;
        aVar.qWY.rKY = str10;
        aVar.qWY.rhy = z ? 1 : 0;
        aVar.qWY.rYX = z2 ? 1 : 0;
        aVar.qWY.reS = com.tencent.mm.kernel.a.DA();
        aVar.qWY.rYZ = com.tencent.mm.compatible.e.q.getAndroidId();
        aVar.qWY.ryW = com.tencent.mm.compatible.e.q.zB();
        aVar.qWY.rZa = ad.getContext().getSharedPreferences(ad.chY(), 0).getString("installreferer", "");
        aVar.qWY.rZb = b.lFJ.ub(2);
        aVar.qWY.rZc = ad.getContext().getSharedPreferences(ad.chY() + "_google_aid", 4).getString("getgoogleaid", "");
        this.efZ = str;
        this.ega = str2;
        this.egb = str3;
        this.egc = str4;
        this.egd = str5;
        this.egf = i;
        this.ege = str9;
        boolean z3 = (str8 == null || str8.length() <= 0) && (str4 == null || str4.length() <= 0);
        this.egh = z3;
    }

    public final void im(int i) {
        ((a) this.dJM.KV()).qWY.rhE = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dJM, this);
    }

    protected final int Cc() {
        return 3;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    protected final void a(l.a aVar) {
    }

    public final void mX(String str) {
        if (!bi.oW(str)) {
            ((a) this.dJM.KV()).qWY.rhF = str;
        }
    }

    public final int getType() {
        return 126;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        int i4;
        u.b bVar = (u.b) qVar.Id();
        if (bVar.qWZ != null) {
            i4 = bVar.qWZ.reI;
            x.i("MicroMsg.NetSceneReg", "summerauth mmtls reg:%s", new Object[]{Integer.valueOf(i4)});
            g.Ek();
            g.Ei().dqk.set(47, Integer.valueOf(i4));
            com.tencent.mm.network.e eVar = g.Eh().dpP.dJs;
            if (eVar != null) {
                eVar.bF((i4 & 1) == 0);
            }
        } else {
            x.i("MicroMsg.NetSceneReg", "summerauth mmtls reg not set as ret:%s", new Object[]{Integer.valueOf(bVar.qWB)});
        }
        if (i2 == 4 && i3 == -301) {
            av.a(true, bVar.qWZ.rhK, bVar.qWZ.rhL, bVar.qWZ.rhJ);
            this.dJp--;
            if (this.dJp <= 0) {
                this.diJ.a(3, -1, "", this);
            } else {
                a(this.dIX, this.diJ);
            }
        } else if (i2 == 4 && i3 == -240) {
            x.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[]{Integer.valueOf(this.dJp)});
            this.dJp--;
            if (this.dJp <= 0) {
                this.diJ.a(3, -1, "", this);
            } else {
                a(this.dIX, this.diJ);
            }
        } else if (i2 == 4 && i3 == -102) {
            i4 = qVar.KV().qWA.ver;
            x.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(i4)});
            g.Em().H(new Runnable() {
                public final void run() {
                    new i().a(s.this.dIX, new 1(this));
                }
            });
        } else if (i2 == 0 && i3 == 0) {
            a aVar = (a) qVar.KV();
            x.d("MicroMsg.NetSceneReg", "dkreg: pass:" + bVar.qWZ.iwG + " regtype:" + bVar.qWZ.raC + " mode:" + aVar.qWY.rLa);
            if (!(bVar.qWZ.iwE == 0 || this.egh)) {
                g.Ek();
                g.gJ(bVar.qWZ.iwE);
                g.Ei().DT().set(2, aVar.qWY.hbL);
                g.Ei().DT().set(16, Integer.valueOf(1));
                g.Ei().DT().set(52, Integer.valueOf(bVar.qWZ.raC));
                g.Ei().DT().set(340240, Long.valueOf(System.currentTimeMillis()));
                g.Ei().DT().set(340241, Boolean.valueOf(true));
                if (!(this.efZ == null || this.efZ.length() <= 0 || this.egg == 1)) {
                    bVar.qWZ.hbL = this.efZ;
                }
                bVar.qWZ.raz = this.egc;
                bVar.qWZ.hcd = 0;
                if (!g.Eg().Dx() || g.Ei().DT() == null) {
                    r7 = new Object[3];
                    g.Eg();
                    r7[1] = o.getString(com.tencent.mm.kernel.a.Df());
                    r7[2] = g.Ei().DT();
                    x.e("MicroMsg.NetSceneReg", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", r7);
                } else {
                    String str2 = this.ege;
                    int i5 = this.egf;
                    String str3 = this.egb;
                    String str4 = this.egd;
                    String str5 = bVar.qWZ.hbL;
                    String str6 = bVar.qWZ.raz;
                    int i6 = bVar.qWZ.hcd;
                    String str7 = bVar.qWZ.raF;
                    String str8 = bVar.qWZ.raG;
                    int i7 = bVar.qWZ.raH;
                    int i8 = bVar.qWZ.rZh;
                    String str9 = bVar.qWZ.qZf;
                    String str10 = bVar.qWZ.raI;
                    String str11 = bVar.qWZ.reA;
                    String str12 = bVar.qWZ.rZg;
                    x.i("MicroMsg.HandleAuthResponse", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", new Object[]{str5, str2, o.getString(i5), str3, str6, str4, Integer.valueOf(i6), str7, str8, Integer.valueOf(i7), Integer.valueOf(i8), bi.Xf(str9), str10, Integer.valueOf(0), bi.Xf(str11), bi.Xf(null), bi.Xf(null), bi.Xf(null), Integer.valueOf(-1), str12, Integer.valueOf(0)});
                    com.tencent.mm.storage.x DT = g.Ei().DT();
                    at.dBv.T("login_weixin_username", str5);
                    at.dBv.T("last_login_nick_name", str3);
                    at.dBv.c(str4, i5, str6);
                    DT.set(2, str5);
                    DT.set(42, str2);
                    DT.set(9, Integer.valueOf(i5));
                    DT.set(4, str3);
                    DT.set(5, str6);
                    DT.set(6, str4);
                    DT.set(7, Integer.valueOf(i6));
                    DT.set(21, str7);
                    DT.set(22, str8);
                    DT.set(57, Integer.valueOf(0));
                    DT.set(17, Integer.valueOf(i7));
                    DT.set(25, Integer.valueOf(i8));
                    DT.set(1, str9);
                    DT.set(29, str10);
                    DT.set(34, Integer.valueOf(0));
                    DT.set(ab.CTRL_BYTE, Boolean.valueOf(false));
                    x.i("MicroMsg.HandleAuthResponse", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
                    DT.set(-1535680990, str11);
                    DT.set(46, null);
                    DT.set(72, null);
                    DT.set(64, Integer.valueOf(-1));
                    DT.lm(true);
                    ((PluginAuth) g.n(PluginAuth.class)).getHandleAuthResponseCallbacks().a(bVar, this.ege, this.egf, this.egb, this.egd, 0);
                }
                av.a(false, bVar.qWZ.rhK, bVar.qWZ.rhL, bVar.qWZ.rhJ);
                g.Ei().DT().lm(true);
                g.DF().a(new bg(new 2(this, bVar)), 0);
                x.d("MicroMsg.NetSceneReg", "resp return flag" + bVar.qWZ.rZj);
                this.egi = (bVar.qWZ.rZj & 1) != 0;
            }
            List linkedList = new LinkedList();
            linkedList.add(new h.a(21, "android-" + VERSION.SDK_INT + "-" + Build.MODEL));
            ((i) g.l(i.class)).FQ().b(new h(linkedList));
            this.diJ.a(i2, i3, str, this);
        } else {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final byte[] Rf() {
        return com.tencent.mm.platformtools.ab.a(((u.b) this.dJM.Id()).qWZ.rLb, new byte[0]);
    }

    public final String Re() {
        return ((u.b) this.dJM.Id()).qWZ.rKY;
    }

    public final String Rn() {
        return ((u.b) this.dJM.Id()).qWZ.rZn;
    }

    public final int Ro() {
        bnp bnp = ((u.b) this.dJM.Id()).qWZ.reD;
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 1) {
                    return bi.getInt(brj.spx, 0);
                }
            }
        }
        return 0;
    }

    public final String Rp() {
        bnp bnp = ((u.b) this.dJM.Id()).qWZ.reD;
        String str = "";
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 2) {
                    return brj.spx;
                }
            }
        }
        return str;
    }

    public final int Rq() {
        bnp bnp = ((u.b) this.dJM.Id()).qWZ.reD;
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 3) {
                    return bi.getInt(brj.spx, 2);
                }
            }
        }
        return 2;
    }

    public final String Rr() {
        bnp bnp = ((u.b) this.dJM.Id()).qWZ.reD;
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 17) {
                    return brj.spx;
                }
            }
        }
        return null;
    }
}
