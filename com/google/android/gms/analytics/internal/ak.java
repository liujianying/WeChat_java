package com.google.android.gms.analytics.internal;

public final class ak extends ab<b> {

    private static class a implements com.google.android.gms.analytics.internal.ab.a<b> {
        private final q aFn;
        private final b aIl = new b();

        public a(q qVar) {
            this.aFn = qVar;
        }

        public final void g(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.aIl.aEZ = z ? 1 : 0;
                return;
            }
            this.aFn.nr().f("Bool xml configuration name not recognized", str);
        }

        public final void k(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.aIl.aEY = i;
            } else {
                this.aFn.nr().f("Int xml configuration name not recognized", str);
            }
        }

        public final void m(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.aIl.aEV = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.aIl.aEW = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.aIl.aEX = str2;
            } else {
                this.aFn.nr().f("String xml configuration name not recognized", str);
            }
        }

        public final /* synthetic */ aa nS() {
            return this.aIl;
        }
    }

    public ak(q qVar) {
        super(qVar, new a(qVar));
    }
}
