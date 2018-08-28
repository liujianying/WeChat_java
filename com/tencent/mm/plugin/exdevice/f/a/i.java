package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.model.au;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.aje;
import com.tencent.mm.protocal.c.ajf;
import com.tencent.mm.protocal.c.bre;
import com.tencent.mm.protocal.c.cig;
import com.tencent.mm.protocal.c.cih;
import com.tencent.mm.protocal.c.kc;
import com.tencent.mm.protocal.c.xj;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i extends a<aje, ajf> {
    public String appName;
    public String bhd;
    private final WeakReference<b<i>> isV;
    public List<bre> ixA;
    public List<cih> ixB;
    public cig ixC;
    public ArrayList<String> ixD;
    public List<xj> ixE;
    public List<kc> ixF;
    public boolean ixG;
    public int ixH;
    public boolean ixI;
    public String ixv;
    public String ixw;
    public String ixx;
    public String ixy;
    public String ixz;
    public String username;

    protected final /* synthetic */ com.tencent.mm.bk.a aGw() {
        return new aje();
    }

    protected final /* synthetic */ com.tencent.mm.bk.a aGx() {
        return new ajf();
    }

    protected final /* bridge */ /* synthetic */ void g(com.tencent.mm.bk.a aVar) {
        aje aje = (aje) aVar;
        aje.iEL = this.appName;
        aje.username = this.username;
    }

    public i(String str, String str2, b<i> bVar) {
        x.d("MicroMsg.NetSceneGetProfileDetail", "appusername: %s, username: %s", new Object[]{str2, str});
        this.username = str;
        this.appName = str2;
        this.isV = new WeakReference(bVar);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        super.a(i, i2, i3, str, qVar, bArr);
        x.d("MicroMsg.NetSceneGetProfileDetail", "hy: getdetail scene gy end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            ajf ajf = (ajf) asj();
            this.ixw = ajf.rLQ;
            this.ixx = ajf.ixx;
            this.ixB = ajf.rLT;
            this.ixC = ajf.rLR;
            this.ixy = ajf.rLV;
            this.bhd = ajf.bhd;
            this.ixz = ajf.rLW;
            this.ixA = ajf.rcK;
            this.ixG = ajf.ixG;
            this.ixE = ajf.rch;
            this.ixF = ajf.rLX;
            this.ixD = new ArrayList();
            this.ixH = ajf.iEk;
            this.ixI = ajf.rLY;
            this.ixv = ajf.ixv;
            if (ajf.rLU != null) {
                this.ixD.addAll(ajf.rLU);
            }
            this.ixA = new LinkedList();
            if (ajf.rcK != null) {
                this.ixA.addAll(ajf.rcK);
            }
            if (!(this.username == null || this.username.equalsIgnoreCase(com.tencent.mm.model.q.GF()))) {
                if (this.ixG) {
                    com.tencent.mm.plugin.exdevice.f.b.b.a aHg = ad.aHg();
                    String str2 = this.username;
                    if (aHg.a(new com.tencent.mm.plugin.exdevice.f.b.b("hardcode_rank_id", "hardcode_app_name", str2)) == null) {
                        c cVar = new c();
                        cVar.field_rankID = "hardcode_rank_id";
                        cVar.field_appusername = "hardcode_app_name";
                        cVar.field_username = str2;
                        cVar.field_step = 0;
                        aHg.b(cVar);
                    }
                } else {
                    ad.aHg().Ag(this.username);
                }
            }
            if (ajf.rch != null) {
                List arrayList = new ArrayList();
                Iterator it = ajf.rch.iterator();
                while (it.hasNext()) {
                    xj xjVar = (xj) it.next();
                    au.HU();
                    if (com.tencent.mm.model.c.FR().Yc(xjVar.username)) {
                        c cVar2 = new c();
                        cVar2.field_username = xjVar.username;
                        cVar2.field_step = xjVar.fHo;
                        arrayList.add(cVar2);
                    } else {
                        au.DF().a(new h(xjVar.username, null), 0);
                    }
                }
                x.d("MicroMsg.NetSceneGetProfileDetail", "follows %d %s", new Object[]{Integer.valueOf(arrayList.size()), arrayList.toString()});
                if (com.tencent.mm.model.q.GF().equalsIgnoreCase(this.username)) {
                    ad.aHg().aS(arrayList);
                }
            }
            this.ixF = new ArrayList();
            if (ajf.rLX != null) {
                this.ixF.addAll(ajf.rLX);
            }
            this.ixG = ajf.ixG;
            com.tencent.mm.plugin.exdevice.f.b.a.a aVar = new com.tencent.mm.plugin.exdevice.f.b.a.a();
            aVar.field_championMotto = this.ixx;
            aVar.field_championUrl = this.ixw;
            aVar.field_username = this.username;
            LinkedList linkedList = ajf.rcK;
            ad.aHi().a(aVar);
        }
        b bVar = (b) this.isV.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmbiz-bin/rank/getuserrankdetail";
    }

    public final int getType() {
        return 1043;
    }
}
