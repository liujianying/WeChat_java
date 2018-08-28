package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.design.a$c;
import android.support.design.a.g;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.design.widget.u.c;
import android.support.v4.content.a;
import android.support.v4.view.z;
import android.support.v4.widget.Space;
import android.support.v7.widget.w;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextInputLayout extends LinearLayout {
    private u cc;
    private final f eb;
    private boolean iA;
    private TextView iB;
    private int iC;
    private int iD;
    private int iE;
    private boolean iF;
    private ColorStateList iG;
    private ColorStateList iH;
    private boolean iI;
    private boolean iJ;
    private EditText im;
    private boolean io;
    private CharSequence iq;
    private Paint ir;
    private LinearLayout is;
    private int it;
    private boolean iu;
    private TextView iw;
    private int ix;
    private boolean iy;
    private CharSequence iz;

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.eb = new f(this);
        t.G(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.eb.b(a.bM);
        f fVar = this.eb;
        fVar.dH = new AccelerateInterpolator();
        fVar.Z();
        this.eb.y(8388659);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.TextInputLayout, i, h.Widget_Design_TextInputLayout);
        this.io = obtainStyledAttributes.getBoolean(i.TextInputLayout_hintEnabled, true);
        setHint(obtainStyledAttributes.getText(i.TextInputLayout_android_hint));
        this.iI = obtainStyledAttributes.getBoolean(i.TextInputLayout_hintAnimationEnabled, true);
        if (obtainStyledAttributes.hasValue(i.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(i.TextInputLayout_android_textColorHint);
            this.iH = colorStateList;
            this.iG = colorStateList;
        }
        if (obtainStyledAttributes.getResourceId(i.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(obtainStyledAttributes.getResourceId(i.TextInputLayout_hintTextAppearance, 0));
        }
        this.ix = obtainStyledAttributes.getResourceId(i.TextInputLayout_errorTextAppearance, 0);
        boolean z = obtainStyledAttributes.getBoolean(i.TextInputLayout_errorEnabled, false);
        boolean z2 = obtainStyledAttributes.getBoolean(i.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(obtainStyledAttributes.getInt(i.TextInputLayout_counterMaxLength, -1));
        this.iD = obtainStyledAttributes.getResourceId(i.TextInputLayout_counterTextAppearance, 0);
        this.iE = obtainStyledAttributes.getResourceId(i.TextInputLayout_counterOverflowTextAppearance, 0);
        obtainStyledAttributes.recycle();
        setErrorEnabled(z);
        setCounterEnabled(z2);
        if (z.F(this) == 0) {
            z.i(this, 1);
        }
        z.a(this, new a(this, (byte) 0));
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof EditText) {
            setEditText((EditText) view);
            super.addView(view, 0, b(layoutParams));
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void setTypeface(Typeface typeface) {
        this.eb.a(typeface);
    }

    public Typeface getTypeface() {
        return this.eb.X();
    }

    private void setEditText(EditText editText) {
        if (this.im != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        this.im = editText;
        this.eb.a(this.im.getTypeface());
        f fVar = this.eb;
        float textSize = this.im.getTextSize();
        if (fVar.dj != textSize) {
            fVar.dj = textSize;
            fVar.Z();
        }
        int gravity = this.im.getGravity();
        this.eb.y((8388615 & gravity) | 48);
        this.eb.x(gravity);
        this.im.addTextChangedListener(new 1(this));
        if (this.iG == null) {
            this.iG = this.im.getHintTextColors();
        }
        if (this.io && TextUtils.isEmpty(this.iq)) {
            setHint(this.im.getHint());
            this.im.setHint(null);
        }
        if (this.iB != null) {
            P(this.im.getText().length());
        }
        if (this.is != null) {
            aM();
        }
        s(false);
    }

    private LinearLayout.LayoutParams b(LayoutParams layoutParams) {
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams);
        if (this.io) {
            if (this.ir == null) {
                this.ir = new Paint();
            }
            this.ir.setTypeface(this.eb.X());
            this.ir.setTextSize(this.eb.dk);
            layoutParams2.topMargin = (int) (-this.ir.ascent());
        } else {
            layoutParams2.topMargin = 0;
        }
        return layoutParams2;
    }

    private void s(boolean z) {
        Object obj;
        Object obj2 = 1;
        Object obj3 = (this.im == null || TextUtils.isEmpty(this.im.getText())) ? null : 1;
        for (int i : getDrawableState()) {
            if (i == 16842908) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (TextUtils.isEmpty(getError())) {
            obj2 = null;
        }
        if (this.iG != null) {
            this.eb.w(this.iG.getDefaultColor());
        }
        if (this.iF && this.iB != null) {
            this.eb.v(this.iB.getCurrentTextColor());
        } else if (obj != null && this.iH != null) {
            this.eb.v(this.iH.getDefaultColor());
        } else if (this.iG != null) {
            this.eb.v(this.iG.getDefaultColor());
        }
        if (obj3 == null && obj == null && obj2 == null) {
            if (this.cc != null && this.cc.iO.isRunning()) {
                this.cc.iO.cancel();
            }
            if (z && this.iI) {
                q(0.0f);
                return;
            } else {
                this.eb.h(0.0f);
                return;
            }
        }
        if (this.cc != null && this.cc.iO.isRunning()) {
            this.cc.iO.cancel();
        }
        if (z && this.iI) {
            q(1.0f);
        } else {
            this.eb.h(1.0f);
        }
    }

    public EditText getEditText() {
        return this.im;
    }

    public void setHint(CharSequence charSequence) {
        if (this.io) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        this.iq = charSequence;
        this.eb.setText(charSequence);
    }

    public CharSequence getHint() {
        return this.io ? this.iq : null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.io) {
            this.io = z;
            CharSequence hint = this.im.getHint();
            if (!this.io) {
                if (!TextUtils.isEmpty(this.iq) && TextUtils.isEmpty(hint)) {
                    this.im.setHint(this.iq);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.iq)) {
                    setHint(hint);
                }
                this.im.setHint(null);
            }
            if (this.im != null) {
                this.im.setLayoutParams(b(this.im.getLayoutParams()));
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.eb.z(i);
        this.iH = ColorStateList.valueOf(this.eb.dm);
        if (this.im != null) {
            s(false);
            this.im.setLayoutParams(b(this.im.getLayoutParams()));
            this.im.requestLayout();
        }
    }

    private void a(TextView textView, int i) {
        if (this.is == null) {
            this.is = new LinearLayout(getContext());
            this.is.setOrientation(0);
            addView(this.is, -1, -2);
            this.is.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.im != null) {
                aM();
            }
        }
        this.is.setVisibility(0);
        this.is.addView(textView, i);
        this.it++;
    }

    private void aM() {
        z.c(this.is, z.O(this.im), 0, z.P(this.im), this.im.getPaddingBottom());
    }

    private void a(TextView textView) {
        if (this.is != null) {
            this.is.removeView(textView);
            int i = this.it - 1;
            this.it = i;
            if (i == 0) {
                this.is.setVisibility(8);
            }
        }
    }

    public void setErrorEnabled(boolean z) {
        if (this.iu != z) {
            if (this.iw != null) {
                z.U(this.iw).cancel();
            }
            if (z) {
                this.iw = new TextView(getContext());
                try {
                    this.iw.setTextAppearance(getContext(), this.ix);
                } catch (Exception e) {
                    this.iw.setTextAppearance(getContext(), h.TextAppearance_AppCompat_Caption);
                    this.iw.setTextColor(a.g(getContext(), a$c.design_textinput_error_color_light));
                }
                this.iw.setVisibility(4);
                z.N(this.iw);
                a(this.iw, 0);
            } else {
                this.iy = false;
                aN();
                a(this.iw);
                this.iw = null;
            }
            this.iu = z;
        }
    }

    public void setError(CharSequence charSequence) {
        if (!TextUtils.equals(this.iz, charSequence)) {
            this.iz = charSequence;
            if (!this.iu) {
                if (!TextUtils.isEmpty(charSequence)) {
                    setErrorEnabled(true);
                } else {
                    return;
                }
            }
            boolean ai = z.ai(this);
            this.iy = !TextUtils.isEmpty(charSequence);
            if (this.iy) {
                this.iw.setText(charSequence);
                this.iw.setVisibility(0);
                if (ai) {
                    if (z.G(this.iw) == 1.0f) {
                        z.d(this.iw, 0.0f);
                    }
                    z.U(this.iw).t(1.0f).h(200).c(a.bO).a(new 2(this)).start();
                }
            } else if (this.iw.getVisibility() == 0) {
                if (ai) {
                    z.U(this.iw).t(0.0f).h(200).c(a.bN).a(new 3(this, charSequence)).start();
                } else {
                    this.iw.setVisibility(4);
                }
            }
            aN();
            s(true);
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.iA != z) {
            if (z) {
                this.iB = new TextView(getContext());
                this.iB.setMaxLines(1);
                try {
                    this.iB.setTextAppearance(getContext(), this.iD);
                } catch (Exception e) {
                    this.iB.setTextAppearance(getContext(), h.TextAppearance_AppCompat_Caption);
                    this.iB.setTextColor(a.g(getContext(), a$c.design_textinput_error_color_light));
                }
                a(this.iB, -1);
                if (this.im == null) {
                    P(0);
                } else {
                    P(this.im.getText().length());
                }
            } else {
                a(this.iB);
                this.iB = null;
            }
            this.iA = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.iC != i) {
            if (i > 0) {
                this.iC = i;
            } else {
                this.iC = -1;
            }
            if (this.iA) {
                P(this.im == null ? 0 : this.im.getText().length());
            }
        }
    }

    public int getCounterMaxLength() {
        return this.iC;
    }

    private void P(int i) {
        boolean z = this.iF;
        if (this.iC == -1) {
            this.iB.setText(String.valueOf(i));
            this.iF = false;
        } else {
            this.iF = i > this.iC;
            if (z != this.iF) {
                this.iB.setTextAppearance(getContext(), this.iF ? this.iE : this.iD);
            }
            this.iB.setText(getContext().getString(g.character_counter_pattern, new Object[]{Integer.valueOf(i), Integer.valueOf(this.iC)}));
        }
        if (this.im != null && z != this.iF) {
            s(false);
            aN();
        }
    }

    private void aN() {
        Drawable background;
        int i = VERSION.SDK_INT;
        if (i == 21 && i == 22) {
            background = this.im.getBackground();
            if (!(background == null || this.iJ)) {
                Drawable newDrawable = background.getConstantState().newDrawable();
                if (background instanceof DrawableContainer) {
                    DrawableContainer drawableContainer = (DrawableContainer) background;
                    ConstantState constantState = newDrawable.getConstantState();
                    this.iJ = VERSION.SDK_INT >= 9 ? i.a(drawableContainer, constantState) : i.b(drawableContainer, constantState);
                }
                if (!this.iJ) {
                    this.im.setBackgroundDrawable(newDrawable);
                    this.iJ = true;
                }
            }
        }
        background = this.im.getBackground();
        if (background != null) {
            if (w.n(background)) {
                background = background.mutate();
            }
            if (this.iy && this.iw != null) {
                background.setColorFilter(android.support.v7.widget.h.a(this.iw.getCurrentTextColor(), Mode.SRC_IN));
            } else if (!this.iF || this.iB == null) {
                background.clearColorFilter();
                this.im.refreshDrawableState();
            } else {
                background.setColorFilter(android.support.v7.widget.h.a(this.iB.getCurrentTextColor(), Mode.SRC_IN));
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.iy) {
            savedState.iM = getError();
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setError(savedState.iM);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public CharSequence getError() {
        return this.iu ? this.iz : null;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.iI = z;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.io) {
            this.eb.draw(canvas);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.io && this.im != null) {
            int left = this.im.getLeft() + this.im.getCompoundPaddingLeft();
            int right = this.im.getRight() - this.im.getCompoundPaddingRight();
            this.eb.b(left, this.im.getTop() + this.im.getCompoundPaddingTop(), right, this.im.getBottom() - this.im.getCompoundPaddingBottom());
            this.eb.c(left, getPaddingTop(), right, (i4 - i2) - getPaddingBottom());
            this.eb.Z();
        }
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        s(z.ai(this));
    }

    private void q(float f) {
        if (this.eb.dc != f) {
            if (this.cc == null) {
                this.cc = aa.aP();
                this.cc.setInterpolator(a.bL);
                this.cc.setDuration(200);
                this.cc.a(new c() {
                    public final void a(u uVar) {
                        TextInputLayout.this.eb.h(uVar.iO.aR());
                    }
                });
            }
            this.cc.p(this.eb.dc, f);
            this.cc.iO.start();
        }
    }
}
