package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

class u$4 extends bd<Boolean> {
    final /* synthetic */ u goS;

    u$4(u uVar, Boolean bool) {
        this.goS = uVar;
        super(1000, bool, (byte) 0);
    }

    private Boolean ame() {
        try {
            u uVar = this.goS;
            LinkedList linkedList = new LinkedList();
            for (u$b u_b : uVar.goM) {
                linkedList.add(Integer.valueOf(u_b.id));
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                uVar.lu(((Integer) it.next()).intValue());
            }
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandWebViewCustomViewContainer", "removeAll error " + e);
        }
        return Boolean.valueOf(false);
    }
}
