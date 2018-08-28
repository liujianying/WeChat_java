package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.ui.base.MMPageControlView;

public class AdLandingControlView extends MMPageControlView {
    public AdLandingControlView(Context context) {
        super(context);
    }

    public AdLandingControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void wR(int i) {
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
                        this.bOA = (ImageView) View.inflate(this.context, this.twg, null).findViewById(f.mmpage_control_img);
                        this.map.put(Integer.valueOf(i3), this.bOA);
                    }
                    this.bOA.setSelected(true);
                } else {
                    if (this.map.size() > i3) {
                        this.bOA = (ImageView) this.map.get(Integer.valueOf(i3));
                    }
                    if (this.bOA == null) {
                        this.bOA = (ImageView) View.inflate(this.context, this.twg, null).findViewById(f.mmpage_control_img);
                        this.map.put(Integer.valueOf(i3), this.bOA);
                    }
                    this.bOA.setSelected(false);
                }
                addView(this.bOA);
            }
        }
    }
}
