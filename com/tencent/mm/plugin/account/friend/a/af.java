package com.tencent.mm.plugin.account.friend.a;

import android.text.TextUtils;
import com.tencent.mm.aa.c;
import com.tencent.mm.aa.j;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.ald;
import com.tencent.mm.protocal.c.ale;
import com.tencent.mm.protocal.c.ard;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class af extends l implements k {
    private final b diG;
    private e diJ;
    private String eIe;
    private HashMap<String, n> eIh = new HashMap();
    private ArrayList<n> eLc;
    private int eLd;
    private int eLe;
    private int eLf;
    private int eLg;

    public af(ArrayList<n> arrayList, int i, HashMap<String, n> hashMap, String str) {
        a aVar = new a();
        aVar.dIG = new ard();
        aVar.dIH = new are();
        aVar.uri = "/cgi-bin/micromsg-bin/listgooglecontact";
        aVar.dIF = 488;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.eLc = arrayList;
        this.eLd = i;
        this.eLe = 0;
        this.eLg = 1;
        this.eIh = hashMap;
        this.eIe = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene");
        this.diJ = eVar2;
        ard ard = (ard) this.diG.dID.dIL;
        if (this.eLc != null) {
            LinkedList linkedList = new LinkedList();
            this.eLf = this.eLc.size();
            int i = this.eLe;
            while (true) {
                int i2 = i;
                if (i2 >= this.eLf || i2 >= this.eLe + 500) {
                    ard.hbG = linkedList;
                    ard.hbF = linkedList.size();
                } else {
                    ale ale = new ale();
                    ale.rhh = ((n) this.eLc.get(i2)).field_googlegmail;
                    linkedList.add(ale);
                    i = i2 + 1;
                }
            }
            ard.hbG = linkedList;
            ard.hbF = linkedList.size();
            if (this.eLe + 500 > this.eLf) {
                this.eLg = 0;
            } else {
                this.eLg = 1;
            }
            ard.rlm = this.eLg;
            ard.rTy = this.eLd;
            x.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doscene mTotalSize:%d, mStarIndex:%d, mContinueFlag:%d", new Object[]{Integer.valueOf(this.eLf), Integer.valueOf(this.eLe), Integer.valueOf(this.eLg)});
        }
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            a(XQ());
            if (this.eLg == 1) {
                this.eLe += 500;
                if (a(this.dIX, this.diJ) < 0) {
                    x.e("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene again failed");
                    this.diJ.a(3, -1, "", this);
                }
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final are XQ() {
        return (are) this.diG.dIE.dIL;
    }

    private synchronized void a(are are) {
        x.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "handleListGoogleContactCGIResponse Count:%d", new Object[]{Integer.valueOf(are.hbF)});
        if (are.hbG != null && are.hbG.size() > 0) {
            int size = are.hbG.size();
            ArrayList arrayList = new ArrayList();
            List linkedList = new LinkedList();
            for (int i = 0; i < size; i++) {
                int i2;
                ald ald = (ald) are.hbG.get(i);
                if (TextUtils.isEmpty(ald.hbL)) {
                    i2 = 1;
                } else {
                    ab Yg = ((i) g.l(i.class)).FR().Yg(ald.hbL);
                    i2 = (Yg == null || !com.tencent.mm.l.a.gd(Yg.field_type)) ? 0 : 2;
                }
                if (this.eIh != null && this.eIh.containsKey(ald.rhh)) {
                    n nVar = (n) this.eIh.get(ald.rhh);
                    nVar.field_username = ald.hbL;
                    nVar.field_nickname = ald.hcS;
                    nVar.field_usernamepy = h.oJ(ald.hcS);
                    nVar.field_nicknameqp = h.oI(ald.hcS);
                    nVar.field_ret = ald.rfn;
                    nVar.field_small_url = ald.rNV;
                    nVar.field_big_url = ald.rNU;
                    nVar.field_status = i2;
                    nVar.field_googlecgistatus = 2;
                    if (i2 == 2 || i2 == 0) {
                        nVar.field_contecttype = "weixin" + i;
                    } else {
                        nVar.field_contecttype = "google";
                    }
                    nVar.field_googlenamepy = h.oJ(nVar.field_googlename);
                    arrayList.add(nVar);
                    Object obj = nVar.field_googleid;
                    String str = nVar.field_googlephotourl;
                    String str2 = this.eIe;
                    if (!(TextUtils.isEmpty(obj) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
                        String str3 = obj + "@google";
                        j kc = com.tencent.mm.aa.q.KH().kc(str3);
                        if (kc == null) {
                            kc = new j();
                        }
                        kc.username = str3;
                        kc.csA = 3;
                        kc.dHR = c.ac(str, str2);
                        kc.dHQ = c.ac(str, str2);
                        kc.by(true);
                        kc.bWA = 31;
                        com.tencent.mm.aa.q.KH().a(kc);
                    }
                    com.tencent.mm.storage.g.a aVar = new com.tencent.mm.storage.g.a();
                    aVar.field_userName = ald.hbL;
                    aVar.field_scene = 58;
                    aVar.field_ticket = ald.rEJ;
                    linkedList.add(aVar);
                }
            }
            ((o) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).h(arrayList);
            com.tencent.mm.plugin.d.a.ZN().Gw().cZ(linkedList);
        }
    }

    public final int getType() {
        return 488;
    }

    protected final int Cc() {
        return 20;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }
}
