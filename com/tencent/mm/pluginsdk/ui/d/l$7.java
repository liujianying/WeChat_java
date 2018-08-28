package com.tencent.mm.pluginsdk.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.k;
import java.util.List;

class l$7 implements OnItemClickListener {
    final /* synthetic */ int eeg;
    final /* synthetic */ List iYC;
    final /* synthetic */ String kzy;
    final /* synthetic */ OnDismissListener qQd;
    final /* synthetic */ k qQg;
    final /* synthetic */ Bundle qQh;
    final /* synthetic */ Context val$context;

    l$7(String str, List list, Context context, k kVar, OnDismissListener onDismissListener, int i, Bundle bundle) {
        this.kzy = str;
        this.iYC = list;
        this.val$context = context;
        this.qQg = kVar;
        this.qQd = onDismissListener;
        this.eeg = i;
        this.qQh = bundle;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CharSequence replace = this.kzy.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
        String str = (String) this.iYC.get(i);
        x.i("MicroMsg.MailPhoneMenuHelper", str);
        Intent intent;
        if (this.val$context.getString(R.l.chatting_phone_use).equals(str)) {
            intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + replace));
            intent.addFlags(268435456);
            if (bi.k(this.val$context, intent)) {
                this.val$context.startActivity(intent);
            }
            h.mEJ.k(10112, "1");
            this.qQg.dismiss();
            if (this.qQd != null) {
                this.qQd.onDismiss(null);
            }
        } else if (this.val$context.getString(R.l.chatting_phone_use_by_ipcall).equals(str)) {
            h.mEJ.h(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            intent = new Intent();
            intent.putExtra("IPCallTalkUI_phoneNumber", replace);
            d.b(this.val$context, "ipcall", ".ui.IPCallDialUI", intent);
            this.qQg.dismiss();
            if (this.qQd != null) {
                this.qQd.onDismiss(null);
            }
        } else if (this.val$context.getString(R.l.chatting_phone_add_op).equals(str)) {
            String[] stringArray;
            if (l.cfi() && l.cfj()) {
                stringArray = this.val$context.getResources().getStringArray(R.c.phone_url_add);
            } else {
                stringArray = l.cfi() ? new String[]{this.val$context.getResources().getString(R.l.chatting_phone_add_contact)} : new String[]{this.val$context.getResources().getString(R.l.chatting_phone_modify_contact)};
            }
            this.val$context.getResources().getString(R.l.chatting_phone_maybe_phone);
            com.tencent.mm.ui.base.h.a(this.val$context, this.kzy, stringArray, "", new 1(this, replace), new 2(this));
            this.qQg.dismiss();
        } else if (this.val$context.getString(R.l.chatting_phone_copy).equals(str)) {
            a.a(this.val$context, replace, replace);
            h.mEJ.k(10115, "1");
            if (this.qQd != null) {
                this.qQd.onDismiss(null);
            }
            this.qQg.dismiss();
            Toast.makeText(this.val$context, this.val$context.getString(R.l.app_copy_ok), 1).show();
        } else if (this.val$context.getString(R.l.chatting_phone_download_wxpb).equals(str)) {
            x.d("MicroMsg.MailPhoneMenuHelper", "hy: button should consume this action");
        } else if (l.qQc.equals(str)) {
            l.a((Activity) this.val$context, this.kzy, this.qQh);
            this.qQg.dismiss();
            if (this.qQd != null) {
                this.qQd.onDismiss(null);
            }
        } else {
            x.e("MicroMsg.MailPhoneMenuHelper", "hy: error phone item clicked. should not happen");
            this.qQg.dismiss();
            if (this.qQd != null) {
                this.qQd.onDismiss(null);
            }
        }
    }
}
