package android.support.v4.a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

class e$a implements g {
    List<b> bX = new ArrayList();
    long mDuration = 200;
    long mStartTime;
    List<d> md = new ArrayList();
    View me;
    float mf = 0.0f;
    private boolean mg = false;
    private boolean mh = false;
    Runnable mi = new 1(this);

    public final void w(View view) {
        this.me = view;
    }

    public final void a(b bVar) {
        this.bX.add(bVar);
    }

    public final void setDuration(long j) {
        if (!this.mg) {
            this.mDuration = j;
        }
    }

    public final void start() {
        if (!this.mg) {
            this.mg = true;
            for (int size = this.bX.size() - 1; size >= 0; size--) {
                this.bX.get(size);
            }
            this.mf = 0.0f;
            this.mStartTime = this.me.getDrawingTime();
            this.me.postDelayed(this.mi, 16);
        }
    }

    final void bd() {
        for (int size = this.bX.size() - 1; size >= 0; size--) {
            ((b) this.bX.get(size)).a(this);
        }
    }

    public final void cancel() {
        if (!this.mh) {
            this.mh = true;
            if (this.mg) {
                for (int size = this.bX.size() - 1; size >= 0; size--) {
                    ((b) this.bX.get(size)).bc();
                }
            }
            bd();
        }
    }

    public final void a(d dVar) {
        this.md.add(dVar);
    }

    public final float getAnimatedFraction() {
        return this.mf;
    }
}
