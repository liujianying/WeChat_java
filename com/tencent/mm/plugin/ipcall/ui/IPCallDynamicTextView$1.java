package com.tencent.mm.plugin.ipcall.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class IPCallDynamicTextView$1 extends ag {
    final /* synthetic */ IPCallDynamicTextView kvJ;

    IPCallDynamicTextView$1(IPCallDynamicTextView iPCallDynamicTextView) {
        this.kvJ = iPCallDynamicTextView;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if ((IPCallDynamicTextView.a(this.kvJ) <= 0.0d || IPCallDynamicTextView.b(this.kvJ) >= IPCallDynamicTextView.c(this.kvJ)) && (IPCallDynamicTextView.a(this.kvJ) >= 0.0d || IPCallDynamicTextView.b(this.kvJ) <= IPCallDynamicTextView.c(this.kvJ))) {
                    IPCallDynamicTextView.a(this.kvJ, false);
                    IPCallDynamicTextView.a(this.kvJ, IPCallDynamicTextView.c(this.kvJ));
                    return;
                }
                IPCallDynamicTextView.a(this.kvJ, true);
                IPCallDynamicTextView.a(this.kvJ, IPCallDynamicTextView.b(this.kvJ));
                IPCallDynamicTextView.b(this.kvJ, IPCallDynamicTextView.b(this.kvJ) + IPCallDynamicTextView.a(this.kvJ));
                IPCallDynamicTextView.e(this.kvJ).sendEmptyMessageDelayed(1, (long) IPCallDynamicTextView.d(this.kvJ));
                return;
            default:
                return;
        }
    }
}
