package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.base.h;

class SnsUploadConfigView$8 implements OnClickListener {
    final /* synthetic */ SnsUploadConfigView ogF;
    final /* synthetic */ Context val$context;

    SnsUploadConfigView$8(SnsUploadConfigView snsUploadConfigView, Context context) {
        this.ogF = snsUploadConfigView;
        this.val$context = context;
    }

    public final void onClick(View view) {
        boolean z = false;
        if (SnsUploadConfigView.d(this.ogF) || !SnsUploadConfigView.b(this.ogF)) {
            g.Ek();
            if (g.Ei().DT().getBoolean(a.sQO, true)) {
                g.Ek();
                g.Ei().DT().a(a.sQO, Boolean.valueOf(false));
                h.a(this.val$context, i$j.sns_tag_first_show_weishi_tip, i$j.app_tip, new 1(this));
                return;
            }
            SnsUploadConfigView snsUploadConfigView = this.ogF;
            if (!SnsUploadConfigView.d(this.ogF)) {
                z = true;
            }
            SnsUploadConfigView.b(snsUploadConfigView, z);
            SnsUploadConfigView.e(this.ogF);
            return;
        }
        h.i(this.val$context, i$j.sns_tag_privacy_weishi_conflict_tip, i$j.app_tip);
    }
}
