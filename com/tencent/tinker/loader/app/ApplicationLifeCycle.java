package com.tencent.tinker.loader.app;

import android.content.Context;
import android.content.res.Configuration;

public interface ApplicationLifeCycle {
    void onBaseContextAttached(Context context);

    void onConfigurationChanged(Configuration configuration);

    /* renamed from: onCreate */
    void aD();

    /* renamed from: onLowMemory */
    void aD();

    /* renamed from: onTerminate */
    void aD();

    void onTrimMemory(int i);
}
