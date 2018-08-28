package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.an.b;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements OnClickListener {
    final /* synthetic */ a lAx;

    a$1(a aVar) {
        this.lAx = aVar;
    }

    public final void onClick(View view) {
        avq Qa = b.Qa();
        Intent intent;
        if (Qa == null || !Qa.rYE || TextUtils.isEmpty(Qa.rYF)) {
            intent = new Intent();
            h.mEJ.h(11992, new Object[]{Integer.valueOf(1)});
            intent.putExtra("key_scene", 1);
            d.b((Context) this.lAx.qJS.get(), "music", ".ui.MusicMainUI", intent);
            return;
        }
        x.i("MusicBanner", "barBackToWebView is true, start to jump Url:%s", new Object[]{Qa.rYF});
        intent = new Intent();
        intent.putExtra("rawUrl", r0);
        d.b((Context) this.lAx.qJS.get(), "webview", ".ui.tools.WebViewUI", intent);
    }
}
