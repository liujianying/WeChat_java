package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.sns.c.a;

class SnsUploadConfigView$11 implements OnClickListener {
    final /* synthetic */ SnsUploadConfigView ogF;

    SnsUploadConfigView$11(SnsUploadConfigView snsUploadConfigView) {
        this.ogF = snsUploadConfigView;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.ezn.h(new Intent(), SnsUploadConfigView.k(this.ogF));
    }
}
