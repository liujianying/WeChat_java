package com.tencent.mm.d;

import android.graphics.Canvas;
import android.graphics.Path;
import android.view.MotionEvent;
import com.tencent.mm.t.b;
import com.tencent.mm.view.footer.a;

public final class d extends b {
    private float VT;
    private float VU;
    private boolean bBR = false;
    private float bBS;
    private float bBT;
    private float bCo;
    private boolean bCp = true;
    private Path ks = new Path();
    public int pN = a.uUQ[2];

    public final void vH() {
        super.vH();
        this.bCo = this.bBn.getInitScale();
    }

    public final a vE() {
        return a.bBh;
    }

    public final boolean q(MotionEvent motionEvent) {
        if (!vM()) {
            return false;
        }
        float[] w = w(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (this.bBp.contains((int) w[0], (int) w[1])) {
                    float f = w[0];
                    this.bBS = f;
                    this.VT = f;
                    float f2 = w[1];
                    this.bBT = f2;
                    this.VU = f2;
                    this.bCp = true;
                } else {
                    this.bCp = false;
                }
                this.bBR = false;
                break;
            case 1:
            case 5:
                if (this.bCp && this.bBR) {
                    vG().add(new b(new Path(this.ks), (this.bCo / this.bBn.getInitScale()) / this.bBn.getCurScale(), this.pN));
                    aH(false);
                }
                vP();
                this.ks.reset();
                this.bBR = false;
                this.bCp = false;
                break;
            case 2:
                if (!this.bCp || !this.bBR) {
                    if (this.bCp && !this.bBR) {
                        this.ks.moveTo(w[0], w[1]);
                        this.bBR = true;
                        break;
                    }
                }
                this.bBS = this.VT;
                this.bBT = this.VU;
                this.VT = w[0];
                this.VU = w[1];
                this.ks.quadTo(this.bBS, this.bBT, (this.VT + this.bBS) / 2.0f, (this.VU + this.bBT) / 2.0f);
                vO();
                break;
                break;
        }
        return this.bCp;
    }

    public final void onDraw(Canvas canvas) {
        canvas.save();
        canvas.clipRect(this.bBp);
        b(canvas);
        if (!this.ks.isEmpty()) {
            new b(this.ks, (this.bCo / this.bBn.getInitScale()) / this.bBn.getCurScale(), this.pN).draw(canvas);
        }
        canvas.restore();
    }

    public final void vF() {
        aH(true);
    }
}
