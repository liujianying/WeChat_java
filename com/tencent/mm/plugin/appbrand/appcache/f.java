package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.base.a;
import com.tencent.mm.sdk.platformtools.h;
import java.util.Locale;

public final class f extends a {
    final int ffw;

    public f(String str, int i, int i2, String str2) {
        String format = String.format(Locale.US, "EncWxaPkg_%s_%d_%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = ah.abY() + "/enc/";
        h.Ey(str3);
        this(format, stringBuilder.append(str3).append(String.format(Locale.US, "%d_%d_%d.encwxapkg", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)})).toString(), str2, str, i, i2);
    }

    private f(String str, String str2, String str3, String str4, int i, int i2) {
        super(str, str2, str3, str4, i2, 0);
        this.ffw = i;
    }

    public final String toShortString() {
        return String.format(Locale.US, "EncryptPkgDownloadRequest[%s %d %d]", new Object[]{this.appId, Integer.valueOf(this.ffw), Integer.valueOf(this.version)});
    }
}
