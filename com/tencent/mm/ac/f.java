package com.tencent.mm.ac;

import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.model.bd.5;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.atx;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.List;

public final class f {
    public static d kH(String str) {
        d kA = z.MY().kA(str);
        return kA.field_updateTime > 0 ? kA : null;
    }

    public static boolean kI(String str) {
        d kH = kH(str);
        if (kH != null && kH.LV()) {
            return true;
        }
        return false;
    }

    public static boolean kJ(String str) {
        d kH = kH(str);
        if (kH == null) {
            return false;
        }
        return kH.LW();
    }

    public static boolean kK(String str) {
        d kH = kH(str);
        if (kH != null && kH.LX()) {
            return true;
        }
        return false;
    }

    public static boolean kL(String str) {
        d kH = kH(str);
        if (kH != null && kH.LZ()) {
            return true;
        }
        return false;
    }

    public static boolean kM(String str) {
        if (str == null) {
            return false;
        }
        d kH = kH(str);
        if (kH == null || !kH.LY()) {
            return false;
        }
        return true;
    }

    public static boolean eZ(String str) {
        d kH = kH(str);
        if (kH != null && kH.Ma()) {
            return true;
        }
        return false;
    }

    public static boolean kN(String str) {
        d kH = kH(str);
        if (kH != null && kH.Mb()) {
            return true;
        }
        return false;
    }

    public static boolean kO(String str) {
        d kH = kH(str);
        if (kH == null) {
            return false;
        }
        return kH.LQ();
    }

    public static void f(d dVar) {
        if (dVar == null) {
            x.e("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession bizInfo is Null");
            return;
        }
        atx atx = new atx();
        atx.eJV = dVar.field_brandFlag;
        atx.hbL = dVar.field_username;
        ab Yf = ((i) g.l(i.class)).FR().Yf(dVar.field_username);
        if (Yf == null || !a.gd(Yf.field_type)) {
            ((i) g.l(i.class)).FQ().b(new h.a(58, atx));
        } else {
            ((i) g.l(i.class)).FQ().b(new h.a(47, atx));
        }
        boolean c = z.MY().c(dVar, new String[0]);
        x.i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", new Object[]{Boolean.valueOf(c), Integer.valueOf(dVar.field_brandFlag)});
    }

    public static void g(d dVar) {
        if (dVar != null) {
            atx atx = new atx();
            atx.eJV = dVar.field_brandFlag;
            atx.hbL = dVar.field_username;
            ((i) g.l(i.class)).FQ().b(new h.a(47, atx));
            z.MY().c(dVar, new String[0]);
        }
    }

    public static boolean MH() {
        return z.MY().hx(1) > 0;
    }

    public static boolean MI() {
        return z.MY().hx(4) > 0;
    }

    public static boolean MJ() {
        return z.MY().hx(8) > 0;
    }

    public static boolean MK() {
        return z.MY().hx(16) > 0;
    }

    public static boolean ML() {
        return z.MY().hx(64) > 0;
    }

    public static List<String> MM() {
        return z.MY().hw(128);
    }

    public static boolean MN() {
        return z.MY().hx(128) > 0;
    }

    public static boolean MO() {
        return z.MY().hx(256) > 0;
    }

    public static boolean MP() {
        return z.MY().hx(512) > 0;
    }

    public static void kP(String str) {
        int i = 0;
        z.MY();
        String kD = e.kD(str);
        if (kD != null) {
            ((o) g.l(o.class)).FU().GK(kD);
        }
        ((i) g.l(i.class)).FW().Yp(str);
        d kH = kH(str);
        if (kH == null) {
            z.Nh().jy(str);
            return;
        }
        if (kH.LY()) {
            ((i) g.l(i.class)).FW().YH(str);
            z.MY();
            List kC = e.kC(str);
            if (kC == null || kC.size() <= 0) {
                x.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalkers, empty talkers");
            } else {
                x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalkers stack[%s]", new Object[]{bi.cjd()});
                e.post(new 5(kC), "deleteMsgByTalkers");
            }
            while (i < kC.size()) {
                String str2 = (String) kC.get(i);
                if (eZ(str2)) {
                    com.tencent.mm.ac.a.e.D(str2, true);
                }
                z.MY().delete(str2);
                i++;
            }
        }
        if (kH.Ma()) {
            com.tencent.mm.ac.a.e.D(str, true);
        }
        z.MY().c(kH);
        z.Nh().jy(str);
    }
}
