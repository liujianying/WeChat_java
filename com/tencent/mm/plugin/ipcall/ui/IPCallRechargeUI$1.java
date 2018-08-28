package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.pluginsdk.model.h.a;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

class IPCallRechargeUI$1 implements a {
    final /* synthetic */ IPCallRechargeUI kxB;

    IPCallRechargeUI$1(IPCallRechargeUI iPCallRechargeUI) {
        this.kxB = iPCallRechargeUI;
    }

    public final void u(ArrayList<n> arrayList) {
        IPCallRechargeUI.a(this.kxB).ksj = bi.VF();
        if (arrayList == null || arrayList.size() <= 0) {
            if (IPCallRechargeUI.f(this.kxB) != null && IPCallRechargeUI.f(this.kxB).isShowing()) {
                IPCallRechargeUI.f(this.kxB).dismiss();
            }
            x.i("MicroMsg.IPCallRechargeUI", "[onQueryFinish] result=null");
            IPCallRechargeUI.a(this.kxB, 10236);
            this.kxB.aYo();
            return;
        }
        IPCallRechargeUI.a(this.kxB, new String[arrayList.size()]);
        IPCallRechargeUI.b(this.kxB, new String[arrayList.size()]);
        n nVar = (n) arrayList.get(0);
        if (nVar.qzg == 10232) {
            x.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product OK size=" + arrayList.size());
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                nVar = (n) it.next();
                IPCallRechargeUI.b(this.kxB)[i] = new BigDecimal(nVar.qzf).divide(new BigDecimal(1000000)).toString();
                IPCallRechargeUI.c(this.kxB)[i] = nVar.qze;
                i++;
            }
            if (IPCallRechargeUI.d(this.kxB) > 0 && IPCallRechargeUI.c(this.kxB).length > 0) {
                String str = IPCallRechargeUI.c(this.kxB)[0];
                if (!(bi.oW(str) || str.equals(IPCallRechargeUI.e(this.kxB)))) {
                    x.i("MicroMsg.IPCallRechargeUI", "remote currency:" + IPCallRechargeUI.e(this.kxB) + ",google wallet currency:" + str);
                    IPCallRechargeUI.a(this.kxB, str);
                    return;
                }
            }
            if (IPCallRechargeUI.f(this.kxB) != null && IPCallRechargeUI.f(this.kxB).isShowing()) {
                IPCallRechargeUI.f(this.kxB).dismiss();
            }
            this.kxB.aYo();
            return;
        }
        if (IPCallRechargeUI.f(this.kxB) != null && IPCallRechargeUI.f(this.kxB).isShowing()) {
            IPCallRechargeUI.f(this.kxB).dismiss();
        }
        IPCallRechargeUI.a(this.kxB, nVar.qzg);
        x.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product Failed Status:" + IPCallRechargeUI.g(this.kxB));
        this.kxB.aYo();
    }
}
