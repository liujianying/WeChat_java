package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

public final class i extends o {
    SharedPreferences aFw;
    private long aFx;
    private long aFy = -1;
    final a aFz = new a(this, "monitoring", ((Long) aj.aIg.get()).longValue(), (byte) 0);

    protected i(q qVar) {
        super(qVar);
    }

    public final void aK(String str) {
        q.nx();
        np();
        Editor edit = this.aFw.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (!edit.commit()) {
            aR("Failed to commit campaign data");
        }
    }

    protected final void mE() {
        this.aFw = this.aFn.mContext.getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final long mR() {
        q.nx();
        np();
        if (this.aFx == 0) {
            long j = this.aFw.getLong("first_run", 0);
            if (j != 0) {
                this.aFx = j;
            } else {
                j = this.aFn.aFC.currentTimeMillis();
                Editor edit = this.aFw.edit();
                edit.putLong("first_run", j);
                if (!edit.commit()) {
                    aR("Failed to commit first run time");
                }
                this.aFx = j;
            }
        }
        return this.aFx;
    }

    public final j mS() {
        return new j(this.aFn.aFC, mR());
    }

    public final long mT() {
        q.nx();
        np();
        if (this.aFy == -1) {
            this.aFy = this.aFw.getLong("last_dispatch", 0);
        }
        return this.aFy;
    }

    public final void mU() {
        q.nx();
        np();
        long currentTimeMillis = this.aFn.aFC.currentTimeMillis();
        Editor edit = this.aFw.edit();
        edit.putLong("last_dispatch", currentTimeMillis);
        edit.apply();
        this.aFy = currentTimeMillis;
    }

    public final String mV() {
        q.nx();
        np();
        CharSequence string = this.aFw.getString("installation_campaign", null);
        return TextUtils.isEmpty(string) ? null : string;
    }
}
