package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.bi;

class AppAttachDownloadUI$6 implements OnClickListener {
    final /* synthetic */ AppAttachDownloadUI tGp;

    AppAttachDownloadUI$6(AppAttachDownloadUI appAttachDownloadUI) {
        this.tGp = appAttachDownloadUI;
    }

    public final void onClick(View view) {
        AppAttachDownloadUI.k(this.tGp).setVisibility(0);
        AppAttachDownloadUI.l(this.tGp).setVisibility(8);
        AppAttachDownloadUI.m(this.tGp).setVisibility(0);
        if (AppAttachDownloadUI.p(this.tGp)) {
            b o = AppAttachDownloadUI.o(this.tGp);
            if (o != null) {
                o.field_status = 101;
                o.field_lastModifyTime = bi.VE();
                ao.asF().c(o, new String[0]);
            }
            AppAttachDownloadUI.a(this.tGp, new ac(AppAttachDownloadUI.q(this.tGp), AppAttachDownloadUI.r(this.tGp), AppAttachDownloadUI.s(this.tGp)));
            au.DF().a(AppAttachDownloadUI.a(this.tGp), 0);
        }
    }
}
