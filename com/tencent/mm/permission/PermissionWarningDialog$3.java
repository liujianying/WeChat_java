package com.tencent.mm.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class PermissionWarningDialog$3 implements OnClickListener {
    final /* synthetic */ PermissionWarningDialog evk;
    final /* synthetic */ boolean evl;
    final /* synthetic */ boolean evm;

    PermissionWarningDialog$3(PermissionWarningDialog permissionWarningDialog, boolean z, boolean z2) {
        this.evk = permissionWarningDialog;
        this.evm = z;
        this.evl = z2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.l(this.evm, this.evl);
        this.evk.finish();
    }
}
