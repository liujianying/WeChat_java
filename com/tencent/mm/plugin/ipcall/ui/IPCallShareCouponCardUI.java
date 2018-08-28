package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.ipcall.a.d.g;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.akc;
import com.tencent.mm.protocal.c.ccm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.i.a.a;
import com.tencent.mm.ui.i.a.b;
import java.io.RandomAccessFile;
import java.util.HashMap;

public class IPCallShareCouponCardUI extends MMActivity implements e, a, b {
    private int BV = 0;
    private String cZG = null;
    private String cZH = null;
    private ProgressDialog eHw = null;
    private View fY;
    private ProgressDialog kuy = null;
    private TextView kxK;
    private TextView kxL;
    private TextView kxM;
    private TextView kxN;
    private Button kxO;
    private ImageView kxP;
    private com.tencent.mm.ui.i.a kxQ = new com.tencent.mm.ui.i.a();
    private ProgressDialog kxR = null;
    private i kxS = null;
    private ImageView kxT = null;
    private ProgressBar kxU = null;
    private com.tencent.mm.plugin.ipcall.a.e.e kxV = new com.tencent.mm.plugin.ipcall.a.e.e();
    private String kxW = null;
    private String kxX = null;
    private String kxY = null;
    private String kxZ = null;
    private String kya = null;
    private String kyb = null;
    private String kyc = null;
    private String kyd = null;
    private String kye = null;
    private ccm kyf = null;
    private String kyg = null;
    private View kyh;

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ipcall_share_coupon_card_title);
        setBackBtn(new 1(this));
        this.fY = findViewById(R.h.layout);
        this.kxK = (TextView) findViewById(R.h.coupon_money_tv);
        this.kxL = (TextView) findViewById(R.h.data_wording_tv);
        this.kxM = (TextView) findViewById(R.h.coupon_big_tips_tv);
        this.kxN = (TextView) findViewById(R.h.coupon_small_tips_tv);
        this.kxO = (Button) findViewById(R.h.share_btn);
        this.kxP = (ImageView) findViewById(R.h.header_icon);
        this.fY.setVisibility(8);
        com.tencent.mm.pluginsdk.ui.a.b.a(this.kxP, q.GF(), 0.5f, false);
        Context context = this.mController.tml;
        getString(R.l.app_tip);
        this.kuy = h.a(context, getString(R.l.ip_call_loading_tip), true, new 9(this));
        com.tencent.mm.plugin.ipcall.a.f.b.aXT().fY(false);
        this.BV = getIntent().getIntExtra("IPCallShareCouponCardUI_KFrom", 0);
        au.DF().a(257, this);
        au.DF().a(1804, this);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(257, this);
        au.DF().b(1804, this);
    }

    protected final int getLayoutId() {
        return R.i.ip_call_coupons_share_ui;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof g) {
            if (i == 0 && i2 == 0) {
                this.fY.setVisibility(0);
                akc aYD = c.aYD();
                if (aYD != null) {
                    this.kxW = aYD.rMH;
                    this.cZG = aYD.jOS;
                    this.kxX = aYD.rMI;
                    this.cZH = aYD.bHD;
                    this.kxY = aYD.ksB;
                    this.kxZ = aYD.rMJ;
                    this.kyb = aYD.rMK;
                    this.kyc = aYD.rML;
                    this.kyd = aYD.rMM;
                    this.kye = aYD.rMO;
                    this.kyf = aYD.rMN;
                    this.kyg = aYD.rMP;
                }
                this.kxK.setText(this.kye);
                this.kxL.setText(String.format(this.mController.tml.getString(R.l.ipcall_share_coupon_card_code_desc), new Object[]{this.kxW}));
                this.kxO.setOnClickListener(new 11(this));
                this.kxM.setText(String.format(getString(R.l.ipcall_share_coupon_card_content_title), new Object[]{this.kye}));
                TextView textView = this.kxN;
                String format = String.format(getString(R.l.ipcall_share_coupon_card_content_desc), new Object[]{this.kye});
                String string = getString(R.l.ipcall_share_coupon_card_rule);
                if (bi.oW(string)) {
                    textView.setText(format);
                } else {
                    String str2;
                    String string2 = getString(R.l.ipcall_share_coupon_promotion_desc);
                    TextPaint paint = textView.getPaint();
                    float measureText = paint.measureText(format);
                    float measureText2 = paint.measureText(string2);
                    int fk = com.tencent.mm.bp.a.fk(this.mController.tml) - (((LayoutParams) textView.getLayoutParams()).rightMargin + ((LayoutParams) textView.getLayoutParams()).leftMargin);
                    int ceil = (int) Math.ceil((double) (measureText / ((float) fk)));
                    int ceil2 = (int) Math.ceil((double) ((measureText + measureText2) / ((float) fk)));
                    if (ceil == 0) {
                        ceil = 1;
                    }
                    if (ceil2 > ceil) {
                        str2 = "\n" + string2;
                    } else {
                        str2 = string2;
                    }
                    textView.setGravity(17);
                    CharSequence newSpannable = Factory.getInstance().newSpannable(format + str2);
                    newSpannable.setSpan(new 6(this, string), format.length(), str2.length() + format.length(), 33);
                    textView.setText(newSpannable);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                if (this.kuy != null && this.kuy.isShowing()) {
                    this.kuy.dismiss();
                }
            } else if (this.kuy != null && this.kuy.isShowing()) {
                this.kuy.dismiss();
                h.a(this.mController.tml, getString(R.l.ip_call_load_error_tip), getString(R.l.ip_call_func_name), new 10(this));
            }
        } else if (lVar instanceof com.tencent.mm.modelmulti.h) {
            if (this.eHw != null) {
                this.eHw.dismiss();
                this.eHw = null;
            }
            if (!com.tencent.mm.plugin.subapp.b.ezo.b(this.mController.tml, i, i2, str)) {
                if (i == 0 && i2 == 0) {
                    h.bA(this, getResources().getString(R.l.confirm_dialog_sent));
                } else {
                    h.i(this.mController.tml, R.l.sendrequest_send_fail, R.l.app_tip);
                }
            }
        } else if ((lVar instanceof com.tencent.mm.as.a) && i == 0 && i2 == 0 && this.kxT != null) {
            if (this.kxU != null) {
                this.kxU.setVisibility(8);
            }
            this.kxT.setImageBitmap(aYp());
        }
    }

    public static void a(Context context, int i, TextView textView, ImageView imageView) {
        CharSequence H = H(context, i);
        if (H != null) {
            textView.setText(H);
        }
        int rH = rH(i);
        if (rH != -1) {
            imageView.setImageResource(rH);
        }
    }

    public static String H(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(8), context.getString(R.l.ip_call_share_copy_invite_url_tip));
        hashMap.put(Integer.valueOf(0), context.getString(R.l.wechat_friend));
        hashMap.put(Integer.valueOf(1), context.getString(R.l.ip_call_share_timeline_tip));
        hashMap.put(Integer.valueOf(3), context.getString(R.l.ip_call_share_email_tip));
        hashMap.put(Integer.valueOf(2), context.getString(R.l.ip_call_share_sms_tip));
        hashMap.put(Integer.valueOf(5), context.getString(R.l.ip_call_share_twitter_tip));
        hashMap.put(Integer.valueOf(4), context.getString(R.l.ip_call_share_whatsapp_tip));
        hashMap.put(Integer.valueOf(6), context.getString(R.l.ip_call_share_facebook_tip));
        hashMap.put(Integer.valueOf(7), context.getString(R.l.ip_call_share_facebook_messenger_tip));
        if (hashMap.containsKey(Integer.valueOf(i))) {
            return (String) hashMap.get(Integer.valueOf(i));
        }
        return null;
    }

    public static int rH(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(8), Integer.valueOf(R.k.bottomsheet_copy));
        hashMap.put(Integer.valueOf(0), Integer.valueOf(R.k.bottomsheet_repost));
        hashMap.put(Integer.valueOf(1), Integer.valueOf(R.k.bottomsheet_moment));
        hashMap.put(Integer.valueOf(3), Integer.valueOf(R.k.bottomsheet_email));
        hashMap.put(Integer.valueOf(2), Integer.valueOf(R.k.bottomsheet_sms));
        hashMap.put(Integer.valueOf(5), Integer.valueOf(R.k.bottomsheet_twitter));
        hashMap.put(Integer.valueOf(4), Integer.valueOf(R.k.bottomsheet_whatsapp));
        hashMap.put(Integer.valueOf(6), Integer.valueOf(R.k.bottomsheet_facebook));
        hashMap.put(Integer.valueOf(7), Integer.valueOf(R.k.bottomsheet_messenger));
        if (hashMap.containsKey(Integer.valueOf(i))) {
            return ((Integer) hashMap.get(Integer.valueOf(i))).intValue();
        }
        return -1;
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

    public final void a(com.tencent.mm.ui.i.a.c cVar) {
        if (this.kxR != null) {
            this.kxR.cancel();
        }
        switch (8.kyp[cVar.ordinal()]) {
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

    private void rI(int i) {
        h.a(this.mController.tml, i, R.l.app_tip, new 14(this), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public final void b(com.tencent.mm.ui.i.a.c cVar) {
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
        Gb = com.tencent.mm.sdk.platformtools.h.f(Gb, com.tencent.mm.model.c.Gc(), "qr_", com.tencent.mm.a.g.u(str.getBytes()), ".png");
        if (bi.oW(Gb)) {
            x.e("MicroMsg.IPCallShareCouponCardUI", "filename is null");
            return null;
        }
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(Gb, "r");
            try {
                byte[] bArr = new byte[((int) randomAccessFile.length())];
                randomAccessFile.read(bArr);
                try {
                    randomAccessFile.close();
                } catch (Exception e2) {
                }
                return bArr;
            } catch (Exception e3) {
                e = e3;
                try {
                    x.printErrStackTrace("MicroMsg.IPCallShareCouponCardUI", e, "", new Object[0]);
                    if (randomAccessFile != null) {
                        return null;
                    }
                    try {
                        randomAccessFile.close();
                        return null;
                    } catch (Exception e4) {
                        return null;
                    }
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
            x.printErrStackTrace("MicroMsg.IPCallShareCouponCardUI", e, "", new Object[0]);
            if (randomAccessFile != null) {
                return null;
            }
            try {
                randomAccessFile.close();
                return null;
            } catch (Exception e42) {
                return null;
            }
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

    private void l(int i, String str, String str2) {
        this.kyh = View.inflate(this.mController.tml, R.i.confirm_dialog_item, null);
        EditText editText = (EditText) this.kyh.findViewById(R.h.confirm_dialog_text_et);
        this.kxT = (ImageView) this.kyh.findViewById(R.h.confirm_dialog_imageview);
        this.kxU = (ProgressBar) this.kyh.findViewById(R.h.loading_pb);
        editText.setText(str);
        Bitmap aYp = aYp();
        if (aYp == null) {
            String GF = q.GF();
            au.HU();
            au.DF().a(new com.tencent.mm.as.a(GF, bi.f((Integer) com.tencent.mm.model.c.DT().get(66561, null))), 0);
            this.kxU.setVisibility(0);
        } else if (this.kxT != null) {
            this.kxT.setImageBitmap(aYp);
        }
        com.tencent.mm.pluginsdk.ui.applet.g.a(this.mController, str2, this.kyh, getResources().getString(R.l.app_send), new 5(this, editText, str, i));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && intent != null) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!bi.oW(stringExtra)) {
                com.tencent.mm.pluginsdk.ui.applet.g.a(this.mController, this.cZH, this.kxX, this.cZG, true, getResources().getString(R.l.app_send), new 7(this, stringExtra));
            }
        }
    }
}
