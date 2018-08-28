package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.view.z;
import android.support.v4.widget.q;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import com.tencent.mm.plugin.appbrand.s.l;

public class YANumberPicker extends View {
    private int Pb = 2;
    private int aaG;
    private int aaH;
    private VelocityTracker cE;
    private q fT;
    private float ftp = 0.0f;
    private int gNA = 0;
    private int gNB = 0;
    private int gNC = 0;
    private int gND = -695533;
    private int gNE = 0;
    private int gNF = 0;
    private int gNG = 3;
    private int gNH = 0;
    private int gNI = 0;
    private int gNJ = -1;
    private int gNK = -1;
    private int gNL = 0;
    private int gNM = 0;
    private int gNN = 0;
    private int gNO = 0;
    private int gNP = 0;
    private int gNQ = 0;
    private int gNR = 0;
    private int gNS = 150;
    private int gNT = 8;
    private String gNU;
    private String gNV;
    private String gNW;
    private String gNX;
    private float gNY = 1.0f;
    private float gNZ = 0.0f;
    private int gNr = -13421773;
    private int gNs = -695533;
    private int gNt = -695533;
    private int gNu = 0;
    private int gNv = 0;
    private int gNw = 0;
    private int gNx = 0;
    private int gNy = 0;
    private int gNz = 0;
    private float gOA = 0.0f;
    private boolean gOB = false;
    private int gOC;
    private float gOD;
    private float gOE;
    private float gOF;
    private int gOG = 0;
    private int gOH = 0;
    private int gOI = 0;
    private int gOJ = 0;
    private int gOK = 0;
    private float gOa = 0.0f;
    private float gOb = 0.0f;
    private boolean gOc = true;
    private boolean gOd = true;
    private boolean gOe = false;
    private boolean gOf = true;
    private boolean gOg = false;
    private boolean gOh = false;
    private boolean gOi = true;
    private Paint gOj = new Paint();
    private TextPaint gOk = new TextPaint();
    private Paint gOl = new Paint();
    private String[] gOm;
    private CharSequence[] gOn;
    private CharSequence[] gOo;
    private Handler gOp;
    private Handler gOq;
    private d gOr;
    private b gOs;
    private a gOt;
    private c gOu;
    private int gOv;
    private int gOw;
    private int gOx;
    private int gOy;
    private float gOz = 0.0f;
    private int if = 0;
    private HandlerThread mHandlerThread;
    private boolean mHasInit = false;

    static /* synthetic */ void a(YANumberPicker yANumberPicker, int i, int i2, Object obj) {
        yANumberPicker.mn(0);
        if (i != i2 && ((obj == null || !(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) && yANumberPicker.gOs != null)) {
            yANumberPicker.gOs.a(yANumberPicker, yANumberPicker.gNL + i2);
        }
        yANumberPicker.gNR = i2;
        if (yANumberPicker.gOg) {
            yANumberPicker.gOg = false;
            yANumberPicker.aqv();
        }
    }

    public YANumberPicker(Context context) {
        super(context);
        init(context);
    }

    public YANumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
        init(context);
    }

    public YANumberPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
        init(context);
    }

    private void b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.YANumberPicker);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == l.YANumberPicker_npv_ShowCount) {
                    this.gNG = obtainStyledAttributes.getInt(index, 3);
                } else if (index == l.YANumberPicker_npv_DividerColor) {
                    this.gND = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == l.YANumberPicker_npv_DividerHeight) {
                    this.Pb = obtainStyledAttributes.getDimensionPixelSize(index, 2);
                } else if (index == l.YANumberPicker_npv_DividerMarginLeft) {
                    this.gNE = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == l.YANumberPicker_npv_DividerMarginRight) {
                    this.gNF = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == l.YANumberPicker_npv_TextArray) {
                    String[] strArr;
                    CharSequence[] textArray = obtainStyledAttributes.getTextArray(index);
                    if (textArray == null) {
                        strArr = null;
                    } else {
                        String[] strArr2 = new String[textArray.length];
                        for (index = 0; index < textArray.length; index++) {
                            strArr2[index] = textArray[index].toString();
                        }
                        strArr = strArr2;
                    }
                    this.gOm = strArr;
                } else if (index == l.YANumberPicker_npv_TextColorNormal) {
                    this.gNr = obtainStyledAttributes.getColor(index, -13421773);
                } else if (index == l.YANumberPicker_npv_TextColorSelected) {
                    this.gNs = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == l.YANumberPicker_npv_TextColorHint) {
                    this.gNt = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == l.YANumberPicker_npv_TextSizeNormal) {
                    this.gNu = obtainStyledAttributes.getDimensionPixelSize(index, d(context, 13.0f));
                } else if (index == l.YANumberPicker_npv_TextSizeSelected) {
                    this.gNv = obtainStyledAttributes.getDimensionPixelSize(index, d(context, 15.0f));
                } else if (index == l.YANumberPicker_npv_TextSizeHint) {
                    this.gNw = obtainStyledAttributes.getDimensionPixelSize(index, d(context, 14.0f));
                } else if (index == l.YANumberPicker_npv_MinValue) {
                    this.gNJ = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == l.YANumberPicker_npv_MaxValue) {
                    this.gNK = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == l.YANumberPicker_npv_WrapSelectorWheel) {
                    this.gOd = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == l.YANumberPicker_npv_ShowDivider) {
                    this.gOc = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == l.YANumberPicker_npv_HintText) {
                    this.gNU = obtainStyledAttributes.getString(index);
                } else if (index == l.YANumberPicker_npv_AlternativeHint) {
                    this.gNX = obtainStyledAttributes.getString(index);
                } else if (index == l.YANumberPicker_npv_EmptyItemHint) {
                    this.gNW = obtainStyledAttributes.getString(index);
                } else if (index == l.YANumberPicker_npv_MarginStartOfHint) {
                    this.gNz = obtainStyledAttributes.getDimensionPixelSize(index, e(context, 8.0f));
                } else if (index == l.YANumberPicker_npv_MarginEndOfHint) {
                    this.gNA = obtainStyledAttributes.getDimensionPixelSize(index, e(context, 8.0f));
                } else if (index == l.YANumberPicker_npv_ItemPaddingVertical) {
                    this.gNB = obtainStyledAttributes.getDimensionPixelSize(index, e(context, 2.0f));
                } else if (index == l.YANumberPicker_npv_ItemPaddingHorizontal) {
                    this.gNC = obtainStyledAttributes.getDimensionPixelSize(index, e(context, 5.0f));
                } else if (index == l.YANumberPicker_npv_AlternativeTextArrayWithMeasureHint) {
                    this.gOn = obtainStyledAttributes.getTextArray(index);
                } else if (index == l.YANumberPicker_npv_AlternativeTextArrayWithoutMeasureHint) {
                    this.gOo = obtainStyledAttributes.getTextArray(index);
                } else if (index == l.YANumberPicker_npv_RespondChangeOnDetached) {
                    this.gOh = obtainStyledAttributes.getBoolean(index, false);
                } else if (index == l.YANumberPicker_npv_RespondChangeInMainThread) {
                    this.gOi = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == l.YANumberPicker_npv_TextEllipsize) {
                    this.gNV = obtainStyledAttributes.getString(index);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void init(Context context) {
        this.fT = q.a(context, null);
        this.gNS = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.gNT = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (this.gNu == 0) {
            this.gNu = d(context, 13.0f);
        }
        if (this.gNv == 0) {
            this.gNv = d(context, 15.0f);
        }
        if (this.gNw == 0) {
            this.gNw = d(context, 14.0f);
        }
        if (this.gNz == 0) {
            this.gNz = e(context, 8.0f);
        }
        if (this.gNA == 0) {
            this.gNA = e(context, 8.0f);
        }
        this.gOj.setColor(this.gND);
        this.gOj.setAntiAlias(true);
        this.gOj.setStyle(Style.STROKE);
        this.gOj.setStrokeWidth((float) this.Pb);
        this.gOk.setColor(this.gNr);
        this.gOk.setAntiAlias(true);
        this.gOk.setTextAlign(Align.CENTER);
        this.gOl.setColor(this.gNt);
        this.gOl.setAntiAlias(true);
        this.gOl.setTextAlign(Align.CENTER);
        this.gOl.setTextSize((float) this.gNw);
        if (this.gNG % 2 == 0) {
            this.gNG++;
        }
        if (this.gNJ == -1 || this.gNK == -1) {
            if (this.gOm == null) {
                this.gOm = new String[1];
                this.gOm[0] = "0";
            }
            aqy();
            if (this.gNJ == -1) {
                this.gNJ = 0;
            }
            if (this.gNK == -1) {
                this.gNK = this.gOm.length - 1;
            }
            g(this.gNJ, this.gNK, false);
        }
        aqu();
    }

    private void aqu() {
        this.mHandlerThread = new HandlerThread("HandlerThread-For-Refreshing");
        this.mHandlerThread.start();
        this.gOp = new 1(this, this.mHandlerThread.getLooper());
        this.gOq = new 2(this);
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        super.onMeasure(i, i2);
        dr(false);
        int mode = MeasureSpec.getMode(i);
        this.gOJ = mode;
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            i3 = size;
        } else {
            i3 = Math.max(this.gNx, this.gNy) == 0 ? 0 : this.gNA;
            if (Math.max(this.gNx, this.gNy) != 0) {
                i4 = this.gNz;
            }
            i3 = Math.max(this.gNP, (((i3 + (i4 + Math.max(this.gNx, this.gNy))) + (this.gNC * 2)) * 2) + Math.max(this.gNN, this.gNQ)) + (getPaddingLeft() + getPaddingRight());
            if (mode == Integer.MIN_VALUE) {
                i3 = Math.min(i3, size);
            }
        }
        mode = MeasureSpec.getMode(i2);
        this.gOK = mode;
        i4 = MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = (this.gNG * (this.gNO + (this.gNB * 2))) + (getPaddingTop() + getPaddingBottom());
            i4 = mode == Integer.MIN_VALUE ? Math.min(size, i4) : size;
        }
        setMeasuredDimension(i3, i4);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z;
        super.onSizeChanged(i, i2, i3, i4);
        this.aaG = i;
        this.aaH = i2;
        this.gOC = this.aaH / this.gNG;
        this.gOF = ((float) ((this.aaG + getPaddingLeft()) - getPaddingRight())) / 2.0f;
        int value = getOneRecycleSize() > 1 ? this.mHasInit ? getValue() - this.gNL : this.gOe ? this.gOG + ((this.gNG - 1) / 2) : 0 : 0;
        if (this.gOd && this.gOf) {
            z = true;
        } else {
            z = false;
        }
        F(value, z);
        if (this.gNu > this.gOC) {
            this.gNu = this.gOC;
        }
        if (this.gNv > this.gOC) {
            this.gNv = this.gOC;
        }
        if (this.gOl == null) {
            throw new IllegalArgumentException("mPaintHint should not be null.");
        }
        this.gOl.setTextSize((float) this.gNw);
        this.gOb = a(this.gOl.getFontMetrics());
        this.gNx = a(this.gNU, this.gOl);
        if (this.gOk == null) {
            throw new IllegalArgumentException("mPaintText should not be null.");
        }
        this.gOk.setTextSize((float) this.gNv);
        this.gOa = a(this.gOk.getFontMetrics());
        this.gOk.setTextSize((float) this.gNu);
        this.gNZ = a(this.gOk.getFontMetrics());
        aqw();
        this.gNH = this.gNG / 2;
        this.gNI = this.gNH + 1;
        this.gOD = (float) ((this.gNH * this.aaH) / this.gNG);
        this.gOE = (float) ((this.gNI * this.aaH) / this.gNG);
        if (this.gNE < 0) {
            this.gNE = 0;
        }
        if (this.gNF < 0) {
            this.gNF = 0;
        }
        if (this.gNE + this.gNF != 0 && getPaddingLeft() + this.gNE >= (this.aaG - getPaddingRight()) - this.gNF) {
            value = (((getPaddingLeft() + this.gNE) + getPaddingRight()) + this.gNF) - this.aaG;
            this.gNE = (int) (((float) this.gNE) - ((((float) value) * ((float) this.gNE)) / ((float) (this.gNE + this.gNF))));
            this.gNF = (int) (((float) this.gNF) - ((((float) value) * ((float) this.gNF)) / ((float) (this.gNE + this.gNF))));
        }
        this.mHasInit = true;
    }

    public void postInvalidate() {
        if (z.ak(this)) {
            super.postInvalidate();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mHandlerThread == null || !this.mHandlerThread.isAlive()) {
            aqu();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandlerThread.quit();
        if (this.gOC != 0) {
            if (!this.fT.isFinished()) {
                this.fT.abortAnimation();
                this.gOI = this.fT.getCurrY();
                aqx();
                if (this.gOH != 0) {
                    if (this.gOH < (-this.gOC) / 2) {
                        this.gOI = (this.gOI + this.gOC) + this.gOH;
                    } else {
                        this.gOI += this.gOH;
                    }
                    aqx();
                }
                mn(0);
            }
            int mo = mo(this.gOI);
            if (mo != this.gNR && this.gOh) {
                try {
                    if (this.gOs != null) {
                        this.gOs.a(this, this.gNL + mo);
                    }
                } catch (Exception e) {
                }
            }
            this.gNR = mo;
        }
    }

    public int getOneRecycleSize() {
        return (this.gNK - this.gNJ) + 1;
    }

    public int getRawContentSize() {
        if (this.gOm != null) {
            return this.gOm.length;
        }
        return 0;
    }

    public void setDisplayedValues(String[] strArr) {
        boolean z = true;
        if (this.gOp != null) {
            this.gOp.removeMessages(1);
        }
        aqz();
        if (strArr == null) {
            throw new IllegalArgumentException("newDisplayedValues should not be null.");
        } else if ((this.gNM - this.gNL) + 1 > strArr.length) {
            throw new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + ((this.gNM - this.gNL) + 1) + " newDisplayedValues.length is " + strArr.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
        } else {
            this.gOm = strArr;
            aqy();
            dr(true);
            this.gNR = this.gNJ + 0;
            if (!(this.gOd && this.gOf)) {
                z = false;
            }
            F(0, z);
            postInvalidate();
            this.gOq.sendEmptyMessage(3);
        }
    }

    public String[] getDisplayedValues() {
        return this.gOm;
    }

    public void setWrapSelectorWheel(boolean z) {
        if (this.gOd == z) {
            return;
        }
        if (z) {
            this.gOd = z;
            aqy();
            postInvalidate();
        } else if (this.if == 0) {
            aqv();
        } else {
            this.gOg = true;
        }
    }

    public int getMinValue() {
        return this.gNL;
    }

    public int getMaxValue() {
        return this.gNM;
    }

    public void setMinValue(int i) {
        this.gNL = i;
        this.gNJ = 0;
        aqw();
    }

    public void setMaxValue(int i) {
        if (this.gOm == null) {
            throw new NullPointerException("mDisplayedValues should not be null");
        } else if ((i - this.gNL) + 1 > this.gOm.length) {
            throw new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + ((i - this.gNL) + 1) + " and mDisplayedValues.length is " + this.gOm.length);
        } else {
            this.gNM = i;
            this.gNK = (this.gNM - this.gNL) + this.gNJ;
            g(this.gNJ, this.gNK, true);
            aqw();
        }
    }

    public void setValue(int i) {
        if (i < this.gNL) {
            throw new IllegalArgumentException("should not set a value less than mMinValue, value is " + i);
        } else if (i > this.gNM) {
            throw new IllegalArgumentException("should not set a value greater than mMaxValue, value is " + i);
        } else {
            setPickedIndexRelativeToRaw(i - this.gNL);
        }
    }

    public int getValue() {
        return getPickedIndexRelativeToRaw() + this.gNL;
    }

    public String getContentByCurrValue() {
        return this.gOm[getValue() - this.gNL];
    }

    public boolean getWrapSelectorWheel() {
        return this.gOd;
    }

    public boolean getWrapSelectorWheelAbsolutely() {
        return this.gOd && this.gOf;
    }

    public void setHintText(String str) {
        String str2 = this.gNU;
        boolean equals = str2 == null ? str == null : str2.equals(str);
        if (!equals) {
            this.gNU = str;
            this.gOb = a(this.gOl.getFontMetrics());
            this.gNx = a(this.gNU, this.gOl);
            this.gOq.sendEmptyMessage(3);
        }
    }

    public void setPickedIndexRelativeToMin(int i) {
        if (i >= 0 && i < getOneRecycleSize()) {
            this.gNR = this.gNJ + i;
            boolean z = this.gOd && this.gOf;
            F(i, z);
            postInvalidate();
        }
    }

    public void setNormalTextColor(int i) {
        if (this.gNr != i) {
            this.gNr = i;
            postInvalidate();
        }
    }

    public void setSelectedTextColor(int i) {
        if (this.gNs != i) {
            this.gNs = i;
            postInvalidate();
        }
    }

    public void setHintTextColor(int i) {
        if (this.gNt != i) {
            this.gNt = i;
            this.gOl.setColor(this.gNt);
            postInvalidate();
        }
    }

    public void setDividerColor(int i) {
        if (this.gND != i) {
            this.gND = i;
            this.gOj.setColor(this.gND);
            postInvalidate();
        }
    }

    public void setDividerHeight(int i) {
        if (i != this.Pb) {
            this.Pb = i;
            this.gOj.setStrokeWidth((float) this.Pb);
            postInvalidate();
        }
    }

    public void setItemPaddingVertical(int i) {
        if (this.gNB != i) {
            this.gNB = i;
            postInvalidate();
        }
    }

    public void setPickedIndexRelativeToRaw(int i) {
        if (this.gNJ >= 0 && this.gNJ <= i && i <= this.gNK) {
            this.gNR = i;
            int i2 = i - this.gNJ;
            boolean z = this.gOd && this.gOf;
            F(i2, z);
            postInvalidate();
        }
    }

    public int getPickedIndexRelativeToRaw() {
        if (this.gOH == 0) {
            return mo(this.gOI);
        }
        if (this.gOH < (-this.gOC) / 2) {
            return mo((this.gOI + this.gOC) + this.gOH);
        }
        return mo(this.gOI + this.gOH);
    }

    private void g(int i, int i2, boolean z) {
        if (i > i2) {
            throw new IllegalArgumentException("minShowIndex should be less than maxShowIndex, minShowIndex is " + i + ", maxShowIndex is " + i2 + ".");
        } else if (this.gOm == null) {
            throw new IllegalArgumentException("mDisplayedValues should not be null, you need to set mDisplayedValues first.");
        } else if (i < 0) {
            throw new IllegalArgumentException("minShowIndex should not be less than 0, now minShowIndex is " + i);
        } else if (i > this.gOm.length - 1) {
            throw new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.gOm.length - 1) + " minShowIndex is " + i);
        } else if (i2 < 0) {
            throw new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is " + i2);
        } else if (i2 > this.gOm.length - 1) {
            throw new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.gOm.length - 1) + " maxShowIndex is " + i2);
        } else {
            this.gNJ = i;
            this.gNK = i2;
            if (z) {
                boolean z2;
                this.gNR = this.gNJ + 0;
                if (this.gOd && this.gOf) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                F(0, z2);
                postInvalidate();
            }
        }
    }

    public void setFriction(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("you should set a a positive float friction, now friction is " + f);
        }
        ViewConfiguration.get(getContext());
        this.gNY = ViewConfiguration.getScrollFriction() / f;
    }

    private void mn(int i) {
        if (this.if != i) {
            this.if = i;
        }
    }

    public void setOnScrollListener(a aVar) {
        this.gOt = aVar;
    }

    public void setOnValueChangedListener(b bVar) {
        this.gOs = bVar;
    }

    public void setOnValueChangedListenerRelativeToRaw(d dVar) {
        this.gOr = dVar;
    }

    public void setOnValueChangeListenerInScrolling(c cVar) {
        this.gOu = cVar;
    }

    public void setContentTextTypeface(Typeface typeface) {
        this.gOk.setTypeface(typeface);
    }

    public void setHintTextTypeface(Typeface typeface) {
        this.gOl.setTypeface(typeface);
    }

    private int mo(int i) {
        boolean z = false;
        if (this.gOC == 0) {
            return 0;
        }
        int i2 = (i / this.gOC) + (this.gNG / 2);
        int oneRecycleSize = getOneRecycleSize();
        if (this.gOd && this.gOf) {
            z = true;
        }
        int h = h(i2, oneRecycleSize, z);
        if (h >= 0 && h < getOneRecycleSize()) {
            return h + this.gNJ;
        }
        throw new IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + h + " getOneRecycleSize() : " + getOneRecycleSize() + " mWrapSelectorWheel : " + this.gOd);
    }

    private static int h(int i, int i2, boolean z) {
        if (i2 <= 0) {
            return 0;
        }
        if (!z) {
            return i;
        }
        int i3 = i % i2;
        if (i3 < 0) {
            return i3 + i2;
        }
        return i3;
    }

    private void aqv() {
        F(getPickedIndexRelativeToRaw() - this.gNJ, false);
        this.gOd = false;
        postInvalidate();
    }

    private void aqw() {
        this.gOx = 0;
        this.gOy = (-this.gNG) * this.gOC;
        if (this.gOm != null) {
            this.gOx = ((getOneRecycleSize() - (this.gNG / 2)) - 1) * this.gOC;
            this.gOy = (-(this.gNG / 2)) * this.gOC;
        }
    }

    private int mp(int i) {
        if (this.gOd && this.gOf) {
            return i;
        }
        if (i < this.gOy) {
            return this.gOy;
        }
        if (i > this.gOx) {
            return this.gOx;
        }
        return i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gOC != 0) {
            if (this.cE == null) {
                this.cE = VelocityTracker.obtain();
            }
            this.cE.addMovement(motionEvent);
            this.gOA = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.gOB = true;
                    this.gOp.removeMessages(1);
                    aqz();
                    this.ftp = this.gOA;
                    this.gOz = (float) this.gOI;
                    mn(0);
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                case 1:
                    int yVelocity;
                    if (!this.gOB) {
                        VelocityTracker velocityTracker = this.cE;
                        velocityTracker.computeCurrentVelocity(1000);
                        yVelocity = (int) (velocityTracker.getYVelocity() * this.gNY);
                        if (Math.abs(yVelocity) > this.gNS) {
                            this.fT.b(this.gOI, 0, -yVelocity, Integer.MIN_VALUE, Integer.MAX_VALUE, mp(Integer.MIN_VALUE), mp(Integer.MAX_VALUE));
                            invalidate();
                            mn(2);
                        }
                        this.gOp.sendMessageDelayed(b(1, 0, 0, null), 0);
                        if (this.cE != null) {
                            this.cE.clear();
                            this.cE.recycle();
                            this.cE = null;
                            break;
                        }
                    }
                    float y = motionEvent.getY();
                    yVelocity = 0;
                    while (yVelocity < this.gNG) {
                        if (((float) (this.gOC * yVelocity)) <= y && y < ((float) (this.gOC * (yVelocity + 1)))) {
                            if (yVelocity >= 0 && yVelocity < this.gNG) {
                                int pickedIndexRelativeToRaw;
                                int i;
                                int i2;
                                yVelocity -= this.gNG / 2;
                                if (!(this.gOd && this.gOf)) {
                                    pickedIndexRelativeToRaw = getPickedIndexRelativeToRaw();
                                    if (pickedIndexRelativeToRaw + yVelocity > this.gNK) {
                                        yVelocity = this.gNK - pickedIndexRelativeToRaw;
                                    } else if (pickedIndexRelativeToRaw + yVelocity < this.gNJ) {
                                        yVelocity = this.gNJ - pickedIndexRelativeToRaw;
                                    }
                                }
                                if (this.gOH < (-this.gOC) / 2) {
                                    pickedIndexRelativeToRaw = this.gOC + this.gOH;
                                    i = (int) ((((float) (this.gOC + this.gOH)) * 300.0f) / ((float) this.gOC));
                                    i = yVelocity < 0 ? (-i) - (yVelocity * 300) : i + (yVelocity * 300);
                                } else {
                                    pickedIndexRelativeToRaw = this.gOH;
                                    i = (int) ((((float) (-this.gOH)) * 300.0f) / ((float) this.gOC));
                                    i = yVelocity < 0 ? i - (yVelocity * 300) : i + (yVelocity * 300);
                                }
                                int i3 = pickedIndexRelativeToRaw + (yVelocity * this.gOC);
                                if (i < 300) {
                                    i2 = 300;
                                } else {
                                    i2 = i;
                                }
                                if (i2 > 600) {
                                    i2 = 600;
                                }
                                this.fT.startScroll(0, this.gOI, 0, i3, i2);
                                this.gOp.sendMessageDelayed(b(1, 0, 0, null), (long) (i2 / 4));
                                postInvalidate();
                                break;
                            }
                        }
                        yVelocity++;
                    }
                    break;
                    break;
                case 2:
                    float f = this.ftp - this.gOA;
                    if (!this.gOB || ((float) (-this.gNT)) >= f || f >= ((float) this.gNT)) {
                        this.gOB = false;
                        this.gOI = mp((int) (f + this.gOz));
                        aqx();
                        invalidate();
                    }
                    mn(1);
                    break;
                case 3:
                    this.gOz = (float) this.gOI;
                    aqz();
                    this.gOp.sendMessageDelayed(b(1, 0, 0, null), 0);
                    break;
            }
        }
        return true;
    }

    private static float a(FontMetrics fontMetrics) {
        if (fontMetrics == null) {
            return 0.0f;
        }
        return Math.abs(fontMetrics.top + fontMetrics.bottom) / 2.0f;
    }

    private void F(int i, boolean z) {
        this.gOG = i - ((this.gNG - 1) / 2);
        this.gOG = h(this.gOG, getOneRecycleSize(), z);
        if (this.gOC == 0) {
            this.gOe = true;
            return;
        }
        this.gOI = this.gOG * this.gOC;
        this.gOv = this.gOG + (this.gNG / 2);
        this.gOv %= getOneRecycleSize();
        if (this.gOv < 0) {
            this.gOv += getOneRecycleSize();
        }
        this.gOw = this.gOv;
        aqx();
    }

    public void computeScroll() {
        if (this.gOC != 0 && this.fT.computeScrollOffset()) {
            this.gOI = this.fT.getCurrY();
            aqx();
            postInvalidate();
        }
    }

    private void aqx() {
        this.gOG = (int) Math.floor((double) (((float) this.gOI) / ((float) this.gOC)));
        this.gOH = -(this.gOI - (this.gOG * this.gOC));
        if (this.gOu != null) {
            if ((-this.gOH) > this.gOC / 2) {
                this.gOw = (this.gOG + 1) + (this.gNG / 2);
            } else {
                this.gOw = this.gOG + (this.gNG / 2);
            }
            this.gOw %= getOneRecycleSize();
            if (this.gOw < 0) {
                this.gOw += getOneRecycleSize();
            }
            this.gOv = this.gOw;
        }
    }

    private void dr(boolean z) {
        float textSize = this.gOk.getTextSize();
        this.gOk.setTextSize((float) this.gNv);
        this.gNN = a(this.gOm, this.gOk);
        this.gNP = a(this.gOn, this.gOk);
        this.gNQ = a(this.gOo, this.gOk);
        this.gOk.setTextSize((float) this.gNw);
        this.gNy = a(this.gNX, this.gOk);
        this.gOk.setTextSize(textSize);
        textSize = this.gOk.getTextSize();
        this.gOk.setTextSize((float) this.gNv);
        this.gNO = (int) (((double) (this.gOk.getFontMetrics().bottom - this.gOk.getFontMetrics().top)) + 0.5d);
        this.gOk.setTextSize(textSize);
        if (!z) {
            return;
        }
        if (this.gOJ == Integer.MIN_VALUE || this.gOK == Integer.MIN_VALUE) {
            this.gOq.sendEmptyMessage(3);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = 0.0f;
        for (int i = 0; i < this.gNG + 1; i++) {
            float f2;
            float f3;
            float f4 = (float) (this.gOH + (this.gOC * i));
            int i2 = this.gOG + i;
            int oneRecycleSize = getOneRecycleSize();
            boolean z = this.gOd && this.gOf;
            int h = h(i2, oneRecycleSize, z);
            if (i == this.gNG / 2) {
                f = ((float) (this.gOC + this.gOH)) / ((float) this.gOC);
                oneRecycleSize = a(f, this.gNr, this.gNs);
                f2 = (float) this.gNu;
                f3 = ((((float) this.gNv) - f2) * f) + f2;
                f2 = this.gNZ;
                f2 += (this.gOa - f2) * f;
            } else if (i == (this.gNG / 2) + 1) {
                oneRecycleSize = a(1.0f - f, this.gNr, this.gNs);
                f3 = (float) this.gNu;
                f3 += (1.0f - f) * (((float) this.gNv) - f3);
                f2 = 1.0f - f;
                float f5 = this.gNZ;
                f2 = (f2 * (this.gOa - f5)) + f5;
            } else {
                oneRecycleSize = this.gNr;
                f3 = (float) this.gNu;
                f2 = this.gNZ;
            }
            this.gOk.setColor(oneRecycleSize);
            this.gOk.setTextSize(f3);
            if (h >= 0 && h < getOneRecycleSize()) {
                CharSequence charSequence = this.gOm[this.gNJ + h];
                if (this.gNV != null) {
                    charSequence = TextUtils.ellipsize(charSequence, this.gOk, (float) (getWidth() - (this.gNC * 2)), getEllipsizeType());
                }
                canvas.drawText(charSequence.toString(), this.gOF, f2 + (f4 + ((float) (this.gOC / 2))), this.gOk);
            } else if (!TextUtils.isEmpty(this.gNW)) {
                canvas.drawText(this.gNW, this.gOF, f2 + (f4 + ((float) (this.gOC / 2))), this.gOk);
            }
        }
        if (this.gOc) {
            canvas.drawLine((float) (getPaddingLeft() + this.gNE), this.gOD, (float) ((this.aaG - getPaddingRight()) - this.gNF), this.gOD, this.gOj);
            canvas.drawLine((float) (getPaddingLeft() + this.gNE), this.gOE, (float) ((this.aaG - getPaddingRight()) - this.gNF), this.gOE, this.gOj);
        }
        if (!TextUtils.isEmpty(this.gNU)) {
            canvas.drawText(this.gNU, (this.gOF + ((float) ((this.gNN + this.gNx) / 2))) + ((float) this.gNz), ((this.gOD + this.gOE) / 2.0f) + this.gOb, this.gOl);
        }
    }

    public void setEllipsizeType(String str) {
        int i = 0;
        String[] strArr = new String[]{"end", "middle", "start"};
        while (i < 3) {
            if (strArr[i].equals(str)) {
                this.gNV = str;
                return;
            }
            i++;
        }
        this.gNV = "end";
    }

    private TruncateAt getEllipsizeType() {
        String str = this.gNV;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1074341483:
                if (str.equals("middle")) {
                    obj = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    obj = 2;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return TruncateAt.START;
            case 1:
                return TruncateAt.MIDDLE;
            case 2:
                return TruncateAt.END;
            default:
                throw new IllegalArgumentException("Illegal text ellipsize type.");
        }
    }

    private static int a(CharSequence[] charSequenceArr, Paint paint) {
        if (charSequenceArr == null) {
            return 0;
        }
        int i = 0;
        for (CharSequence charSequence : charSequenceArr) {
            if (charSequence != null) {
                i = Math.max(a(charSequence, paint), i);
            }
        }
        return i;
    }

    private static int a(CharSequence charSequence, Paint paint) {
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        return (int) (paint.measureText(charSequence.toString()) + 0.5f);
    }

    private void aqy() {
        this.gOf = this.gOm.length > this.gNG;
    }

    private void aqz() {
        if (this.fT != null && !this.fT.isFinished()) {
            this.fT.startScroll(0, this.fT.getCurrY(), 0, 0, 1);
            this.fT.abortAnimation();
            postInvalidate();
        }
    }

    public final void aqA() {
        aqz();
        if (this.gOp != null) {
            this.gOp.sendMessageDelayed(b(1, 0, 0, null), 0);
        }
    }

    private static Message b(int i, int i2, int i3, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        obtain.obj = obj;
        return obtain;
    }

    private static int d(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }

    private static int e(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    private static int a(float f, int i, int i2) {
        int i3 = (i & -16777216) >>> 24;
        int i4 = (i & 16711680) >>> 16;
        int i5 = (i & 65280) >>> 8;
        int i6 = (i & 255) >>> 0;
        return (((((int) ((((float) (((-16777216 & i2) >>> 24) - i3)) * f) + ((float) i3))) << 24) | (((int) ((((float) (((16711680 & i2) >>> 16) - i4)) * f) + ((float) i4))) << 16)) | (((int) ((((float) (((65280 & i2) >>> 8) - i5)) * f) + ((float) i5))) << 8)) | ((int) ((((float) (((i2 & 255) >>> 0) - i6)) * f) + ((float) i6)));
    }
}
