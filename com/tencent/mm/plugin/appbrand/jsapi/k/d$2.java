package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class d$2 implements Runnable {
    final /* synthetic */ String dEt;
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ p fIY;
    final /* synthetic */ d fXR;
    final /* synthetic */ boolean fXS;
    final /* synthetic */ int fXT;
    final /* synthetic */ boolean fXU;
    final /* synthetic */ String fXV;
    final /* synthetic */ String fXW;

    d$2(d dVar, boolean z, p pVar, l lVar, int i, int i2, boolean z2, String str, String str2, String str3) {
        this.fXR = dVar;
        this.fXS = z;
        this.fIY = pVar;
        this.fCl = lVar;
        this.fXT = i;
        this.doP = i2;
        this.fXU = z2;
        this.fXV = str;
        this.fXW = str2;
        this.dEt = str3;
    }

    public final void run() {
        if (this.fXR.fXP != null) {
            d.bK(this.fXR.fXP);
            this.fXR.fXP = null;
            if (this.fXR.eVk != null) {
                this.fXR.eVk.SO();
            }
        }
        if (this.fXS) {
            this.fXR.fXP = LayoutInflater.from(this.fIY.mContext).inflate(h.app_brand_show_no_icon_toast, null);
        } else {
            this.fXR.fXP = LayoutInflater.from(this.fIY.mContext).inflate(h.app_brand_show_toast, null);
        }
        FrameLayout aha = this.fIY.aha();
        if (aha == null) {
            x.e("MicroMsg.JsApiShowToast", "the page may be destroy");
            return;
        }
        d.a(this.fXR, aha);
        u.Hx().v(this.fCl.hashCode() + "toast_name", true).p("toast_view", this.fXR.fXP);
        if (this.fXU) {
            this.fXR.fXP.setLayoutParams(new LayoutParams(-1, -1));
            ((LinearLayout) this.fXR.fXP.findViewById(g.show_toast_view)).setBackgroundColor(0);
            this.fXR.fXP.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
        }
        TextView textView = (TextView) this.fXR.fXP.findViewById(g.title);
        int fromDPToPix = a.fromDPToPix(textView.getContext(), 18);
        if (bi.oW(this.dEt)) {
            textView.setVisibility(4);
        } else {
            textView.setLineSpacing(0.0f, 1.0f);
            textView.setSpannableFactory(new 3(this, fromDPToPix));
            textView.setText(this.dEt, BufferType.SPANNABLE);
            textView.setVisibility(0);
            if (!this.fXS) {
                this.fXR.fXP.findViewById(g.show_toast_view_container).setPadding(0, a.fromDPToPix(textView.getContext(), 27), 0, 0);
            }
        }
        if (!this.fXS) {
            ImageView imageView = (ImageView) this.fXR.fXP.findViewById(g.iv_icon);
            ProgressBar progressBar = (ProgressBar) this.fXR.fXP.findViewById(g.progress);
            if (this.fXV.equals("loading")) {
                imageView.setVisibility(8);
                progressBar.setVisibility(0);
            } else {
                Drawable c;
                imageView.setVisibility(0);
                progressBar.setVisibility(8);
                if (bi.oW(this.fXW)) {
                    c = com.tencent.mm.svg.a.a.c(imageView.getResources(), i.app_brand_show_toast_success);
                } else {
                    Bitmap j = o.j(this.fCl.fdO, this.fXW);
                    c = (j == null || j.isRecycled()) ? null : new BitmapDrawable(imageView.getResources(), j);
                }
                if (c != null) {
                    imageView.setImageDrawable(c);
                    imageView.setScaleType(ScaleType.FIT_CENTER);
                }
            }
        }
        aha.addView(this.fXR.fXP);
        com.tencent.mm.plugin.appbrand.widget.input.l bV = com.tencent.mm.plugin.appbrand.widget.input.l.bV(this.fIY.aha());
        if (bV != null) {
            com.tencent.mm.plugin.appbrand.widget.input.l.a aVar = this.fXR.fXQ;
            if (!(aVar == null || bV.gHm.contains(aVar))) {
                bV.gHm.add(aVar);
            }
        }
        this.fXR.eVk = new al(new al.a() {
            public final boolean vD() {
                d.bK(d$2.this.fXR.fXP);
                d$2.this.fXR.fXP = null;
                u.Hx().ib(d$2.this.fCl.hashCode() + "toast_name");
                x.d("MicroMsg.JsApiShowToast", "on timer expired!");
                com.tencent.mm.plugin.appbrand.widget.input.l bV = com.tencent.mm.plugin.appbrand.widget.input.l.bV(d$2.this.fIY.aha());
                if (bV != null) {
                    com.tencent.mm.plugin.appbrand.widget.input.l.a aVar = d$2.this.fXR.fXQ;
                    if (aVar != null && bV.gHm.contains(aVar)) {
                        bV.gHm.remove(aVar);
                    }
                }
                return true;
            }
        }, false);
        long j2 = (long) this.fXT;
        this.fXR.eVk.J(j2, j2);
        this.fCl.E(this.doP, this.fXR.f("ok", null));
    }
}
