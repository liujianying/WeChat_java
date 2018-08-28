package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.ui.base.n.d;

class CardGiftImageUI$4 implements d {
    final /* synthetic */ CardGiftImageUI hDo;

    CardGiftImageUI$4(CardGiftImageUI cardGiftImageUI) {
        this.hDo = cardGiftImageUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                l.i(CardGiftImageUI.b(this.hDo), this.hDo);
                return;
            default:
                return;
        }
    }
}
