package com.tencent.mm.ui.tools;

import android.os.Message;
import android.view.MotionEvent;
import com.tencent.mm.ui.tools.CropImageView.3;
import java.util.TimerTask;

class CropImageView$3$1 extends TimerTask {
    final /* synthetic */ MotionEvent uwI;
    final /* synthetic */ 3 uwJ;

    CropImageView$3$1(3 3, MotionEvent motionEvent) {
        this.uwJ = 3;
        this.uwI = motionEvent;
    }

    public final void run() {
        if (CropImageView.z(this.uwJ.uwH)) {
            Message message = new Message();
            message.what = 4661;
            message.obj = this.uwI;
            CropImageView.l(this.uwJ.uwH).sendMessage(message);
            CropImageView.c(this.uwJ.uwH, false);
        }
    }
}
