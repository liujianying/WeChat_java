package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.b.a;

class SnsMsgUI$2 implements OnItemLongClickListener {
    final /* synthetic */ SnsMsgUI nYl;

    SnsMsgUI$2(SnsMsgUI snsMsgUI) {
        this.nYl = snsMsgUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < SnsMsgUI.c(this.nYl).getHeaderViewsCount()) {
            x.w("MicroMsg.SnsMsgUI", "on header view long click, ignore");
            return true;
        }
        new a(this.nYl).a(view, i, j, this.nYl, SnsMsgUI.k(this.nYl), SnsMsgUI.j(this.nYl)[0], SnsMsgUI.j(this.nYl)[1]);
        return true;
    }
}
