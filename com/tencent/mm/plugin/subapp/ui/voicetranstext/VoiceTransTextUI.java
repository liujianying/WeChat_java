package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.utils.TbsLog;

public class VoiceTransTextUI extends MMActivity implements OnClickListener, e {
    private final String TAG = "MicroMsg.VoiceTransTextUI";
    private long cYP;
    private ScrollView fPS = null;
    private int fW;
    private int goe;
    private int gof;
    private Button iQh = null;
    private View ido = null;
    private ag mHandler = new 6(this);
    private long mmg = 0;
    private bx opT;
    private a opZ;
    private c oqa;
    private b oqb;
    private com.tencent.mm.modelvoice.b oqc;
    private volatile boolean oqe = false;
    private boolean oqf = false;
    private al oqg;
    private View oui = null;
    private View ouj = null;
    private LinearLayout ouk = null;
    private TextView oul = null;
    private int oum = 6;
    private boolean oun = false;
    private p ouo;
    private bd oup;
    private c ouq;
    private boolean our = false;
    private boolean ous = false;
    private int ouu;
    private OnTouchListener ouv;
    private OnClickListener ouw = new 1(this);
    private ClipboardManager oux;
    private OnLongClickListener ouy = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            x.d("MicroMsg.VoiceTransTextUI", "onLongClick");
            h.a(VoiceTransTextUI.this, "", new String[]{VoiceTransTextUI.this.getString(R.l.app_copy)}, "", new 1(this));
            return false;
        }
    };

    /* renamed from: com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI$9 */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] ouD = new int[a.bGJ().length];
        static final /* synthetic */ int[] ouE = new int[b.bGK().length];

        static {
            try {
                ouE[b.ouK - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                ouE[b.ouL - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                ouE[b.ouM - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                ouD[a.ouF - 1] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                ouD[a.ouG - 1] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                ouD[a.ouH - 1] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                ouD[a.ouI - 1] = 4;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    private enum b {
        ;

        public static int[] bGK() {
            return (int[]) ouN.clone();
        }

        static {
            ouK = 1;
            ouL = 2;
            ouM = 3;
            ouN = new int[]{ouK, ouL, ouM};
        }
    }

    static /* synthetic */ void l(VoiceTransTextUI voiceTransTextUI) {
        voiceTransTextUI.goe = 0;
        voiceTransTextUI.gof = 0;
        voiceTransTextUI.our = false;
        voiceTransTextUI.ous = false;
        voiceTransTextUI.mHandler.removeMessages(0);
    }

    public void onCreate(Bundle bundle) {
        int i;
        bx bxVar = null;
        super.onCreate(bundle);
        this.fW = ViewConfiguration.get(this.mController.tml).getScaledTouchSlop();
        this.oux = (ClipboardManager) getSystemService("clipboard");
        this.ido = findViewById(R.h.voice_trans_text_root);
        this.oui = findViewById(R.h.voice_trans_load);
        this.ouj = findViewById(R.h.voice_trans_text_fail_root);
        this.oul = (TextView) findViewById(R.h.voice_trans_text_content);
        this.iQh = (Button) findViewById(R.h.voice_trans_text_cancel);
        this.ouk = (LinearLayout) findViewById(R.h.voice_trans_text_content_layout);
        this.fPS = (ScrollView) findViewById(R.h.full_screen_scroll_container);
        this.ouv = new 3(this);
        this.oul.setOnLongClickListener(this.ouy);
        this.oul.setOnClickListener(this.ouw);
        this.cYP = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1);
        if (this.cYP < 0) {
            i = 0;
        } else {
            x.i("MicroMsg.VoiceTransTextUI", "msg Id:%d", new Object[]{Long.valueOf(this.cYP)});
            by TJ = m.TJ();
            if (this.cYP >= 0) {
                bx bxVar2 = new bx();
                Cursor a = TJ.diF.a("VoiceTransText", null, "msgId=?", new String[]{String.valueOf(r6)}, null, null, null, 2);
                if (a.moveToFirst()) {
                    bxVar2.d(a);
                }
                a.close();
                bxVar = bxVar2;
            }
            this.opT = bxVar;
            if (this.opT == null || bi.oW(this.opT.field_content)) {
                String string = getIntent().getExtras().getString("voice_trans_text_img_path");
                if (bi.oW(string)) {
                    i = 0;
                } else {
                    this.ouo = m.TI().ow(string);
                    if (this.ouo != null) {
                        x.i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
                        i = 1;
                    } else {
                        au.HU();
                        this.oup = com.tencent.mm.model.c.FT().dW(this.cYP);
                        if (this.oup != null) {
                            x.i("MicroMsg.VoiceTransTextUI", "get MsgInfo");
                            i = 1;
                        } else {
                            i = 0;
                        }
                    }
                }
            } else {
                x.i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
                i = 1;
            }
        }
        if (i == 0) {
            x.d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
            return;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        initView();
    }

    protected final int getLayoutId() {
        return R.i.voice_trans_text_view;
    }

    protected final void initView() {
        Object obj;
        setMMTitle(R.l.voice_trans_text_title);
        this.iQh.setOnClickListener(this);
        if (this.opT == null || bi.oW(this.opT.field_content)) {
            obj = null;
        } else {
            aJ(b.ouK, this.opT.field_content);
            if (!(this.fPS == null || this.ouk == null)) {
                this.mHandler.postDelayed(new 8(this), 5);
            }
            obj = 1;
        }
        if (obj == null) {
            aJ(b.ouL, null);
            xX(a.ouF);
        }
    }

    private void xX(int i) {
        bGF();
        switch (AnonymousClass9.ouD[i - 1]) {
            case 1:
                x.i("MicroMsg.VoiceTransTextUI", "net check");
                if (wW() > 0) {
                    x.i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", new Object[]{Long.valueOf(wW())});
                    this.opZ = new a(bGG(), bGH(), bGI().getFormat(), wW(), getFileName());
                } else {
                    x.i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", new Object[]{Long.valueOf(wW())});
                    this.opZ = new a(bGG(), bGH(), getFileName());
                }
                au.DF().a(this.opZ, 0);
                au.DF().a(this.opZ.getType(), this);
                if (this.ouq == null) {
                    if (this.ouq == null) {
                        this.ouq = new 5(this);
                    }
                    a.sFg.b(this.ouq);
                    return;
                }
                return;
            case 2:
                x.i("MicroMsg.VoiceTransTextUI", "net upload");
                if (this.opZ == null) {
                    x.d("MicroMsg.VoiceTransTextUI", "request upload must after check!");
                    return;
                } else if (bGI() == null) {
                    x.d("MicroMsg.VoiceTransTextUI", "can't get FileOperator!");
                    return;
                } else {
                    this.oqa = new c(bGG(), this.opZ.oue, bGI().getFormat(), getFileName());
                    au.DF().a(this.oqa, 0);
                    au.DF().a(this.oqa.getType(), this);
                    return;
                }
            case 3:
                x.i("MicroMsg.VoiceTransTextUI", "net upload more");
                if (this.oqa == null) {
                    x.d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
                    return;
                }
                this.oqa = new c(this.oqa);
                au.DF().a(this.oqa, 0);
                au.DF().a(this.oqa.getType(), this);
                return;
            case 4:
                this.oun = false;
                if (this.oqe) {
                    x.i("MicroMsg.VoiceTransTextUI", "pulling so pass");
                    return;
                }
                x.i("MicroMsg.VoiceTransTextUI", "net get");
                if (this.opZ == null) {
                    x.d("MicroMsg.VoiceTransTextUI", "request get must after check!");
                    return;
                }
                this.oqe = true;
                this.oqb = new b(bGG());
                au.DF().a(this.oqb, 0);
                au.DF().a(this.oqb.getType(), this);
                return;
            default:
                return;
        }
    }

    private void aJ(int i, String str) {
        while (true) {
            CharSequence str2;
            switch (AnonymousClass9.ouE[i - 1]) {
                case 1:
                    if (!bi.oW(str2)) {
                        this.ouk.setVisibility(0);
                        this.oui.setVisibility(8);
                        this.iQh.setVisibility(4);
                        this.ouj.setVisibility(8);
                        this.oul.setText(str2);
                        iy(true);
                        break;
                    }
                    i = b.ouM;
                    str2 = null;
                case 2:
                    this.ouk.setVisibility(0);
                    this.oui.setVisibility(0);
                    this.iQh.setVisibility(0);
                    if (str2 != null) {
                        this.oul.setText(str2);
                        iy(false);
                        break;
                    }
                    break;
                case 3:
                    this.ouk.setVisibility(8);
                    this.oui.setVisibility(8);
                    this.iQh.setHeight(0);
                    this.iQh.setVisibility(8);
                    this.ouj.setVisibility(0);
                    break;
                default:
                    break;
            }
        }
        if (i == b.ouK || i == b.ouM) {
            this.fPS.setOnTouchListener(this.ouv);
            this.ido.setOnClickListener(this.ouw);
            return;
        }
        this.fPS.setOnTouchListener(null);
        this.ido.setOnClickListener(null);
    }

    private void bGF() {
        x.d("MicroMsg.VoiceTransTextUI", "cancel all net");
        if (this.opZ != null) {
            au.DF().c(this.opZ);
            au.DF().b(this.opZ.getType(), this);
        }
        if (this.oqa != null) {
            au.DF().c(this.oqa);
            au.DF().b(this.oqa.getType(), this);
        }
        if (this.oqb != null) {
            au.DF().c(this.oqb);
            au.DF().b(this.oqb.getType(), this);
        }
    }

    private String bGG() {
        if (this.ouo != null) {
            return this.ouo.clientId;
        }
        return this.oup.field_talker + this.oup.field_msgId + "T" + this.oup.field_createTime;
    }

    private int bGH() {
        if (this.ouo != null) {
            return this.ouo.dHI;
        }
        return o.nM(this.oup.field_imgPath);
    }

    private long wW() {
        return this.ouo == null ? -1 : this.ouo.bYu;
    }

    private String getFileName() {
        if (this.ouo != null) {
            return this.ouo.fileName;
        }
        return this.oup.field_imgPath;
    }

    private com.tencent.mm.modelvoice.b bGI() {
        if (this.oqc == null) {
            if (this.ouo != null) {
                this.oqc = q.ok(this.ouo.fileName);
            } else if (this.oup != null) {
                this.oqc = q.ok(this.oup.field_imgPath);
            } else {
                x.d("MicroMsg.VoiceTransTextUI", "error why get fileOperator, already has transContent. ");
            }
        }
        return this.oqc;
    }

    public final void a(int i, int i2, String str, l lVar) {
        String str2 = null;
        if (i == 0 && i2 == 0) {
            switch (lVar.getType()) {
                case 546:
                    if (this.opZ.mState == a.ouc) {
                        x.i("MicroMsg.VoiceTransTextUI", "check result: done");
                        if (this.opZ.bGC()) {
                            str2 = this.opZ.oud.suF;
                        }
                        Oo(str2);
                        return;
                    } else if (this.opZ.mState == a.oub) {
                        if (this.opZ.oud != null && bi.oW(this.opZ.oud.suF)) {
                            aJ(b.ouL, this.opZ.oud.suF);
                        }
                        x.i("MicroMsg.VoiceTransTextUI", "check result: processing");
                        xX(a.ouI);
                        return;
                    } else if (this.opZ.mState == a.oua) {
                        x.i("MicroMsg.VoiceTransTextUI", "check result: not exist");
                        xX(a.ouG);
                        return;
                    } else if (this.opZ.ouf != null) {
                        this.oum = this.opZ.ouf.sga;
                        return;
                    } else {
                        return;
                    }
                case 547:
                    if (this.oqa.bGE()) {
                        x.i("MicroMsg.VoiceTransTextUI", "succeed upload");
                        xX(a.ouI);
                        return;
                    }
                    x.d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", new Object[]{Integer.valueOf(this.oqa.oue.rdW), Integer.valueOf(this.oqa.oue.rdX)});
                    xX(a.ouH);
                    return;
                case 548:
                    this.oum = this.oqb.ouh;
                    this.oqe = false;
                    if (!this.oqb.isComplete() && this.oqb.bGC()) {
                        aJ(b.ouL, this.oqb.oud.suF);
                        x.d("MicroMsg.VoiceTransTextUI", "result valid:%s", new Object[]{this.oqb.oud.suF});
                    } else if (!this.oqb.bGC()) {
                        x.d("MicroMsg.VoiceTransTextUI", "result not valid");
                    }
                    if (this.oqb.isComplete()) {
                        x.i("MicroMsg.VoiceTransTextUI", "succeed get");
                        if (this.oqb.bGC()) {
                            str2 = this.oqb.oud.suF;
                        }
                        Oo(str2);
                        return;
                    } else if (this.oun) {
                        x.i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
                        xX(a.ouI);
                        return;
                    } else {
                        x.i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", new Object[]{Integer.valueOf(this.oum)});
                        int i3 = this.oum;
                        if (!this.oqf) {
                            if (this.oqg == null) {
                                this.oqg = new al(new 4(this, i3), false);
                            }
                            long j = (long) (i3 * TbsLog.TBSLOG_CODE_SDK_BASE);
                            this.oqg.J(j, j);
                            return;
                        }
                        return;
                    }
                default:
                    return;
            }
        }
        this.oqf = true;
        aJ(b.ouM, null);
    }

    private void Oo(String str) {
        this.oqf = true;
        if (!bi.oW(str)) {
            by TJ = m.TJ();
            bx bxVar = new bx();
            bxVar.field_msgId = this.cYP;
            bxVar.Zr(bGG());
            bxVar.field_content = str;
            TJ.a(bxVar);
        }
        aJ(b.ouK, str);
    }

    protected void onDestroy() {
        bGF();
        if (this.oqg != null) {
            this.oqg.SO();
        }
        if (this.ouq != null) {
            a.sFg.c(this.ouq);
            this.ouq = null;
        }
        super.onDestroy();
    }

    public void onClick(View view) {
        finish();
    }

    private void iy(boolean z) {
        if (this.fPS != null && this.ouk != null) {
            this.mHandler.postDelayed(new 7(this, z), 5);
        }
    }
}
