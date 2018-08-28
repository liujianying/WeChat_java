package com.tencent.mm.ui.base;

import android.os.Build.VERSION;
import android.support.v4.view.u;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public abstract class w extends u {
    private final v tAX;

    public abstract View getView(int i, View view, ViewGroup viewGroup);

    public w() {
        this(new v());
    }

    private w(v vVar) {
        this.tAX = vVar;
        SparseArray[] sparseArrayArr = new SparseArray[1];
        for (int i = 0; i <= 0; i++) {
            sparseArrayArr[0] = new SparseArray();
        }
        vVar.tAV = 1;
        vVar.tAW = sparseArrayArr[0];
        vVar.tAU = sparseArrayArr;
    }

    public void notifyDataSetChanged() {
        int length;
        v vVar = this.tAX;
        View[] viewArr = vVar.tAS;
        int[] iArr = vVar.tAT;
        Object obj = vVar.tAV > 1 ? 1 : null;
        SparseArray sparseArray = vVar.tAW;
        for (length = viewArr.length - 1; length >= 0; length--) {
            View view = viewArr[length];
            if (view != null) {
                int i = iArr[length];
                viewArr[length] = null;
                iArr[length] = -1;
                if ((i >= 0 ? 1 : null) != null) {
                    if (obj != null) {
                        sparseArray = vVar.tAU[i];
                    }
                    sparseArray.put(length, view);
                    if (VERSION.SDK_INT >= 14) {
                        view.setAccessibilityDelegate(null);
                    }
                }
            }
        }
        length = vVar.tAS.length;
        int i2 = vVar.tAV;
        SparseArray[] sparseArrayArr = vVar.tAU;
        for (int i3 = 0; i3 < i2; i3++) {
            SparseArray sparseArray2 = sparseArrayArr[i3];
            int size = sparseArray2.size();
            int i4 = size - length;
            size--;
            int i5 = 0;
            while (i5 < i4) {
                int i6 = size - 1;
                sparseArray2.remove(sparseArray2.keyAt(size));
                i5++;
                size = i6;
            }
        }
        super.notifyDataSetChanged();
    }

    public final Object b(ViewGroup viewGroup, int i) {
        View view = null;
        int itemViewType = getItemViewType(i);
        if (itemViewType != -1) {
            v vVar = this.tAX;
            if (vVar.tAV == 1) {
                view = v.a(vVar.tAW, i);
            } else if (itemViewType >= 0 && itemViewType < vVar.tAU.length) {
                view = v.a(vVar.tAU[itemViewType], i);
            }
        }
        view = getView(i, view, viewGroup);
        viewGroup.addView(view);
        return view;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        int itemViewType = getItemViewType(i);
        if (itemViewType != -1) {
            v vVar = this.tAX;
            if (vVar.tAV == 1) {
                vVar.tAW.put(i, view);
            } else {
                vVar.tAU[itemViewType].put(i, view);
            }
            if (VERSION.SDK_INT >= 14) {
                view.setAccessibilityDelegate(null);
            }
        }
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public int getItemViewType(int i) {
        return 0;
    }
}
