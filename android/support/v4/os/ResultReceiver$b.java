package android.support.v4.os;

import android.os.Bundle;

class ResultReceiver$b implements Runnable {
    final /* synthetic */ ResultReceiver sY;
    final int sZ;
    final Bundle ta;

    public ResultReceiver$b(ResultReceiver resultReceiver, int i, Bundle bundle) {
        this.sY = resultReceiver;
        this.sZ = i;
        this.ta = bundle;
    }

    public final void run() {
        this.sY.onReceiveResult(this.sZ, this.ta);
    }
}
