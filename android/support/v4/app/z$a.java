package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v4.app.ac.a;
import android.support.v4.app.z.d;

public class z$a extends a {
    public static final a.a pn = new 1();
    public PendingIntent actionIntent;
    public int icon;
    private final Bundle mExtras;
    private final ah[] pm;
    public CharSequence title;

    public final /* bridge */ /* synthetic */ aj.a[] bz() {
        return this.pm;
    }

    public z$a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        this(i, charSequence, pendingIntent, new Bundle());
    }

    private z$a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        this.icon = i;
        this.title = d.e(charSequence);
        this.actionIntent = pendingIntent;
        this.mExtras = bundle;
        this.pm = null;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final PendingIntent getActionIntent() {
        return this.actionIntent;
    }

    public final Bundle getExtras() {
        return this.mExtras;
    }
}
