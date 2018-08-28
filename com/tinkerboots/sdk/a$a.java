package com.tinkerboots.sdk;

import android.content.Context;
import com.tencent.tinker.lib.c.a;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tinkerboots.sdk.a.a.b;

public class a$a {
    public final ApplicationLike applicationLike;
    public final Context context;
    public a vFZ;
    public Class<? extends AbstractResultService> vGa;
    public b vGb;
    public com.tencent.tinker.lib.b.b vsx;
    public c vsy;
    public d vsz;

    public a$a(ApplicationLike applicationLike) {
        if (applicationLike == null) {
            throw new TinkerRuntimeException("applicationLike must not be null.");
        }
        this.context = applicationLike.getApplication();
        this.applicationLike = applicationLike;
    }
}
