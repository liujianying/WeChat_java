package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.br.e;
import com.tencent.mm.sdk.platformtools.ad;

public final class b extends a {
    private static final int gKH = a.fromDPToPix(ad.getContext(), 48);
    private static final int gKI = a.fromDPToPix(ad.getContext(), 43);

    public final View mk(int i) {
        View view = null;
        Context context = this.gKE;
        c cVar = this.qlL;
        d dVar = new d();
        dVar.mIndex = i;
        dVar.qlT = this;
        dVar.mContext = context;
        dVar.qlL = cVar;
        if (!(dVar.mContext == null || dVar.qlT == null)) {
            view = View.inflate(dVar.mContext, R.i.webview_smiley_panel_page, null);
            if (view instanceof WebViewSmileyGrid) {
                ((WebViewSmileyGrid) view).setPanelManager(dVar.qlL);
                WebViewSmileyGrid webViewSmileyGrid = (WebViewSmileyGrid) view;
                int i2 = dVar.mIndex;
                int aqc = dVar.qlT.aqc();
                int aqd = dVar.qlT.aqd();
                int aqe = dVar.qlT.aqe();
                int rowCount = dVar.qlT.getRowCount();
                int rowSpacing = dVar.qlT.getRowSpacing();
                webViewSmileyGrid.setLayoutParams(new LayoutParams(-1, -1));
                webViewSmileyGrid.setBackgroundResource(0);
                webViewSmileyGrid.setStretchMode(2);
                webViewSmileyGrid.setOnItemClickListener(webViewSmileyGrid.UD);
                webViewSmileyGrid.gKM = i2;
                webViewSmileyGrid.gKK = aqc;
                webViewSmileyGrid.gKL = aqd;
                webViewSmileyGrid.gKN = rowSpacing;
                webViewSmileyGrid.gKO = aqe;
                webViewSmileyGrid.gKP = rowCount;
                webViewSmileyGrid.setNumColumns(aqe);
                i2 = webViewSmileyGrid.getRowSpacing();
                rowSpacing = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                aqc = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                if (i2 == 0) {
                    i2 = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                }
                webViewSmileyGrid.setPadding(rowSpacing, i2, aqc, 0);
                webViewSmileyGrid.qlM = new WebViewSmileyGrid.a(webViewSmileyGrid, (byte) 0);
                webViewSmileyGrid.setAdapter(webViewSmileyGrid.qlM);
                webViewSmileyGrid.qlM.notifyDataSetChanged();
            }
        }
        return view;
    }

    public final int aqc() {
        return e.cjH().apW();
    }

    public final int aqd() {
        return aqe() * getRowCount();
    }

    public final int getPageCount() {
        if (aqd() <= 0) {
            return 0;
        }
        return (int) Math.ceil(((double) e.cjH().apW()) / ((double) aqd()));
    }

    public final int aqe() {
        if (this.qlL.gKV) {
            return 7;
        }
        c cVar = this.qlL;
        if (cVar.gLa <= 1) {
            r2 = new int[2];
            Display defaultDisplay = ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay();
            r2[0] = defaultDisplay.getWidth();
            r2[1] = defaultDisplay.getHeight();
            cVar.gLa = r2[0];
        }
        return cVar.gLa / gKI;
    }

    public final int getRowSpacing() {
        return (this.qlL.gKZ - (gKH * getRowCount())) / (getRowCount() + 1);
    }

    public final int getRowCount() {
        int i = 3;
        int i2 = this.qlL.gKZ / gKH;
        if (i2 <= 3) {
            i = i2;
        }
        return i <= 0 ? 1 : i;
    }
}
