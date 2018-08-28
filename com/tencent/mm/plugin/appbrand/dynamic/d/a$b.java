package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.protocal.c.aor;
import com.tencent.mm.protocal.c.aos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class a$b implements a<Bundle, Bundle> {
    private static final String[] fvK = new String[]{"scope.userLocation"};

    private a$b() {
    }

    static /* synthetic */ void a(a$b a_b, String str, String str2, Bundle bundle, int i) {
        ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
        LinkedList linkedList = new LinkedList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            linkedList.add((String) it.next());
        }
        b.a aVar = new b.a();
        aVar.dIF = 1158;
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
        aor aor = new aor();
        aor.jQb = str2;
        aor.rQZ = linkedList;
        aor.rRb = 0;
        aor.rRa = i;
        aVar.dIG = aor;
        aVar.dIH = new aos();
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.KT(), new 2(a_b, i, str));
    }

    static /* synthetic */ String sE(String str) {
        return str != null ? str : "";
    }
}
