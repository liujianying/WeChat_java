package com.tencent.mm.plugin.wallet_core.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.i.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.y;

public class WalletAwardShakeAnimView extends RelativeLayout {
    long hmb;
    c lAY;
    private View pzE;
    private TextView pzF;
    private boolean pzG = false;
    private boolean pzH = false;
    private String pzI;
    private int pzJ = 0;
    private String pzK;
    private int pzL = 0;
    private ValueAnimator pzM;
    private a pzN;
    Runnable pzO = new 1(this);

    static /* synthetic */ void a(WalletAwardShakeAnimView walletAwardShakeAnimView) {
        x.i("MicroMsg.WalletAwardShakeAnimView", "delayNotifyClick, isInvokeCallback: %s", new Object[]{Boolean.valueOf(walletAwardShakeAnimView.pzH)});
        if (!walletAwardShakeAnimView.pzH) {
            if (bi.oW(walletAwardShakeAnimView.pzK)) {
                walletAwardShakeAnimView.pzF.setText(walletAwardShakeAnimView.getContext().getString(i.wallet_shake_award_delay_notify));
            } else {
                walletAwardShakeAnimView.pzF.setText(walletAwardShakeAnimView.pzK);
            }
            if (walletAwardShakeAnimView.pzL != 0) {
                walletAwardShakeAnimView.pzF.setTextColor(walletAwardShakeAnimView.pzL);
            }
        }
    }

    static /* synthetic */ void g(WalletAwardShakeAnimView walletAwardShakeAnimView) {
        x.i("MicroMsg.WalletAwardShakeAnimView", "onStartShakeOrClick");
        as.I(walletAwardShakeAnimView.getContext(), i.shake_sound_male);
        walletAwardShakeAnimView.bQJ();
        if (walletAwardShakeAnimView.pzN != null) {
            walletAwardShakeAnimView.pzN.jE(true);
        }
    }

    public WalletAwardShakeAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public WalletAwardShakeAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        y.gq(getContext()).inflate(g.wallet_award_shake_anim_view, this);
        findViewById(f.background).setBackground(getResources().getDrawable(h.wallet_new_shakea_anim_view_bg));
        this.pzE = findViewById(f.shake_icon);
        this.pzF = (TextView) findViewById(f.shake_hint_wording);
    }

    public void setShakeOrClickCallback(a aVar) {
        this.pzN = aVar;
    }

    public void setShakeHintWording(String str) {
        this.pzI = str;
        this.pzF.setText(str);
    }

    public void setShakeHintWordingColor(int i) {
        this.pzJ = i;
        this.pzF.setTextColor(i);
    }

    public void setAfterHintWording(String str) {
        this.pzK = str;
    }

    public void setAfterHintWordingColor(int i) {
        this.pzL = i;
    }

    private void bQJ() {
        if (this.pzM != null) {
            this.pzM.cancel();
        }
        this.pzM = ValueAnimator.ofFloat(new float[]{-30.0f, 30.0f});
        this.pzM.setInterpolator(new LinearInterpolator());
        this.pzM.setRepeatMode(2);
        this.pzM.setRepeatCount(-1);
        this.pzM.setDuration(300);
        this.pzM.addUpdateListener(new 4(this));
        this.pzM.start();
    }

    public final void destroy() {
        if (this.lAY != null) {
            this.lAY.aDc();
            this.lAY = null;
        }
        this.pzH = false;
        this.pzG = false;
        if (this.pzM != null) {
            this.pzM.cancel();
        }
        this.pzE.setRotation(0.0f);
        if (bi.oW(this.pzI)) {
            this.pzF.setText(getResources().getText(i.wallet_shake_award_hint_wording));
        } else {
            this.pzF.setText(this.pzI);
        }
        if (this.pzJ != 0) {
            this.pzF.setTextColor(this.pzJ);
        } else {
            this.pzF.setTextColor(Color.parseColor("#E24C4C"));
        }
        ah.M(this.pzO);
    }
}
