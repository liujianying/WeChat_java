package com.tencent.mm.ui.gridviewheaders;

import android.view.View;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.f;

class GridHeadersGridView$a extends f implements Runnable {
    final /* synthetic */ GridHeadersGridView uuu;

    private GridHeadersGridView$a(GridHeadersGridView gridHeadersGridView) {
        this.uuu = gridHeadersGridView;
        super(gridHeadersGridView, (byte) 0);
    }

    /* synthetic */ GridHeadersGridView$a(GridHeadersGridView gridHeadersGridView, byte b) {
        this(gridHeadersGridView);
    }

    public final void run() {
        View Ga = this.uuu.Ga(this.uuu.uus);
        if (Ga != null) {
            boolean z;
            GridHeadersGridView.a(this.uuu, this.uuu.uus);
            if (!czo() || this.uuu.tsK) {
                z = false;
            } else {
                GridHeadersGridView gridHeadersGridView = this.uuu;
                if (gridHeadersGridView.uuo != null) {
                    z = gridHeadersGridView.uuo.czm();
                } else {
                    z = false;
                }
                if (z) {
                    if (Ga != null) {
                        Ga.sendAccessibilityEvent(2);
                    }
                    gridHeadersGridView.performHapticFeedback(0);
                }
            }
            if (z) {
                this.uuu.VS = -2;
                this.uuu.setPressed(false);
                Ga.setPressed(false);
                return;
            }
            this.uuu.VS = 2;
        }
    }
}
