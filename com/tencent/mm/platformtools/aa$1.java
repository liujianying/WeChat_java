package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class aa$1 implements OnClickListener {
    final /* synthetic */ int eeg;
    final /* synthetic */ Activity ews;
    final /* synthetic */ Runnable ewt;

    aa$1(int i, Activity activity, Runnable runnable) {
        this.eeg = i;
        this.ews = activity;
        this.ewt = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.PostLoginUtil", "[cpan] kv report logid:%d scene:%d", new Object[]{Integer.valueOf(11438), Integer.valueOf(this.eeg)});
        h.mEJ.h(11438, new Object[]{Integer.valueOf(this.eeg)});
        g.Ei().DT().set(12322, Boolean.valueOf(true));
        aa.syncUploadMContactStatus(true, false);
        b.Vn();
        if (this.ewt != null) {
            this.ewt.run();
        }
        this.ews.getSharedPreferences(ad.chY(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
    }
}
