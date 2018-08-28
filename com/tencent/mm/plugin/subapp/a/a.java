package com.tencent.mm.plugin.subapp.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aji;
import com.tencent.mm.protocal.c.ajj;
import com.tencent.mm.protocal.c.bxj;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileOutputStream;

public final class a extends l implements k {
    private al dHa = new al(new 1(this), true);
    final b diG;
    private e diJ;
    int oqY = 0;

    public a() {
        int i = 0;
        au.HU();
        int f = bi.f((Integer) c.DT().get(66052, null));
        if (com.tencent.mm.model.am.a.dBt.gZ(f)) {
            au.HU();
            i = bi.f((Integer) c.DT().get(66053, null));
        }
        StringBuilder append = new StringBuilder("init: allfileid:").append(Integer.toBinaryString(f)).append(" inver:");
        au.HU();
        x.d("MicroMsg.NetSceneGetVUserInfo", append.append(bi.f((Integer) c.DT().get(66053, null))).append(" reqver:").append(i).toString());
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new aji();
        aVar.dIH = new ajj();
        aVar.uri = "/cgi-bin/micromsg-bin/getvuserinfo";
        aVar.dIF = 167;
        aVar.dII = 60;
        aVar.dIJ = 1000000060;
        this.diG = aVar.KT();
        ((aji) this.diG.dID.dIL).hcD = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 167;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            ajj ajj = (ajj) ((b) qVar).dIE.dIL;
            StringBuilder append = new StringBuilder("onGYNetEnd new version:").append(ajj.hcD).append(" old version:");
            au.HU();
            x.d("MicroMsg.NetSceneGetVUserInfo", append.append(bi.f((Integer) c.DT().get(66053, null))).append(" Count:").append(ajj.rMl.size()).toString());
            au.HU();
            c.DT().set(66053, Integer.valueOf(ajj.hcD));
            if (ajj.rMl.size() <= 0) {
                this.diJ.a(i2, i3, str, this);
                return;
            }
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < ajj.rMl.size()) {
                    i4 |= ((bxj) ajj.rMl.get(i6)).bzI;
                    i5 = i6 + 1;
                } else {
                    au.HU();
                    c.DT().set(66052, Integer.valueOf(i4));
                    this.diJ.a(i2, i3, str, this);
                    this.oqY = ajj.rMl.size() - 1;
                    this.dHa.J(50, 50);
                    return;
                }
            }
        }
        x.e("MicroMsg.NetSceneGetVUserInfo", "errType:" + i2 + " errCode:" + i3);
        this.diJ.a(i2, i3, str, this);
    }

    static boolean a(int i, boolean z, byte[] bArr) {
        Throwable e;
        Throwable th;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(com.tencent.mm.model.am.a.dBt.w(i, z));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (Exception e2) {
                }
                return true;
            } catch (Exception e3) {
                e = e3;
                try {
                    x.printErrStackTrace("MicroMsg.NetSceneGetVUserInfo", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Exception e4) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            x.printErrStackTrace("MicroMsg.NetSceneGetVUserInfo", e, "", new Object[0]);
            if (fileOutputStream != null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (Exception e42) {
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e52) {
                }
            }
            throw th;
        }
    }
}
