package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bea;
import com.tencent.mm.protocal.c.bws;
import com.tencent.mm.protocal.c.byo;
import com.tencent.mm.protocal.c.byt;
import com.tencent.mm.protocal.c.ow;
import com.tencent.mm.protocal.c.ox;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    public static int oua = 1;
    public static int oub = 2;
    public static int ouc = 3;
    private String bZR;
    private b dIy;
    private e lCQ;
    private String mFileName;
    public int mState = -1;
    private String otU;
    private int otV;
    private byo otW;
    private long otX;
    private int otY;
    private String otZ;
    public byt oud;
    public bws oue;
    public bea ouf;
    int oug;

    public a(String str, int i, String str2) {
        a(str, i, -1, -1, str2, 0, "", "");
    }

    public a(String str, int i, int i2, long j, String str2) {
        a(str, i, i2, j, str2, 0, "", "");
    }

    public a(String str, int i, String str2, int i2, String str3, String str4) {
        a(str, i, -1, -1, str2, i2, str3, str4);
    }

    public a(String str, int i, int i2, long j, String str2, int i3, String str3, String str4) {
        a(str, i, i2, j, str2, i3, str3, str4);
    }

    private void a(String str, int i, int i2, long j, String str2, int i3, String str3, String str4) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new ow();
        aVar.dIH = new ox();
        aVar.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
        aVar.dIF = 546;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.mFileName = str2;
        this.dIy = aVar.KT();
        x.i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)});
        if (i2 >= 0) {
            this.otW = d.aI(i2, str2);
        }
        if (j > 0) {
            this.otX = j;
        }
        this.otU = str;
        this.otV = i;
        this.otY = i3;
        this.otZ = str3;
        this.bZR = str4;
    }

    public final int getType() {
        return 546;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.lCQ = eVar2;
        ow owVar = (ow) this.dIy.dID.dIL;
        owVar.rsZ = this.otU;
        owVar.rdV = this.otV;
        owVar.rta = this.otW;
        owVar.rcq = this.otX;
        owVar.otY = this.otY;
        owVar.jTv = this.otZ;
        owVar.jTu = this.bZR;
        return a(eVar, this.dIy, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            ox oxVar = (ox) this.dIy.dIE.dIL;
            if (oxVar != null) {
                this.oud = oxVar.rtb;
                this.mState = oxVar.hcd;
                this.oue = oxVar.rtc;
                this.ouf = oxVar.rtd;
                this.oug = oxVar.rte;
            } else {
                return;
            }
        }
        x.i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), this.otU});
        this.lCQ.a(i2, i3, str, this);
    }

    public final boolean bGC() {
        return (this.oud == null || bi.oW(this.oud.suF)) ? false : true;
    }
}
