package com.tencent.mm.plugin.sns.ui;

import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.c;

class AtContactWidget$2 implements Runnable {
    final /* synthetic */ AtContactWidget nLG;

    AtContactWidget$2(AtContactWidget atContactWidget) {
        this.nLG = atContactWidget;
    }

    public final void run() {
        int i = (int) (c.chu().density * 36.0f);
        if (i != 0) {
            i = (((AtContactWidget.b(this.nLG).getWidth() - AtContactWidget.c(this.nLG).getWidth()) - AtContactWidget.d(this.nLG).getWidth()) - ((int) (c.chu().density * 32.0f))) / i;
            if (i > 0 && i < 5) {
                AtContactWidget.e(this.nLG).setLineNum(i);
                LayoutParams layoutParams = (LayoutParams) AtContactWidget.e(this.nLG).getLayoutParams();
                layoutParams.alignWithParent = true;
                AtContactWidget.e(this.nLG).setLayoutParams(layoutParams);
            }
        }
    }
}
