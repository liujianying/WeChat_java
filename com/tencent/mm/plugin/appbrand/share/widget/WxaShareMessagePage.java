package com.tencent.mm.plugin.appbrand.share.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.modelappbrand.b.b.h;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public class WxaShareMessagePage extends LinearLayout implements h {
    ImageView gav;
    TextView gsY;
    ImageView gsZ;
    IPCDynamicPageView gta;
    ThreeDotsLoadingView gtb;

    public WxaShareMessagePage(Context context) {
        super(context);
        init(context);
    }

    public WxaShareMessagePage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public WxaShareMessagePage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, s.h.wxa_share_message_page, this);
        this.gav = (ImageView) inflate.findViewById(g.cover_iv);
        this.gsZ = (ImageView) inflate.findViewById(g.error_icon_iv);
        this.gta = (IPCDynamicPageView) inflate.findViewById(g.widget_pv);
        this.gsY = (TextView) inflate.findViewById(g.title_tv);
        this.gtb = (ThreeDotsLoadingView) inflate.findViewById(g.loading_view);
        ((ViewGroup) inflate.findViewById(g.container)).addView(((a) com.tencent.mm.kernel.g.l(a.class)).c(context, (ViewGroup) inflate));
        setGravity(17);
    }

    public final void Kc() {
    }

    public final void n(Bitmap bitmap) {
        this.gtb.setVisibility(4);
        this.gtb.cAH();
        if (bitmap == null || bitmap.isRecycled()) {
            this.gav.setImageBitmap(null);
            this.gsZ.setVisibility(0);
            return;
        }
        this.gav.setImageBitmap(bitmap);
        this.gsZ.setVisibility(4);
    }

    public final void Kd() {
        this.gtb.setVisibility(4);
        this.gtb.cAH();
        this.gav.setImageBitmap(null);
        this.gsZ.setVisibility(0);
    }

    public final String Ke() {
        return k.bq(this);
    }

    public void setImageUrl(String str) {
        this.gtb.setVisibility(0);
        this.gtb.cAG();
        this.gsZ.setVisibility(4);
        this.gav.setVisibility(0);
        b.Ka().a(this, str, null, ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.l(com.tencent.mm.modelappbrand.g.class)).bc(112, 90));
    }

    public void setImageData(Bitmap bitmap) {
        this.gav.setVisibility(0);
        this.gtb.setVisibility(4);
        this.gsZ.setVisibility(4);
        if (bitmap == null || bitmap.isRecycled()) {
            this.gav.setImageBitmap(null);
            return;
        }
        this.gav.setImageBitmap(((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.l(com.tencent.mm.modelappbrand.g.class)).JO().o(bitmap));
    }

    public void setTitle(String str) {
        this.gsY.setText(str);
    }

    public ImageView getCoverImageView() {
        return this.gav;
    }

    public ImageView getErrorImageView() {
        return this.gsZ;
    }

    public IPCDynamicPageView getWidgetPageView() {
        return this.gta;
    }

    public ThreeDotsLoadingView getLoadingView() {
        return this.gtb;
    }

    public int getWidgetWidth() {
        return f.lP(224);
    }

    public int getWidgetHeight() {
        return f.lP(180);
    }
}
