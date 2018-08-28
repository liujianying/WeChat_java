package com.tencent.mm.plugin.sight.encode.ui;

import com.tencent.mm.g.a.pn;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class MainSightForwardContainerView$5 extends c<pn> {
    final /* synthetic */ MainSightForwardContainerView nfL;

    MainSightForwardContainerView$5(MainSightForwardContainerView mainSightForwardContainerView) {
        this.nfL = mainSightForwardContainerView;
        this.sFo = pn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pn pnVar = (pn) bVar;
        String str = "MicroMsg.MainSightContainerView";
        String str2 = "on sight send result back[%d], type %d, waitSend %B, isForSns %B";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Integer.valueOf(pnVar.cap.type);
        objArr[2] = Boolean.valueOf(MainSightForwardContainerView.g(this.nfL) != null);
        objArr[3] = Boolean.valueOf(MainSightForwardContainerView.h(this.nfL));
        x.i(str, str2, objArr);
        switch (pnVar.cap.type) {
            case 0:
                MainSightForwardContainerView.i(this.nfL);
                if (!MainSightForwardContainerView.h(this.nfL)) {
                    if (!pnVar.cap.car) {
                        this.nfL.postDelayed(new 1(this), 500);
                        break;
                    }
                    h.mEJ.h(11443, new Object[]{Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(0)});
                    this.nfL.hO(true);
                    break;
                }
                if (pnVar.cap.car) {
                    h.mEJ.h(11443, new Object[]{Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(0)});
                }
                this.nfL.aEI();
                break;
        }
        return false;
    }
}
