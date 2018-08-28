package com.tencent.mm.platformtools;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class k {
    public static k evQ = new k();
    private Map<String, String> evR;

    public final Map<String, String> bY(Context context) {
        try {
            String x = bi.x(context.getAssets().open("config/EmailAddress.xml"));
            if (bi.oW(x)) {
                return null;
            }
            Map z = bl.z(x, "config");
            if (z == null || z.isEmpty()) {
                x.d("MicroMsg.EmailFormater", "values null");
                return null;
            } else if (this.evR != null) {
                return this.evR;
            } else {
                this.evR = new HashMap();
                int i = 0;
                while (true) {
                    x = ".config.format" + (i == 0 ? "" : Integer.valueOf(i));
                    if (z.get(x) == null) {
                        return this.evR;
                    }
                    String str = x + ".emaildomain";
                    String str2 = x + ".loginpage";
                    x = (String) z.get(str);
                    str = (String) z.get(str2);
                    if (!(bi.oW(x) || bi.oW(str))) {
                        this.evR.put(x, str);
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.EmailFormater", "parse email failed:[%s]", new Object[]{e.getMessage()});
            return null;
        }
    }
}
