package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.model.au;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.f.b.a.e;
import com.tencent.mm.plugin.exdevice.f.b.f;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.ajg;
import com.tencent.mm.protocal.c.ajh;
import com.tencent.mm.protocal.c.cie;
import com.tencent.mm.protocal.c.cif;
import com.tencent.mm.protocal.c.xj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class j extends a<ajg, ajh> {
    public String appName;
    public boolean ixI;
    public boolean ixJ;
    public String ixK;
    public String ixL;
    public com.tencent.mm.plugin.exdevice.f.b.a.a ixM;
    public ArrayList<d> ixN;
    public ArrayList<c> ixO;
    public ArrayList<e> ixP;
    public ArrayList<String> ixQ;
    public String ixR;
    public String ixS;
    public boolean ixT;
    public boolean ixU;
    public String ixV;
    private final WeakReference<b<j>> ixW;
    public a ixX;
    public String ixy;
    public String ixz;

    protected final /* synthetic */ com.tencent.mm.bk.a aGw() {
        return new ajg();
    }

    protected final /* synthetic */ com.tencent.mm.bk.a aGx() {
        return new ajh();
    }

    protected final /* bridge */ /* synthetic */ void g(com.tencent.mm.bk.a aVar) {
        ajg ajg = (ajg) aVar;
        ajg.iEL = this.appName;
        ajg.dxc = this.ixK;
        ajg.rLZ = this.ixJ;
        ajg.rMa = this.ixL;
    }

    public j(String str, String str2, String str3, boolean z, b<j> bVar) {
        this.ixW = new WeakReference(bVar);
        this.ixR = str;
        this.ixK = str;
        this.appName = bi.oV(str2);
        this.ixJ = z;
        this.ixL = str3;
    }

    public final int getType() {
        return 1042;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetRankInfo", "hy: get rank info end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            Iterator it;
            String str2;
            String str3;
            Object obj;
            String str4;
            com.tencent.mm.plugin.exdevice.f.b.a.a aVar;
            ajh ajh = (ajh) asj();
            String str5 = "";
            this.ixO = new ArrayList();
            if (ajh.rch != null) {
                it = ajh.rch.iterator();
                while (it.hasNext()) {
                    xj xjVar = (xj) it.next();
                    au.HU();
                    if (com.tencent.mm.model.c.FR().Yc(xjVar.username)) {
                        str2 = ajh.dxc;
                        str3 = this.appName;
                        if (bi.oW(str2) || xjVar == null) {
                            x.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                            obj = null;
                        } else {
                            c cVar = new c();
                            cVar.field_rankID = str2;
                            cVar.field_username = xjVar.username;
                            cVar.field_step = xjVar.fHo;
                            cVar.field_appusername = str3;
                            c obj2 = cVar;
                        }
                        if (obj2 != null) {
                            this.ixO.add(obj2);
                        }
                    } else {
                        au.DF().a(new h(xjVar.username, null), 0);
                    }
                }
            }
            this.ixN = new ArrayList();
            if (ajh.rMb != null) {
                it = ajh.rMb.iterator();
                while (it.hasNext()) {
                    d dVar;
                    cie cie = (cie) it.next();
                    str2 = ajh.dxc;
                    str3 = this.appName;
                    if (bi.oW(str2) || cie == null) {
                        x.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                        dVar = null;
                    } else {
                        dVar = new d();
                        dVar.field_appusername = str3;
                        dVar.field_rankID = str2;
                        dVar.field_likecount = cie.sCe;
                        dVar.field_ranknum = cie.sCd;
                        dVar.field_score = cie.score;
                        dVar.field_selfLikeState = cie.sCf;
                        dVar.field_username = cie.username;
                    }
                    if (dVar != null) {
                        if (dVar.field_ranknum == 1) {
                            str4 = dVar.field_username;
                        } else {
                            str4 = str5;
                        }
                        this.ixN.add(dVar);
                        str5 = str4;
                    }
                }
            }
            this.ixP = new ArrayList();
            if (ajh.rMc != null) {
                it = ajh.rMc.iterator();
                while (it.hasNext()) {
                    cif cif = (cif) it.next();
                    str2 = ajh.dxc;
                    str3 = this.appName;
                    if (bi.oW(str2) || cif == null) {
                        x.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                        obj2 = null;
                    } else {
                        e eVar = new e();
                        eVar.field_appusername = str3;
                        eVar.field_rankID = str2;
                        eVar.field_timestamp = cif.timestamp;
                        eVar.field_username = cif.username;
                        e eVar2 = eVar;
                    }
                    if (obj2 != null) {
                        this.ixP.add(obj2);
                    }
                }
            }
            this.ixQ = new ArrayList();
            if (ajh.rLU != null) {
                Iterator it2 = ajh.rLU.iterator();
                while (it2.hasNext()) {
                    this.ixQ.add((String) it2.next());
                }
            }
            if (!bi.oW(this.ixL)) {
                str5 = this.ixL;
            }
            String str6 = ajh.rMd;
            String str7 = ajh.rMe;
            if (bi.oW(str5)) {
                x.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                aVar = null;
            } else {
                aVar = new com.tencent.mm.plugin.exdevice.f.b.a.a();
                aVar.field_username = str5;
                aVar.field_championUrl = str6;
                aVar.field_championMotto = str7;
            }
            this.ixM = aVar;
            this.ixR = ajh.dxc;
            this.ixz = ajh.rLW;
            this.ixy = ajh.rLV;
            this.ixS = ajh.rMf;
            this.ixT = ajh.ixT;
            this.ixU = ajh.rMi == 1;
            this.ixV = ajh.rMj;
            this.ixI = ajh.rLY;
            x.d("MicroMsg.NetSceneGetRankInfo", "hy: get score info ok.");
            if (this.ixK == null || !this.ixK.equals(this.ixR)) {
                f fVar = ad.aHm().iye;
                if (fVar != null) {
                    fVar.Ae(this.ixR);
                }
            }
            if (this.ixX != null && this.ixJ) {
                this.ixX.a(this);
            }
            if (this.ixJ) {
                ad.aHg().aS(this.ixO);
            }
            com.tencent.mm.plugin.exdevice.f.b.b.d aHf = ad.aHf();
            if (bi.oW(this.ixR)) {
                x.w("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId failed, rankId is null or nil.");
            } else {
                int delete = aHf.diF.delete("HardDeviceRankInfo", "rankID = ? ", new String[]{this.ixR});
                x.i("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId (%s).(r : %d)", new Object[]{str4, Integer.valueOf(delete)});
            }
            ad.aHf().e(this.ixR, this.ixN);
            str4 = "MicroMsg.NetSceneGetRankInfo";
            str5 = "isCacheExist(%s), RankFollowInfo size(%s), RankInfo size(%d), LikeInfo size(%d).";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(this.ixT);
            objArr[1] = Integer.valueOf(this.ixO != null ? this.ixO.size() : 0);
            objArr[2] = Integer.valueOf(this.ixN != null ? this.ixN.size() : 0);
            objArr[3] = Integer.valueOf(this.ixP != null ? this.ixP.size() : 0);
            x.i(str4, str5, objArr);
            ad.aHj().a(this.ixR, this.appName, this.ixP);
            if (this.ixM != null) {
                ad.aHi().a(this.ixM);
            }
        }
        super.a(i, i2, i3, str, qVar, bArr);
        b bVar = (b) this.ixW.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmbiz-bin/rank/getuserranklike";
    }
}
