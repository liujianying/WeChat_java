package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.je;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class a extends c<je> {
    protected ArrayList<String> qyv;

    public abstract void j(b bVar);

    public a() {
        this.qyv = new ArrayList(3);
        this.sFo = je.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        je jeVar = (je) bVar;
        if ((jeVar instanceof je) && jeVar.bSL.bSM != null && this.qyv.contains(jeVar.bSL.bSM.getClass().getName())) {
            j(jeVar.bSL.bSM);
        }
        return false;
    }

    public static void a(String str, a aVar) {
        if (!aVar.qyv.contains(str)) {
            aVar.qyv.add(str);
        }
        com.tencent.mm.sdk.b.a.sFg.b(aVar);
        e.SG(str);
    }

    public static void b(String str, a aVar) {
        e.SH(str);
        com.tencent.mm.sdk.b.a.sFg.c(aVar);
        if (aVar.qyv.contains(str)) {
            aVar.qyv.remove(str);
        }
    }
}
