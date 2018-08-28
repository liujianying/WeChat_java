package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.aq.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.r;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements e, com.tencent.mm.pluginsdk.b.a, b {
    private static boolean lBG = true;
    private Context context;
    private f eOE;
    private ab guS;
    private c lBD;
    private View lBE;
    private CheckBox lBF;
    private com.tencent.mm.ui.widget.a.c lBH = null;
    private p tipDialog;

    public a(Context context) {
        this.context = context;
        this.lBE = View.inflate(context, R.i.lbs_open_dialog_view, null);
        this.lBF = (CheckBox) this.lBE.findViewById(R.h.lbs_open_dialog_cb);
        this.lBF.setChecked(false);
        au.DF().a(148, this);
    }

    public final boolean wX(String str) {
        x.d("MicroMsg.ContactWidgetLBS", "handleEvent : key = " + str);
        if (bi.oV(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_lbs_go_lbs")) {
            au.HU();
            Boolean bool = (Boolean) com.tencent.mm.model.c.DT().get(4103, null);
            if (bool == null || !bool.booleanValue()) {
                d.A(this.context, "nearby", ".ui.NearbyFriendsIntroUI");
            } else {
                bl ID = bl.ID();
                if (ID == null) {
                    d.A(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
                } else {
                    String oV = bi.oV(ID.getProvince());
                    String oV2 = bi.oV(ID.getCity());
                    int i = ID.sex;
                    if (oV.equals("") || oV2.equals("") || i == 0) {
                        d.A(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
                    } else {
                        au.HU();
                        bool = (Boolean) com.tencent.mm.model.c.DT().get(4104, null);
                        if (bool == null || !bool.booleanValue()) {
                            com.tencent.mm.be.a.eF(this.context);
                            ((Activity) this.context).finish();
                        } else if (this.lBH == null) {
                            this.lBH = h.a(this.context, this.context.getString(R.l.app_tip), this.lBE, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    au.HU();
                                    com.tencent.mm.model.c.DT().set(4104, Boolean.valueOf(!a.this.lBF.isChecked()));
                                    com.tencent.mm.be.a.eF(a.this.context);
                                    ((Activity) a.this.context).finish();
                                }
                            }, new 3(this));
                        } else {
                            this.lBH.show();
                        }
                    }
                }
            }
            return true;
        } else if (str.equals("contact_info_lbs_install")) {
            m(this.context, true);
            return true;
        } else if (str.equals("contact_info_lbs_clear_info")) {
            h.a(this.context, R.l.nearby_friend_clear_location_exit_hint, R.l.nearby_friend_clear_location_exit, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    a.this.lBD = new c(2, 0.0f, 0.0f, 0, 0, "", "");
                    au.DF().a(a.this.lBD, 0);
                    a aVar = a.this;
                    Context a = a.this.context;
                    a.this.context.getString(R.l.app_tip);
                    aVar.tipDialog = h.a(a, a.this.context.getString(R.l.nearby_friend_clearing_location), true, new 1(this));
                }
            }, new 5(this));
            return true;
        } else if (str.equals("contact_info_lbs_uninstall")) {
            h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new 1(this), null);
            return true;
        } else {
            x.e("MicroMsg.ContactWidgetLBS", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(f fVar, ab abVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (abVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(s.hs(abVar.field_username));
        au.HU();
        com.tencent.mm.model.c.DT().a(this);
        x.v("MicroMsg.ContactWidgetLBS", "listener added");
        this.guS = abVar;
        this.eOE = fVar;
        lBG = true;
        fVar.addPreferencesFromResource(R.o.contact_info_pref_lbs);
        auv();
        return true;
    }

    private void auv() {
        int i;
        boolean z;
        boolean z2 = true;
        boolean z3 = (q.GQ() & 512) == 0;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.eOE.ZZ("contact_info_header_helper");
        helperHeaderPreference.an(this.guS.field_username, this.guS.BL(), this.context.getString(R.l.contact_info_lbs_tip));
        if (z3) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.nw(i);
        this.eOE.bw("contact_info_lbs_install", z3);
        f fVar = this.eOE;
        String str = "contact_info_lbs_go_lbs";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.bw(str, z);
        fVar = this.eOE;
        str = "contact_info_lbs_clear_info";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.bw(str, z);
        f fVar2 = this.eOE;
        String str2 = "contact_info_lbs_uninstall";
        if (z3) {
            z2 = false;
        }
        fVar2.bw(str2, z2);
    }

    public static void m(Context context, final boolean z) {
        String string = z ? context.getString(R.l.settings_plugins_installing) : context.getString(R.l.settings_plugins_uninstalling);
        lBG = z;
        context.getString(R.l.app_tip);
        final p a = h.a(context, string, true, null);
        final AnonymousClass6 anonymousClass6 = new ag() {
            final /* synthetic */ r hlE = null;

            public final void handleMessage(Message message) {
                int i;
                int GQ = q.GQ();
                if (z) {
                    i = GQ & -513;
                } else {
                    i = GQ | 512;
                }
                au.HU();
                com.tencent.mm.model.c.DT().set(34, Integer.valueOf(i));
                au.HU();
                com.tencent.mm.model.c.FQ().b(new l("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    com.tencent.mm.az.d.SG().aPm();
                    au.DF().a(new c(2, 0.0f, 0.0f, 0, 0, "", ""), 0);
                }
                if (this.hlE != null) {
                    this.hlE.a(null, null);
                }
            }
        };
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass6.sendEmptyMessage(0);
                }
            }
        }, 1500);
    }

    public final boolean auw() {
        au.HU();
        com.tencent.mm.model.c.DT().b(this);
        au.DF().b(148, this);
        com.tencent.mm.plugin.nearby.a.ezo.vl();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        x.d("MicroMsg.ContactWidgetLBS", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(p), mVar});
        au.HU();
        if (mVar != com.tencent.mm.model.c.DT() || p <= 0) {
            x.e("MicroMsg.ContactWidgetLBS", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(p), mVar});
        } else if (p == 40 || p == 34 || p == 7) {
            auv();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (this.lBD != null || ((c) lVar).Oh() != 2) {
            x.i("MicroMsg.ContactWidgetLBS", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
            if (lVar.getType() == 148) {
                int i3;
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                if (i == 0 && i2 == 0) {
                    i3 = R.l.nearby_friend_clear_location_ok;
                } else {
                    i3 = R.l.nearby_friend_clear_location_failed;
                }
                if (((c) lVar).Oh() == 2 && lBG) {
                    h.a(this.context, i3, R.l.app_tip, new 8(this));
                    this.lBD = null;
                }
            }
        }
    }
}
