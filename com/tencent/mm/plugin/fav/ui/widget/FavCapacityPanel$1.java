package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.b;

class FavCapacityPanel$1 implements OnClickListener {
    final /* synthetic */ FavCapacityPanel jfe;

    FavCapacityPanel$1(FavCapacityPanel favCapacityPanel) {
        this.jfe = favCapacityPanel;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        if (this.jfe.jfc == 0) {
            intent.putExtra("key_enter_fav_cleanui_from", 1);
        } else {
            intent.putExtra("key_enter_fav_cleanui_from", 2);
        }
        b.a(this.jfe.getContext(), ".ui.FavCleanUI", intent);
    }
}
