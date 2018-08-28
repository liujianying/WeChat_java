package com.tencent.mm.plugin.mmsight.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.w.a;
import com.tencent.mm.plugin.w.a.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;

public class MMSightRecordViewTestUI extends MMActivity {
    private MMSightRecordView fOq;
    private int fbk = 720;
    private float fbl = 0.67f;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        this.fOq = (MMSightRecordView) findViewById(d.record_view);
        this.fOq.setDisplayRatio(this.fbl);
        this.fOq.setPreviewSizeLimit(this.fbk);
        this.fOq.setVideoPara$2e715812(100000);
        this.fOq.setVideoFilePath(e.bnE + "mmsighttest.mp4");
        this.fOq.setClipPictureSize(true);
        this.fOq.setClipVideoSize(true);
        this.fOq.leB.ZX();
        this.fOq.setFlashMode(3);
        this.fOq.setFrameDataCallback(new 2(this));
        this.fOq.leB.startPreview();
        this.fOq.leB.ZS();
        findViewById(d.take_picture_btn).setOnClickListener(new 3(this));
        findViewById(d.start_record_btn).setOnClickListener(new 4(this));
        ah.i(new 5(this, (TextView) findViewById(d.debug_info)), 1000);
        findViewById(d.switch_camera_btn).setOnClickListener(new 6(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        this.fOq.leB.release();
    }

    protected final int getLayoutId() {
        return a.e.mmsight_record_view_testui;
    }
}
