package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;

class SnsUploadConfigView$4 implements OnClickListener {
    final /* synthetic */ SnsUploadConfigView ogF;

    SnsUploadConfigView$4(SnsUploadConfigView snsUploadConfigView) {
        this.ogF = snsUploadConfigView;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("is_force_unbind", true);
        intent.putExtra("shake_music", true);
        d.b(this.ogF.getContext(), "account", ".ui.FacebookAuthUI", intent, 8);
    }
}
