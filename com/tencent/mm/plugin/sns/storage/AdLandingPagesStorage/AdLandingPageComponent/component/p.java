package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;

public final class p extends i {
    MMWebView dEn;
    FrameLayout nED;

    public p(Context context, v vVar, ViewGroup viewGroup) {
        super(context, vVar, viewGroup);
    }

    protected final void bzQ() {
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        this.dEn.setVerticalScrollBarEnabled(false);
        this.dEn.setHorizontalScrollBarEnabled(false);
        this.dEn.getSettings().setJavaScriptEnabled(true);
        this.dEn.loadUrl(((v) this.nDt).kck);
        this.dEn.setLayoutParams(new LayoutParams(-1, -1));
        this.dEn.setVisibility(0);
        this.nED.setPadding(this.nED.getPaddingLeft(), (int) ((v) this.nDt).nAY, this.nED.getPaddingRight(), (int) ((v) this.nDt).nAZ);
        this.nED.setLayoutParams(new LinearLayout.LayoutParams(width, height));
    }

    public final View bzM() {
        this.nED = (FrameLayout) this.contentView;
        this.dEn = a.cS(this.context);
        this.nED.addView(this.dEn);
        return this.nED;
    }

    protected final int getLayout() {
        return Integer.MAX_VALUE;
    }

    protected final View bzR() {
        return new FrameLayout(this.context);
    }
}
