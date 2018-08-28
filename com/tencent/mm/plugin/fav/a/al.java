package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.auj;
import com.tencent.mm.protocal.c.auk;
import com.tencent.mm.protocal.c.aul;
import com.tencent.mm.protocal.c.aum;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class al extends l implements k {
    private final b diG;
    private e diJ;
    public int iXb;
    public f iXc;
    private LinkedList<aum> iXd;
    private LinkedList<auj> iXe;
    public String iXf;
    private int scene;
    public int type;

    private al(int i, LinkedList<auj> linkedList, LinkedList<aum> linkedList2, int i2) {
        this.diJ = null;
        a aVar = new a();
        aVar.dIG = new auk();
        aVar.dIH = new aul();
        aVar.uri = "/cgi-bin/micromsg-bin/modfavitem";
        aVar.dIF = 426;
        aVar.dII = 216;
        aVar.dIJ = 1000000216;
        this.diG = aVar.KT();
        this.iXd = linkedList2;
        this.iXe = linkedList;
        this.iXb = i;
        this.type = i2;
    }

    public al(int i, LinkedList<auj> linkedList, LinkedList<aum> linkedList2) {
        this(i, (LinkedList) linkedList, (LinkedList) linkedList2, 0);
    }

    public al(int i, f fVar) {
        this(i, fVar.field_modItem.iXe, fVar.field_modItem.rBr, 1);
        this.iXc = fVar;
    }

    public al(int i, LinkedList<auj> linkedList, LinkedList<aum> linkedList2, String str) {
        this(i, (LinkedList) linkedList, (LinkedList) linkedList2, 0);
        this.iXf = str;
    }

    public al(int i, LinkedList<auj> linkedList, LinkedList<aum> linkedList2, String str, byte b) {
        this(i, (LinkedList) linkedList, (LinkedList) linkedList2, 0);
        this.iXf = str;
        this.scene = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.scene == 0 && (this.iXe == null || this.iXe.size() == 0)) {
            return -1;
        }
        auk auk = (auk) this.diG.dID.dIL;
        auk.rXC = this.iXe.size();
        if (this.iXd != null) {
            auk.rXE = this.iXd.size();
            auk.rgH = this.iXd;
        } else {
            auk.rXE = 0;
            auk.rgH = new LinkedList();
        }
        if (!bi.oW(this.iXf)) {
            auk.rXF = this.iXf;
        }
        auk.rXC = this.iXe.size();
        auk.rXD = this.iXe;
        auk.rbY = this.iXb;
        auk.otY = this.scene;
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final long aLO() {
        if (this.iXc == null) {
            return -1;
        }
        return this.iXc.field_localId;
    }

    public final int aLP() {
        if (this.iXc == null) {
            return -1;
        }
        return this.iXc.field_type;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.Fav.NetSceneModFavItem", "favId: " + this.iXb + ", netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.diJ.a(i2, i3, str, this);
        b.d(((ae) g.n(ae.class)).getFavItemInfoStorage().dz((long) this.iXb));
    }

    public final int getType() {
        return 426;
    }
}
