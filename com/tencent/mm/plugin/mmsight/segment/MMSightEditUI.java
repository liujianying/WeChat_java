package com.tencent.mm.plugin.mmsight.segment;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.a.a$a;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.ui.VideoSeekBarEditorView;
import com.tencent.mm.plugin.w.a$d;
import com.tencent.mm.plugin.w.a.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.a;

@a(3)
public class MMSightEditUI extends MMActivity {
    private String bOX;
    private d iMQ = new d(ad.getContext());
    private VideoTransPara lfT;
    private ViewGroup lkY;
    private VideoPlayerTextureView lkZ;
    private VideoSeekBarEditorView lla;
    private com.tencent.mm.plugin.mmsight.ui.a llb;
    private String llc;
    private boolean lld = false;
    private boolean lle = false;
    private f.a llf = new 3(this);
    private String videoPath;

    static /* synthetic */ void a(MMSightEditUI mMSightEditUI) {
        if (gn(mMSightEditUI)) {
            mMSightEditUI.cqj();
            mMSightEditUI.DO(0);
        }
        mMSightEditUI.lkY = (ViewGroup) mMSightEditUI.findViewById(a$d.root);
        mMSightEditUI.lkZ = (VideoPlayerTextureView) mMSightEditUI.findViewById(a$d.video_play_video);
        mMSightEditUI.lla = (VideoSeekBarEditorView) mMSightEditUI.findViewById(a$d.video_seek_bar_editor);
        mMSightEditUI.videoPath = mMSightEditUI.getIntent().getStringExtra("key_video_path");
        mMSightEditUI.lfT = (VideoTransPara) mMSightEditUI.getIntent().getParcelableExtra("key_video_para");
        mMSightEditUI.lld = mMSightEditUI.getIntent().getBooleanExtra("key_need_clip_video_first", false);
        if (bi.oW(mMSightEditUI.videoPath)) {
            x.e("MicroMsg.MMSightEditUI", "error!, videoPath is null!!");
            return;
        }
        if (mMSightEditUI.lfT == null) {
            x.e("MicroMsg.MMSightEditUI", "videoTransPara is null!, use SnsAlbumVideoTransPara");
            mMSightEditUI.lfT = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
        }
        x.i("MicroMsg.MMSightEditUI", "videoTransPara: %s", new Object[]{mMSightEditUI.lfT});
        mMSightEditUI.lkZ.setAlpha(0.0f);
        mMSightEditUI.lkZ.setVideoPath(mMSightEditUI.videoPath);
        mMSightEditUI.lkZ.setLoop(true);
        mMSightEditUI.lkZ.setForceScaleFullScreen(true);
        mMSightEditUI.lkZ.setVideoCallback(mMSightEditUI.llf);
        mMSightEditUI.llc = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4";
        mMSightEditUI.bOX = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg";
        if (ak.gt(mMSightEditUI)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) mMSightEditUI.lla.getLayoutParams();
            marginLayoutParams.bottomMargin += ak.gs(mMSightEditUI);
            mMSightEditUI.lla.setLayoutParams(marginLayoutParams);
        }
    }

    static /* synthetic */ void i(MMSightEditUI mMSightEditUI) {
        mMSightEditUI.llb = new com.tencent.mm.plugin.mmsight.ui.a();
        mMSightEditUI.llb.lpe = true;
        mMSightEditUI.llb.lpi = 2;
        mMSightEditUI.llb.lpc = new 2(mMSightEditUI);
        mMSightEditUI.llb.lph = mMSightEditUI.llc;
        mMSightEditUI.llb.a(mMSightEditUI, 512, mMSightEditUI.videoPath, mMSightEditUI.lla, mMSightEditUI.lkZ, mMSightEditUI.lkY, mMSightEditUI.lfT, mMSightEditUI.lld);
    }

    public void onCreate(Bundle bundle) {
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().addFlags(2097280);
        if (com.tencent.mm.compatible.util.d.fR(19)) {
            getWindow().setFlags(201327616, 201327616);
            com.tencent.mm.plugin.mmsight.d.gs(true);
        } else {
            getWindow().setFlags(1024, 1024);
            com.tencent.mm.plugin.mmsight.d.gs(false);
        }
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.iMQ));
        this.iMQ.K(new 1(this, bi.VG()));
    }

    protected final int getLayoutId() {
        return e.mmsight_video_edit_ui;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onBackPressed() {
        if (this.llb == null || !this.llb.agV()) {
            super.onBackPressed();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.lkZ != null) {
            this.lkZ.pause();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.lkZ != null) {
            this.lkZ.start();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lkZ != null) {
            this.lkZ.stop();
        }
        if (this.llb != null) {
            if (this.lle) {
                com.tencent.mm.plugin.mmsight.a.a.a(new a$a(this.llb.scene));
            }
            this.llb.release();
        }
    }
}
