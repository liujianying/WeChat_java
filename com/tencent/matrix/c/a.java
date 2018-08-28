package com.tencent.matrix.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.d.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class a extends c {
    private final long brh = 86400000;
    private final SharedPreferences bri;
    private final Editor brj;
    private final HashMap<String, Long> brk;

    public a(Context context, String str, com.tencent.matrix.c.c.a aVar) {
        super(aVar);
        this.bri = context.getSharedPreferences(str + c.aC(context), 0);
        this.brk = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        this.brj = this.bri.edit();
        Iterator it = new HashSet(this.bri.getAll().keySet()).iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            long j = this.bri.getLong(str2, 0);
            long j2 = currentTimeMillis - j;
            if (j <= 0 || j2 > this.brh) {
                this.brj.remove(str2);
            } else {
                this.brk.put(str2, Long.valueOf(j));
            }
        }
        this.brj.apply();
    }

    public final void ca(String str) {
        if (str != null && !this.brk.containsKey(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            this.brk.put(str, Long.valueOf(currentTimeMillis));
            this.brj.putLong(str, currentTimeMillis).apply();
        }
    }

    public final boolean cb(String str) {
        if (!this.brk.containsKey(str)) {
            return false;
        }
        long longValue = ((Long) this.brk.get(str)).longValue();
        if (longValue > 0 && System.currentTimeMillis() - longValue <= this.brh) {
            return true;
        }
        this.brj.remove(str).apply();
        this.brk.remove(str);
        return false;
    }
}
