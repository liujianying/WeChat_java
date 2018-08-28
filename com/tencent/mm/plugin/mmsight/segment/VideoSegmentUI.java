package com.tencent.mm.plugin.mmsight.segment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.a.c;
import com.tencent.mm.plugin.mmsight.segment.k.f;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.concurrent.CountDownLatch;

@com.tencent.mm.ui.base.a(3)
public class VideoSegmentUI extends MMActivity {
    private String bOX;
    private CountDownLatch bsr = new CountDownLatch(2);
    private ProgressDialog eHw = null;
    private int egD;
    private d iMQ = new d(this);
    private RelativeLayout jdF;
    private VideoTransPara lfT;
    private String llc = "";
    private String lna = null;
    private f lnb;
    private c lnc;
    private boolean lnd = false;
    private c lne;
    private int lnf = 10000;
    private boolean lnh = false;
    private boolean lni = false;
    private boolean lnj = false;
    private com.tencent.mm.plugin.mmsight.segment.c.b lnk = new 2(this);
    private com.tencent.mm.plugin.mmsight.segment.a.c.a lnl = new 3(this);
    private com.tencent.mm.plugin.mmsight.segment.a.a.d lnm = new 4(this);
    private Surface mSurface;

    private class a implements Runnable {
        private Context context;
        private ViewGroup lkY;
        private int lns;
        private int lnt;
        private int lnu;
        private b lnv;

        /* synthetic */ a(VideoSegmentUI videoSegmentUI, ViewGroup viewGroup, int i, int i2, int i3, b bVar, byte b) {
            this(viewGroup, i, i2, i3, bVar);
        }

        private a(ViewGroup viewGroup, int i, int i2, int i3, b bVar) {
            this.lns = i;
            this.lnt = i2;
            this.lnu = i3;
            this.context = viewGroup.getContext();
            this.lkY = viewGroup;
            this.lnv = bVar;
        }

        public final void run() {
            if (!VideoSegmentUI.this.isFinishing()) {
                1 1 = new 1(this, this.context);
                int width = this.lkY.getWidth();
                int ad = com.tencent.mm.bp.a.ad(this.context, com.tencent.mm.plugin.mmsight.segment.k.b.video_segment_surface_padding_vertical);
                int top = ((View) VideoSegmentUI.this.lne).getTop() - (ad * 2);
                int i = this.lnt;
                int i2 = this.lns;
                Point point = new Point();
                float f = ((float) i2) / ((float) i) > ((float) top) / ((float) width) ? ((float) top) / ((float) i2) : ((float) width) / ((float) i);
                point.x = (int) (((float) i) * f);
                point.y = (int) (f * ((float) i2));
                x.i("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d  rawDegress %d padding %d validWidth %d validHeight %d scaled %s", new Object[]{Integer.valueOf(this.lnt), Integer.valueOf(this.lns), Integer.valueOf(this.lnu), Integer.valueOf(ad), Integer.valueOf(width), Integer.valueOf(top), point.toString()});
                if (point.x <= 0 || point.y <= 0) {
                    x.e("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d padding %d validWidth %d validHeight %d scaled %s", new Object[]{Integer.valueOf(this.lnt), Integer.valueOf(this.lns), Integer.valueOf(ad), Integer.valueOf(width), Integer.valueOf(top), point.toString()});
                    if (this.lnv != null) {
                        b bVar = this.lnv;
                        x.e("MicroMsg.VideoSegmentUI", "TextureViewCallback error");
                        bVar.lnn.lni = true;
                        bVar.lnn.finish();
                        VideoSegmentUI.b(bVar.lnn);
                        return;
                    }
                    return;
                }
                LayoutParams layoutParams = new RelativeLayout.LayoutParams(point.x, point.y);
                ad += (int) (((float) (top - point.y)) / 2.0f);
                layoutParams.topMargin = ad;
                layoutParams.bottomMargin = ad;
                width = (int) (((float) (width - point.x)) / 2.0f);
                layoutParams.leftMargin = width;
                layoutParams.rightMargin = width;
                1.setSurfaceTextureListener(this.lnv);
                this.lkY.addView(1, 0, layoutParams);
            }
        }
    }

    private class b implements SurfaceTextureListener {
        private b() {
        }

        /* synthetic */ b(VideoSegmentUI videoSegmentUI, byte b) {
            this();
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "TextureViewCallback create needResume[%b] segmentPlayer is null[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(VideoSegmentUI.this.lnh);
            objArr[1] = Boolean.valueOf(VideoSegmentUI.this.lnc == null);
            x.i(str, str2, objArr);
            VideoSegmentUI.this.mSurface = new Surface(surfaceTexture);
            if (VideoSegmentUI.this.lnc == null && VideoSegmentUI.this.lnh) {
                x.i("MicroMsg.VideoSegmentUI", "MediaPlayer resume");
                try {
                    VideoSegmentUI.this.a(false, VideoSegmentUI.this.mSurface);
                    if (!(VideoSegmentUI.this.lne == null || VideoSegmentUI.this.lnc == null)) {
                        VideoSegmentUI.this.lnc.setLoop((int) (((float) VideoSegmentUI.this.egD) * VideoSegmentUI.this.lne.beM()), (int) (((float) VideoSegmentUI.this.egD) * VideoSegmentUI.this.lne.beN()));
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "ResumeMediaPlayer error %s", new Object[]{e.getMessage()});
                }
                VideoSegmentUI.this.lnh = false;
            }
            VideoSegmentUI.this.bsr.countDown();
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            x.i("MicroMsg.VideoSegmentUI", "TextureViewCallback.surfaceDestroyed %s", new Object[]{bi.cjd()});
            try {
                if (VideoSegmentUI.this.lnc != null) {
                    x.i("MicroMsg.VideoSegmentUI", "TextureViewCallback MediaPlayer pause");
                    VideoSegmentUI.this.lnc.release();
                    VideoSegmentUI.this.lnc = null;
                    VideoSegmentUI.this.lnh = true;
                }
                VideoSegmentUI.this.mSurface = null;
            } catch (Exception e) {
            }
            return false;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    static /* synthetic */ void a(VideoSegmentUI videoSegmentUI) {
        boolean z = false;
        videoSegmentUI.setBackBtn(new 5(videoSegmentUI));
        videoSegmentUI.setMMTitle(f.edit_video);
        videoSegmentUI.a(0, com.tencent.mm.bp.a.af(videoSegmentUI.mController.tml, f.app_finish), new 6(videoSegmentUI), com.tencent.mm.ui.s.b.tmX);
        videoSegmentUI.enableOptionMenu(false);
        Intent intent = videoSegmentUI.getIntent();
        if (intent == null || bi.oW(intent.getStringExtra("key_video_path"))) {
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "is Intent null ? %b, is path null ? %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(intent == null);
            if (intent == null || intent.getStringExtra("key_video_path") == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
            videoSegmentUI.finish();
            return;
        }
        videoSegmentUI.lna = intent.getStringExtra("key_video_path");
        x.i("MicroMsg.VideoSegmentUI", "selectVideoPath: %s", new Object[]{videoSegmentUI.lna});
        if (videoSegmentUI.lna == null || videoSegmentUI.lna.length() == 0) {
            x.e("MicroMsg.VideoSegmentUI", "Please pick a video first");
            return;
        }
        videoSegmentUI.initView();
        try {
            videoSegmentUI.a(true, null);
            videoSegmentUI.lne.setOnPreparedListener(new 12(videoSegmentUI));
            videoSegmentUI.lne.setThumbBarSeekListener(videoSegmentUI.lnk);
            videoSegmentUI.lne.Hu(videoSegmentUI.lna);
            videoSegmentUI.lnb = new p();
            e.a(new d(videoSegmentUI, (byte) 0), "waiting_for_component_prepared.");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "MediaPlayer set data source error : [%s]", new Object[]{e.getMessage()});
            videoSegmentUI.finish();
        }
    }

    static /* synthetic */ void a(VideoSegmentUI videoSegmentUI, boolean z, String str) {
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("K_SEGMENTVIDEOPATH", videoSegmentUI.llc);
            intent.putExtra("KSEGMENTVIDEOTHUMBPATH", videoSegmentUI.bOX);
            videoSegmentUI.setResult(-1, intent);
            videoSegmentUI.finish();
            return;
        }
        x.e("MicroMsg.VideoSegmentUI", "Clip not success. %s", new Object[]{str});
    }

    static /* synthetic */ void b(VideoSegmentUI videoSegmentUI) {
        int i = 0;
        while (true) {
            try {
                if (((long) i) < videoSegmentUI.bsr.getCount()) {
                    videoSegmentUI.bsr.countDown();
                    i++;
                } else {
                    return;
                }
            } catch (Exception e) {
                x.e("MicroMsg.VideoSegmentUI", "ensureNotWaiting e : %s", new Object[]{e});
                return;
            }
        }
    }

    static /* synthetic */ void c(VideoSegmentUI videoSegmentUI) {
        videoSegmentUI.llc = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4";
        videoSegmentUI.bOX = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg";
        e.post(new 8(videoSegmentUI), "delete_old_temp_video_file");
        if (bi.oW(videoSegmentUI.llc) || bi.oW(videoSegmentUI.bOX)) {
            x.e("MicroMsg.VideoSegmentUI", "Create output file failed.");
            return;
        }
        videoSegmentUI.lfT = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
        if (videoSegmentUI.lfT == null) {
            x.e("MicroMsg.VideoSegmentUI", "VideoTransPara not provided.");
        } else if (videoSegmentUI.lna == null) {
            x.e("MicroMsg.VideoSegmentUI", "Please pick a video first");
        } else if (videoSegmentUI.bsr.getCount() != 0) {
            x.e("MicroMsg.VideoSegmentUI", "Not prepared right now, please try again.");
        } else {
            x.i("MicroMsg.VideoSegmentUI", "Start to process video");
            videoSegmentUI.getString(f.app_tip);
            videoSegmentUI.eHw = h.a(videoSegmentUI, videoSegmentUI.getString(f.app_waiting), false, null);
            videoSegmentUI.lne.gv(true);
            e.post(new 7(videoSegmentUI), "clip_video");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.iMQ));
        this.iMQ.K(new 1(this));
    }

    protected final void initView() {
        this.lne = (c) findViewById(k.c.segment_thumb_seek_bar);
        this.jdF = (RelativeLayout) findViewById(k.c.root);
    }

    private void a(boolean z, Surface surface) {
        if (this.lnc != null) {
            x.e("MicroMsg.VideoSegmentUI", "initSegmentPlayer not null, you can not init segmentPlayer");
            return;
        }
        this.lnc = new c();
        this.lnd = false;
        this.lnc.setDataSource(this.lna);
        this.lnc.a(new com.tencent.mm.plugin.mmsight.segment.a.a.a() {
            public final boolean cS(int i, int i2) {
                x.e("MicroMsg.VideoSegmentUI", "MediaPlayer on error what = %d extra = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                VideoSegmentUI.this.lni = true;
                VideoSegmentUI.this.finish();
                VideoSegmentUI.b(VideoSegmentUI.this);
                return true;
            }
        });
        if (z) {
            this.lnc.a(this.lnm);
        }
        this.lnc.setAudioStreamType(3);
        this.lnc.setLooping(true);
        if (surface != null) {
            this.lnc.setSurface(surface);
        }
        this.lnc.lnl = this.lnl;
        this.lnc.a(new com.tencent.mm.plugin.mmsight.segment.a.a.b() {
            public final void bG(Object obj) {
                x.i("MicroMsg.VideoSegmentUI", "MediaPlayer.onPrepared start %s", new Object[]{obj});
                try {
                    if (VideoSegmentUI.this.lnc != null) {
                        VideoSegmentUI.this.lnd = true;
                        VideoSegmentUI.this.lnc.start();
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "hy: exception when onPrepared waiting for starting", new Object[0]);
                }
            }
        });
        this.lnc.prepareAsync();
        this.lnc.a(new 11(this));
    }

    protected void onResume() {
        if (this.lnc != null && this.lnd) {
            x.i("MicroMsg.VideoSegmentUI", "onResume start player");
            this.lnc.start();
        }
        super.onResume();
    }

    protected void onPause() {
        if (this.lnc != null) {
            x.i("MicroMsg.VideoSegmentUI", "onPause pause player");
            this.lnc.pause();
        }
        super.onPause();
    }

    protected void onDestroy() {
        x.i("MicroMsg.VideoSegmentUI", "onDestroy");
        super.onDestroy();
        getWindow().clearFlags(128);
        this.iMQ.release();
        if (this.lne != null) {
            this.lne.release();
        }
        if (this.lnc != null) {
            this.lnc.release();
        }
        if (this.mSurface != null) {
            this.mSurface.release();
        }
        if (this.lnb != null) {
            this.lnb.release();
        }
        j.lin.Fm();
    }

    protected final int getLayoutId() {
        return k.d.video_segment_ui;
    }
}
