package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.m.b;
import com.tencent.mm.plugin.wallet_core.ui.j.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Vector;

class j$a$1 extends m<String> {
    final /* synthetic */ a pvA;

    j$a$1(a aVar) {
        this.pvA = aVar;
    }

    public final String a(Vector<b> vector, int i) {
        if (vector == null) {
            x.w("MicroMsg.WalletFavorDialog", "func[getComposedKey] keyList null");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= vector.size()) {
                break;
            }
            i2 = ((b) vector.get(i3)).poz;
            if (i3 == i || i2 == m.a.pov) {
                stringBuilder.append(((String) ((b) vector.get(i3)).poy) + "-");
            }
            i2 = i3 + 1;
        }
        if (stringBuilder.length() == 0) {
            return "0";
        }
        if (stringBuilder.length() > 1) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
