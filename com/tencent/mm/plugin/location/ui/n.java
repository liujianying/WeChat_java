package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.map.a;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.r.d;

public final class n implements c {
    public boolean bNu = false;
    public boolean isVisible = true;
    private String kCs;
    public double kCw = 1000000.0d;
    public double kCx = 1000000.0d;
    public boolean kEX = true;
    private View kEY;
    private TextView kEs;
    private ProgressBar kEt;
    private String kEx = "";
    public String kFa;
    public final String kHE = "info_window_tag";
    public ImageView kHF;
    public FrameLayout kHG;
    private TextView kHH;
    public boolean kHI;
    private Context mContext;
    public ViewManager mViewManager;

    public final void b(LocationInfo locationInfo) {
        this.kCw = locationInfo.kCw;
        this.kCx = locationInfo.kCx;
    }

    public n(d dVar, Context context, boolean z) {
        this.mContext = context;
        this.kHI = z;
        this.kHF = new ImageView(context);
        this.kHF.setBackgroundResource(a.d.mm_trans);
        this.kHF.setScaleType(ScaleType.CENTER_CROP);
        this.kHG = (FrameLayout) View.inflate(context, f.map_overlay_layout, null);
        if (z) {
            this.kHF.setImageResource(a.d.location_arrows);
        } else {
            this.kHF.setImageResource(a.d.location_artboard1);
        }
        this.kEY = this.kHG;
        this.mViewManager = (ViewManager) dVar.getViewManager();
    }

    public final void setText(String str) {
        this.kCs = str;
        CharSequence charSequence = this.kCs;
        this.kEs = (TextView) this.kHG.findViewById(e.location_tips);
        this.kEt = (ProgressBar) this.kHG.findViewById(e.location_load_progress);
        this.kHH = (TextView) this.kHG.findViewById(e.location_poiname);
        if (charSequence == null || charSequence.equals("")) {
            this.kEt.setVisibility(0);
        } else {
            this.kEt.setVisibility(8);
            this.kEs.setVisibility(0);
            this.kEs.setText(charSequence);
        }
        if (this.kFa == null || this.kFa.equals("")) {
            this.kHH.setText("");
            this.kHH.setVisibility(8);
        } else {
            this.kHH.setVisibility(0);
            this.kHH.setText(this.kFa);
        }
        if (this.kEX) {
            this.mViewManager.updateViewLayout(this.kHF, this.kCw, this.kCx, false);
            if (this.kHI) {
                this.mViewManager.showInfoWindowByView(this.kHF);
            }
        }
    }

    public final String getPreText() {
        return this.kEx;
    }
}
