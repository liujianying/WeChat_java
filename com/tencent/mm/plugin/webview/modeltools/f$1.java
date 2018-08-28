package com.tencent.mm.plugin.webview.modeltools;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mm.plugin.webview.modeltools.f.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag.a;

class f$1 implements a {
    final /* synthetic */ f pUs;

    f$1(f fVar) {
        this.pUs = fVar;
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                Bitmap bitmap = this.pUs.pUo.getBitmap();
                if (bitmap != null) {
                    e.post(new b(this.pUs, bitmap), "ViewCaptureHelper_SaveBitmap");
                    this.pUs.pUo = null;
                    break;
                }
                break;
            case 2:
                if (this.pUs.pUq != null) {
                    this.pUs.pUq.ug(this.pUs.pUp);
                    break;
                }
                break;
        }
        return false;
    }
}
