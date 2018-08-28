package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class a$1 extends ag {
    final /* synthetic */ a ioY;

    a$1(a aVar) {
        this.ioY = aVar;
    }

    public final void handleMessage(Message message) {
        a aVar = this.ioY;
        String string;
        switch (message.what) {
            case 131074:
                if (aVar.ihz != null) {
                    aVar.ihz.notifyDataSetChanged();
                    return;
                }
                return;
            case 131075:
                if (aVar.ihz != null && message.getData() != null) {
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        aVar.ihz.bf(string, message.getData().getInt("progress"));
                        return;
                    }
                    return;
                }
                return;
            case 131076:
                if (aVar.ihz != null && message.getData() != null) {
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        aVar.ihz.be(string, message.getData().getInt("status"));
                        return;
                    }
                    return;
                }
                return;
            case 131077:
                if (aVar.ikc != null) {
                    aVar.ikc.aGc();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
