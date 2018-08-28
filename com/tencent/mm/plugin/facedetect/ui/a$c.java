package com.tencent.mm.plugin.facedetect.ui;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class a$c extends CountDownTimer {
    WeakReference<TextView> iQL = null;
    WeakReference<TextView> iQM = null;
    String iQN = null;
    int iQO = 0;
    int iQP = 0;

    public a$c() {
        super(Long.MAX_VALUE, 500);
    }

    public final void onTick(long j) {
        if (this.iQL == null || this.iQL.get() == null || this.iQM == null || this.iQM.get() == null) {
            x.w("MicroMsg.FaceDetectJumper", "hy: tv ref released");
            cancel();
        } else {
            TextView textView = (TextView) this.iQM.get();
            ((TextView) this.iQL.get()).setText(this.iQN.substring(0, this.iQO));
            textView.setText(this.iQN.substring(this.iQO, this.iQO + (this.iQP % ((this.iQN.length() - this.iQO) + 1))));
        }
        this.iQP++;
    }

    public final void onFinish() {
    }
}
