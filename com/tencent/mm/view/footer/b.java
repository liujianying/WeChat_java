package com.tencent.mm.view.footer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View.MeasureSpec;
import com.tencent.mm.api.d;
import com.tencent.mm.bd.a$d;
import com.tencent.mm.bd.a$h;
import com.tencent.mm.bd.a.c;
import com.tencent.mm.bd.a.g;
import com.tencent.smtt.sdk.WebView;

public final class b extends a {
    private Bitmap uUV;
    private Bitmap uUW;
    private Bitmap uUX;
    private Bitmap uUY;
    private Bitmap uUZ;
    private Bitmap uVa;
    private Bitmap uVb;
    private Bitmap uVc;
    private Bitmap uVd;
    private Bitmap uVe;
    private Bitmap uVf;
    private Bitmap uVg;
    private Bitmap uVh;
    private Bitmap uVi;
    private Rect[] uVj;
    private Rect[] uVk;
    private boolean uVl;
    private boolean uVm;
    private boolean uVn;
    private boolean uVo;
    private boolean uVp = true;
    private int uVq = -1;
    private Paint uvt;

    /* renamed from: com.tencent.mm.view.footer.b$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] qVw = new int[d.values().length];

        static {
            try {
                qVw[d.bwR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                qVw[d.bwQ.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public b(Context context, com.tencent.mm.bi.b bVar) {
        super(context, bVar);
    }

    protected final void cCi() {
        super.cCi();
        this.uvt = new Paint(1);
        this.uvt.setTextSize(getResources().getDimension(c.crop_reset_text_size));
        this.uUZ = BitmapFactory.decodeResource(getResources(), a$d.mosaic_one_unselected);
        this.uVa = BitmapFactory.decodeResource(getResources(), a$d.mosaic_one_selected);
        this.uVb = BitmapFactory.decodeResource(getResources(), a$d.mosaic_two_unselected);
        this.uVc = BitmapFactory.decodeResource(getResources(), a$d.mosaic_two_selected);
        this.uUW = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(g.mosaic_unselected));
        this.uUV = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(g.mosaic_selected));
        this.uUX = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(g.crop_unselected));
        this.uUY = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(g.crop_selected));
        this.uVd = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(g.rotation_normal));
        this.uVe = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(g.rotation_press));
        this.uVg = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(g.sure_crop_press));
        this.uVf = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(g.sure_crop_normal));
        this.uVh = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(g.cancel_crop_press));
        this.uVi = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(g.cancel_crop_normal));
    }

    protected final void onMeasure(int i, int i2) {
        if (getCurFeatureType() != d.bwR) {
            super.onMeasure(i, i2);
            return;
        }
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        setMeasuredDimension(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(getDetailHeight(), 1073741824));
        cCk();
    }

    protected final void k(Canvas canvas) {
        if (getCurFeatureType() != d.bwR) {
            super.k(canvas);
        } else {
            l(canvas);
        }
    }

    protected final Bitmap a(d dVar, boolean z) {
        if (dVar == d.bwR) {
            return z ? this.uUY : this.uUX;
        } else {
            if (dVar == d.bwQ) {
                return z ? this.uUV : this.uUW;
            } else {
                return null;
            }
        }
    }

    protected final int getDetailHeight() {
        int detailHeight = super.getDetailHeight();
        if (detailHeight != 0) {
            return detailHeight;
        }
        if (getCurFeatureType() == d.bwQ) {
            return (int) getResources().getDimension(c.feature_select_detail_layout_height);
        }
        if (getCurFeatureType() == d.bwR) {
            return (int) (getResources().getDimension(c.feature_select_layout_height) + getResources().getDimension(c.crop_rotation_layout_height));
        }
        return detailHeight;
    }

    protected final boolean GU(int i) {
        boolean GU = super.GU(i);
        switch (AnonymousClass1.qVw[GT(i).ordinal()]) {
            case 1:
            case 2:
                return true;
            default:
                return GU;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void fs(int r5, int r6) {
        /*
        r4 = this;
        r0 = 0;
        r3 = 1;
        super.fs(r5, r6);
        r1 = com.tencent.mm.view.footer.b.AnonymousClass1.qVw;
        r2 = r4.gEm;
        r2 = r4.GT(r2);
        r2 = r2.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x002d;
            case 2: goto L_0x0019;
            default: goto L_0x0016;
        };
    L_0x0016:
        return;
    L_0x0017:
        r0 = r0 + 1;
    L_0x0019:
        r1 = r4.uVj;
        r1 = r1.length;
        if (r0 >= r1) goto L_0x0016;
    L_0x001e:
        r1 = r4.uVj;
        r1 = r1[r0];
        r1 = r1.contains(r5, r6);
        if (r1 == 0) goto L_0x0017;
    L_0x0028:
        r4.uVq = r0;
        goto L_0x0016;
    L_0x002b:
        r0 = r0 + 1;
    L_0x002d:
        r1 = r4.uVk;
        r1 = r1.length;
        if (r0 >= r1) goto L_0x0016;
    L_0x0032:
        r1 = r4.uVk;
        r1 = r1[r0];
        r1 = r1.contains(r5, r6);
        if (r1 == 0) goto L_0x002b;
    L_0x003c:
        if (r0 != 0) goto L_0x0041;
    L_0x003e:
        r4.uVm = r3;
        goto L_0x0016;
    L_0x0041:
        if (r0 != r3) goto L_0x0046;
    L_0x0043:
        r4.uVl = r3;
        goto L_0x0016;
    L_0x0046:
        r1 = 2;
        if (r0 != r1) goto L_0x004c;
    L_0x0049:
        r4.uVn = r3;
        goto L_0x0016;
    L_0x004c:
        r1 = 3;
        if (r0 != r1) goto L_0x0016;
    L_0x004f:
        r4.uVo = r3;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.view.footer.b.fs(int, int):void");
    }

    protected final void ft(int i, int i2) {
        int i3 = 0;
        super.ft(i, i2);
        switch (AnonymousClass1.qVw[GT(this.gEm).ordinal()]) {
            case 1:
                int i4 = 0;
                while (this.uVk != null && i4 < this.uVk.length) {
                    if (this.uVk[i4].contains(i, i2)) {
                        if ((i4 == 0 && this.uVm) || ((i4 == 1 && this.uVl) || ((i4 == 2 && this.uVn) || (i4 == 3 && this.uVo)))) {
                            getPresenter().getSelectedFeatureListener().a(d.bwR, i4);
                            this.uUJ = this.gEm;
                        }
                        this.uVm = false;
                        this.uVl = false;
                        this.uVn = false;
                        this.uVo = false;
                        return;
                    }
                    i4++;
                }
                return;
            case 2:
                break;
            default:
                return;
        }
        while (this.uVj != null && i3 < this.uVj.length) {
            if (this.uVj[i3].contains(i, i2) && i3 == this.uVq) {
                getPresenter().getSelectedFeatureListener().a(d.bwQ, i3);
                this.uUJ = this.gEm;
                return;
            }
            i3++;
        }
    }

    protected final void cCk() {
        super.cCk();
        float measuredWidth;
        int width;
        int detailHeight;
        int width2;
        int width3;
        if (getCurFeatureType() == d.bwQ) {
            if (this.uVj == null) {
                this.uVj = new Rect[2];
            }
            if (this.uUN == null) {
                this.uUN = new Rect();
            }
            measuredWidth = ((float) ((((getMeasuredWidth() - getPaddingLeftAndRight()) - this.uUH.getWidth()) - this.uVc.getWidth()) - this.uUZ.getWidth())) / 3.0f;
            width = (int) (((float) (this.uVb.getWidth() / 2)) + measuredWidth);
            detailHeight = ((getDetailHeight() - this.uVb.getWidth()) / 2) + (this.uVb.getWidth() / 2);
            width2 = this.uVb.getWidth() * 2;
            this.uVj[0] = new Rect(width - width2, detailHeight - width2, width + width2, detailHeight + width2);
            width3 = (int) ((measuredWidth + ((float) this.uVb.getWidth())) + ((float) width));
            this.uVj[1] = new Rect(width3 - width2, detailHeight - width2, width3 + width2, detailHeight + width2);
            width3 = (getMeasuredWidth() - (getPaddingLeftAndRight() / 2)) - (this.uUH.getWidth() / 2);
            this.uUN.set(width3 - this.uUH.getWidth(), 0, width3 + this.uUH.getWidth(), getDetailHeight());
        } else if (getCurFeatureType() == d.bwR) {
            if (this.uVk == null) {
                this.uVk = new Rect[4];
            }
            width3 = (int) getResources().getDimension(c.crop_rotation_layout_height);
            float height = (float) ((width3 / 2) - (this.uVe.getHeight() / 2));
            measuredWidth = ((float) width3) + ((getResources().getDimension(c.feature_select_layout_height) / 2.0f) - ((float) (this.uVi.getHeight() / 2)));
            width = (int) (height + ((float) (this.uVi.getHeight() / 2)));
            detailHeight = (int) (((1.0f * ((float) getPaddingLeftAndRight())) / 2.0f) + ((float) (this.uVi.getHeight() / 2)));
            width2 = this.uVi.getHeight();
            this.uVk[0] = new Rect(detailHeight - width2, width - width2, detailHeight + width2, width + width2);
            width3 = (int) (measuredWidth + ((float) (this.uVi.getHeight() / 2)));
            this.uVk[1] = new Rect(detailHeight - width2, width3 - width2, detailHeight + width2, width3 + width2);
            width = (getMeasuredWidth() - (getPaddingLeftAndRight() / 2)) - (this.uVi.getHeight() / 2);
            this.uVk[2] = new Rect(width - width2, width3 - width2, width + width2, width3 + width2);
            width = getMeasuredWidth() / 2;
            this.uVk[3] = new Rect(width - width2, width3 - width2, width + width2, width3 + width2);
        }
    }

    protected final void l(Canvas canvas) {
        super.l(canvas);
        float measuredWidth;
        float detailHeight;
        if (getCurFeatureType() == d.bwQ) {
            Paint paint = new Paint();
            if (vK()) {
                paint.setAlpha(WebView.NORMAL_MODE_ALPHA);
            } else {
                paint.setAlpha(160);
            }
            Bitmap bitmap = (this.uUO && vK()) ? this.uUI : this.uUH;
            canvas.drawBitmap(bitmap, (float) ((getMeasuredWidth() - (getPaddingLeftAndRight() / 2)) - this.uUH.getWidth()), (float) ((getDetailHeight() - this.uUH.getHeight()) / 2), paint);
            measuredWidth = ((float) ((((getMeasuredWidth() - getPaddingLeftAndRight()) - this.uUH.getWidth()) - this.uVc.getWidth()) - this.uUZ.getWidth())) / 3.0f;
            detailHeight = (((float) (getDetailHeight() - this.uVc.getHeight())) * 1.0f) / 2.0f;
            if (this.uVp) {
                this.uVq = 0;
                this.uVp = false;
            }
            if (this.uVq == 0) {
                canvas.drawBitmap(this.uVa, measuredWidth, detailHeight, null);
                canvas.drawBitmap(this.uVb, (measuredWidth + measuredWidth) + ((float) this.uVc.getWidth()), detailHeight, null);
            } else if (this.uVq == 1) {
                canvas.drawBitmap(this.uUZ, measuredWidth, detailHeight, null);
                canvas.drawBitmap(this.uVc, (measuredWidth + measuredWidth) + ((float) this.uVc.getWidth()), detailHeight, null);
            } else {
                canvas.drawBitmap(this.uUZ, measuredWidth, detailHeight, null);
                canvas.drawBitmap(this.uVb, (measuredWidth + measuredWidth) + ((float) this.uVc.getWidth()), detailHeight, null);
            }
        } else if (getCurFeatureType() == d.bwR) {
            int dimension = (int) getResources().getDimension(c.crop_rotation_layout_height);
            canvas.drawLine(0.0f, (float) dimension, (float) getMeasuredWidth(), (float) dimension, this.uUP);
            measuredWidth = ((getResources().getDimension(c.feature_select_layout_height) / 2.0f) - ((float) (this.uVi.getHeight() / 2))) + ((float) dimension);
            detailHeight = (((float) getPaddingLeftAndRight()) * 1.0f) / 2.0f;
            float height = (float) ((dimension / 2) - (this.uVe.getHeight() / 2));
            if (this.uVm) {
                canvas.drawBitmap(this.uVe, detailHeight, height, null);
            } else {
                canvas.drawBitmap(this.uVd, detailHeight, height, null);
            }
            if (this.uVn) {
                canvas.drawBitmap(this.uVg, (((float) getMeasuredWidth()) - detailHeight) - ((float) this.uVi.getWidth()), measuredWidth, null);
            } else {
                canvas.drawBitmap(this.uVf, (((float) getMeasuredWidth()) - detailHeight) - ((float) this.uVi.getWidth()), measuredWidth, null);
            }
            if (this.uVl) {
                canvas.drawBitmap(this.uVh, detailHeight, measuredWidth, null);
            } else {
                canvas.drawBitmap(this.uVi, detailHeight, measuredWidth, null);
            }
            measuredWidth = getResources().getDimension(c.crop_reset_text_size) * 2.0f;
            detailHeight = (((getResources().getDimension(c.crop_reset_text_size) - 8.0f) / 2.0f) + (getResources().getDimension(c.feature_select_layout_height) / 2.0f)) + ((float) dimension);
            height = (float) (getMeasuredWidth() / 2);
            if (this.uVo) {
                this.uvt.setColor(-1);
                this.uvt.setAlpha(160);
                canvas.drawText(getResources().getString(a$h.crop_reset), height - (measuredWidth / 2.0f), detailHeight, this.uvt);
            } else if (vK()) {
                this.uvt.setColor(-1);
                this.uvt.setAlpha(WebView.NORMAL_MODE_ALPHA);
                canvas.drawText(getResources().getString(a$h.crop_reset), height - (measuredWidth / 2.0f), detailHeight, this.uvt);
            } else {
                this.uvt.setColor(-1);
                this.uvt.setAlpha(100);
                canvas.drawText(getResources().getString(a$h.crop_reset), height - (measuredWidth / 2.0f), detailHeight, this.uvt);
            }
        }
    }
}
