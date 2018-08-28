package com.tencent.mm.plugin.webview.fts.c;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.plugin.webview.fts.ui.b.1;
import com.tencent.mm.plugin.webview.fts.ui.b.2;
import com.tencent.mm.plugin.webview.fts.ui.b.4;
import com.tencent.mm.plugin.webview.fts.ui.b.5;
import com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass3;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements e {
    private Context context;
    public d pNV;
    private b pQK;
    com.tencent.mm.plugin.webview.fts.ui.b pQO;
    private ba<FtsWebVideoView> pQP = new ba(3);

    public interface a {
        void agK();

        void agL();

        boolean agV();

        void ajd();

        void bIu();

        void bTS();

        void onDestroy();
    }

    public b(Context context, MMWebView mMWebView, b bVar) {
        this.context = context;
        this.pQK = bVar;
        this.pQO = new com.tencent.mm.plugin.webview.fts.ui.b(mMWebView, bVar);
    }

    public final void w(final int i, String str, String str2) {
        x.i("FtsVideoPlayerMgr", "insert player id %d,viewProps %s,videoProps %s", new Object[]{Integer.valueOf(i), str, str2});
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                x.e("FtsVideoPlayerMgr", "insert args invalid");
                return;
            }
            FtsWebVideoView ftsWebVideoView;
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            FtsWebVideoView ftsWebVideoView2 = (FtsWebVideoView) this.pQP.bW();
            if (ftsWebVideoView2 == null) {
                ftsWebVideoView = new FtsWebVideoView(this.context, jSONObject2.optBoolean("autoPlay"));
            } else {
                ftsWebVideoView2.stop();
                ftsWebVideoView = ftsWebVideoView2;
            }
            ftsWebVideoView.setIsShowBasicControls(true);
            ftsWebVideoView.setVideoSizeByte(jSONObject2.optInt("fileSize"));
            ftsWebVideoView.setMute(jSONObject2.optBoolean("isMute"));
            ftsWebVideoView.setCover$16da05f7(jSONObject2.optString("coverUrl"));
            ftsWebVideoView.setVideoPlayerId(i);
            ftsWebVideoView.setAutoPlay(jSONObject2.optBoolean("autoPlay"));
            ftsWebVideoView.cv(c.an(jSONObject2), jSONObject2.optInt("durationSec"));
            final 1 1 = new 1(this, ftsWebVideoView);
            ftsWebVideoView.setFullScreenDelegate(new com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.a() {
                public final void jU(boolean z) {
                    com.tencent.mm.plugin.webview.fts.ui.b bVar = b.this.pQO;
                    4 4 = new 4(bVar, Boolean.valueOf(false), i, 1, z);
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        ((Boolean) 4.a(null)).booleanValue();
                    } else {
                        ((Boolean) 4.a(bVar.mHandler)).booleanValue();
                    }
                }

                public final void ajc() {
                    com.tencent.mm.plugin.webview.fts.ui.b bVar = b.this.pQO;
                    5 5 = new 5(bVar, Boolean.valueOf(false), i);
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        ((Boolean) 5.a(null)).booleanValue();
                    } else {
                        ((Boolean) 5.a(bVar.mHandler)).booleanValue();
                    }
                }

                public final boolean isFullScreen() {
                    return b.this.pQO.lz(i);
                }
            });
            3 3 = new 3(this, ftsWebVideoView);
            ftsWebVideoView.setUiLifecycleListener(3);
            this.pQK.a(3);
            ftsWebVideoView.setCallback(new d(ftsWebVideoView, this.pQK, this.pNV));
            com.tencent.mm.plugin.webview.fts.ui.b bVar = this.pQO;
            1 12 = new 1(bVar, Boolean.valueOf(false), ftsWebVideoView, i, c.a(jSONObject, this.context), c.m(jSONObject));
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                ((Boolean) 12.a(null)).booleanValue();
            } else {
                ((Boolean) 12.a(bVar.mHandler)).booleanValue();
            }
        } catch (JSONException e) {
            x.e("FtsVideoPlayerMgr", "", new Object[]{e});
        }
    }

    public final void x(int i, String str, String str2) {
        x.i("FtsVideoPlayerMgr", "update player id %d,viewProps %s,videoProps %s", new Object[]{Integer.valueOf(i), str, str2});
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                com.tencent.mm.plugin.webview.fts.ui.b bVar = this.pQO;
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(Boolean.valueOf(false), i, c.a(jSONObject, this.context), c.m(jSONObject));
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    ((Boolean) anonymousClass3.a(null)).booleanValue();
                } else {
                    ((Boolean) anonymousClass3.a(bVar.mHandler)).booleanValue();
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject2 = new JSONObject(str2);
                FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.pQO.lx(i);
                if (ftsWebVideoView == null) {
                    x.i("FtsVideoPlayerMgr", "can not find video View by id %d", new Object[]{Integer.valueOf(i)});
                    return;
                }
                if (jSONObject2.has("autoPlay")) {
                    ftsWebVideoView.setAutoPlay(jSONObject2.optBoolean("autoPlay"));
                }
                if (jSONObject2.has("coverUrl")) {
                    ftsWebVideoView.setCover$16da05f7(jSONObject2.optString("coverUrl"));
                }
                if (jSONObject2.has("durationSec")) {
                    ftsWebVideoView.setDuration(jSONObject2.optInt("durationSec"));
                }
                if (jSONObject2.has("playUrl")) {
                    ftsWebVideoView.cv(c.an(jSONObject2), jSONObject2.optInt("durationSec"));
                }
                if (jSONObject2.has("isMute")) {
                    ftsWebVideoView.setMute(jSONObject2.optBoolean("isMute"));
                }
            }
        } catch (JSONException e) {
            x.e("FtsVideoPlayerMgr", "", new Object[]{e});
        }
    }

    public final void Ak(int i) {
        x.i("FtsVideoPlayerMgr", "remove palyer id %d", new Object[]{Integer.valueOf(i)});
        FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.pQO.lx(i);
        if (ftsWebVideoView != null) {
            ftsWebVideoView.getUiLifecycleListener();
        } else {
            x.w("FtsVideoPlayerMgr", "can not find player by id %d", new Object[]{Integer.valueOf(i)});
        }
        com.tencent.mm.plugin.webview.fts.ui.b bVar = this.pQO;
        2 2 = new 2(bVar, Boolean.valueOf(false), i);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ((Boolean) 2.a(null)).booleanValue();
        } else {
            ((Boolean) 2.a(bVar.mHandler)).booleanValue();
        }
        if (ftsWebVideoView != null) {
            ftsWebVideoView.stop();
            ftsWebVideoView.getCallback().clean();
            ftsWebVideoView.setCallback(null);
            ftsWebVideoView.setVisibility(0);
            ftsWebVideoView.setAllowMobileNetPlay(false);
            this.pQP.j(ftsWebVideoView);
        }
    }

    public final void aT(int i, String str) {
        x.i("FtsVideoPlayerMgr", "op player id %d,type %s", new Object[]{Integer.valueOf(i), str});
        FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.pQO.lx(i);
        if (ftsWebVideoView != null) {
            boolean z = true;
            switch (str.hashCode()) {
                case 3443508:
                    if (str.equals("play")) {
                        z = false;
                        break;
                    }
                    break;
                case 3540994:
                    if (str.equals("stop")) {
                        z = true;
                        break;
                    }
                    break;
                case 106440182:
                    if (str.equals("pause")) {
                        z = true;
                        break;
                    }
                    break;
                case 640038740:
                    if (str.equals("setUnMute")) {
                        z = true;
                        break;
                    }
                    break;
                case 1984790939:
                    if (str.equals("setMute")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    ftsWebVideoView.jS(false);
                    return;
                case true:
                    ftsWebVideoView.pause();
                    return;
                case true:
                    ftsWebVideoView.stop();
                    return;
                case true:
                    ftsWebVideoView.setMute(true);
                    return;
                case true:
                    ftsWebVideoView.setMute(false);
                    return;
                default:
                    x.i("FtsVideoPlayerMgr", "unknown op type %s", new Object[]{str});
                    return;
            }
        }
        x.i("FtsVideoPlayerMgr", "can not find player by id %d", new Object[]{Integer.valueOf(i)});
    }
}
