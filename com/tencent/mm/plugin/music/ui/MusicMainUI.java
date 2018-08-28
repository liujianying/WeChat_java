package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.e;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ga;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.music.b;
import com.tencent.mm.plugin.music.model.d;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

@a(19)
public class MusicMainUI extends MMActivity implements e, com.tencent.mm.ab.e {
    private ag cZl = new ag(Looper.getMainLooper());
    private c fIu = new 2(this);
    private long hmb;
    private CheckBox lAU;
    private ImageButton lAV;
    private ImageButton lAW;
    private MusicViewPager lAX;
    private com.tencent.mm.pluginsdk.i.c lAY;
    private b lAZ;
    private boolean lBa;
    private int lBb = 0;
    private Timer lBc;
    private int lBd = -1;
    private com.tencent.mm.plugin.music.b.a.c.a lwX = new 7(this);
    private boolean lzc;
    private int mode;
    private int scene;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.mode = getIntent().getIntExtra("key_mode", 2);
        this.scene = getIntent().getIntExtra("key_scene", 0);
        this.lzc = getIntent().getBooleanExtra("KGlobalShakeMusic", false);
        this.lAX = (MusicViewPager) findViewById(b.c.view_pager);
        this.lAZ = new b(this, this.scene, this.lzc);
        this.lAX.setAdapter(this.lAZ);
        this.lAX.setOnPageChangeListener(this);
        this.lAX.setSystemUiVisibility(4096);
        this.lAV = (ImageButton) findViewById(b.c.back_btn);
        this.lAW = (ImageButton) findViewById(b.c.send_btn);
        LayoutParams layoutParams = (LayoutParams) this.lAV.getLayoutParams();
        int i = layoutParams.topMargin;
        if (ak.gw(this.mController.tml)) {
            i += ak.eL(this.mController.tml);
        }
        layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, layoutParams.bottomMargin);
        this.lAV.setLayoutParams(layoutParams);
        layoutParams = (LayoutParams) this.lAW.getLayoutParams();
        i = layoutParams.topMargin;
        if (ak.gw(this.mController.tml)) {
            i += ak.eL(this.mController.tml);
        }
        layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, layoutParams.bottomMargin);
        this.lAW.setLayoutParams(layoutParams);
        this.lAU = (CheckBox) findViewById(b.c.music_play_btn);
        this.lAU.setChecked(!h.bic().bhQ().PY());
        this.lAY = new com.tencent.mm.pluginsdk.i.c(this);
        this.lAU.setOnClickListener(new 1(this));
        com.tencent.mm.sdk.b.a.sFg.b(this.fIu);
        if (!this.lAY.ccS()) {
            x.w("MicroMsg.Music.MusicMainUI", "not support shake");
        }
        biI();
        this.lAX.setCurrentItem(100000 + h.bic().lya);
        biK();
        int i2 = this.scene;
        if (h.bic().bhR() != null) {
            x.v("MicroMsg.Music.MusicReportUtil", "kvReportEnterMusicUI: %d, %d, %s, %s, %s, %s, %s, %s", new Object[]{Integer.valueOf(13041), Integer.valueOf(i2), h.bic().bhR().field_musicId, h.bic().bhR().field_songName, h.bic().bhR().field_songAlbum, Integer.valueOf(h.bic().bhR().field_songId), h.bic().bhR().field_songSinger, h.bic().bhR().field_appId});
            com.tencent.mm.plugin.report.service.h.mEJ.h(13041, new Object[]{Integer.valueOf(i2), r1.field_musicId, r1.field_songName, r1.field_songAlbum, Integer.valueOf(r1.field_songId), r1.field_songSinger, r1.field_appId});
        }
        com.tencent.mm.plugin.report.service.h.mEJ.a(285, 1, 1, false);
        com.tencent.mm.an.a bhR = h.bic().bhR();
        if (bhR == null) {
            finish();
            return;
        }
        if (this.scene == 4 && h.bic().mode == 2) {
            i = g.Ei().DT().getInt(83, 0);
            if (i < 3) {
                Toast.makeText(this, b.e.fts_search_enter_wording, 0).show();
                g.Ei().DT().set(83, Integer.valueOf(i + 1));
            }
        }
        if (this.scene == 5) {
            f.a(0, bhR);
        }
        p(bhR);
        if (this.mode == 1) {
            if (this.lBc == null) {
                this.lBc = new Timer();
            }
            this.lBc.schedule(new 3(this), 0, 500);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
    }

    protected void onResume() {
        int i;
        super.onResume();
        com.tencent.mm.an.a bhR = h.bic().bhR();
        if (bhR != null) {
            switch (bhR.field_musicType) {
                case 1:
                case 4:
                case 6:
                case 8:
                case 9:
                    i = 1;
                    break;
            }
        }
        i = (byte) 0;
        if (i == 0) {
            x.i("MicroMsg.Music.MusicMainUI", "no need to shake music");
            h.bic().mode = 1;
        } else if (!this.lzc) {
            if (!(this.lAY == null || !this.lAY.ccS() || this.lAY.ccQ())) {
                this.lAY.a(new b(this, (byte) 0));
            }
            this.hmb = bi.VG();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.lAY != null) {
            this.lAY.aDc();
        }
    }

    private void biI() {
        h.bic();
        this.lAZ.count = 200000;
        this.lAZ.notifyDataSetChanged();
        if (h.bic().bhW()) {
            this.lAX.setCanSlide(true);
        } else {
            this.lAX.setCanSlide(false);
        }
    }

    private void biJ() {
        if (this.lBc != null) {
            this.lBc.cancel();
        }
        this.lBc = null;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lAY != null) {
            this.lAY.aDc();
        }
        if (this.lAZ != null) {
            b bVar = this.lAZ;
            bVar.lxW.removeCallbacksAndMessages(null);
            d dVar = bVar.lAC;
            dVar.lxW.removeCallbacksAndMessages(null);
            dVar.cYh.clear();
        }
        biJ();
        com.tencent.mm.sdk.b.a.sFg.c(this.fIu);
        biL();
        if (!h.bic().bhQ().PY()) {
            h.bic().bhQ().stopPlay();
        }
        com.tencent.mm.plugin.music.model.e bic = h.bic();
        if (!bic.lyc.PY() && !bic.lyd.PY()) {
            x.i("MicroMsg.Music.MusicPlayerManager", "really exit music");
            bic.mode = 1;
        }
    }

    public void onClickBack(View view) {
        finish();
    }

    public void onClickSend(View view) {
        avq bhS = h.bic().bhS();
        x.i("MicroMsg.Music.MusicMainUI", "MusicType:%d, SongWebUrl ", new Object[]{Integer.valueOf(bhS.rYj), bhS.rYr});
        if (bhS.rYj == 11) {
            ga gaVar = new ga();
            com.tencent.mm.sdk.b.a.sFg.m(gaVar);
            String str = gaVar.bPf.appId;
            CharSequence charSequence = gaVar.bPf.bKC;
            String str2 = gaVar.bPf.bPg;
            int i = gaVar.bPf.bPh;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            x.i("MicroMsg.Music.MusicMainUI", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", new Object[]{str, charSequence, Integer.valueOf(i), str2});
            String string = getString(b.e.go_to_app_brand, new Object[]{charSequence});
            if (TextUtils.isEmpty(bhS.rYr)) {
                String[] strArr = new String[]{string};
                new ArrayList().add(Integer.valueOf(0));
                com.tencent.mm.ui.base.h.a((Context) this, "", strArr, "", new 5(this, str, str2, i));
                return;
            }
            List arrayList = new ArrayList();
            String[] strArr2 = new String[]{getString(b.e.music_send_to_friend), getString(b.e.music_share_timeline), getString(b.e.chatting_fav), string};
            arrayList.add(Integer.valueOf(0));
            arrayList.add(Integer.valueOf(1));
            arrayList.add(Integer.valueOf(2));
            arrayList.add(Integer.valueOf(3));
            com.tencent.mm.ui.base.h.a((Context) this, "", strArr2, "", new 4(this, bhS, str, str2, i));
        } else if (!TextUtils.isEmpty(bhS.rYr)) {
            List arrayList2 = new ArrayList();
            String[] strArr3 = new String[]{getString(b.e.music_send_to_friend), getString(b.e.music_share_timeline), getString(b.e.chatting_fav), getString(b.e.fav_to_qq_music)};
            arrayList2.add(Integer.valueOf(0));
            arrayList2.add(Integer.valueOf(1));
            arrayList2.add(Integer.valueOf(2));
            arrayList2.add(Integer.valueOf(3));
            com.tencent.mm.ui.base.h.a((Context) this, "", strArr3, "", new 6(this, bhS));
        }
    }

    protected final int getLayoutId() {
        return b.d.music_main_ui;
    }

    public final void a(int i, float f, int i2) {
    }

    private void p(com.tencent.mm.an.a aVar) {
        if (!com.tencent.mm.plugin.music.model.g.f(aVar) || this.lzc) {
            this.lAU.setVisibility(8);
            this.lAW.setVisibility(8);
            return;
        }
        this.lAU.setVisibility(0);
        this.lAW.setVisibility(0);
    }

    public final void O(int i) {
        x.i("MicroMsg.Music.MusicMainUI", "onPageSelected %d", new Object[]{Integer.valueOf(i)});
        if (h.bic().bhW()) {
            this.lAX.setCanSlide(false);
        }
        this.cZl.removeCallbacksAndMessages(null);
        this.cZl.postDelayed(new a(this, i), 500);
        if (this.lBd == -1) {
            this.lBd = i;
        }
        if (this.lBd != i) {
            this.lBd = i;
            f.lyn = true;
            com.tencent.mm.plugin.report.service.h.mEJ.a(285, 3, 1, false);
            f.cW(1, this.scene);
        }
    }

    public final void N(int i) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (-1 == i2 && 1 == i) {
            com.tencent.mm.plugin.music.model.g.a(h.bic().bhS(), intent, this);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    public final void biK() {
        h.bic().bhQ().a(this.lwX);
    }

    public static void biL() {
        h.bic().bhQ().a(null);
    }

    public final void q(com.tencent.mm.an.a aVar) {
        com.tencent.mm.an.a bhR = h.bic().bhR();
        if (bhR != null && bhR.a(aVar) && this.lAW != null && this.lAV != null && this.lAU != null && this.lAW.getBackground() != null && this.lAV.getBackground() != null && this.lAU.getBackground() != null) {
            if (aVar.PT()) {
                int i = aVar.field_songLyricColor;
                this.lAW.getBackground().setColorFilter(i, Mode.MULTIPLY);
                this.lAV.getBackground().setColorFilter(i, Mode.MULTIPLY);
                this.lAU.getBackground().setColorFilter(i, Mode.MULTIPLY);
                return;
            }
            this.lAW.getBackground().setColorFilter(-1, Mode.MULTIPLY);
            this.lAV.getBackground().setColorFilter(-1, Mode.MULTIPLY);
            this.lAU.getBackground().setColorFilter(-1, Mode.MULTIPLY);
        }
    }
}
