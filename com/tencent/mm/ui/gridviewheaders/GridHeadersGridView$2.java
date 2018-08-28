package com.tencent.mm.ui.gridviewheaders;

import android.view.View;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.e;

class GridHeadersGridView$2 implements Runnable {
    final /* synthetic */ GridHeadersGridView uuu;
    final /* synthetic */ View uuv;
    final /* synthetic */ e uuw;

    GridHeadersGridView$2(GridHeadersGridView gridHeadersGridView, View view, e eVar) {
        this.uuu = gridHeadersGridView;
        this.uuv = view;
        this.uuw = eVar;
    }

    public final void run() {
        this.uuu.VS = -1;
        this.uuv.setPressed(false);
        this.uuu.setPressed(false);
        if (!this.uuu.tsK) {
            this.uuw.run();
        }
    }
}
