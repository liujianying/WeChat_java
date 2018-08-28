package com.tencent.mm.d;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.api.i;
import com.tencent.mm.b.c.2;
import com.tencent.mm.cache.c;
import com.tencent.mm.d.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.x.a;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

public final class e extends b<c> {
    private boolean bBR = false;
    private boolean bCp = false;
    private TimerTask bCq;
    private Rect bCr = new Rect();
    private float bCs = 0.0f;
    private float bCt = 0.0f;
    private int bCu = 0;
    private int bCv = 0;
    private boolean bCw = false;
    private com.tencent.mm.b.c bCx = new com.tencent.mm.b.c(this);
    public a bCy;
    boolean bCz = false;
    private Timer bno = new Timer();
    Matrix jS = new Matrix();

    public final void vH() {
        super.vH();
        this.bCr.set(0, getBoardRect().height() - ((int) ad.getResources().getDimension(com.tencent.mm.bd.a.c.rubbish_layout_height)), getBoardRect().width(), getBoardRect().height());
    }

    public final a vE() {
        return a.bBj;
    }

    public final void vF() {
    }

    public final void onDraw(Canvas canvas) {
        b(canvas);
        com.tencent.mm.t.c ys = ((c) vG()).ys();
        if (ys != null && ys.dnN) {
            ys.draw(canvas);
        }
    }

    public final boolean q(MotionEvent motionEvent) {
        com.tencent.mm.t.c y;
        boolean z;
        com.tencent.mm.t.c ys;
        switch (motionEvent.getActionMasked()) {
            case 0:
                vX();
                y = y(motionEvent.getX(), motionEvent.getY());
                if (y != null) {
                    z = y.dnR;
                    vV();
                    this.bCp = true;
                    y.setSelected(true);
                    y.dnR = z;
                    y.dnO.set(y.dnK);
                    ((c) vG()).b(y);
                    aH(true);
                    vO();
                    break;
                }
                this.bCp = false;
                ys = ((c) vG()).ys();
                if (ys != null) {
                    z = ys.dnN;
                } else {
                    z = false;
                }
                if (z) {
                    vV();
                    aH(false);
                    vO();
                    break;
                }
                break;
            case 1:
                if (isAlive()) {
                    y = ((c) vG()).ys();
                    if (y != null) {
                        if (!this.bBp.contains((int) y.dnK.x, (int) y.dnK.y)) {
                            this.bCx.bwt = true;
                            com.tencent.mm.b.c cVar = this.bCx;
                            cVar.bww = y;
                            cVar.bwj = y.dnO.x - y.dnK.x;
                            cVar.bwk = y.dnO.y - y.dnK.y;
                            cVar.bwx = y.dnH;
                            cVar = this.bCx;
                            if (cVar.bwt) {
                                PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, cVar.bwk});
                                PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, cVar.bwj});
                                cVar.bwg = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2});
                                cVar.bwg.addUpdateListener(new AnimatorUpdateListener() {
                                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                        float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
                                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
                                        x.d("MicroMsg.StickBackAnim", "animatorValueY:%s  %s", new Object[]{Float.valueOf(floatValue), Float.valueOf(floatValue - c.this.bwy)});
                                        e eVar = c.this.bwv;
                                        float f = floatValue2 - c.this.bwz;
                                        float f2 = floatValue - c.this.bwy;
                                        String str = c.this.bwx;
                                        ListIterator yt = ((com.tencent.mm.cache.c) eVar.vG()).yt();
                                        while (yt.hasPrevious()) {
                                            com.tencent.mm.t.c cVar = (com.tencent.mm.t.c) yt.previous();
                                            if (cVar.dnH.equals(str)) {
                                                cVar.dnK.offset(f, f2);
                                                eVar.vO();
                                                break;
                                            }
                                        }
                                        c.this.bwy = floatValue;
                                        c.this.bwz = floatValue2;
                                    }
                                });
                                cVar.bwg.addListener(new 2(cVar));
                                cVar.bwg.setInterpolator(new LinearInterpolator());
                                cVar.bwg.setDuration(100);
                                cVar.bwg.start();
                            }
                        }
                        if (y instanceof com.tencent.mm.t.e) {
                            com.tencent.mm.t.e eVar = (com.tencent.mm.t.e) y;
                            if (eVar.dnN && eVar.dnR) {
                                if (this.bCy != null) {
                                    this.bCy.a(eVar);
                                }
                            } else if (eVar.dnN) {
                                eVar.dnR = true;
                            }
                        }
                        PointF pointF = y.dnK;
                        x.i("MicroMsg.EmojiAndTextArtist", "mRubbishRect:%s pointF:%s", new Object[]{this.bCr, Float.valueOf(x(pointF.x, pointF.y)[1])});
                        if (y.dnN && ((float) this.bCr.top) <= r0[1] && this.bCp && this.bCy != null) {
                            ((c) vG()).yr();
                            vO();
                        }
                    }
                    vW();
                    if (this.bBR && this.bCy != null) {
                        this.bCy.onHide();
                    }
                    this.bBR = false;
                    break;
                }
                x.e("MicroMsg.EmojiAndTextArtist", "[ACTION_UP] is not alive!");
                return false;
            case 2:
                if (!this.bCw) {
                    if (this.bCp && u(motionEvent)) {
                        int toDegrees;
                        float f;
                        if (!(this.bBR || this.bCy == null)) {
                            this.bCy.onShow();
                        }
                        int[] iArr = new int[]{(int) (motionEvent.getX(0) - this.bBv.x), (int) (motionEvent.getY(0) - this.bBv.y)};
                        float f2 = 1.0f;
                        if (motionEvent.getPointerCount() > 1) {
                            if (0.0f != this.bCs) {
                                f2 = ((float) r(motionEvent)) / this.bCs;
                            }
                            toDegrees = this.bCu - ((int) Math.toDegrees(Math.atan2((double) s(motionEvent)[0], (double) s(motionEvent)[1])));
                            f = f2;
                        } else {
                            toDegrees = 0;
                            f = 1.0f;
                        }
                        float f3 = (float) iArr[0];
                        float f4 = (float) iArr[1];
                        float f5 = this.bCt;
                        int i = this.bCv;
                        int pointerCount = motionEvent.getPointerCount();
                        ys = ((c) vG()).ys();
                        if (ys != null) {
                            this.jS.reset();
                            this.jS.postRotate(-getRotation());
                            Matrix matrix = this.jS;
                            Matrix matrix2 = new Matrix();
                            matrix.invert(matrix2);
                            float[] fArr = new float[]{f3, f4};
                            matrix2.mapPoints(fArr);
                            if (pointerCount > 1) {
                                ys.b(0.0f, 0.0f, f * f5, (toDegrees + i) % 360);
                            } else {
                                ys.b(fArr[0] / getScale(), fArr[1] / getScale(), 0.0f, ys.dnL);
                            }
                            ys.CK();
                            PointF pointF2 = ys.dnK;
                            float[] x = x(pointF2.x, pointF2.y);
                            if (((float) this.bCr.top) <= x[1]) {
                                if (this.bCy != null) {
                                    this.bCy.W((x[1] - ((float) this.bCr.top)) / ((float) this.bCr.height()));
                                }
                                this.bCz = true;
                            } else {
                                if (this.bCy != null && this.bCz) {
                                    this.bCy.Fj();
                                }
                                this.bCz = false;
                            }
                            if (ys instanceof com.tencent.mm.t.e) {
                                ys.dnR = false;
                            }
                        }
                        this.bBR = true;
                        vO();
                        break;
                    }
                }
                this.bCw = false;
                return true;
            case 5:
                if (!this.bCp) {
                    int[] iArr2 = new int[2];
                    if (motionEvent.getPointerCount() > 1) {
                        iArr2[0] = ((int) (motionEvent.getX(0) + motionEvent.getX(1))) / 2;
                        iArr2[1] = ((int) (motionEvent.getY(0) + motionEvent.getY(1))) / 2;
                    }
                    y = y((float) iArr2[0], (float) iArr2[1]);
                    if (y != null) {
                        z = y.dnR;
                        vV();
                        y.dnR = z;
                        this.bCp = true;
                        y.setSelected(true);
                        ((c) vG()).b(y);
                        this.bCs = (float) r(motionEvent);
                        this.bCu = (int) Math.toDegrees(Math.atan2((double) s(motionEvent)[0], (double) s(motionEvent)[1]));
                        if (y != null && y.dnN) {
                            this.bCv = y.dnL;
                            this.bCt = y.dD;
                        }
                        aH(true);
                        vO();
                        break;
                    }
                }
                this.bCs = (float) r(motionEvent);
                this.bCu = (int) Math.toDegrees(Math.atan2((double) s(motionEvent)[0], (double) s(motionEvent)[1]));
                ys = ((c) vG()).ys();
                if (ys != null && ys.dnN) {
                    this.bCv = ys.dnL;
                    this.bCt = ys.dD;
                    break;
                }
                break;
            case 6:
                this.bCw = true;
                break;
        }
        super.q(motionEvent);
        return this.bCp;
    }

    public final void onDestroy() {
        super.onDestroy();
        vX();
    }

    private com.tencent.mm.t.c y(float f, float f2) {
        if (vG() == null) {
            x.e("MicroMsg.EmojiAndTextArtist", "[isContainsItem] getCache is null!");
            return null;
        }
        ListIterator yt = ((c) vG()).yt();
        while (yt.hasPrevious()) {
            int i;
            com.tencent.mm.t.c cVar = (com.tencent.mm.t.c) yt.previous();
            float[] w = w(f, f2);
            float f3 = w[0];
            float f4 = w[1];
            cVar.dnS.clear();
            cVar.dnS.add(cVar.U(cVar.dnT - 180.0f));
            cVar.dnS.add(cVar.U(-cVar.dnT));
            cVar.dnS.add(cVar.U(cVar.dnT));
            cVar.dnS.add(cVar.U((-cVar.dnT) + 180.0f));
            com.tencent.mm.t.c.a aVar = new com.tencent.mm.t.c.a(cVar, cVar.dnS);
            int i2 = 0;
            int i3 = aVar.dnX - 1;
            while (true) {
                i = i2;
                if (0 >= aVar.dnX) {
                    break;
                }
                if ((aVar.dnW[0] < f4 && aVar.dnW[i3] >= f4) || (aVar.dnW[i3] < f4 && aVar.dnW[0] >= f4)) {
                    if (((aVar.dnV[i3] - aVar.dnV[0]) * ((f4 - aVar.dnW[0]) / (aVar.dnW[i3] - aVar.dnW[0]))) + aVar.dnV[0] < f3) {
                        Object obj = i == 0 ? 1 : null;
                    }
                }
                i2 = 0 + 1;
                i3 = 0;
            }
            if (i != 0) {
                return cVar;
            }
        }
        return null;
    }

    private com.tencent.mm.t.c vV() {
        com.tencent.mm.t.c cVar = null;
        ListIterator yt = ((c) vG()).yt();
        while (yt.hasPrevious()) {
            com.tencent.mm.t.c cVar2 = (com.tencent.mm.t.c) yt.previous();
            if (cVar2.dnN) {
                cVar = cVar2;
            }
            cVar2.setSelected(false);
        }
        return cVar;
    }

    private void vW() {
        x.d("MicroMsg.EmojiAndTextArtist", "[registerFocusTask]");
        if (this.bCq != null) {
            this.bCq.cancel();
        }
        this.bCq = new a(this, this);
        this.bno.schedule(this.bCq, 1500);
    }

    private void vX() {
        x.d("MicroMsg.EmojiAndTextArtist", "[unRegisterFocusTask]");
        if (this.bCq != null) {
            this.bCq.cancel();
        }
    }

    public final void a(SpannableString spannableString, int i, int i2) {
        x.i("MicroMsg.EmojiAndTextArtist", "[addItem] text:%s", new Object[]{spannableString});
        if (!bi.K(spannableString)) {
            vX();
            vV();
            aH(false);
            Rect boardRect = getBoardRect();
            com.tencent.mm.t.e eVar = new com.tencent.mm.t.e(ad.getContext(), getMainMatrix(), ((c) vG()).aW(true), boardRect, spannableString, i, i2);
            eVar.setSelected(true);
            eVar.dnR = true;
            float[] w = w((float) boardRect.centerX(), (float) boardRect.centerY());
            eVar.a(w[0], w[1], this.bBn.getInitScale() / this.bBn.getCurScale(), (int) getRotation());
            ((c) vG()).a(eVar);
            vO();
            vW();
        }
    }

    public final void b(i iVar) {
        x.i("MicroMsg.EmojiAndTextArtist", "[addEmojiItem] item:%s", new Object[]{iVar});
        vX();
        vV();
        aH(false);
        Rect boardRect = getBoardRect();
        com.tencent.mm.t.c cVar = new com.tencent.mm.t.c(ad.getContext(), getMainMatrix(), ((c) vG()).aW(true), iVar, boardRect);
        cVar.setSelected(true);
        float[] w = w((float) boardRect.centerX(), (float) boardRect.centerY());
        cVar.a(w[0], w[1], this.bBn.getInitScale() / this.bBn.getCurScale(), (int) getRotation());
        ((c) vG()).a(cVar);
        vO();
        vW();
    }

    public final void a(com.tencent.mm.t.e eVar, SpannableString spannableString, int i, int i2) {
        c cVar = (c) vG();
        x.i("MicroMsg.EmojiAndTextCache", "[delete] id:%s", new Object[]{eVar.dnH});
        if (cVar.dai != null && cVar.dai.size() > 0) {
            if (((com.tencent.mm.t.c) cVar.dai.peek()).dnH.equalsIgnoreCase(r2)) {
                cVar.dai.pop();
            } else {
                x.e("MicroMsg.EmojiAndTextCache", "[delete] id:%s emojiItem:%s", new Object[]{r2, (com.tencent.mm.t.c) cVar.dai.peek()});
            }
        }
        eVar.setSelected(true);
        eVar.dnR = true;
        vX();
        vV();
        aH(true);
        if (!bi.K(spannableString)) {
            com.tencent.mm.t.e eVar2 = new com.tencent.mm.t.e(ad.getContext(), getMainMatrix(), ((c) vG()).aW(true), getBoardRect(), spannableString, i, i2);
            eVar2.setSelected(true);
            PointF pointF = eVar.dnK;
            eVar2.a(pointF.x, pointF.y, this.bBn.getInitScale() / this.bBn.getCurScale(), eVar.dnL);
            eVar2.dD = eVar.dD;
            ((c) vG()).a(eVar2);
        }
        vO();
        vW();
    }
}
