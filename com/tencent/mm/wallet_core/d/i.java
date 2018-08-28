package com.tencent.mm.wallet_core.d;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave$RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.a;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class i implements e, e {
    public String dox;
    public HashSet<l> eXE = new HashSet();
    public HashSet<l> eXF = new HashSet();
    public Dialog eXG = null;
    private Set<Integer> eXU = new HashSet();
    private f kQv = null;
    public Context mContext;
    public Bundle sy;
    private a uXM;
    private b uXN;
    public HashMap<Integer, c> uXO;

    public i(Context context, f fVar) {
        this.mContext = context;
        this.kQv = fVar;
        this.uXM = new a(this);
        this.uXN = new b(this);
        this.uXO = new HashMap();
    }

    public final void a(l lVar, boolean z) {
        q(lVar);
        this.eXE.add(lVar);
        if (z && (this.eXG == null || !(this.eXG == null || this.eXG.isShowing()))) {
            if (this.eXG != null) {
                this.eXG.dismiss();
            }
            if (this.mContext == null) {
                x.w("MicroMsg.WalletNetSceneMgr", "%s activity has destroyed!!!", new Object[]{this});
                return;
            }
            this.eXG = g.a(this.mContext, false, new 1(this));
        }
        if (af.eyh && (lVar instanceof com.tencent.mm.wallet_core.tenpay.model.i) && (((com.tencent.mm.wallet_core.tenpay.model.i) lVar).getUri().contains("authen") || ((com.tencent.mm.wallet_core.tenpay.model.i) lVar).getUri().contains("verify"))) {
            ((com.tencent.mm.wallet_core.tenpay.model.i) lVar).cDz();
        }
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(lVar, 0);
    }

    public final void a(l lVar, boolean z, int i) {
        String str;
        String str2 = "MicroMsg.WalletNetSceneMgr";
        String str3 = "this %s isShowProgress %s scene: %s dialogType %s type %s IWxSafePay %s tipDialog showing? %s";
        Object[] objArr = new Object[7];
        objArr[0] = this;
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = lVar;
        objArr[3] = Integer.valueOf(i);
        objArr[4] = Integer.valueOf(lVar.getType());
        objArr[5] = Boolean.valueOf(lVar instanceof d);
        boolean z2 = this.eXG == null || !(this.eXG == null || this.eXG.isShowing());
        objArr[6] = Boolean.valueOf(z2);
        x.i(str2, str3, objArr);
        q(lVar);
        this.eXF.add(lVar);
        if (z && (this.eXG == null || !(this.eXG == null || this.eXG.isShowing()))) {
            if (this.eXG != null) {
                this.eXG.dismiss();
            }
            Context context;
            if (this.mContext == null) {
                x.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
                return;
            } else if (i == 1) {
                if (lVar instanceof d) {
                    this.eXG = g.a(this.mContext, false, new 2(this));
                } else {
                    context = this.mContext;
                    this.mContext.getString(com.tencent.mm.plugin.wxpay.a.i.app_empty_string);
                    this.eXG = h.a(context, this.mContext.getString(com.tencent.mm.plugin.wxpay.a.i.wallet_pay_loading), false, new 3(this));
                }
            } else if (i == 2) {
                context = this.mContext;
                this.mContext.getString(com.tencent.mm.plugin.wxpay.a.i.app_empty_string);
                this.eXG = h.a(context, this.mContext.getString(com.tencent.mm.plugin.wxpay.a.i.wallet_pay_loading), false, new 4(this));
            } else if (i == 3) {
                this.eXG = g.e(this.mContext, "验证中", new 5(this));
            } else if (i == 4) {
                this.eXG = g.a(this.mContext, false, new 6(this));
            } else {
                x.i("MicroMsg.WalletNetSceneMgr", "unknown dialog type: %d", new Object[]{Integer.valueOf(i)});
                context = this.mContext;
                this.mContext.getString(com.tencent.mm.plugin.wxpay.a.i.app_empty_string);
                this.eXG = h.a(context, this.mContext.getString(com.tencent.mm.plugin.wxpay.a.i.wallet_pay_loading), false, new 7(this));
            }
        }
        if (af.eyh && (lVar instanceof com.tencent.mm.wallet_core.tenpay.model.i) && (((com.tencent.mm.wallet_core.tenpay.model.i) lVar).getUri().contains("authen") || ((com.tencent.mm.wallet_core.tenpay.model.i) lVar).getUri().contains("verify"))) {
            ((com.tencent.mm.wallet_core.tenpay.model.i) lVar).cDz();
        }
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(lVar, 0);
        str2 = "MicroMsg.WalletNetSceneMgr";
        str3 = "this %s scene url %s %s";
        objArr = new Object[3];
        objArr[0] = this;
        objArr[1] = lVar;
        if (lVar.dJd == null) {
            str = "";
        } else {
            str = lVar.dJd.getUri();
        }
        objArr[2] = str;
        x.i(str2, str3, objArr);
    }

    public final void baT() {
        l lVar;
        if (this.eXG != null) {
            this.eXG.dismiss();
            this.eXG = null;
        }
        Iterator it = this.eXE.iterator();
        while (it.hasNext()) {
            lVar = (l) it.next();
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.c(lVar);
        }
        it = this.eXF.iterator();
        while (it.hasNext()) {
            lVar = (l) it.next();
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.c(lVar);
        }
        this.eXE.clear();
        this.eXF.clear();
    }

    public final void jr(int i) {
        this.eXU.add(Integer.valueOf(i));
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(i, this);
    }

    public final void js(int i) {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(i, this);
        this.eXU.remove(Integer.valueOf(i));
        if (this.eXU.isEmpty()) {
            baT();
            this.kQv = null;
            this.mContext = null;
            a aVar = this.uXM;
            aVar.uXI = null;
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.b(385, aVar);
            b bVar = this.uXN;
            bVar.uXI = null;
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.b(385, bVar);
            for (c cVar : this.uXO.values()) {
                x.i("MicroMsg.IDelayQueryOrder", "onDestory rtType %s", new Object[]{Integer.valueOf(cVar.rtType)});
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Eh().dpP.b(cVar.rtType, cVar);
            }
            this.uXO.clear();
        }
    }

    public final void baV() {
        bNx();
    }

    private boolean l(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WalletNetSceneMgr", "onSceneEnd scene is %s %s", new Object[]{this, lVar.toString()});
        x.d("MicroMsg.WalletNetSceneMgr", "tofutest: %s errType: %d, errCode: %d, errMsg: %s, %s", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(af.eyh)});
        j jVar;
        if (!af.eyh || !(lVar instanceof j) || ((j) lVar).mxp || ((j) lVar).bNv()) {
            if (lVar instanceof ITenpaySave) {
                ITenpaySave iTenpaySave = (ITenpaySave) lVar;
                if (iTenpaySave instanceof ITenpaySave) {
                    ITenpaySave$RetryPayInfo bMO = iTenpaySave.bMO();
                    if (bMO != null && bMO.cDx()) {
                        b.oYE = bMO;
                    }
                }
            }
            if (lVar instanceof j) {
                if (((j) lVar).mxp) {
                    x.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass %s", new Object[]{lVar});
                    return false;
                } else if (((j) lVar).bNv() && (lVar instanceof a)) {
                    x.d("MicroMsg.WalletNetSceneMgr", "%s save or fetch shouldRetry, network: %B, server: %B", new Object[]{this, Boolean.valueOf(!((j) lVar).uXm), Boolean.valueOf(((j) lVar).uYn)});
                    if ((((j) lVar).uYn || r0) && this.uXN.d((j) lVar)) {
                        return true;
                    }
                    return false;
                }
            }
            int type = lVar.getType();
            if (this.uXO != null) {
                c cVar = (c) this.uXO.get(Integer.valueOf(type));
                if (lVar instanceof d) {
                    if (((d) lVar).bre()) {
                        return false;
                    }
                    d dVar = (d) lVar;
                    x.i("MicroMsg.IDelayQueryOrder", "startQueryOrder %s ", new Object[]{dVar});
                    cVar.uXJ = dVar;
                    if (cVar.a(i, i2, dVar)) {
                        return true;
                    }
                }
            }
            if (!(lVar instanceof j) || ((j) lVar).bNv()) {
                return false;
            }
            if (((j) lVar).mxp) {
                x.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass");
                return false;
            }
            jVar = (j) lVar;
            x.d("MicroMsg.WalletNetSceneMgr", "%s shouldRetry, network: %B, server: %B", new Object[]{this, Boolean.valueOf(!jVar.uXm), Boolean.valueOf(this.uXM.a(jVar))});
            if (!this.uXM.a(jVar) && !r0) {
                return false;
            }
            x.i("MicroMsg.WalletNetSceneMgr", "%s doing delay order query retry", new Object[]{this});
            this.uXM.b(jVar);
            return true;
        }
        jVar = (j) lVar;
        x.i("MicroMsg.WalletNetSceneMgr", "test do delay query order");
        this.uXM.b(jVar);
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        int i3;
        boolean z;
        if (this.eXF.contains(lVar)) {
            x.d("MicroMsg.WalletNetSceneMgr", "%s has find scene ", new Object[]{this});
            if (l(i, i2, str, lVar)) {
                x.i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", new Object[]{this});
                return;
            }
            x.i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", new Object[]{this});
            this.eXF.remove(lVar);
            i3 = 1;
        } else if (this.eXE.contains(lVar)) {
            x.d("MicroMsg.WalletNetSceneMgr", "%s has find forcescenes ", new Object[]{this});
            if (l(i, i2, str, lVar)) {
                x.i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", new Object[]{this});
                return;
            }
            this.eXE.remove(lVar);
            x.i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", new Object[]{this});
            i3 = 1;
        } else {
            i3 = 0;
        }
        x.i("MicroMsg.WalletNetSceneMgr", "%s onSceneEnd scenes %s forcescenes %s", new Object[]{this, Integer.valueOf(this.eXF.size()), Integer.valueOf(this.eXE.size())});
        if (this.eXF.isEmpty() && this.eXE.isEmpty()) {
            bNx();
            z = true;
        } else {
            z = false;
        }
        if (i3 != 0 && this.kQv != null) {
            this.kQv.b(i, i2, str, lVar, z);
        }
    }

    public final void bNx() {
        if (this.eXG != null) {
            this.eXG.dismiss();
            this.eXG = null;
        }
    }

    public final boolean baU() {
        if (this.eXF.isEmpty() && this.eXE.isEmpty()) {
            return false;
        }
        return true;
    }

    private void q(l lVar) {
        if (lVar != null && (lVar instanceof m)) {
            ((m) lVar).dox = this.dox;
            if (this.sy != null) {
                ((m) lVar).sy = this.sy;
            } else if (this.mContext instanceof WalletBaseUI) {
                ((m) lVar).sy = ((WalletBaseUI) this.mContext).sy;
            }
        }
    }
}
