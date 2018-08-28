package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;

class NewFileExplorerUI$1 implements OnClickListener {
    final /* synthetic */ NewFileExplorerUI qTk;

    NewFileExplorerUI$1(NewFileExplorerUI newFileExplorerUI) {
        this.qTk = newFileExplorerUI;
    }

    public final void onClick(View view) {
        if (NewFileExplorerUI.a(this.qTk) != null) {
            FileSelectorFolderView a = NewFileExplorerUI.a(this.qTk);
            a.fk(!a.Ld);
        }
    }
}
