package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public Button eOQ;
    public TextView hSo;
    public long jfd = b.aKR();
    public boolean jff = false;
    public View jfg;
    public a jfh;

    public final void show() {
        if (!this.jff) {
            if (this.jfg != null) {
                if (this.jfg instanceof ViewStub) {
                    this.jfg = ((ViewStub) this.jfg).inflate();
                }
                this.hSo = (TextView) this.jfg.findViewById(e.fav_clean_delete_info_tv);
                if (!w.chL()) {
                    this.hSo.setTextSize(1, 14.0f);
                }
                this.eOQ = (Button) this.jfg.findViewById(e.fav_clean_del_btn);
                aMR();
                this.eOQ.setOnClickListener(new 1(this));
                this.jff = true;
            } else {
                return;
            }
        }
        if (this.jfg.getVisibility() != 0) {
            this.jfg.setVisibility(0);
            this.jfg.startAnimation(AnimationUtils.loadAnimation(this.jfg.getContext(), com.tencent.mm.plugin.fav.ui.m.a.fast_faded_in));
        }
    }

    public final void hide() {
        if (this.jff && this.jfg.getVisibility() != 8) {
            this.jfg.setVisibility(8);
            this.jfg.startAnimation(AnimationUtils.loadAnimation(this.jfg.getContext(), com.tencent.mm.plugin.fav.ui.m.a.fast_faded_out));
        }
    }

    public final void aMR() {
        this.hSo.setText(this.hSo.getContext().getString(i.fav_clean_capacity_info, new Object[]{b.dp(this.jfd)}));
        this.eOQ.setEnabled(false);
    }
}
