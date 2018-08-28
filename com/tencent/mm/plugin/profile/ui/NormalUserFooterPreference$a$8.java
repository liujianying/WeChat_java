package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import com.tencent.mm.plugin.report.service.h;

class NormalUserFooterPreference$a$8 implements OnClickListener {
    final /* synthetic */ ProgressDialog hsv;
    final /* synthetic */ String lXC;
    final /* synthetic */ a lXy;

    NormalUserFooterPreference$a$8(a aVar, ProgressDialog progressDialog, String str) {
        this.lXy = aVar;
        this.hsv = progressDialog;
        this.lXC = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(14553, new Object[]{Integer.valueOf(2), Integer.valueOf(3), NormalUserFooterPreference.a(this.lXy.lXw).field_username});
        this.hsv.show();
        this.lXy.isDeleteCancel = false;
        this.lXy.sa(this.lXC);
    }
}
