package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.amu;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.ir;
import com.tencent.mm.protocal.c.yo;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h extends l implements k {
    public final b diG;
    private e diJ;
    public Object tag;

    private h() {
        this.diG = a.c(a.a(a.efe));
    }

    private h(String str, int i) {
        a aVar = a.efd;
        if (aVar == a.efd) {
            aVar = a.R(str, i);
        }
        x.i("MicroMsg.NetSceneGetA8Key", "getCommReqRespFromReqUrl reqUrl=%s, type=%s, reason=%d", new Object[]{str, aVar, Integer.valueOf(i)});
        this.diG = a.c(a.a(aVar));
    }

    private h(a aVar) {
        this.diG = a.a(aVar);
    }

    public h(String str, String str2, String str3, int i) {
        this(a.eff);
        yo yoVar = (yo) this.diG.dID.dIL;
        yoVar.qZc = 1;
        yoVar.rEn = new bhz().VO(str);
        yoVar.rEo = new bhz().VO(str2);
        yoVar.rEp = new bhz().VO(str3);
        yoVar.rEy = i;
        x.d("MicroMsg.NetSceneGetA8Key", "get a8key appid=%s requestId=%d", new Object[]{str, Integer.valueOf(i)});
    }

    public h(String str, String str2, int i, int i2, byte[] bArr) {
        this(str, 0);
        yo yoVar = (yo) this.diG.dID.dIL;
        yoVar.qZc = 2;
        yoVar.rEq = new bhz().VO(str);
        yoVar.otY = i;
        yoVar.hbL = str2;
        yoVar.rEv = 0;
        yoVar.rEy = i2;
        yoVar.rEB = new bhy().bq(bArr);
        x.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + str + ", username = " + str2 + ", scene = " + i + ", reason = 0, requestId = " + i2);
        x.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[]{bi.bE(bArr)});
    }

    public h(String str, int i, int i2, int i3, String str2, int i4, byte[] bArr) {
        this(str, 0);
        yo yoVar = (yo) this.diG.dID.dIL;
        yoVar.qZc = 2;
        yoVar.rEq = new bhz().VO(str);
        yoVar.otY = i;
        yoVar.hbL = null;
        yoVar.rEv = 0;
        yoVar.rrv = i2;
        yoVar.rrw = i3;
        yoVar.rEy = i4;
        yoVar.rEn = new bhz().VO(str2);
        yoVar.rEB = new bhy().bq(bArr);
        x.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + str + ", username = " + null + ", scene = " + i + ", reason = 0, codeType = " + i2 + ", codeVersion = " + i3 + ", requestId = " + i4);
        x.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[]{bi.bE(bArr)});
    }

    public h(String str, String str2, int i, int i2, int i3, String str3, int i4, String str4, String str5, int i5, byte[] bArr) {
        this(str, i2);
        yo yoVar = (yo) this.diG.dID.dIL;
        yoVar.qZc = 2;
        yoVar.rEq = new bhz().VO(str);
        yoVar.otY = i;
        yoVar.hbL = str2;
        yoVar.rEv = i2;
        yoVar.rbZ = i3;
        yoVar.rEx = str3;
        yoVar.rEy = i4;
        yoVar.rEz = str5;
        yoVar.rEA = i5;
        yoVar.rEn = new bhz().VO(str4);
        yoVar.rEB = new bhy().bq(bArr);
        x.i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s, functionId = %s, wallentRegion = %d, a8KeyCookie = %s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str3, Integer.valueOf(i4), str4, str5, Integer.valueOf(i5), bi.bE(bArr)});
    }

    public h(int i, int i2) {
        this();
        yo yoVar = (yo) this.diG.dID.dIL;
        yoVar.qZc = 3;
        yoVar.otY = 5;
        yoVar.rEs = i;
        yoVar.rEy = i2;
        x.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d requestId", new Object[]{Integer.valueOf(i), Integer.valueOf(yoVar.reB.siI), Integer.valueOf(i2)});
    }

    public final int getType() {
        return 233;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), QL(), ((yp) this.diG.dIE.dIL).rED});
        x.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie:%s", new Object[]{bi.bE(QT())});
        this.diJ.a(i2, i3, str, this);
    }

    public final String QL() {
        return ((yp) this.diG.dIE.dIL).rEC;
    }

    public final String QM() {
        bhz bhz = ((yo) this.diG.dID.dIL).rEq;
        if (bhz != null) {
            return bhz.siM;
        }
        return null;
    }

    public final String getTitle() {
        return ((yp) this.diG.dIE.dIL).bHD;
    }

    public final String getContent() {
        return ((yp) this.diG.dIE.dIL).jSA;
    }

    public final int QN() {
        return ((yp) this.diG.dIE.dIL).qZk;
    }

    public final byte[] QO() {
        yp ypVar = (yp) this.diG.dIE.dIL;
        if (ypVar.rEL == null) {
            return null;
        }
        try {
            return ab.a(ypVar.rEL);
        } catch (Exception e) {
            return null;
        }
    }

    public final String getShareUrl() {
        return ((yp) this.diG.dIE.dIL).rEG;
    }

    public final ArrayList<byte[]> QP() {
        yp ypVar = (yp) this.diG.dIE.dIL;
        ArrayList<byte[]> arrayList = new ArrayList();
        if (ypVar == null || ypVar.rEI == null) {
            return arrayList;
        }
        Iterator it = ypVar.rEI.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(((ir) it.next()).toByteArray());
            } catch (Throwable e) {
                x.e("MicroMsg.NetSceneGetA8Key", "exception:%s", new Object[]{bi.i(e)});
            }
        }
        x.d("MicroMsg.NetSceneGetA8Key", "ScopeList size = %s", new Object[]{Integer.valueOf(arrayList.size())});
        return arrayList;
    }

    public final long QQ() {
        yp ypVar = (yp) this.diG.dIE.dIL;
        return ypVar.rEK != null ? ypVar.rEK.rvh : -1;
    }

    public final List<amu> QR() {
        return ((yp) this.diG.dIE.dIL).rEN;
    }

    public final int QS() {
        return ((yo) this.diG.dID.dIL).rEy;
    }

    public final byte[] QT() {
        yp ypVar = (yp) this.diG.dIE.dIL;
        if (ypVar.rEB == null) {
            return new byte[0];
        }
        try {
            return ab.a(ypVar.rEB);
        } catch (Exception e) {
            return new byte[0];
        }
    }
}
