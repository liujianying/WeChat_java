package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel.1;

class FavTagPanel$1$2 implements Runnable {
    final /* synthetic */ View gvo;
    final /* synthetic */ 1 jfJ;

    FavTagPanel$1$2(1 1, View view) {
        this.jfJ = 1;
        this.gvo = view;
    }

    public final void run() {
        FavTagPanel.a(this.jfJ.jfI).BI(((TextView) this.gvo).getText().toString());
    }
}
