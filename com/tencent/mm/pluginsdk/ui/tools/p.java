package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.platformtools.x;

public final class p {
    d gbg = d.qFy;
    int hmV;
    int hmW;
    boolean qTC;
    int qUm;
    int qUn;
    int videoHeight;
    int videoWidth;

    final void reset() {
        this.hmW = 0;
        this.hmV = 0;
        this.videoHeight = 0;
        this.videoWidth = 0;
        this.qUn = 0;
        this.qUm = 0;
    }

    final void setScaleType(d dVar) {
        x.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[]{this.gbg, dVar});
        this.gbg = dVar;
        reset();
    }

    final boolean x(int i, int i2, int i3, int i4) {
        if (this.hmV == i && this.hmW == i2 && this.videoWidth == i3 && this.videoHeight == i4) {
            return true;
        }
        p pVar;
        this.hmV = i;
        this.hmW = i2;
        this.videoWidth = i3;
        this.videoHeight = i4;
        float f = (((float) this.videoWidth) * 1.0f) / ((float) this.videoHeight);
        float f2 = (((float) this.hmV) * 1.0f) / ((float) this.hmW);
        if (this.gbg != d.qFy) {
            if (this.gbg == d.qFA) {
                if (this.hmV < this.hmW) {
                    this.qUn = (int) (((float) this.hmV) / f);
                    this.qUm = this.hmV;
                    if (this.qUn > this.hmW) {
                        pVar = this;
                        pVar.qUm = (int) (((float) pVar.hmW) * f);
                        pVar.qUn = pVar.hmW;
                    }
                } else {
                    this.qUm = (int) (((float) this.hmW) * f);
                    this.qUn = this.hmW;
                    if (this.qUm > this.hmV) {
                        this.qUn = (int) (((float) this.hmV) / f);
                        this.qUm = this.hmV;
                    }
                }
                x.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[]{Integer.valueOf(this.hmV), Integer.valueOf(this.hmW), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.qUm), Integer.valueOf(this.qUn), Float.valueOf(f2), Float.valueOf(f)});
                return false;
            }
            if (this.gbg == d.qFz) {
                this.qUn = this.hmW;
                this.qUm = this.hmV;
            } else if (this.gbg == d.qFB) {
                if (this.hmV > this.hmW) {
                    this.qUn = (int) (((float) this.hmV) / f);
                    this.qUm = this.hmV;
                    if (this.qUn < this.hmW) {
                        pVar = this;
                        pVar.qUm = (int) (((float) pVar.hmW) * f);
                        pVar.qUn = pVar.hmW;
                    }
                } else {
                    this.qUm = (int) (((float) this.hmW) * f);
                    this.qUn = this.hmW;
                    if (this.qUm < this.hmV) {
                        this.qUn = (int) (((float) this.hmV) / f);
                        this.qUm = this.hmV;
                    }
                }
            }
            x.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[]{Integer.valueOf(this.hmV), Integer.valueOf(this.hmW), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.qUm), Integer.valueOf(this.qUn), Float.valueOf(f2), Float.valueOf(f)});
            return false;
        }
        if (this.qTC) {
            if (((double) Math.abs(f - f2)) > 0.05d) {
                if (this.hmV < this.hmW) {
                    this.qUn = (int) (((float) this.hmV) / f);
                    this.qUm = this.hmV;
                } else {
                    this.qUm = (int) (((float) this.hmW) * f);
                    this.qUn = this.hmW;
                }
            } else if (this.hmV > this.hmW) {
                this.qUn = (int) (((float) this.hmV) / f);
                this.qUm = this.hmV;
            } else {
                pVar = this;
                pVar.qUm = (int) (((float) pVar.hmW) * f);
                pVar.qUn = pVar.hmW;
            }
        } else if (this.hmV < this.hmW) {
            this.qUn = (int) (((float) this.hmV) / f);
            this.qUm = this.hmV;
        } else {
            this.qUm = (int) (((float) this.hmW) * f);
            this.qUn = this.hmW;
        }
        x.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[]{Integer.valueOf(this.hmV), Integer.valueOf(this.hmW), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.qUm), Integer.valueOf(this.qUn), Float.valueOf(f2), Float.valueOf(f)});
        return false;
    }
}
