package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.arr;
import com.tencent.mm.protocal.c.atu;
import com.tencent.mm.protocal.c.bwc;
import com.tencent.mm.protocal.c.bwd;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class al extends l implements k {
    private int bOh;
    private e diJ;
    public final List<String> eLj;
    public final List<String> eLk;
    private final String eLl = ((String) g.Ei().DT().get(6, null));
    private int eLm = 0;
    private int eLn = 0;

    public al(List<String> list, List<String> list2) {
        this.eLj = list;
        this.eLk = list2;
        this.bOh = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 0;
        this.diJ = eVar2;
        if ((this.eLj == null || this.eLj.size() == 0) && (this.eLk == null || this.eLk.size() == 0)) {
            x.i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
            return -1;
        }
        a aVar = new a();
        aVar.dIG = new bwc();
        aVar.dIH = new bwd();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
        aVar.dIF = 133;
        aVar.dII = 0;
        aVar.dIJ = 0;
        b KT = aVar.KT();
        bwc bwc = (bwc) KT.dID.dIL;
        bwc.rhu = this.eLl;
        bwc.hbL = q.GF();
        bwc.rfe = this.bOh;
        int i2 = 200;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        while (i2 > 0) {
            if (this.eLj != null && this.eLm < this.eLj.size()) {
                if (this.eLj.get(this.eLm) != null) {
                    atu atu = new atu();
                    atu.v = (String) this.eLj.get(this.eLm);
                    linkedList.add(atu);
                }
                this.eLm++;
                i2--;
            }
            if (this.eLk != null && this.eLn < this.eLk.size()) {
                if (this.eLk.get(this.eLn) != null) {
                    arr arr = new arr();
                    arr.v = (String) this.eLk.get(this.eLn);
                    linkedList2.add(arr);
                }
                this.eLn++;
                i2--;
            }
            if ((this.eLk == null || this.eLn >= this.eLk.size()) && (this.eLj == null || this.eLm >= this.eLj.size())) {
                break;
            }
        }
        bwc.rTA = linkedList;
        bwc.sss = linkedList.size();
        bwc.ssu = linkedList2;
        bwc.sst = linkedList2.size();
        String str = "MicroMsg.NetSceneUploadMContact";
        StringBuilder append = new StringBuilder("doscene in:[").append(this.eLk == null ? 0 : this.eLk.size()).append(",");
        if (this.eLj != null) {
            i = this.eLj.size();
        }
        x.v(str, append.append(i).append("] index:[").append(this.eLn).append(",").append(this.eLm).append("] req:[").append(bwc.ssu.size()).append(",").append(bwc.rTA.size()).append("]").toString());
        return a(eVar, KT, this);
    }

    public final boolean KX() {
        return true;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        bwc bwc = (bwc) ((b) qVar).dID.dIL;
        int size = bwc.ssu.size() + bwc.rTA.size();
        if (size == 0 || size > 200) {
            x.e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
            return l.b.dJn;
        } else if (bwc.rhu == null || bwc.rhu.length() <= 0) {
            x.e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
            return l.b.dJn;
        } else if (bwc.hbL != null && bwc.hbL.length() > 0) {
            return l.b.dJm;
        } else {
            x.e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
            return l.b.dJn;
        }
    }

    protected final int Cc() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadMContact", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (i2 == 0 && i3 == 0) {
            bwc bwc = (bwc) ((b) qVar).dID.dIL;
            l.ad(af(bwc.ssu));
            l.ad(ag(bwc.rTA));
            if ((this.eLk == null || this.eLn >= this.eLk.size()) && (this.eLj == null || this.eLm >= this.eLj.size())) {
                this.diJ.a(i2, i3, str, this);
                return;
            } else if (a(this.dIX, this.diJ) < 0) {
                this.diJ.a(i2, i3, str, this);
                return;
            } else {
                return;
            }
        }
        x.e("MicroMsg.NetSceneUploadMContact", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.diJ.a(i2, i3, str, this);
    }

    private static List<String> af(List<arr> list) {
        List<String> arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.NetSceneUploadMContact", "the req emai list is empty");
            return arrayList;
        }
        for (arr arr : list) {
            arrayList.add(arr.v);
        }
        return arrayList;
    }

    private static List<String> ag(List<atu> list) {
        List<String> arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.NetSceneUploadMContact", "the req mobile list is empty");
            return arrayList;
        }
        for (atu atu : list) {
            arrayList.add(com.tencent.mm.a.g.u(com.tencent.mm.pluginsdk.a.pK(atu.v).getBytes()));
        }
        return arrayList;
    }

    public final int getType() {
        return 133;
    }
}
