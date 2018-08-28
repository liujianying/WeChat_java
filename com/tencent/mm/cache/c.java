package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.t.e;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public final class c implements d<com.tencent.mm.t.c> {
    public Stack<com.tencent.mm.t.c> dai;
    public Stack<com.tencent.mm.t.c> daj;
    private int dal;

    public final void onCreate() {
        x.i("MicroMsg.EmojiAndTextCache", "[onCreate]");
        this.dai = new Stack();
    }

    public final void onDestroy() {
        Iterator it;
        x.i("MicroMsg.EmojiAndTextCache", "[onDestroy]");
        if (this.dai != null) {
            it = this.dai.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.t.c) it.next()).clear();
            }
            this.dai.clear();
        }
        if (this.daj != null) {
            it = this.daj.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.t.c) it.next()).clear();
            }
            this.daj.clear();
        }
    }

    public final void aV(boolean z) {
        x.i("MicroMsg.EmojiAndTextCache", "[onSave] size:%s isExit:%s", new Object[]{Integer.valueOf(this.dai.size()), Boolean.valueOf(z)});
        if (this.daj != null) {
            this.daj.clear();
        }
        this.daj = new Stack();
        Iterator it = this.dai.iterator();
        while (it.hasNext()) {
            this.daj.push(((com.tencent.mm.t.c) it.next()).CL());
        }
        x.i("MicroMsg.EmojiAndTextCache", "[onSave] mLastStack size:%s", new Object[]{Integer.valueOf(this.daj.size())});
        if (z) {
            this.dai.clear();
            it = this.daj.iterator();
            while (it.hasNext()) {
                com.tencent.mm.t.c cVar = (com.tencent.mm.t.c) it.next();
                x.d("MicroMsg.EmojiItem", "[recycleBitmap]");
                if (!(cVar.dnJ == null || cVar.dnJ.isRecycled())) {
                    cVar.dnJ.recycle();
                }
            }
        }
    }

    public final void yo() {
        x.i("MicroMsg.EmojiAndTextCache", "[onRestore] size:%s isExit:%s", new Object[]{Integer.valueOf(this.dai.size()), Boolean.valueOf(false)});
        this.dai.clear();
        if (this.daj != null) {
            x.i("MicroMsg.EmojiAndTextCache", "[onRestore] %s", new Object[]{Integer.valueOf(this.daj.size())});
            this.dai.addAll(this.daj);
        }
        x.i("MicroMsg.EmojiAndTextCache", "[onRestore] mCurStack size:%s ", new Object[]{Integer.valueOf(this.dai.size())});
        Iterator it = this.dai.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.t.c) it.next()).CG();
        }
    }

    public final void a(Canvas canvas, boolean z) {
        com.tencent.mm.t.c cVar;
        if (z) {
            canvas.drawColor(0, Mode.CLEAR);
            Iterator it = this.dai.iterator();
            while (it.hasNext()) {
                cVar = (com.tencent.mm.t.c) it.next();
                if (!cVar.dnN) {
                    cVar.draw(canvas);
                }
            }
            return;
        }
        cVar = ys();
        if (cVar != null && !cVar.dnN) {
            cVar.draw(canvas);
        }
    }

    public final void c(Canvas canvas) {
        Iterator it = this.dai.iterator();
        while (it.hasNext()) {
            com.tencent.mm.t.c cVar = (com.tencent.mm.t.c) it.next();
            cVar.setSelected(false);
            cVar.draw(canvas);
        }
    }

    /* renamed from: yr */
    public final com.tencent.mm.t.c pop() {
        return (com.tencent.mm.t.c) this.dai.pop();
    }

    public final com.tencent.mm.t.c ys() {
        if (this.dai == null || this.dai.size() <= 0) {
            return null;
        }
        return (com.tencent.mm.t.c) this.dai.peek();
    }

    /* renamed from: a */
    public final void add(com.tencent.mm.t.c cVar) {
        if (this.dai != null) {
            this.dai.push(cVar);
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

    public final void b(com.tencent.mm.t.c cVar) {
        if (cVar != null) {
            this.dai.remove(this.dai.indexOf(cVar));
            this.dai.push(cVar);
        }
    }

    public final ListIterator<com.tencent.mm.t.c> yt() {
        return this.dai.listIterator(this.dai.size());
    }

    public final int[] yu() {
        int[] iArr = new int[2];
        if (this.daj != null) {
            Iterator it = this.daj.iterator();
            while (it.hasNext()) {
                if (((com.tencent.mm.t.c) it.next()) instanceof e) {
                    iArr[1] = iArr[1] + 1;
                } else {
                    iArr[0] = iArr[0] + 1;
                }
            }
        }
        return iArr;
    }
}
