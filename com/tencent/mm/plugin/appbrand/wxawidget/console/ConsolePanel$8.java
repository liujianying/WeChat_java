package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;

class ConsolePanel$8 implements OnClickListener {
    final /* synthetic */ ConsolePanel gQy;

    ConsolePanel$8(ConsolePanel consolePanel) {
        this.gQy = consolePanel;
    }

    public final void onClick(View view) {
        int i = 0;
        while (i < this.gQy.gQs.length) {
            boolean z;
            View view2 = this.gQy.gQs[i];
            if (view2 == view) {
                z = true;
            } else {
                z = false;
            }
            view2.setSelected(z);
            if (z && this.gQy.gQw != i) {
                this.gQy.gQw = i;
                ConsolePanel.a(this.gQy);
            }
            i++;
        }
    }
}
