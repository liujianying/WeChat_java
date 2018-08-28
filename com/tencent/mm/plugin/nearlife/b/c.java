package com.tencent.mm.plugin.nearlife.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aez;
import com.tencent.mm.protocal.c.afa;
import com.tencent.mm.protocal.c.aqq;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public final class c extends l implements k {
    public static Vector<String> lCS = new Vector();
    public int bNI = 0;
    private final b diG;
    private e diJ;
    public String fuu = "";
    public int kCL;
    public String lCT = "";
    public String lCU = "";
    public List<a> lCV;
    public boolean lCW;

    public static boolean tS(int i) {
        String valueOf = String.valueOf(i);
        if (lCS.contains(valueOf)) {
            return false;
        }
        lCS.add(valueOf);
        return true;
    }

    public static boolean tT(int i) {
        lCS.remove(String.valueOf(i));
        return true;
    }

    public static void clear() {
        lCS.clear();
    }

    public c(int i, int i2, float f, float f2, int i3, int i4, String str, String str2, bhy bhy, String str3, int i5, boolean z) {
        this.lCT = str3;
        if (!(i == 0 || i == 1)) {
            x.e("MicroMsg.NetSceneGetLbsLifeList", "OpCode Error :" + i);
        }
        this.bNI = i;
        a aVar = new a();
        aVar.dIG = new aez();
        aVar.dIH = new afa();
        aVar.uri = "/cgi-bin/micromsg-bin/getlbslifelist";
        aVar.dIF = Downloads.DOWNLOAD_ERR_UNKNOWN_HOST;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aez aez = (aez) this.diG.dID.dIL;
        aqr aqr = new aqr();
        aqr.ryX = str2;
        aqr.ryY = i4;
        aqr.rms = f2;
        aqr.rmr = f;
        aqr.ryW = str;
        aqr.ryV = i3;
        aez.rva = aqr;
        aez.rDH = str3;
        aez.otY = i2;
        aez.rIX = i5;
        if (bhy == null) {
            aez.rIW = new bhy().bq(new byte[0]);
        } else {
            aez.rIW = bhy;
        }
        aez.rfe = i;
        aez.rIY = 1;
        this.lCW = z;
        x.d("MicroMsg.NetSceneGetLbsLifeList", "Req: opcode:" + i + " lon:" + f + " lat:" + f2 + " pre:" + i3 + " gpsSource:" + i4 + " mac" + str + " cell:" + str2 + " scene: " + i2 + " entryTime: " + i5);
        x.d("MicroMsg.NetSceneGetLbsLifeList", "isLoadMore: %s, buf: %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(aez.rIW.siI)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return Downloads.DOWNLOAD_ERR_UNKNOWN_HOST;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetLbsLifeList", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        afa afa = (afa) ((b) qVar).dIE.dIL;
        this.fuu = afa.rlo;
        this.kCL = afa.rJg;
        x.d("MicroMsg.NetSceneGetLbsLifeList", "resp " + afa.rJd + "searchId " + this.fuu);
        int i4 = (i3 == 0 || i3 == 101) ? 1 : 0;
        if (i2 == 0 || i4 != 0) {
            x.d("MicroMsg.NetSceneGetLbsLifeList", "continueFlag %d lifeCount %d linkCount %d %s", new Object[]{Integer.valueOf(afa.rlm), Integer.valueOf(afa.rJd), Integer.valueOf(afa.rJb), afa.rJf});
            this.lCU = bi.aG(afa.rJf, "");
            this.lCV = new ArrayList();
            Iterator it = afa.rJe.iterator();
            while (it.hasNext()) {
                this.lCV.add(new a(afa.rlo, (aqq) it.next()));
            }
            if (afa.rJd > 0) {
                aqq aqq = (aqq) afa.rJe.get(0);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(" Bid " + aqq.lCG);
                stringBuffer.append(" title " + aqq.bHD);
                stringBuffer.append(" link " + aqq.lCN);
                stringBuffer.append(" price " + aqq.lCH);
                stringBuffer.append(" rate " + aqq.lCM);
                stringBuffer.append(" type " + aqq.hcE);
                stringBuffer.append(" desc : ");
                it = aqq.lCL.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(((bhz) it.next()).siM + "-");
                }
                x.d("MicroMsg.NetSceneGetLbsLifeList", "resp one %s ", new Object[]{stringBuffer.toString()});
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final bhy biW() {
        bhy bhy = ((afa) this.diG.dIE.dIL).rIW;
        return bhy == null ? new bhy().bq(new byte[0]) : bhy;
    }

    public final int biX() {
        return ((afa) this.diG.dIE.dIL).rlm;
    }
}
