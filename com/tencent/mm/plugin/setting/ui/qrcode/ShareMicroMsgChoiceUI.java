package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ShareMicroMsgChoiceUI extends MMPreference {
    private f eOE;

    protected final boolean Yy() {
        return false;
    }

    public final int getLayoutId() {
        return g.share_mm_choice;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final int Ys() {
        return k.share_micromsg_choice;
    }

    protected final void initView() {
        setMMTitle(i.send_qrcode_to_microblog);
        this.eOE = this.tCL;
        setBackBtn(new 1(this));
        ((IconPreference) this.eOE.ZZ("share_micromsg_to_sina")).drawable = a.f(this, e.share_to_sinaweibo_icon);
        ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FZ().Hg("@t.qq.com");
        IconPreference iconPreference = (IconPreference) this.eOE.ZZ("share_micromsg_qzone");
        if ((bi.f((Integer) com.tencent.mm.kernel.g.Ei().DT().get(9, null)) != 0 ? 1 : null) == null) {
            this.eOE.c(iconPreference);
        } else {
            iconPreference.drawable = a.f(this, e.self_qrcode_show_to_qzone);
        }
        iconPreference = (IconPreference) this.eOE.ZZ("share_micromsg_to_fuckbook");
        if (q.He()) {
            iconPreference.drawable = a.f(this, e.share_to_facebook_icon);
        } else {
            this.eOE.c(iconPreference);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        Intent intent;
        if (str.equals("share_micromsg_qzone")) {
            if (bi.f((Integer) com.tencent.mm.kernel.g.Ei().DT().get(9, null)) != 0) {
                intent = new Intent(this, ShowQRCodeStep1UI.class);
                intent.putExtra("show_to", 2);
                startActivity(intent);
            } else {
                h.i(this, i.self_qrcode_show_no_qq_tip, i.app_tip);
            }
        } else if (str.equals("share_micromsg_to_sina")) {
            intent = new Intent(this, ShowQRCodeStep1UI.class);
            intent.putExtra("show_to", 3);
            startActivity(intent);
        } else if (str.equals("share_micromsg_to_fuckbook")) {
            intent = new Intent(this, ShowQRCodeStep1UI.class);
            intent.putExtra("show_to", 4);
            startActivity(intent);
        }
        return false;
    }
}
