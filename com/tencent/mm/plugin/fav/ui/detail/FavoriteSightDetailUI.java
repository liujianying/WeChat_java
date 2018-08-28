package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.ui.FavDetailFooterView;
import com.tencent.mm.plugin.fav.ui.h;
import com.tencent.mm.plugin.fav.ui.m.d;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.fav.ui.widget.FavDetailTitleView;
import com.tencent.mm.plugin.fav.ui.widget.FavTagEntrance;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class FavoriteSightDetailUI extends BaseFavDetailReportUI implements p, a {
    private vx bOz;
    private k jaf = new k();
    private g jaq;
    private boolean jcp = false;
    private boolean jcv = false;
    private FavDetailTitleView jdc;
    private FavDetailFooterView jdd;
    private FavTagEntrance jde;
    private View jdf;
    private ImageView jdg;
    private MMPinProgressBtn jdh;
    private VideoPlayerTextureView jdi;
    private ImageView jdj;
    private long jdk;
    private boolean jdl = true;
    private boolean jdm = false;
    private Runnable jdn = new 5(this);
    private boolean jdo = false;

    static /* synthetic */ void a(FavoriteSightDetailUI favoriteSightDetailUI, boolean z, Context context) {
        vx c = b.c(favoriteSightDetailUI.jaq);
        Intent intent;
        if (c == null) {
            x.e("MicroMsg.FavoriteSightDetailUI", "goPlayView, but dataitem is null , exit");
        } else if (c.rAo == null || (bi.oW(c.rAo.dyJ) && bi.oW(c.rAo.dyN))) {
            intent = new Intent();
            intent.putExtra("key_detail_info_id", favoriteSightDetailUI.jaq.field_localId);
            intent.putExtra("key_detail_fav_scene", favoriteSightDetailUI.jcb.scene);
            intent.putExtra("key_detail_fav_sub_scene", favoriteSightDetailUI.jcb.iVT);
            intent.putExtra("key_detail_fav_path", b.b(c));
            intent.putExtra("key_detail_fav_thumb_path", b.c(c));
            intent.putExtra("key_detail_fav_video_duration", c.duration);
            intent.putExtra("key_detail_statExtStr", c.bZN);
            intent.putExtra("key_detail_data_valid", z);
            b.a(context, ".ui.detail.FavoriteVideoPlayUI", intent);
        } else {
            x.i("MicroMsg.FavoriteSightDetailUI", "it is ad sight.use sight play");
            intent = new Intent();
            intent.putExtra("key_detail_fav_scene", favoriteSightDetailUI.jcb.scene);
            intent.putExtra("key_detail_fav_sub_scene", favoriteSightDetailUI.jcb.iVT);
            intent.putExtra("key_detail_info_id", favoriteSightDetailUI.jaq.field_localId);
            intent.putExtra("key_detail_data_id", c.jdM);
            intent.putExtra("key_detail_can_delete", false);
            b.a(context, ".ui.detail.FavoriteFileDetailUI", intent);
        }
    }

    protected final int getLayoutId() {
        return f.favorite_sight_detail_ui;
    }

    protected final MMLoadScrollView aMI() {
        return (MMLoadScrollView) findViewById(e.scroll_view);
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        com.tencent.mm.pluginsdk.e.k(this);
        super.onCreate(bundle);
        this.jdk = getIntent().getLongExtra("key_detail_info_id", -1);
        this.jaq = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(this.jdk);
        if (this.jaq == null) {
            x.w("MicroMsg.FavoriteSightDetailUI", "id[%d] info is null, return", new Object[]{Long.valueOf(this.jdk)});
            finish();
            return;
        }
        F(this.jaq);
        m.w(this.jaq);
        this.bOz = b.c(this.jaq);
        this.jdc = (FavDetailTitleView) findViewById(e.fav_detail_title);
        this.jdd = (FavDetailFooterView) findViewById(e.fav_detail_footer);
        this.jde = (FavTagEntrance) findViewById(e.fav_tag_entrance);
        this.jdg = (ImageView) findViewById(e.status_btn);
        this.jdh = (MMPinProgressBtn) findViewById(e.video_progress);
        this.jdf = findViewById(e.click_area);
        this.jdi = (VideoPlayerTextureView) findViewById(e.video_view);
        this.jdj = (ImageView) findViewById(e.video_thumb);
        this.jde.setFavItemID(this.jaq.field_localId);
        this.jde.setTagContent(this.jaq.field_tagProto.rBX);
        this.jdc.D(this.jaq);
        this.jdd.D(this.jaq);
        this.jdf.setOnClickListener(new 1(this));
        this.jdi.setVideoCallback(new 2(this));
        setMMTitle(getString(i.favorite_detail));
        setBackBtn(new 3(this));
        addIconOptionMenu(0, i.top_item_desc_more, d.mm_title_btn_menu, new 4(this));
        if (com.tencent.mm.a.e.cn(b.c(this.bOz))) {
            Bitmap a = com.tencent.mm.plugin.fav.ui.k.a(this.bOz, this.jaq);
            if (a != null) {
                int width = a.getWidth();
                int height = a.getHeight();
                if (!this.jdo) {
                    this.jdo = true;
                    DisplayMetrics displayMetrics = this.jdf.getResources().getDisplayMetrics();
                    float f = (displayMetrics.density * 36.0f) + 0.5f;
                    LayoutParams layoutParams = this.jdf.getLayoutParams();
                    if (layoutParams == null) {
                        x.e("MicroMsg.FavoriteSightDetailUI", "setViewResize, but params is null");
                    } else {
                        layoutParams.width = displayMetrics.widthPixels - ((int) f);
                        layoutParams.height = (height * layoutParams.width) / width;
                        this.jdf.setLayoutParams(layoutParams);
                    }
                }
                this.jdj.setImageBitmap(a);
                this.jdj.setVisibility(0);
            }
        } else if (!bi.oW(this.bOz.dwE)) {
            b.a(this.jaq, this.bOz);
        }
        eW(false);
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().c(this.jde);
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().c(this);
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().a(this);
        com.tencent.mm.pluginsdk.e.l(this);
    }

    protected void onDestroy() {
        if (this.jdi != null) {
            this.jdi.setVideoCallback(null);
            this.jdi.stop();
        }
        if (this.jde != null) {
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().d(this.jde);
        }
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().d(this);
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().b(this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        if (this.jdi != null) {
            if (!this.jdl) {
                aMP();
            } else if (!this.jdi.isPlaying()) {
                this.jdi.start();
            }
            this.jdl = false;
        }
    }

    protected void onPause() {
        if (this.jdi != null) {
            this.jdi.stop();
        }
        super.onPause();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"ResourceType"})
    private void eW(boolean r5) {
        /*
        r4 = this;
        r3 = 8;
        r2 = 0;
        r0 = r4.jaq;
        r0 = r0.isDone();
        if (r0 == 0) goto L_0x0053;
    L_0x000b:
        r0 = r4.bOz;
        r0 = com.tencent.mm.plugin.fav.a.b.f(r0);
        if (r0 == 0) goto L_0x0021;
    L_0x0013:
        r0 = r4.jdg;
        r0.setVisibility(r3);
        r0 = r4.jdh;
        r0.setVisibility(r3);
        r4.aMP();
    L_0x0020:
        return;
    L_0x0021:
        r0 = r4.bOz;
        r0 = r0.rzo;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 == 0) goto L_0x0042;
    L_0x002b:
        r0 = r4.jdg;
        r1 = com.tencent.mm.plugin.fav.ui.m.h.shortvideo_play_btn;
        r0.setImageResource(r1);
    L_0x0032:
        r0 = r4.jdg;
        r0.setVisibility(r2);
        r0 = r4.jdh;
        r0.setVisibility(r3);
        r0 = r4.jdj;
        r0.setVisibility(r2);
        goto L_0x0020;
    L_0x0042:
        r0 = "MicroMsg.FavoriteSightDetailUI";
        r1 = "? info is done, source file not exist, cdn data url is not null";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r0 = r4.jdg;
        r1 = com.tencent.mm.plugin.fav.ui.m.h.shortvideo_play_btn;
        r0.setImageResource(r1);
        goto L_0x0032;
    L_0x0053:
        r0 = r4.jaq;
        r0 = r0.aLh();
        if (r0 == 0) goto L_0x0086;
    L_0x005b:
        r0 = r4.bOz;
        r0 = r0.rzo;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 == 0) goto L_0x006f;
    L_0x0065:
        r0 = r4.jdg;
        r1 = com.tencent.mm.plugin.fav.ui.m.h.shortvideo_play_btn;
        r0.setImageResource(r1);
        if (r5 == 0) goto L_0x0032;
    L_0x006e:
        goto L_0x0032;
    L_0x006f:
        r0 = r4.jdg;
        r1 = com.tencent.mm.plugin.fav.ui.m.h.shortvideo_play_btn;
        r0.setImageResource(r1);
        if (r5 == 0) goto L_0x0032;
    L_0x0078:
        r0 = r4.mController;
        r0 = r0.tml;
        r1 = com.tencent.mm.plugin.fav.ui.m.i.download_fail;
        r1 = r4.getString(r1);
        com.tencent.mm.ui.base.h.bA(r0, r1);
        goto L_0x0032;
    L_0x0086:
        r0 = r4.jaq;
        r0 = r0.aLg();
        if (r0 == 0) goto L_0x00a5;
    L_0x008e:
        r0 = r4.jdg;
        r1 = com.tencent.mm.plugin.fav.ui.m.h.shortvideo_play_btn;
        r0.setImageResource(r1);
        if (r5 == 0) goto L_0x0032;
    L_0x0097:
        r0 = r4.mController;
        r0 = r0.tml;
        r1 = com.tencent.mm.plugin.fav.ui.m.i.fav_upload_fail;
        r1 = r4.getString(r1);
        com.tencent.mm.ui.base.h.bA(r0, r1);
        goto L_0x0032;
    L_0x00a5:
        r0 = r4.jaq;
        r0 = r0.isDownloading();
        if (r0 != 0) goto L_0x00b5;
    L_0x00ad:
        r0 = r4.jaq;
        r0 = r0.aLf();
        if (r0 == 0) goto L_0x00ec;
    L_0x00b5:
        r0 = r4.jdg;
        r0.setVisibility(r3);
        r0 = r4.jdh;
        r0.setVisibility(r2);
        r0 = com.tencent.mm.plugin.fav.a.ae.class;
        r0 = com.tencent.mm.kernel.g.n(r0);
        r0 = (com.tencent.mm.plugin.fav.a.ae) r0;
        r0 = r0.getFavCdnStorage();
        r1 = r4.bOz;
        r1 = r1.jdM;
        r0 = r0.Br(r1);
        if (r0 == 0) goto L_0x00e6;
    L_0x00d5:
        r1 = r4.jdh;
        r0 = r0.getProgress();
        r0 = (int) r0;
        r1.setProgress(r0);
    L_0x00df:
        r0 = r4.jdj;
        r0.setVisibility(r2);
        goto L_0x0020;
    L_0x00e6:
        r0 = r4.jdh;
        r0.setProgress(r2);
        goto L_0x00df;
    L_0x00ec:
        r0 = "MicroMsg.FavoriteSightDetailUI";
        r1 = "other status, not done, downloading, uploading, downloadfail, uploadfail";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r0 = r4.jdg;
        r1 = com.tencent.mm.plugin.fav.ui.m.h.shortvideo_play_btn;
        r0.setImageResource(r1);
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.eW(boolean):void");
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.FavoriteSightDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[]{str, Long.valueOf(this.jaq.field_localId)});
        g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(this.jaq.field_localId);
        if (dy == null) {
            x.w("MicroMsg.FavoriteSightDetailUI", "error, on notify change, cannot find info");
            finish();
            return;
        }
        boolean z;
        this.jaq = dy;
        this.bOz = b.c(dy);
        c Br = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(this.bOz.jdM);
        if (Br == null) {
            z = false;
        } else if (this.jcv) {
            z = false;
        } else {
            if (Br.field_status == 4 && ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(this.bOz.jdM).field_extFlag != 0) {
                b.a(this.jaq, this.bOz, true);
                this.jcv = true;
            }
            x.i("MicroMsg.FavoriteSightDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[]{Boolean.valueOf(this.jcv)});
            z = this.jcv;
        }
        if (!z) {
            ah.M(this.jdn);
            ah.i(this.jdn, 500);
        }
    }

    public final void d(c cVar) {
        if (cVar == null || cVar.field_dataId == null) {
            x.w("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, item is null");
            return;
        }
        x.i("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, dataID is %s, field id is %s,offset is %d, total is %d,cdn status is %d, cdn type is %d (send or recieve)", new Object[]{this.bOz.jdM, cVar.field_dataId, Integer.valueOf(cVar.field_offset), Integer.valueOf(cVar.field_totalLen), Integer.valueOf(cVar.field_status), Integer.valueOf(cVar.field_type)});
        if (cVar.field_offset > cVar.field_totalLen) {
            x.e("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, cdn offset length > cdn total length, do cdnLengthError()");
            if (1 == cVar.field_type) {
                cVar.field_status = 2;
            } else {
                cVar.field_status = 4;
            }
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().a(cVar, new String[0]);
            if (cVar.field_type == 0) {
                b.a(cVar);
            }
            if (cVar.field_type == 1) {
                b.b(cVar);
            }
        }
        if (cVar.field_dataId.equals(this.bOz.jdM)) {
            this.jdh.post(new 6(this, (int) cVar.getProgress()));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && -1 == i2) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            h.a(this.mController.tml, stringExtra, str, this.jaq, new 7(this, com.tencent.mm.ui.base.h.a(this.mController.tml, getString(i.favorite_forward_tips), false, null)));
            boolean fq = s.fq(stringExtra);
            m.a(fq ? m.c.iWy : m.c.iWx, this.jaq, m.d.iWB, fq ? com.tencent.mm.model.m.gK(stringExtra) : 0);
            com.tencent.mm.ui.widget.snackbar.b.h(this, getString(i.fav_finish_sent));
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    private void aMP() {
        String b = b.b(this.bOz);
        if (com.tencent.mm.a.e.cn(b)) {
            this.jdi.stop();
            this.jdi.setMute(true);
            this.jdi.setVideoPath(b);
        }
    }
}
