package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;

class SnsUploadUI$6 implements OnTouchListener {
    final /* synthetic */ SnsUploadUI ogU;

    SnsUploadUI$6(SnsUploadUI snsUploadUI) {
        this.ogU = snsUploadUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        x.d("MicroMsg.SnsUploadUI", "upload_content onTouch");
        if (SnsUploadUI.b(this.ogU)) {
            return true;
        }
        return false;
    }
}
