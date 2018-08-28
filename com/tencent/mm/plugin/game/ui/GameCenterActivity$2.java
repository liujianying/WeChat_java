package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;

class GameCenterActivity$2 implements OnApplyWindowInsetsListener {
    final /* synthetic */ GameCenterActivity jVc;
    final /* synthetic */ ViewGroup jVd;

    GameCenterActivity$2(GameCenterActivity gameCenterActivity, ViewGroup viewGroup) {
        this.jVc = gameCenterActivity;
        this.jVd = viewGroup;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        this.jVc.a(this.jVd, windowInsets);
        return windowInsets.consumeSystemWindowInsets();
    }
}
