package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;

class GridHeadersGridView$1 extends DataSetObserver {
    final /* synthetic */ GridHeadersGridView uuu;

    GridHeadersGridView$1(GridHeadersGridView gridHeadersGridView) {
        this.uuu = gridHeadersGridView;
    }

    public final void onChanged() {
        GridHeadersGridView.a(this.uuu);
    }

    public final void onInvalidated() {
        GridHeadersGridView.a(this.uuu);
    }
}
