package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import java.util.HashMap;
import java.util.Map;

public class MMPageControlView extends LinearLayout {
    public ImageView bOA;
    public Context context;
    public int count;
    public Map<Integer, ImageView> map = new HashMap();
    public int twg = h.mmpage_control_image;

    public final void eS(int i, int i2) {
        this.count = i;
        wR(i2);
    }

    public void setPage(int i) {
        wR(i);
    }

    public void setIndicatorLayoutRes(int i) {
        this.twg = i;
    }

    public MMPageControlView(Context context) {
        super(context);
        this.context = context;
    }

    public MMPageControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public void wR(int i) {
        removeAllViews();
        if (i < this.count) {
            int i2 = this.count;
            for (int i3 = 0; i3 < i2; i3++) {
                this.bOA = null;
                if (i == i3) {
                    if (this.map.size() > i3) {
                        this.bOA = (ImageView) this.map.get(Integer.valueOf(i3));
                    }
                    if (this.bOA == null) {
                        this.bOA = (ImageView) View.inflate(this.context, this.twg, null).findViewById(g.mmpage_control_img);
                        this.map.put(Integer.valueOf(i3), this.bOA);
                    }
                    this.bOA.setSelected(true);
                } else {
                    if (this.map.size() > i3) {
                        this.bOA = (ImageView) this.map.get(Integer.valueOf(i3));
                    }
                    if (this.bOA == null) {
                        this.bOA = (ImageView) View.inflate(this.context, this.twg, null).findViewById(g.mmpage_control_img);
                        this.map.put(Integer.valueOf(i3), this.bOA);
                    }
                    this.bOA.setSelected(false);
                }
                if (i3 == 0) {
                    this.bOA.setPadding(0, 0, 0, 0);
                }
                addView(this.bOA);
            }
        }
    }
}
