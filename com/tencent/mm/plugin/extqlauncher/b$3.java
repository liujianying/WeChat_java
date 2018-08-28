package com.tencent.mm.plugin.extqlauncher;

import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class b$3 extends ag {
    final /* synthetic */ b iLM;

    b$3(b bVar, Looper looper) {
        this.iLM = bVar;
        super(looper);
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
    public final void handleMessage(Message message) {
        if (ad.getContext() == null || !au.HX()) {
            x.w("MicroMsg.SubCoreExtQLauncher", "wrong status");
        } else if (b.a(this.iLM)) {
            int aJm = b.aJm();
            if (aJm > 0 || aJm < this.iLM.iLK) {
                x.d("MicroMsg.SubCoreExtQLauncher", "notify unread");
                Intent intent = new Intent("com.tencent.mm.ext.ACTION_EXT_NOTIFY");
                intent.putExtra("EXTRA_EXT_NOTIFY_TYPE", "NEW_UNREAD");
                ad.getContext().sendBroadcast(intent);
                this.iLM.iLK = aJm;
            }
        }
    }
}
