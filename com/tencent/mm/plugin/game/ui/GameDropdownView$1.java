package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class GameDropdownView$1 implements OnClickListener {
    final /* synthetic */ GameDropdownView jXS;

    GameDropdownView$1(GameDropdownView gameDropdownView) {
        this.jXS = gameDropdownView;
    }

    public final void onClick(View view) {
        if (GameDropdownView.a(this.jXS).getContentView() == null || !(GameDropdownView.a(this.jXS).getContentView() instanceof ViewGroup)) {
            GameDropdownView.a(this.jXS).dismiss();
            return;
        }
        GameDropdownView.a(this.jXS, ((ViewGroup) GameDropdownView.a(this.jXS).getContentView()).indexOfChild(view));
        GameDropdownView.a(this.jXS).dismiss();
    }
}
