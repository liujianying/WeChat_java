package android.support.v4.a;

import android.support.v4.a.e.a;

class e$a$1 implements Runnable {
    final /* synthetic */ a mj;

    e$a$1(a aVar) {
        this.mj = aVar;
    }

    public final void run() {
        float drawingTime = (((float) (this.mj.me.getDrawingTime() - this.mj.mStartTime)) * 1.0f) / ((float) this.mj.mDuration);
        if (drawingTime > 1.0f || this.mj.me.getParent() == null) {
            drawingTime = 1.0f;
        }
        this.mj.mf = drawingTime;
        a aVar = this.mj;
        for (int size = aVar.md.size() - 1; size >= 0; size--) {
            ((d) aVar.md.get(size)).b(aVar);
        }
        if (this.mj.mf >= 1.0f) {
            this.mj.bd();
        } else {
            this.mj.me.postDelayed(this.mj.mi, 16);
        }
    }
}
