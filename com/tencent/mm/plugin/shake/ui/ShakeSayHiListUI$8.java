package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.k;

class ShakeSayHiListUI$8 implements OnItemLongClickListener {
    final /* synthetic */ k hle;
    final /* synthetic */ ShakeSayHiListUI nbq;

    ShakeSayHiListUI$8(ShakeSayHiListUI shakeSayHiListUI, k kVar) {
        this.nbq = shakeSayHiListUI;
        this.hle = kVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < ShakeSayHiListUI.d(this.nbq).getHeaderViewsCount()) {
            x.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
        } else {
            this.hle.a(view, i, j, this.nbq, ShakeSayHiListUI.f(this.nbq));
        }
        return true;
    }
}
