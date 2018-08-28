package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.an;

class GameBlockView$1 implements OnClickListener {
    final /* synthetic */ int jUG;
    final /* synthetic */ GameBlockView jUH;

    GameBlockView$1(GameBlockView gameBlockView, int i) {
        this.jUH = gameBlockView;
        this.jUG = i;
    }

    public final void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof String)) {
            an.a(this.jUH.getContext(), 10, 1002, 99, c.r(this.jUH.getContext(), (String) view.getTag(), "game_center_mygame_more"), this.jUG, null);
        }
    }
}
