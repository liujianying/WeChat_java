package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.KeyListener;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.sdk.platformtools.bi;

@SuppressLint({"ResourceAsColor"})
public class NoMeasuredTextView extends View {
    private static final Metrics tAx = new Metrics();
    private int HB;
    private ColorStateList bv;
    private TextPaint dG;
    private int gg;
    private CharSequence mText;
    private int rA;
    private boolean tAa;
    private boolean tAb;
    private int tAc;
    private boolean tAd;
    private BoringLayout tAe;
    private boolean tAf;
    private int tAg;
    private FontMetricsInt tAh;
    private boolean tAi;
    private boolean tAj;
    private b tAk;
    private boolean tAl;
    private boolean tAm;
    private boolean tAn;
    private boolean tAo;
    private int tAp;
    private int tAq;
    private int tAr;
    private int tAs;
    private String tAt;
    private int tAu;
    private int tAv;
    private c tAw;
    private boolean txi;
    private int tzM;
    private Factory tzN;
    private Spannable.Factory tzO;
    private TruncateAt tzP;
    private CharSequence tzQ;
    private int tzR;
    private KeyListener tzS;
    private Layout tzT;
    private float tzU;
    private float tzV;
    private int tzW;
    private int tzX;
    private int tzY;
    private int tzZ;

    public void setDrawLeftDrawable(boolean z) {
        if (this.tAl != z) {
            invalidate();
        }
        this.tAl = z;
    }

    public void setDrawRightDrawable(boolean z) {
        if (this.tAm != z) {
            invalidate();
        }
        this.tAm = z;
    }

    public void setDrawTopDrawable(boolean z) {
        if (this.tAn != z) {
            invalidate();
        }
        this.tAn = z;
    }

    public void setDrawDownDrawable(boolean z) {
        if (this.tAo != z) {
            invalidate();
        }
        this.tAo = z;
    }

    static {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.measureText("H");
    }

    public void setShouldEllipsize(boolean z) {
        this.tAj = z;
    }

    public NoMeasuredTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tzN = Factory.getInstance();
        this.tzO = Spannable.Factory.getInstance();
        this.tzP = null;
        this.tzR = a.tAy;
        this.rA = 51;
        this.tzU = 1.0f;
        this.tzV = 0.0f;
        this.tzW = Integer.MAX_VALUE;
        this.tzX = 1;
        this.tzY = 0;
        this.tzZ = 1;
        this.gg = Integer.MAX_VALUE;
        this.tAa = false;
        this.HB = 0;
        this.tAb = false;
        this.tAc = -1;
        this.tAd = true;
        this.tAf = false;
        this.tAi = false;
        this.tAj = false;
        this.tAl = false;
        this.tAm = false;
        this.tAn = false;
        this.tAo = false;
        this.tAp = -1;
        this.tAq = -1;
        this.tAr = -1;
        this.tAs = -1;
        this.mText = "";
        this.tzQ = "";
        this.dG = new TextPaint(1);
        this.dG.density = getResources().getDisplayMetrics().density;
        setDrawingCacheEnabled(false);
        this.tAh = this.dG.getFontMetricsInt();
        csd();
        setSingleLine(true);
        setEllipsize(null);
    }

    protected boolean getDefaultEditable() {
        return false;
    }

    protected MovementMethod getDefaultMovementMethod() {
        return null;
    }

    @CapturedViewProperty
    public CharSequence getText() {
        return this.mText;
    }

    public Editable getEditableText() {
        return this.mText instanceof Editable ? (Editable) this.mText : null;
    }

    public int getLineHeight() {
        return Math.round((((float) this.dG.getFontMetricsInt(null)) * this.tzU) + this.tzV);
    }

    public final Layout getLayout() {
        return this.tzT;
    }

    private void a(Drawable drawable, Drawable drawable2) {
        b bVar = this.tAk;
        int i = (drawable == null && drawable2 == null) ? 0 : 1;
        if (i != 0) {
            if (bVar == null) {
                bVar = new b(this);
                this.tAk = bVar;
            }
            if (!(bVar.tAF == drawable || bVar.tAF == null)) {
                bVar.tAF.setCallback(null);
            }
            bVar.tAF = drawable;
            if (!(bVar.tAD == null || bVar.tAD == null)) {
                bVar.tAD.setCallback(null);
            }
            bVar.tAD = null;
            if (!(bVar.tAG == drawable2 || bVar.tAG == null)) {
                bVar.tAG.setCallback(null);
            }
            bVar.tAG = drawable2;
            if (!(bVar.tAE == null || bVar.tAE == null)) {
                bVar.tAE.setCallback(null);
            }
            bVar.tAE = null;
            Rect rect = bVar.tAC;
            int[] drawableState = getDrawableState();
            if (drawable != null) {
                drawable.setState(drawableState);
                drawable.copyBounds(rect);
                drawable.setCallback(this);
                bVar.tAJ = rect.width();
                bVar.tAN = rect.height();
            } else {
                bVar.tAN = 0;
                bVar.tAJ = 0;
            }
            if (drawable2 != null) {
                drawable2.setState(drawableState);
                drawable2.copyBounds(rect);
                drawable2.setCallback(this);
                bVar.tAK = rect.width();
                bVar.tAO = rect.height();
                bVar.tAL = 0;
                bVar.tAH = 0;
                bVar.tAM = 0;
                bVar.tAI = 0;
            }
            bVar.tAO = 0;
            bVar.tAK = 0;
            bVar.tAL = 0;
            bVar.tAH = 0;
            bVar.tAM = 0;
            bVar.tAI = 0;
        } else if (bVar != null) {
            if (bVar.tAP == 0) {
                this.tAk = null;
            } else {
                if (bVar.tAF != null) {
                    bVar.tAF.setCallback(null);
                }
                bVar.tAF = null;
                if (bVar.tAD != null) {
                    bVar.tAD.setCallback(null);
                }
                bVar.tAD = null;
                if (bVar.tAG != null) {
                    bVar.tAG.setCallback(null);
                }
                bVar.tAG = null;
                if (bVar.tAE != null) {
                    bVar.tAE.setCallback(null);
                }
                bVar.tAE = null;
                bVar.tAN = 0;
                bVar.tAJ = 0;
                bVar.tAO = 0;
                bVar.tAK = 0;
                bVar.tAL = 0;
                bVar.tAH = 0;
                bVar.tAM = 0;
                bVar.tAI = 0;
            }
        }
        invalidate();
    }

    public void setCompoundLeftDrawablesWithIntrinsicBounds(Drawable drawable) {
        if (drawable != null) {
            if (this.tAk == null || this.tAk.tAF != drawable) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                a(drawable, null);
            }
        }
    }

    public void setCompoundRightDrawablesWithIntrinsicBounds(Drawable drawable) {
        if (drawable != null) {
            if (this.tAk == null || this.tAk.tAG != drawable) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                a(null, drawable);
            }
        }
    }

    public void setCompoundLeftDrawablesWithIntrinsicBounds(int i) {
        if (i != this.tAp) {
            this.tAp = i;
            setCompoundLeftDrawablesWithIntrinsicBounds(getResources().getDrawable(i));
        }
    }

    public void setCompoundRightDrawablesWithIntrinsicBounds(int i) {
        if (i != this.tAq) {
            this.tAq = i;
            setCompoundRightDrawablesWithIntrinsicBounds(getResources().getDrawable(i));
        }
    }

    public Drawable[] getCompoundDrawables() {
        if (this.tAk != null) {
            return new Drawable[]{this.tAk.tAF, this.tAk.tAD, this.tAk.tAG, this.tAk.tAE};
        }
        return new Drawable[]{null, null, null, null};
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.bv != null && this.bv.isStateful()) {
            updateTextColors();
        }
        b bVar = this.tAk;
        if (bVar != null) {
            int[] drawableState = getDrawableState();
            if (bVar.tAD != null && bVar.tAD.isStateful()) {
                bVar.tAD.setState(drawableState);
            }
            if (bVar.tAE != null && bVar.tAE.isStateful()) {
                bVar.tAE.setState(drawableState);
            }
            if (bVar.tAF != null && bVar.tAF.isStateful()) {
                bVar.tAF.setState(drawableState);
            }
            if (bVar.tAG != null && bVar.tAG.isStateful()) {
                bVar.tAG.setState(drawableState);
            }
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean verifyDrawable = super.verifyDrawable(drawable);
        if (verifyDrawable || this.tAk == null) {
            return verifyDrawable;
        }
        return drawable == this.tAk.tAF || drawable == this.tAk.tAD || drawable == this.tAk.tAG || drawable == this.tAk.tAE;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            b bVar = this.tAk;
            if (bVar != null) {
                int compoundPaddingTop;
                if (drawable == bVar.tAF) {
                    compoundPaddingTop = getCompoundPaddingTop();
                    scrollX += getPaddingLeft();
                    scrollY += (((((getBottom() - getTop()) - getCompoundPaddingBottom()) - compoundPaddingTop) - bVar.tAN) / 2) + compoundPaddingTop;
                } else if (drawable == bVar.tAG) {
                    compoundPaddingTop = getCompoundPaddingTop();
                    scrollX += ((getRight() - getLeft()) - getPaddingRight()) - bVar.tAK;
                    scrollY += (((((getBottom() - getTop()) - getCompoundPaddingBottom()) - compoundPaddingTop) - bVar.tAO) / 2) + compoundPaddingTop;
                } else if (drawable == bVar.tAD) {
                    compoundPaddingTop = getCompoundPaddingLeft();
                    scrollX += (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingTop) - bVar.tAL) / 2) + compoundPaddingTop;
                    scrollY += getPaddingTop();
                } else if (drawable == bVar.tAE) {
                    compoundPaddingTop = getCompoundPaddingLeft();
                    scrollX += compoundPaddingTop + (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingTop) - bVar.tAM) / 2);
                    scrollY += ((getBottom() - getTop()) - getPaddingBottom()) - bVar.tAI;
                }
            }
            invalidate(bounds.left + scrollX, bounds.top + scrollY, scrollX + bounds.right, scrollY + bounds.bottom);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCompoundDrawablePadding(int r2) {
        /*
        r1 = this;
        r0 = r1.tAk;
        if (r2 != 0) goto L_0x000f;
    L_0x0004:
        if (r0 == 0) goto L_0x0008;
    L_0x0006:
        r0.tAP = r2;
    L_0x0008:
        r1.invalidate();
        r1.requestLayout();
        return;
    L_0x000f:
        if (r0 != 0) goto L_0x0006;
    L_0x0011:
        r0 = new com.tencent.mm.ui.base.NoMeasuredTextView$b;
        r0.<init>(r1);
        r1.tAk = r0;
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.base.NoMeasuredTextView.setCompoundDrawablePadding(int):void");
    }

    public int getCompoundDrawablePadding() {
        b bVar = this.tAk;
        return bVar != null ? bVar.tAP : 0;
    }

    public int getCompoundPaddingTop() {
        b bVar = this.tAk;
        if (bVar == null || bVar.tAD == null || !this.tAn) {
            return getPaddingTop();
        }
        return bVar.tAH + (getPaddingTop() + bVar.tAP);
    }

    public int getCompoundPaddingBottom() {
        b bVar = this.tAk;
        if (bVar == null || bVar.tAE == null || !this.tAo) {
            return getPaddingBottom();
        }
        return bVar.tAI + (getPaddingBottom() + bVar.tAP);
    }

    public int getCompoundPaddingLeft() {
        b bVar = this.tAk;
        if (bVar == null || bVar.tAF == null || !this.tAl) {
            return getPaddingLeft();
        }
        return bVar.tAJ + (getPaddingLeft() + bVar.tAP);
    }

    public int getCompoundPaddingRight() {
        b bVar = this.tAk;
        if (bVar == null || bVar.tAG == null || !this.tAm) {
            return getPaddingRight();
        }
        return bVar.tAK + (getPaddingRight() + bVar.tAP);
    }

    public int getExtendedPaddingTop() {
        if (this.tzT == null || this.tzX != 1) {
            return getCompoundPaddingTop();
        }
        if (this.tzT.getLineCount() <= this.tzW) {
            return getCompoundPaddingTop();
        }
        int compoundPaddingTop = getCompoundPaddingTop();
        int height = (getHeight() - compoundPaddingTop) - getCompoundPaddingBottom();
        int lineTop = this.tzT.getLineTop(this.tzW);
        if (lineTop >= height) {
            return compoundPaddingTop;
        }
        int i = this.rA & 112;
        if (i == 48) {
            return compoundPaddingTop;
        }
        if (i == 80) {
            return (compoundPaddingTop + height) - lineTop;
        }
        return compoundPaddingTop + ((height - lineTop) / 2);
    }

    public int getExtendedPaddingBottom() {
        if (this.tzT == null || this.tzX != 1) {
            return getCompoundPaddingBottom();
        }
        if (this.tzT.getLineCount() <= this.tzW) {
            return getCompoundPaddingBottom();
        }
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        compoundPaddingTop = (getHeight() - compoundPaddingTop) - compoundPaddingBottom;
        int lineTop = this.tzT.getLineTop(this.tzW);
        if (lineTop >= compoundPaddingTop) {
            return compoundPaddingBottom;
        }
        int i = this.rA & 112;
        if (i == 48) {
            return (compoundPaddingBottom + compoundPaddingTop) - lineTop;
        }
        return i != 80 ? compoundPaddingBottom + ((compoundPaddingTop - lineTop) / 2) : compoundPaddingBottom;
    }

    public int getTotalPaddingLeft() {
        return getCompoundPaddingLeft();
    }

    public int getTotalPaddingRight() {
        return getCompoundPaddingRight();
    }

    public int getTotalPaddingTop() {
        return getExtendedPaddingTop() + getVerticalOffset$1385f2();
    }

    public int getTotalPaddingBottom() {
        int extendedPaddingBottom = getExtendedPaddingBottom();
        int i = 0;
        int i2 = this.rA & 112;
        Layout layout = this.tzT;
        if (i2 != 80) {
            int measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom();
            int height = layout.getHeight();
            if (height < measuredHeight) {
                i = i2 == 48 ? measuredHeight - height : (measuredHeight - height) >> 1;
            }
        }
        return i + extendedPaddingBottom;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (!(i == getPaddingLeft() && i3 == getPaddingRight() && i2 == getPaddingTop() && i4 == getPaddingBottom())) {
            csb();
        }
        super.setPadding(i, i2, i3, i4);
        invalidate();
    }

    public float getTextSize() {
        return this.dG.getTextSize();
    }

    public void setTextSize(float f) {
        setTextSize(2, f);
    }

    public final void setTextSize(int i, float f) {
        Resources system;
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
    }

    private void setRawTextSize(float f) {
        if (f != this.dG.getTextSize()) {
            this.dG.setTextSize(f);
            this.tAh = this.dG.getFontMetricsInt();
            this.tAg = (int) (Math.ceil((double) (this.tAh.descent - this.tAh.ascent)) + 2.0d);
            if (this.tzT != null) {
                csb();
                requestLayout();
                invalidate();
            }
        }
    }

    public float getTextScaleX() {
        return this.dG.getTextScaleX();
    }

    public void setTypeface(Typeface typeface) {
        if (this.dG.getTypeface() != typeface) {
            this.dG.setTypeface(typeface);
            if (this.tzT != null) {
                csb();
                requestLayout();
                invalidate();
            }
        }
    }

    public Typeface getTypeface() {
        return this.dG.getTypeface();
    }

    public void setTextColor(int i) {
        this.bv = ColorStateList.valueOf(i);
        updateTextColors();
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            throw new NullPointerException();
        } else if (this.bv != colorStateList) {
            this.bv = colorStateList;
            updateTextColors();
        }
    }

    public final ColorStateList getTextColors() {
        return this.bv;
    }

    public final int getCurrentTextColor() {
        return this.tzM;
    }

    public TextPaint getPaint() {
        return this.dG;
    }

    public void setGravity(int i) {
        int i2;
        if ((i & 7) == 0) {
            i2 = i | 3;
        } else {
            i2 = i;
        }
        if ((i2 & 112) == 0) {
            i2 |= 48;
        }
        Object obj = null;
        if ((i2 & 7) != (this.rA & 7)) {
            obj = 1;
        }
        if (i2 != this.rA) {
            invalidate();
        }
        this.rA = i2;
        if (this.tzT != null && obj != null) {
            eU(this.tzT.getWidth(), (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight());
        }
    }

    public int getGravity() {
        return this.rA;
    }

    public int getPaintFlags() {
        return this.dG.getFlags();
    }

    public void setPaintFlags(int i) {
        if (this.dG.getFlags() != i) {
            this.dG.setFlags(i);
            if (this.tzT != null) {
                csb();
                requestLayout();
                invalidate();
            }
        }
    }

    public void setMinLines(int i) {
        this.tzY = i;
        this.tzZ = 1;
        requestLayout();
        invalidate();
    }

    public void setMinHeight(int i) {
        this.tzY = i;
        this.tzZ = 2;
        requestLayout();
        invalidate();
    }

    public void setMaxLines(int i) {
        this.tzW = i;
        this.tzX = 1;
        requestLayout();
        invalidate();
    }

    public void setMaxHeight(int i) {
        this.tzW = i;
        this.tzX = 2;
        requestLayout();
        invalidate();
    }

    public void setLines(int i) {
        this.tzY = i;
        this.tzW = i;
        this.tzZ = 1;
        this.tzX = 1;
        requestLayout();
        invalidate();
    }

    public void setHeight(int i) {
        this.tzY = i;
        this.tzW = i;
        this.tzZ = 2;
        this.tzX = 2;
        requestLayout();
        invalidate();
    }

    public void setMinWidth(int i) {
        this.HB = i;
        this.tAb = true;
        requestLayout();
        invalidate();
    }

    public void setMaxWidth(int i) {
        this.gg = i;
        this.tAa = true;
        requestLayout();
        invalidate();
    }

    public void setWidth(int i) {
        this.HB = i;
        this.gg = i;
        this.tAb = true;
        this.tAa = true;
        requestLayout();
        invalidate();
    }

    private void updateTextColors() {
        int i = 0;
        int colorForState = this.bv.getColorForState(getDrawableState(), 0);
        if (colorForState != this.tzM) {
            this.tzM = colorForState;
            i = 1;
        }
        if (i != 0) {
            invalidate();
        }
    }

    public final void setEditableFactory(Factory factory) {
        this.tzN = factory;
        setText(this.mText);
    }

    public final void setSpannableFactory(Spannable.Factory factory) {
        this.tzO = factory;
        setText(this.mText);
    }

    public final void setText(CharSequence charSequence) {
        h(charSequence, this.tzR);
    }

    public final void setTextKeepState(CharSequence charSequence) {
        int i = this.tzR;
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        int length = charSequence.length();
        h(charSequence, i);
        if ((selectionStart >= 0 || selectionEnd >= 0) && (this.mText instanceof Spannable)) {
            Selection.setSelection((Spannable) this.mText, Math.max(0, Math.min(selectionStart, length)), Math.max(0, Math.min(selectionEnd, length)));
        }
    }

    private void h(CharSequence charSequence, int i) {
        CharSequence charSequence2 = charSequence == null ? "" : charSequence;
        if (!charSequence2.equals(this.mText)) {
            int i2;
            if (!(getMeasuredWidth() <= 0 || this.tAw == null || bi.oW(this.tAt))) {
                charSequence2 = this.tAw.a(this, charSequence2, this.tAt, this.tAu, this.tAv);
                this.tAt = null;
            }
            if (charSequence2 instanceof Spanned) {
                this.tAf = false;
            } else {
                this.tAf = true;
            }
            if (i == a.tAA || this.tzS != null) {
                charSequence2 = this.tzN.newEditable(charSequence2);
            } else if (i == a.tAz) {
                charSequence2 = this.tzO.newSpannable(charSequence2);
            }
            int compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundPaddingRight();
            if (this.tAj) {
                if (this.tAa) {
                    i2 = this.gg;
                    if (getMeasuredWidth() > 0) {
                        i2 = Math.min(this.gg, getMeasuredWidth());
                    }
                    charSequence2 = TextUtils.ellipsize(charSequence2, this.dG, (float) (i2 - compoundPaddingLeft), TruncateAt.END);
                } else if (getMeasuredWidth() > 0) {
                    charSequence2 = TextUtils.ellipsize(charSequence2, this.dG, (float) (getMeasuredWidth() - compoundPaddingLeft), TruncateAt.END);
                } else {
                    this.tAi = true;
                }
            }
            this.tzR = i;
            this.mText = charSequence2;
            this.tzQ = charSequence2;
            if (this.tAf) {
                csd();
                invalidate();
                return;
            }
            if (getWidth() != 0) {
                if (this.tzT == null) {
                    csc();
                    if (this.tzT.getHeight() != getHeight()) {
                        requestLayout();
                    }
                    invalidate();
                    return;
                }
                i2 = this.tzT.getHeight();
                int width = this.tzT.getWidth();
                eU(width, width - compoundPaddingLeft);
                if (this.tzP != TruncateAt.MARQUEE) {
                    if (getLayoutParams().height == -2 || getLayoutParams().height == -1) {
                        compoundPaddingLeft = this.tzT.getHeight();
                        if (compoundPaddingLeft == i2 && compoundPaddingLeft == getHeight()) {
                            invalidate();
                            return;
                        }
                    }
                    invalidate();
                    return;
                }
            }
            requestLayout();
            invalidate();
        }
    }

    public final void an(String str, int i, int i2) {
        this.tAt = str;
        this.tAu = i;
        this.tAv = i2;
    }

    public void setLayoutCallback(c cVar) {
        this.tAw = cVar;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.tAi && getMeasuredWidth() > 0) {
            if (bi.oW(this.tAt) || this.tAw == null) {
                setText(TextUtils.ellipsize(this.mText, getPaint(), (float) ((getMeasuredWidth() - getCompoundPaddingRight()) - getCompoundPaddingLeft()), TruncateAt.END));
            } else {
                CharSequence a = this.tAw.a(this, this.mText, this.tAt, this.tAu, this.tAv);
                this.tAt = null;
                setText(a);
            }
            this.tAi = false;
        }
    }

    public final void setText(int i) {
        setText(getContext().getResources().getText(i));
    }

    private int getVerticalOffset$1385f2() {
        int i = this.rA & 112;
        Layout layout = this.tzT;
        if (i == 48) {
            return 0;
        }
        int measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom();
        int height = layout.getHeight();
        if (height >= measuredHeight) {
            return 0;
        }
        if (i == 80) {
            return measuredHeight - height;
        }
        return (measuredHeight - height) >> 1;
    }

    private int getBottomVerticalOffset$1385f2() {
        int i = this.rA & 112;
        Layout layout = this.tzT;
        if (i == 80) {
            return 0;
        }
        int measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom();
        int height = layout.getHeight();
        if (height >= measuredHeight) {
            return 0;
        }
        if (i == 48) {
            return measuredHeight - height;
        }
        return (measuredHeight - height) >> 1;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingRight = getCompoundPaddingRight();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int right = getRight();
        int left = getLeft();
        int bottom = getBottom();
        int top = getTop();
        int width = getWidth();
        int height = getHeight();
        b bVar = this.tAk;
        float f = -1.0f;
        if (bVar != null) {
            int i = ((bottom - top) - compoundPaddingBottom) - compoundPaddingTop;
            int i2 = ((right - left) - compoundPaddingRight) - compoundPaddingLeft;
            if (this.tAl && bVar.tAF != null) {
                canvas.save();
                canvas.translate((float) (getPaddingLeft() + scrollX), (float) ((scrollY + compoundPaddingTop) + ((i - bVar.tAN) / 2)));
                bVar.tAF.draw(canvas);
                canvas.restore();
            }
            if (this.tAm && bVar.tAG != null) {
                float f2;
                float f3;
                canvas.save();
                if (this.tAf) {
                    f = this.dG.measureText(this.mText, 0, this.mText.length());
                    f2 = f;
                    f3 = f;
                } else {
                    f2 = (float) Math.ceil((double) Layout.getDesiredWidth(this.tzQ, this.dG));
                    f3 = -1.0f;
                }
                canvas.translate((f2 + ((float) scrollX)) - ((float) getPaddingRight()), (float) ((scrollY + compoundPaddingTop) + ((i - bVar.tAO) / 2)));
                bVar.tAG.draw(canvas);
                canvas.restore();
                f = f3;
            }
            if (this.tAn && bVar.tAD != null) {
                canvas.save();
                canvas.translate((float) ((scrollX + compoundPaddingLeft) + ((i2 - bVar.tAL) / 2)), (float) (getPaddingTop() + scrollY));
                bVar.tAD.draw(canvas);
                canvas.restore();
            }
            if (this.tAo && bVar.tAE != null) {
                canvas.save();
                canvas.translate((float) ((scrollX + compoundPaddingLeft) + ((i2 - bVar.tAM) / 2)), (float) ((((scrollY + bottom) - top) - getPaddingBottom()) - bVar.tAI));
                bVar.tAE.draw(canvas);
                canvas.restore();
            }
        }
        this.dG.setColor(this.tzM);
        this.dG.drawableState = getDrawableState();
        canvas.save();
        compoundPaddingTop = getExtendedPaddingTop();
        Canvas canvas2 = canvas;
        float f4 = (float) (compoundPaddingTop + scrollY);
        canvas2.clipRect((float) (compoundPaddingLeft + scrollX), f4, (float) (((right - left) - compoundPaddingRight) + scrollX), (float) (((bottom - top) - getExtendedPaddingBottom()) + scrollY));
        int i3 = 0;
        compoundPaddingBottom = 0;
        if ((this.rA & 112) != 48) {
            i3 = getVerticalOffset$1385f2();
            compoundPaddingBottom = getVerticalOffset$1385f2();
        }
        canvas.translate((float) compoundPaddingLeft, (float) (compoundPaddingTop + i3));
        if (this.tAf) {
            float f5 = (float) (((height - (this.tAh.bottom - this.tAh.top)) / 2) - this.tAh.top);
            compoundPaddingBottom = 0;
            if ((this.rA & 7) != 3) {
                switch (this.rA & 7) {
                    case 1:
                        if (f == -1.0f) {
                            f = this.dG.measureText(this.mText, 0, this.mText.length());
                        }
                        compoundPaddingBottom = ((int) (((float) (width - getPaddingRight())) - f)) / 2;
                        break;
                    case 5:
                        if (f == -1.0f) {
                            f = this.dG.measureText(this.mText, 0, this.mText.length());
                        }
                        compoundPaddingBottom = (int) (((float) (width - getPaddingRight())) - f);
                        break;
                }
            }
            canvas.drawText(this.mText, 0, this.mText.length(), (float) compoundPaddingBottom, f5, this.dG);
        } else {
            if (this.tzT == null) {
                csc();
            }
            this.tzT.draw(canvas, null, null, compoundPaddingBottom - i3);
        }
        canvas.restore();
    }

    public void getFocusedRect(Rect rect) {
        if (this.tzT == null) {
            super.getFocusedRect(rect);
            return;
        }
        int selectionEnd = getSelectionEnd();
        if (selectionEnd < 0) {
            super.getFocusedRect(rect);
            return;
        }
        int lineForOffset = this.tzT.getLineForOffset(selectionEnd);
        rect.top = this.tzT.getLineTop(lineForOffset);
        rect.bottom = this.tzT.getLineBottom(lineForOffset);
        rect.left = (int) this.tzT.getPrimaryHorizontal(selectionEnd);
        rect.right = rect.left + 1;
        lineForOffset = getCompoundPaddingLeft();
        selectionEnd = getExtendedPaddingTop();
        if ((this.rA & 112) != 48) {
            selectionEnd += getVerticalOffset$1385f2();
        }
        rect.offset(lineForOffset, selectionEnd);
    }

    public int getLineCount() {
        return this.tzT != null ? this.tzT.getLineCount() : 0;
    }

    public int getBaseline() {
        if (this.tzT == null) {
            return super.getBaseline();
        }
        int verticalOffset$1385f2;
        if ((this.rA & 112) != 48) {
            verticalOffset$1385f2 = getVerticalOffset$1385f2();
        } else {
            verticalOffset$1385f2 = 0;
        }
        return (verticalOffset$1385f2 + getExtendedPaddingTop()) + this.tzT.getLineBaseline(0);
    }

    private void csb() {
        if ((this.tzT instanceof BoringLayout) && this.tAe == null) {
            this.tAe = (BoringLayout) this.tzT;
        }
        this.tzT = null;
    }

    private void csc() {
        int compoundPaddingLeft;
        if (this.tAa) {
            compoundPaddingLeft = (this.gg - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        } else {
            compoundPaddingLeft = ((getRight() - getLeft()) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        }
        if (compoundPaddingLeft <= 0) {
            compoundPaddingLeft = 0;
        }
        eU(compoundPaddingLeft, compoundPaddingLeft);
    }

    private void eU(int i, int i2) {
        int i3;
        Alignment alignment;
        int i4;
        if (i < 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        switch (this.rA & 7) {
            case 1:
                alignment = Alignment.ALIGN_CENTER;
                break;
            case 5:
                alignment = Alignment.ALIGN_OPPOSITE;
                break;
            default:
                alignment = Alignment.ALIGN_NORMAL;
                break;
        }
        if (this.tzP == null || this.tzS != null) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        if (i4 != 0) {
            this.tzT = new StaticLayout(this.tzQ, 0, this.tzQ.length(), this.dG, i3, alignment, this.tzU, this.tzV, this.tAd, this.tzP, i2);
        } else {
            this.tzT = new StaticLayout(this.tzQ, this.dG, i3, alignment, this.tzU, this.tzV, this.tAd);
        }
    }

    public void setIncludeFontPadding(boolean z) {
        this.tAd = z;
        if (this.tzT != null) {
            csb();
            requestLayout();
            invalidate();
        }
    }

    protected void onMeasure(int i, int i2) {
        MeasureSpec.getMode(i);
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (size == 0) {
            setMeasuredDimension(size, this.tAg);
        } else if (this.tAf) {
            if (this.tAg == 0) {
                csd();
            }
            setMeasuredDimension(size, this.tAg);
        } else {
            int compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundPaddingRight();
            if (this.tAa) {
                compoundPaddingLeft = this.gg - compoundPaddingLeft;
            } else {
                compoundPaddingLeft = size - compoundPaddingLeft;
            }
            if (this.tzT == null) {
                eU(compoundPaddingLeft, compoundPaddingLeft);
            } else {
                int i3;
                if (this.tzT.getWidth() != compoundPaddingLeft) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    eU(compoundPaddingLeft, compoundPaddingLeft);
                }
            }
            if (mode == 1073741824) {
                this.tAc = -1;
                compoundPaddingLeft = size2;
            } else {
                compoundPaddingLeft = getDesiredHeight();
                this.tAc = compoundPaddingLeft;
                if (mode == Integer.MIN_VALUE) {
                    compoundPaddingLeft = Math.min(compoundPaddingLeft, size2);
                }
            }
            scrollTo(0, 0);
            setMeasuredDimension(size, compoundPaddingLeft);
        }
    }

    private int getDesiredHeight() {
        Layout layout = this.tzT;
        if (layout == null) {
            return 0;
        }
        int lineCount = layout.getLineCount();
        int compoundPaddingBottom = getCompoundPaddingBottom() + getCompoundPaddingTop();
        int lineTop = layout.getLineTop(lineCount) + compoundPaddingBottom;
        if (this.tzX != 1) {
            lineTop = Math.min(lineTop, this.tzW);
        } else if (lineCount > this.tzW) {
            lineTop = (layout.getLineTop(this.tzW) + layout.getBottomPadding()) + compoundPaddingBottom;
            lineCount = this.tzW;
        }
        if (this.tzZ != 1) {
            lineTop = Math.max(lineTop, this.tzY);
        } else if (lineCount < this.tzY) {
            lineTop += (this.tzY - lineCount) * getLineHeight();
        }
        return Math.max(lineTop, getSuggestedMinimumHeight());
    }

    private void csd() {
        if (this.tAg == 0) {
            this.tAg = (int) (Math.ceil((double) (this.tAh.descent - this.tAh.ascent)) + 2.0d);
        }
    }

    @ExportedProperty
    public int getSelectionStart() {
        return Selection.getSelectionStart(getText());
    }

    @ExportedProperty
    public int getSelectionEnd() {
        return Selection.getSelectionEnd(getText());
    }

    public void setSingleLine(boolean z) {
        this.txi = z;
        if (z) {
            setLines(1);
        } else {
            setMaxLines(Integer.MAX_VALUE);
        }
    }

    public void setEllipsize(TruncateAt truncateAt) {
        this.tzP = truncateAt;
        if (this.tzT != null) {
            csb();
            requestLayout();
            invalidate();
        }
    }

    @ExportedProperty
    public TruncateAt getEllipsize() {
        return this.tzP;
    }

    protected int computeHorizontalScrollRange() {
        if (this.tzT != null) {
            return this.tzT.getWidth();
        }
        return super.computeHorizontalScrollRange();
    }

    protected int computeVerticalScrollRange() {
        if (this.tzT != null) {
            return this.tzT.getHeight();
        }
        return super.computeVerticalScrollRange();
    }

    protected int computeVerticalScrollExtent() {
        return (getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom();
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        CharSequence contentDescription = getContentDescription();
        if (bi.oW((String) contentDescription)) {
            contentDescription = getText();
        }
        accessibilityNodeInfo.setText(contentDescription);
    }
}
