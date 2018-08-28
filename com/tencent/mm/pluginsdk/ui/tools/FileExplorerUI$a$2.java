package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.a;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.b;
import java.util.Comparator;

class FileExplorerUI$a$2 implements Comparator<b> {
    final /* synthetic */ a qSi;

    FileExplorerUI$a$2(a aVar) {
        this.qSi = aVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((b) obj).qSj.compareTo(((b) obj2).qSj);
    }
}
