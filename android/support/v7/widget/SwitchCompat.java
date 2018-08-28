package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v7.a.a.a;
import android.support.v7.a.a.k;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public class SwitchCompat extends CompoundButton {
    private static final int[] bh = new int[]{16842912};
    private final h Mb;
    private int Rx;
    private Drawable VJ;
    private Drawable VK;
    private int VL;
    private int VM;
    private int VN;
    private boolean VO;
    private CharSequence VP;
    private CharSequence VQ;
    private boolean VR;
    private int VS;
    private float VT;
    private float VU;
    private float VV;
    private int VW;
    private int VX;
    private int VY;
    private int VZ;
    private int Wa;
    private int Wb;
    private int Wc;
    private ColorStateList Wd;
    private Layout We;
    private Layout Wf;
    private TransformationMethod Wg;
    private a Wh;
    private final Rect bJ;
    private VelocityTracker cE;
    private TextPaint dG;
    private int fW;

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cE = VelocityTracker.obtain();
        this.bJ = new Rect();
        this.dG = new TextPaint(1);
        this.dG.density = getResources().getDisplayMetrics().density;
        ap a = ap.a(context, attributeSet, k.SwitchCompat, i);
        this.VJ = a.getDrawable(k.SwitchCompat_android_thumb);
        if (this.VJ != null) {
            this.VJ.setCallback(this);
        }
        this.VK = a.getDrawable(k.SwitchCompat_track);
        if (this.VK != null) {
            this.VK.setCallback(this);
        }
        this.VP = a.getText(k.SwitchCompat_android_textOn);
        this.VQ = a.getText(k.SwitchCompat_android_textOff);
        this.VR = a.getBoolean(k.SwitchCompat_showText, true);
        this.VL = a.getDimensionPixelSize(k.SwitchCompat_thumbTextPadding, 0);
        this.VM = a.getDimensionPixelSize(k.SwitchCompat_switchMinWidth, 0);
        this.VN = a.getDimensionPixelSize(k.SwitchCompat_switchPadding, 0);
        this.VO = a.getBoolean(k.SwitchCompat_splitTrack, false);
        int resourceId = a.getResourceId(k.SwitchCompat_switchTextAppearance, 0);
        if (resourceId != 0) {
            Typeface typeface;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId, k.TextAppearance);
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(k.TextAppearance_android_textColor);
            if (colorStateList != null) {
                this.Wd = colorStateList;
            } else {
                this.Wd = getTextColors();
            }
            resourceId = obtainStyledAttributes.getDimensionPixelSize(k.TextAppearance_android_textSize, 0);
            if (!(resourceId == 0 || ((float) resourceId) == this.dG.getTextSize())) {
                this.dG.setTextSize((float) resourceId);
                requestLayout();
            }
            resourceId = obtainStyledAttributes.getInt(k.TextAppearance_android_typeface, -1);
            int i2 = obtainStyledAttributes.getInt(k.TextAppearance_android_textStyle, -1);
            switch (resourceId) {
                case 1:
                    typeface = Typeface.SANS_SERIF;
                    break;
                case 2:
                    typeface = Typeface.SERIF;
                    break;
                case 3:
                    typeface = Typeface.MONOSPACE;
                    break;
                default:
                    typeface = null;
                    break;
            }
            if (i2 > 0) {
                typeface = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
                setSwitchTypeface(typeface);
                i2 &= (typeface != null ? typeface.getStyle() : 0) ^ -1;
                this.dG.setFakeBoldText((i2 & 1) != 0);
                this.dG.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
            } else {
                this.dG.setFakeBoldText(false);
                this.dG.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (obtainStyledAttributes.getBoolean(k.TextAppearance_textAllCaps, false)) {
                this.Wg = new android.support.v7.e.a(getContext());
            } else {
                this.Wg = null;
            }
            obtainStyledAttributes.recycle();
        }
        this.Mb = h.eJ();
        a.Ww.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.fW = viewConfiguration.getScaledTouchSlop();
        this.Rx = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.dG.getTypeface() != typeface) {
            this.dG.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int i) {
        this.VN = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.VN;
    }

    public void setSwitchMinWidth(int i) {
        this.VM = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.VM;
    }

    public void setThumbTextPadding(int i) {
        this.VL = i;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.VL;
    }

    public void setTrackDrawable(Drawable drawable) {
        this.VK = drawable;
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(this.Mb.a(getContext(), i, false));
    }

    public Drawable getTrackDrawable() {
        return this.VK;
    }

    public void setThumbDrawable(Drawable drawable) {
        this.VJ = drawable;
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(this.Mb.a(getContext(), i, false));
    }

    public Drawable getThumbDrawable() {
        return this.VJ;
    }

    public void setSplitTrack(boolean z) {
        this.VO = z;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.VO;
    }

    public CharSequence getTextOn() {
        return this.VP;
    }

    public void setTextOn(CharSequence charSequence) {
        this.VP = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.VQ;
    }

    public void setTextOff(CharSequence charSequence) {
        this.VQ = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z) {
        if (this.VR != z) {
            this.VR = z;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.VR;
    }

    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int max;
        int i3 = 0;
        if (this.VR) {
            if (this.We == null) {
                this.We = h(this.VP);
            }
            if (this.Wf == null) {
                this.Wf = h(this.VQ);
            }
        }
        Rect rect = this.bJ;
        if (this.VJ != null) {
            this.VJ.getPadding(rect);
            intrinsicWidth = (this.VJ.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.VJ.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        }
        if (this.VR) {
            max = Math.max(this.We.getWidth(), this.Wf.getWidth()) + (this.VL * 2);
        } else {
            max = 0;
        }
        this.VY = Math.max(max, intrinsicWidth);
        if (this.VK != null) {
            this.VK.getPadding(rect);
            i3 = this.VK.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        intrinsicWidth = rect.left;
        max = rect.right;
        if (this.VJ != null) {
            rect = w.l(this.VJ);
            intrinsicWidth = Math.max(intrinsicWidth, rect.left);
            max = Math.max(max, rect.right);
        }
        intrinsicWidth = Math.max(this.VM, (intrinsicWidth + (this.VY * 2)) + max);
        intrinsicHeight = Math.max(i3, intrinsicHeight);
        this.VW = intrinsicWidth;
        this.VX = intrinsicHeight;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < intrinsicHeight) {
            setMeasuredDimension(z.L(this), intrinsicHeight);
        }
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object obj = isChecked() ? this.VP : this.VQ;
        if (obj != null) {
            accessibilityEvent.getText().add(obj);
        }
    }

    private Layout h(CharSequence charSequence) {
        CharSequence transformation;
        if (this.Wg != null) {
            transformation = this.Wg.getTransformation(charSequence, this);
        } else {
            transformation = charSequence;
        }
        return new StaticLayout(transformation, this.dG, transformation != null ? (int) Math.ceil((double) Layout.getDesiredWidth(transformation, this.dG)) : 0, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 1.0f;
        int i = 0;
        this.cE.addMovement(motionEvent);
        float x;
        switch (o.d(motionEvent)) {
            case 0:
                x = motionEvent.getX();
                f = motionEvent.getY();
                if (isEnabled()) {
                    if (this.VJ != null) {
                        int thumbOffset = getThumbOffset();
                        this.VJ.getPadding(this.bJ);
                        int i2 = this.Wa - this.fW;
                        thumbOffset = (thumbOffset + this.VZ) - this.fW;
                        int i3 = (((this.VY + thumbOffset) + this.bJ.left) + this.bJ.right) + this.fW;
                        int i4 = this.Wc + this.fW;
                        if (x > ((float) thumbOffset) && x < ((float) i3) && f > ((float) i2) && f < ((float) i4)) {
                            i = 1;
                        }
                    }
                    if (i != 0) {
                        this.VS = 1;
                        this.VT = x;
                        this.VU = f;
                        break;
                    }
                }
                break;
            case 1:
            case 3:
                if (this.VS != 2) {
                    this.VS = 0;
                    this.cE.clear();
                    break;
                }
                boolean z;
                this.VS = 0;
                if (motionEvent.getAction() == 1 && isEnabled()) {
                    z = true;
                } else {
                    z = false;
                }
                boolean isChecked = isChecked();
                if (z) {
                    this.cE.computeCurrentVelocity(BaseReportManager.MAX_READ_COUNT);
                    x = this.cE.getXVelocity();
                    z = Math.abs(x) > ((float) this.Rx) ? at.bv(this) ? x < 0.0f : x > 0.0f : getTargetCheckedState();
                } else {
                    z = isChecked;
                }
                if (z != isChecked) {
                    playSoundEffect(0);
                }
                setChecked(z);
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                super.onTouchEvent(obtain);
                obtain.recycle();
                super.onTouchEvent(motionEvent);
                return true;
            case 2:
                switch (this.VS) {
                    case 1:
                        x = motionEvent.getX();
                        f = motionEvent.getY();
                        if (Math.abs(x - this.VT) > ((float) this.fW) || Math.abs(f - this.VU) > ((float) this.fW)) {
                            this.VS = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.VT = x;
                            this.VU = f;
                            return true;
                        }
                    case 2:
                        float x2 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f2 = x2 - this.VT;
                        x = thumbScrollRange != 0 ? f2 / ((float) thumbScrollRange) : f2 > 0.0f ? 1.0f : -1.0f;
                        if (at.bv(this)) {
                            x = -x;
                        }
                        x += this.VV;
                        if (x < 0.0f) {
                            f = 0.0f;
                        } else if (x <= 1.0f) {
                            f = x;
                        }
                        if (f == this.VV) {
                            return true;
                        }
                        this.VT = x2;
                        setThumbPosition(f);
                        return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void gZ() {
        if (this.Wh != null) {
            clearAnimation();
            this.Wh = null;
        }
    }

    private boolean getTargetCheckedState() {
        return this.VV > 0.5f;
    }

    private void setThumbPosition(float f) {
        this.VV = f;
        invalidate();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setChecked(boolean z) {
        float f = 1.0f;
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() != null && z.ai(this) && isShown()) {
            if (this.Wh != null) {
                gZ();
            }
            float f2 = this.VV;
            if (!isChecked) {
                f = 0.0f;
            }
            this.Wh = new a(this, f2, f, (byte) 0);
            this.Wh.setDuration(250);
            this.Wh.setAnimationListener(new 1(this, isChecked));
            startAnimation(this.Wh);
            return;
        }
        gZ();
        if (!isChecked) {
            f = 0.0f;
        }
        setThumbPosition(f);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int max2;
        int paddingLeft;
        int paddingTop;
        super.onLayout(z, i, i2, i3, i4);
        if (this.VJ != null) {
            Rect rect = this.bJ;
            if (this.VK != null) {
                this.VK.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect l = w.l(this.VJ);
            max = Math.max(0, l.left - rect.left);
            max2 = Math.max(0, l.right - rect.right);
        } else {
            max2 = 0;
            max = 0;
        }
        if (at.bv(this)) {
            paddingLeft = getPaddingLeft() + max;
            max = ((this.VW + paddingLeft) - max) - max2;
            max2 = paddingLeft;
        } else {
            paddingLeft = (getWidth() - getPaddingRight()) - max2;
            max2 += max + (paddingLeft - this.VW);
            max = paddingLeft;
        }
        switch (getGravity() & 112) {
            case 16:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.VX / 2);
                paddingLeft = this.VX + paddingTop;
                break;
            case f$k.AppCompatTheme_panelMenuListTheme /*80*/:
                paddingLeft = getHeight() - getPaddingBottom();
                paddingTop = paddingLeft - this.VX;
                break;
            default:
                paddingTop = getPaddingTop();
                paddingLeft = this.VX + paddingTop;
                break;
        }
        this.VZ = max2;
        this.Wa = paddingTop;
        this.Wc = paddingLeft;
        this.Wb = max;
    }

    public void draw(Canvas canvas) {
        Rect l;
        int i;
        Rect rect = this.bJ;
        int i2 = this.VZ;
        int i3 = this.Wa;
        int i4 = this.Wb;
        int i5 = this.Wc;
        int thumbOffset = i2 + getThumbOffset();
        if (this.VJ != null) {
            l = w.l(this.VJ);
        } else {
            l = w.Or;
        }
        if (this.VK != null) {
            this.VK.getPadding(rect);
            int i6 = rect.left + thumbOffset;
            if (l != null) {
                if (l.left > rect.left) {
                    i2 += l.left - rect.left;
                }
                if (l.top > rect.top) {
                    thumbOffset = (l.top - rect.top) + i3;
                } else {
                    thumbOffset = i3;
                }
                if (l.right > rect.right) {
                    i4 -= l.right - rect.right;
                }
                i = l.bottom > rect.bottom ? i5 - (l.bottom - rect.bottom) : i5;
            } else {
                i = i5;
                thumbOffset = i3;
            }
            this.VK.setBounds(i2, thumbOffset, i4, i);
            i = i6;
        } else {
            i = thumbOffset;
        }
        if (this.VJ != null) {
            this.VJ.getPadding(rect);
            i2 = i - rect.left;
            i = (i + this.VY) + rect.right;
            this.VJ.setBounds(i2, i3, i, i5);
            Drawable background = getBackground();
            if (background != null) {
                android.support.v4.b.a.a.a(background, i2, i3, i, i5);
            }
        }
        super.draw(canvas);
    }

    protected void onDraw(Canvas canvas) {
        int save;
        super.onDraw(canvas);
        Rect rect = this.bJ;
        Drawable drawable = this.VK;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.Wa + rect.top;
        int i2 = this.Wc - rect.bottom;
        Drawable drawable2 = this.VJ;
        if (drawable != null) {
            if (!this.VO || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect l = w.l(drawable2);
                drawable2.copyBounds(rect);
                rect.left += l.left;
                rect.right -= l.right;
                save = canvas.save();
                canvas.clipRect(rect, Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        save = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.We : this.Wf;
        if (layout != null) {
            int i3;
            int[] drawableState = getDrawableState();
            if (this.Wd != null) {
                this.dG.setColor(this.Wd.getColorForState(drawableState, 0));
            }
            this.dG.drawableState = drawableState;
            if (drawable2 != null) {
                rect = drawable2.getBounds();
                i3 = rect.right + rect.left;
            } else {
                i3 = getWidth();
            }
            canvas.translate((float) ((i3 / 2) - (layout.getWidth() / 2)), (float) (((i + i2) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public int getCompoundPaddingLeft() {
        if (!at.bv(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.VW;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft;
        }
        return compoundPaddingLeft + this.VN;
    }

    public int getCompoundPaddingRight() {
        if (at.bv(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.VW;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingRight;
        }
        return compoundPaddingRight + this.VN;
    }

    private int getThumbOffset() {
        float f;
        if (at.bv(this)) {
            f = 1.0f - this.VV;
        } else {
            f = this.VV;
        }
        return (int) ((f * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        if (this.VK == null) {
            return 0;
        }
        Rect l;
        Rect rect = this.bJ;
        this.VK.getPadding(rect);
        if (this.VJ != null) {
            l = w.l(this.VJ);
        } else {
            l = w.Or;
        }
        return ((((this.VW - this.VY) - rect.left) - rect.right) - l.left) - l.right;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, bh);
        }
        return onCreateDrawableState;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.VJ != null) {
            this.VJ.setState(drawableState);
        }
        if (this.VK != null) {
            this.VK.setState(drawableState);
        }
        invalidate();
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.VJ != null) {
            android.support.v4.b.a.a.a(this.VJ, f, f2);
        }
        if (this.VK != null) {
            android.support.v4.b.a.a.a(this.VK, f, f2);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.VJ || drawable == this.VK;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.VJ != null) {
                this.VJ.jumpToCurrentState();
            }
            if (this.VK != null) {
                this.VK.jumpToCurrentState();
            }
            gZ();
            setThumbPosition(isChecked() ? 1.0f : 0.0f);
        }
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Switch");
            CharSequence charSequence = isChecked() ? this.VP : this.VQ;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                CharSequence stringBuilder = new StringBuilder();
                stringBuilder.append(text).append(' ').append(charSequence);
                accessibilityNodeInfo.setText(stringBuilder);
            }
        }
    }
}
