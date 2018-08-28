package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.mm.plugin.fav.ui.a.d;

class FavTagEditUI$10 extends d {
    final /* synthetic */ FavTagEditUI jaA;

    FavTagEditUI$10(FavTagEditUI favTagEditUI, Context context) {
        this.jaA = favTagEditUI;
        super(context);
    }

    protected final void Ax(String str) {
        FavTagEditUI.d(this.jaA).bu(str, true);
        FavTagEditUI.f(this.jaA).BE(str);
        FavTagEditUI.d(this.jaA).crN();
        FavTagEditUI.d(this.jaA).crP();
        FavTagEditUI.c(this.jaA);
    }
}
