package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class OpenFileChooserUI$2 implements OnCancelListener {
    final /* synthetic */ OpenFileChooserUI pWh;

    OpenFileChooserUI$2(OpenFileChooserUI openFileChooserUI) {
        this.pWh = openFileChooserUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.pWh.setResult(0);
        this.pWh.finish();
    }
}
