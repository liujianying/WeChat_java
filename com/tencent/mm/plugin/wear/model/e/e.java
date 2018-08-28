package com.tencent.mm.plugin.wear.model.e;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.List;

public final class e extends a {
    public final List<Integer> bSy() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_DATA));
        arrayList.add(Integer.valueOf(11014));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_NETWORK));
        return arrayList;
    }

    protected final byte[] p(int i, byte[] bArr) {
        switch (i) {
            case TXCStreamUploader.TXE_UPLOAD_ERROR_NO_DATA /*11013*/:
                a.sFg.m(new kt());
                break;
            case 11014:
                List bdg = ((i) g.l(i.class)).bcY().bdg();
                if (bdg.size() != 1) {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    intent.addFlags(536870912);
                    if (VERSION.SDK_INT < 16) {
                        intent.putExtra("resend_fail_messages", true);
                    }
                    intent.putExtra("From_fail_notify", true);
                    x.d("MicroMsg.Wear.HttpFailMsgServer", "startMainUI");
                    d.e(ad.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
                    break;
                }
                String str = ((bd) bdg.get(0)).field_talker;
                Intent intent2 = new Intent();
                intent2.putExtra("Main_User", str);
                intent2.putExtra("From_fail_notify", true);
                intent2.addFlags(67108864);
                intent2.addFlags(536870912);
                if (VERSION.SDK_INT < 16) {
                    intent2.putExtra("resend_fail_messages", true);
                }
                x.d("MicroMsg.Wear.HttpFailMsgServer", "startChattingUI talker=%s", new Object[]{str});
                d.e(ad.getContext(), "com.tencent.mm.ui.LauncherUI", intent2);
                break;
            case TXCStreamUploader.TXE_UPLOAD_ERROR_NO_NETWORK /*11015*/:
                a.sFg.m(new nr());
                break;
        }
        return null;
    }
}
