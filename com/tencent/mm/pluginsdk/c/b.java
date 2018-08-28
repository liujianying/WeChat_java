package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.kb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class b extends c<kb> {
    protected ArrayList<String> qyv;

    public abstract void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar);

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        kb kbVar = (kb) bVar;
        if ((kbVar instanceof kb) && kbVar.bUq.bUr != null && this.qyv.contains(kbVar.bUq.bUr.getClass().getName())) {
            a(kbVar.bUq.errType, kbVar.bUq.errCode, kbVar.bUq.Yy, kbVar.bUq.bUr);
        }
        return false;
    }

    public b() {
        super(0);
        this.qyv = new ArrayList(3);
        this.sFo = kb.class.getName().hashCode();
    }

    public static void a(String str, b bVar) {
        if (!bVar.qyv.contains(str)) {
            bVar.qyv.add(str);
        }
        a.sFg.b(bVar);
        e.SG(str);
    }

    public static void b(String str, b bVar) {
        e.SH(str);
        a.sFg.c(bVar);
        if (bVar.qyv.contains(str)) {
            bVar.qyv.remove(str);
        }
    }
}
