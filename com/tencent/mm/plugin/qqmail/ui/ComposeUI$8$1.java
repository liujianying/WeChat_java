package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import com.tencent.mm.plugin.qqmail.ui.ComposeUI.8;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;

class ComposeUI$8$1 implements c {
    final /* synthetic */ 8 mfv;

    ComposeUI$8$1(8 8) {
        this.mfv = 8;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                x.i("MicroMsg.ComposeUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a.a(this.mfv.mfs.mController.tml, "android.permission.CAMERA", 16, "", "")), bi.cjd(), this.mfv.mfs.mController.tml});
                if (a.a(this.mfv.mfs.mController.tml, "android.permission.CAMERA", 16, "", "")) {
                    ComposeUI.C(this.mfv.mfs);
                    return;
                }
                return;
            case 1:
                l.a(this.mfv.mfs, 4, null);
                return;
            case 2:
                this.mfv.mfs.startActivityForResult(new Intent(this.mfv.mfs, FileExplorerUI.class), 5);
                return;
            default:
                return;
        }
    }
}
