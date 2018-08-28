package com.tencent.matrix.trace.e;

import android.view.View;
import android.view.ViewGroup;

public final class b {

    public static class a {
        public int buR = 0;
        public int buS = 0;
        public String mActivityName = "";

        public final String toString() {
            return "ViewCount:" + this.buR + ",ViewDeep:" + this.buS + ",mActivityName:" + this.mActivityName;
        }
    }

    public static void a(a aVar, int i, View view) {
        if (view != null) {
            int i2 = i + 1;
            if (i2 > aVar.buS) {
                aVar.buS = i2;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                if (childCount > 0) {
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = viewGroup.getChildAt(i3);
                        if (childAt.getVisibility() != 8) {
                            aVar.buR++;
                            a(aVar, i2, childAt);
                        }
                    }
                }
            }
        }
    }
}
