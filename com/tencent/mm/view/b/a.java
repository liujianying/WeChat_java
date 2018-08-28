package com.tencent.mm.view.b;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.bi.b;
import com.tencent.mm.sdk.platformtools.x;

public class a extends View {
    private boolean bBR = false;
    private b bBn;
    protected Matrix bBo;
    private Rect bBp;
    private Rect dnF;
    private float dnM = 1.0f;
    private float inM;
    private float inN;
    protected Matrix uUf;
    public Rect uUg;
    private Rect uUh;
    private Rect uUi;
    private Runnable uUj;
    protected float uUk;
    protected float uUl;
    private boolean uUm = true;
    float[] values = new float[9];

    public b getPresenter() {
        return this.bBn;
    }

    public a(Context context, b bVar) {
        super(context);
        this.bBn = bVar;
        this.bBo = new Matrix();
        this.uUf = new Matrix();
        this.bBp = new Rect();
        this.uUg = new Rect();
        this.uUh = new Rect();
        this.dnF = new Rect();
        this.uUi = new Rect();
        Bitmap cfS = bVar.cfS();
        if (cfS != null) {
            this.dnF.set(0, 0, cfS.getWidth(), cfS.getHeight());
            this.bBp.set(this.dnF);
            this.uUi.set(this.dnF);
        }
        if (!cCg() && bVar.getConfig().rect != null) {
            Rect rect = bVar.getConfig().rect;
            this.bBp.set(0, 0, rect.width(), rect.height());
            this.bBo.postTranslate(0.0f, (float) rect.top);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        x.i("changelcai", "[onLayout] %s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.uUg.set(i, i2, i3, i4);
            this.uUh.set(this.uUg);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0, Mode.CLEAR);
        canvas.setMatrix(this.bBo);
        getPresenter().onDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getPresenter().cfT()) {
            if (motionEvent.getAction() == 0) {
                this.inM = motionEvent.getX();
                this.inN = motionEvent.getY();
            }
            if (motionEvent.getAction() == 1) {
                removeCallbacks(this.uUj);
                long j = 0;
                if (this.bBR) {
                    j = 700;
                }
                if (getPresenter().cfR().vE() != com.tencent.mm.d.a.bBj) {
                    Runnable anonymousClass1 = new Runnable() {
                        public final void run() {
                            if (a.this.getPresenter().cfQ().bwY) {
                                a.this.getPresenter().cfQ().setFooterVisible(false);
                                a.this.getPresenter().cfQ().setActionBarVisible(false);
                                return;
                            }
                            a.this.getPresenter().cfQ().setFooterVisible(true);
                            a.this.getPresenter().cfQ().setActionBarVisible(true);
                        }
                    };
                    this.uUj = anonymousClass1;
                    postDelayed(anonymousClass1, j);
                } else {
                    getPresenter().cfQ().mK(true);
                    if (getPresenter().cfQ().bwY) {
                        getPresenter().cfQ().setFooterVisible(false);
                        getPresenter().cfQ().setActionBarVisible(false);
                    } else {
                        com.tencent.mm.view.a cfQ = getPresenter().cfQ();
                        boolean z = cfQ.uSu.getVisibility() == 0 || cfQ.getTextEditView().getVisibility() == 0;
                        if (!z) {
                            getPresenter().cfQ().setFooterVisible(true);
                            getPresenter().cfQ().setActionBarVisible(true);
                        }
                    }
                    getPresenter().cfQ().getBaseFooterView().cCm();
                }
                this.bBR = false;
            } else if (motionEvent.getAction() == 2) {
                if (Math.abs(motionEvent.getX() - this.inM) >= 3.0f || Math.abs(motionEvent.getY() - this.inN) >= 3.0f) {
                    this.bBR = true;
                    removeCallbacks(this.uUj);
                    if (getPresenter().cfQ().bwY) {
                        getPresenter().cfQ().setFooterVisible(false);
                        getPresenter().cfQ().setActionBarVisible(false);
                    }
                }
                this.inM = motionEvent.getX();
                this.inN = motionEvent.getY();
            }
        }
        if (!getPresenter().I(motionEvent) && cCg()) {
            R(motionEvent);
        }
        return true;
    }

    protected void R(MotionEvent motionEvent) {
    }

    protected boolean cCf() {
        return this.uUm;
    }

    public void setOneFingerMoveEnable(boolean z) {
        this.uUm = z;
    }

    public boolean cCg() {
        return true;
    }

    public Rect getAliveRect() {
        return this.bBp;
    }

    public Matrix getMainMatrix() {
        return this.bBo;
    }

    public float getInitScale() {
        return cCg() ? this.dnM : 1.0f;
    }

    public Rect getBoardRect() {
        return this.uUg;
    }

    public Rect getRawBoardRect() {
        return this.uUh;
    }

    public final void cCh() {
        float width;
        float height;
        float height2;
        Rect rawImageRect = getRawImageRect();
        if (a(this.bBo) % 180.0f == 0.0f) {
            width = (((float) rawImageRect.width()) * 1.0f) / ((float) rawImageRect.height());
        } else {
            width = (((float) rawImageRect.height()) * 1.0f) / ((float) rawImageRect.width());
        }
        if (width < (((float) getBoardRect().width()) * 1.0f) / ((float) getBoardRect().height())) {
            width = ((float) getBoardRect().width()) / width;
            height = (float) getBoardRect().height();
        } else {
            height = ((float) getBoardRect().width()) / width;
            width = (float) getBoardRect().height();
        }
        if (a(this.bBo) % 180.0f == 0.0f) {
            height2 = (1.0f * height) / ((float) rawImageRect.height());
        } else {
            height2 = (1.0f * height) / ((float) rawImageRect.width());
        }
        if (a(this.bBo) % 180.0f == 0.0f) {
            width = (width * 1.0f) / ((float) rawImageRect.height());
        } else {
            width = (width * 1.0f) / ((float) rawImageRect.width());
        }
        this.bBo.postScale(height2, height2, (float) rawImageRect.centerX(), (float) rawImageRect.centerY());
        RectF curImageRect = getCurImageRect();
        int centerX = (int) curImageRect.centerX();
        this.bBo.postTranslate((float) (getBoardRect().centerX() - centerX), (float) (getBoardRect().centerY() - ((int) curImageRect.centerY())));
        this.uUf.set(this.bBo);
        this.uUk = c(this.uUf) * 3.0f;
        this.uUl = c(this.uUf) * 1.0f;
        if (this.uUk < width) {
            this.uUk = width * 1.2f;
        }
    }

    public final void a(b bVar, float f, boolean z) {
        float width;
        float height;
        RectF curImageRect = getCurImageRect();
        int centerX = (int) curImageRect.centerX();
        int centerY = (int) curImageRect.centerY();
        int centerX2 = getBoardRect().centerX() - centerX;
        int centerY2 = getBoardRect().centerY() - centerY;
        if (f % 180.0f == 0.0f) {
            width = (1.0f * curImageRect.width()) / curImageRect.height();
        } else {
            width = (1.0f * curImageRect.height()) / curImageRect.width();
        }
        if (width < (1.0f * ((float) getBoardRect().width())) / ((float) getBoardRect().height())) {
            getBoardRect().width();
            width = (float) getBoardRect().height();
        } else {
            getBoardRect().height();
            width = ((float) getBoardRect().width()) / width;
        }
        if (f % 180.0f == 0.0f) {
            height = (width * 1.0f) / curImageRect.height();
        } else {
            height = (width * 1.0f) / curImageRect.width();
        }
        a aVar = new a(this, height, (float) centerX2, (float) centerY2, (float) centerX, (float) centerY, f, z);
        aVar.uUr = bVar;
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, 166.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, aVar.uUo});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, aVar.uUp});
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("rotation", new float[]{0.0f, aVar.cY});
        aVar.bwg = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
        aVar.bwg.addUpdateListener(new a$a$1(aVar));
        aVar.bwg.addListener(new 2(aVar));
        aVar.bwg.setInterpolator(new LinearInterpolator());
        aVar.bwg.setDuration(166);
        aVar.bwg.start();
    }

    public RectF getCurImageRect() {
        RectF rectF = new RectF(getRawImageRect());
        this.bBo.mapRect(rectF);
        return rectF;
    }

    public final void m(Rect rect) {
        this.dnF.set(rect);
        this.bBp.set(rect);
        x.i("MicroMsg.BaseBoardView", "[resetImageRect] rect");
    }

    public Rect getRawImageRect() {
        return this.dnF;
    }

    public Rect getImageBitmapRect() {
        return this.uUi;
    }

    public float getMinScale() {
        return this.uUl;
    }

    public float getMaxScale() {
        return this.uUk;
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.values);
        return this.values[i];
    }

    protected final float c(Matrix matrix) {
        float a = a(matrix, 3);
        float a2 = a(matrix, 0);
        return (float) Math.sqrt((double) ((a * a) + (a2 * a2)));
    }

    public float getCurScale() {
        return c(this.bBo);
    }

    public final float a(Matrix matrix) {
        return (float) Math.round(Math.atan2((double) a(matrix, 1), (double) a(matrix, 0)) * 57.29577951308232d);
    }
}
