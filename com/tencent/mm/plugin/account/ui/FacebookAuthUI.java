package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.aq.h;
import com.tencent.mm.aq.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.account.a$k;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.f.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacebookAuthUI extends MMPreference implements e {
    public static final String[] eQb = new String[]{"publish_actions", "email"};
    private f eOE;
    private c eOa;
    private ProgressDialog ePA;
    private OnCancelListener ePB;
    private v ePC;
    private boolean eQc = false;
    private boolean eQd = false;
    private final Map<String, Preference> eQe = new HashMap();
    private com.tencent.mm.sdk.b.c eQf = new 1(this);

    static /* synthetic */ void cm(boolean z) {
        List arrayList = new ArrayList();
        arrayList.add(new a(32, z ? "0" : "1"));
        ((i) g.l(i.class)).FQ().b(new h(arrayList));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eOE = this.tCL;
        initView();
    }

    protected void onResume() {
        com.tencent.mm.sdk.b.a.sFg.b(this.eQf);
        super.onResume();
        g.DF().a(183, this);
        g.DF().a(254, this);
        Yv();
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.sFg.c(this.eQf);
        g.DF().b(183, this);
        g.DF().b(254, this);
    }

    public final int Ys() {
        return a$k.facebook_auth;
    }

    protected final void initView() {
        this.eQc = getIntent().getBooleanExtra("is_force_unbind", false);
        this.eOa = new c("290293790992170");
        this.ePB = new 3(this);
        this.eOE.addPreferencesFromResource(a$k.facebook_auth);
        Preference ZZ = this.eOE.ZZ("facebook_auth_tip");
        if (ZZ != null) {
            this.eQe.put("facebook_auth_tip", ZZ);
        }
        ZZ = this.eOE.ZZ("facebook_auth_cat");
        if (ZZ != null) {
            this.eQe.put("facebook_auth_cat", ZZ);
        }
        ZZ = this.eOE.ZZ("facebook_auth_bind_btn");
        if (ZZ != null) {
            this.eQe.put("facebook_auth_bind_btn", ZZ);
        }
        ZZ = this.eOE.ZZ("facebook_auth_account");
        if (ZZ != null) {
            this.eQe.put("facebook_auth_account", ZZ);
        }
        ZZ = this.eOE.ZZ("facebook_auth_cat2");
        if (ZZ != null) {
            this.eQe.put("facebook_auth_cat2", ZZ);
        }
        ZZ = this.eOE.ZZ("facebook_auth_unbind_btn");
        if (ZZ != null) {
            this.eQe.put("facebook_auth_unbind_btn", ZZ);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = FacebookAuthUI.this.getIntent();
                intent.putExtra("bind_facebook_succ", FacebookAuthUI.this.eQd);
                FacebookAuthUI.this.setResult(-1, intent);
                FacebookAuthUI.this.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        if (str == null) {
            x.e("MicroMsg.FacebookAuthUI", "onPreferenceTreeClick, key is null");
            return true;
        } else if (str.equals("facebook_auth_bind_btn")) {
            try {
                this.eOa.gY(this);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FacebookAuthUI", e, "", new Object[0]);
            }
            this.eOa = new c("290293790992170");
            this.eOa.a(this, eQb, new a(this, (byte) 0));
            return true;
        } else if (!str.equals("facebook_auth_unbind_btn")) {
            return false;
        } else {
            com.tencent.mm.ui.base.h.a(this, j.facebook_auth_unbind_alert_tip, j.app_tip, new 5(this), new 6(this));
            return true;
        }
    }

    private void Yv() {
        Preference preference;
        this.eOE.removeAll();
        boolean Hg = this.eQc ? false : q.Hg();
        if (this.eQe.containsKey("facebook_auth_tip")) {
            preference = (Preference) this.eQe.get("facebook_auth_tip");
            preference.setTitle(Hg ? j.facebook_auth_unbind_tip : j.facebook_auth_bind_tip);
            this.eOE.a(preference);
        }
        if (this.eQe.containsKey("facebook_auth_cat")) {
            this.eOE.a((Preference) this.eQe.get("facebook_auth_cat"));
        }
        if (Hg) {
            if (this.eQe.containsKey("facebook_auth_account")) {
                preference = (Preference) this.eQe.get("facebook_auth_account");
                preference.setTitle(getString(j.facebook_auth_bound_account) + g.Ei().DT().get(65826, null));
                this.eOE.a(preference);
            }
            if (this.eQe.containsKey("facebook_auth_cat2")) {
                this.eOE.a((Preference) this.eQe.get("facebook_auth_cat2"));
            }
            if (this.eQe.containsKey("facebook_auth_unbind_btn")) {
                this.eOE.a((Preference) this.eQe.get("facebook_auth_unbind_btn"));
            }
        } else if (this.eQe.containsKey("facebook_auth_bind_btn")) {
            this.eOE.a((Preference) this.eQe.get("facebook_auth_bind_btn"));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = "MicroMsg.FacebookAuthUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.i(str, str2, objArr);
        if (i2 == -1 && i == 1024 && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.FacebookAuthUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(bi.oW(stringExtra));
            objArr2[1] = Integer.valueOf(bi.oW(stringExtra) ? 0 : stringExtra.length());
            objArr2[2] = Integer.valueOf(intExtra);
            x.i(str2, str3, objArr2);
            if (intExtra == -217) {
                try {
                    this.eOa.gY(this);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FacebookAuthUI", e, "", new Object[0]);
                }
                this.eOa = new c("290293790992170");
                this.eOa.a(this, eQb, new a(this, (byte) 0));
                return;
            }
        }
        this.eOa.g(i, i2, intent);
    }

    public final void a(int i, int i2, String str, l lVar) {
        com.tencent.mm.h.a eV;
        if (lVar.getType() == 254) {
            if (i == 0 && i2 == 0) {
                this.ePC = new v(0, "");
                g.DF().a(this.ePC, 0);
                return;
            }
            if (this.ePA != null) {
                this.ePA.dismiss();
            }
            if (i2 == -82) {
                com.tencent.mm.ui.base.h.a(this, j.setting_unbind_qq_err_one_left, j.app_tip, new 7(this));
            } else if (i2 == -83) {
                com.tencent.mm.ui.base.h.a(this, j.setting_unbind_qq_err_has_unbind, j.app_tip, new 8(this));
            } else if (i2 == -84) {
                com.tencent.mm.ui.base.h.a(this, j.setting_unbind_qq_err_hasbinded, j.app_tip, new 9(this));
            } else if (i2 == -85) {
                com.tencent.mm.ui.base.h.a(this, j.setting_unbind_qq_err_bindedbyother, j.app_tip, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -86) {
                com.tencent.mm.ui.base.h.a(this, j.setting_unbind_qq_err_qmail, j.app_tip, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -106) {
                aa.e(this, str, 0);
            } else if (i2 == -217) {
                aa.a(this, com.tencent.mm.platformtools.f.a((com.tencent.mm.modelsimple.q) lVar), i2);
            } else {
                eV = com.tencent.mm.h.a.eV(str);
                if (eV != null) {
                    eV.a(this, null, null);
                }
            }
        } else if (lVar.getType() == 183) {
            if (this.ePA != null) {
                this.ePA.dismiss();
            }
            int i3 = ((v) lVar).opType;
            if (i == 0 && i2 == 0) {
                Toast.makeText(this, i3 == 0 ? j.contact_info_facebookapp_unbind_success : j.contact_info_facebookapp_bind_success, 1).show();
                this.eQc = false;
                Yv();
                if (i3 == 1) {
                    ((i) g.l(i.class)).FW().Yp("facebookapp");
                    ((i) g.l(i.class)).bcY().GK("facebookapp");
                    this.eQd = true;
                }
            } else if (i == 4 && i2 == -67) {
                Toast.makeText(this, j.facebook_auth_have_bind_facebook, 1).show();
            } else if (i == 4 && i2 == -5) {
                Toast.makeText(this, i3 == 1 ? j.facebook_auth_bind_access_denied : j.facebook_auth_unbind_access_denied, 1).show();
            } else if (i2 == -106) {
                aa.e(this, str, 0);
            } else {
                eV = com.tencent.mm.h.a.eV(str);
                if (eV != null) {
                    eV.a(this, null, null);
                } else {
                    Toast.makeText(this, i3 == 0 ? j.contact_info_facebookapp_unbind_fail : j.contact_info_facebookapp_bind_fail, 1).show();
                }
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Intent intent = getIntent();
            intent.putExtra("bind_facebook_succ", this.eQd);
            setResult(-1, intent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
