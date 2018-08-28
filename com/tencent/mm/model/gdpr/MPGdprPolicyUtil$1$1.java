package com.tencent.mm.model.gdpr;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mm.model.gdpr.c.1;

class MPGdprPolicyUtil$1$1 extends ResultReceiver {
    final /* synthetic */ 1 dEj;

    MPGdprPolicyUtil$1$1(1 1, Handler handler) {
        this.dEj = 1;
        super(handler);
    }

    protected void onReceiveResult(int i, Bundle bundle) {
        this.dEj.dEh.hj(i > 0 ? 0 : 1);
    }
}
