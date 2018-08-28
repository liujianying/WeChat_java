package com.tencent.mm.ui.tools;

import android.os.Message;
import java.util.TimerTask;

class CropImageView$b extends TimerTask {
    final /* synthetic */ CropImageView uwH;

    public final void run() {
        Message message = new Message();
        if (CropImageView.p(this.uwH) || CropImageView.q(this.uwH) || CropImageView.r(this.uwH) || CropImageView.s(this.uwH)) {
            message.what = 4654;
        } else {
            message.what = 4653;
        }
        CropImageView.t(this.uwH).sendMessage(message);
    }
}
