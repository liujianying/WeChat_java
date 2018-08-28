package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.ui.base.h.c;

class l$1 implements c {
    final /* synthetic */ OnDismissListener qQd;
    final /* synthetic */ String qQe;
    final /* synthetic */ Context val$context;

    l$1(OnDismissListener onDismissListener, String str, Context context) {
        this.qQd = onDismissListener;
        this.qQe = str;
        this.val$context = context;
    }

    public final void ju(int i) {
        if (this.qQd != null) {
            this.qQd.onDismiss(null);
        }
        String replace = this.qQe.replace(" ", "").replace("#", "@");
        switch (i) {
            case 0:
                Context context = this.val$context;
                Intent intent = new Intent();
                intent.putExtra("composeType", 4);
                String substring = replace.substring(0, replace.indexOf(64));
                intent.putExtra("toList", new String[]{substring + " " + replace});
                d.b(context, "qqmail", ".ui.ComposeUI", intent);
                return;
            case 1:
                l.bn(this.val$context, replace);
                return;
            default:
                return;
        }
    }
}
