package com.tencent.mm.plugin.welab.ui;

import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Comparator;

class WelabMainUI$3 implements Comparator<a> {
    final /* synthetic */ WelabMainUI qnr;

    WelabMainUI$3(WelabMainUI welabMainUI) {
        this.qnr = welabMainUI;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        a aVar = (a) obj;
        a aVar2 = (a) obj2;
        if (aVar == aVar2) {
            return 0;
        }
        if (aVar != null) {
            if (aVar2 == null) {
                return 1;
            }
            if (aVar.field_Pos == aVar2.field_Pos) {
                int WU = bi.WU(aVar.field_expId);
                int WU2 = bi.WU(aVar2.field_expId);
                if (WU != WU2) {
                    return WU2 > WU ? 1 : -1;
                } else {
                    return 0;
                }
            } else if (aVar.field_Pos > aVar2.field_Pos) {
                return 1;
            }
        }
        return -1;
    }
}
