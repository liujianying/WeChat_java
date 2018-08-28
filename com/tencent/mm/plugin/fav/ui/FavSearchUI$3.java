package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.view.View.OnClickListener;

class FavSearchUI$3 implements OnClickListener {
    final /* synthetic */ FavSearchUI iZQ;

    FavSearchUI$3(FavSearchUI favSearchUI) {
        this.iZQ = favSearchUI;
    }

    public final void onClick(View view) {
        FavSearchUI.a(this.iZQ).setType(((Integer) view.getTag()).intValue());
    }
}
