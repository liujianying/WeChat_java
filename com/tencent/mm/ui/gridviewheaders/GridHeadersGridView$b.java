package com.tencent.mm.ui.gridviewheaders;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.a;

final class GridHeadersGridView$b implements Runnable {
    final /* synthetic */ GridHeadersGridView uuu;

    GridHeadersGridView$b(GridHeadersGridView gridHeadersGridView) {
        this.uuu = gridHeadersGridView;
    }

    public final void run() {
        if (this.uuu.VS == 0) {
            this.uuu.VS = 1;
            View Ga = this.uuu.Ga(this.uuu.uus);
            if (Ga != null && !Ga.hasFocusable()) {
                if (this.uuu.tsK) {
                    this.uuu.VS = 2;
                    return;
                }
                Ga.setPressed(true);
                this.uuu.setPressed(true);
                this.uuu.refreshDrawableState();
                int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                if (this.uuu.isLongClickable()) {
                    if (this.uuu.uub == null) {
                        this.uuu.uub = new a(this.uuu, (byte) 0);
                    }
                    this.uuu.uub.czn();
                    GridHeadersGridView.d(this.uuu).postDelayed(this.uuu.uub, (long) longPressTimeout);
                    return;
                }
                this.uuu.VS = 2;
            }
        }
    }
}
