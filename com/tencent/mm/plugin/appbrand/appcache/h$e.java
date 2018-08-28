package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.app.e;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class h$e {
    public static int abC() {
        Set hashSet = new HashSet();
        Cursor b = e.aaV().b("select distinct appId from AppBrandWxaPkgManifestRecord where  ( appId not like '%%$%%' or appId like " + String.format(Locale.US, "'%%$%s'", new Object[]{"__APP__"}) + " )  and  ( pkgPath is not null  and pkgPath != ''  ) ", null, 2);
        if (!(b == null || b.isClosed())) {
            if (b.moveToFirst()) {
                do {
                    Object string = b.getString(0);
                    int indexOf = string.indexOf(36);
                    if (indexOf > 0) {
                        string = string.substring(0, indexOf);
                    }
                    hashSet.add(string);
                } while (b.moveToNext());
            }
            b.close();
        }
        Cursor b2 = e.aaV().b("select distinct appId from PredownloadEncryptPkgInfo where pkgPath is not null  and pkgPath != '' ", null, 2);
        if (!(b2 == null || b2.isClosed())) {
            if (b2.moveToFirst()) {
                hashSet.add(b2.getString(0));
            }
            do {
            } while (b2.moveToNext());
            b2.close();
        }
        return hashSet.size();
    }
}
