package com.tencent.mm.ui.chatting;

import android.view.View.OnLayoutChangeListener;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.c.a.a;
import com.tencent.mm.ui.c.a.b;

class ChattingAnimFrame$b extends Animation {
    private int fi = 0;
    private float hkl;
    private float hkm;
    private float hkn;
    private float hko;
    private float hkp;
    private float hkq;
    final /* synthetic */ ChattingAnimFrame tIp;
    private float tIq;
    private float tIr;
    private float tIs;
    private float tIt;
    private int tIu = 0;
    private boolean tIv = false;
    private OnLayoutChangeListener tjG = new 1(this);

    public ChattingAnimFrame$b(ChattingAnimFrame chattingAnimFrame, int i, int i2) {
        this.tIp = chattingAnimFrame;
        this.tIu = i;
        this.fi = i2;
        this.tIv = false;
    }

    public ChattingAnimFrame$b(ChattingAnimFrame chattingAnimFrame, int i, int i2, boolean z) {
        this.tIp = chattingAnimFrame;
        this.tIu = i;
        this.fi = i2;
        this.tIv = z;
    }

    public final void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        switch (this.tIu) {
            case 1:
                this.tIq = ChattingAnimFrame.E(0.1f, 0.9f);
                this.tIr = ChattingAnimFrame.E(this.tIq - 0.25f, this.tIq + 0.25f);
                this.tIs = 1.5f;
                this.tIt = -0.2f;
                setInterpolator(new LinearInterpolator());
                break;
            case 2:
                this.tIq = 0.0f;
                this.tIr = 0.0f;
                this.tIs = 0.0f;
                this.tIt = 1.0f;
                setInterpolator(new a());
                break;
            case 3:
                this.tIq = 0.0f;
                this.tIr = 0.0f;
                this.tIs = 1.5f;
                if (this.tIv) {
                    this.tIt = ChattingAnimFrame.E(0.4f, 0.55f);
                } else {
                    this.tIt = ChattingAnimFrame.E(0.54999995f, 0.85f);
                }
                setInterpolator(new b());
                break;
            case 999:
                this.tIq = ChattingAnimFrame.E(0.1f, 0.9f);
                this.tIr = ChattingAnimFrame.E(this.tIq - 0.5f, this.tIq + 0.5f);
                this.tIs = 0.0f;
                this.tIt = 0.0f;
                this.hkl = 0.8f;
                this.hkm = 1.1f;
                setInterpolator(new LinearInterpolator());
                break;
            default:
                this.tIq = ChattingAnimFrame.E(0.1f, 0.9f);
                this.tIr = ChattingAnimFrame.E(this.tIq - 0.5f, this.tIq + 0.5f);
                this.tIs = -0.2f;
                this.tIt = 1.2f;
                setInterpolator(new LinearInterpolator());
                break;
        }
        if (!(this.tIu == 0 || this.tIu == 1)) {
            this.tIp.addOnLayoutChangeListener(this.tjG);
        }
        aum();
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        float f2 = this.hkn;
        float f3 = this.hkp;
        if (this.hkn != this.hko) {
            f2 = this.hkn + ((this.hko - this.hkn) * f);
        }
        if (this.hkp != this.hkq) {
            f3 = this.hkp + ((this.hkq - this.hkp) * f);
            if (this.tIu == 2) {
                f3 -= (float) this.fi;
            }
        }
        transformation.getMatrix().setTranslate(f2, f3);
        if (this.hkl != this.hkm && 3 == this.tIu) {
            f2 = this.hkl + ((this.hkm - this.hkl) * f);
            transformation.getMatrix().postScale(f2, f2);
        }
    }

    protected final void finalize() {
        super.finalize();
        x.i("MicroMsg.ChattingAnimFrame", "finalize!");
        this.tIp.removeOnLayoutChangeListener(this.tjG);
    }

    public final void aum() {
        this.hkn = this.tIq * ((float) ChattingAnimFrame.a(this.tIp));
        this.hko = this.tIr * ((float) ChattingAnimFrame.a(this.tIp));
        if (this.tIu == 2) {
            this.hkp = this.tIs * ((float) ChattingAnimFrame.b(this.tIp));
            this.hkq = this.tIt * ((float) ChattingAnimFrame.b(this.tIp));
        } else if (this.tIu == 3) {
            this.hkp = this.tIs * ((float) ChattingAnimFrame.c(this.tIp));
            this.hkq = this.tIt * ((float) ChattingAnimFrame.c(this.tIp));
            if (ChattingAnimFrame.d(this.tIp)) {
                this.hkp = (this.tIs * ((float) ChattingAnimFrame.c(this.tIp))) - ((float) ChattingAnimFrame.e(this.tIp));
                this.hkq = (this.tIt * ((float) ChattingAnimFrame.c(this.tIp))) - ((float) ChattingAnimFrame.e(this.tIp));
            }
            if (this.hkq < 0.0f) {
                this.hkq = 0.0f;
            }
        } else {
            this.hkp = this.tIs * ((float) ChattingAnimFrame.c(this.tIp));
            this.hkq = this.tIt * ((float) ChattingAnimFrame.c(this.tIp));
        }
    }
}
