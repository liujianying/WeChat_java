package com.tencent.mm.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class PermissionWarningDialog$2 implements OnClickListener {
    final /* synthetic */ PermissionWarningDialog evk;
    final /* synthetic */ boolean evl;

    PermissionWarningDialog$2(PermissionWarningDialog permissionWarningDialog, boolean z) {
        this.evk = permissionWarningDialog;
        this.evl = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.cc(this.evl);
        this.evk.finish();
    }
}
