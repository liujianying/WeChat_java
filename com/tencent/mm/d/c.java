package com.tencent.mm.d;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.view.MotionEvent;
import com.tencent.mm.bi.b;
import com.tencent.mm.cache.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.view.b.a$b;

public final class c extends b<a> {
    private int bBA = ((int) ad.getResources().getDimension(com.tencent.mm.bd.a.c.crop_rotation_layout_height));
    private Matrix bBB = new Matrix();
    private RectF bBC;
    private RectF bBD;
    private RectF bBE;
    private RectF bBF;
    public final Rect bBG = new Rect();
    public com.tencent.mm.t.a bBH;
    private boolean bBI = false;
    private boolean bBJ = false;
    public com.tencent.mm.b.a bBK;
    boolean bBL = false;
    boolean bBM = false;
    boolean bBN = false;
    boolean bBO = false;
    boolean bBP = false;
    public boolean bBQ = true;
    boolean bBR = false;
    float bBS;
    float bBT;
    float bBU;
    float bBV;
    float bBW;
    float bBX;
    public ValueAnimator bBY;
    public Rect bBZ = new Rect();
    private int bBy = ((int) ad.getResources().getDimension(com.tencent.mm.bd.a.c.box_padding));
    private int bBz = ((int) ad.getResources().getDimension(com.tencent.mm.bd.a.c.feature_select_layout_height));
    public int bCa = 0;
    public boolean bCb = false;
    public Rect bwl;

    static /* synthetic */ void a(c cVar, long j, boolean z, boolean z2) {
        if (cVar.bBY != null) {
            cVar.bBY.cancel();
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{0, 255});
        PropertyValuesHolder ofInt2 = z ? PropertyValuesHolder.ofInt("bg_alpha", new int[]{282, 255}) : z2 ? PropertyValuesHolder.ofInt("bg_alpha", new int[]{255, 255}) : PropertyValuesHolder.ofInt("bg_alpha", new int[]{0, 255});
        cVar.bBY = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt, ofInt2});
        cVar.bBY.addUpdateListener(new 3(cVar));
        cVar.bBY.addListener(new 4(cVar));
        cVar.bBY.setStartDelay(j);
        cVar.bBY.setDuration(300);
        cVar.bBY.start();
    }

    public final a vE() {
        return a.bBk;
    }

    public final void a(b bVar, Matrix matrix, Rect rect) {
        super.a(bVar, matrix, rect);
        this.bwl = new Rect();
        this.bBD = new RectF();
        this.bBC = new RectF();
        this.bBE = new RectF();
        this.bBF = new RectF();
        this.bBH = new com.tencent.mm.t.a(this.bwl);
        this.bBK = new com.tencent.mm.b.a(this);
    }

    public final void vH() {
        super.vH();
        if (this.bBG.isEmpty()) {
            this.bBG.set(this.bBy, this.bBy * 2, getBoardRect().width() - this.bBy, ((getBoardRect().height() - this.bBz) - this.bBA) - (this.bBy * 2));
        }
        x.i("MicroMsg.CropArtist", "[onAlive] CROP_MAX_RECT:%s", new Object[]{this.bBG});
        com.tencent.mm.t.a yq = ((a) vG()).yq();
        if (yq != null && !yq.dnF.isEmpty()) {
            this.bBn.cfQ().getBaseBoardView().m(yq.dnF);
            x.i("MicroMsg.CropArtist", "[onAlive] rotation:%s", new Object[]{Float.valueOf(a(yq.mMatrix))});
            getMainMatrix().postRotate(-r1, (float) yq.dnF.centerX(), (float) yq.dnF.centerY());
        }
    }

    public final void vI() {
        super.vI();
        this.bBn.cfQ().getActionBar().setVisibility(8);
        this.bBZ.setEmpty();
        com.tencent.mm.t.a aVar;
        if (((a) vG()).aW(true) <= 0) {
            aVar = new com.tencent.mm.t.a();
            aVar.mMatrix.set(getMainMatrix());
            ((a) vG()).a(aVar);
            vS();
            this.bBn.cfQ().getBaseBoardView().uUg = this.bwl;
            this.bBn.cfQ().getBaseBoardView().a(new 1(this), 0.0f, false);
        } else {
            aVar = ((a) vG()).yq();
            if (aVar == null) {
                x.e("MicroMsg.CropArtist", "item is null!!!");
                return;
            }
            this.bwl.set(new Rect(aVar.bwl));
            this.bBn.cfQ().getBaseBoardView().uUg = aVar.bwl;
            try {
                ((a) vG()).a((com.tencent.mm.t.a) aVar.clone());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CropArtist", e, "", new Object[0]);
            }
            this.bBn.cfQ().getBaseBoardView().a(new 2(this), 0.0f, false);
        }
        setOneFingerMoveEnable(true);
    }

    public final boolean vK() {
        return !((a) vG()).dak.equals(getMainMatrix());
    }

    public final void vF() {
    }

    public final void onDraw(Canvas canvas) {
        if (this.bBJ) {
            canvas.setMatrix(this.bBB);
        } else {
            canvas.setMatrix(null);
        }
        com.tencent.mm.t.a aVar = this.bBH;
        boolean z = this.bBQ;
        boolean z2 = this.bBI;
        if (aVar.bwl == null) {
            x.e("MicroMsg.CropItem", "[draw] mBoxRect is null!");
            return;
        }
        if (z) {
            canvas.save();
            canvas.clipRect(aVar.bwl, Op.DIFFERENCE);
            canvas.drawPaint(com.tencent.mm.t.a.dnB);
            canvas.restore();
        }
        if (z2) {
            if (!com.tencent.mm.t.a.ea.equals(aVar.bwl)) {
                com.tencent.mm.t.a.dny.reset();
                com.tencent.mm.t.a.dny.moveTo((float) aVar.bwl.left, (float) aVar.bwl.top);
                com.tencent.mm.t.a.dny.lineTo((float) aVar.bwl.right, (float) aVar.bwl.top);
                com.tencent.mm.t.a.dny.lineTo((float) aVar.bwl.right, (float) aVar.bwl.bottom);
                com.tencent.mm.t.a.dny.lineTo((float) aVar.bwl.left, (float) aVar.bwl.bottom);
                com.tencent.mm.t.a.dny.close();
                com.tencent.mm.t.a.dnx.reset();
                for (int i = 1; i < 3; i++) {
                    com.tencent.mm.t.a.dnx.moveTo((float) (aVar.bwl.left + ((aVar.bwl.width() / 3) * i)), (float) aVar.bwl.top);
                    com.tencent.mm.t.a.dnx.lineTo((float) (aVar.bwl.left + ((aVar.bwl.width() / 3) * i)), (float) aVar.bwl.bottom);
                    com.tencent.mm.t.a.dnx.moveTo((float) aVar.bwl.left, (float) (aVar.bwl.top + ((aVar.bwl.height() / 3) * i)));
                    com.tencent.mm.t.a.dnx.lineTo((float) aVar.bwl.right, (float) (aVar.bwl.top + ((aVar.bwl.height() / 3) * i)));
                }
            }
            canvas.drawRect((float) aVar.bwl.left, (float) aVar.bwl.top, (float) aVar.bwl.right, (float) aVar.bwl.bottom, com.tencent.mm.t.a.dnA);
            canvas.drawPath(com.tencent.mm.t.a.dnx, com.tencent.mm.t.a.dnC);
            canvas.drawPath(com.tencent.mm.t.a.dny, com.tencent.mm.t.a.dnz);
            Canvas canvas2 = canvas;
            canvas2.drawLine(((float) aVar.bwl.left) - com.tencent.mm.t.a.dnv, ((float) aVar.bwl.top) - (com.tencent.mm.t.a.dnv / 2.0f), com.tencent.mm.t.a.dnw + ((float) aVar.bwl.left), ((float) aVar.bwl.top) - (com.tencent.mm.t.a.dnv / 2.0f), com.tencent.mm.t.a.dnD);
            canvas2 = canvas;
            canvas2.drawLine((com.tencent.mm.t.a.dnv / 2.0f) + (((float) aVar.bwl.right) - com.tencent.mm.t.a.dnw), ((float) aVar.bwl.top) - (com.tencent.mm.t.a.dnv / 2.0f), com.tencent.mm.t.a.dnv + ((float) aVar.bwl.right), ((float) aVar.bwl.top) - (com.tencent.mm.t.a.dnv / 2.0f), com.tencent.mm.t.a.dnD);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.bwl.left) - (com.tencent.mm.t.a.dnv / 2.0f), ((float) aVar.bwl.top) - (com.tencent.mm.t.a.dnv / 2.0f), ((float) aVar.bwl.left) - (com.tencent.mm.t.a.dnv / 2.0f), com.tencent.mm.t.a.dnw + ((float) aVar.bwl.top), com.tencent.mm.t.a.dnD);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.bwl.left) - (com.tencent.mm.t.a.dnv / 2.0f), (com.tencent.mm.t.a.dnv / 2.0f) + (((float) aVar.bwl.bottom) - com.tencent.mm.t.a.dnw), ((float) aVar.bwl.left) - (com.tencent.mm.t.a.dnv / 2.0f), (com.tencent.mm.t.a.dnv / 2.0f) + ((float) aVar.bwl.bottom), com.tencent.mm.t.a.dnD);
            canvas2 = canvas;
            canvas2.drawLine((com.tencent.mm.t.a.dnv / 2.0f) + ((float) aVar.bwl.right), (float) aVar.bwl.top, (com.tencent.mm.t.a.dnv / 2.0f) + ((float) aVar.bwl.right), com.tencent.mm.t.a.dnw + ((float) aVar.bwl.top), com.tencent.mm.t.a.dnD);
            canvas2 = canvas;
            canvas2.drawLine((com.tencent.mm.t.a.dnv / 2.0f) + ((float) aVar.bwl.right), (com.tencent.mm.t.a.dnv / 2.0f) + (((float) aVar.bwl.bottom) - com.tencent.mm.t.a.dnw), (com.tencent.mm.t.a.dnv / 2.0f) + ((float) aVar.bwl.right), (com.tencent.mm.t.a.dnv / 2.0f) + ((float) aVar.bwl.bottom), com.tencent.mm.t.a.dnD);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.bwl.left) - com.tencent.mm.t.a.dnv, (com.tencent.mm.t.a.dnv / 2.0f) + ((float) aVar.bwl.bottom), com.tencent.mm.t.a.dnw + ((float) aVar.bwl.left), (com.tencent.mm.t.a.dnv / 2.0f) + ((float) aVar.bwl.bottom), com.tencent.mm.t.a.dnD);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.bwl.right) - com.tencent.mm.t.a.dnw, (com.tencent.mm.t.a.dnv / 2.0f) + ((float) aVar.bwl.bottom), com.tencent.mm.t.a.dnv + ((float) aVar.bwl.right), (com.tencent.mm.t.a.dnv / 2.0f) + ((float) aVar.bwl.bottom), com.tencent.mm.t.a.dnD);
            if (!com.tencent.mm.t.a.ea.equals(aVar.bwl)) {
                com.tencent.mm.t.a.ea.set(aVar.bwl);
            }
        }
    }

    public final boolean q(MotionEvent motionEvent) {
        if (!vM()) {
            return false;
        }
        RectF curImageRect = this.bBn.cfQ().getBaseBoardView().getCurImageRect();
        this.bBU = curImageRect.top - (curImageRect.bottom - ((float) this.bwl.bottom));
        this.bBV = curImageRect.bottom + (((float) this.bwl.top) - curImageRect.top);
        this.bBW = curImageRect.left - (curImageRect.right - ((float) this.bwl.right));
        this.bBX = curImageRect.right + (((float) this.bwl.left) - curImageRect.left);
        if (this.bBX > ((float) this.bBG.right)) {
            this.bBX = (float) this.bBG.right;
        }
        if (this.bBW < ((float) this.bBy)) {
            this.bBW = (float) this.bBy;
        }
        if (this.bBV > ((float) this.bBG.bottom)) {
            this.bBV = (float) this.bBG.bottom;
        }
        if (this.bBU < ((float) this.bBy)) {
            this.bBU = (float) this.bBy;
        }
        float width;
        float height;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.bBR = false;
                if (this.bBK != null) {
                    this.bBK.cancel();
                }
                if (this.bBD.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.bBO = true;
                }
                if (this.bBC.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.bBN = true;
                }
                if (this.bBE.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.bBM = true;
                }
                if (this.bBF.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.bBP = true;
                }
                this.bBQ = false;
                if (vQ()) {
                    if (this.bBO && this.bBM) {
                        this.bBO = true;
                        this.bBM = true;
                        this.bBN = false;
                        this.bBP = false;
                    } else if (this.bBO && this.bBP) {
                        this.bBO = true;
                        this.bBM = false;
                        this.bBN = false;
                        this.bBP = true;
                    } else if (this.bBN && this.bBP) {
                        this.bBO = false;
                        this.bBM = false;
                        this.bBN = true;
                        this.bBP = true;
                    } else if (this.bBN && this.bBP) {
                        this.bBO = false;
                        this.bBM = false;
                        this.bBN = true;
                        this.bBP = true;
                    }
                    this.bBS = motionEvent.getX();
                    this.bBT = motionEvent.getY();
                    break;
                }
                break;
            case 1:
                width = (((float) this.bBG.width()) * 1.0f) / ((float) this.bwl.width());
                height = (((float) this.bBG.height()) * 1.0f) / ((float) this.bwl.height());
                if (width >= height) {
                    width = height;
                }
                height = ((float) this.bBG.centerX()) - ((float) this.bwl.centerX());
                float centerY = ((float) this.bBG.centerY()) - ((float) this.bwl.centerY());
                if (this.bBR) {
                    this.bBK.bwo = 1000;
                    com.tencent.mm.b.a aVar = this.bBK;
                    Rect rect = this.bwl;
                    aVar.bwj = height;
                    aVar.bwk = centerY;
                    aVar.bwl = rect;
                    aVar.bwm.set(aVar.bwl);
                    aVar.bwi = width;
                    this.bBK.play();
                }
                if (vQ()) {
                    this.bBL = true;
                } else {
                    this.bBL = false;
                }
                this.bBO = false;
                this.bBM = false;
                this.bBN = false;
                this.bBP = false;
                vP();
                break;
            case 2:
                this.bBR = true;
                if (motionEvent.getPointerCount() == 1 && vQ()) {
                    Rect rect2;
                    if (this.bBP && this.bwl.right >= this.bwl.left) {
                        if (this.bwl.right <= this.bBG.right) {
                            if (motionEvent.getX() - this.bBS > ((float) (this.bBG.right - this.bwl.right))) {
                                this.bwl.right = this.bBG.right;
                            } else {
                                rect2 = this.bwl;
                                rect2.right = (int) (((float) rect2.right) + (motionEvent.getX() - this.bBS));
                            }
                        }
                        if (this.bwl.right < this.bwl.left + (this.bBy * 2)) {
                            this.bwl.right = this.bwl.left + (this.bBy * 2);
                        }
                        if (this.bwl.right > this.bBG.right) {
                            this.bwl.right = this.bBG.right;
                        }
                        if (((int) curImageRect.right) <= ((int) this.bBX) && ((int) curImageRect.right) <= this.bwl.right) {
                            if (motionEvent.getX() - this.bBS > this.bBX - curImageRect.right) {
                                getMainMatrix().postTranslate(this.bBX - curImageRect.right, 0.0f);
                            } else {
                                getMainMatrix().postTranslate(motionEvent.getX() - this.bBS, 0.0f);
                            }
                        }
                        if (((float) this.bwl.width()) > curImageRect.width() && this.bwl.right < this.bBG.right) {
                            height = ((float) this.bwl.width()) / curImageRect.width();
                            getMainMatrix().postScale(height, height, (float) this.bwl.left, (float) this.bwl.centerY());
                        }
                    }
                    if (this.bBM && this.bwl.right >= this.bwl.left) {
                        if (this.bwl.left >= this.bBG.left) {
                            if (this.bBS - motionEvent.getX() > ((float) (this.bwl.left - this.bBG.left))) {
                                this.bwl.left = this.bBG.left;
                            } else {
                                rect2 = this.bwl;
                                rect2.left = (int) (((float) rect2.left) - (this.bBS - motionEvent.getX()));
                            }
                        }
                        if (this.bwl.left > this.bwl.right - (this.bBy * 2)) {
                            this.bwl.left = this.bwl.right - (this.bBy * 2);
                        }
                        if (this.bwl.left < this.bBG.left) {
                            this.bwl.left = this.bBG.left;
                        }
                        if (((int) curImageRect.left) >= ((int) this.bBW) && ((int) curImageRect.left) >= this.bwl.left) {
                            if (this.bBS - motionEvent.getX() > curImageRect.left - this.bBW) {
                                getMainMatrix().postTranslate(this.bBW - curImageRect.left, 0.0f);
                            } else {
                                getMainMatrix().postTranslate(motionEvent.getX() - this.bBS, 0.0f);
                            }
                        }
                        if (((float) this.bwl.width()) > curImageRect.width() && this.bwl.left > this.bBG.left) {
                            height = ((float) this.bwl.width()) / curImageRect.width();
                            getMainMatrix().postScale(height, height, (float) this.bwl.right, (float) this.bwl.centerY());
                        }
                    }
                    if (this.bBN && this.bwl.bottom >= this.bwl.top) {
                        if (this.bwl.top >= this.bBG.top) {
                            if (this.bBT - motionEvent.getY() > ((float) (this.bwl.top - this.bBG.top))) {
                                this.bwl.top = this.bBG.top;
                            } else {
                                rect2 = this.bwl;
                                rect2.top = (int) (((float) rect2.top) - (this.bBT - motionEvent.getY()));
                            }
                        }
                        if (this.bwl.top > this.bwl.bottom - (this.bBy * 2)) {
                            this.bwl.top = this.bwl.bottom - (this.bBy * 2);
                        }
                        if (this.bwl.top < this.bBG.top) {
                            this.bwl.top = this.bBG.top;
                        }
                        if (((int) curImageRect.top) >= ((int) this.bBU) && ((int) curImageRect.top) >= this.bwl.top) {
                            if (this.bBT - motionEvent.getY() > curImageRect.top - this.bBU) {
                                getMainMatrix().postTranslate(0.0f, this.bBU - curImageRect.top);
                            } else {
                                getMainMatrix().postTranslate(0.0f, motionEvent.getY() - this.bBT);
                            }
                        }
                        if (((float) this.bwl.height()) > curImageRect.height() && this.bwl.top > this.bBG.top) {
                            height = ((float) this.bwl.height()) / curImageRect.height();
                            getMainMatrix().postScale(height, height, (float) this.bwl.centerX(), (float) this.bwl.bottom);
                        }
                    }
                    if (this.bBO && this.bwl.bottom >= this.bwl.top) {
                        if (this.bwl.bottom <= this.bBG.bottom) {
                            if (motionEvent.getY() - this.bBT > ((float) (this.bBG.bottom - this.bwl.bottom))) {
                                this.bwl.bottom = this.bBG.bottom;
                            } else {
                                rect2 = this.bwl;
                                rect2.bottom = (int) (((float) rect2.bottom) + (motionEvent.getY() - this.bBT));
                            }
                        }
                        if (this.bwl.bottom < this.bwl.top + (this.bBy * 2)) {
                            this.bwl.bottom = this.bwl.top + (this.bBy * 2);
                        }
                        if (this.bwl.bottom > this.bBG.bottom) {
                            this.bwl.bottom = this.bBG.bottom;
                        }
                        if (((int) curImageRect.bottom) <= ((int) this.bBV) && ((int) curImageRect.bottom) <= this.bwl.bottom) {
                            if (motionEvent.getY() - this.bBT > this.bBV - curImageRect.bottom) {
                                getMainMatrix().postTranslate(0.0f, this.bBV - curImageRect.bottom);
                            } else {
                                getMainMatrix().postTranslate(0.0f, motionEvent.getY() - this.bBT);
                            }
                        }
                        if (((float) this.bwl.height()) > curImageRect.height() && this.bwl.bottom < this.bBG.bottom) {
                            width = ((float) this.bwl.height()) / curImageRect.height();
                            getMainMatrix().postScale(width, width, (float) this.bwl.centerX(), (float) this.bwl.top);
                        }
                    }
                    vR();
                    this.bBL = true;
                    vO();
                    this.bBS = motionEvent.getX();
                    this.bBT = motionEvent.getY();
                } else {
                    this.bBL = false;
                }
                t(motionEvent);
                break;
            case 5:
                this.bBO = false;
                this.bBM = false;
                this.bBN = false;
                this.bBP = false;
                this.bBL = false;
                break;
        }
        return this.bBL;
    }

    private boolean vQ() {
        return this.bBO || this.bBM || this.bBN || this.bBP;
    }

    public final void vR() {
        this.bBD.set((float) (this.bwl.left - this.bBy), (float) (this.bwl.bottom - this.bBy), (float) (this.bwl.right + this.bBy), (float) (this.bwl.bottom + this.bBy));
        this.bBC.set((float) (this.bwl.left - this.bBy), (float) (this.bwl.top - this.bBy), (float) (this.bwl.right + this.bBy), (float) (this.bwl.top + this.bBy));
        this.bBE.set((float) (this.bwl.left - this.bBy), (float) (this.bwl.top - this.bBy), (float) (this.bwl.left + this.bBy), (float) (this.bwl.bottom + this.bBy));
        this.bBF.set((float) (this.bwl.right - this.bBy), (float) (this.bwl.top - this.bBy), (float) (this.bwl.right + this.bBy), (float) (this.bwl.bottom + this.bBy));
    }

    public final void vS() {
        float width = (((float) this.bBn.cfS().getWidth()) * 1.0f) / ((float) this.bBn.cfS().getHeight());
        int width2;
        if (width < (((float) this.bBG.width()) * 1.0f) / ((float) this.bBG.height())) {
            width2 = (int) ((((float) this.bBG.width()) - (width * ((float) this.bBG.height()))) / 2.0f);
            this.bwl.set(this.bBG.left + width2, this.bBG.top, this.bBG.right - width2, this.bBG.bottom);
        } else {
            width2 = (int) ((((float) this.bBG.height()) - (((float) this.bBG.width()) / width)) / 2.0f);
            this.bwl.set(this.bBG.left, this.bBG.top + width2, this.bBG.right, this.bBG.bottom - width2);
        }
        vR();
    }

    /* renamed from: vT */
    public final void c() {
        this.bBn.cfQ().getBaseBoardView().uUg = this.bBn.cfQ().getBaseBoardView().getRawBoardRect();
        RectF rectF = new RectF(this.bwl);
        Matrix matrix = new Matrix();
        getMainMatrix().invert(matrix);
        matrix.mapRect(rectF);
        Rect rect = new Rect();
        rectF.round(rect);
        this.bBn.cfQ().getBaseBoardView().m(rect);
        final com.tencent.mm.t.a aVar = new com.tencent.mm.t.a();
        aVar.bwl = new Rect(this.bwl);
        aVar.dnF.set(rect);
        this.bBn.cfQ().getBaseBoardView().a(new a$b() {
            public final void vU() {
                com.tencent.mm.t.a aVar = aVar;
                aVar.mMatrix.set(c.this.getMainMatrix());
                a aVar2 = (a) c.this.vG();
                if (aVar2.dai != null) {
                    aVar2.dai.clear();
                }
                ((a) c.this.vG()).a(aVar);
            }

            public final void onStart() {
            }
        }, 0.0f, true);
        this.bBn.cfQ().getActionBar().setVisibility(0);
    }
}
