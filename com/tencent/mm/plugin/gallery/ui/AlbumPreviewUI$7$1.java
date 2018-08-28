package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.j.b;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.p.a;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.7;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class AlbumPreviewUI$7$1 implements OnClickListener {
    final /* synthetic */ 7 jCI;

    AlbumPreviewUI$7$1(7 7) {
        this.jCI = 7;
    }

    private void aRS() {
        String stringExtra = this.jCI.jCE.getIntent().getStringExtra("to_user");
        String stringExtra2 = this.jCI.jCE.getIntent().getStringExtra("file_name");
        String stringExtra3 = this.jCI.jCE.getIntent().getStringExtra("video_path");
        String stringExtra4 = this.jCI.jCE.getIntent().getStringExtra("video_full_path");
        String stringExtra5 = this.jCI.jCE.getIntent().getStringExtra("video_thumb_path");
        try {
            Intent intent = new Intent();
            intent.setClassName(this.jCI.jCE.mController.tml.getPackageName(), "com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI");
            intent.putExtra("VideoRecorder_ToUser", stringExtra);
            intent.putExtra("VideoRecorder_FileName", stringExtra2);
            intent.putExtra("VideoRecorder_VideoPath", stringExtra3);
            intent.putExtra("VideoRecorder_VideoFullPath", stringExtra4);
            intent.putExtra("VideoRecorder_VideoThumbPath", stringExtra5);
            x.d("MicroMsg.AlbumPreviewUI", "try to record video, dump intent:\n%s", new Object[]{intent});
            this.jCI.jCE.startActivityForResult(intent, 4371);
        } catch (Exception e) {
            x.w("MicroMsg.AlbumPreviewUI", e.toString());
            if (!a.bx(this.jCI.jCE.mController.tml) && !a.bw(this.jCI.jCE.mController.tml)) {
                b.k(this.jCI.jCE.mController.tml);
            }
        }
    }

    public final void onClick(View view) {
        x.d("MicroMsg.AlbumPreviewUI", "on click open camera, valid click times[%d]", new Object[]{Integer.valueOf(AlbumPreviewUI.B(this.jCI.jCE))});
        if (AlbumPreviewUI.C(this.jCI.jCE)) {
            x.w("MicroMsg.AlbumPreviewUI", "click open camera, but camera is opening");
            return;
        }
        AlbumPreviewUI.D(this.jCI.jCE);
        AlbumPreviewUI.E(this.jCI.jCE);
        if (c.aRf().aRJ() == 2 || c.aRf().aRI() == 13) {
            if (this.jCI.jCE.getIntent().getBooleanExtra("record_video_force_sys_camera", false)) {
                int intExtra = this.jCI.jCE.getIntent().getIntExtra("record_video_quality", 0);
                int intExtra2 = this.jCI.jCE.getIntent().getIntExtra("record_video_time_limit", 0);
                l.a(this.jCI.jCE.mController.tml, this.jCI.jCE.getIntent().getStringExtra("video_full_path"), 4372, intExtra2, intExtra, false);
            } else if (this.jCI.jCE.getIntent().getBooleanExtra("record_video_is_sight_capture", false)) {
                if (((SightParams) this.jCI.jCE.getIntent().getParcelableExtra("KEY_SIGHT_PARAMS")) == null) {
                    x.e("MicroMsg.AlbumPreviewUI", "takeMMSight, sightParams == null");
                }
                if (c.aRf().aRI() != 13) {
                    l.a(this.jCI.jCE.mController.tml, 4375, this.jCI.jCE.getIntent(), 3, 1);
                } else {
                    l.a(this.jCI.jCE.mController.tml, 4375, this.jCI.jCE.getIntent(), 4, 1);
                }
            } else if (q.deW.ddK == 2) {
                aRS();
            } else if (q.deW.ddK != 1 || a.bx(this.jCI.jCE.mController.tml) || a.bw(this.jCI.jCE.mController.tml)) {
                aRS();
            } else {
                b.k(this.jCI.jCE.mController.tml);
            }
        } else if (c.aRf().aRJ() == 1 || c.aRf().aRJ() == 3) {
            File file = new File(e.dgl);
            if (file.exists() || file.mkdir()) {
                x.i("MicroMsg.AlbumPreviewUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.jCI.jCE.mController.tml, "android.permission.CAMERA", 16, "", "")), bi.cjd(), this.jCI.jCE.mController.tml});
                if (com.tencent.mm.pluginsdk.permission.a.a(this.jCI.jCE.mController.tml, "android.permission.CAMERA", 16, "", "")) {
                    AlbumPreviewUI.F(this.jCI.jCE);
                    return;
                }
                return;
            }
            Toast.makeText(this.jCI.jCE.mController.tml, this.jCI.jCE.getString(R.l.chatting_toast_sdk_fail), 1).show();
        }
    }
}
