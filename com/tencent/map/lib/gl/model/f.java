package com.tencent.map.lib.gl.model;

import java.util.ArrayList;

public class f {
    private ArrayList<e> a = new ArrayList();

    public e a(int i) {
        return (e) this.a.get(i);
    }

    public void a(e eVar) {
        this.a.add(eVar);
    }

    public float[] a() {
        float[] fArr = new float[(this.a.size() * 3)];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.size()) {
                return fArr;
            }
            int i3 = i2 * 3;
            fArr[i3 + 0] = ((e) this.a.get(i2)).a;
            fArr[i3 + 1] = ((e) this.a.get(i2)).b;
            fArr[i3 + 2] = ((e) this.a.get(i2)).c;
            i = i2 + 1;
        }
    }
}
