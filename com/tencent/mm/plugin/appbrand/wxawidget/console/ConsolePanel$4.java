package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class ConsolePanel$4 implements OnKeyListener {
    final /* synthetic */ ConsolePanel gQy;

    ConsolePanel$4(ConsolePanel consolePanel) {
        this.gQy = consolePanel;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 66) {
            return false;
        }
        this.gQy.gQx = this.gQy.gQr.getText().toString();
        ConsolePanel.a(this.gQy);
        f.ck(view);
        return true;
    }
}
