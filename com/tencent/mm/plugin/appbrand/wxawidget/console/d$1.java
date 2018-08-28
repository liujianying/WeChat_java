package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.d.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class d$1 implements e {
    d$1() {
    }

    public final /* synthetic */ void at(Object obj) {
        Bundle bundle = (Bundle) obj;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("logList");
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            x.i("MicroMsg.ConsoleLogger", "logList is null or nil.");
        } else {
            d.b(bundle.getString("id"), parcelableArrayList);
        }
    }
}
