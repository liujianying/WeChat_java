package com.tencent.mm.ui;

import com.tencent.mm.g.a.cm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class HomeUI$4 extends c<cm> {
    final /* synthetic */ HomeUI tjS;

    HomeUI$4(HomeUI homeUI) {
        this.tjS = homeUI;
        this.sFo = cm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (HomeUI.l(this.tjS) != null) {
            HomeUI.l(this.tjS).post(new Runnable() {
                public final void run() {
                    HomeUI.m(HomeUI$4.this.tjS);
                }

                public final String toString() {
                    return super.toString() + "|updatePlusMenuNewTips";
                }
            });
        }
        HomeUI.n(this.tjS).cqD();
        return false;
    }
}
