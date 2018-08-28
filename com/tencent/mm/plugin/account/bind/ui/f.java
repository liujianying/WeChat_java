package com.tencent.mm.plugin.account.bind.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.EditText;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.opensdk.modelbase.BaseResp.ErrCode;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.protocal.c.bxw;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.c;

public final class f implements e {
    Context context;
    private View eIU = null;
    p eIV = null;
    c eIW = null;
    SecurityImage eIX = null;
    String eIY = "";
    private byte[] eIZ = null;
    private String eJa = "";
    private String eJb;
    private a eJc;

    public interface a {
        void Xc();

        boolean by(int i, int i2);
    }

    public f(Context context, a aVar) {
        this.context = context;
        this.eJc = aVar;
    }

    public final void FC() {
        g.DF().a(384, this);
    }

    public final void onDetach() {
        g.DF().b(384, this);
        if (this.eJc != null) {
            this.eJc.Xc();
        }
    }

    public final void Xd() {
        this.eIU = View.inflate(this.context, com.tencent.mm.plugin.account.a.g.sendqqpwd_dialog, null);
        final EditText editText = (EditText) this.eIU.findViewById(com.tencent.mm.plugin.account.a.f.sendqqpwd_content);
        editText.setHint(a$j.bind_qq_verify_textview_pwd);
        this.eIW = h.a(this.context, this.context.getString(a$j.bind_qq_verify_alert_pwd), this.eIU, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                f.this.eIW = null;
                f fVar = f.this;
                String trim = editText.getText().toString().trim();
                fVar.FC();
                fVar.eIY = trim;
                Context context = fVar.context;
                fVar.context.getString(a$j.app_tip);
                fVar.eIV = h.a(context, fVar.context.getString(a$j.sendrequest_sending), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        f.this.onDetach();
                    }
                });
                g.DF().a(new ab(5, fVar.eIY, "", "", "", false, 1), 0);
            }
        }, new 2(this));
    }

    @TargetApi(17)
    public final void a(int i, int i2, String str, l lVar) {
        onDetach();
        if (lVar != null && lVar.getType() == 384) {
            byte[] a;
            if (this.eIV != null) {
                this.eIV.dismiss();
                this.eIV = null;
            }
            this.eJa = com.tencent.mm.platformtools.ab.a(((bxw) ((ab) lVar).diG.dIE.dIL).rMn);
            ab abVar = (ab) lVar;
            if (((bxw) abVar.diG.dIE.dIL).rev == null || ((bxw) abVar.diG.dIE.dIL).rev.siI <= 0) {
                a = com.tencent.mm.platformtools.ab.a(((bxw) abVar.diG.dIE.dIL).rcn);
            } else {
                a = g.Eg().Dp().ba(abVar.egu);
            }
            this.eIZ = a;
            if (this.eJc == null || !this.eJc.by(i, i2)) {
                if (this.context instanceof Activity) {
                    Activity activity = (Activity) this.context;
                    if (!activity.isFinishing()) {
                        if (VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
                            return;
                        }
                    }
                    return;
                }
                com.tencent.mm.h.a eV;
                if (i == 4) {
                    switch (i2) {
                        case -311:
                        case -310:
                        case ErrCode.ERR_BAN /*-6*/:
                            if (!g.Eg().Dx()) {
                                return;
                            }
                            if (this.eIX == null) {
                                this.eIX = com.tencent.mm.ui.applet.SecurityImage.a.a(this.context, a$j.regbyqq_secimg_title, 0, this.eIZ, this.eJa, this.eJb, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        ab abVar = new ab(5, f.this.eIY, f.this.eIX.getSecImgSid(), f.this.eIX.getSecImgCode(), f.this.eIX.getSecImgEncryptKey(), true, 1);
                                        f.this.FC();
                                        g.DF().a(abVar, 0);
                                        f fVar = f.this;
                                        Context context = f.this.context;
                                        f.this.context.getString(a$j.app_tip);
                                        fVar.eIV = h.a(context, f.this.context.getString(a$j.login_logining), true, new 1(this, abVar));
                                    }
                                }, null, new 6(this), new b(this));
                                return;
                            } else {
                                this.eIX.a(0, this.eIZ, this.eJa, this.eJb);
                                return;
                            }
                        case -72:
                            this.eIW = h.i(this.context, a$j.chatting_niceqq_expired_tip, a$j.app_tip);
                            return;
                        case -34:
                            this.eIW = h.b(this.context, this.context.getString(a$j.bind_qq_verify_alert_failed_freq_limit), this.context.getString(a$j.app_tip), true);
                            return;
                        case -3:
                            this.eIW = h.a(this.context, this.context.getString(a$j.bind_qq_verify_alert_wrong), this.context.getString(a$j.app_tip), new 4(this), null);
                            return;
                        default:
                            eV = com.tencent.mm.h.a.eV(str);
                            if (eV != null) {
                                eV.a(this.context, null, null);
                                return;
                            }
                            return;
                    }
                }
                eV = com.tencent.mm.h.a.eV(str);
                if (eV != null) {
                    eV.a(this.context, null, null);
                }
            }
        }
    }
}
