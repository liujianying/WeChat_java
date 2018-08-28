package com.tencent.mm.plugin.qqmail.b;

import android.os.Bundle;

public class p$c {
    public boolean mdk = false;
    public boolean mdl = true;
    public boolean mdm = true;

    public final void toBundle(Bundle bundle) {
        bundle.putBoolean("qqmail_httpoptions_expired", this.mdk);
        bundle.putBoolean("qqmail_httpoptions_needcache", this.mdl);
        bundle.putBoolean("qqmail_httpoptions_needparse", this.mdm);
    }

    public final void fromBundle(Bundle bundle) {
        this.mdk = bundle.getBoolean("qqmail_httpoptions_expired");
        this.mdl = bundle.getBoolean("qqmail_httpoptions_needcache");
        this.mdm = bundle.getBoolean("qqmail_httpoptions_needparse");
    }
}
