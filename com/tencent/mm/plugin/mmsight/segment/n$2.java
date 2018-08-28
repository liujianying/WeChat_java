package com.tencent.mm.plugin.mmsight.segment;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.mmsight.segment.n.a;

class n$2 implements OnTouchListener {
    float fto;
    float ftp;
    final /* synthetic */ n lmL;
    int lmM = -1;
    int lmN = -1;
    int lmO;
    int lmP;

    n$2(n nVar) {
        this.lmL = nVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!n.h(this.lmL)) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 5:
                this.lmP = motionEvent.getActionIndex();
                this.lmO = motionEvent.getPointerId(this.lmP);
                this.fto = motionEvent.getX(this.lmP);
                this.ftp = motionEvent.getY(this.lmP);
                if (n.a(this.lmL, n.c(this.lmL), this.fto, this.ftp)) {
                    if (n.a(this.lmL, true)) {
                        return false;
                    }
                    if (n.j(this.lmL) != null) {
                        n.j(this.lmL).beZ();
                    }
                    this.lmM = this.lmO;
                    n.a(this.lmL, (float) n.c(this.lmL).getBounds().left);
                    n.a(this.lmL, true, true);
                    return true;
                } else if (!n.a(this.lmL, n.e(this.lmL), this.fto, this.ftp) || n.a(this.lmL, false)) {
                    return false;
                } else {
                    if (n.j(this.lmL) != null) {
                        n.j(this.lmL).beZ();
                    }
                    this.lmN = this.lmO;
                    n.b(this.lmL, (float) n.e(this.lmL).getBounds().right);
                    n.a(this.lmL, false, true);
                    return true;
                }
            case 1:
            case 3:
            case 6:
                this.lmO = motionEvent.getPointerId(motionEvent.getActionIndex());
                if (this.lmO != this.lmM && this.lmO != this.lmN) {
                    return false;
                }
                if (n.j(this.lmL) != null) {
                    n.j(this.lmL).bfa();
                }
                n.a(this.lmL, this.lmO == this.lmM, false);
                if (this.lmO == this.lmM) {
                    this.lmM = -1;
                } else {
                    this.lmN = -1;
                }
                return true;
            case 2:
                if (!n.a(this.lmL, true) && !n.a(this.lmL, false)) {
                    return false;
                }
                if (n.i(this.lmL)) {
                    return true;
                }
                this.lmP = 0;
                boolean z = false;
                while (this.lmP < motionEvent.getPointerCount()) {
                    this.lmO = motionEvent.getPointerId(this.lmP);
                    if (this.lmO == this.lmM || this.lmO == this.lmN) {
                        n nVar = this.lmL;
                        if (this.lmO == this.lmM) {
                            z = true;
                        } else {
                            z = false;
                        }
                        n.a(nVar, z, motionEvent.getX(this.lmP));
                        if (n.j(this.lmL) != null) {
                            a j = n.j(this.lmL);
                            if (this.lmO == this.lmM) {
                                z = true;
                            } else {
                                z = false;
                            }
                            j.gx(z);
                        }
                        z = true;
                    }
                    this.lmP++;
                }
                return z;
            default:
                return false;
        }
    }
}
