package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.t.d;
import com.tencent.mm.t.d.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Stack;

public final class g implements d<d> {
    private Stack<d> dai;
    private Stack<d> daj;
    public int dal;
    public SparseArray<String> daq;
    public HashMap<String, Bitmap> dar;

    public final /* synthetic */ Object pop() {
        if (this.dai.size() > 0) {
            return (d) this.dai.pop();
        }
        x.e("MicroMsg.MosaicCache", "[pop]");
        return null;
    }

    public final void onCreate() {
        x.i("MicroMsg.MosaicCache", "[onCreate]");
        this.dai = new Stack();
        this.daq = new SparseArray();
        this.dar = new HashMap();
    }

    public final void onDestroy() {
        Iterator it;
        if (this.dai != null) {
            it = this.dai.iterator();
            while (it.hasNext()) {
                it.next();
                d.clear();
            }
            this.dai.clear();
        }
        if (this.daj != null) {
            it = this.daj.iterator();
            while (it.hasNext()) {
                it.next();
                d.clear();
            }
            this.daj.clear();
        }
        this.daq.clear();
        for (Entry value : this.dar.entrySet()) {
            Bitmap bitmap = (Bitmap) value.getValue();
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
        }
        this.dar.clear();
    }

    public final void aV(boolean z) {
        x.i("MicroMsg.MosaicCache", "[onSave] size:%s", new Object[]{Integer.valueOf(this.dai.size())});
        if (this.daj != null) {
            this.daj.clear();
        }
        this.daj = (Stack) this.dai.clone();
        if (z) {
            this.dai.clear();
        }
    }

    public final void yo() {
        x.i("MicroMsg.MosaicCache", "[onRestore] size:%s", new Object[]{Integer.valueOf(this.dai.size())});
        this.dai.clear();
        if (this.daj != null) {
            x.i("MicroMsg.MosaicCache", "[onRestore] %s", new Object[]{Integer.valueOf(this.daj.size())});
            this.dai.addAll(this.daj);
        }
    }

    public final void a(Canvas canvas, boolean z) {
        if (!z) {
            d dVar = (this.dai == null || this.dai.size() <= 0) ? null : (d) this.dai.peek();
            if (dVar != null && dVar.bCF == a.doc) {
                dVar.draw(canvas);
            }
        }
    }

    public final void c(Canvas canvas) {
        Bitmap yv = yv();
        if (yv != null && !yv.isRecycled()) {
            canvas.drawBitmap(yv, 0.0f, 0.0f, null);
        }
    }

    public final Bitmap yv() {
        String str = (String) this.daq.get(aW(true));
        if (bi.oW(str)) {
            x.w("MicroMsg.MosaicCache", "[getCacheFromLocal] path is null");
            return null;
        }
        Bitmap bitmap;
        x.i("MicroMsg.MosaicCache", "[getCacheFromLocal] path:%s size:%s", new Object[]{str, Integer.valueOf(aW(true))});
        if (this.dar.containsKey(str)) {
            bitmap = (Bitmap) this.dar.get(str);
        } else {
            bitmap = null;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            x.i("MicroMsg.MosaicCache", "");
            bitmap = c.Wb(str);
            x.i("MicroMsg.MosaicCache", "[getCacheFromLocal] get from local!");
        }
        if (bitmap == null) {
            x.e("MicroMsg.MosaicCache", "[getCacheFromLocal] null == bitmap path:%s", new Object[]{str});
            return null;
        }
        Bitmap copy = bitmap.copy(Config.ARGB_8888, true);
        bitmap.recycle();
        return copy;
    }

    /* renamed from: a */
    public final void add(d dVar) {
        if (this.dai != null) {
            this.dai.push(dVar);
        }
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
