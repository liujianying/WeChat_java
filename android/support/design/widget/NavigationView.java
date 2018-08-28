package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.a$b;
import android.support.design.a.f;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.design.internal.NavigationMenuView;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.internal.b;
import android.support.v4.view.z;
import android.support.v7.view.g;
import android.support.v7.view.menu.l;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] bh = new int[]{16842912};
    private static final int[] gc = new int[]{-16842910};
    private final android.support.design.internal.a gd;
    private final b ge;
    private a gf;
    private int gg;
    private MenuInflater gh;

    public interface a {
        boolean aw();
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        int resourceId;
        boolean z;
        int resourceId2;
        super(context, attributeSet, i);
        this.ge = new b();
        t.G(context);
        this.gd = new android.support.design.internal.a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.NavigationView, i, h.Widget_Design_NavigationView);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(i.NavigationView_android_background));
        if (obtainStyledAttributes.hasValue(i.NavigationView_elevation)) {
            z.g(this, (float) obtainStyledAttributes.getDimensionPixelSize(i.NavigationView_elevation, 0));
        }
        z.a(this, obtainStyledAttributes.getBoolean(i.NavigationView_android_fitsSystemWindows, false));
        this.gg = obtainStyledAttributes.getDimensionPixelSize(i.NavigationView_android_maxWidth, 0);
        if (obtainStyledAttributes.hasValue(i.NavigationView_itemIconTint)) {
            colorStateList = obtainStyledAttributes.getColorStateList(i.NavigationView_itemIconTint);
        } else {
            colorStateList = G(16842808);
        }
        if (obtainStyledAttributes.hasValue(i.NavigationView_itemTextAppearance)) {
            resourceId = obtainStyledAttributes.getResourceId(i.NavigationView_itemTextAppearance, 0);
            z = true;
        } else {
            resourceId = 0;
            z = false;
        }
        ColorStateList colorStateList2 = null;
        if (obtainStyledAttributes.hasValue(i.NavigationView_itemTextColor)) {
            colorStateList2 = obtainStyledAttributes.getColorStateList(i.NavigationView_itemTextColor);
        }
        if (!z && r5 == null) {
            colorStateList2 = G(16842806);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(i.NavigationView_itemBackground);
        this.gd.a(new 1(this));
        this.ge.mId = 1;
        this.ge.a(context, this.gd);
        this.ge.setItemIconTintList(colorStateList);
        if (z) {
            this.ge.setItemTextAppearance(resourceId);
        }
        this.ge.setItemTextColor(colorStateList2);
        this.ge.setItemBackground(drawable);
        this.gd.a(this.ge);
        b bVar = this.ge;
        if (bVar.bn == null) {
            bVar.bn = (NavigationMenuView) bVar.mLayoutInflater.inflate(f.design_navigation_menu, this, false);
            if (bVar.br == null) {
                bVar.br = new b.b(bVar);
            }
            bVar.bo = (LinearLayout) bVar.mLayoutInflater.inflate(f.design_navigation_item_header, bVar.bn, false);
            bVar.bn.setAdapter(bVar.br);
        }
        addView((View) bVar.bn);
        if (obtainStyledAttributes.hasValue(i.NavigationView_menu)) {
            resourceId2 = obtainStyledAttributes.getResourceId(i.NavigationView_menu, 0);
            this.ge.o(true);
            getMenuInflater().inflate(resourceId2, this.gd);
            this.ge.o(false);
            this.ge.n(false);
        }
        if (obtainStyledAttributes.hasValue(i.NavigationView_headerLayout)) {
            resourceId2 = obtainStyledAttributes.getResourceId(i.NavigationView_headerLayout, 0);
            bVar = this.ge;
            bVar.bo.addView(bVar.mLayoutInflater.inflate(resourceId2, bVar.bo, false));
            bVar.bn.setPadding(0, 0, 0, bVar.bn.getPaddingBottom());
        }
        obtainStyledAttributes.recycle();
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.gj = new Bundle();
        this.gd.dispatchSaveInstanceState(savedState.gj);
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            android.support.design.internal.a aVar = this.gd;
            SparseArray sparseParcelableArray = savedState.gj.getSparseParcelableArray("android:menu:presenters");
            if (sparseParcelableArray != null && !aVar.Iw.isEmpty()) {
                Iterator it = aVar.Iw.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    l lVar = (l) weakReference.get();
                    if (lVar == null) {
                        aVar.Iw.remove(weakReference);
                    } else {
                        int id = lVar.getId();
                        if (id > 0) {
                            Parcelable parcelable2 = (Parcelable) sparseParcelableArray.get(id);
                            if (parcelable2 != null) {
                                lVar.onRestoreInstanceState(parcelable2);
                            }
                        }
                    }
                }
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setNavigationItemSelectedListener(a aVar) {
        this.gf = aVar;
    }

    protected void onMeasure(int i, int i2) {
        switch (MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                i = MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i), this.gg), 1073741824);
                break;
            case 0:
                i = MeasureSpec.makeMeasureSpec(this.gg, 1073741824);
                break;
        }
        super.onMeasure(i, i2);
    }

    protected final void c(Rect rect) {
        b bVar = this.ge;
        int i = rect.top;
        if (bVar.bx != i) {
            bVar.bx = i;
            if (bVar.bo.getChildCount() == 0) {
                bVar.bn.setPadding(0, bVar.bx, 0, bVar.bn.getPaddingBottom());
            }
        }
    }

    public Menu getMenu() {
        return this.gd;
    }

    public int getHeaderCount() {
        return this.ge.bo.getChildCount();
    }

    public ColorStateList getItemIconTintList() {
        return this.ge.bm;
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.ge.setItemIconTintList(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.ge.bv;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.ge.setItemTextColor(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.ge.bw;
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(android.support.v4.content.a.f(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        this.ge.setItemBackground(drawable);
    }

    public void setCheckedItem(int i) {
        MenuItem findItem = this.gd.findItem(i);
        if (findItem != null) {
            this.ge.br.d((android.support.v7.view.menu.h) findItem);
        }
    }

    public void setItemTextAppearance(int i) {
        this.ge.setItemTextAppearance(i);
    }

    private MenuInflater getMenuInflater() {
        if (this.gh == null) {
            this.gh = new g(getContext());
        }
        return this.gh;
    }

    private ColorStateList G(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = getResources().getColorStateList(typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(a$b.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        return new ColorStateList(new int[][]{gc, bh, EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(gc, defaultColor), i2, defaultColor});
    }
}
