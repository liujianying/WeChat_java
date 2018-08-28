package com.tencent.mrs.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.d.b;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.mm.sdk.platformtools.s;

public class MatrixStrategyNotifyBroadcast extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            b.e("Matrix.StrategyNotifyBroadcast", "MatrixStrategyNotifyBroadcast intent == null", new Object[0]);
            return;
        }
        Object j = s.j(intent, "strategy");
        b.i("Matrix.StrategyNotifyBroadcast", "receive MatrixStrategyNotifyBroadcast, process: %s, strategy:%s", MatrixReport.with().getProcessName(), j);
        if (!TextUtils.isEmpty(j)) {
            MatrixReport.getMrsCallback().onStrategyNotify(j, false);
        }
    }
}
