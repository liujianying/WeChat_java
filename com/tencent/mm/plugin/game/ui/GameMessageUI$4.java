package com.tencent.mm.plugin.game.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class GameMessageUI$4 implements OnScrollListener {
    final /* synthetic */ GameMessageUI kbc;

    GameMessageUI$4(GameMessageUI gameMessageUI) {
        this.kbc = gameMessageUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !GameMessageUI.b(this.kbc).ayQ()) {
            n b = GameMessageUI.b(this.kbc);
            if (!b.ayQ()) {
                b.hFO += 15;
                if (b.hFO > b.edl) {
                    b.hFO = b.edl;
                }
            } else if (b.tlG != null) {
                b.tlG.Xb();
            }
            GameMessageUI.b(this.kbc).a(null, null);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
