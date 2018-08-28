package com.tencent.mm.plugin.brandservice.ui.base;

import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.4;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

class BrandServiceSortView$4$1 implements Runnable {
    final /* synthetic */ 4 hqu;

    BrandServiceSortView$4$1(4 4) {
        this.hqu = 4;
    }

    public final void run() {
        List datas = this.hqu.hqt.getDatas();
        if (this.hqu.hW >= 0 && datas != null && this.hqu.hW < datas.size()) {
            datas.remove(this.hqu.hW);
            ah.A(this.hqu.hqt.getAdapter().tDR);
        }
    }
}
