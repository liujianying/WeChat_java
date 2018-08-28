package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;

public class OfflineAlertView extends LinearLayout {
    private View contentView = null;
    public int lKQ = 0;
    RelativeLayout lKR = null;
    boolean lKS = true;
    private a lKT = null;

    static /* synthetic */ void a(OfflineAlertView offlineAlertView, View view, Runnable runnable, Runnable runnable2, int i) {
        offlineAlertView.lKQ = i;
        offlineAlertView.setVisibility(0);
        ((TextView) offlineAlertView.contentView.findViewById(f.i_know_btn)).setOnClickListener(new 5(offlineAlertView, runnable));
        offlineAlertView.contentView.findViewById(f.take_for_more).setOnClickListener(new 6(offlineAlertView, runnable2));
        x.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight()));
        LayoutParams layoutParams = (LayoutParams) offlineAlertView.contentView.getLayoutParams();
        if (view.getHeight() > 0) {
            layoutParams.height = view.getHeight();
            offlineAlertView.contentView.setLayoutParams(layoutParams);
            offlineAlertView.contentView.invalidate();
        }
        offlineAlertView.lKS = false;
        if (offlineAlertView.lKT != null) {
            offlineAlertView.lKT.onShow();
        }
    }

    public OfflineAlertView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public OfflineAlertView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.contentView = LayoutInflater.from(getContext()).inflate(g.wallet_offline_alert, this);
        this.lKR = (RelativeLayout) this.contentView.findViewById(f.offline_alert_root);
    }

    public void setDialogState(a aVar) {
        this.lKT = aVar;
    }

    final void a(View view, OnClickListener onClickListener, int i) {
        this.lKQ = i;
        setVisibility(0);
        this.lKR.removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(g.wallet_offline_unopened_layout, null);
        if (i == 6) {
            ((TextView) inflate.findViewById(f.alert_title)).setText(i.offline_need_open_again_text);
        }
        this.lKR.addView(inflate);
        ((Button) this.contentView.findViewById(f.i_know_btn)).setOnClickListener(onClickListener);
        this.lKS = false;
        view.post(new 7(this, view));
    }

    public final boolean isShowing() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final boolean ul(int i) {
        if (!isShowing() || i == this.lKQ) {
            return true;
        }
        if (i == 2 && (this.lKQ == 3 || this.lKQ == 4 || this.lKQ == 2 || this.lKQ == 5)) {
            return true;
        }
        if ((i == 5 && this.lKQ == 4) || i == 6) {
            return true;
        }
        return false;
    }

    public final void dismiss() {
        if (this.lKR != null) {
            this.lKR.removeAllViews();
        }
        setVisibility(8);
        if (this.lKT != null) {
            this.lKT.onClose();
        }
        this.lKS = true;
    }
}
