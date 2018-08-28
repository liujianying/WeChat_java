package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.support.v7.view.b;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends a {
    private TextView Dm;
    private View JG;
    private LinearLayout JH;
    private TextView JI;
    private int JJ;
    private int JK;
    public boolean JL;
    private int JM;
    private View hZ;
    private CharSequence sn;
    private CharSequence so;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ap a = ap.a(context, attributeSet, k.ActionMode, i);
        setBackgroundDrawable(a.getDrawable(k.ActionMode_background));
        this.JJ = a.getResourceId(k.ActionMode_titleTextStyle, 0);
        this.JK = a.getResourceId(k.ActionMode_subtitleTextStyle, 0);
        this.Jq = a.getLayoutDimension(k.ActionMode_height, 0);
        this.JM = a.getResourceId(k.ActionMode_closeItemLayout, h.abc_action_mode_close_item_material);
        a.Ww.recycle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Jp != null) {
            this.Jp.hideOverflowMenu();
            this.Jp.el();
        }
    }

    public void setContentHeight(int i) {
        this.Jq = i;
    }

    public void setCustomView(View view) {
        if (this.hZ != null) {
            removeView(this.hZ);
        }
        this.hZ = view;
        if (!(view == null || this.JH == null)) {
            removeView(this.JH);
            this.JH = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.sn = charSequence;
        ea();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.so = charSequence;
        ea();
    }

    public CharSequence getTitle() {
        return this.sn;
    }

    public CharSequence getSubtitle() {
        return this.so;
    }

    private void ea() {
        int i;
        int i2 = 8;
        Object obj = 1;
        if (this.JH == null) {
            LayoutInflater.from(getContext()).inflate(h.abc_action_bar_title_item, this);
            this.JH = (LinearLayout) getChildAt(getChildCount() - 1);
            this.Dm = (TextView) this.JH.findViewById(f.action_bar_title);
            this.JI = (TextView) this.JH.findViewById(f.action_bar_subtitle);
            if (this.JJ != 0) {
                this.Dm.setTextAppearance(getContext(), this.JJ);
            }
            if (this.JK != 0) {
                this.JI.setTextAppearance(getContext(), this.JK);
            }
        }
        this.Dm.setText(this.sn);
        this.JI.setText(this.so);
        Object obj2 = !TextUtils.isEmpty(this.sn) ? 1 : null;
        if (TextUtils.isEmpty(this.so)) {
            obj = null;
        }
        TextView textView = this.JI;
        if (obj != null) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout = this.JH;
        if (!(obj2 == null && obj == null)) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        if (this.JH.getParent() == null) {
            addView(this.JH);
        }
    }

    public final void c(final b bVar) {
        if (this.JG == null) {
            this.JG = LayoutInflater.from(getContext()).inflate(this.JM, this, false);
            addView(this.JG);
        } else if (this.JG.getParent() == null) {
            addView(this.JG);
        }
        this.JG.findViewById(f.action_mode_close_button).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                bVar.finish();
            }
        });
        android.support.v7.view.menu.f fVar = (android.support.v7.view.menu.f) bVar.getMenu();
        if (this.Jp != null) {
            this.Jp.ek();
        }
        this.Jp = new ActionMenuPresenter(getContext());
        this.Jp.ej();
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        fVar.a(this.Jp, this.Jn);
        this.Jo = (ActionMenuView) this.Jp.e((ViewGroup) this);
        this.Jo.setBackgroundDrawable(null);
        addView(this.Jo, layoutParams);
    }

    public final void eb() {
        if (this.JG == null) {
            ec();
        }
    }

    public final void ec() {
        removeAllViews();
        this.hZ = null;
        this.Jo = null;
    }

    public final boolean showOverflowMenu() {
        if (this.Jp != null) {
            return this.Jp.showOverflowMenu();
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        } else {
            int f;
            int size = MeasureSpec.getSize(i);
            int size2 = this.Jq > 0 ? this.Jq : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i4 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
            if (this.JG != null) {
                f = a.f(this.JG, paddingLeft, makeMeasureSpec);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.JG.getLayoutParams();
                paddingLeft = f - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.Jo != null && this.Jo.getParent() == this) {
                paddingLeft = a.f(this.Jo, paddingLeft, makeMeasureSpec);
            }
            if (this.JH != null && this.hZ == null) {
                if (this.JL) {
                    this.JH.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    f = this.JH.getMeasuredWidth();
                    makeMeasureSpec = f <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= f;
                    }
                    this.JH.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = a.f(this.JH, paddingLeft, makeMeasureSpec);
                }
            }
            if (this.hZ != null) {
                int min;
                LayoutParams layoutParams = this.hZ.getLayoutParams();
                if (layoutParams.width != -2) {
                    makeMeasureSpec = 1073741824;
                } else {
                    makeMeasureSpec = Integer.MIN_VALUE;
                }
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    min = Math.min(layoutParams.height, i4);
                } else {
                    min = i4;
                }
                this.hZ.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(min, i3));
            }
            if (this.Jq <= 0) {
                i3 = getChildCount();
                makeMeasureSpec = 0;
                size2 = 0;
                while (makeMeasureSpec < i3) {
                    paddingLeft = getChildAt(makeMeasureSpec).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    makeMeasureSpec++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean bv = at.bv(this);
        int paddingRight = bv ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (!(this.JG == null || this.JG.getVisibility() == 8)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.JG.getLayoutParams();
            int i6 = bv ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            i5 = bv ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            paddingRight = a.c(paddingRight, i6, bv);
            paddingRight = a.c(paddingRight + a.a(this.JG, paddingRight, paddingTop, paddingTop2, bv), i5, bv);
        }
        if (!(this.JH == null || this.hZ != null || this.JH.getVisibility() == 8)) {
            paddingRight += a.a(this.JH, paddingRight, paddingTop, paddingTop2, bv);
        }
        if (this.hZ != null) {
            a.a(this.hZ, paddingRight, paddingTop, paddingTop2, bv);
        }
        i5 = bv ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.Jo != null) {
            a.a(this.Jo, i5, paddingTop, paddingTop2, !bv);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.sn);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.JL) {
            requestLayout();
        }
        this.JL = z;
    }
}
