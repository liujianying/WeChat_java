package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.bd;
import com.tencent.mm.pointers.PBool;

class b$11 implements OnClickListener {
    final /* synthetic */ String dhh;
    final /* synthetic */ ProgressDialog hsv;
    final /* synthetic */ String tif;
    final /* synthetic */ PBool unC;

    b$11(String str, PBool pBool, ProgressDialog progressDialog, String str2) {
        this.dhh = str;
        this.unC = pBool;
        this.hsv = progressDialog;
        this.tif = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        bd.a(this.dhh, new 1(this));
    }
}
