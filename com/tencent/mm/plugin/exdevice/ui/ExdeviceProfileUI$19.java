package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.exdevice.model.ac.a;

class ExdeviceProfileUI$19 implements a {
    final /* synthetic */ ExdeviceProfileUI iEx;

    ExdeviceProfileUI$19(ExdeviceProfileUI exdeviceProfileUI) {
        this.iEx = exdeviceProfileUI;
    }

    public final void zZ(String str) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
        intent.putExtra("Ksnsupload_appname", this.iEx.getString(R.l.exdevice_wechat_sport));
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("need_result", true);
        String ic = u.ic("wx_sport");
        u.Hx().v(ic, true).p("prePublishId", "wx_sport");
        intent.putExtra("reportSessionId", ic);
        intent.putExtra("Ksnsupload_type", 0);
        intent.putExtra("sns_kemdia_path", str);
        d.b(this.iEx, "sns", ".ui.SnsUploadUI", intent, 2);
    }
}
