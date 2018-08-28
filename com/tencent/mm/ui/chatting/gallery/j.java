package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.graphics.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class j {
    String bSS = "";
    long createTime;
    String fileId;
    public View jEz;
    public TextView jcm;
    public int mPosition;
    int nFC = 0;
    public b tTU;
    public b$b tWP;
    public HashMap<String, Boolean> tWQ = new HashMap();
    public RelativeLayout tWR;
    public f tWS;
    public ImageView tWT;
    public ImageView tWU;
    public MMPinProgressBtn tWV;
    public View tWW;
    public RelativeLayout tWX;
    public ImageView tWY;
    public ImageView tWZ;
    public f tXa;
    public MMPinProgressBtn tXb;
    public TextView tXc;
    public LinearLayout tXd;
    public TextView tXe;
    public TextView tXf;
    public ImageView tXg;
    public ProgressBar tXh;
    public ProgressBar tXi;
    public LinearLayout tXj;
    public TextView tXk;
    public ImageView tXl;
    public MultiTouchImageView tXm;
    public WxImageView tXn;
    int tXo = 0;
    int tXp = 0;

    @TargetApi(11)
    public j(b bVar, View view) {
        this.jEz = view;
        this.tTU = bVar;
        this.tXm = (MultiTouchImageView) view.findViewById(R.h.image);
        this.tXn = (WxImageView) view.findViewById(R.h.wx_image);
        this.tXi = (ProgressBar) view.findViewById(R.h.image_gallery_download_circle_pb);
        if (this.tXn != null) {
            this.tXn.setForceTileFlag(c.diW);
        }
        if (d.fR(11) && view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
    }

    public static void O(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public final j cxw() {
        if (this.tXd == null) {
            this.tXd = (LinearLayout) ((ViewStub) this.jEz.findViewById(R.h.image_gallery_downloading)).inflate();
            this.tXh = (ProgressBar) this.tXd.findViewById(R.h.downloading_pb);
            this.tXe = (TextView) this.tXd.findViewById(R.h.downloading_percent_tv);
            this.tXf = (TextView) this.tXd.findViewById(R.h.downloading_hd_tip_tv);
            this.tXg = (ImageView) this.tXd.findViewById(R.h.downloading_thumb_iv);
        }
        return this;
    }

    public final j cxx() {
        if (this.tXj == null) {
            this.tXj = (LinearLayout) ((ViewStub) this.jEz.findViewById(R.h.image_gallery_download_fail)).inflate();
            this.tXl = (ImageView) this.tXj.findViewById(R.h.download_fail_iv);
            this.tXk = (TextView) this.tXj.findViewById(R.h.download_fail_text);
        }
        return this;
    }

    public final j cxy() {
        if (this.tWR == null) {
            this.tWR = (RelativeLayout) ((ViewStub) this.jEz.findViewById(R.h.sight_root)).inflate();
            this.tWS = o.fb(this.jEz.getContext());
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            this.tWR.addView((View) this.tWS, layoutParams);
            ((View) this.tWS).setVisibility(8);
            this.tWW = this.tWR.findViewById(R.h.tips_tv);
            this.tWW.setVisibility(8);
            this.jcm = (TextView) this.tWR.findViewById(R.h.show_ad_sight);
            this.tWV = (MMPinProgressBtn) this.tWR.findViewById(R.h.sight_downloading_pb);
            this.tWV.setVisibility(8);
            this.tWT = (ImageView) this.tWR.findViewById(R.h.sight_image);
            this.tWU = (ImageView) this.tWR.findViewById(R.h.videoplayer_icon);
            this.tWS.setVideoCallback(new 1(this));
            this.jcm.setOnClickListener(new 2(this));
        }
        return this;
    }

    public final j cxz() {
        if (this.tWX == null) {
            if (this.tXn != null) {
                this.tXn.setVisibility(8);
            }
            if (this.tXm != null) {
                this.tXm.setVisibility(8);
            }
            this.tWX = (RelativeLayout) ((ViewStub) this.jEz.findViewById(R.h.video_root)).inflate();
            this.tWY = (ImageView) this.tWX.findViewById(R.h.video_image);
            this.tWZ = (ImageView) this.tWX.findViewById(R.h.video_wait_play_btn);
            this.tWZ.setOnClickListener(new 3(this));
            com.tencent.mm.modelcontrol.d.NP();
            if (com.tencent.mm.modelcontrol.d.NW()) {
                this.tXa = new VideoPlayerTextureView(this.jEz.getContext());
                h.mEJ.a(354, 150, 1, false);
            } else {
                this.tXa = new VideoTextureView(this.jEz.getContext());
                h.mEJ.a(354, 151, 1, false);
            }
            this.tXc = (TextView) this.jEz.findViewById(R.h.debuginfo_tv);
            this.tXa.setPlayProgressCallback(true);
            this.tWX.addView((View) this.tXa, 2, new RelativeLayout.LayoutParams(-1, -1));
            this.tXb = (MMPinProgressBtn) this.tWX.findViewById(R.h.video_downloading_pb);
            this.tXb.setVisibility(8);
            ((View) this.tXa).setVisibility(8);
            this.tXa.setVideoCallback(new 4(this));
        }
        return this;
    }

    public final void a(boolean z, float f) {
        x.i("MicroMsg.ImageGalleryViewHolder", "%d switch video model isVideoPlay[%b] alpha[%f]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(z), Float.valueOf(f)});
        if (z) {
            View view = (View) cxz().tXa;
            view.setAlpha(f);
            O(view, 0);
            if (((double) f) >= 1.0d) {
                O(cxz().tWY, 8);
                O(cxz().tWZ, 8);
                return;
            }
            return;
        }
        O((View) cxz().tXa, 8);
        O(cxz().tWY, 0);
        O(cxz().tWZ, 0);
    }
}
