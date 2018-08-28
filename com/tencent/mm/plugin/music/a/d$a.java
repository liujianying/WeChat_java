package com.tencent.mm.plugin.music.a;

import com.tencent.mm.z.a;
import java.util.Comparator;

public class d$a implements Comparator<a> {
    final /* synthetic */ d lwU;

    public d$a(d dVar) {
        this.lwU = dVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        a aVar = (a) obj;
        a aVar2 = (a) obj2;
        if (aVar.dGw > aVar2.dGw) {
            return 1;
        }
        return aVar.dGw < aVar2.dGw ? -1 : 0;
    }
}
