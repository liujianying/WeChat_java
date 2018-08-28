package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

class FavRecordDetailUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FavRecordDetailUI msF;

    FavRecordDetailUI$2(FavRecordDetailUI favRecordDetailUI) {
        this.msF = favRecordDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.msF.mController.tml, 1, false);
        dVar.ofp = new 1(this);
        dVar.ofq = new 2(this);
        dVar.bXO();
        return true;
    }
}
