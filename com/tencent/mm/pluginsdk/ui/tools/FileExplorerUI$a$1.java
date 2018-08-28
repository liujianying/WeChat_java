package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.a;
import java.io.File;
import java.io.FileFilter;

class FileExplorerUI$a$1 implements FileFilter {
    final /* synthetic */ a qSi;

    FileExplorerUI$a$1(a aVar) {
        this.qSi = aVar;
    }

    public final boolean accept(File file) {
        if (file.isHidden()) {
            return false;
        }
        return true;
    }
}
