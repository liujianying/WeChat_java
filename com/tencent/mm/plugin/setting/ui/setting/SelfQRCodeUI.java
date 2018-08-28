package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ac.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class SelfQRCodeUI extends MMActivity implements e {
    private static final String mQx = (h.getExternalStorageDirectory().toString() + "/Pictures/Screenshots/");
    private Bitmap dHf = null;
    private ProgressDialog eHw = null;
    private ImageView gmn = null;
    private long hXx;
    private TextView hrt = null;
    private ImageView mPI = null;
    private byte[] mPJ = null;
    private TextView mQu = null;
    private boolean mQv = false;
    private a mQw;
    private String userName = "";

    static /* synthetic */ void b(SelfQRCodeUI selfQRCodeUI) {
        d dVar = new d(selfQRCodeUI, 1, false);
        dVar.ofp = new 6(selfQRCodeUI);
        dVar.ofq = new 7(selfQRCodeUI);
        dVar.bXO();
    }

    static /* synthetic */ void e(SelfQRCodeUI selfQRCodeUI) {
        byte[] toByteArray;
        Throwable e;
        if (s.fq(selfQRCodeUI.userName) || f.kM(selfQRCodeUI.userName)) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(219, 10, 1, true);
            Bitmap dk = c.dk(selfQRCodeUI.findViewById(a.f.qrcode_container));
            if (dk != null) {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                dk.compress(CompressFormat.PNG, 90, byteArrayOutputStream);
                toByteArray = byteArrayOutputStream.toByteArray();
            } else {
                toByteArray = null;
            }
            if (toByteArray == null) {
                toByteArray = selfQRCodeUI.mPJ;
            }
        } else {
            toByteArray = selfQRCodeUI.mPJ;
        }
        if (toByteArray != null && toByteArray.length > 0) {
            String str = l.cfw() + "mmqrcode" + System.currentTimeMillis() + ".png";
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    fileOutputStream.write(toByteArray);
                    Toast.makeText(selfQRCodeUI, selfQRCodeUI.getString(i.cropimage_saved, new Object[]{l.cfw()}), 1).show();
                    l.a(str, selfQRCodeUI);
                    try {
                        fileOutputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.SelfQRCodeNewUI", e, "", new Object[0]);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
                x.printErrStackTrace("MicroMsg.SelfQRCodeNewUI", e, "", new Object[0]);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e42) {
                    }
                }
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e52) {
                    }
                }
                throw e;
            }
        }
    }

    protected final int getLayoutId() {
        return g.self_qrcode;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cqh();
        this.mQw = new a(this, this);
        this.mQw.start();
        com.tencent.mm.kernel.g.DF().a(168, this);
        initView();
        this.mPI.post(new 1(this));
    }

    public void onDestroy() {
        com.tencent.mm.kernel.g.DF().b(168, this);
        if (this.mQw != null) {
            this.mQw.stop();
        }
        if (!(this.dHf == null || this.dHf.isRecycled())) {
            this.dHf.recycle();
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        if (!s.fq(this.userName) && !f.kM(this.userName)) {
            View findViewById = findViewById(a.f.self_qrcode_verify_open_prompt);
            this.hXx = q.GK();
            x.d("MicroMsg.SelfQRCodeNewUI", (this.hXx & 2) + ",extstatus:" + this.hXx);
            if ((this.hXx & 2) != 0) {
                findViewById.setVisibility(0);
                this.mPI.setAlpha(0.1f);
                findViewById(a.f.self_qrcode_verify_openBt).setOnClickListener(new 4(this));
                return;
            }
            findViewById.setVisibility(8);
            this.mPI.setAlpha(1.0f);
        }
    }

    protected final void initView() {
        this.userName = getIntent().getStringExtra("from_userName");
        if (bi.oW(this.userName)) {
            this.userName = q.GF();
        }
        if (q.GF().equals(this.userName)) {
            this.mQv = true;
        }
        if (s.fq(this.userName)) {
            setMMTitle(i.settings_room_qrcode_card);
            ((TextView) findViewById(a.f.qrcode_tip)).setText("");
            enableOptionMenu(false);
        } else if (f.kM(this.userName)) {
            setMMTitle(i.enterprise_qrcode);
            ((TextView) findViewById(a.f.qrcode_tip)).setText(i.enterprise_qrcode_tip);
            enableOptionMenu(false);
        } else {
            setMMTitle(i.settings_qrcode_card);
        }
        this.mPI = (ImageView) findViewById(a.f.self_qrcode_iv);
        this.gmn = (ImageView) findViewById(a.f.header_icon);
        this.hrt = (TextView) findViewById(a.f.nick_name);
        this.mQu = (TextView) findViewById(a.f.district);
        CharSequence charSequence;
        if (!s.fq(this.userName) && !f.kM(this.userName)) {
            String str = (String) com.tencent.mm.kernel.g.Ei().DT().get(42, null);
            String string = getString(i.app_field_username);
            if (bi.oW(str)) {
                str = (String) com.tencent.mm.kernel.g.Ei().DT().get(2, null);
                string = string + str;
                ab.XT(str);
                str = string;
            } else {
                str = string + str;
            }
            x.d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", new Object[]{str});
            if (this.dHf == null) {
                x.d("MicroMsg.SelfQRCodeNewUI", "%s", new Object[]{"bitmap == null"});
                vL(1);
            } else {
                this.mPI.setImageBitmap(this.dHf);
            }
            b.a(this.gmn, q.GF());
            x.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", new Object[]{(String) com.tencent.mm.kernel.g.Ei().DT().get(4, null)});
            this.hrt.setText(j.a(this, str, com.tencent.mm.bp.a.ad(this.mController.tml, a.d.HintTextSize)));
            bl IC = bl.IC();
            string = bi.oV(IC.getProvince());
            x.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", new Object[]{r.gV(string) + " " + bi.oV(IC.getCity())});
            this.mQu.setText(charSequence);
            switch (bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(12290, null), 0)) {
                case 1:
                    this.hrt.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bp.a.f(this, a.h.ic_sex_male), null);
                    break;
                case 2:
                    this.hrt.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bp.a.f(this, a.h.ic_sex_female), null);
                    break;
            }
        }
        vL(1);
        b.a(this.gmn, this.userName);
        ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(this.userName);
        this.hrt.setSingleLine(false);
        this.hrt.setMaxLines(3);
        this.hrt.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        if (Yg != null) {
            charSequence = Yg.field_nickname;
            if (bi.oW(charSequence)) {
                charSequence = ((com.tencent.mm.plugin.chatroom.b.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.chatroom.b.b.class)).Ga().ii(this.userName).field_displayname;
            }
            this.hrt.setText(j.a(this, charSequence, this.hrt.getTextSize()));
        } else {
            this.hrt.setVisibility(8);
        }
        this.mQu.setVisibility(8);
        addIconOptionMenu(0, a.e.mm_title_btn_menu, new 2(this));
        setBackBtn(new 3(this));
    }

    private void vL(int i) {
        int f;
        if (this.mQv) {
            f = bi.f((Integer) com.tencent.mm.kernel.g.Ei().DT().get(66561, null));
        } else {
            f = 0;
        }
        com.tencent.mm.as.a aVar = new com.tencent.mm.as.a(this.userName, f, i);
        com.tencent.mm.kernel.g.DF().a(aVar, 0);
        ActionBarActivity actionBarActivity = this.mController.tml;
        getString(i.app_tip);
        this.eHw = com.tencent.mm.ui.base.h.a(actionBarActivity, getString(i.self_qrcode_getting), true, new 5(this, aVar));
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        com.tencent.mm.as.a aVar = (com.tencent.mm.as.a) lVar;
        if (lVar.getType() == 168 && !com.tencent.mm.plugin.setting.b.ezo.b(this.mController.tml, i, i2, str)) {
            if (i == 0 && i2 == 0) {
                this.mPJ = aVar.edg;
                this.dHf = c.bs(this.mPJ);
                if (s.fq(this.userName) || f.kM(this.userName)) {
                    enableOptionMenu(true);
                    CharSequence charSequence = aVar.ede;
                    if (!bi.oW(charSequence)) {
                        ((TextView) findViewById(a.f.qrcode_tip)).setText(charSequence);
                    }
                } else if (this.mQv) {
                    CharSequence charSequence2 = aVar.edf;
                    TextView textView = (TextView) findViewById(a.f.tips_banner_tv);
                    View view = (View) textView.getParent();
                    if (bi.oW(charSequence2)) {
                        view.setVisibility(8);
                    } else {
                        textView.setText(charSequence2);
                        view.setOnClickListener(new 9(this));
                        view.setVisibility(0);
                    }
                }
                this.mPI.setImageBitmap(this.dHf);
                return;
            }
            Toast.makeText(this, getString(i.fmt_self_qrcode_getting_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }

    public static void btv() {
        com.tencent.mm.plugin.report.service.h.mEJ.a(219, 14, 1, true);
    }
}
