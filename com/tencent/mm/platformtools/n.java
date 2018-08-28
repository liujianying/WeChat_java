package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends e {
    public n(Activity activity) {
        super(activity);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.ErrorLabelProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
    }

    public final boolean b(ah ahVar) {
        x.d("MicroMsg.ErrorLabelProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, ahVar.content, 0).show();
        return true;
    }

    public final boolean c(ah ahVar) {
        x.d("MicroMsg.ErrorLabelProcessor", "handleIgnore");
        Toast.makeText(this.activity, ahVar.content, 0).show();
        return true;
    }

    public final boolean d(ah ahVar) {
        x.d("MicroMsg.ErrorLabelProcessor", "handleFalseLast");
        Toast.makeText(this.activity, ahVar.content, 0).show();
        return true;
    }

    public final boolean e(ah ahVar) {
        x.d("MicroMsg.ErrorLabelProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, ahVar.content, 0).show();
        return true;
    }
}
