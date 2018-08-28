package com.tencent.mm.ui;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.Iterator;

class HomeUI$8 implements OnClickListener {
    final /* synthetic */ HomeUI tjS;

    HomeUI$8(HomeUI homeUI) {
        this.tjS = homeUI;
    }

    public final void onClick(View view) {
        if (SystemClock.elapsedRealtime() - HomeUI.o(this.tjS) < 300) {
            Iterator it = HomeUI.p(this.tjS).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
        HomeUI.b(this.tjS, SystemClock.elapsedRealtime());
    }
}
