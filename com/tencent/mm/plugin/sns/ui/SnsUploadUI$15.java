package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa.a;

class SnsUploadUI$15 implements OnClickListener {
    final /* synthetic */ SnsUploadUI ogU;

    SnsUploadUI$15(SnsUploadUI snsUploadUI) {
        this.ogU = snsUploadUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        if (SnsUploadUI.h(this.ogU) == 9) {
            g.Ek();
            g.Ei().DT().a(a.USERINFO_SNS_OPEN_UPLOAD_NEWTEXT_DRAFT_STRING_SYNC, (Object) "");
        } else {
            g.Ek();
            g.Ei().DT().a(a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, (Object) "");
        }
        if (SnsUploadUI.f(this.ogU) instanceof ae) {
            SnsUploadUI.a(this.ogU).setText("");
        }
        switch (SnsUploadUI.h(this.ogU)) {
            case 0:
                i2 = 4;
                break;
            case 9:
                i2 = 2;
                break;
            case 14:
                i2 = 6;
                break;
            default:
                i2 = 0;
                break;
        }
        String stringExtra = this.ogU.getIntent().getStringExtra("KSessionID");
        h.mEJ.h(14247, Integer.valueOf(0), Integer.valueOf(i2), stringExtra, Long.valueOf(bi.VE()));
        SnsUploadUI.j(this.ogU);
    }
}
