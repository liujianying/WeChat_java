package com.tencent.mm.plugin.boots;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    public final boolean a(Context context, String[] strArr) {
        String str = strArr[1];
        if (b.chp()) {
            int i = -1;
            switch (str.hashCode()) {
                case 3000779:
                    if (str.equals("apkg")) {
                        i = 1;
                        break;
                    }
                    break;
                case 2067292548:
                    if (str.equals("showall")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    List<com.tencent.mm.plugin.boots.a.a> aua = ((c) g.l(c.class)).aua();
                    if (!aua.isEmpty()) {
                        x.e("MicroMsg.Boots.BootsCommand", "start day active keys");
                        for (com.tencent.mm.plugin.boots.a.a aVar : aua) {
                            x.i("MicroMsg.Boots.BootsCommand", "key:%s active:%d", new Object[]{Integer.toHexString(aVar.field_key), Integer.valueOf(aVar.field_dau)});
                        }
                    }
                    return true;
                case 1:
                    if (strArr.length < 5) {
                        x.i("MicroMsg.Boots.BootsCommand", "must include url,md5 and appId");
                    }
                    return true;
            }
        }
        str.hashCode();
        return false;
    }
}
