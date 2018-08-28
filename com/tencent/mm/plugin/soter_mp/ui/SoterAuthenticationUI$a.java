package com.tencent.mm.plugin.soter_mp.ui;

import android.annotation.TargetApi;
import android.os.Message;
import com.tencent.mm.plugin.soter_mp.b.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.a.c;
import java.lang.ref.WeakReference;

public class SoterAuthenticationUI$a extends ag {
    private WeakReference<SoterAuthenticationUI> iQm;

    /* synthetic */ SoterAuthenticationUI$a(SoterAuthenticationUI soterAuthenticationUI, byte b) {
        this(soterAuthenticationUI);
    }

    static /* synthetic */ void a(SoterAuthenticationUI$a soterAuthenticationUI$a) {
        if (soterAuthenticationUI$a.iQm != null) {
            soterAuthenticationUI$a.iQm.clear();
        }
    }

    private SoterAuthenticationUI$a(SoterAuthenticationUI soterAuthenticationUI) {
        this.iQm = null;
        this.iQm = new WeakReference(soterAuthenticationUI);
    }

    @TargetApi(23)
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        e eVar;
        switch (message.what) {
            case 0:
                x.i("MicroMsg.SoterAuthenticationUI", "hy: inform ok");
                eVar = (e) message.obj;
                if (this.iQm == null || this.iQm.get() == null) {
                    x.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                    return;
                } else {
                    SoterAuthenticationUI.a((SoterAuthenticationUI) this.iQm.get(), eVar);
                    return;
                }
            case 1:
                x.i("MicroMsg.SoterAuthenticationUI", "hy: inform cancel");
                eVar = (e) message.obj;
                if (this.iQm == null || this.iQm.get() == null) {
                    x.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                    return;
                } else {
                    SoterAuthenticationUI.b((SoterAuthenticationUI) this.iQm.get(), eVar);
                    return;
                }
            case 2:
                x.i("MicroMsg.SoterAuthenticationUI", "hy: inform fail");
                eVar = (e) message.obj;
                if (this.iQm == null || this.iQm.get() == null) {
                    x.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                    return;
                } else {
                    SoterAuthenticationUI.c((SoterAuthenticationUI) this.iQm.get(), eVar);
                    return;
                }
            case 3:
                x.i("MicroMsg.SoterAuthenticationUI", "hy: request permission");
                if (this.iQm == null || this.iQm.get() == null) {
                    x.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                    return;
                }
                String[] stringArray = message.getData().getStringArray("permissions");
                int i = message.getData().getInt("request_code");
                if (stringArray == null || stringArray.length <= 1) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: permission null");
                    return;
                } else {
                    ((SoterAuthenticationUI) this.iQm.get()).requestPermissions(stringArray, i);
                    return;
                }
            case 4:
                x.i("MicroMsg.SoterAuthenticationUI", "hy: show progress");
                if (this.iQm == null || this.iQm.get() == null) {
                    x.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                    return;
                } else {
                    SoterAuthenticationUI.a((SoterAuthenticationUI) this.iQm.get());
                    return;
                }
            case 5:
                x.i("MicroMsg.SoterAuthenticationUI", "hy: dismiss progress");
                if (this.iQm == null || this.iQm.get() == null) {
                    x.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                    return;
                } else {
                    SoterAuthenticationUI.b((SoterAuthenticationUI) this.iQm.get());
                    return;
                }
            case 6:
                x.i("MicroMsg.SoterAuthenticationUI", "hy: show dialog");
                if (this.iQm == null || this.iQm.get() == null) {
                    x.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                    return;
                }
                ((SoterAuthenticationUI) this.iQm.get()).addDialog((c) message.obj);
                return;
            default:
                x.e("MicroMsg.SoterAuthenticationUI", "hy: unidentified msg: %d", new Object[]{Integer.valueOf(message.what)});
                return;
        }
    }
}
