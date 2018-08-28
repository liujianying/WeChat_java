package com.tencent.mm.plugin.sight.encode.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.encode.a.b.a;
import com.tencent.mm.ui.base.h;
import java.util.List;

class MainSightForwardContainerView$6 implements a {
    final /* synthetic */ MainSightForwardContainerView nfL;
    final /* synthetic */ List nfN;

    MainSightForwardContainerView$6(MainSightForwardContainerView mainSightForwardContainerView, List list) {
        this.nfL = mainSightForwardContainerView;
        this.nfN = list;
    }

    public final void onError(int i) {
        if (this.nfN.size() <= 1 || -1 == i) {
            h.bA(this.nfL.getContext(), this.nfL.getContext().getString(R.l.sendrequest_send_fail));
        }
    }
}
