package com.tencent.c.d.a;

import android.text.TextUtils;
import com.tencent.c.d.b.d.a;
import com.tencent.c.f.h;
import java.util.ArrayList;
import java.util.List;

public final class c implements b {
    private final List<a> vjo = new ArrayList();

    public final void a(a aVar) {
        if (aVar.uid == 0 && !TextUtils.isEmpty(aVar.vjw) && "u:r:zygote:s0".equals(aVar.vjw) && !TextUtils.isEmpty(aVar.name) && !"zygote".equals(aVar.name) && !"zygote64".equals(aVar.name)) {
            h.i("JavaProcessAnalyzer match : " + aVar.toString());
            this.vjo.add(aVar);
        }
    }

    public final boolean cFe() {
        return this.vjo.size() > 0;
    }
}
