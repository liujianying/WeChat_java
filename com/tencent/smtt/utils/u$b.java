package com.tencent.smtt.utils;

import com.tencent.smtt.utils.u.a;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

class u$b {
    final /* synthetic */ u a;
    private Map<String, a> b = new HashMap();

    u$b(u uVar, File file) {
        this.a = uVar;
        this.b.clear();
        a(file);
    }

    private void a(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File a : listFiles) {
                a(a);
            }
        } else if (file.isFile()) {
            a(file.getName(), file.length(), file.lastModified());
        }
    }

    private void a(String str, long j, long j2) {
        if (str != null && str.length() > 0 && j > 0 && j2 > 0) {
            a aVar = new a(this.a, str, j, j2);
            if (!this.b.containsKey(str)) {
                this.b.put(str, aVar);
            }
        }
    }

    Map<String, a> a() {
        return this.b;
    }
}
