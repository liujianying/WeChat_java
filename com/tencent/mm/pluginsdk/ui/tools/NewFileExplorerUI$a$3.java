package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.a.a;
import java.util.Comparator;

class NewFileExplorerUI$a$3 implements Comparator<a> {
    final /* synthetic */ NewFileExplorerUI.a qTo;

    NewFileExplorerUI$a$3(NewFileExplorerUI.a aVar) {
        this.qTo = aVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        a aVar = (a) obj;
        a aVar2 = (a) obj2;
        if (aVar.time == aVar2.time) {
            return 0;
        }
        return aVar.time > aVar2.time ? -1 : 1;
    }
}
