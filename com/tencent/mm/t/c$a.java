package com.tencent.mm.t;

import android.graphics.PointF;
import java.util.List;

class c$a {
    public float[] dnV = new float[this.dnX];
    public float[] dnW = new float[this.dnX];
    public int dnX;
    final /* synthetic */ c dnY;

    public c$a(c cVar, List<PointF> list) {
        this.dnY = cVar;
        this.dnX = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dnX) {
                this.dnV[i2] = ((PointF) list.get(i2)).x;
                this.dnW[i2] = ((PointF) list.get(i2)).y;
                i = i2 + 1;
            } else {
                new StringBuilder("lasso size:").append(this.dnX);
                return;
            }
        }
    }
}
