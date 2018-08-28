package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.x;

class SnsGalleryUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SnsGalleryUI nWf;
    final /* synthetic */ boolean nWg;

    SnsGalleryUI$3(SnsGalleryUI snsGalleryUI, boolean z) {
        this.nWf = snsGalleryUI;
        this.nWg = z;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String selectId = this.nWf.nTu.getSelectId();
        String selectedMediaId = this.nWf.nTu.getSelectedMediaId();
        b selectItem = this.nWf.nTu.getSelectItem();
        x.d("MicroMsg.SnsGalleryUI", "click selectLocalId " + selectId);
        x.d("MicroMsg.SnsGalleryUI", "click position " + selectedMediaId);
        n Nl = af.byo().Nl(selectId);
        try {
            int i;
            int position = this.nWf.nTu.getPosition();
            int size = Nl.bAJ().sqc.ruA.size();
            if (size <= 1 || position <= 1 || position > size) {
                i = 0;
            } else {
                i = position - 1;
            }
            this.nWf.nTr.a(this.nWg, Nl, selectItem.caK, true, i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsGalleryUI", e, "", new Object[0]);
        }
        return true;
    }
}
