package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Message;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$2 extends c<cu> {
    final /* synthetic */ a ioY;

    a$2(a aVar) {
        this.ioY = aVar;
        this.sFo = cu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cu cuVar = (cu) bVar;
        if (cuVar != null) {
            a aVar = this.ioY;
            String str = cuVar.bKj.bKk;
            int i = cuVar.bKj.status;
            int i2 = cuVar.bKj.progress;
            x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), cuVar.bKj.bKl);
            if (!(aVar.ihz == null || aVar.ihz.ien == null)) {
                if (i == 6) {
                    Message obtain = Message.obtain();
                    obtain.getData().putString("product_id", str);
                    obtain.getData().putInt("progress", i2);
                    obtain.what = 131075;
                    aVar.m(obtain);
                } else {
                    x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "product status:%d", Integer.valueOf(i));
                    Message obtain2 = Message.obtain();
                    obtain2.getData().putString("product_id", str);
                    obtain2.getData().putInt("status", i);
                    obtain2.what = 131076;
                    aVar.m(obtain2);
                }
                f za = aVar.ihz.ien.za(str);
                if (za != null) {
                    za.ieC = r4;
                }
            }
        }
        return false;
    }
}
