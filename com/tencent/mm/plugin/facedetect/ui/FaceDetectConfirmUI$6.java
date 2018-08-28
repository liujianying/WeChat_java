package com.tencent.mm.plugin.facedetect.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.protocal.c.bbt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectConfirmUI$6 extends ClickableSpan {
    final /* synthetic */ FaceDetectConfirmUI iQa;
    final /* synthetic */ bbt iQb;

    FaceDetectConfirmUI$6(FaceDetectConfirmUI faceDetectConfirmUI, bbt bbt) {
        this.iQa = faceDetectConfirmUI;
        this.iQb = bbt;
    }

    public final void onClick(View view) {
        if (bi.oW(this.iQb.url)) {
            x.e("MicroMsg.FaceDetectConfirmUI", "alvinluo promptInfo url is null");
        } else {
            FaceDetectConfirmUI.a(this.iQa, this.iQb.url);
        }
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.iQa.getResources().getColor(b.link_color));
    }
}
