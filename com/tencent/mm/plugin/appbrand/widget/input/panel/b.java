package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.sdk.platformtools.ad;

public final class b extends a {
    private static final int gKH = a.fromDPToPix(ad.getContext(), 48);
    private static final int gKI = a.fromDPToPix(ad.getContext(), 43);

    public final View mk(int i) {
        View view = null;
        Context context = this.gKE;
        c cVar = this.gKF;
        d dVar = new d();
        dVar.mIndex = i;
        dVar.gLb = this;
        dVar.mContext = context;
        dVar.gKF = cVar;
        if (!(dVar.mContext == null || dVar.gLb == null)) {
            view = View.inflate(dVar.mContext, h.appbrand_smiley_panel_page, null);
            if (view instanceof AppBrandSmileyGrid) {
                ((AppBrandSmileyGrid) view).setPanelManager(dVar.gKF);
                AppBrandSmileyGrid appBrandSmileyGrid = (AppBrandSmileyGrid) view;
                int i2 = dVar.mIndex;
                int aqc = dVar.gLb.aqc();
                int aqd = dVar.gLb.aqd();
                int aqe = dVar.gLb.aqe();
                int rowCount = dVar.gLb.getRowCount();
                int rowSpacing = dVar.gLb.getRowSpacing();
                appBrandSmileyGrid.setLayoutParams(new LayoutParams(-1, -1));
                appBrandSmileyGrid.setBackgroundResource(0);
                appBrandSmileyGrid.setStretchMode(2);
                appBrandSmileyGrid.setOnItemClickListener(appBrandSmileyGrid.UD);
                appBrandSmileyGrid.gKM = i2;
                appBrandSmileyGrid.gKK = aqc;
                appBrandSmileyGrid.gKL = aqd;
                appBrandSmileyGrid.gKN = rowSpacing;
                appBrandSmileyGrid.gKO = aqe;
                appBrandSmileyGrid.gKP = rowCount;
                appBrandSmileyGrid.setNumColumns(aqe);
                i2 = appBrandSmileyGrid.getRowSpacing();
                rowSpacing = a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                aqc = a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                if (i2 == 0) {
                    i2 = a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                }
                appBrandSmileyGrid.setPadding(rowSpacing, i2, aqc, 0);
                appBrandSmileyGrid.gKJ = new AppBrandSmileyGrid.a(appBrandSmileyGrid, (byte) 0);
                appBrandSmileyGrid.setAdapter(appBrandSmileyGrid.gKJ);
                appBrandSmileyGrid.gKJ.notifyDataSetChanged();
            }
        }
        return view;
    }

    public final int aqc() {
        return this.gKF.apU().apW();
    }

    public final int aqd() {
        return aqe() * getRowCount();
    }

    public final int getPageCount() {
        if (aqd() <= 0) {
            return 0;
        }
        return (int) Math.ceil(((double) aqc()) / ((double) aqd()));
    }

    public final int aqe() {
        if (this.gKF.gKV) {
            return 7;
        }
        c cVar = this.gKF;
        if (cVar.gLa <= 1) {
            cVar.gLa = c.anG()[0];
        }
        return cVar.gLa / gKI;
    }

    public final int getRowSpacing() {
        return (this.gKF.gKZ - (gKH * getRowCount())) / (getRowCount() + 1);
    }

    public final int getRowCount() {
        int i = 3;
        int i2 = this.gKF.gKZ / gKH;
        if (i2 <= 3) {
            i = i2;
        }
        return i <= 0 ? 1 : i;
    }
}
