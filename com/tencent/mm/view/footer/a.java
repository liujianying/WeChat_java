package com.tencent.mm.view.footer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.api.d;
import com.tencent.mm.bd.a$g;
import com.tencent.mm.bd.a.c;
import com.tencent.mm.bd.a.e;
import com.tencent.mm.bi.b;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;

public abstract class a extends View {
    public static final int[] uUQ = new int[]{-1, -16777216, -707825, -17592, -16535286, -15172610, -7054596, -449092};
    private b bBn;
    private Paint dnG;
    protected int gEm = -1;
    protected Paint uSU;
    private final float uUA = getResources().getDimension(c.feature_padding);
    private Bitmap uUB;
    private Bitmap uUC;
    private Bitmap uUD;
    private Bitmap uUE;
    private Bitmap uUF;
    private Bitmap uUG;
    protected Bitmap uUH;
    protected Bitmap uUI;
    protected int uUJ = -1;
    protected int uUK = -1;
    private Rect[] uUL;
    private Rect[] uUM;
    protected Rect uUN;
    protected boolean uUO;
    protected Paint uUP;
    protected int uUR = -1;
    protected int uUS = -1;
    private boolean uUT = true;

    protected abstract Bitmap a(d dVar, boolean z);

    public a(Context context, b bVar) {
        super(context);
        setId(e.base_footer_view_id);
        this.bBn = bVar;
        cCi();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        k(canvas);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r9) {
        /*
        r8 = this;
        r7 = 1;
        r0 = 0;
        r6 = -1;
        r1 = r9.getX();
        r2 = (int) r1;
        r1 = r9.getY();
        r3 = (int) r1;
        r1 = r9.getAction();
        switch(r1) {
            case 0: goto L_0x002e;
            case 1: goto L_0x0048;
            case 2: goto L_0x0014;
            case 3: goto L_0x0048;
            default: goto L_0x0014;
        };
    L_0x0014:
        return r7;
    L_0x0015:
        r1 = r8.cCj();
        if (r1 == 0) goto L_0x002c;
    L_0x001b:
        r1 = r8.uUN;
        if (r1 == 0) goto L_0x0044;
    L_0x001f:
        r1 = r8.uUN;
        r1 = r1.contains(r2, r3);
        if (r1 == 0) goto L_0x0044;
    L_0x0027:
        r8.uUO = r7;
        r8.postInvalidate();
    L_0x002c:
        r0 = r0 + 1;
    L_0x002e:
        r1 = r8.getFeatureCount();
        if (r0 >= r1) goto L_0x0014;
    L_0x0034:
        r1 = r8.uUL;
        r1 = r1[r0];
        r1 = r1.contains(r2, r3);
        if (r1 == 0) goto L_0x0015;
    L_0x003e:
        r8.uUR = r0;
        r8.postInvalidate();
        goto L_0x0014;
    L_0x0044:
        r8.fs(r2, r3);
        goto L_0x002c;
    L_0x0048:
        r1 = r0;
    L_0x0049:
        r4 = r8.getFeatureCount();
        if (r1 >= r4) goto L_0x008c;
    L_0x004f:
        r4 = r8.uUL;
        r4 = r4[r1];
        r4 = r4.contains(r2, r3);
        if (r4 == 0) goto L_0x00d4;
    L_0x0059:
        r4 = r8.uUR;
        if (r4 != r1) goto L_0x00d4;
    L_0x005d:
        r4 = r8.GU(r1);
        if (r4 == 0) goto L_0x006d;
    L_0x0063:
        r4 = r8.uUR;
        r5 = r8.gEm;
        if (r4 == r5) goto L_0x00bf;
    L_0x0069:
        r4 = r8.uUR;
        r8.gEm = r4;
    L_0x006d:
        r4 = r8.uUJ;
        r8.uUK = r4;
        r4 = r8.GU(r1);
        if (r4 == 0) goto L_0x00c2;
    L_0x0077:
        r1 = r8.gEm;
        r8.uUJ = r1;
        r1 = r8.getPresenter();
        r1 = r1.getSelectedFeatureListener();
        r4 = r8.gEm;
        r4 = r8.GT(r4);
        r1.a(r4);
    L_0x008c:
        r1 = r8.cCj();
        if (r1 == 0) goto L_0x00b3;
    L_0x0092:
        r1 = r8.uUN;
        if (r1 == 0) goto L_0x00d8;
    L_0x0096:
        r1 = r8.uUN;
        r1 = r1.contains(r2, r3);
        if (r1 == 0) goto L_0x00d8;
    L_0x009e:
        r1 = r8.uUO;
        if (r1 == 0) goto L_0x00d8;
    L_0x00a2:
        r1 = r8.getPresenter();
        r1 = r1.getSelectedFeatureListener();
        r2 = r8.gEm;
        r2 = r8.GT(r2);
        r1.a(r2, r6);
    L_0x00b3:
        r8.uUO = r0;
        r8.uUR = r6;
        r8.requestLayout();
        r8.postInvalidate();
        goto L_0x0014;
    L_0x00bf:
        r8.gEm = r6;
        goto L_0x006d;
    L_0x00c2:
        r8.uUJ = r1;
        r4 = r8.getPresenter();
        r4 = r4.getSelectedFeatureListener();
        r1 = r8.GT(r1);
        r4.a(r1);
        goto L_0x008c;
    L_0x00d4:
        r1 = r1 + 1;
        goto L_0x0049;
    L_0x00d8:
        r8.ft(r2, r3);
        goto L_0x00b3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.view.footer.a.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    protected void onMeasure(int i, int i2) {
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int dimension = (int) getResources().getDimension(c.feature_select_layout_height);
        if (cCj()) {
            dimension += getDetailHeight();
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(dimension, 1073741824));
        cCk();
    }

    protected b getPresenter() {
        return this.bBn;
    }

    protected void cCi() {
        this.uSU = new Paint(1);
        this.uSU.setColor(-16711936);
        this.uUP = new Paint(1);
        this.uUP.setColor(getResources().getColor(com.tencent.mm.bd.a.b.divider_line_color));
        this.uUP.setStrokeWidth(0.6f);
        this.dnG = new Paint(1);
        this.dnG.setStyle(Style.FILL);
        this.dnG.setStrokeCap(Cap.ROUND);
        this.uUI = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(a$g.undo_press));
        this.uUH = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(a$g.undo_normal));
        this.uUB = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(a$g.doodle_unselected));
        this.uUC = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(a$g.doodle_selected));
        this.uUD = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(a$g.text_unselected));
        this.uUE = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(a$g.text_selected));
        this.uUF = BitmapFactory.decodeResource(getResources(), com.tencent.mm.bd.a.d.emoji_unselected);
        this.uUG = BitmapFactory.decodeResource(getResources(), com.tencent.mm.bd.a.d.emoji_selected);
    }

    protected void fs(int i, int i2) {
        switch (3.qVw[GT(this.gEm).ordinal()]) {
            case 1:
                for (int i3 = 0; i3 < this.uUM.length; i3++) {
                    if (this.uUM[i3].contains(i, i2)) {
                        this.uUS = i3;
                        this.uUT = false;
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    protected void ft(int i, int i2) {
        switch (3.qVw[GT(this.gEm).ordinal()]) {
            case 1:
                int i3 = 0;
                while (this.uUM != null && i3 < this.uUM.length) {
                    if (this.uUM[i3].contains(i, i2) && i3 == this.uUS) {
                        getPresenter().getSelectedFeatureListener().a(d.bwN, i3);
                        return;
                    }
                    i3++;
                }
                return;
            default:
                return;
        }
    }

    private boolean cCj() {
        return getDetailHeight() > 0;
    }

    private Bitmap b(d dVar, boolean z) {
        Bitmap bitmap = null;
        switch (3.qVw[dVar.ordinal()]) {
            case 1:
                if (!z) {
                    bitmap = this.uUB;
                    break;
                }
                bitmap = this.uUC;
                break;
            case 2:
                if (!z) {
                    bitmap = this.uUD;
                    break;
                }
                bitmap = this.uUE;
                break;
            case 3:
                if (!z) {
                    bitmap = this.uUF;
                    break;
                }
                bitmap = this.uUG;
                break;
        }
        if (bitmap == null) {
            return a(dVar, z);
        }
        return bitmap;
    }

    protected int getFeatureCount() {
        return getPresenter().getFeatures().length;
    }

    protected float getIconWidth() {
        Bitmap b = b(d.bwN, false);
        return b == null ? 0.0f : (float) b.getWidth();
    }

    public static int getColor(int i) {
        if (i < 0 || i >= uUQ.length) {
            return -65536;
        }
        return uUQ[i];
    }

    public int getPaddingLeftAndRight() {
        return (int) (2.0f * this.uUA);
    }

    protected float getWidthSpacing() {
        return ((((float) getMeasuredWidth()) - (((float) getFeatureCount()) * getIconWidth())) - ((float) getPaddingLeftAndRight())) / ((float) (getFeatureCount() - 1));
    }

    protected float getHeightSpacing() {
        return (((float) (getMeasuredHeight() - getDetailHeight())) - getIconWidth()) / 2.0f;
    }

    protected int getDetailHeight() {
        if (GT(this.gEm) == d.bwN) {
            return (int) getResources().getDimension(c.feature_select_detail_layout_height);
        }
        return 0;
    }

    protected final d GT(int i) {
        if (i < 0 || i >= getFeatureCount()) {
            return d.bwM;
        }
        return getPresenter().getFeatures()[i];
    }

    protected void cCk() {
        if (this.uUL == null) {
            this.uUL = new Rect[getFeatureCount()];
        }
        int iconWidth = (int) (this.uUA + (getIconWidth() / 2.0f));
        int iconWidth2 = (int) getIconWidth();
        for (int i = 0; i < getFeatureCount(); i++) {
            this.uUL[i] = new Rect(iconWidth - iconWidth2, getDetailHeight(), iconWidth + iconWidth2, getDetailHeight() + getMeasuredHeight());
            iconWidth = (int) (((float) iconWidth) + (getWidthSpacing() + getIconWidth()));
        }
        if (GT(this.gEm) == d.bwN) {
            cCl();
        }
    }

    private void cCl() {
        int i;
        if (this.uUM == null) {
            this.uUM = new Rect[uUQ.length];
        }
        if (this.uUN == null) {
            this.uUN = new Rect();
        }
        float dimension = getResources().getDimension(c.doodle_radio);
        float measuredWidth = (((float) ((getMeasuredWidth() - getPaddingLeftAndRight()) - this.uUH.getWidth())) - ((2.0f * dimension) * ((float) uUQ.length))) / ((float) uUQ.length);
        int i2 = (int) (dimension * 2.0f);
        int paddingLeftAndRight = (int) ((((float) (getPaddingLeftAndRight() / 2)) + dimension) + 5.0f);
        int detailHeight = (int) (((((float) getDetailHeight()) - (dimension * 2.0f)) / 2.0f) + dimension);
        for (i = 0; i < uUQ.length; i++) {
            this.uUM[i] = new Rect(paddingLeftAndRight - i2, detailHeight - i2, paddingLeftAndRight + i2, detailHeight + i2);
            paddingLeftAndRight = (int) (((float) paddingLeftAndRight) + ((2.0f * dimension) + measuredWidth));
        }
        i = (getMeasuredWidth() - (getPaddingLeftAndRight() / 2)) - (this.uUH.getWidth() / 2);
        this.uUN.set(i - this.uUH.getWidth(), 0, i + this.uUH.getWidth(), getDetailHeight());
    }

    protected void k(Canvas canvas) {
        if (cCj()) {
            canvas.drawLine(0.0f, (float) getDetailHeight(), (float) getMeasuredWidth(), (float) getDetailHeight(), this.uUP);
            l(canvas);
        }
        float f = this.uUA;
        float heightSpacing = getHeightSpacing() + ((float) getDetailHeight());
        int i = 0;
        while (i < getFeatureCount()) {
            boolean z;
            d dVar = getPresenter().getFeatures()[i];
            if (this.uUR == i || i == this.gEm) {
                z = true;
            } else {
                z = false;
            }
            Bitmap b = b(dVar, z);
            if (b != null) {
                canvas.drawBitmap(b, f, heightSpacing, null);
            }
            f += getWidthSpacing() + getIconWidth();
            i++;
        }
    }

    protected void l(Canvas canvas) {
        if (GT(this.gEm) == d.bwN) {
            float dimension = getResources().getDimension(c.doodle_radio);
            float measuredWidth = (((float) ((getMeasuredWidth() - getPaddingLeftAndRight()) - this.uUH.getWidth())) - ((2.0f * dimension) * ((float) uUQ.length))) / ((float) uUQ.length);
            float aH = ((float) com.tencent.mm.bx.a.aH(1.5f)) + (((float) (getPaddingLeftAndRight() / 2)) + dimension);
            float detailHeight = ((((float) getDetailHeight()) - (dimension * 2.0f)) / 2.0f) + dimension;
            int i = 0;
            while (i < uUQ.length) {
                float f = 0.0f;
                if (this.uUS == i) {
                    f = (float) com.tencent.mm.bx.a.aH(2.0f);
                    this.uUT = false;
                } else if (this.uUT && i == 2) {
                    f = (float) com.tencent.mm.bx.a.aH(2.0f);
                }
                this.dnG.setColor(-1);
                canvas.drawCircle(aH, detailHeight, (((float) com.tencent.mm.bx.a.aH(1.5f)) + dimension) + f, this.dnG);
                this.dnG.setColor(uUQ[i]);
                canvas.drawCircle(aH, detailHeight, f + dimension, this.dnG);
                aH += (2.0f * dimension) + measuredWidth;
                i++;
            }
            Paint paint = new Paint();
            if (vK()) {
                paint.setAlpha(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE);
            } else {
                paint.setAlpha(JsApiSetBackgroundAudioState.CTRL_INDEX);
            }
            Bitmap bitmap = (this.uUO && vK()) ? this.uUI : this.uUH;
            canvas.drawBitmap(bitmap, (float) ((getMeasuredWidth() - (getPaddingLeftAndRight() / 2)) - this.uUH.getWidth()), (float) ((getDetailHeight() - this.uUH.getHeight()) / 2), paint);
        }
    }

    protected final boolean vK() {
        com.tencent.mm.d.b b = getPresenter().b(getCurFeatureType());
        return b == null ? false : b.vK();
    }

    protected boolean GU(int i) {
        switch (3.qVw[GT(i).ordinal()]) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    public d getCurFeatureType() {
        return GT(this.uUJ);
    }

    public void setCurFeatureType(d dVar) {
        int i = 0;
        while (i < getFeatureCount()) {
            if (getPresenter().getFeatures()[i] == dVar) {
                break;
            }
            i++;
        }
        i = -1;
        if (GU(i)) {
            this.gEm = i;
        } else {
            this.gEm = -1;
        }
        this.uUJ = i;
        requestLayout();
        invalidate();
    }

    public final void cCm() {
        this.uUJ = this.uUK;
        requestLayout();
        invalidate();
    }

    public void setFooterVisible(boolean z) {
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.bd.a.a.alpha_in);
            loadAnimation.setAnimationListener(new 1(this));
            startAnimation(loadAnimation);
            return;
        }
        loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.bd.a.a.alpha_out);
        loadAnimation.setAnimationListener(new 2(this));
        startAnimation(loadAnimation);
    }
}
