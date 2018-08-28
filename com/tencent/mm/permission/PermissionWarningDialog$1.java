package com.tencent.mm.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class PermissionWarningDialog$1 implements OnClickListener {
    final /* synthetic */ PermissionWarningDialog evk;

    PermissionWarningDialog$1(PermissionWarningDialog permissionWarningDialog) {
        this.evk = permissionWarningDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.evk.finish();
    }
}
