package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class e {
    private ImageView bRk;
    private MMActivity gKS;
    View hzL;
    b hzM;
    protected LinearLayout hzN;
    protected LinearLayout hzO;
    private TextView hzP;

    public e(MMActivity mMActivity) {
        this.gKS = mMActivity;
    }

    public final void axQ() {
        if (this.hzL == null) {
            this.hzL = View.inflate(this.gKS, com.tencent.mm.plugin.card.a.e.card_othercity_footer, null);
            this.bRk = (ImageView) this.hzL.findViewById(d.album_next_progress);
            this.hzP = (TextView) this.hzL.findViewById(d.show_other_city);
            this.hzN = (LinearLayout) this.hzL.findViewById(d.loading_more_state);
            this.hzO = (LinearLayout) this.hzL.findViewById(d.loading_end);
            this.hzN.setVisibility(8);
            this.hzO.setVisibility(8);
            Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.bRk.startAnimation(rotateAnimation);
        }
        aL();
    }

    public final void axR() {
        this.hzN.setVisibility(0);
        this.hzO.setVisibility(8);
    }

    public final void axS() {
        this.hzN.setVisibility(8);
    }

    private void axT() {
        this.hzN.setVisibility(8);
        this.hzO.setVisibility(8);
    }

    public final void axU() {
        axT();
        this.hzP.setVisibility(8);
    }

    public final void aL() {
        Integer num = (Integer) am.axn().getValue("key_share_card_show_type");
        if (num == null) {
            num = Integer.valueOf(0);
        }
        if (this.hzM != null && b.axK() && ((num.intValue() == 1 || num.intValue() == 4) && b.axH())) {
            this.hzP.setVisibility(0);
        } else {
            this.hzP.setVisibility(8);
            if (this.hzM != null) {
                x.d("MicroMsg.ShareCardFooterController", "updateView isLocalEnd %s isOtherEnd %s ", new Object[]{Boolean.valueOf(b.axK()), Boolean.valueOf(b.axL())});
                if (!b.axK() || !b.axL()) {
                    axR();
                    return;
                } else if (b.axK() && b.axL()) {
                    this.hzN.setVisibility(8);
                    this.hzO.setVisibility(8);
                    return;
                } else {
                    return;
                }
            }
        }
        axT();
    }
}
