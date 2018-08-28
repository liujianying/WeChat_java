package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.ak.a$f;
import com.tencent.mm.plugin.ak.a.b;
import com.tencent.mm.plugin.ak.a.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;

public final class c extends i implements a {
    public int ccR = 0;
    public String dXA;
    private d gbl = new d();
    private f hEl = null;
    public int iYO = 0;
    public String imagePath;
    public int ncW = 0;
    private TextView ndP = null;
    private boolean ndQ = false;

    static /* synthetic */ void a(c cVar) {
        if (cVar.hEl.start()) {
            cVar.gbl.a(cVar);
        } else {
            cVar.bvV();
        }
    }

    public c(Context context) {
        super(context, com.tencent.mm.plugin.ak.a.i.videodialog);
    }

    protected final void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        x.d("MicroMsg.VideoPopupHelper", currentTimeMillis + " initView beg");
        super.onCreate(bundle);
        getWindow().setFlags(16777216, 16777216);
        setContentView(a$f.shortvideoplayer);
        if (com.tencent.mm.booter.a.xt() != null) {
            com.tencent.mm.booter.a.xt().xv();
        }
        x.d("MicroMsg.VideoPopupHelper", g.Ab() + " initView: fullpath:" + this.dXA + ", imagepath:" + this.imagePath);
        this.ndP = (TextView) findViewById(e.tips_tv);
        findViewById(e.show_ad_sight).setVisibility(8);
        ViewGroup viewGroup = (ViewGroup) findViewById(e.video_container);
        viewGroup.setBackgroundResource(b.black);
        x.i("MicroMsg.VideoPopupHelper", "getVideoView, is normal video");
        if (com.tencent.mm.compatible.util.d.fR(14)) {
            this.hEl = new VideoTextureView(getContext());
        } else {
            this.hEl = new VideoSurfaceView(getContext());
        }
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        viewGroup.addView((View) this.hEl, layoutParams);
        this.hEl.setVideoCallback(new 1(this));
        findViewById(e.video_container).setOnClickListener(new 2(this));
        ((View) this.hEl).setOnClickListener(new 3(this));
        if (this.dXA != null) {
            this.hEl.stop();
            this.hEl.setVideoPath(this.dXA);
        }
        x.d("MicroMsg.VideoPopupHelper", (System.currentTimeMillis() - currentTimeMillis) + " initView end");
        rz rzVar = new rz();
        rzVar.ccO.type = 1;
        com.tencent.mm.sdk.b.a.sFg.m(rzVar);
    }

    private void bvV() {
        x.v("check", "onclick");
        if (this.hEl.isPlaying()) {
            this.hEl.pause();
            this.gbl.bv(false);
        }
        new ag().post(new 4(this));
    }

    public final void dismiss() {
        x.d("MicroMsg.VideoPopupHelper", "on dismiss");
        if (com.tencent.mm.booter.a.xt() != null) {
            com.tencent.mm.booter.a.xt().xu();
        }
        if (this.hEl != null) {
            this.hEl.setVideoCallback(null);
            this.hEl.stop();
            this.hEl.onDetach();
            findViewById(e.video_container).setOnClickListener(null);
        }
        if (!this.ndQ && isShowing()) {
            rz rzVar = new rz();
            rzVar.ccO.type = 0;
            rzVar.ccO.ccP = this.ncW;
            rzVar.ccO.ccQ = this.iYO;
            rzVar.ccO.ccR = this.ccR;
            com.tencent.mm.sdk.b.a.sFg.m(rzVar);
        }
        super.dismiss();
        this.gbl.bv(true);
    }
}
