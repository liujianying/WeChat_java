package com.tencent.mm.ui.chatting;

import android.app.ProgressDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.chatting.viewitems.au;
import com.tencent.mm.ui.w;

public final class c implements OnClickListener, e, t {
    private ProgressDialog eHw;
    private a tGW;

    public c(a aVar) {
        this.tGW = aVar;
    }

    public final void onClick(View view) {
        boolean z = true;
        boolean z2 = false;
        String str;
        if (view.getTag() == null) {
            x.e("MicroMsg.AppSpamClickListener", "onClick tag is null");
        } else if (view.getTag() instanceof au) {
            au auVar = (au) view.getTag();
            if (auVar == null) {
                x.e("MicroMsg.AppSpamClickListener", "ItemDataTag is null");
                return;
            }
            str = auVar.bXA.appId;
            if (bi.oW(str)) {
                x.e("MicroMsg.AppSpamClickListener", "appId is null or nil");
            } else if (g.bl(str, false) == null) {
                x.e("MicroMsg.AppSpamClickListener", "get null appinfo : appid = " + str);
            } else {
                z2 = true;
            }
            if (z2) {
                int i;
                String iB;
                ao.bmi().a(2, this);
                if (this.tGW.cwr()) {
                    i = 2;
                } else {
                    i = 1;
                }
                str = this.tGW.getTalkerUserName();
                if (s.fq(str)) {
                    iB = bd.iB(auVar.bXQ.field_content);
                } else {
                    iB = str;
                }
                com.tencent.mm.y.g.a aVar = auVar.bXA;
                h.a(this.tGW.tTq.getContext(), this.tGW.tTq.getMMResources().getString(R.l.app_message_setting_confirm), this.tGW.tTq.getMMResources().getString(R.l.app_message_setting_title), this.tGW.tTq.getMMResources().getString(R.l.ac_app_message_btn_tip), this.tGW.tTq.getMMResources().getString(R.l.refuse_app_message_btn_tip), new 2(this, aVar, iB, i), new 3(this, aVar, iB, i));
            }
        } else if (view.getTag() instanceof n) {
            n nVar = (n) view.getTag();
            if (nVar == null) {
                x.e("MicroMsg.AppSpamClickListener", "TemplateItemDataTag is null");
            } else if (nVar == null || bi.oW(nVar.dxx) || nVar.bXQ == null) {
                String str2 = "MicroMsg.AppSpamClickListener";
                str = "wrong args, tag is null ? ";
                Object[] objArr = new Object[1];
                if (nVar != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                x.e(str2, str, objArr);
            } else {
                String[] strArr = new String[]{this.tGW.tTq.getMMResources().getString(R.l.template_msg_btn_expose), this.tGW.tTq.getMMResources().getString(R.l.template_msg_btn_refuse), this.tGW.tTq.getMMResources().getString(R.l.app_cancel)};
                h.a(this.tGW.tTq.getContext(), null, strArr, null, true, new 1(this, nVar));
            }
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.pluginsdk.model.app.x xVar) {
        x.d("MicroMsg.AppSpamClickListener", "appsettings errType = " + i + ", errCode = " + i2);
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        ao.bmi().b(2, this);
        if (i == 0 && i2 == 0) {
            h.bA(this.tGW.tTq.getContext(), this.tGW.tTq.getMMResources().getString(R.l.game_refuse_message_ok));
        } else if (!w.a.a(this.tGW.tTq.getContext(), i, i2, str, 4)) {
            Toast.makeText(this.tGW.tTq.getContext(), this.tGW.tTq.getMMResources().getString(R.l.game_liset_set_refuse_msg_failed, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        com.tencent.mm.model.au.DF().b(1030, this);
        if (i == 0 && i2 == 0) {
            h.bA(this.tGW.tTq.getContext(), this.tGW.tTq.getMMResources().getString(R.l.game_refuse_message_ok));
            return;
        }
        Toast.makeText(this.tGW.tTq.getContext(), this.tGW.tTq.getMMResources().getString(R.l.template_msg_refuse_success, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
    }
}
