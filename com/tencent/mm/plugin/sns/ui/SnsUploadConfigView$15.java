package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;

class SnsUploadConfigView$15 implements OnClickListener {
    final /* synthetic */ SnsUploadConfigView ogF;

    SnsUploadConfigView$15(SnsUploadConfigView snsUploadConfigView) {
        this.ogF = snsUploadConfigView;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SnsUploadConfigView snsUploadConfigView = this.ogF;
        Context context = this.ogF.getContext();
        this.ogF.getContext().getString(j.app_tip);
        SnsUploadConfigView.a(snsUploadConfigView, h.a(context, this.ogF.getContext().getString(j.twitter_loading), true, new 1(this)));
        SnsUploadConfigView.l(this.ogF).a(this.ogF, this.ogF.getContext());
    }
}
