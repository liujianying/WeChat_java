package com.tencent.mm.permission;

import android.media.AudioManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.a.e$b;

class PermissionWarningDialog$4 implements e$b {
    final /* synthetic */ PermissionWarningDialog evk;

    PermissionWarningDialog$4(PermissionWarningDialog permissionWarningDialog) {
        this.evk = permissionWarningDialog;
    }

    public final void b(boolean z, String str) {
        if (z) {
            x.i("MicroMsg.PermissionWarningDialog", "set MicroPhone unmute.");
            ((AudioManager) ad.getContext().getSystemService("audio")).setMicrophoneMute(false);
        }
        this.evk.finish();
    }
}
