package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.ui.statusbar.b;

public final class e extends b implements l {
    private final g fdO;
    private final Bitmap gvu;

    public e(Context context, g gVar, Bitmap bitmap) {
        super(context);
        this.gvu = bitmap;
        this.fdO = gVar;
        setupFullscreen(this.fdO.aaq());
        dl(true);
        setBackground(new BitmapDrawable(getResources(), bitmap));
        View inflate = LayoutInflater.from(context).inflate(h.app_brand_show_toast, this, false);
        addView(inflate, new LayoutParams(-2, -2, 17));
        ((TextView) inflate.findViewById(s.g.title)).setText(j.app_brand_jsapi_update_app_updating);
        inflate.findViewById(s.g.iv_icon).setVisibility(8);
    }

    private void setupFullscreen(boolean z) {
        Activity cJ = j.cJ(getContext());
        if (cJ != null) {
            Window window = cJ.getWindow();
            if (window != null) {
                j.c(window, z);
            }
        }
    }

    public final void bL(String str, String str2) {
    }

    public final void anm() {
        post(new 1(this));
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gvu.recycle();
    }

    public final void ann() {
    }

    public final void a(d dVar) {
    }

    public final View getView() {
        return this;
    }

    public final void setProgress(int i) {
    }
}
