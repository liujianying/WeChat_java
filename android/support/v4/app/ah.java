package android.support.v4.app;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;

public final class ah extends android.support.v4.app.aj.a {
    private static final b qI;
    public static final android.support.v4.app.aj.a.a qJ = new android.support.v4.app.aj.a.a() {
    };
    private final Bundle mExtras;
    private final String qE;
    private final CharSequence qF;
    private final CharSequence[] qG;
    private final boolean qH;

    public static final class a {
        public Bundle mExtras = new Bundle();
        public final String qE;
        public CharSequence qF;
        public CharSequence[] qG;
        public boolean qH = true;

        public a(String str) {
            this.qE = str;
        }
    }

    public /* synthetic */ ah(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle, byte b) {
        this(str, charSequence, charSequenceArr, z, bundle);
    }

    private ah(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
        this.qE = str;
        this.qF = charSequence;
        this.qG = charSequenceArr;
        this.qH = z;
        this.mExtras = bundle;
    }

    public final String getResultKey() {
        return this.qE;
    }

    public final CharSequence getLabel() {
        return this.qF;
    }

    public final CharSequence[] getChoices() {
        return this.qG;
    }

    public final boolean getAllowFreeFormInput() {
        return this.qH;
    }

    public final Bundle getExtras() {
        return this.mExtras;
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        return qI.getResultsFromIntent(intent);
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            qI = new c();
        } else if (VERSION.SDK_INT >= 16) {
            qI = new e();
        } else {
            qI = new d();
        }
    }
}
