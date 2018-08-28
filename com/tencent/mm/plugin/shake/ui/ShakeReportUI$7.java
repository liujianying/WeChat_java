package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

class ShakeReportUI$7 implements OnClickListener {
    final /* synthetic */ ShakeReportUI nbh;

    ShakeReportUI$7(ShakeReportUI shakeReportUI) {
        this.nbh = shakeReportUI;
    }

    public final void onClick(View view) {
        if (ShakeReportUI.t(this.nbh)) {
            ShakeReportUI.b(this.nbh, false);
            ShakeReportUI.c(this.nbh, true);
            ShakeReportUI.d(this.nbh, false);
            h.a(this.nbh.mController.tml, null, new String[]{this.nbh.getString(R.l.shake_item_change_bgimg)}, "", new c() {
                public final void ju(int i) {
                    ShakeReportUI.b(ShakeReportUI$7.this.nbh, true);
                    switch (i) {
                        case 0:
                            l.a(ShakeReportUI$7.this.nbh, 1, null);
                            return;
                        default:
                            return;
                    }
                }
            }, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    ShakeReportUI.b(ShakeReportUI$7.this.nbh, true);
                }
            });
        }
    }
}
