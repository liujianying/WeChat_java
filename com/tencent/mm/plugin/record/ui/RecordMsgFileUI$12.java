package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Base64;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pluginsdk.ui.tools.f$a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

class RecordMsgFileUI$12 implements f$a {
    final /* synthetic */ RecordMsgFileUI mtg;

    RecordMsgFileUI$12(RecordMsgFileUI recordMsgFileUI) {
        this.mtg = recordMsgFileUI;
    }

    public final void iy() {
        x.d("MicroMsg.RecordMsgFileUI", g.Ab() + " onPrepared");
        RecordMsgFileUI.i(this.mtg).setLoop(true);
        RecordMsgFileUI.i(this.mtg).start();
    }

    public final void onError(int i, int i2) {
        RecordMsgFileUI.i(this.mtg).stop();
        if (!RecordMsgFileUI.j(this.mtg)) {
            RecordMsgFileUI.k(this.mtg);
            final Bitmap b = RecordMsgFileUI.l(this.mtg).b(RecordMsgFileUI.a(this.mtg), RecordMsgFileUI.b(this.mtg));
            final String videoPath = RecordMsgFileUI.i(this.mtg).getVideoPath();
            b.A(Base64.encodeToString((d.bvD() + "[RecordMsgFileUI] on play sight error, what=" + i + ", extra=" + i2 + ", path=" + bi.aG(videoPath, "")).getBytes(), 2), "FullScreenPlaySight");
            ah.A(new Runnable() {
                public final void run() {
                    ImageView imageView = (ImageView) RecordMsgFileUI$12.this.mtg.findViewById(R.h.videoplayer_maskview);
                    imageView.setImageBitmap(b);
                    imageView.setVisibility(0);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.fromFile(new File(videoPath)), "video/*");
                    try {
                        RecordMsgFileUI$12.this.mtg.startActivity(Intent.createChooser(intent, RecordMsgFileUI$12.this.mtg.getString(R.l.favorite_video)));
                    } catch (Exception e) {
                        x.e("MicroMsg.RecordMsgFileUI", "startActivity fail, activity not found");
                        h.i(RecordMsgFileUI$12.this.mtg.mController.tml, R.l.favorite_no_match_msg, R.l.favorite_no_match_title);
                    }
                }
            });
        }
    }

    public final void wd() {
    }

    public final int ck(int i, int i2) {
        return 0;
    }

    public final void cl(int i, int i2) {
    }
}
