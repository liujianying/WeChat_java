package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.api.b;
import com.tencent.mm.api.e;
import com.tencent.mm.api.k;
import com.tencent.mm.api.m;
import com.tencent.mm.api.m.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.p;

public final class a {
    MMActivity bGc;
    String bKg;
    p eXe;
    VideoTransPara lfT;
    VideoPlayerTextureView lkZ;
    VideoSeekBarEditorView lla;
    RecyclerThumbSeekBar loS;
    boolean loT = false;
    int loU = -1;
    int loV = -1;
    int loW = -1;
    al loX;
    ViewGroup loY;
    m loZ;
    b lpa;
    com.tencent.mm.plugin.mmsight.api.a lpb;
    public a lpc;
    boolean lpd = false;
    public boolean lpe = false;
    private boolean lpf = false;
    private boolean lpg = false;
    public String lph = null;
    public int lpi = -1;
    com.tencent.mm.plugin.mmsight.a.a.b lpj;
    public int scene;
    String videoPath;

    static /* synthetic */ void a(a aVar) {
        int width = aVar.lkZ.getWidth();
        int height = aVar.lkZ.getHeight();
        int fromDPToPix = ((aVar.lla.getHeight() <= 0 ? com.tencent.mm.bp.a.fromDPToPix(aVar.bGc, 100) : aVar.lla.getHeight()) + com.tencent.mm.bp.a.fromDPToPix(aVar.bGc, 20)) + com.tencent.mm.bp.a.fromDPToPix(aVar.bGc, 12);
        if (ak.gt(aVar.bGc)) {
            fromDPToPix += ak.gs(aVar.bGc);
        }
        int i = height - fromDPToPix;
        if (aVar.lkZ.getBottom() + fromDPToPix < d.dO(aVar.bGc).y) {
            i = (int) (((float) (width - (com.tencent.mm.bp.a.fromDPToPix(aVar.bGc, 32) * 2))) / (((float) width) / ((float) height)));
        }
        float f = ((float) ((int) ((((float) width) / ((float) height)) * ((float) i)))) / ((float) width);
        float f2 = ((float) i) / ((float) height);
        aVar.lkZ.animate().scaleX(f).scaleY(f2).translationY(-(((float) fromDPToPix) / 2.0f)).setDuration(300).setListener(new 11(aVar));
        aVar.lpa.animate().scaleX(f).scaleY(f2).translationY(-(((float) fromDPToPix) / 2.0f)).setDuration(300);
        aVar.lpa.setAutoShowFooterAndBar(false);
        aVar.lpa.setFooterVisible(false);
        aVar.lpa.setActionBarVisible(false);
        if (!aVar.loT) {
            aVar.loS.setOnPreparedListener(new 7(aVar));
            aVar.loS.setThumbBarSeekListener(new 8(aVar));
            aVar.loS.Hu(aVar.videoPath);
            aVar.lkZ.setLoop(true);
            aVar.lkZ.setVideoCallback(new 9(aVar));
            aVar.loT = true;
        }
        aVar.lla.setVisibility(0);
        aVar.lla.bringToFront();
        aVar.lla.setCancelButtonClickListener(new 12(aVar));
        aVar.lla.setFinishButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                a.this.bfk();
                if (a.this.loV >= 0 && a.this.loW > 0) {
                    a.this.lpd = true;
                }
            }
        });
        aVar.lpg = true;
    }

    public final void a(MMActivity mMActivity, int i, String str, VideoSeekBarEditorView videoSeekBarEditorView, VideoPlayerTextureView videoPlayerTextureView, ViewGroup viewGroup, VideoTransPara videoTransPara, boolean z) {
        this.lfT = videoTransPara;
        if (this.lfT == null) {
            x.e("MicroMsg.MMSightVideoEditor", "video trans para is null!!!");
            this.lfT = new VideoTransPara();
            this.lfT.duration = 10000;
        } else if (this.lfT.duration <= 0) {
            this.lfT.duration = 10000;
        }
        this.scene = i;
        this.videoPath = str;
        this.lla = videoSeekBarEditorView;
        this.lkZ = videoPlayerTextureView;
        this.loY = viewGroup;
        this.bGc = mMActivity;
        this.lpf = z;
        this.lpj = new com.tencent.mm.plugin.mmsight.a.a.b(i);
        this.loS = videoSeekBarEditorView.lqM;
        this.loS.setVideoTransPara(this.lfT);
        this.loZ = m.bwV.tY();
        m mVar = this.loZ;
        com.tencent.mm.api.m.a.a aVar = new com.tencent.mm.api.m.a.a();
        aVar.bwX = false;
        aVar.bwZ = true;
        aVar.bwW = c.bxb;
        aVar.bxa = new Rect(this.lkZ.getLeft(), this.lkZ.getTop(), this.lkZ.getRight(), this.lkZ.getBottom());
        mVar.a(aVar.uk());
        this.lpa = this.loZ.aQ(this.loY.getContext());
        this.lpa.setActionBarCallback(new e() {
            public final void onFinish() {
                x.i("MicroMsg.MMSightVideoEditor", "photoEditor onFinish");
                a.this.loZ.a(new 1(this));
            }

            public final void ua() {
                x.i("MicroMsg.MMSightVideoEditor", "photoEditor onExit");
                a.this.release();
                if (a.this.lpc != null) {
                    ah.A(new 2(this));
                }
            }
        });
        LayoutParams marginLayoutParams = new MarginLayoutParams(-1, -1);
        if (ak.gt(this.bGc)) {
            marginLayoutParams.height = d.bdF().y - ak.gs(this.bGc);
        }
        this.loY.addView(this.lpa, marginLayoutParams);
        this.lpa.setSelectedFeatureListener(new 5(this));
        if (this.lpf) {
            this.lpa.post(new 6(this));
        }
    }

    final void bfk() {
        this.lkZ.animate().scaleX(1.0f).scaleY(1.0f).translationY(0.0f).setDuration(300);
        this.lla.animate().alpha(0.0f).setDuration(100).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                a.this.lla.setVisibility(8);
                a.this.lla.setAlpha(1.0f);
            }
        });
        this.lpa.setFooterVisible(true);
        this.lpa.setActionBarVisible(true);
        this.lpa.setAutoShowFooterAndBar(true);
        this.lpa.animate().scaleX(1.0f).scaleY(1.0f).translationY(0.0f).setDuration(300);
        this.lpg = false;
    }

    public final void release() {
        try {
            if (this.loX != null) {
                this.loX.SO();
                this.loX = null;
            }
            if (this.loS != null) {
                this.loS.release();
            }
            if (this.loZ != null) {
                this.loZ.onDestroy();
            }
            if (this.loY != null) {
                this.loY.removeView(this.lpa);
            }
            if (this.lla != null) {
                this.lla.bft();
            }
            this.loT = false;
            j.lin.Fm();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightVideoEditor", e, "release error: %s", new Object[]{e.getMessage()});
        }
    }

    public final void l(boolean z, String str) {
        int i = 2;
        try {
            this.lpj.dJO = z;
            if (this.loZ == null) {
                x.e("MicroMsg.MMSightVideoEditor", "[report] null == photoEditor");
                return;
            }
            k tX = this.loZ.tX();
            this.lpj.lkB = tX.uc();
            this.lpj.lkC = tX.ub();
            this.lpj.lkE = tX.ue();
            this.lpj.dal = tX.uf();
            this.lpj.lkF = tX.ui();
            this.lpj.textColor = tX.getTextColor();
            com.tencent.mm.plugin.mmsight.a.a.b bVar = this.lpj;
            h hVar = h.mEJ;
            Object[] objArr = new Object[14];
            objArr[0] = Integer.valueOf(bVar.scene);
            if (!bVar.dJO) {
                i = 1;
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(bVar.lkB);
            objArr[3] = Integer.valueOf(bVar.lkC);
            objArr[4] = Integer.valueOf(bVar.lkE);
            objArr[5] = Boolean.valueOf(bVar.lkD);
            objArr[6] = Integer.valueOf(bVar.dal);
            objArr[7] = Integer.valueOf(bVar.lkz);
            objArr[8] = Integer.valueOf(bVar.lkA);
            objArr[9] = Integer.valueOf(bVar.lkF);
            objArr[10] = Integer.valueOf(0);
            objArr[11] = Integer.valueOf(bVar.textColor);
            objArr[12] = str;
            objArr[13] = Long.valueOf(bi.VE());
            hVar.h(14362, objArr);
            x.i("MicroMsg.VideoEditReporter", "[report-VideoEditDetailData] %s", new Object[]{bVar.toString()});
        } catch (Exception e) {
        }
    }

    public final boolean agV() {
        if (this.lpg) {
            bfk();
            return true;
        } else if (this.loZ != null) {
            return this.loZ.tW();
        } else {
            return false;
        }
    }
}
