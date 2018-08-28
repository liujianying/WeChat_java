package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends e {
    public o(Activity activity) {
        super(activity);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.ErrorMsgBoxProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
    }

    public final boolean b(ah ahVar) {
        x.d("MicroMsg.ErrorMsgBoxProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, ahVar.content, 0).show();
        return true;
    }

    public final boolean c(ah ahVar) {
        x.d("MicroMsg.ErrorMsgBoxProcessor", "handleIgnore");
        Toast.makeText(this.activity, ahVar.content, 0).show();
        return true;
    }

    public final boolean d(ah ahVar) {
        x.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseLast");
        Toast.makeText(this.activity, ahVar.content, 0).show();
        return true;
    }

    public final boolean e(ah ahVar) {
        x.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, ahVar.content, 0).show();
        return true;
    }
}
