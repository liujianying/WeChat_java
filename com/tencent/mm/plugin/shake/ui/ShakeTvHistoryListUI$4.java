package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.ui.tools.k;

class ShakeTvHistoryListUI$4 implements OnItemLongClickListener {
    final /* synthetic */ k hle;
    final /* synthetic */ ShakeTvHistoryListUI nbu;

    ShakeTvHistoryListUI$4(ShakeTvHistoryListUI shakeTvHistoryListUI, k kVar) {
        this.nbu = shakeTvHistoryListUI;
        this.hle = kVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= ShakeTvHistoryListUI.b(this.nbu).getHeaderViewsCount()) {
            this.hle.a(view, i, j, this.nbu.mController.tml, ShakeTvHistoryListUI.c(this.nbu));
        }
        return true;
    }
}
