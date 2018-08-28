package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.a.a;
import com.tencent.mm.wallet_core.b;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class c$a {
    public static String a(int i, TenpaySecureEditText tenpaySecureEditText) {
        if (q.GS()) {
            x.v("MicroMsg.IEncryptDelegate", "hy: is payu. encrypt with payu");
            c$b c_b = new c$b();
            tenpaySecureEditText.setSecureEncrypt(new a(i));
            return tenpaySecureEditText.get3DesEncrptData();
        }
        x.v("MicroMsg.IEncryptDelegate", "hy: is tenpay. encrypt with tenpay");
        c$c c_c = new c$c();
        switch (i) {
            case 0:
                b.cCO();
                return tenpaySecureEditText.getEncryptDataWithHash(false, b.cCP());
            case 1:
                b.cCO();
                return tenpaySecureEditText.getEncryptDataWithHash(true, b.cCP());
            case 2:
                return tenpaySecureEditText.get3DesEncrptData();
            case 3:
                return tenpaySecureEditText.get3DesVerifyCode();
            default:
                return tenpaySecureEditText.getText().toString() == null ? "" : tenpaySecureEditText.getText().toString();
        }
    }
}
