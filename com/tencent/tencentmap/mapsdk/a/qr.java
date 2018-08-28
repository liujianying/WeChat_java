package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;

public final class qr {
    public static qq a() {
        return a("marker.png");
    }

    public static qq a(Bitmap bitmap) {
        return bitmap == null ? null : new qq(bitmap);
    }

    public static qq a(String str) {
        try {
            InputStream resourceAsStream = qr.class.getResourceAsStream("/assets/" + str);
            Bitmap decodeStream = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return a(decodeStream);
        } catch (Exception e) {
            return null;
        }
    }
}
