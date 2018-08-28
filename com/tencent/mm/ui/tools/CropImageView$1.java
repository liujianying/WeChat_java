package com.tencent.mm.ui.tools;

import android.os.Message;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.f;

class CropImageView$1 extends ag {
    final /* synthetic */ CropImageView uwH;

    CropImageView$1(CropImageView cropImageView) {
        this.uwH = cropImageView;
    }

    public final void handleMessage(Message message) {
        x.d("MicroMsg.CropImageView", "on handler");
        if (message.what == 4659) {
            this.uwH.zoomIn();
        } else if (message.what == 4658) {
            this.uwH.zoomOut();
        } else if (message.what == 4660) {
            if (!(CropImageView.a(this.uwH) == null || CropImageView.b(this.uwH) == null)) {
                CropImageView.b(this.uwH).cancel();
                CropImageView.c(this.uwH);
            }
        } else if (message.what == 4661) {
            boolean z;
            MotionEvent motionEvent = (MotionEvent) message.obj;
            CropImageView.a(this.uwH, System.currentTimeMillis());
            CropImageView.a(this.uwH, false);
            if (motionEvent.getRawX() - CropImageView.d(this.uwH) > 10.0f || motionEvent.getRawY() - CropImageView.e(this.uwH) > 10.0f || motionEvent.getRawX() - CropImageView.d(this.uwH) < -10.0f || motionEvent.getRawY() - CropImageView.e(this.uwH) < -10.0f) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                if (CropImageView.f(this.uwH) != 0 && currentTimeMillis - CropImageView.f(this.uwH) < 300 && currentTimeMillis - CropImageView.f(this.uwH) >= 0 && CropImageView.g(this.uwH) != null) {
                    CropImageView.g(this.uwH).czF();
                }
                CropImageView.a(this.uwH, 0);
            }
            f.a(CropImageView.h(this.uwH), CropImageView.i(this.uwH));
        }
        super.handleMessage(message);
    }
}
