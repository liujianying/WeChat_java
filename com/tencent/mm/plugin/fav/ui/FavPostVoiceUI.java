package com.tencent.mm.plugin.fav.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.b.j;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.m.d;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.y;

public class FavPostVoiceUI extends MMBaseActivity {
    private static final int[] erx = new int[]{d.amp1, d.amp2, d.amp3, d.amp4, d.amp5, d.amp6, d.amp7};
    private static final int[] hnd = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private long duration;
    private final al erD = new al(new a() {
        public final boolean vD() {
            int maxAmplitude;
            int i = 0;
            j a = FavPostVoiceUI.this.iZl;
            if (a.status == 1) {
                maxAmplitude = a.bFv.getMaxAmplitude();
                if (maxAmplitude > j.bFx) {
                    j.bFx = maxAmplitude;
                }
                maxAmplitude = (maxAmplitude * 100) / j.bFx;
            } else {
                maxAmplitude = 0;
            }
            while (i < FavPostVoiceUI.erx.length) {
                if (maxAmplitude >= FavPostVoiceUI.hnd[i] && maxAmplitude < FavPostVoiceUI.hnd[i + 1]) {
                    FavPostVoiceUI.this.hnl.setBackgroundResource(FavPostVoiceUI.erx[i]);
                    break;
                }
                i++;
            }
            return true;
        }
    }, true);
    private int hmW;
    private final ag hnB = new 6(this);
    private long hng = -1;
    private Toast hnh;
    private ImageView hnl;
    private boolean hnt;
    private boolean hnu;
    private final al hnz = new al(new 7(this), true);
    private Button iZd;
    private long iZe;
    private View iZf;
    private View iZg;
    private View iZh;
    private View iZi;
    private TextView iZj;
    private View iZk;
    private j iZl;
    boolean iZm = false;
    private String path;

    static /* synthetic */ void j(FavPostVoiceUI favPostVoiceUI) {
        favPostVoiceUI.iZd.setKeepScreenOn(true);
        favPostVoiceUI.iZd.setBackgroundResource(d.record_shape_press);
        favPostVoiceUI.iZd.setText(i.favorite_release_to_fav);
        favPostVoiceUI.hnu = false;
        favPostVoiceUI.iZl = favPostVoiceUI.aMm();
        if (favPostVoiceUI.iZl.de(favPostVoiceUI.path)) {
            favPostVoiceUI.iZe = bi.VG();
            favPostVoiceUI.hnz.J(200, 200);
            favPostVoiceUI.hnl.setVisibility(0);
            favPostVoiceUI.erD.J(100, 100);
            favPostVoiceUI.iZj.setText(i.favorite_move_up_cancel);
            return;
        }
        favPostVoiceUI.iZe = 0;
    }

    static /* synthetic */ void n(FavPostVoiceUI favPostVoiceUI) {
        favPostVoiceUI.iZd.setKeepScreenOn(false);
        favPostVoiceUI.iZl.we();
        favPostVoiceUI.erD.SO();
        favPostVoiceUI.hnz.SO();
        favPostVoiceUI.aMp();
        favPostVoiceUI.aMo();
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(y.gq(this).inflate(f.fav_post_voice, null));
        this.hnl = (ImageView) findViewById(e.voice_rcd_hint_anim);
        this.iZh = findViewById(e.voice_rcd_hint_anim_area);
        this.iZi = findViewById(e.voice_rcd_hint_cancel_area);
        this.iZf = findViewById(e.voice_rcd_hint_rcding);
        this.iZg = findViewById(e.voice_rcd_hint_tooshort);
        this.iZj = (TextView) findViewById(e.voice_rcd_hint_word);
        this.iZk = findViewById(e.voice_rcd_hint_bg);
        findViewById(e.voice_rcd_hint).setVisibility(8);
        this.iZk.setVisibility(8);
        findViewById(e.voice_rcd_hint).setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                FavPostVoiceUI.this.aMq();
                return false;
            }
        });
        findViewById(e.fav_post_voice_footer).setVisibility(8);
        this.iZl = aMm();
        this.iZd = (Button) findViewById(e.fav_post_voice_btn);
        this.iZd.setOnTouchListener(new 5(this));
        aMo();
        String aKX = b.aKX();
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(aKX);
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        do {
            str = aKX + "/" + System.currentTimeMillis();
        } while (new com.tencent.mm.vfs.b(str).exists());
        this.path = str;
        this.iZj.post(new 3(this));
    }

    private j aMm() {
        com.tencent.mm.compatible.b.b.a aVar = com.tencent.mm.compatible.b.b.a.daM;
        j jVar = new j();
        jVar.bFw = new 4(this);
        return jVar;
    }

    private void aMn() {
        long j = 0;
        if (this.hnt) {
            boolean z;
            this.iZd.setKeepScreenOn(true);
            this.iZd.setBackgroundResource(d.record_shape_normal);
            this.iZd.setText(i.favorite_press_talk_to_fav);
            this.iZl.we();
            if (this.iZe != 0) {
                j = bi.bI(this.iZe);
            }
            this.duration = j;
            if (this.duration < 800) {
                z = true;
            } else {
                z = false;
            }
            this.erD.SO();
            this.hnz.SO();
            if (z) {
                aMp();
                this.iZd.setEnabled(false);
                this.iZd.setBackgroundResource(d.record_shape_disable);
                this.iZg.setVisibility(0);
                this.iZf.setVisibility(8);
                this.hnB.sendEmptyMessageDelayed(0, 500);
            } else {
                String str = this.path;
                int i = (int) this.duration;
                if (bi.oW(str)) {
                    x.e("MicroMsg.FavPostLogic", "postVoice path null");
                } else {
                    g gVar = new g();
                    gVar.field_type = 3;
                    gVar.field_sourceType = 6;
                    g.E(gVar);
                    vx vxVar = new vx();
                    vxVar.UP(str);
                    vxVar.CE(i);
                    vxVar.kY(true);
                    vxVar.CF(gVar.field_type);
                    vxVar.UL("amr");
                    gVar.field_favProto.rBI.add(vxVar);
                    b.B(gVar);
                    h.mEJ.h(10648, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                }
                setResult(-1);
                finish();
                overridePendingTransition(0, 0);
            }
            this.hnt = false;
        }
    }

    public final void aMo() {
        this.iZf.setVisibility(0);
        this.iZg.setVisibility(8);
        this.iZi.setVisibility(8);
        this.iZh.setVisibility(0);
        this.iZj.setText(i.fav_press_talk_start_record);
        this.iZd.setBackgroundResource(d.record_shape_press);
        this.iZd.setText(i.favorite_press_talk_to_fav);
        this.hnl.setVisibility(4);
        this.hnt = false;
    }

    private void aMp() {
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(this.path);
        if (bVar.exists()) {
            bVar.delete();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        aMn();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 != i) {
            return super.onKeyDown(i, keyEvent);
        }
        aMq();
        return true;
    }

    private void aMq() {
        if (!this.iZm) {
            this.iZm = true;
            Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            translateAnimation.setDuration(300);
            Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300);
            translateAnimation.setAnimationListener(new 8(this));
            findViewById(e.voice_rcd_hint).setVisibility(8);
            findViewById(e.fav_post_voice_footer).setVisibility(8);
            this.iZk.setVisibility(8);
            this.iZk.startAnimation(alphaAnimation);
            findViewById(e.voice_rcd_hint).startAnimation(alphaAnimation);
            findViewById(e.fav_post_voice_footer).startAnimation(translateAnimation);
        }
    }
}
