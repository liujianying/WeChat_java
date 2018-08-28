package com.tencent.smtt.utils;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

public class u {
    private b a = null;
    private b b = null;

    private boolean a(b bVar, b bVar2) {
        if (bVar == null || bVar.a() == null || bVar2 == null || bVar2.a() == null) {
            return false;
        }
        Map a = bVar.a();
        Map a2 = bVar2.a();
        for (Entry entry : a.entrySet()) {
            String str = (String) entry.getKey();
            a aVar = (a) entry.getValue();
            if (!a2.containsKey(str)) {
                return false;
            }
            a aVar2 = (a) a2.get(str);
            if (aVar.a() == aVar2.a()) {
                if (aVar.b() != aVar2.b()) {
                }
            }
            return false;
        }
        return true;
    }

    public void a(File file) {
        this.a = new b(this, file);
    }

    public boolean a() {
        return this.b != null && this.a != null && this.b.a().size() == this.a.a().size() && a(this.a, this.b);
    }

    public void b(File file) {
        this.b = new b(this, file);
    }
}
