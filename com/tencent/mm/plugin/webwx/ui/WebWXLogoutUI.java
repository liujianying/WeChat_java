package com.tencent.mm.plugin.webwx.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.k.f;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.webwx.a.b;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class WebWXLogoutUI extends MMActivity implements e, aq {
    private boolean hsJ;
    private ProgressDialog mQY = null;
    private c nqB = new 9(this);
    private Animator qmA;
    private int qmB;
    private boolean qmn = false;
    private boolean qmt;
    private ImageButton qmu;
    private ImageButton qmv;
    private ImageView qmw;
    private int qmx;
    private int qmy;
    private int qmz;

    static /* synthetic */ boolean b(WebWXLogoutUI webWXLogoutUI) {
        if (!au.HX()) {
            return false;
        }
        int GL = q.GL();
        GL = webWXLogoutUI.qmt ? GL | 8192 : GL & -8193;
        f.fV(GL);
        au.HU();
        com.tencent.mm.model.c.DT().set(40, Integer.valueOf(GL));
        webWXLogoutUI.qmn = true;
        webWXLogoutUI.anw();
        return true;
    }

    static /* synthetic */ void e(WebWXLogoutUI webWXLogoutUI) {
        if (webWXLogoutUI.hsJ) {
            au.DF().a(new b(2), 0);
            x.d("MicroMsg.WebWXLogoutUI", "doScene netSceneExtDeviceControl : UNLOCK");
            return;
        }
        au.DF().a(new b(1), 0);
        x.d("MicroMsg.WebWXLogoutUI", "doScene netSceneExtDeviceControl : LOCK");
    }

    static /* synthetic */ boolean f(WebWXLogoutUI webWXLogoutUI) {
        if (webWXLogoutUI.qmB == l.QZ()) {
            h.a(webWXLogoutUI.mController.tml, l.efB, webWXLogoutUI.getString(R.l.app_tip), webWXLogoutUI.getString(R.l.webwx_logout_dialog_txt), webWXLogoutUI.getString(R.l.app_cancel), new 8(webWXLogoutUI), null);
        } else {
            webWXLogoutUI.finish();
        }
        return true;
    }

    static /* synthetic */ int g(WebWXLogoutUI webWXLogoutUI) {
        int[] iArr = new int[2];
        View findViewById = webWXLogoutUI.findViewById(R.h.webwx_logout_action_bar);
        int height = findViewById.getHeight();
        findViewById.getLocationInWindow(iArr);
        int i = iArr[1];
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            webWXLogoutUI.getWindowManager().getDefaultDisplay().getRealSize(point);
        } else {
            webWXLogoutUI.getWindowManager().getDefaultDisplay().getSize(point);
        }
        x.d("MicroMsg.WebWXLogoutUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", Integer.valueOf(i), Integer.valueOf(point.y), Integer.valueOf(height));
        return (((int) (((double) point.y) / 4.0d)) - i) - height;
    }

    protected final int getLayoutId() {
        return R.i.webwxlogout;
    }

    public void finish() {
        super.a();
        overridePendingTransition(R.a.anim_not_change, R.a.push_down_out);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        if (getIntent() != null) {
            this.qmB = getIntent().getIntExtra("intent.key.online_version", 0);
        }
        initView();
        overridePendingTransition(R.a.push_up_in, R.a.anim_not_change);
        au.DF().a(281, (e) this);
        au.DF().a(792, (e) this);
        au.HU();
        com.tencent.mm.model.c.a(this);
        com.tencent.mm.sdk.b.a.sFg.b(this.nqB);
    }

    protected void onPause() {
        super.onPause();
        if (this.qmn && au.HX()) {
            xt xtVar = new xt();
            xtVar.rDz = 27;
            xtVar.rDA = q.gT(q.GL()) ? 1 : 2;
            au.HU();
            com.tencent.mm.model.c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(23, xtVar));
            this.qmn = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        overridePendingTransition(R.a.anim_not_change, R.a.push_down_out);
        au.DF().b(281, (e) this);
        au.DF().b(792, (e) this);
        au.HU();
        com.tencent.mm.model.c.b(this);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqB);
    }

    protected final void initView() {
        setMMTitle("");
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(an.n(getResources().getColor(R.e.statusbar_fg_color), this.mController.cqm()));
        }
        if (f.Aj()) {
            this.qmv = (ImageButton) findViewById(R.h.webwx_close_notify);
            if (q.gT(q.GL())) {
                this.qmt = true;
            } else {
                this.qmt = false;
            }
            kp(this.qmt);
            this.qmv.setOnClickListener(new 1(this));
        } else {
            findViewById(R.h.closeNotiBt_layout).setVisibility(8);
            this.qmt = false;
        }
        this.qmw = (ImageView) findViewById(R.h.status_icon);
        x.d("MicroMsg.WebWXLogoutUI", "need hide lock bt ?: " + l.Ra());
        if (l.Ra()) {
            findViewById(R.h.lockBt_layout).setVisibility(8);
        } else {
            Animator loadAnimator = AnimatorInflater.loadAnimator(this, R.b.fade_in_property_anim);
            loadAnimator.setTarget(findViewById(R.h.webwx_lock_progress));
            this.qmA = AnimatorInflater.loadAnimator(this, R.b.fade_out_property_anim);
            this.qmA.setTarget(findViewById(R.h.webwx_lock_progress));
            this.qmA.addListener(new 2(this));
            this.hsJ = l.QY();
            this.qmu = (ImageButton) findViewById(R.h.webwx_lock);
            ko(this.hsJ);
            this.qmu.setOnClickListener(new 3(this, loadAnimator));
        }
        ImageButton imageButton = (ImageButton) findViewById(R.h.webwx_file_transfer);
        x.d("MicroMsg.WebWXLogoutUI", "need hide file bt ?: " + l.Rb());
        if (l.Rb()) {
            imageButton.setVisibility(8);
        } else {
            imageButton.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", "filehelper");
                    intent.putExtra("key_show_bottom_app_panel", true);
                    com.tencent.mm.plugin.webwx.a.ezn.e(intent, WebWXLogoutUI.this);
                    x.d("MicroMsg.WebWXLogoutUI", "clicked file transfer bt, start filehelper");
                    WebWXLogoutUI.this.finish();
                }
            });
        }
        Button button = (Button) findViewById(R.h.webwx_logout_bt);
        button.setText(l.efE);
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.d("MicroMsg.WebWXLogoutUI", "logout webwx");
                WebWXLogoutUI.f(WebWXLogoutUI.this);
            }
        });
        ((TextView) findViewById(R.h.webwx_logout_closeBt)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WebWXLogoutUI.this.finish();
            }
        });
        Drawable drawable;
        Drawable drawable2;
        if (l.QW() == 1) {
            drawable = getResources().getDrawable(R.k.connect_pc);
            drawable2 = getResources().getDrawable(R.k.connect_pc_mute);
            if (!(drawable == null || drawable2 == null)) {
                this.qmx = drawable.getIntrinsicWidth();
                this.qmy = drawable2.getIntrinsicWidth();
            }
        } else if (l.QW() == 2) {
            drawable = getResources().getDrawable(R.k.connect_mac);
            drawable2 = getResources().getDrawable(R.k.connect_mac_mute);
            if (!(drawable == null || drawable2 == null)) {
                this.qmx = drawable.getIntrinsicWidth();
                this.qmy = drawable2.getIntrinsicWidth();
            }
        }
        this.qmw.post(new 7(this));
    }

    private void anw() {
        if (!bi.oW(l.efw)) {
            ((TextView) findViewById(R.h.status_desc)).setText(l.efw);
            if (l.QW() == 1) {
                if (!this.qmt) {
                    this.qmw.setImageResource(R.k.connect_pc_mute);
                    this.qmw.setPadding(this.qmy - this.qmx, this.qmz, 0, 0);
                    return;
                }
            } else if (l.QW() == 2) {
                if (this.qmt) {
                    ((TextView) findViewById(R.h.prompt_desc)).setText(R.l.webwx_open_notify_prompt);
                } else if (!f.Aj()) {
                    ((TextView) findViewById(R.h.prompt_desc)).setText("");
                }
                if (this.hsJ) {
                    ((TextView) findViewById(R.h.status_desc)).setText(getString(R.l.webwx_lock_desc, new Object[]{"Mac"}));
                    this.qmw.setImageResource(R.k.connect_mac_lock);
                    this.qmw.setPadding(0, this.qmz, 0, 0);
                    if (f.Aj() && !this.qmt) {
                        ((TextView) findViewById(R.h.prompt_desc)).setText(R.l.webwx_close_notify_prompt);
                        this.qmw.setImageResource(R.k.connect_mac_mute_lock);
                        this.qmw.setPadding(this.qmy - this.qmx, this.qmz, 0, 0);
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.h.status_desc)).setText(getString(R.l.webwx_login_desc, new Object[]{"Mac"}));
                this.qmw.setImageResource(R.k.connect_mac);
                this.qmw.setPadding(0, this.qmz, 0, 0);
                if (f.Aj() && !this.qmt) {
                    ((TextView) findViewById(R.h.prompt_desc)).setText(R.l.webwx_close_notify_prompt);
                    this.qmw.setImageResource(R.k.connect_mac_mute);
                    this.qmw.setPadding(this.qmy - this.qmx, this.qmz, 0, 0);
                    return;
                }
                return;
            } else if (l.QW() == 3) {
                this.qmw.setImageResource(R.k.connect_ipad);
                this.qmw.setPadding(0, this.qmz, 0, 0);
                return;
            }
            this.qmw.setImageResource(R.k.connect_pc);
            this.qmw.setPadding(0, this.qmz, 0, 0);
        }
    }

    private void ko(boolean z) {
        if (this.qmu == null) {
            return;
        }
        if (z) {
            this.qmu.setImageResource(R.g.webwx_unlock_bt);
            ((TextView) findViewById(R.h.webwx_lockBt_txt)).setText(R.l.webwx_unlock);
            return;
        }
        this.qmu.setImageResource(R.g.webwx_lock_bt);
        ((TextView) findViewById(R.h.webwx_lockBt_txt)).setText(R.l.webwx_lock);
    }

    private void kp(boolean z) {
        if (this.qmv == null) {
            return;
        }
        if (z) {
            this.qmv.setImageResource(R.g.webwx_close_notify_bt);
        } else {
            this.qmv.setImageResource(R.g.webwx_open_notify_bt);
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (this.mQY != null) {
            this.mQY.dismiss();
            this.mQY = null;
        }
        if (lVar.getType() == 281) {
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this, R.l.webwx_logout_error_txt, 1).show();
            }
            finish();
        } else if (lVar.getType() == 792) {
            int i3 = ((b) lVar).bNI;
            if (this.qmA != null) {
                this.qmA.start();
            }
            if (i == 0 && i2 == 0) {
                boolean z;
                if (i3 == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.hsJ = z;
                l.bO(this.hsJ);
                anw();
                String str2 = "MicroMsg.WebWXLogoutUI";
                String str3 = "%s extDevice success";
                Object[] objArr = new Object[1];
                objArr[0] = this.hsJ ? "lock" : "unlock";
                x.d(str2, str3, objArr);
            } else if (i3 == 1) {
                Toast.makeText(this, R.l.webwx_lock_error_txt, 0).show();
            } else {
                Toast.makeText(this, R.l.webwx_unlock_error_txt, 0).show();
            }
        }
    }

    public final void HK() {
        au.HU();
        if (!com.tencent.mm.model.c.FM()) {
            finish();
        } else if (l.QY() && !this.hsJ) {
            x.d("MicroMsg.WebWXLogoutUI", "extDevice remote lock");
            this.hsJ = true;
            ko(this.hsJ);
            anw();
        }
    }
}
