package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.List;

public class nd {
    private List<String> a = new ArrayList();
    private List<String> b = new ArrayList();
    private final int c = 300;

    public synchronized boolean a(String str) {
        boolean z = false;
        synchronized (this) {
            if (str != null) {
                if (str.trim().length() != 0) {
                    if (!this.b.contains(str)) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private void a(List<String> list) {
        if (list != null && list.size() > 300) {
            list.remove(0);
        }
    }

    public synchronized void b(String str) {
        if (str != null) {
            if (str.trim().length() != 0) {
                if (this.b.contains(str)) {
                    this.b.remove(str);
                    this.b.add(str);
                } else if (this.a.contains(str)) {
                    a(this.b);
                    this.b.add(str);
                    this.a.remove(str);
                } else {
                    a(this.a);
                    this.a.add(str);
                }
            }
        }
    }
}
