package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI.3;

class SendFeedBackUI$3$1 implements OnCancelListener {
    final /* synthetic */ j mQE;
    final /* synthetic */ 3 mQF;

    SendFeedBackUI$3$1(3 3, j jVar) {
        this.mQF = 3;
        this.mQE = jVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.mQE);
    }
}
