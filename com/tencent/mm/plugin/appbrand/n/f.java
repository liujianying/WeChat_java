package com.tencent.mm.plugin.appbrand.n;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import java.util.List;

public interface f extends a {
    void a(Context context, String str, String str2, List<WxaEntryInfo> list);

    void x(Context context, int i);
}
