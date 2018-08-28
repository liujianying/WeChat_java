package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class SDKOAuthUI$5 implements OnCancelListener {
    final /* synthetic */ SDKOAuthUI pWs;

    SDKOAuthUI$5(SDKOAuthUI sDKOAuthUI) {
        this.pWs = sDKOAuthUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        try {
            dialogInterface.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", new Object[]{e.getLocalizedMessage()});
        }
    }
}
