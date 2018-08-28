package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.a.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.masssend.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;

class c$a implements OnClickListener {
    private String fileName;
    final /* synthetic */ c laQ;
    private int lao;

    public c$a(c cVar, String str, int i) {
        this.laQ = cVar;
        this.fileName = str;
        this.lao = i;
    }

    public final void onClick(View view) {
        x.v("MicroMsg.HistoryAdapter", "image clicked:" + this.fileName);
        au.HU();
        if (c.isSDCardAvailable()) {
            StringBuilder stringBuilder = new StringBuilder();
            au.HU();
            String stringBuilder2 = stringBuilder.append(c.Gb()).append(this.fileName).toString();
            if (stringBuilder2 == null || stringBuilder2.equals("") || !e.cn(stringBuilder2)) {
                x.d("MicroMsg.HistoryAdapter", "showImg : imgPath is null");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("key_compress_type", this.lao);
            intent.putExtra("key_favorite", false);
            intent.putExtra("key_image_path", stringBuilder2);
            a.ezn.d(c.a(this.laQ), intent);
            return;
        }
        s.gH(c.a(this.laQ));
    }
}
