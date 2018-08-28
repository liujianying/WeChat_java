package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class AppBrandSmileyGrid extends GridView {
    OnItemClickListener UD = new 1(this);
    private c gKF;
    a gKJ;
    int gKK;
    int gKL = 0;
    int gKM;
    int gKN = 0;
    int gKO = 0;
    int gKP = 0;

    public AppBrandSmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    int getRowSpacing() {
        return this.gKN;
    }

    public void setPanelManager(c cVar) {
        this.gKF = cVar;
    }
}
