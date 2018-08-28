package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ImagePreviewUI$24 implements OnClickListener {
    final /* synthetic */ ImagePreviewUI jEa;

    ImagePreviewUI$24(ImagePreviewUI imagePreviewUI) {
        this.jEa = imagePreviewUI;
    }

    public final void onClick(View view) {
        String jl = ImagePreviewUI.h(this.jEa).jl(ImagePreviewUI.g(this.jEa).intValue());
        if (bi.oW(jl)) {
            x.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[]{ImagePreviewUI.g(this.jEa)});
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_video_path", jl);
        intent.putExtra("key_need_clip_video_first", true);
        d.b(this.jEa.mController.tml, "mmsight", ".segment.MMSightEditUI", intent, 4370);
    }
}
