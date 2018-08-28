package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.h.3;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Iterator;
import java.util.LinkedList;

class h$2 implements Runnable {
    final /* synthetic */ g fdq;
    final /* synthetic */ AppBrandInitConfig fdr;
    final /* synthetic */ AppBrandStatObject fds;
    final /* synthetic */ h fdt;

    h$2(h hVar, g gVar, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        this.fdt = hVar;
        this.fdq = gVar;
        this.fdr = appBrandInitConfig;
        this.fds = appBrandStatObject;
    }

    public final void run() {
        boolean z = true;
        h hVar = this.fdt;
        g gVar = this.fdq;
        AppBrandInitConfig appBrandInitConfig = this.fdr;
        AppBrandStatObject appBrandStatObject = this.fds;
        g qp = hVar.qp(appBrandInitConfig.appId);
        int indexOf = hVar.fdn.indexOf(qp) - 1;
        if (indexOf >= 0) {
            LinkedList linkedList = new LinkedList();
            int i = indexOf;
            while (i >= 0 && ((g) hVar.fdn.get(i)).aap()) {
                linkedList.add(hVar.fdn.get(i));
                i--;
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                g gVar2 = (g) it.next();
                if (gVar2 != gVar) {
                    hVar.f(gVar2);
                }
            }
        }
        if (!hVar.fdn.contains(qp)) {
            hVar.fdn.push(qp);
            if (hVar.fcA.indexOfChild(qp.fcA) == -1) {
                hVar.fcA.addView(qp.fcA);
            }
            hVar.fdo.remove(qp.mAppId);
        }
        hVar.fdn.remove(qp);
        hVar.fdn.push(qp);
        qp.fcA.setVisibility(0);
        hVar.fcA.bringChildToFront(qp.fcA);
        qp.fcs = gVar;
        if (qp.dti) {
            boolean z2;
            String str;
            if (appBrandInitConfig != null) {
                if (qp.fcR) {
                    qp.fcR = false;
                    z2 = true;
                } else if (appBrandInitConfig.fig != qp.fct.fig) {
                    z2 = true;
                }
                qp.fcP = z2;
                z2 = (appBrandInitConfig != null || appBrandStatObject == null) ? false : (qp.fcS || appBrandStatObject.scene == 1099) ? true : (appBrandStatObject.scene == 1022 || appBrandStatObject.scene == TXLiveConstants.PUSH_EVT_CONNECT_SUCC || appBrandStatObject.scene == 1089 || appBrandStatObject.scene == 1090) ? false : (bi.oW(appBrandInitConfig.fqx) && bi.oW(appBrandInitConfig.dzR) && bi.oW(qp.fct.fqx) && bi.oW(qp.fct.dzR)) ? false : true;
                qp.fcQ = z2;
                if (appBrandStatObject.scene != 1099) {
                    z = false;
                }
                qp.fcS = z;
                qp.fct = appBrandInitConfig;
                str = appBrandInitConfig.fqx;
                qp.a(appBrandStatObject);
            }
            z2 = false;
            qp.fcP = z2;
            if (appBrandInitConfig != null) {
            }
            qp.fcQ = z2;
            if (appBrandStatObject.scene != 1099) {
                z = false;
            }
            qp.fcS = z;
            qp.fct = appBrandInitConfig;
            str = appBrandInitConfig.fqx;
            qp.a(appBrandStatObject);
        }
        if (gVar != null) {
            gVar.onPause();
            f.a(qp, gVar, new 3(hVar, gVar));
            qp.onResume();
        }
    }
}
