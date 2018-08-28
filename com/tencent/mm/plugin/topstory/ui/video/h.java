package com.tencent.mm.plugin.topstory.ui.video;

import android.view.View;
import com.tencent.mm.plugin.topstory.a.a;
import com.tencent.mm.plugin.topstory.ui.a.c;

public final class h {
    public static final c a(a aVar) {
        for (int i = 0; i < aVar.bAt().getChildCount(); i++) {
            View childAt = aVar.bAt().getChildAt(i);
            if (childAt.getTag() != null) {
                c cVar = (c) aVar.bAt().aP(childAt);
                Object obj = (cVar.SU.getTop() < a.oyO + ((-(cVar.SU.getHeight() - cVar.oCS)) / 2) || cVar.SU.getBottom() > cVar.nqm.y + (cVar.SU.getHeight() / 2)) ? null : 1;
                if (obj != null) {
                    return cVar;
                }
            }
        }
        return null;
    }

    public static final c b(a aVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aVar.bAt().getChildCount()) {
                return a(aVar);
            }
            View childAt = aVar.bAt().getChildAt(i2);
            if (childAt.getTag() != null) {
                c cVar = (c) aVar.bAt().aP(childAt);
                if (cVar.position == aVar.bHP()) {
                    return cVar;
                }
            }
            i = i2 + 1;
        }
    }
}
