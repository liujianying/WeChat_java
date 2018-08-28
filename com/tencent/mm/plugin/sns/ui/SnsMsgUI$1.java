package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.sdk.platformtools.x;

class SnsMsgUI$1 implements OnClickListener {
    final /* synthetic */ SnsMsgUI nYl;

    SnsMsgUI$1(SnsMsgUI snsMsgUI) {
        this.nYl = snsMsgUI;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof ap) {
            SnsMsgUI.a(this.nYl).a(view, -1, null);
        } else if (view.getTag() instanceof j) {
            SnsMsgUI.a(this.nYl, (j) view.getTag());
        } else {
            x.w("MicroMsg.SnsMsgUI", "v.getTag():" + view.getTag());
        }
    }
}
