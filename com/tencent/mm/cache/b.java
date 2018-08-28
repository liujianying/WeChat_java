package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.Stack;

public final class b implements d<com.tencent.mm.t.b> {
    private Stack<com.tencent.mm.t.b> dai;
    public Stack<com.tencent.mm.t.b> daj;
    public int dal;

    public final /* synthetic */ void add(Object obj) {
        com.tencent.mm.t.b bVar = (com.tencent.mm.t.b) obj;
        if (this.dai != null) {
            this.dai.push(bVar);
        }
    }

    public final /* synthetic */ Object pop() {
        return this.dai.size() <= 0 ? null : (com.tencent.mm.t.b) this.dai.pop();
    }

    public final void onCreate() {
        this.dai = new Stack();
    }

    public final void onDestroy() {
        x.i("MicroMsg.DoodleCache", "[onDestroy]");
        if (this.dai != null) {
            this.dai.clear();
        }
        if (this.daj != null) {
            this.daj.clear();
        }
    }

    public final void aV(boolean z) {
        x.i("MicroMsg.DoodleCache", "[onSave] size:%s", new Object[]{Integer.valueOf(this.dai.size())});
        if (this.daj != null) {
            this.daj.clear();
        }
        this.daj = (Stack) this.dai.clone();
        if (z) {
            this.dai.clear();
        }
    }

    public final void yo() {
        x.i("MicroMsg.DoodleCache", "[onRestore] size:%s", new Object[]{Integer.valueOf(this.dai.size())});
        this.dai.clear();
        if (this.daj != null) {
            x.i("MicroMsg.DoodleCache", "[onRestore] %s", new Object[]{Integer.valueOf(this.daj.size())});
            this.dai.addAll(this.daj);
        }
    }

    public final void a(Canvas canvas, boolean z) {
        if (z) {
            canvas.drawColor(0, Mode.CLEAR);
            Iterator it = this.dai.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.t.b) it.next()).draw(canvas);
            }
            return;
        }
        com.tencent.mm.t.b bVar = (this.dai == null || this.dai.size() <= 0) ? null : (com.tencent.mm.t.b) this.dai.peek();
        if (bVar != null) {
            bVar.draw(canvas);
        }
    }

    public final void c(Canvas canvas) {
        Iterator it = this.dai.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.t.b) it.next()).draw(canvas);
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
