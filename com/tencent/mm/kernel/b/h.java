package com.tencent.mm.kernel.b;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.by.a;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;

public final class h extends g {
    public c cXF;
    public ApplicationLike dsS;
    public a<ApplicationLifeCycle> dsT = new a();
    public e mProfileCompat;

    /* renamed from: com.tencent.mm.kernel.b.h$3 */
    class AnonymousClass3 implements a.a<ApplicationLifeCycle> {
        final /* synthetic */ int dsV;

        public AnonymousClass3(int i) {
            this.dsV = i;
        }

        public final /* synthetic */ void aD(Object obj) {
            ((ApplicationLifeCycle) obj).onTrimMemory(this.dsV);
        }
    }

    /* renamed from: com.tencent.mm.kernel.b.h$5 */
    class AnonymousClass5 implements a.a<ApplicationLifeCycle> {
        final /* synthetic */ Configuration dsW;

        public AnonymousClass5(Configuration configuration) {
            this.dsW = configuration;
        }

        public final /* synthetic */ void aD(Object obj) {
            ((ApplicationLifeCycle) obj).onConfigurationChanged(this.dsW);
        }
    }

    /* renamed from: com.tencent.mm.kernel.b.h$6 */
    class AnonymousClass6 implements a.a<ApplicationLifeCycle> {
        final /* synthetic */ Context val$context;

        public AnonymousClass6(Context context) {
            this.val$context = context;
        }

        public final /* synthetic */ void aD(Object obj) {
            ((ApplicationLifeCycle) obj).onBaseContextAttached(this.val$context);
        }
    }

    public final String getPackageName() {
        return ad.getPackageName();
    }

    public h(String str, Application application, ApplicationLike applicationLike) {
        super(str, application);
        ad.bZ(str);
        this.dsS = applicationLike;
    }
}
