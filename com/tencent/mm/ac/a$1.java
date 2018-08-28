package com.tencent.mm.ac;

import com.tencent.mm.ab.l;
import com.tencent.mm.ac.p.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.hq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.lang.ref.WeakReference;
import java.util.List;

class a$1 implements a<p> {
    final /* synthetic */ a dKA;
    final /* synthetic */ WeakReference dKz;
    final /* synthetic */ String dhF;

    a$1(a aVar, WeakReference weakReference, String str) {
        this.dKA = aVar;
        this.dKz = weakReference;
        this.dhF = str;
    }

    public final /* synthetic */ void b(int i, int i2, String str, l lVar) {
        p pVar = (p) lVar;
        x.i("MicroMsg.BizAttrRenovator", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        if (this.dKz != null) {
            this.dKz.get();
        }
        if (pVar == null) {
            x.e("MicroMsg.BizAttrRenovator", "scene == null");
        } else if (i == 0 && i2 == 0) {
            hq hqVar = (pVar.diG == null || pVar.diG.dIE.dIL == null) ? null : (hq) pVar.diG.dIE.dIL;
            if (hqVar == null) {
                x.e("MicroMsg.BizAttrRenovator", "resp is null.");
                return;
            }
            String str2 = "MicroMsg.BizAttrRenovator";
            String str3 = "[BizAttr] biz(%s) Attribute LastAttrVersion = %s, UpdateInfoList.size = %s";
            Object[] objArr = new Object[3];
            objArr[0] = this.dhF;
            objArr[1] = hqVar.riB == null ? null : new String(hqVar.riB.lR);
            objArr[2] = Integer.valueOf(hqVar.riC == null ? 0 : hqVar.riC.size());
            x.i(str2, str3, objArr);
            if (hqVar.riC == null) {
                x.e("MicroMsg.BizAttrRenovator", "[BizAttr] resp.UpdateInfoList null");
                return;
            }
            boolean z;
            String str4 = this.dhF;
            List list = hqVar.riC;
            if (bi.oW(str4)) {
                x.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, username is null.");
                z = false;
            } else {
                d kA = z.MY().kA(str4);
                if (a.b(kA)) {
                    ab Yg = ((i) g.l(i.class)).FR().Yg(str4);
                    if (Yg == null || ((int) Yg.dhP) == 0 || !Yg.ckW()) {
                        x.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact do not exist.(username : %s)", new Object[]{str4});
                        z = false;
                    } else {
                        if (bi.oW(Yg.field_username)) {
                            Yg.setUsername(str4);
                        }
                        z = a.a(Yg, kA, list);
                    }
                } else {
                    x.i("MicroMsg.BizAttrRenovator", "Do not need to update bizAttrs now.(username : %s)", new Object[]{str4});
                    z = false;
                }
            }
            if (!z) {
                x.i("MicroMsg.BizAttrRenovator", "notifyDataSetChanged, after updateBizAttributes.");
            } else if (hqVar.riB != null) {
                z = (bi.oW(this.dhF) || bi.oW(bi.bE(hqVar.riB.lR))) ? false : z.MY().fV("BizInfo", String.format("update %s set %s='%s', %s=%d where %s='%s'", new Object[]{"BizInfo", "attrSyncVersion", bi.bE(hqVar.riB.lR), "incrementUpdateTime", Long.valueOf(System.currentTimeMillis()), "username", this.dhF}));
                x.i("MicroMsg.BizAttrRenovator", "Update attrSyncVersion of bizInfo succ = %b.", new Object[]{Boolean.valueOf(z)});
            }
        } else {
            x.e("MicroMsg.BizAttrRenovator", "scene.getType() = %s", new Object[]{Integer.valueOf(pVar.getType())});
        }
    }
}
