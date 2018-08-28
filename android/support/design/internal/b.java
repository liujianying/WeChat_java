package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.l.a;
import android.support.v7.view.menu.p;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.Iterator;

public final class b implements l {
    public ColorStateList bm;
    public NavigationMenuView bn;
    public LinearLayout bo;
    private a bp;
    f bq;
    public b br;
    int bt;
    boolean bu;
    public ColorStateList bv;
    public Drawable bw;
    public int bx;
    int by;
    public int mId;
    public LayoutInflater mLayoutInflater;
    final OnClickListener mOnClickListener = new 1(this);

    private interface d {
    }

    private static class g extends j {
        public g(LayoutInflater layoutInflater, ViewGroup viewGroup, OnClickListener onClickListener) {
            super(layoutInflater.inflate(android.support.design.a.f.design_navigation_item, viewGroup, false));
            this.SU.setOnClickListener(onClickListener);
        }
    }

    private static class e implements d {
        final int bE;
        final int bF;

        public e(int i, int i2) {
            this.bE = i;
            this.bF = i2;
        }
    }

    public final void a(Context context, f fVar) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.bq = fVar;
        this.by = context.getResources().getDimensionPixelOffset(android.support.design.a.d.design_navigation_separator_vertical_padding);
    }

    public final void n(boolean z) {
        if (this.br != null) {
            b bVar = this.br;
            bVar.O();
            bVar.RR.notifyChanged();
        }
    }

    public final boolean a(p pVar) {
        return false;
    }

    public final void a(f fVar, boolean z) {
        if (this.bp != null) {
            this.bp.a(fVar, z);
        }
    }

    public final boolean N() {
        return false;
    }

    public final boolean b(h hVar) {
        return false;
    }

    public final boolean c(h hVar) {
        return false;
    }

    public final int getId() {
        return this.mId;
    }

    public final Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        if (this.bn != null) {
            SparseArray sparseArray = new SparseArray();
            this.bn.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.br != null) {
            bundle.putBundle("android:menu:adapter", this.br.P());
        }
        return bundle;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.bn.restoreHierarchyState(sparseParcelableArray);
        }
        Bundle bundle2 = bundle.getBundle("android:menu:adapter");
        if (bundle2 != null) {
            d dVar;
            b bVar = this.br;
            int i = bundle2.getInt("android:menu:checked", 0);
            if (i != 0) {
                bVar.bD = true;
                Iterator it = bVar.bA.iterator();
                while (it.hasNext()) {
                    dVar = (d) it.next();
                    if (dVar instanceof f) {
                        h hVar = ((f) dVar).bG;
                        if (hVar != null && hVar.getItemId() == i) {
                            bVar.d(hVar);
                            break;
                        }
                    }
                }
                bVar.bD = false;
                bVar.O();
            }
            SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
            Iterator it2 = bVar.bA.iterator();
            while (it2.hasNext()) {
                dVar = (d) it2.next();
                if (dVar instanceof f) {
                    h hVar2 = ((f) dVar).bG;
                    View actionView = hVar2 != null ? hVar2.getActionView() : null;
                    if (actionView != null) {
                        actionView.restoreHierarchyState((SparseArray) sparseParcelableArray2.get(hVar2.getItemId()));
                    }
                }
            }
        }
    }

    public final void setItemIconTintList(ColorStateList colorStateList) {
        this.bm = colorStateList;
        n(false);
    }

    public final void setItemTextColor(ColorStateList colorStateList) {
        this.bv = colorStateList;
        n(false);
    }

    public final void setItemTextAppearance(int i) {
        this.bt = i;
        this.bu = true;
        n(false);
    }

    public final void setItemBackground(Drawable drawable) {
        this.bw = drawable;
        n(false);
    }

    public final void o(boolean z) {
        if (this.br != null) {
            this.br.bD = z;
        }
    }
}
