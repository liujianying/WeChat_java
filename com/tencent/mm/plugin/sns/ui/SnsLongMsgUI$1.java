package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;

class SnsLongMsgUI$1 implements OnClickListener {
    final /* synthetic */ SnsLongMsgUI nYa;

    SnsLongMsgUI$1(SnsLongMsgUI snsLongMsgUI) {
        this.nYa = snsLongMsgUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.nYa, SnsUploadUI.class);
        intent.putExtra("KSnsPostManu", true);
        intent.putExtra("KTouchCameraTime", bi.VE());
        intent.putExtra("sns_comment_type", 1);
        intent.putExtra("Ksnsupload_type", 9);
        this.nYa.startActivity(intent);
        this.nYa.finish();
    }
}
