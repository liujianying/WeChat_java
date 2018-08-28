package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.w;

class SnsPermissionUI$2 implements OnCancelListener {
    final /* synthetic */ SnsPermissionUI nZu;
    final /* synthetic */ w nZv;

    SnsPermissionUI$2(SnsPermissionUI snsPermissionUI, w wVar) {
        this.nZu = snsPermissionUI;
        this.nZv = wVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        SnsPermissionUI.a(this.nZu);
        g.Ek();
        g.Eh().dpP.c(this.nZv);
    }
}
