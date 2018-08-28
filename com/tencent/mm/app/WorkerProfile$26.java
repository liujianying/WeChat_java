package com.tencent.mm.app;

import android.content.Context;
import com.tencent.mm.l.a.a;
import java.util.HashMap;
import java.util.Map;

class WorkerProfile$26 implements a {
    final Map<String, Integer> bzY = new HashMap();
    final Map<String, Integer> map = new HashMap();
    final /* synthetic */ Context val$context;

    WorkerProfile$26(Context context) {
        this.val$context = context;
    }

    public final String cY(String str) {
        if (this.map.containsKey(str)) {
            return this.val$context.getString(((Integer) this.map.get(str)).intValue());
        }
        return null;
    }

    public final String cZ(String str) {
        if (this.bzY.containsKey(str)) {
            return this.val$context.getString(((Integer) this.bzY.get(str)).intValue());
        }
        return null;
    }
}
