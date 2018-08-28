package com.tencent.tencentmap.mapsdk.a;

import android.view.animation.Interpolator;
import com.tencent.tencentmap.mapsdk.a.go.a;
import com.tencent.tencentmap.mapsdk.a.go.b;
import java.util.ArrayList;
import java.util.Arrays;

public class gp {
    int a;
    go b;
    go c;
    Interpolator d;
    ArrayList<go> e = new ArrayList();
    gt f;

    public gp(go... goVarArr) {
        this.a = goVarArr.length;
        this.e.addAll(Arrays.asList(goVarArr));
        this.b = (go) this.e.get(0);
        this.c = (go) this.e.get(this.a - 1);
        this.d = this.c.c();
    }

    public static gp a(double... dArr) {
        int i = 1;
        int length = dArr.length;
        a[] aVarArr = new a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (a) go.a(0.0f);
            aVarArr[1] = (a) go.a(1.0f, dArr[0]);
        } else {
            aVarArr[0] = (a) go.a(0.0f, dArr[0]);
            while (i < length) {
                aVarArr[i] = (a) go.a(((float) i) / ((float) (length - 1)), dArr[i]);
                i++;
            }
        }
        return new gk(aVarArr);
    }

    public static gp a(Object... objArr) {
        int i = 1;
        int length = objArr.length;
        b[] bVarArr = new b[Math.max(length, 2)];
        if (length == 1) {
            bVarArr[0] = (b) go.b(0.0f);
            bVarArr[1] = (b) go.a(1.0f, objArr[0]);
        } else {
            bVarArr[0] = (b) go.a(0.0f, objArr[0]);
            while (i < length) {
                bVarArr[i] = (b) go.a(((float) i) / ((float) (length - 1)), objArr[i]);
                i++;
            }
        }
        return new gp(bVarArr);
    }

    public void a(gt gtVar) {
        this.f = gtVar;
    }

    /* renamed from: b */
    public gp clone() {
        ArrayList arrayList = this.e;
        int size = this.e.size();
        go[] goVarArr = new go[size];
        for (int i = 0; i < size; i++) {
            goVarArr[i] = ((go) arrayList.get(i)).clone();
        }
        return new gp(goVarArr);
    }

    public String toString() {
        String str = " ";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a) {
                return str;
            }
            str = str + ((go) this.e.get(i2)).a() + "  ";
            i = i2 + 1;
        }
    }
}
