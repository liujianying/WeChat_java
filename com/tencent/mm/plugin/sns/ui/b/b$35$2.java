package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.b.b.35;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

class b$35$2 implements d {
    final /* synthetic */ String dhF;
    final /* synthetic */ n oli;
    final /* synthetic */ 35 olm;
    final /* synthetic */ String oln;

    b$35$2(35 35, n nVar, String str, String str2) {
        this.olm = 35;
        this.oli = nVar;
        this.dhF = str;
        this.oln = str2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        long j = 0;
        Intent intent;
        switch (menuItem.getItemId()) {
            case 0:
                intent = new Intent();
                String str = "sns_permission_snsinfo_svr_id";
                if (this.oli != null) {
                    j = this.oli.field_snsId;
                }
                intent.putExtra(str, j);
                intent.putExtra("sns_permission_userName", this.dhF);
                intent.putExtra("sns_permission_anim", true);
                intent.putExtra("sns_permission_block_scene", 5);
                intent.setClass(this.olm.olf.activity, SnsPermissionUI.class);
                this.olm.olf.activity.startActivityForResult(intent, 11);
                return;
            case 1:
                intent = new Intent();
                n Nl = af.byo().Nl(this.oln);
                if (Nl == null) {
                    x.i("MicroMsg.TimelineClickListener", "error get snsinfo by id " + this.oln);
                    return;
                }
                x.i("MicroMsg.TimelineClickListener", "expose id " + Nl.bAK() + " " + Nl.field_userName);
                String str2 = "k_expose_msg_id";
                if (Nl != null) {
                    j = Nl.field_snsId;
                }
                intent.putExtra(str2, j);
                intent.putExtra("k_username", Nl == null ? "" : Nl.field_userName);
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                com.tencent.mm.bg.d.b(this.olm.olf.activity, "webview", ".ui.tools.WebViewUI", intent);
                return;
            default:
                return;
        }
    }
}
