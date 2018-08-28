package com.tencent.mm.ui.gridviewheaders;

import android.view.View;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.f;

class GridHeadersGridView$e extends f implements Runnable {
    final /* synthetic */ GridHeadersGridView uuu;
    int uux;

    private GridHeadersGridView$e(GridHeadersGridView gridHeadersGridView) {
        this.uuu = gridHeadersGridView;
        super(gridHeadersGridView, (byte) 0);
    }

    /* synthetic */ GridHeadersGridView$e(GridHeadersGridView gridHeadersGridView, byte b) {
        this(gridHeadersGridView);
    }

    public final void run() {
        if (!this.uuu.tsK && this.uuu.uur != null && this.uuu.uur.getCount() > 0 && this.uux != -1 && this.uux < this.uuu.uur.getCount() && czo()) {
            View Ga = this.uuu.Ga(this.uux);
            if (Ga != null) {
                GridHeadersGridView gridHeadersGridView = this.uuu;
                GridHeadersGridView.a(this.uuu, this.uux);
                if (gridHeadersGridView.uun != null) {
                    gridHeadersGridView.playSoundEffect(0);
                    if (Ga != null) {
                        Ga.sendAccessibilityEvent(1);
                    }
                    gridHeadersGridView.uun.cq(Ga);
                }
            }
        }
    }
}
