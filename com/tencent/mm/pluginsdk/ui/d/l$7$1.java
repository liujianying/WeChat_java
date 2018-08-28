package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.l.7;
import com.tencent.mm.ui.base.h.c;

class l$7$1 implements c {
    final /* synthetic */ String hGV;
    final /* synthetic */ 7 qQi;

    l$7$1(7 7, String str) {
        this.qQi = 7;
        this.hGV = str;
    }

    public final void ju(int i) {
        if (this.qQi.qQd != null) {
            this.qQi.qQd.onDismiss(null);
        }
        switch (i) {
            case 0:
                if (l.cfi()) {
                    Context context = this.qQi.val$context;
                    String str = this.hGV;
                    Intent intent = new Intent("android.intent.action.INSERT");
                    intent.setType("vnd.android.cursor.dir/contact");
                    intent.putExtra("phone", str);
                    context.startActivity(intent);
                    h.mEJ.k(10113, "1");
                    return;
                }
                l.bo(this.qQi.val$context, this.hGV);
                h.mEJ.k(10114, "1");
                return;
            case 1:
                l.bo(this.qQi.val$context, this.hGV);
                h.mEJ.k(10114, "1");
                return;
            default:
                return;
        }
    }
}
