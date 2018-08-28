package com.tencent.wework.api;

import android.content.Context;

public class WWAPIFactory {
    public static IWWAPI ii(Context context) {
        return new WWAPIImpl(context);
    }
}
