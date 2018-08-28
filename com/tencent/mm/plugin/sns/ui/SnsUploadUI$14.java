package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Parcel;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.e.h;

class SnsUploadUI$14 implements OnClickListener {
    final /* synthetic */ SnsUploadUI ogU;

    SnsUploadUI$14(SnsUploadUI snsUploadUI) {
        this.ogU = snsUploadUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        Parcel obtain = Parcel.obtain();
        this.ogU.getIntent().putExtra(h.thz, SnsUploadUI.a(this.ogU).getText().toString());
        this.ogU.getIntent().writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        if (SnsUploadUI.h(this.ogU) == 9) {
            g.Ek();
            g.Ei().DT().a(a.sQM, bi.bE(marshall));
        } else {
            g.Ek();
            g.Ei().DT().a(a.sQL, bi.bE(marshall));
        }
        switch (SnsUploadUI.h(this.ogU)) {
            case 0:
                i2 = 3;
                break;
            case 9:
                i2 = 1;
                break;
            case 14:
                i2 = 5;
                break;
            default:
                i2 = 0;
                break;
        }
        String stringExtra = this.ogU.getIntent().getStringExtra("KSessionID");
        com.tencent.mm.plugin.report.service.h.mEJ.h(14247, new Object[]{Integer.valueOf(0), Integer.valueOf(i2), stringExtra, Long.valueOf(bi.VE())});
        SnsUploadUI.i(this.ogU);
    }
}
