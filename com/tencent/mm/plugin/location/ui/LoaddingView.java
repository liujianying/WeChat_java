package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.map.a.a;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.sdk.platformtools.bi;

public class LoaddingView extends LinearLayout implements c {
    private TextView kEs;
    private ProgressBar kEt;
    private Animation kEu;
    private View kEv;
    private boolean kEw = false;
    private String kEx = "";

    @TargetApi(11)
    public LoaddingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public LoaddingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.kEu = AnimationUtils.loadAnimation(context, a.translate_map);
        View inflate = LayoutInflater.from(context).inflate(f.location_view, this, true);
        this.kEt = (ProgressBar) inflate.findViewById(e.location_load_progress);
        this.kEs = (TextView) inflate.findViewById(e.location_tips);
        this.kEv = inflate.findViewById(e.location_here);
        this.kEs.setText("");
        this.kEs.setVisibility(0);
        this.kEt.setVisibility(0);
    }

    public void setProgressAlwaysGone(boolean z) {
        this.kEw = z;
        this.kEt.setVisibility(8);
        this.kEs.setVisibility(8);
    }

    public void setText(String str) {
        if (this.kEs != null && this.kEt != null && !this.kEw) {
            if (bi.oW(str)) {
                this.kEs.setText("");
                this.kEs.setVisibility(0);
                this.kEt.setVisibility(0);
                return;
            }
            this.kEs.setText(str);
            this.kEt.setVisibility(8);
            this.kEs.setVisibility(0);
        }
    }

    public void setPreText(String str) {
        if (!bi.oW(str)) {
            this.kEx = str + "\n";
        }
    }

    public String getPreText() {
        return this.kEx;
    }
}
