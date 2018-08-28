package com.tencent.mm.plugin.talkroom.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ax.d;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.bsm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.y;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomUI extends MMBaseActivity implements e, d {
    private List<String> bTR = new LinkedList();
    private TextView eBO;
    private p eXe;
    private long kGA = 0;
    private al kGB = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean vD() {
            x.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess expired to execute");
            TalkRoomUI.this.aZJ();
            return false;
        }
    }, false);
    private al kGC = new al(new 1(this), false);
    private al kGD = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean vD() {
            TalkRoomUI.this.aZK();
            return false;
        }
    }, false);
    private final al kGG = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean vD() {
            short So;
            int i = 15;
            boolean z = false;
            if (TalkRoomUI.this.kGy == 3) {
                So = b.bGT().So();
            } else if (bi.oW(TalkRoomUI.this.kGv)) {
                TalkRoomUI.this.bHn();
                return false;
            } else {
                So = b.bGT().Sp();
            }
            if (So <= (short) 15) {
                if (!TalkRoomUI.this.oxO) {
                    i = 0;
                }
                TalkRoomUI.this.oxP = TalkRoomUI.this.oxP + 1;
                if (TalkRoomUI.this.oxP >= 5) {
                    TalkRoomUI talkRoomUI = TalkRoomUI.this;
                    if (!TalkRoomUI.this.oxO) {
                        z = true;
                    }
                    talkRoomUI.oxO = z;
                    TalkRoomUI.this.oxP = 0;
                }
            } else {
                short s = So;
            }
            TalkRoomUI.this.bHn();
            TalkRoomUI.this.oxL.setValue(i);
            return true;
        }
    }, true);
    private boolean kGH = true;
    private Chronometer kGM;
    private int kGN = 0;
    private boolean kGt = true;
    private String kGu;
    private String kGv;
    private boolean kGx = false;
    private int kGy = 0;
    private long kGz = 500;
    private float kHA = -1.0f;
    private TextView kxe;
    private TextView oxH;
    private ImageButton oxI;
    private Button oxJ;
    private ImageView oxK;
    private TalkRoomVolumeMeter oxL;
    private TalkRoomAvatarsFrame oxM;
    private a oxN;
    private boolean oxO = true;
    private int oxP = 0;
    private AlphaAnimation oxQ;
    private AlphaAnimation oxR;
    private AlphaAnimation oxS;
    private AlphaAnimation oxT;
    private float oxU = -1.0f;
    private float oxV = -1.0f;
    private WakeLock wakeLock;

    private abstract class a {
        float fto;
        float ftp;
        long oya;

        public abstract void bHr();

        private a() {
        }

        /* synthetic */ a(TalkRoomUI talkRoomUI, byte b) {
            this();
        }
    }

    static /* synthetic */ void a(TalkRoomUI talkRoomUI) {
        if (talkRoomUI.kGy == 5) {
            talkRoomUI.kGy = 3;
            b.bGT().Sn();
            talkRoomUI.kGG.J(100, 100);
        }
    }

    private void bHn() {
        if (this.kGy == 3 || this.kGy == 5) {
            this.oxL.setShowFlame(true);
        } else if (bi.oW(this.kGv)) {
            this.oxL.setShowFlame(false);
        } else {
            this.oxL.setShowFlame(true);
        }
    }

    public void onCreate(Bundle bundle) {
        x.d("MicroMsg.TalkRoomUI", "onCreate");
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("enter_room_username");
        x.i("MicroMsg.TalkRoomUI", "onCreate talkRoomName : %s", new Object[]{stringExtra});
        x.d("MicroMsg.TalkRoomUI", "talkRoomName %s ", new Object[]{stringExtra});
        this.kGu = stringExtra;
        if (bi.oW(this.kGu)) {
            Or("");
        } else {
            if (s.fq(stringExtra)) {
                List gI = m.gI(stringExtra);
                if (gI == null) {
                    com.tencent.mm.model.am.a.dBr.R(stringExtra, "");
                } else {
                    this.bTR = gI;
                }
            } else {
                this.bTR.clear();
                this.bTR.add(stringExtra);
                this.bTR.add(q.GF());
            }
            new ag(Looper.getMainLooper()).post(new 3(this, stringExtra));
        }
        x.d("MicroMsg.TalkRoomUI", "onCreate before initView");
        setContentView(y.gq(ad.getContext()).inflate(R.i.talk_room, null));
        this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(26, "TalkRoomUI Lock");
        this.eBO = (TextView) findViewById(R.h.title_tv);
        this.oxH = (TextView) findViewById(R.h.mic_info);
        this.kxe = (TextView) findViewById(R.h.count_tv);
        this.oxJ = (Button) findViewById(R.h.info_btn);
        this.kGM = (Chronometer) findViewById(R.h.chronometer);
        this.oxK = (ImageView) findViewById(R.h.led_iv);
        this.oxN = new a(this);
        this.oxJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                h.a(TalkRoomUI.this, TalkRoomUI.this.getString(R.l.talk_room_exit_room_tip), TalkRoomUI.this.getString(R.l.talk_room_exit_room), new 1(this), null);
            }
        });
        findViewById(R.h.up_btn).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                boolean z;
                TalkRoomUI talkRoomUI = TalkRoomUI.this;
                au.HU();
                if (bi.a((Integer) c.DT().get(144641, null), 0) > 0) {
                    z = false;
                } else {
                    i iVar = new i(talkRoomUI, R.m.mmdialog);
                    LinearLayout linearLayout = (LinearLayout) y.gq(ad.getContext()).inflate(R.i.talkroom_welcome_ui, null);
                    linearLayout.setMinimumWidth(10000);
                    Button button = (Button) linearLayout.findViewById(R.h.i_know_btn);
                    iVar.setCanceledOnTouchOutside(true);
                    iVar.setOnDismissListener(new 17(talkRoomUI));
                    iVar.setCancelable(false);
                    button.setOnClickListener(new 2(talkRoomUI, iVar));
                    iVar.setContentView(linearLayout);
                    iVar.show();
                    z = true;
                }
                if (!z) {
                    TalkRoomUI.this.onBackPressed();
                }
            }
        });
        this.oxI = (ImageButton) findViewById(R.h.mic_btn);
        this.oxI.setEnabled(false);
        this.oxI.setImageResource(R.g.talk_room_mic_btn_unable);
        this.oxI.setOnTouchListener(new 13(this));
        this.oxL = (TalkRoomVolumeMeter) findViewById(R.h.volume_meter);
        findViewById(R.h.touch_view).setOnTouchListener(new 15(this, new 14(this)));
        this.oxM = (TalkRoomAvatarsFrame) findViewById(R.h.avatar_frame);
        this.eBO.setOnClickListener(new 16(this));
        this.oxQ = new AlphaAnimation(0.0f, 1.0f);
        this.oxQ.setDuration(300);
        this.oxQ.setFillAfter(true);
        this.oxR = new AlphaAnimation(1.0f, 0.0f);
        this.oxR.setDuration(300);
        this.oxR.setFillAfter(true);
        this.oxS = new AlphaAnimation(0.0f, 1.0f);
        this.oxS.setDuration(300);
        this.oxS.setFillAfter(true);
        this.oxT = new AlphaAnimation(1.0f, 0.0f);
        this.oxT.setDuration(300);
        this.oxT.setFillAfter(true);
        au.DF().a(364, this);
        x.d("MicroMsg.TalkRoomUI", "onCreate before getServer");
        b.bGT().a(this);
        x.d("MicroMsg.TalkRoomUI", "onCreate end");
    }

    protected void onResume() {
        super.onResume();
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("isTalkroom", true).putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
        this.wakeLock.acquire();
        this.eBO.setText(j.a(this, com.tencent.mm.plugin.talkroom.model.h.aJ(this, this.kGu), this.eBO.getTextSize()));
        b.bGS().ovZ.owe = true;
        b.bGS();
        x.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        b.bGS();
        com.tencent.mm.plugin.talkroom.model.c.bGZ();
        ln lnVar = new ln();
        lnVar.bVQ.bVR = true;
        com.tencent.mm.sdk.b.a.sFg.a(lnVar, getMainLooper());
        x.d("MicroMsg.TalkRoomUI", "TalkRoom req pause auto download logic");
    }

    protected void onPause() {
        super.onPause();
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
        this.wakeLock.release();
        this.kGG.SO();
        b.bGS().ovZ.owe = false;
        b.bGS();
        com.tencent.mm.plugin.talkroom.model.c cVar = b.bGS().ovZ;
        if (cVar.kGt) {
            cVar.Op(ad.getContext().getString(R.l.talk_room_readying));
        } else if (bi.oW(cVar.kFP)) {
            cVar.Op(com.tencent.mm.plugin.talkroom.model.h.aJ(ad.getContext(), b.bGT().owU));
        } else {
            String string = ad.getContext().getString(R.l.talk_room_speaking, new Object[]{r.gT(cVar.kFP)});
            com.tencent.mm.plugin.talkroom.model.c.bGZ();
            cVar.Op(string);
        }
        ln lnVar = new ln();
        lnVar.bVQ.bVR = false;
        com.tencent.mm.sdk.b.a.sFg.a(lnVar, getMainLooper());
        x.d("MicroMsg.TalkRoomUI", "TalkRoom cancel pause auto download logic");
    }

    protected void onDestroy() {
        b.bGT().b(this);
        au.DF().b(364, this);
        if (this.eXe != null && this.eXe.isShowing()) {
            this.eXe.cancel();
        }
        super.onDestroy();
    }

    public void finish() {
        super.finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 25) {
            au.HV().fE(3);
            return true;
        } else if (i != 24) {
            return super.onKeyDown(i, keyEvent);
        } else {
            au.HV().fD(3);
            return true;
        }
    }

    public final void St() {
        this.kGt = false;
        this.oxI.setEnabled(true);
        this.oxI.setImageResource(R.g.talk_room_mic_btn_normal);
        this.oxJ.setVisibility(0);
        aZK();
        bHp();
        bHo();
    }

    public final void i(String str, int i, int i2) {
        x.f("MicroMsg.TalkRoomUI", "onInitFailed %s", new Object[]{str});
        String str2 = "";
        if (i == 4) {
            if (i2 != -1) {
                this.kGH = false;
                finish();
                return;
            }
            str2 = getString(R.l.talk_room_network_failed);
        }
        Or(str2);
    }

    public final void iA(int i) {
        x.i("MicroMsg.TalkRoomUI", "onSeizeMicFailed");
        if (i == 340) {
            if (this.kGy == 3) {
                this.kGy = 4;
            } else {
                return;
            }
        } else if (this.kGy == 1) {
            this.kGy = 2;
        } else {
            return;
        }
        bHn();
        aZK();
        as.a(ad.getContext(), R.l.talkroom_sasasa, new 4(this));
    }

    public final void Su() {
        x.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess");
        if (this.kGy == 1) {
            this.kGy = 5;
            if (bi.bI(this.kGA) < this.kGz) {
                x.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess waiting to execute");
                long bI = this.kGz - bi.bI(this.kGA);
                this.kGB.J(bI, bI);
                return;
            }
            aZJ();
        }
    }

    private void aZJ() {
        if (this.kGy == 5) {
            this.kGB.SO();
            aZK();
            bHn();
            as.b(ad.getContext(), R.l.talkroom_begin, new 6(this));
            this.kGC.J(1000, 1000);
        }
    }

    public final void b(int i, int i2, String str) {
        x.f("MicroMsg.TalkRoomUI", "errType %d, errCode %d, errInfo %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        Or("");
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 364 && this.eXe != null && this.eXe.isShowing()) {
            this.eXe.cancel();
        }
    }

    private void Or(String str) {
        if (this.kGH) {
            this.kGH = false;
            b.bGT().aZL();
            if (bi.oW(str)) {
                if (ao.isConnected(getApplication())) {
                    str = getString(R.l.talk_room_network_failed);
                } else {
                    str = getString(R.l.talk_room_network_not_conn);
                }
            }
            if (!isFinishing()) {
                h.a(this, str, "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        TalkRoomUI.this.finish();
                    }
                });
                return;
            }
            return;
        }
        x.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
    }

    public final void nr(String str) {
        x.d("MicroMsg.TalkRoomUI", "onCurMember %s", new Object[]{str});
        this.kGv = str;
        bHn();
        aZK();
        if (bi.oW(str)) {
            this.kGG.SO();
            return;
        }
        as.b(ad.getContext(), R.l.talkroom_othersbegin, new com.tencent.mm.sdk.platformtools.as.a() {
            public final void wd() {
            }
        });
        this.kGG.J(100, 100);
    }

    public final void Sv() {
        if (this.kGH) {
            this.kGH = false;
            finish();
            return;
        }
        x.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
    }

    public final void Sw() {
        aZK();
    }

    public final void Sx() {
        aZK();
    }

    public final void Sy() {
        e(getString(R.l.talk_room_reconnecting), R.e.talk_room_tv_red);
    }

    private void bHo() {
        List<bsm> aZp = b.bGT().aZp();
        List linkedList = new LinkedList();
        for (bsm bsm : aZp) {
            linkedList.add(bsm.hbL);
        }
        this.oxM.setMembersList(linkedList);
    }

    public final void ay(String str, String str2) {
        x.i("MicroMsg.TalkRoomUI", "add %s,  del %s", new Object[]{str, str2});
        bHo();
        if (!this.kGt) {
            bHp();
            if (!bi.oW(str)) {
                cm(getString(R.l.talk_room_enter_4short, new Object[]{r.gT(str)}), R.e.talk_room_tv_green);
                this.kGD.J(3000, 3000);
            }
            if (!bi.oW(str2)) {
                cm(getString(R.l.talk_room_exit_4short, new Object[]{r.gT(str2)}), R.e.talk_room_tv_green);
                this.kGD.J(3000, 3000);
            }
        }
    }

    private void aZK() {
        if (!this.kGt) {
            if (b.bGT().oxi) {
                e(getString(R.l.talk_room_pausing), R.e.talk_room_tv_red);
                this.oxM.setCurMemeber(null);
                this.oxK.setImageResource(R.g.talk_room_led_black);
                bHq();
                return;
            }
            switch (this.kGy) {
                case 0:
                    if (bi.oW(this.kGv)) {
                        CharSequence string;
                        if (b.bGT().aZp().size() == 1) {
                            string = getString(R.l.talk_room_waiting_for_others);
                        } else {
                            string = "";
                        }
                        e(string, R.e.talk_room_tv_green);
                        this.oxM.setCurMemeber(null);
                        this.oxK.setImageResource(R.g.talk_room_led_black);
                        bHq();
                        return;
                    }
                    cm(r.gT(this.kGv), R.e.talk_room_tv_green);
                    this.oxM.setCurMemeber(this.kGv);
                    this.oxK.setImageResource(R.g.talk_room_led_black);
                    yc(1);
                    return;
                case 1:
                    e(getString(R.l.talk_room_connecting), R.e.talk_room_tv_green);
                    this.oxK.setImageResource(R.g.talk_room_led_yellow);
                    return;
                case 2:
                    e(getString(R.l.talk_room_seize_mic_failed), R.e.talk_room_tv_red);
                    this.oxK.setImageResource(R.g.talk_room_led_red);
                    return;
                case 3:
                case 5:
                    e(getString(R.l.talk_room_self_speaking), R.e.talk_room_tv_green);
                    this.oxM.setCurMemeber(q.GF());
                    this.oxK.setImageResource(R.g.talk_room_led_green);
                    yc(2);
                    return;
                case 4:
                    e(getString(R.l.talk_room_speak_too_long), R.e.talk_room_tv_red);
                    this.oxK.setImageResource(R.g.talk_room_led_red);
                    bHq();
                    return;
                default:
                    return;
            }
        }
    }

    private void bHp() {
        x.i("MicroMsg.TalkRoomUI", "displayCount %d", new Object[]{Integer.valueOf(b.bGT().aZp().size())});
        this.kxe.setText(String.valueOf(r0));
    }

    private void cm(String str, int i) {
        e(j.a(this, str, this.oxH.getTextSize()), i);
    }

    private void e(CharSequence charSequence, int i) {
        if (bi.oW(charSequence.toString())) {
            this.oxH.startAnimation(this.oxT);
            return;
        }
        this.oxH.setTextColor(getResources().getColor(i));
        this.oxH.setText(charSequence);
        this.oxH.startAnimation(this.oxS);
    }

    private void yc(int i) {
        if (i == 0 || this.kGN != i) {
            this.kGM.setVisibility(0);
            this.kGM.startAnimation(this.oxQ);
            this.kGM.setBase(bi.VG());
            this.kGM.start();
            this.kGN = i;
        }
    }

    private void bHq() {
        if (this.kGN != 0) {
            this.kGM.stop();
            this.kGN = 0;
            this.kGM.startAnimation(this.oxR);
        }
    }
}
