package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.a.b;
import android.support.design.a.d;
import android.support.design.a.e;
import android.support.design.a.f;
import android.support.v4.widget.r;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.m.a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends ForegroundLinearLayout implements a {
    private static final int[] bh = new int[]{16842912};
    private final int bi;
    final CheckedTextView bj;
    FrameLayout bk;
    private h bl;
    private ColorStateList bm;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        LayoutInflater.from(context).inflate(f.design_navigation_menu_item, this, true);
        this.bi = context.getResources().getDimensionPixelSize(d.design_navigation_icon_size);
        this.bj = (CheckedTextView) findViewById(e.design_menu_item_text);
        this.bj.setDuplicateParentStateEnabled(true);
    }

    public final void a(h hVar) {
        this.bl = hVar;
        setVisibility(hVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            Drawable stateListDrawable;
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(b.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(bh, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            setBackgroundDrawable(stateListDrawable);
        }
        setCheckable(hVar.isCheckable());
        setChecked(hVar.isChecked());
        setEnabled(hVar.isEnabled());
        setTitle(hVar.getTitle());
        setIcon(hVar.getIcon());
        setActionView(hVar.getActionView());
    }

    private void setActionView(View view) {
        if (this.bk == null) {
            this.bk = (FrameLayout) ((ViewStub) findViewById(e.design_menu_item_action_area_stub)).inflate();
        }
        this.bk.removeAllViews();
        if (view != null) {
            this.bk.addView(view);
        }
    }

    public h getItemData() {
        return this.bl;
    }

    public void setTitle(CharSequence charSequence) {
        this.bj.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.bj.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = android.support.v4.b.a.a.g(drawable).mutate();
            drawable.setBounds(0, 0, this.bi, this.bi);
            android.support.v4.b.a.a.a(drawable, this.bm);
        }
        r.a(this.bj, drawable);
    }

    public final boolean M() {
        return false;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.bl != null && this.bl.isCheckable() && this.bl.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, bh);
        }
        return onCreateDrawableState;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.bm = colorStateList;
        if (this.bl != null) {
            setIcon(this.bl.getIcon());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.bj.setTextColor(colorStateList);
    }
}
