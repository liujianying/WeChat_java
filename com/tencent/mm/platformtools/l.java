package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends e {
    public l(Activity activity) {
        super(activity);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.ErrorClientProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
    }

    public final boolean b(ah ahVar) {
        x.d("MicroMsg.ErrorClientProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, ahVar.content, 0).show();
        return true;
    }

    public final boolean c(ah ahVar) {
        x.d("MicroMsg.ErrorClientProcessor", "handleIgnore");
        Toast.makeText(this.activity, ahVar.content, 0).show();
        return true;
    }

    public final boolean d(ah ahVar) {
        x.d("MicroMsg.ErrorClientProcessor", "handleFalseLast");
        Toast.makeText(this.activity, ahVar.content, 0).show();
        return true;
    }

    public final boolean e(ah ahVar) {
        x.d("MicroMsg.ErrorClientProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, ahVar.content, 0).show();
        return true;
    }
}
