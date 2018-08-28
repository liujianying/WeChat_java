package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.k.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.c.a;
import com.google.android.gms.wearable.internal.bg.c;
import com.google.android.gms.wearable.k;
import java.util.List;
import java.util.concurrent.FutureTask;

final class an {

    static final class d extends a<com.google.android.gms.wearable.h> {
        public d(b<com.google.android.gms.wearable.h> bVar) {
            super(bVar);
        }

        public final void b(DataHolder dataHolder) {
            aq(new com.google.android.gms.wearable.h(dataHolder));
        }
    }

    static final class e extends a<com.google.android.gms.wearable.c.d> {
        public e(b<com.google.android.gms.wearable.c.d> bVar) {
            super(bVar);
        }

        public final void a(GetFdForAssetResponse getFdForAssetResponse) {
            aq(new c(ak.dS(getFdForAssetResponse.statusCode), getFdForAssetResponse.beD));
        }
    }

    static final class f extends a {
        f() {
        }

        public final void f(Status status) {
        }
    }

    static final class g extends a<a> {
        private final List<FutureTask<Boolean>> beT;

        g(b<a> bVar, List<FutureTask<Boolean>> list) {
            super(bVar);
            this.beT = list;
        }

        public final void a(PutDataResponse putDataResponse) {
            aq(new bg.a(ak.dS(putDataResponse.statusCode), putDataResponse.beC));
            if (putDataResponse.statusCode != 0) {
                for (FutureTask cancel : this.beT) {
                    cancel.cancel(true);
                }
            }
        }
    }

    static final class h extends a<k.b> {
        public h(b<k.b> bVar) {
            super(bVar);
        }

        public final void a(SendMessageResponse sendMessageResponse) {
            aq(new z.a(ak.dS(sendMessageResponse.statusCode), sendMessageResponse.aRl));
        }
    }
}
