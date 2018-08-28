package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.x;
import java.util.TimerTask;

class CropImageView$c extends TimerTask {
    final /* synthetic */ CropImageView uwH;

    public final void run() {
        x.d("MicroMsg.CropImageView", "in timer task run");
        Message message = new Message();
        if (CropImageView.j(this.uwH)) {
            message.what = 4659;
        } else if (CropImageView.k(this.uwH)) {
            message.what = 4658;
        } else {
            message.what = 4660;
        }
        CropImageView.l(this.uwH).sendMessage(message);
    }
}
