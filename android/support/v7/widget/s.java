package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

final class s {
    final b NA;
    final a NB = new a();
    final List<View> NC = new ArrayList();

    s(b bVar) {
        this.NA = bVar;
    }

    final void aM(View view) {
        this.NC.add(view);
        this.NA.aQ(view);
    }

    final boolean aN(View view) {
        if (!this.NC.remove(view)) {
            return false;
        }
        this.NA.aR(view);
        return true;
    }

    final void a(View view, int i, boolean z) {
        int childCount;
        if (i < 0) {
            childCount = this.NA.getChildCount();
        } else {
            childCount = aV(i);
        }
        this.NB.n(childCount, z);
        if (z) {
            aM(view);
        }
        this.NA.addView(view, childCount);
    }

    final int aV(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.NA.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int aY = i - (i2 - this.NB.aY(i2));
            if (aY == 0) {
                while (this.NB.get(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += aY;
        }
        return -1;
    }

    final View getChildAt(int i) {
        return this.NA.getChildAt(aV(i));
    }

    final void a(View view, int i, LayoutParams layoutParams, boolean z) {
        int childCount;
        if (i < 0) {
            childCount = this.NA.getChildCount();
        } else {
            childCount = aV(i);
        }
        this.NB.n(childCount, z);
        if (z) {
            aM(view);
        }
        this.NA.attachViewToParent(view, childCount, layoutParams);
    }

    final int getChildCount() {
        return this.NA.getChildCount() - this.NC.size();
    }

    final int eO() {
        return this.NA.getChildCount();
    }

    final View aW(int i) {
        return this.NA.getChildAt(i);
    }

    final void detachViewFromParent(int i) {
        int aV = aV(i);
        this.NB.aX(aV);
        this.NA.detachViewFromParent(aV);
    }

    final int indexOfChild(View view) {
        int indexOfChild = this.NA.indexOfChild(view);
        if (indexOfChild == -1 || this.NB.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.NB.aY(indexOfChild);
    }

    final boolean aO(View view) {
        return this.NC.contains(view);
    }

    public final String toString() {
        return this.NB.toString() + ", hidden list:" + this.NC.size();
    }
}
