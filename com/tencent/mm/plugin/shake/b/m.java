package com.tencent.mm.plugin.shake.b;

import android.os.Looper;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.bv;
import com.tencent.mm.plugin.shake.c.a.f;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.az.a;
import java.util.HashMap;

public final class m implements ar {
    private static HashMap<Integer, d> cVM;
    private a dBJ = new 2(this);
    private c hKG = new 7(this);
    private ay.a lBt = new ay.a() {
        public final void a(ay ayVar, ab abVar) {
            if (ayVar != null && abVar != null && abVar.BA()) {
                m.buC().Lb(abVar.field_username);
            }
        }
    };
    private c lyA = new 6(this);
    private ag mHandler = new ag(Looper.getMainLooper());
    private e mWV;
    private g mWW;
    private f mWX;
    private com.tencent.mm.plugin.shake.c.a.d mWY;
    private o mWZ;
    private n mXa = new n();
    com.tencent.mm.pluginsdk.c.d mXb = new com.tencent.mm.pluginsdk.c.d() {
        public final b CY(String str) {
            ph phVar = new ph();
            phVar.caf.bHA = str;
            return phVar;
        }

        public final j aSe() {
            return m.buD();
        }
    };
    private bv.a mXc = new 13(this);
    private c mXd = new 3(this);
    private bv.a mXe = new 4(this);
    private bv.a mXf = new bv.a() {
        public final void a(com.tencent.mm.ab.d.a aVar) {
            String a = com.tencent.mm.platformtools.ab.a(aVar.dIN.rcl);
            if (a == null || a.length() == 0) {
                x.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
            } else {
                m.this.mHandler.post(new 1(this, a, aVar));
            }
        }
    };

    private static m buB() {
        au.HN();
        m mVar = (m) bs.iK("plugin.shake");
        if (mVar != null) {
            return mVar;
        }
        mVar = new m();
        au.HN().a("plugin.shake", mVar);
        return mVar;
    }

    public static e buC() {
        g.Eg().Ds();
        if (buB().mWV == null) {
            m buB = buB();
            au.HU();
            buB.mWV = new e(com.tencent.mm.model.c.FO());
        }
        return buB().mWV;
    }

    public static g buD() {
        g.Eg().Ds();
        if (buB().mWW == null) {
            m buB = buB();
            au.HU();
            buB.mWW = new g(com.tencent.mm.model.c.FO());
        }
        return buB().mWW;
    }

    public static o buE() {
        g.Eg().Ds();
        if (buB().mWZ == null) {
            m buB = buB();
            au.HU();
            buB.mWZ = new o(com.tencent.mm.model.c.FO());
        }
        return buB().mWZ;
    }

    public final void onAccountRelease() {
        au.HU();
        com.tencent.mm.model.c.FW().c(this.dBJ);
        com.tencent.mm.sdk.b.a.sFg.c(this.hKG);
        com.tencent.mm.sdk.b.a.sFg.c(this.mXd);
        com.tencent.mm.sdk.b.a.sFg.c(this.mXa);
        com.tencent.mm.sdk.b.a.sFg.c(this.lyA);
        au.HU();
        com.tencent.mm.model.c.FR().b(this.lBt);
        au.getSysCmdMsgExtension().b("shake", this.mXc, true);
        au.getSysCmdMsgExtension().b("ShakeCardEntrance", this.mXe, true);
        au.getSysCmdMsgExtension().b("ShakeCardRedDot", this.mXf, true);
        com.tencent.mm.pluginsdk.o.a.qyh = null;
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("SHAKEITEM_TABLE".hashCode()), new 8());
        cVM.put(Integer.valueOf("SHAKEMSG_TABLE".hashCode()), new 9());
        cVM.put(Integer.valueOf("SHAKETVHISTORY_TABLE".hashCode()), new 10());
        cVM.put(Integer.valueOf("SHAKENEWYEARFRIENDINFO_TABLE".hashCode()), new d() {
            public final String[] xb() {
                return k.diD;
            }
        });
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public static void buF() {
        buC().but();
        com.tencent.mm.az.d.SH().aPm();
    }

    public final void bn(boolean z) {
        com.tencent.mm.pluginsdk.o.a.qyh = new h();
        au.HU();
        com.tencent.mm.model.c.FW().b(this.dBJ);
        com.tencent.mm.sdk.b.a.sFg.b(this.hKG);
        com.tencent.mm.sdk.b.a.sFg.b(this.mXd);
        com.tencent.mm.sdk.b.a.sFg.b(this.mXa);
        com.tencent.mm.sdk.b.a.sFg.b(this.lyA);
        au.HU();
        com.tencent.mm.model.c.FR().a(this.lBt);
        au.Em().H(new 12(this));
        au.getSysCmdMsgExtension().a("shake", this.mXc, true);
        au.getSysCmdMsgExtension().a("ShakeCardEntrance", this.mXe, true);
        au.getSysCmdMsgExtension().a("ShakeCardRedDot", this.mXf, true);
        this.mWX = null;
        this.mWY = null;
    }

    public final void bo(boolean z) {
    }

    public static int buG() {
        g.Eg().Ds();
        return i.mWK;
    }

    public static String lV(String str) {
        if (!au.HX()) {
            return "";
        }
        r1 = new Object[2];
        au.HU();
        r1[0] = com.tencent.mm.model.c.Gi();
        r1[1] = com.tencent.mm.a.g.u(str.getBytes());
        return String.format("%s/Sk_%s", r1);
    }

    public static String eq(String str, String str2) {
        if (!au.HX() || bi.oW(str)) {
            return "";
        }
        r1 = new Object[3];
        au.HU();
        r1[0] = com.tencent.mm.model.c.Gi();
        r1[1] = str2;
        r1[2] = com.tencent.mm.a.g.u(str.getBytes());
        return String.format("%s/Sk%s_%s", r1);
    }

    public static f buH() {
        g.Eg().Ds();
        if (buB().mWX == null) {
            buB().mWX = new f();
        }
        return buB().mWX;
    }

    public static com.tencent.mm.plugin.shake.c.a.d buI() {
        g.Eg().Ds();
        if (buB().mWY == null) {
            buB().mWY = new com.tencent.mm.plugin.shake.c.a.d();
        }
        return buB().mWY;
    }
}
