package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class g$70 implements OnKeyListener {
    final /* synthetic */ g qiK;

    g$70(g gVar) {
        this.qiK = gVar;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        h.a(g.j(this.qiK), true, g.j(this.qiK).getString(R.l.webview_jssdk_video_uploading_tips), "", g.j(this.qiK).getString(R.l.webview_jssdk_upload_video_cancel), g.j(this.qiK).getString(R.l.webview_jssdk_upload_video_continue), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                g.l(g$70.this.qiK).cancel();
            }
        }, new 2(this));
        return true;
    }
}
