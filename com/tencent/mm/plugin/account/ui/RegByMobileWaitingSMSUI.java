package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.account.a.e;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegByMobileWaitingSMSUI extends MMActivity {
    private String bTi;
    private String eHy;
    private s eUU;
    private boolean eUV;
    private com.tencent.mm.plugin.account.ui.s.a eUW = new com.tencent.mm.plugin.account.ui.s.a() {
        public final void pP(String str) {
            RegByMobileWaitingSMSUI.this.pN(str.trim());
        }

        public final void YZ() {
            RegByMobileWaitingSMSUI.this.pN(null);
        }
    };
    private int eUi = 30;
    private TextView eVQ;
    private ProgressBar eVR;
    private CountDownTimer eVS;
    private ListView eVT;
    private a eVU;
    private List<Integer> eVV = new ArrayList();
    String[] eVW = new String[]{"你好", "可以请你喝一杯吗？", "Здравствуйте!", "Darf ich Ihnen einen Drink ausgeben?", "Ich habe Gefühle für Dich.", "Bonjour!", "Prends soins de toi.", "?Hola! ", "Soy un ingeniero.", "Tu novio es un hombre bonito", "今日は!", "カッコいいですね", "Buona notte!", "Ayons une fête ce soir!", "Let's enjoy the holidays.", "Hello!"};
    private Drawable eVX;
    private List<Drawable> eVY = new ArrayList();
    private boolean eVZ = false;

    private class a extends ArrayAdapter<String> {
        private final LayoutInflater eMa;
        final /* synthetic */ RegByMobileWaitingSMSUI eWa;
        private final ArrayList<String> eWc;

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            View inflate;
            int itemViewType = getItemViewType(i);
            if (view == null) {
                bVar = new b(this.eWa, (byte) 0);
                switch (itemViewType) {
                    case 0:
                        inflate = this.eMa.inflate(g.animation_chatting_item, null);
                        break;
                    case 1:
                        inflate = this.eMa.inflate(g.animation_chatting_item_to, null);
                        break;
                    default:
                        throw new IllegalArgumentException("UNIMPLEMENT TYPE");
                }
                bVar.eWd = (TextView) inflate.findViewById(f.chatting_content_itv);
                bVar.eKk = (ImageView) inflate.findViewById(f.chatting_avatar_iv);
                inflate.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
                inflate = view;
            }
            int intValue = ((Integer) this.eWa.eVV.get(i % this.eWa.eVV.size())).intValue();
            switch (itemViewType) {
                case 0:
                    bVar.eKk.setImageDrawable((Drawable) this.eWa.eVY.get(intValue % this.eWa.eVY.size()));
                    break;
                case 1:
                    bVar.eKk.setImageDrawable(this.eWa.eVX);
                    break;
            }
            bVar.eWd.setText(jl(i));
            return inflate;
        }

        public final int getCount() {
            return this.eWc.size();
        }

        private String jl(int i) {
            return (String) this.eWc.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            if (((Integer) this.eWa.eVV.get(i % this.eWa.eVV.size())).intValue() % 4 == 0) {
                return 1;
            }
            return 0;
        }

        /* renamed from: pS */
        public final void add(String str) {
            this.eWc.add(str);
            notifyDataSetChanged();
        }
    }

    private class b {
        public ImageView eKk;
        public TextView eWd;

        private b() {
        }

        /* synthetic */ b(RegByMobileWaitingSMSUI regByMobileWaitingSMSUI, byte b) {
            this();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eVY.add(getResources().getDrawable(e.headshow1));
        this.eVY.add(getResources().getDrawable(e.headshow2));
        this.eVY.add(getResources().getDrawable(e.headshow3));
        this.eVY.add(getResources().getDrawable(e.headshow4));
        this.eVY.add(getResources().getDrawable(e.headshow5));
        this.eVY.add(getResources().getDrawable(e.headshow6));
        initView();
        this.eUU = new s(this, this.eUW);
        this.eUU.Zr();
        this.eHy = com.tencent.mm.plugin.c.a.Zu();
    }

    protected void onDestroy() {
        if (this.eUU != null) {
            this.eUU.Zs();
            this.eUU = null;
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",RE200_250,");
        com.tencent.mm.kernel.g.Eg();
        com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("RE200_250")).append(",1").toString());
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.plugin.c.a.pT("RE200_250");
        if (this.eVZ) {
            com.tencent.mm.plugin.c.a.pU(this.eHy);
        } else {
            com.tencent.mm.plugin.c.a.pU("RE200_300");
        }
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",RE200_250,");
        com.tencent.mm.kernel.g.Eg();
        com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("RE200_250")).append(",2").toString());
    }

    protected final void initView() {
        this.eVQ = (TextView) findViewById(f.waiting_sms_mobile_number);
        this.eVR = (ProgressBar) findViewById(f.waitting_sms_progress_bar);
        this.eVT = (ListView) findViewById(f.waitting_sms_chatting_animation_list);
        this.eUV = false;
        String string = getString(j.bind_mcontact_title_verify);
        if (d.qVQ) {
            string = getString(j.app_name) + getString(j.alpha_version_alpha);
        }
        setMMTitle(string);
        this.bTi = getIntent().getExtras().getString("bindmcontact_mobile");
        this.bTi = ap.Ww(this.bTi);
        this.eUi = getIntent().getIntExtra("mobileverify_countdownsec", this.eUi);
        Random random = new Random();
        for (int i = 0; i < this.eUi; i++) {
            this.eVV.add(Integer.valueOf(random.nextInt(1000)));
        }
        int nextInt = random.nextInt(1000) % this.eVY.size();
        this.eVX = (Drawable) this.eVY.get(nextInt);
        this.eVY.remove(nextInt);
        setBackBtn(new 1(this));
        ap apVar = new ap();
        string = "86";
        if (this.bTi.startsWith("+")) {
            this.bTi = this.bTi.replace("+", "");
            string = ap.Fp(this.bTi);
            if (string != null) {
                this.bTi = this.bTi.substring(string.length());
            }
        }
        CharSequence formatNumber = ap.formatNumber(string, this.bTi);
        if (string == null || string.length() <= 0) {
            this.eVQ.setText(formatNumber);
        } else {
            this.eVQ.setText("+" + string + " " + formatNumber);
        }
        this.eVT.setVisibility(4);
        if (this.eVS == null) {
            this.eVS = new CountDownTimer((long) (this.eUi * 1000)) {
                public final void onFinish() {
                    RegByMobileWaitingSMSUI.this.pN(null);
                }

                public final void onTick(long j) {
                    int c = (int) (((long) RegByMobileWaitingSMSUI.this.eUi) - (j / 1000));
                    RegByMobileWaitingSMSUI.this.eVR.setProgress(c);
                    if (c % 2 == 0 && RegByMobileWaitingSMSUI.this.eVU != null) {
                        RegByMobileWaitingSMSUI.this.eVU.add(RegByMobileWaitingSMSUI.this.eVW[(c / 2) % RegByMobileWaitingSMSUI.this.eVW.length]);
                        RegByMobileWaitingSMSUI.this.eVT.post(new 1(this));
                    }
                }
            };
            this.eVR.setMax(this.eUi);
            this.eVS.start();
        }
    }

    protected final int getLayoutId() {
        return g.mobile_waiting_sms_ui;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        h.a(this, getString(j.mobile_verify_cancel_tip), "", getString(j.mobile_verify_cancel_tip_back), getString(j.mobile_verify_cancel_tip_wait), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                RegByMobileWaitingSMSUI.this.eVZ = true;
                RegByMobileWaitingSMSUI.this.finish();
            }
        }, new 5(this));
    }

    private synchronized void pN(String str) {
        if (this.eUU != null) {
            this.eUU.Zs();
            this.eUU = null;
        }
        if (!(this.eVS == null || this.eVS == null)) {
            this.eVS.cancel();
            this.eVS = null;
        }
        if (!this.eUV) {
            this.eUV = true;
            Intent intent = getIntent();
            intent.putExtra("mobile_verify_purpose", 2);
            if (str != null && str.length() > 0) {
                intent.putExtra("MicroMsg.MobileVerifyUIIntent_sms_code", str);
            }
            a(MobileVerifyUI.class, intent);
            finish();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.RegByMobileWaitingSMSUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.cjd();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.RegByMobileWaitingSMSUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 128:
                if (iArr[0] == 0 && this.eUU != null) {
                    this.eUU.Yh();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
