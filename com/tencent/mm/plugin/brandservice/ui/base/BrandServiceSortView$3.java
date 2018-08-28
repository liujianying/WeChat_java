package com.tencent.mm.plugin.brandservice.ui.base;

import android.view.MenuItem;
import com.tencent.mm.ac.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.n.d;

class BrandServiceSortView$3 implements d {
    final /* synthetic */ BrandServiceSortView hqt;

    BrandServiceSortView$3(BrandServiceSortView brandServiceSortView) {
        this.hqt = brandServiceSortView;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (bi.oW(BrandServiceSortView.d(this.hqt))) {
            x.i("MicroMsg.BrandServiceSortView", "username is null or nil.");
        } else if (menuItem.getItemId() == 0) {
            x.i("MicroMsg.BrandServiceSortView", "Menu Item selected, pos(%d)", new Object[]{Integer.valueOf(i)});
            ab Yg = ((i) g.l(i.class)).FR().Yg(BrandServiceSortView.d(this.hqt));
            BrandServiceSortView.a(this.hqt, f.kH(BrandServiceSortView.d(this.hqt)), this.hqt.getContext(), Yg, menuItem.getGroupId());
        }
    }
}
