package com.tencent.mm.plugin.hp.b;

import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class i {
    public static void a(String str, String str2, String str3, OnClickListener onClickListener, String str4, OnClickListener onClickListener2) {
        if (bi.oW(str2)) {
            x.e("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "msg is null");
            return;
        }
        x.i("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "try to show dialog");
        ah.A(new 1(str, str2, str3, str4, onClickListener, onClickListener2));
    }
}
