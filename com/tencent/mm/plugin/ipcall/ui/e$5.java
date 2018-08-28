package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.ui.e.8;

class e$5 implements OnItemLongClickListener {
    final /* synthetic */ e kuf;

    e$5(e eVar) {
        this.kuf = eVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        h hVar = this.kuf.ktW;
        if (hVar.kxg == null) {
            hVar.kxg = m.aXY();
        }
        k rG = this.kuf.ktW.rG(i - ((ListView) adapterView).getHeaderViewsCount());
        e eVar = this.kuf;
        int headerViewsCount = i - ((ListView) adapterView).getHeaderViewsCount();
        if (rG != null) {
            com.tencent.mm.ui.tools.k kVar = new com.tencent.mm.ui.tools.k(eVar.ktY);
            kVar.ofp = new 8(eVar);
            kVar.ofq = new e$9(eVar, rG, headerViewsCount);
            kVar.bEo();
        }
        return true;
    }
}
