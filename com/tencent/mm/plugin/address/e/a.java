package com.tencent.mm.plugin.address.e;

import android.content.Intent;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static Intent b(b bVar) {
        if (bVar == null) {
            x.e("MicroMsg.AddrUtil", "addressObj == null");
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("nationalCode", bVar.eYf);
        intent.putExtra("userName", bVar.eYd);
        intent.putExtra("telNumber", bVar.eYe);
        intent.putExtra("addressPostalCode", bVar.eYb);
        intent.putExtra("proviceFirstStageName", bVar.eXY);
        intent.putExtra("addressCitySecondStageName", bVar.eXZ);
        intent.putExtra("addressCountiesThirdStageName", bVar.eYa);
        intent.putExtra("addressDetailInfo", bVar.eYc);
        return intent;
    }
}
