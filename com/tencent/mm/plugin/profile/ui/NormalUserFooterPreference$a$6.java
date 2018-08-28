package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;

class NormalUserFooterPreference$a$6 implements OnCancelListener {
    final /* synthetic */ a lXy;

    NormalUserFooterPreference$a$6(a aVar) {
        this.lXy = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.lXy.isDeleteCancel = true;
    }
}
