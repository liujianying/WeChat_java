package com.tencent.mm.pluginsdk.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;

class FileExplorerUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FileExplorerUI qSc;

    FileExplorerUI$1(FileExplorerUI fileExplorerUI) {
        this.qSc = fileExplorerUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (FileExplorerUI.a(this.qSc).qSf != null) {
            if (1 == FileExplorerUI.b(this.qSc)) {
                FileExplorerUI.a(this.qSc, FileExplorerUI.a(this.qSc).qSf);
            } else if (FileExplorerUI.b(this.qSc) == 0) {
                FileExplorerUI.b(this.qSc, FileExplorerUI.a(this.qSc).qSf);
            }
            FileExplorerUI.a(this.qSc).g(FileExplorerUI.a(this.qSc).qSf.getParentFile(), FileExplorerUI.a(this.qSc).qSf);
            FileExplorerUI.a(this.qSc).notifyDataSetChanged();
            FileExplorerUI.c(this.qSc).setSelection(0);
            FileExplorerUI.cfm();
        } else {
            au.HU();
            c.DT().set(131074, FileExplorerUI.d(this.qSc).getAbsolutePath());
            au.HU();
            c.DT().set(131073, FileExplorerUI.e(this.qSc).getAbsolutePath());
            this.qSc.finish();
        }
        return true;
    }
}
