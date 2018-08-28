package com.tencent.mm.plugin.walletlock.gesture.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.walletlock.a$h;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.a.c;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternLockView extends View {
    private static Bitmap pHR = null;
    private static Bitmap pHS = null;
    private static Bitmap pHT = null;
    private static Bitmap pHU = null;
    private int iGa;
    private Paint pHB = new Paint();
    private Paint pHC = new Paint();
    private Path pHD = new Path();
    private Matrix pHE = new Matrix();
    private Rect pHF = new Rect();
    private Rect pHG = new Rect();
    private ArrayList<f> pHH = new ArrayList(9);
    private boolean[][] pHI = ((boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{3, 3}));
    private int pHJ = c.pIj;
    private int pHK = 6;
    private int pHL = 200;
    private float pHM = 0.66f;
    private boolean pHN = false;
    private boolean pHO = true;
    private boolean pHP = false;
    private b pHQ;
    private float pHV;
    private float pHW;
    private boolean pHX;
    private long pHY;
    private float pHZ;
    private float pIa;
    private a pIb;
    private int rH;
    private int rI;

    public PatternLockView(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        if (isInEditMode()) {
            i = -1;
        } else {
            i = getResources().getColor(b.gesture_color_norm_line);
        }
        this.iGa = i;
        this.pHQ = b.pId;
        this.pHV = -1.0f;
        this.pHW = -1.0f;
        this.pHX = false;
        this.pHY = 0;
        this.rH = 0;
        this.rI = 0;
        this.pHZ = 0.0f;
        this.pIa = 0.0f;
        this.pIb = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a$h.mm_patternlock_view);
        this.pHO = obtainStyledAttributes.getBoolean(a$h.mm_patternlock_view_showLine, this.pHO);
        this.pHL = obtainStyledAttributes.getInt(a$h.mm_patternlock_view_lineAlpha, this.pHL);
        this.pHK = obtainStyledAttributes.getInt(a$h.mm_patternlock_view_lineWidth, this.pHK);
        this.pHN = obtainStyledAttributes.getBoolean(a$h.mm_patternlock_view_hapticFeedback, this.pHN);
        switch (obtainStyledAttributes.getInt(a$h.mm_patternlock_view_shapeMode, this.pHJ - 1)) {
            case 0:
                this.pHJ = c.pIj;
                break;
            case 1:
                this.pHJ = c.pIk;
                break;
            default:
                this.pHJ = c.pIj;
                break;
        }
        obtainStyledAttributes.recycle();
        setClickable(true);
        this.pHC.setStyle(Style.STROKE);
        this.pHC.setStrokeJoin(Join.ROUND);
        this.pHC.setStrokeCap(Cap.ROUND);
        this.pHC.setAntiAlias(true);
        this.pHC.setDither(false);
        this.pHC.setAlpha(this.pHL);
        this.pHB.setAntiAlias(true);
        this.pHB.setDither(true);
        if (!isInEditMode()) {
            if (pHR == null) {
                pHR = r(a.f(getContext(), c.gesture_node_normal));
                Bitmap r = r(a.f(getContext(), c.gesture_node_touched));
                pHS = r;
                pHT = r;
                pHU = r(a.f(getContext(), c.gesture_node_touched_wrong));
            }
            this.pHK = (int) (((float) this.pHK) * com.tencent.mm.sdk.platformtools.c.chu().density);
            Bitmap[] bitmapArr = new Bitmap[]{pHR, pHS, pHT, pHU};
            for (i = 0; i < 4; i++) {
                Bitmap bitmap = bitmapArr[i];
                this.rH = Math.max(bitmap.getWidth(), this.rH);
                this.rI = Math.max(bitmap.getHeight(), this.rI);
            }
        }
    }

    private static Bitmap r(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static String cK(List<f> list) {
        if (list == null) {
            throw new IllegalArgumentException("pattern is null");
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            f fVar = (f) list.get(i);
            bArr[i] = (byte) (fVar.pGX + (fVar.pGW * 3));
        }
        return new String(bArr);
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), cK(this.pHH), this.pHQ.ordinal(), this.pHO, this.pHP, this.pHN);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        b bVar = b.pId;
        String str = savedState.pIh;
        if (str == null) {
            throw new IllegalArgumentException("Serialized pattern is null");
        }
        List arrayList = new ArrayList();
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            arrayList.add(f.eb(b / 3, b % 3));
        }
        a(bVar, arrayList);
        this.pHQ = b.values()[savedState.pIi];
        this.pHO = savedState.pHO;
        this.pHP = savedState.pHP;
        this.pHN = savedState.pHN;
    }

    protected int getSuggestedMinimumWidth() {
        return (int) ((3.0d * ((double) ((float) this.rH))) / ((double) getResources().getDisplayMetrics().density));
    }

    protected int getSuggestedMinimumHeight() {
        return (int) ((3.0d * ((double) ((float) this.rI))) / ((double) getResources().getDisplayMetrics().density));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.pHZ = ((float) ((i - getPaddingLeft()) - getPaddingRight())) / 3.0f;
        this.pIa = ((float) ((i2 - getPaddingTop()) - getPaddingBottom())) / 3.0f;
    }

    private static int ec(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        switch (MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                return Math.max(size, i2);
            case 0:
                return i2;
            default:
                return size;
        }
    }

    protected void onMeasure(int i, int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int ec = ec(i, suggestedMinimumWidth);
        suggestedMinimumWidth = ec(i2, suggestedMinimumHeight);
        if (this.pHJ == c.pIj) {
            ec = Math.min(ec, suggestedMinimumWidth);
            suggestedMinimumWidth = ec;
            suggestedMinimumHeight = ec;
        } else {
            suggestedMinimumHeight = ec;
        }
        setMeasuredDimension(suggestedMinimumHeight, suggestedMinimumWidth);
    }

    protected void onDraw(Canvas canvas) {
        int elapsedRealtime;
        int i;
        f fVar;
        Object obj;
        float zz;
        float zA;
        float f;
        ArrayList arrayList = this.pHH;
        int size = arrayList.size();
        boolean[][] zArr = this.pHI;
        if (this.pHQ == b.pIf) {
            elapsedRealtime = ((int) (SystemClock.elapsedRealtime() - this.pHY)) % ((size + 1) * 700);
            i = elapsedRealtime / 700;
            bRT();
            for (int i2 = 0; i2 < i; i2++) {
                fVar = (f) arrayList.get(i2);
                zArr[fVar.pGW][fVar.pGX] = true;
            }
            obj = (i <= 0 || i >= size) ? null : 1;
            if (obj != null) {
                float f2 = ((float) (elapsedRealtime % 700)) / 700.0f;
                fVar = (f) arrayList.get(i - 1);
                float zz2 = zz(fVar.pGX);
                float zA2 = zA(fVar.pGW);
                fVar = (f) arrayList.get(i);
                zz = (zz(fVar.pGX) - zz2) * f2;
                zA = (zA(fVar.pGW) - zA2) * f2;
                this.pHV = zz2 + zz;
                this.pHW = zA + zA2;
            }
            invalidate();
        }
        this.pHC.setColor(this.iGa);
        this.pHC.setStrokeWidth((float) this.pHK);
        Path path = this.pHD;
        path.rewind();
        obj = (this.pHO || this.pHQ == b.pIe) ? 1 : null;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        float f3 = this.pHZ;
        float f4 = this.pIa;
        boolean z = (this.pHB.getFlags() & 2) != 0;
        this.pHB.setFilterBitmap(true);
        elapsedRealtime = 0;
        while (true) {
            i = elapsedRealtime;
            if (i >= 3) {
                break;
            }
            f = (((float) i) * f4) + ((float) paddingTop);
            for (elapsedRealtime = 0; elapsedRealtime < 3; elapsedRealtime++) {
                float f5 = ((float) paddingLeft) + (((float) elapsedRealtime) * f3);
                if (!zArr[i][elapsedRealtime]) {
                    a(canvas, (int) f5, (int) f, zArr[i][elapsedRealtime]);
                }
            }
            elapsedRealtime = i + 1;
        }
        if (obj != null) {
            Object obj2 = null;
            for (elapsedRealtime = 0; elapsedRealtime < size; elapsedRealtime++) {
                fVar = (f) arrayList.get(elapsedRealtime);
                if (!zArr[fVar.pGW][fVar.pGX]) {
                    break;
                }
                obj2 = 1;
                f = zz(fVar.pGX);
                zA = zA(fVar.pGW);
                if (elapsedRealtime == 0) {
                    path.moveTo(f, zA);
                } else {
                    path.lineTo(f, zA);
                }
            }
            if ((this.pHX || this.pHQ == b.pIf) && obj2 != null) {
                path.lineTo(this.pHV, this.pHW);
            }
            canvas.drawPath(path, this.pHC);
        }
        int i3 = 0;
        while (true) {
            elapsedRealtime = i3;
            if (elapsedRealtime < 3) {
                zz = (((float) elapsedRealtime) * f4) + ((float) paddingTop);
                for (i3 = 0; i3 < 3; i3++) {
                    float f6 = ((float) paddingLeft) + (((float) i3) * f3);
                    if (zArr[elapsedRealtime][i3]) {
                        a(canvas, (int) f6, (int) zz, zArr[elapsedRealtime][i3]);
                    }
                }
                i3 = elapsedRealtime + 1;
            } else {
                this.pHB.setFilterBitmap(z);
                return;
            }
        }
    }

    private void a(Canvas canvas, int i, int i2, boolean z) {
        Bitmap bitmap;
        if (!z || (!this.pHO && this.pHQ != b.pIe)) {
            bitmap = pHR;
        } else if (this.pHX) {
            bitmap = pHS;
        } else if (this.pHQ == b.pIe) {
            bitmap = pHU;
        } else if (this.pHQ == b.pId || this.pHQ == b.pIf) {
            bitmap = pHT;
        } else {
            throw new IllegalStateException("unknown display mode " + this.pHQ);
        }
        int i3 = this.rH;
        int i4 = this.rI;
        i3 = (int) ((this.pHZ - ((float) i3)) * 0.5f);
        i4 = (int) ((this.pIa - ((float) i4)) * 0.5f);
        float f = getResources().getDisplayMetrics().density;
        float min = Math.min((this.pHZ - (33.0f * f)) / ((float) this.rH), 1.0f);
        f = Math.min((this.pIa - (f * 33.0f)) / ((float) this.rI), 1.0f);
        this.pHE.setTranslate((float) (i3 + i), (float) (i4 + i2));
        this.pHE.preTranslate((float) (this.rH / 2), (float) (this.rI / 2));
        this.pHE.preScale(min, f);
        this.pHE.preTranslate((float) ((-this.rH) / 2), (float) ((-this.rI) / 2));
        if (!isInEditMode()) {
            canvas.drawBitmap(bitmap, this.pHE, this.pHB);
        }
    }

    private f Q(float f, float f2) {
        float f3;
        int i = 0;
        f fVar = null;
        float f4 = this.pIa;
        float f5 = f4 * this.pHM;
        float paddingTop = ((f4 - f5) / 2.0f) + ((float) getPaddingTop());
        int i2 = 0;
        while (i2 < 3) {
            f3 = (((float) i2) * f4) + paddingTop;
            if (f2 >= f3 && f2 <= f3 + f5) {
                break;
            }
            i2++;
        }
        i2 = -1;
        if (i2 >= 0) {
            f4 = this.pHZ;
            f5 = this.pHM * f4;
            paddingTop = ((float) getPaddingLeft()) + ((f4 - f5) / 2.0f);
            while (i < 3) {
                f3 = (((float) i) * f4) + paddingTop;
                if (f >= f3 && f <= f3 + f5) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i >= 0 && !this.pHI[i2][i]) {
                fVar = f.eb(i2, i);
            }
        }
        if (fVar == null) {
            return null;
        }
        this.pHI[fVar.pGW][fVar.pGX] = true;
        this.pHH.add(fVar);
        if (this.pIb != null) {
            ArrayList arrayList = new ArrayList(this.pHH);
        }
        if (!this.pHN) {
            return fVar;
        }
        performHapticFeedback(1, 3);
        return fVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = r13.pHP;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r13.isEnabled();
        if (r0 != 0) goto L_0x000c;
    L_0x000a:
        r0 = 0;
    L_0x000b:
        return r0;
    L_0x000c:
        r0 = r14.getAction();
        switch(r0) {
            case 0: goto L_0x0015;
            case 1: goto L_0x0060;
            case 2: goto L_0x0080;
            case 3: goto L_0x0207;
            default: goto L_0x0013;
        };
    L_0x0013:
        r0 = 0;
        goto L_0x000b;
    L_0x0015:
        r13.bRU();
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = r13.Q(r0, r1);
        if (r2 == 0) goto L_0x005c;
    L_0x0026:
        r3 = 1;
        r13.pHX = r3;
        r3 = com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.b.pId;
        r13.pHQ = r3;
        r3 = r13.pIb;
        if (r3 == 0) goto L_0x0031;
    L_0x0031:
        if (r2 == 0) goto L_0x0056;
    L_0x0033:
        r3 = r2.pGX;
        r3 = r13.zz(r3);
        r2 = r2.pGW;
        r2 = r13.zA(r2);
        r4 = r13.pHZ;
        r5 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r4 = r4 * r5;
        r5 = r13.pIa;
        r6 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r5 = r5 * r6;
        r6 = r3 - r4;
        r6 = (int) r6;
        r7 = r2 - r5;
        r7 = (int) r7;
        r3 = r3 + r4;
        r3 = (int) r3;
        r2 = r2 + r5;
        r2 = (int) r2;
        r13.invalidate(r6, r7, r3, r2);
    L_0x0056:
        r13.pHV = r0;
        r13.pHW = r1;
        r0 = 1;
        goto L_0x000b;
    L_0x005c:
        r3 = 0;
        r13.pHX = r3;
        goto L_0x0031;
    L_0x0060:
        r0 = r13.pHH;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x007e;
    L_0x0068:
        r0 = 0;
        r13.pHX = r0;
        r0 = r13.pIb;
        if (r0 == 0) goto L_0x007b;
    L_0x006f:
        r0 = r13.pIb;
        r1 = new java.util.ArrayList;
        r2 = r13.pHH;
        r1.<init>(r2);
        r0.a(r13, r1);
    L_0x007b:
        r13.invalidate();
    L_0x007e:
        r0 = 1;
        goto L_0x000b;
    L_0x0080:
        r0 = r13.pHK;
        r7 = (float) r0;
        r8 = r14.getHistorySize();
        r0 = r13.pHF;
        r0.setEmpty();
        r2 = 0;
        r0 = 0;
        r6 = r0;
    L_0x008f:
        r0 = r8 + 1;
        if (r6 >= r0) goto L_0x0159;
    L_0x0093:
        if (r6 >= r8) goto L_0x014b;
    L_0x0095:
        r0 = r14.getHistoricalX(r6);
        r3 = r0;
    L_0x009a:
        if (r6 >= r8) goto L_0x0152;
    L_0x009c:
        r0 = r14.getHistoricalY(r6);
        r1 = r0;
    L_0x00a1:
        r9 = r13.Q(r3, r1);
        r0 = r13.pHH;
        r4 = r0.size();
        if (r9 == 0) goto L_0x00b3;
    L_0x00ad:
        r0 = 1;
        if (r4 != r0) goto L_0x00b3;
    L_0x00b0:
        r0 = 1;
        r13.pHX = r0;
    L_0x00b3:
        r0 = r13.pHV;
        r0 = r3 - r0;
        r0 = java.lang.Math.abs(r0);
        r5 = r13.pHW;
        r5 = r1 - r5;
        r5 = java.lang.Math.abs(r5);
        r10 = 0;
        r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
        if (r0 > 0) goto L_0x00cd;
    L_0x00c8:
        r0 = 0;
        r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x00cf;
    L_0x00cd:
        r0 = 1;
        r2 = r0;
    L_0x00cf:
        r0 = r13.pHX;
        if (r0 == 0) goto L_0x0146;
    L_0x00d3:
        if (r4 <= 0) goto L_0x0146;
    L_0x00d5:
        r0 = r13.pHH;
        r4 = r4 + -1;
        r0 = r0.get(r4);
        r0 = (com.tencent.mm.plugin.walletlock.gesture.a.f) r0;
        r4 = r0.pGX;
        r4 = r13.zz(r4);
        r0 = r0.pGW;
        r10 = r13.zA(r0);
        r0 = java.lang.Math.min(r4, r3);
        r0 = r0 - r7;
        r3 = java.lang.Math.max(r4, r3);
        r5 = r3 + r7;
        r3 = java.lang.Math.min(r10, r1);
        r3 = r3 - r7;
        r1 = java.lang.Math.max(r10, r1);
        r4 = r1 + r7;
        if (r9 == 0) goto L_0x021d;
    L_0x0103:
        r1 = r13.pHZ;
        r10 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r1 = r1 * r10;
        r10 = r13.pIa;
        r11 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r10 = r10 * r11;
        r11 = r9.pGX;
        r11 = r13.zz(r11);
        r9 = r9.pGW;
        r9 = r13.zA(r9);
        r12 = r11 - r1;
        r0 = java.lang.Math.min(r12, r0);
        r1 = r1 + r11;
        r5 = java.lang.Math.max(r1, r5);
        r1 = r9 - r10;
        r1 = java.lang.Math.min(r1, r3);
        r3 = r9 + r10;
        r3 = java.lang.Math.max(r3, r4);
        r4 = r3;
    L_0x0131:
        r3 = r13.pHF;
        r0 = java.lang.Math.round(r0);
        r1 = java.lang.Math.round(r1);
        r5 = java.lang.Math.round(r5);
        r4 = java.lang.Math.round(r4);
        r3.union(r0, r1, r5, r4);
    L_0x0146:
        r0 = r6 + 1;
        r6 = r0;
        goto L_0x008f;
    L_0x014b:
        r0 = r14.getX();
        r3 = r0;
        goto L_0x009a;
    L_0x0152:
        r0 = r14.getY();
        r1 = r0;
        goto L_0x00a1;
    L_0x0159:
        r0 = r14.getX();
        r13.pHV = r0;
        r0 = r13.pHV;
        r1 = r13.getPaddingLeft();
        r3 = r13.pHK;
        r1 = r1 + r3;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 >= 0) goto L_0x01ad;
    L_0x016d:
        r0 = r13.getPaddingLeft();
        r1 = r13.pHK;
        r0 = r0 + r1;
        r0 = (float) r0;
        r13.pHV = r0;
    L_0x0177:
        r0 = r14.getY();
        r13.pHW = r0;
        r0 = r13.pHW;
        r1 = r13.getPaddingTop();
        r3 = r13.pHK;
        r1 = r1 + r3;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 >= 0) goto L_0x01da;
    L_0x018b:
        r0 = r13.getPaddingTop();
        r1 = r13.pHK;
        r0 = r0 + r1;
        r0 = (float) r0;
        r13.pHW = r0;
    L_0x0195:
        if (r2 == 0) goto L_0x01aa;
    L_0x0197:
        r0 = r13.pHG;
        r1 = r13.pHF;
        r0.union(r1);
        r0 = r13.pHG;
        r13.invalidate(r0);
        r0 = r13.pHG;
        r1 = r13.pHF;
        r0.set(r1);
    L_0x01aa:
        r0 = 1;
        goto L_0x000b;
    L_0x01ad:
        r0 = r13.pHV;
        r1 = r13.getPaddingLeft();
        r3 = r13.getWidth();
        r1 = r1 + r3;
        r3 = r13.getPaddingRight();
        r1 = r1 - r3;
        r3 = r13.pHK;
        r1 = r1 - r3;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x0177;
    L_0x01c5:
        r0 = r13.getPaddingLeft();
        r1 = r13.getWidth();
        r0 = r0 + r1;
        r1 = r13.getPaddingRight();
        r0 = r0 - r1;
        r1 = r13.pHK;
        r0 = r0 - r1;
        r0 = (float) r0;
        r13.pHV = r0;
        goto L_0x0177;
    L_0x01da:
        r0 = r13.pHW;
        r1 = r13.getPaddingTop();
        r3 = r13.getHeight();
        r1 = r1 + r3;
        r3 = r13.getPaddingRight();
        r1 = r1 - r3;
        r3 = r13.pHK;
        r1 = r1 - r3;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x0195;
    L_0x01f2:
        r0 = r13.getPaddingTop();
        r1 = r13.getHeight();
        r0 = r0 + r1;
        r1 = r13.getPaddingBottom();
        r0 = r0 - r1;
        r1 = r13.pHK;
        r0 = r0 - r1;
        r0 = (float) r0;
        r13.pHW = r0;
        goto L_0x0195;
    L_0x0207:
        r0 = r13.pHX;
        if (r0 == 0) goto L_0x021a;
    L_0x020b:
        r0 = 0;
        r13.pHX = r0;
        r13.bRU();
        r0 = r13.pIb;
        if (r0 == 0) goto L_0x021a;
    L_0x0215:
        r0 = r13.pIb;
        r0.a(r13);
    L_0x021a:
        r0 = 1;
        goto L_0x000b;
    L_0x021d:
        r1 = r3;
        goto L_0x0131;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean getEnableHapticFeedback() {
        return this.pHN;
    }

    public void setEnableHapticFeedback(boolean z) {
        this.pHN = z;
    }

    public boolean getDisplayLine() {
        return this.pHO;
    }

    public void setDisplayLine(boolean z) {
        this.pHO = z;
        invalidate();
    }

    public boolean getEnableInput() {
        return this.pHP;
    }

    public void setEnableInput(boolean z) {
        this.pHP = z;
    }

    public void setOnPatternListener(a aVar) {
        this.pIb = aVar;
    }

    private void bRT() {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.pHI[i][i2] = false;
            }
        }
    }

    private float zz(int i) {
        return (((float) getPaddingLeft()) + (((float) i) * this.pHZ)) + (this.pHZ * 0.5f);
    }

    private float zA(int i) {
        return (((float) getPaddingTop()) + (((float) i) * this.pIa)) + (this.pIa * 0.5f);
    }

    public List<f> getPattern() {
        return new ArrayList(this.pHH);
    }

    private void a(b bVar, List<f> list) {
        this.pHH.clear();
        bRT();
        this.pHH.addAll(list);
        Iterator it = this.pHH.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            this.pHI[fVar.pGW][fVar.pGX] = true;
        }
        setDisplayMode(bVar);
    }

    private void bRU() {
        this.pHH.clear();
        bRT();
        this.pHQ = b.pId;
        invalidate();
    }

    public final void bRV() {
        bRU();
        if (this.pIb != null) {
            this.pIb.a(this);
        }
    }

    public void setDisplayMode(b bVar) {
        switch (1.pIc[bVar.ordinal()]) {
            case 1:
                this.iGa = getResources().getColor(b.gesture_color_norm_line);
                break;
            case 2:
                this.iGa = getResources().getColor(b.gesture_color_wrong_line);
                break;
            case 3:
                if (this.pHH.size() != 0) {
                    this.pHP = false;
                    this.iGa = getResources().getColor(b.gesture_color_norm_line);
                    f fVar = (f) this.pHH.get(0);
                    this.pHV = zz(fVar.pGX);
                    this.pHW = zA(fVar.pGW);
                    bRT();
                    this.pHY = SystemClock.elapsedRealtime();
                    break;
                }
                throw new IllegalStateException("You should set a pattern before animating.");
        }
        this.pHQ = bVar;
        invalidate();
    }
}
