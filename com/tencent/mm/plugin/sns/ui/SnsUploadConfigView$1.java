package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;

class SnsUploadConfigView$1 implements OnClickListener {
    final /* synthetic */ SnsUploadConfigView ogF;
    final /* synthetic */ Context val$context;

    SnsUploadConfigView$1(SnsUploadConfigView snsUploadConfigView, Context context) {
        this.ogF = snsUploadConfigView;
        this.val$context = context;
    }

    public final void onClick(View view) {
        if (SnsUploadConfigView.a(this.ogF) || !SnsUploadConfigView.b(this.ogF)) {
            SnsUploadConfigView.a(this.ogF, !SnsUploadConfigView.a(this.ogF));
            SnsUploadConfigView.c(this.ogF);
            return;
        }
        h.i(this.val$context, j.sns_tag_privacy_qzone_conflict_tip, j.app_tip);
    }
}
