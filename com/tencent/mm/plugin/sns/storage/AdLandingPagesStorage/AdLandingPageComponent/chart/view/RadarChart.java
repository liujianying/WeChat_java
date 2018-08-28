package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.text.Spannable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.Chart;
import java.util.ArrayList;

public class RadarChart extends Chart {
    private Context context;
    public ArrayList<a> nCn;
    private c nCo = new c();
    public TextView nCp;
    private RadarGrid nCq;
    private RadarDataLayer[] nCr;
    private a nCs;
    private boolean nCt = true;
    private boolean nCu = true;
    public int nCv = 3;
    public int nCw = 0;
    private int nCx = 4;
    public Spannable[] nCy;
    private float nCz = 1.0f;

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public void setData(a... aVarArr) {
        int i;
        int i2 = 0;
        removeAllViews();
        for (a size : aVarArr) {
            if (size.size() <= 0) {
                throw new Exception("Not enough elements.");
            }
        }
        for (a size2 : aVarArr) {
            i = 0;
            while (i < aVarArr.length) {
                if (size2.a(aVarArr[i])) {
                    i++;
                } else {
                    throw new Error("Layer not compatible.");
                }
            }
        }
        this.nCy = aVarArr[0].bzI();
        this.nCw = aVarArr[0].size();
        if (this.nCn == null) {
            this.nCn = new ArrayList();
        }
        for (Object add : aVarArr) {
            this.nCn.add(add);
        }
        this.nCq = new RadarGrid(this.context, this.nCw, this.nCx, this.nCz, this.nCy, this.nCo);
        addView(this.nCq);
        this.nCr = new RadarDataLayer[this.nCv];
        while (i2 < this.nCr.length && this.nCn.size() > i2) {
            this.nCr[i2] = new RadarDataLayer(this.context, this.nCz, (a) this.nCn.get(i2));
            addView(this.nCr[i2]);
            i2++;
        }
        if (this.nCs == null) {
            this.nCs = new a(this.context, this.nCo);
        }
        addView(this.nCs);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setLatitudeNum(int i) {
        this.nCx = i;
    }

    public void setGridStyle(c cVar) {
        this.nCo = cVar;
        if (this.nCq != null) {
            this.nCq.setGridStyle(cVar);
        }
    }

    public c getGridStyle() {
        if (this.nCq == null) {
            return this.nCo;
        }
        this.nCo = this.nCq.getGridStyle();
        return this.nCq.getGridStyle();
    }
}
