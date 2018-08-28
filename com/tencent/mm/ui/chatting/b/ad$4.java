package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.h;

class ad$4 implements OnItemClickListener {
    final /* synthetic */ ad tRG;

    ad$4(ad adVar) {
        this.tRG = adVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bd bdVar = (bd) ad.d(this.tRG).getItem(i);
        if (bdVar != null && !bi.oW(bdVar.field_talker)) {
            this.tRG.cvN();
            ((h) this.tRG.bAG.O(h.class)).aU(bdVar);
            if (!this.tRG.tRw) {
                this.tRG.tRw = true;
                this.tRG.bAG.tTs.setBottomViewVisible(true);
                this.tRG.bAG.tTr.cuc();
            }
            this.tRG.bAG.tTs.cua();
            this.tRG.bAG.tTs.setIsBottomShowAll(false);
            g gVar = (g) this.tRG.bAG.O(g.class);
            int t = gVar.t(bdVar.field_msgId, false);
            gVar.ctF().a(null, null);
            this.tRG.bAG.getListView().post(new 1(this, i, t));
        }
    }
}
