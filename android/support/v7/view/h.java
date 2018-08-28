package android.support.v7.view;

import android.support.v4.view.ai;
import android.support.v4.view.am;
import android.support.v4.view.an;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {
    am Hf;
    boolean Hg;
    private final an Hh = new an() {
        private boolean Hi = false;
        private int Hj = 0;

        public final void p(View view) {
            if (!this.Hi) {
                this.Hi = true;
                if (h.this.Hf != null) {
                    h.this.Hf.p(null);
                }
            }
        }

        public final void q(View view) {
            int i = this.Hj + 1;
            this.Hj = i;
            if (i == h.this.jC.size()) {
                if (h.this.Hf != null) {
                    h.this.Hf.q(null);
                }
                this.Hj = 0;
                this.Hi = false;
                h.this.Hg = false;
            }
        }
    };
    final ArrayList<ai> jC = new ArrayList();
    private long mDuration = -1;
    private Interpolator mInterpolator;

    public final h g(ai aiVar) {
        if (!this.Hg) {
            this.jC.add(aiVar);
        }
        return this;
    }

    public final h a(ai aiVar, ai aiVar2) {
        this.jC.add(aiVar);
        View view = (View) aiVar.xd.get();
        aiVar2.i(view != null ? ai.xh.aq(view) : 0);
        this.jC.add(aiVar2);
        return this;
    }

    public final void start() {
        if (!this.Hg) {
            Iterator it = this.jC.iterator();
            while (it.hasNext()) {
                ai aiVar = (ai) it.next();
                if (this.mDuration >= 0) {
                    aiVar.h(this.mDuration);
                }
                if (this.mInterpolator != null) {
                    aiVar.c(this.mInterpolator);
                }
                if (this.Hf != null) {
                    aiVar.a(this.Hh);
                }
                aiVar.start();
            }
            this.Hg = true;
        }
    }

    public final void cancel() {
        if (this.Hg) {
            Iterator it = this.jC.iterator();
            while (it.hasNext()) {
                ((ai) it.next()).cancel();
            }
            this.Hg = false;
        }
    }

    public final h dx() {
        if (!this.Hg) {
            this.mDuration = 250;
        }
        return this;
    }

    public final h d(Interpolator interpolator) {
        if (!this.Hg) {
            this.mInterpolator = interpolator;
        }
        return this;
    }

    public final h b(am amVar) {
        if (!this.Hg) {
            this.Hf = amVar;
        }
        return this;
    }
}
