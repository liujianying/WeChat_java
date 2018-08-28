package com.tencent.mm.model.a;

import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.ab.d.c;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import java.util.Map;

public final class a implements m {
    public final b a(String str, Map<String, String> map, com.tencent.mm.ab.d.a aVar) {
        if (str == null || !str.equals("abtest")) {
            return null;
        }
        d ba = c.ba(Integer.valueOf(-1879048184));
        if (ba == null) {
            return null;
        }
        return ba.b(aVar);
    }
}
