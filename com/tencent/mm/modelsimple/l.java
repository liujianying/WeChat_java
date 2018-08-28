package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.afo;
import com.tencent.mm.protocal.c.afp;
import com.tencent.mm.protocal.c.awy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.Map;

public final class l extends com.tencent.mm.ab.l implements k {
    public static String efA;
    public static String efB;
    public static String efC;
    public static String efD;
    public static String efE;
    private static int efF;
    private static int efG = 0;
    private static int efH = 22;
    private static int efI = 0;
    private static boolean efJ = false;
    public static String efv;
    public static String efw;
    public static String efx;
    public static String efy;
    public static String efz;
    private e diJ;

    public static boolean il(int i) {
        if (efF == i) {
            return false;
        }
        return true;
    }

    public static int QW() {
        return efG;
    }

    public static boolean QX() {
        return (efI & 2) != 0;
    }

    public static boolean QY() {
        return (efH & 4) != 0;
    }

    public static void bO(boolean z) {
        if (z) {
            efH |= 4;
        } else {
            efH &= -5;
        }
    }

    public static int QZ() {
        return efF;
    }

    public static boolean Ra() {
        return (efI & 512) != 0;
    }

    public static boolean Rb() {
        return (efI & 1024) != 0;
    }

    public l(int i) {
        efF = i;
    }

    public final int getType() {
        return 526;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        a aVar = new a();
        afo afo = new afo();
        afo.iwP = w.chP();
        x.d("MicroMsg.NetSceneGetOnlineInfo", "language %s", new Object[]{afo.iwP});
        aVar.dIG = afo;
        aVar.dIH = new afp();
        aVar.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
        aVar.dIF = 526;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diJ = eVar2;
        return a(eVar, aVar.KT(), this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetOnlineInfo", "ongynetend %d, %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            afp afp = (afp) ((b) qVar).dIE.dIL;
            efG = afp.rJA;
            x.d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", new Object[]{Integer.valueOf(efG), Integer.valueOf(afp.rbZ)});
            Map z = bl.z(afp.rJz, "summary");
            int i4 = efH;
            if (z != null) {
                int i5;
                int i6;
                efv = (String) z.get(".summary.banner");
                x.d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s", new Object[]{Integer.valueOf(afp.rJx), afp.rJz});
                afo afo = (afo) ((b) qVar).dID.dIL;
                Iterator it = afp.rJy.iterator();
                while (it.hasNext()) {
                    awy awy = (awy) it.next();
                    if (awy.rgs.cfV().hashCode() != afo.shX.rgs.cfV().hashCode()) {
                        Map z2 = bl.z(awy.saa, "wording");
                        x.d("MicroMsg.NetSceneGetOnlineInfo", awy.saa);
                        if (z2 != null) {
                            efw = (String) z2.get(".wording.title");
                            efx = (String) z2.get(".wording.notify");
                            efy = (String) z2.get(".wording.mute_title");
                            efz = (String) z2.get(".wording.mute_tips");
                            efA = (String) z2.get(".wording.exit");
                            efB = (String) z2.get(".wording.exit_confirm");
                            efC = (String) z2.get(".wording.lock_title");
                            efD = (String) z2.get(".wording.mute_lock_title");
                            efE = (String) z2.get(".wording.exit");
                        }
                        i5 = awy.sac;
                        i6 = afp.rbZ;
                        efI = i6;
                        if ((i6 & 2) != 0) {
                            efJ = true;
                        } else {
                            efJ = false;
                        }
                        if (i5 != efH) {
                            efH = i5;
                            au.HU();
                            c.Dt();
                        }
                    }
                }
                i5 = i4;
                i6 = afp.rbZ;
                efI = i6;
                if ((i6 & 2) != 0) {
                    efJ = false;
                } else {
                    efJ = true;
                }
                if (i5 != efH) {
                    efH = i5;
                    au.HU();
                    c.Dt();
                }
            }
            if ((afp.rbZ & 64) != 0) {
                au.HU();
                ai Yg = c.FR().Yg("filehelper");
                if (Yg == null || bi.oW(Yg.field_username)) {
                    aa.w(Yg);
                    au.HU();
                    Yg = c.FR().Yg("filehelper");
                }
                if (!(Yg == null || com.tencent.mm.l.a.gd(Yg.field_type))) {
                    Yg.Bb();
                    au.HU();
                    c.FR().a(Yg.field_username, Yg);
                }
                au.HU();
                com.tencent.mm.storage.ai Yq = c.FW().Yq("filehelper");
                if (Yq == null) {
                    Yq = new com.tencent.mm.storage.ai("filehelper");
                    Yq.as(bi.VF());
                    au.HU();
                    c.FW().d(Yq);
                } else {
                    Yq.as(bi.VF());
                    au.HU();
                    c.FW().a(Yq, "filehelper");
                }
            }
        }
        this.diJ.a(i2, i3, str, this);
    }
}
