package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelmulti.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.i.a.a;
import com.tencent.mm.ui.i.a.b;
import com.tencent.mm.ui.i.a.c;
import java.io.RandomAccessFile;

public class InviteFriendsBy3rdUI extends MMPreference implements e, a, b {
    private static int otA = 2;
    private static int otB = 3;
    private static int otC = 4;
    private static int otD = 5;
    private static int otE = 0;
    private static int otF = 1;
    private static int otz = 1;
    private ProgressDialog eHw = null;
    private int fromScene;
    private ProgressBar jfO = null;
    private ProgressDialog kxR = null;
    private com.tencent.mm.ui.i.a ogE = new com.tencent.mm.ui.i.a();
    private int otG = 0;
    private Bitmap otH = null;
    private View otI;
    private ImageView otJ = null;
    private EditText otK = null;
    private boolean otL = false;
    private boolean otM = false;

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI$3 */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] kyp = new int[c.values().length];

        static {
            try {
                kyp[c.uFl.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kyp[c.uFn.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kyp[c.uFm.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    static /* synthetic */ void a(InviteFriendsBy3rdUI inviteFriendsBy3rdUI, int i, String str) {
        h hVar = new h(i, str);
        inviteFriendsBy3rdUI.getString(R.l.app_tip);
        inviteFriendsBy3rdUI.eHw = com.tencent.mm.ui.base.h.a((Context) inviteFriendsBy3rdUI, inviteFriendsBy3rdUI.getString(R.l.app_sending), true, new 9(inviteFriendsBy3rdUI, hVar));
        au.DF().a(hVar, 0);
    }

    public final int Ys() {
        return R.o.invate_friends_by_3rd;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.find_friends_by_invite_friend);
        this.fromScene = getIntent().getIntExtra("Invite_friends", 4);
        int i = bi.getInt(g.AT().getValue("InviteFriendsInviteFlags"), 0);
        com.tencent.mm.ui.base.preference.h hVar = this.tCL;
        if ((i & 2) <= 0) {
            hVar.aaa("invite_friends_by_message");
        }
        if ((i & 1) <= 0) {
            hVar.aaa("invite_friends_by_mail");
        }
        if ((i & 4) <= 0 || !au(this.mController.tml, "com.whatsapp")) {
            hVar.aaa("invite_friends_by_whatsapp");
        }
        if ((i & 8) <= 0 || !q.He()) {
            hVar.aaa("invite_friends_by_facebook");
        }
        if ((i & 16) <= 0) {
            hVar.aaa("invite_friends_by_twitter");
        }
        hVar.notifyDataSetChanged();
        au.DF().a(1803, this);
        au.DF().a(1804, this);
        au.DF().a(168, this);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                InviteFriendsBy3rdUI.this.finish();
                return true;
            }
        });
    }

    protected void onDestroy() {
        au.DF().b(1803, this);
        au.DF().b(1804, this);
        au.DF().b(168, this);
        if (this.otG == 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(14035, new Object[]{Integer.valueOf(this.otG), Integer.valueOf(otE), Integer.valueOf(this.fromScene)});
        }
        super.onDestroy();
    }

    public final boolean a(f fVar, Preference preference) {
        if ("invite_friends_by_message".equals(preference.mKey)) {
            this.otG = otA;
            xW(2);
            return true;
        } else if ("invite_friends_by_mail".equals(preference.mKey)) {
            this.otG = otz;
            xW(1);
            return true;
        } else if ("invite_friends_by_whatsapp".equals(preference.mKey)) {
            this.otG = otB;
            xW(4);
            return true;
        } else if ("invite_friends_by_facebook".equals(preference.mKey)) {
            this.otG = otC;
            if (q.Hg()) {
                this.otM = true;
                xW(8);
                return true;
            }
            com.tencent.mm.ui.base.h.a(this.mController.tml, R.l.settings_facebook_notice, R.l.app_tip, new 4(this), new 5(this));
            return true;
        } else if (!"invite_friends_by_twitter".equals(preference.mKey)) {
            return false;
        } else {
            this.otG = otD;
            if (this.ogE.cAo()) {
                this.otL = true;
                xW(16);
                return true;
            }
            com.tencent.mm.ui.base.h.a(this.mController.tml, R.l.settings_twitter_notice, R.l.app_tip, new 6(this), new 7(this));
            return true;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.InviteFriendsBy3rdUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (!(i == 0 && i2 == 0)) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(14035, new Object[]{Integer.valueOf(this.otG), Integer.valueOf(otE), Integer.valueOf(this.fromScene)});
        }
        if (lVar.getType() == 1803) {
            if (i == 0 && i2 == 0) {
                Intent intent;
                com.tencent.mm.modelmulti.e eVar = (com.tencent.mm.modelmulti.e) lVar;
                String str2 = bi.oW(eVar.title) ? null : eVar.title;
                eVar = (com.tencent.mm.modelmulti.e) lVar;
                String str3 = bi.oW(eVar.content) ? null : eVar.content;
                String GG = q.GG();
                au.HU();
                String str4 = (String) com.tencent.mm.model.c.DT().get(6, null);
                if (bi.oW(GG)) {
                    GG = str4;
                }
                int i3 = ((com.tencent.mm.modelmulti.e) lVar).dZg;
                if ((i3 & 1) > 0) {
                    if (bi.oW(str2)) {
                        str2 = String.format(getString(R.l.invite_friends_mail_title), new Object[]{q.GH()});
                    }
                    if (bi.oW(str3)) {
                        str3 = String.format(getString(R.l.invite_friends_mail_content), new Object[]{GG});
                    }
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.putExtra("android.intent.extra.SUBJECT", str2);
                    intent2.putExtra("android.intent.extra.TEXT", str3);
                    intent2.setType("plain/text");
                    startActivity(Intent.createChooser(intent2, getString(R.l.invite_friends_by_mail_select)));
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14035, new Object[]{Integer.valueOf(this.otG), Integer.valueOf(otF), Integer.valueOf(this.fromScene)});
                }
                str4 = str3;
                if ((i3 & 2) > 0) {
                    if (bi.oW(str4)) {
                        str4 = String.format(getString(R.l.invite_friends_message_content), new Object[]{GG});
                    }
                    intent = new Intent("android.intent.action.VIEW");
                    intent.putExtra("sms_body", str4);
                    intent.setType("vnd.android-dir/mms-sms");
                    if (bi.k(this, intent)) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, R.l.selectsmsapp_none, 1).show();
                    }
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14035, new Object[]{Integer.valueOf(this.otG), Integer.valueOf(otF), Integer.valueOf(this.fromScene)});
                }
                if ((i3 & 4) > 0) {
                    if (bi.oW(str4)) {
                        str4 = String.format(getString(R.l.invite_friends_message_content), new Object[]{GG});
                    }
                    intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", str4);
                    intent.setType("text/plain");
                    intent.setPackage("com.whatsapp");
                    startActivity(intent);
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14035, new Object[]{Integer.valueOf(this.otG), Integer.valueOf(otF), Integer.valueOf(this.fromScene)});
                }
                if ((i3 & 8) > 0) {
                    if (bi.oW(str4)) {
                        if (bi.oW(q.GG())) {
                            str4 = getString(R.l.invite_friends_facebook_twitter_no_wechatid_content);
                        } else {
                            str4 = String.format(getString(R.l.invite_friends_facebook_twitter_content), new Object[]{q.GG()});
                        }
                    }
                    str2 = getString(R.l.invite_friends_by_facebook);
                    if (this.otM) {
                        l(i3, str4, str2);
                        this.otM = false;
                    }
                }
                if ((i3 & 16) > 0) {
                    this.ogE.a(this);
                    if (bi.oW(str4)) {
                        if (bi.oW(q.GG())) {
                            str4 = getString(R.l.invite_friends_facebook_twitter_no_wechatid_content);
                        } else {
                            str4 = String.format(getString(R.l.invite_friends_facebook_twitter_content), new Object[]{q.GG()});
                        }
                    }
                    str2 = getString(R.l.invite_friends_by_twitter);
                    if (this.otL) {
                        l(i3, str4, str2);
                        this.otL = false;
                    }
                }
            } else {
                com.tencent.mm.ui.base.h.i(this.mController.tml, R.l.loading_failed, R.l.app_tip);
                return;
            }
        }
        if (lVar.getType() == 1804) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.ui.base.h.bA(this, getResources().getString(R.l.confirm_dialog_sent));
                com.tencent.mm.plugin.report.service.h.mEJ.h(14035, new Object[]{Integer.valueOf(this.otG), Integer.valueOf(otF), Integer.valueOf(this.fromScene)});
            } else {
                com.tencent.mm.ui.base.h.i(this.mController.tml, R.l.sendrequest_send_fail, R.l.app_tip);
                return;
            }
        }
        if (lVar.getType() == 168 && i == 0 && i2 == 0 && this.otJ != null) {
            if (this.jfO != null) {
                this.jfO.setVisibility(8);
            }
            this.otJ.setImageBitmap(aYp());
        }
    }

    private void xW(int i) {
        com.tencent.mm.modelmulti.e eVar = new com.tencent.mm.modelmulti.e(i);
        getString(R.l.app_tip);
        this.eHw = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.loading_tips), true, new 8(this, eVar));
        au.DF().a(eVar, 0);
    }

    private static boolean au(Context context, String str) {
        if (bi.oW(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private void rI(int i) {
        com.tencent.mm.ui.base.h.a(this.mController.tml, i, R.l.app_tip, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }, new 11(this));
    }

    public final void a(c cVar) {
        if (this.kxR != null) {
            this.kxR.cancel();
        }
        switch (AnonymousClass3.kyp[cVar.ordinal()]) {
            case 1:
                rI(R.l.twitterlogin_success);
                return;
            case 3:
                rI(R.l.twitterlogin_failed);
                return;
            default:
                return;
        }
    }

    public final void b(c cVar) {
    }

    private void l(int i, String str, String str2) {
        this.otI = View.inflate(this.mController.tml, R.i.confirm_dialog_item, null);
        this.otK = (EditText) this.otI.findViewById(R.h.confirm_dialog_text_et);
        this.otJ = (ImageView) this.otI.findViewById(R.h.confirm_dialog_imageview);
        this.jfO = (ProgressBar) this.otI.findViewById(R.h.loading_pb);
        ((View) this.otJ.getParent()).setVisibility(8);
        this.otK.setText(str);
        this.otH = aYp();
        if (this.otH == null) {
            String GF = q.GF();
            au.HU();
            au.DF().a(new com.tencent.mm.as.a(GF, bi.f((Integer) com.tencent.mm.model.c.DT().get(66561, null))), 0);
            ((ProgressBar) this.otI.findViewById(R.h.loading_pb)).setVisibility(0);
        } else if (this.otJ != null) {
            this.otJ.setImageBitmap(this.otH);
        }
        com.tencent.mm.pluginsdk.ui.applet.g.a(this.mController, str2, this.otI, getResources().getString(R.l.app_send), new 2(this, str, i));
    }

    private static Bitmap aYp() {
        byte[] Fg = Fg(q.GF());
        if (Fg == null) {
            return null;
        }
        return com.tencent.mm.sdk.platformtools.c.bs(Fg);
    }

    private static byte[] Fg(String str) {
        Throwable e;
        au.HU();
        String Gb = com.tencent.mm.model.c.Gb();
        au.HU();
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(com.tencent.mm.sdk.platformtools.h.f(Gb, com.tencent.mm.model.c.Gc(), "qr_", com.tencent.mm.a.g.u(str.getBytes()), ".png"), "r");
            try {
                byte[] bArr = new byte[((int) randomAccessFile.length())];
                randomAccessFile.read(bArr);
                try {
                    randomAccessFile.close();
                    return bArr;
                } catch (Exception e2) {
                    return bArr;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    x.printErrStackTrace("MicroMsg.InviteFriendsBy3rdUI", e, "", new Object[0]);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e4) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            x.printErrStackTrace("MicroMsg.InviteFriendsBy3rdUI", e, "", new Object[0]);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e42) {
                }
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e52) {
                }
            }
            throw e;
        }
    }
}
