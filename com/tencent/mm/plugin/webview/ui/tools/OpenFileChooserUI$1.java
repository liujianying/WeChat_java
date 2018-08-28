package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;

class OpenFileChooserUI$1 implements c {
    final /* synthetic */ OpenFileChooserUI pWh;

    OpenFileChooserUI$1(OpenFileChooserUI openFileChooserUI) {
        this.pWh = openFileChooserUI;
    }

    public final void ju(int i) {
        x.i("MicroMsg.OpenFileChooserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a.a(this.pWh.mController.tml, "android.permission.CAMERA", 16, "", "")), bi.cjd(), this.pWh.mController.tml});
        if (a.a(this.pWh.mController.tml, "android.permission.CAMERA", 16, "", "")) {
            l.c(this.pWh.mController.tml, e.dgl, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
        }
    }
}
