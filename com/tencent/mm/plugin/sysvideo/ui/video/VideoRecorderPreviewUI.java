package com.tencent.mm.plugin.sysvideo.ui.video;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.video.VideoView;

public class VideoRecorderPreviewUI extends MMActivity {
    private long duration = -1;
    private VideoView ouO;
    private String ouP = null;
    private final int ouQ = 3000;
    private ag ouR = new 2(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.mController.hideTitleView();
        this.ouP = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
        setMMTitle(R.l.video_preview_title);
        setBackBtn(new 1(this));
        initView();
    }

    public void onStart() {
        super.onStart();
    }

    protected final void initView() {
        this.ouO = (VideoView) findViewById(R.h.video_recorder_play_view);
        this.ouO.setOnErrorListener(new 3(this));
        this.ouO.setOnPreparedListener(new 4(this));
        findViewById(R.h.video_recorder_play_area).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                VideoRecorderPreviewUI.this.ouR.removeMessages(0);
                if (VideoRecorderPreviewUI.this.mController.isTitleShowing()) {
                    VideoRecorderPreviewUI.this.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    VideoRecorderPreviewUI.this.mController.hideTitleView();
                    return;
                }
                VideoRecorderPreviewUI.this.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                VideoRecorderPreviewUI.this.mController.showTitleView();
                VideoRecorderPreviewUI.this.ouR.removeMessages(0);
                VideoRecorderPreviewUI.this.ouR.sendEmptyMessageDelayed(0, 3000);
            }
        });
        this.ouO.setOnCompletionListener(new 6(this));
        if (this.ouP != null) {
            this.ouO.stopPlayback();
            this.ouO.setVideoURI(this.ouP);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.ouO.isPlaying()) {
            VideoView videoView = this.ouO;
            if (videoView.ngO != null && videoView.qTW && videoView.ngO.isPlaying()) {
                videoView.ngO.pause();
            }
            videoView.qTX = false;
        }
        finish();
        overridePendingTransition(0, 0);
        this.ouR.removeMessages(0);
    }

    protected final void dealContentView(View view) {
        ak.d(ak.a(getWindow(), null), this.mController.tlX);
        ((ViewGroup) this.mController.tlX.getParent()).removeView(this.mController.tlX);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.tlX, 0);
    }

    protected final int getLayoutId() {
        return R.i.video_recorder_preview;
    }
}
