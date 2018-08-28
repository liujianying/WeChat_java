package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.a;
import java.io.File;

class FileExplorerUI$2 implements OnItemClickListener {
    final /* synthetic */ FileExplorerUI qSc;

    FileExplorerUI$2(FileExplorerUI fileExplorerUI) {
        this.qSc = fileExplorerUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        File file = (File) FileExplorerUI.a(this.qSc).getItem(i);
        if (1 == FileExplorerUI.b(this.qSc)) {
            if (file.isFile()) {
                au.HU();
                c.DT().set(131074, a.b(FileExplorerUI.a(this.qSc)).getAbsolutePath());
                au.HU();
                c.DT().set(131073, FileExplorerUI.e(this.qSc).getAbsolutePath());
            } else {
                FileExplorerUI.a(this.qSc, file);
            }
        } else if (FileExplorerUI.b(this.qSc) == 0) {
            if (file.isFile()) {
                au.HU();
                c.DT().set(131073, a.b(FileExplorerUI.a(this.qSc)).getAbsolutePath());
                au.HU();
                c.DT().set(131074, FileExplorerUI.d(this.qSc).getAbsolutePath());
            } else {
                FileExplorerUI.b(this.qSc, file);
            }
        }
        if (file == a.a(FileExplorerUI.a(this.qSc))) {
            FileExplorerUI.a(this.qSc).g(a.a(FileExplorerUI.a(this.qSc)).getParentFile(), a.a(FileExplorerUI.a(this.qSc)));
        } else if (file.isDirectory()) {
            FileExplorerUI.a(this.qSc).g(a.b(FileExplorerUI.a(this.qSc)), file);
        } else if (file.isFile()) {
            this.qSc.setResult(-1, new Intent().putExtra("choosed_file_path", file.getAbsolutePath()));
            this.qSc.finish();
        }
        FileExplorerUI.cfm();
        FileExplorerUI.a(this.qSc).notifyDataSetChanged();
        FileExplorerUI.c(this.qSc).setSelection(0);
    }
}
