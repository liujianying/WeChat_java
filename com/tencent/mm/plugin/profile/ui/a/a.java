package com.tencent.mm.plugin.profile.ui.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;

public final class a implements e {
    Activity bOb;
    p jnR;
    com.tencent.mm.plugin.profile.a.a lYn;
    private al lYo = new al(new 1(this), false);

    public a(Activity activity) {
        this.bOb = activity;
    }

    public final void ef(String str, String str2) {
        if (str == null) {
            x.e("MicroMsg.ViewTWeibo", "null weibo id");
            return;
        }
        au.DF().a(205, this);
        this.lYn = new com.tencent.mm.plugin.profile.a.a(bi.oV(str).replace("http://t.qq.com/", "").trim(), str2);
        au.DF().a(this.lYn, 0);
        this.lYo.J(3000, 3000);
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(205, this);
        com.tencent.mm.plugin.profile.a.a aVar = (com.tencent.mm.plugin.profile.a.a) lVar;
        if (i == 0 && i2 == 0) {
            JI(aVar.getURL());
            return;
        }
        if (i != 4) {
            x.e("MicroMsg.ViewTWeibo", "view weibo failed: " + i + ", " + i2);
        }
        JI("http://t.qq.com/" + aVar.lUe);
    }

    private void JI(String str) {
        this.lYo.SO();
        if (this.jnR != null) {
            this.jnR.dismiss();
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, this.bOb.getString(R.l.contact_info_weibo));
        intent.putExtra("zoom", true);
        intent.putExtra("vertical_scroll", false);
        d.b(this.bOb, "webview", ".ui.tools.WebViewUI", intent);
    }
}
