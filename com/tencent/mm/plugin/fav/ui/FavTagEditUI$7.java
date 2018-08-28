package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.mm.plugin.fav.ui.a.c;

class FavTagEditUI$7 extends c {
    final /* synthetic */ FavTagEditUI jaA;

    FavTagEditUI$7(FavTagEditUI favTagEditUI, Context context) {
        this.jaA = favTagEditUI;
        super(context);
    }

    protected final void Bz(String str) {
        FavTagEditUI.d(this.jaA).bu(str, true);
        if (FavTagEditUI.g(this.jaA) != null) {
            FavTagEditUI.g(this.jaA).bv(str, true);
        }
        FavTagEditUI.c(this.jaA);
    }

    protected final void BA(String str) {
        FavTagEditUI.d(this.jaA).removeTag(str);
        if (FavTagEditUI.g(this.jaA) != null) {
            FavTagEditUI.g(this.jaA).bv(str, false);
        }
        FavTagEditUI.c(this.jaA);
    }
}
