package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.os.IInterface;

public interface f extends IInterface {
    void c(String str, Bitmap bitmap);

    MCacheItem eH(String str);

    void eI(String str);

    Bitmap getBitmap(String str);
}
