package com.tencent.mm.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.u;
import android.util.AttributeSet;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.view.a.f;
import com.tencent.mm.view.f.a;

public class SmileyPanelViewPager extends CustomViewPager {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager";
    private int gLc = 0;
    private int gLd = 0;
    private a uSK;
    private a uTo;
    private boolean uTp = j.fC(getContext());

    public SmileyPanelViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (bi.getInt(VERSION.SDK, 0) >= 9) {
            setOverScrollMode(2);
        }
    }

    public void setSmileyPanelViewPagerLayoutListener(a aVar) {
        this.uTo = aVar;
    }

    public void setPanelStg(a aVar) {
        this.uSK = aVar;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "alvinluo w: %d, h: %d, oldw: %d, oldh: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        boolean fC = j.fC(getContext());
        if (this.uSK != null && (((i > 0 && i3 != i) || (i2 > 0 && i4 != i2)) && ((i2 > 0 && i2 != this.gLc) || (i > 0 && i != this.gLd)))) {
            if (this.uSK.gKZ <= 0) {
                this.uSK.GW(i2);
            }
            this.uSK.gLa = i;
            this.uSK.uuh = 0;
            if (!(this.uTo == null || (this.uSK.uWB && !this.uSK.uWC && this.uTp == fC))) {
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "need deal cache size.");
                this.uSK.uWC = false;
                this.uTo.GQ(i2);
            }
        }
        this.uTp = fC;
        if (i2 > 0) {
            this.gLc = i2;
        }
        if (i > 0) {
            this.gLd = i;
        }
    }

    public void setAdapter(u uVar) {
        super.setAdapter(uVar);
    }

    public void setAdapter(f fVar) {
        if (fVar != null) {
            fVar.cCe();
            fVar.uTT = false;
        }
        super.setAdapter(fVar);
    }
}
