package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Stack;

public final class a implements d<com.tencent.mm.t.a> {
    public Stack<com.tencent.mm.t.a> dai;
    private Stack<com.tencent.mm.t.a> daj;
    public Matrix dak = new Matrix();
    private int dal;

    public final void onCreate() {
        x.i("MicroMsg.CropCache", "[onCreate]");
        this.dai = new Stack();
    }

    public final void onDestroy() {
        if (this.dai != null) {
            this.dai.clear();
        }
        if (this.daj != null) {
            this.daj.clear();
        }
        this.dak.reset();
    }

    public final void aV(boolean z) {
        x.i("MicroMsg.CropCache", "[onSave] size:%s", new Object[]{Integer.valueOf(this.dai.size())});
        if (this.daj != null) {
            this.daj.clear();
        }
        this.daj = (Stack) this.dai.clone();
        if (z) {
            this.dai.clear();
        }
    }

    public final void yo() {
        x.i("MicroMsg.CropCache", "[onRestore] size:%s", new Object[]{Integer.valueOf(this.dai.size())});
        this.dai.clear();
        if (this.daj != null) {
            x.i("MicroMsg.CropCache", "[onRestore] %s", new Object[]{Integer.valueOf(this.daj.size())});
            this.dai.addAll(this.daj);
        }
    }

    public final void a(Canvas canvas, boolean z) {
    }

    public final void c(Canvas canvas) {
    }

    /* renamed from: yp */
    public final com.tencent.mm.t.a pop() {
        if (this.dai.size() > 0) {
            return (com.tencent.mm.t.a) this.dai.pop();
        }
        x.e("MicroMsg.CropCache", "[pop]");
        return null;
    }

    /* renamed from: a */
    public final void add(com.tencent.mm.t.a aVar) {
        if (this.dai != null) {
            this.dai.push(aVar);
        }
    }

    public final com.tencent.mm.t.a yq() {
        if (this.dai == null || this.dai.size() <= 0) {
            return null;
        }
        return (com.tencent.mm.t.a) this.dai.peek();
    }

    public final int aW(boolean z) {
        if (z) {
            if (this.dai != null) {
                return this.dai.size();
            }
            return 0;
        } else if (this.daj != null) {
            return this.daj.size();
        } else {
            return 0;
        }
    }

    public final void vN() {
        this.dal++;
    }
}
