package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView.5;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.f;

@a(3)
public class FavoriteVideoPlayUI extends MMActivity {
    private String bOX;
    private boolean bUY = true;
    private String dXA;
    private Bundle hDg;
    private boolean hDh = false;
    private f hDi;
    private int hDj = 0;
    private int hDk = 0;
    private int hDl = 0;
    private int hDm = 0;
    private OnClickListener iZP = new 1(this);
    private OnLongClickListener jcS = new 2(this);
    private int jdD;
    private String jdE;
    private RelativeLayout jdF;
    private ImageView jdG;
    private FavVideoView jdH;
    private LinearLayout jdI;
    private boolean jdJ = true;
    private int jdK;
    private boolean jdL = false;
    private String jdM = "";
    private boolean jdl = true;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (d.fR(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(1024, 1024);
        }
        this.hDg = bundle;
        getWindow().addFlags(128);
        this.jdJ = getIntent().getBooleanExtra("key_detail_data_valid", true);
        this.dXA = getIntent().getStringExtra("key_detail_fav_path");
        this.bOX = getIntent().getStringExtra("key_detail_fav_thumb_path");
        this.jdD = getIntent().getIntExtra("key_detail_fav_video_duration", 0);
        this.jdE = getIntent().getStringExtra("key_detail_statExtStr");
        this.jdK = getIntent().getIntExtra("key_detail_fav_video_scene_from", 0);
        this.bUY = getIntent().getBooleanExtra("show_share", true);
        this.jdL = getIntent().getBooleanExtra("key_detail_fav_video_show_download_status", false);
        this.jdM = getIntent().getStringExtra("key_detail_data_id");
        if (!e.cn(this.bOX)) {
            Bitmap By = c.By(this.dXA);
            if (By != null) {
                try {
                    x.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: create thumbpath bitmap, saveBitmapToImage ");
                    com.tencent.mm.sdk.platformtools.c.a(By, 60, CompressFormat.JPEG, this.bOX, true);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FavoriteVideoPlayUI", e, "", new Object[0]);
                }
            }
        }
        String str = "MicroMsg.FavoriteVideoPlayUI";
        String str2 = "VideoPlay: init data, isVideoValid: %B. thumbPath: %s, fullPath: %s";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.jdJ);
        objArr[1] = bi.oW(this.bOX) ? "" : this.bOX;
        objArr[2] = bi.oW(this.dXA) ? "" : this.dXA;
        x.i(str, str2, objArr);
        this.jdF = (RelativeLayout) findViewById(m.e.video_ui_root);
        this.jdH = (FavVideoView) findViewById(m.e.video_view);
        ImageView imageView = (ImageView) findViewById(m.e.video_thumb);
        this.jdG = (ImageView) findViewById(m.e.gallery_bg);
        this.jdI = (LinearLayout) findViewById(m.e.fav_expired_btn);
        if (!(this.jdJ || this.jdI == null)) {
            this.jdI.setVisibility(0);
        }
        if (this.jdG != null) {
            this.jdG.setLayerType(2, null);
        }
        if (bi.oW(this.dXA)) {
            b(imageView);
        } else if (FileOp.cn(this.dXA)) {
            this.jdH.setVideoData(this.dXA);
            x.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  videoView.setVideoData(fullPath)");
        } else {
            b(imageView);
        }
        this.jdH.setOnClickListener(this.iZP);
        if (this.bUY) {
            this.jdH.setOnLongClickListener(this.jcS);
        }
        this.hDi = new f(null);
    }

    protected final int getLayoutId() {
        return m.f.fav_video_play_ui;
    }

    private void b(ImageView imageView) {
        FavVideoView favVideoView = this.jdH;
        String str = this.dXA;
        boolean z = this.jdL;
        String str2 = this.jdM;
        favVideoView.dXA = str;
        if (z) {
            favVideoView.hDf.post(new 5(favVideoView));
            favVideoView.jdM = str2;
        }
        if (imageView != null) {
            if (e.cn(this.bOX)) {
                imageView.setImageBitmap(b.e(this.bOX, 1.0f));
            } else {
                imageView.setImageResource(m.d.chat_video_nf_mask_from);
            }
        }
        x.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: fullPath is not null,but not exist videoView.setVideoData(null)");
    }

    public static void f(String str, Context context) {
        String nX = t.nX(str);
        x.i("MicroMsg.FavoriteVideoPlayUI", "save video now video path %s out path %s", new Object[]{str, nX});
        if (bi.oW(nX)) {
            Toast.makeText(context, context.getString(i.video_file_save_failed), 1).show();
            return;
        }
        Toast.makeText(context, context.getString(i.video_file_saved, new Object[]{nX}), 1).show();
        l.a(nX, context);
    }

    public void onStart() {
        Bundle bundle = this.hDg;
        if (!this.hDh) {
            this.hDh = true;
            if (VERSION.SDK_INT >= 12) {
                this.hDj = getIntent().getIntExtra("img_gallery_top", 0);
                this.hDk = getIntent().getIntExtra("img_gallery_left", 0);
                this.hDl = getIntent().getIntExtra("img_gallery_width", 0);
                this.hDm = getIntent().getIntExtra("img_gallery_height", 0);
                this.hDi.u(this.hDk, this.hDj, this.hDl, this.hDm);
                if (bundle == null) {
                    this.jdH.getViewTreeObserver().addOnPreDrawListener(new 4(this));
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        x.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  onResume,hadOnStart is %B", new Object[]{Boolean.valueOf(this.jdl)});
        if (!this.jdl) {
            this.jdH.onResume();
        }
        this.jdl = false;
        super.onResume();
        com.tencent.mm.plugin.webview.ui.tools.widget.m.Bk(1);
    }

    protected void onPause() {
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        FavVideoView favVideoView = this.jdH;
        x.i("MicroMsg.FavVideoView", "VideoPlay:   onPause()");
        if (favVideoView.hEl.isPlaying()) {
            x.i("MicroMsg.FavVideoView", "VideoPlay: pausePlay()");
            favVideoView.hEl.pause();
        }
        super.onPause();
        com.tencent.mm.plugin.webview.ui.tools.widget.m.Bk(2);
    }

    protected void onDestroy() {
        setResult(0, getIntent().putExtra("key_activity_browse_time", cql()));
        FavVideoView favVideoView = this.jdH;
        x.i("MicroMsg.FavVideoView", "VideoPlay:   onDestroy()");
        favVideoView.hEl.stop();
        ((com.tencent.mm.plugin.record.a.a) g.n(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(favVideoView.jfR);
        ((ae) g.n(ae.class)).getFavCdnStorage().b(favVideoView.jfR);
        getWindow().clearFlags(128);
        super.onDestroy();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
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
            3 3 = new 3(this, h.a(this.mController.tml, getString(i.favorite_forward_tips), false, null));
            if (!bi.oW(stringExtra)) {
                for (String stringExtra2 : bi.F(stringExtra2.split(","))) {
                    ActionBarActivity actionBarActivity = this.mController.tml;
                    String str2 = this.dXA;
                    String str3 = this.bOX;
                    int i3 = this.jdD;
                    String str4 = this.jdE;
                    if (actionBarActivity == null) {
                        x.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
                    } else if (bi.oW(stringExtra2)) {
                        x.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
                    } else {
                        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str2);
                        if (!bi.oW(str2) || bVar.exists()) {
                            g.Em().H(new com.tencent.mm.plugin.fav.ui.h.5(actionBarActivity, stringExtra2, str2, str3, i3, str4, 3));
                        } else {
                            x.w("MicroMsg.FavSendLogic", "want to send fav video, but datapath is null or is not exist ");
                        }
                    }
                    if (!bi.oW(str)) {
                        com.tencent.mm.plugin.messenger.a.g.bcT().D(stringExtra2, str, s.hQ(stringExtra2));
                    }
                }
                com.tencent.mm.ui.widget.snackbar.b.h(this, getString(i.fav_finish_sent));
                return;
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void ayH() {
        this.jdI.setVisibility(8);
        int width = this.jdF.getWidth();
        int height = this.jdF.getHeight();
        if (!(this.hDl == 0 || this.hDm == 0)) {
            height = (int) ((((float) width) / ((float) this.hDl)) * ((float) this.hDm));
        }
        this.hDi.fh(width, height);
        this.hDi.u(this.hDk, this.hDj, this.hDl, this.hDm);
        this.hDi.a(this.jdH, this.jdG, new 5(this), null);
    }

    public void onBackPressed() {
        ayH();
    }
}
