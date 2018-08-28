package com.tencent.mm.plugin.gallery.model;

import com.tencent.mm.sdk.platformtools.at.a;

class a$a {
    final /* synthetic */ a jAj;

    /* renamed from: com.tencent.mm.plugin.gallery.model.a$a$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a jAk;

        AnonymousClass1(a aVar) {
            this.jAk = aVar;
        }

        public final void run() {
            if (this.jAk.Kr()) {
                this.jAk.Ks();
            }
            a.c(a$a.this.jAj);
            a.d(a$a.this.jAj);
        }

        public final String toString() {
            return super.toString() + "|QueueWorkerThreadForGallery";
        }
    }

    private a$a(a aVar) {
        this.jAj = aVar;
    }

    /* synthetic */ a$a(a aVar, byte b) {
        this(aVar);
    }
}
