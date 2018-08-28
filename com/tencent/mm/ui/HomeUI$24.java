package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;

class HomeUI$24 implements OnClickListener {
    final /* synthetic */ HomeUI tjS;
    final /* synthetic */ boolean tjW;

    HomeUI$24(HomeUI homeUI, boolean z) {
        this.tjS = homeUI;
        this.tjW = z;
    }

    public final void onClick(View view) {
        HomeUI.e(this.tjS).dZ();
        if (this.tjW) {
            HomeUI.a(this.tjS, Boolean.valueOf(true), Boolean.valueOf(true));
        } else {
            HomeUI.a(this.tjS, Boolean.valueOf(true), Boolean.valueOf(false));
        }
    }
}
