package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.support.v7.widget.LinearLayoutManager;
import java.util.List;

class ConsolePanel$9 implements Runnable {
    final /* synthetic */ ConsolePanel gQy;
    final /* synthetic */ List gQz;

    ConsolePanel$9(ConsolePanel consolePanel, List list) {
        this.gQy = consolePanel;
        this.gQz = list;
    }

    public final void run() {
        int itemCount = this.gQy.gQv.getItemCount();
        this.gQy.gQv.gQl.addAll(this.gQz);
        this.gQy.gQv.Z(itemCount, this.gQz.size());
        if (((LinearLayoutManager) this.gQy.gvH.getLayoutManager()).fj() == itemCount - 1) {
            this.gQy.gvH.smoothScrollToPosition(this.gQy.gQv.getItemCount() - 1);
        }
    }
}
