package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectConfirmUI$2 implements OnClickListener {
    final /* synthetic */ FaceDetectConfirmUI iQa;

    FaceDetectConfirmUI$2(FaceDetectConfirmUI faceDetectConfirmUI) {
        this.iQa = faceDetectConfirmUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.iQa, FaceDetectPrepareUI.class);
        Bundle extras = this.iQa.getIntent().getExtras();
        if (extras != null) {
            extras.putString("key_feedback_url", FaceDetectConfirmUI.b(this.iQa));
            intent.putExtras(extras);
            this.iQa.startActivityForResult(intent, 1);
            return;
        }
        x.e("MicroMsg.FaceDetectConfirmUI", "alvinluo extras is null when start FaceDetectPrepareUI");
    }
}
