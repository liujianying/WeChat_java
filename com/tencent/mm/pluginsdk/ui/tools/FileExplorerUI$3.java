package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import java.io.File;

class FileExplorerUI$3 implements OnClickListener {
    final /* synthetic */ FileExplorerUI qSc;
    final /* synthetic */ File qSd;

    FileExplorerUI$3(FileExplorerUI fileExplorerUI, File file) {
        this.qSc = fileExplorerUI;
        this.qSd = file;
    }

    public final void onClick(View view) {
        FileExplorerUI.a(this.qSc, 0);
        FileExplorerUI.a(this.qSc).elx = this.qSd.getPath();
        FileExplorerUI.a(this.qSc).g(FileExplorerUI.e(this.qSc).getParentFile(), FileExplorerUI.e(this.qSc));
        FileExplorerUI.a(this.qSc).notifyDataSetInvalidated();
        FileExplorerUI.a(this.qSc).notifyDataSetChanged();
        FileExplorerUI.c(this.qSc).setSelection(0);
    }
}
