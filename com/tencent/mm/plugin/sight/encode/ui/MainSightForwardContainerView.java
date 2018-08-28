package com.tencent.mm.plugin.sight.encode.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sight.encode.a.b;
import com.tencent.mm.plugin.sight.encode.a.b.3;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.List;

public class MainSightForwardContainerView extends RelativeLayout implements OnItemClickListener, a {
    public View kWn;
    private int mDuration;
    private boolean mIsPause;
    private boolean mIsPlaying;
    public String nfA;
    private boolean nfB;
    public String nfC;
    public float nfD;
    private b nfE;
    private boolean nfF;
    public MMFragmentActivity nfG;
    private boolean nfH;
    private c nfI;
    private boolean nfJ;
    private MediaPlayer nfK;
    public MainSightSelectContactView nfs;
    public SightCameraView nft;
    private b nfu;
    public View nfv;
    public View nfw;
    public View nfx;
    private Dialog nfy;
    private boolean nfz;

    public MainSightForwardContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nfy = null;
        this.mIsPlaying = false;
        this.nfz = true;
        this.nfA = "";
        this.nfB = false;
        this.nfC = "";
        this.mDuration = 1;
        this.nfD = 1.0f;
        this.mIsPause = false;
        this.nfE = new b();
        this.nfF = false;
        this.nfH = false;
        this.nfI = new 5(this);
        this.nfJ = false;
    }

    public MainSightForwardContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void aEI() {
        a.sFg.c(this.nfI);
    }

    public final void bwn() {
        boolean z = true;
        x.i("MicroMsg.MainSightContainerView", "toggle play video, path %s, mute %B, playing %B", new Object[]{this.nfC, Boolean.valueOf(this.nfz), Boolean.valueOf(this.mIsPlaying)});
        if (!this.nft.isPlaying()) {
            this.nfz = true;
        }
        this.nft.aP(this.nfC, this.nfz);
        if (this.nfz) {
            hP(true);
        } else {
            hP(false);
        }
        this.mIsPlaying = true;
        if (this.nfz) {
            z = false;
        }
        this.nfz = z;
    }

    public final boolean BD() {
        return !this.nfz;
    }

    public void setIsMute(boolean z) {
        if (this.nft != null) {
            this.nft.setIsMute(z);
        }
    }

    public final void hO(boolean z) {
        if (!this.nfB) {
            this.nfB = true;
            bi.hideVKB(this);
            this.mIsPlaying = false;
            this.nfz = true;
            x.d("MicroMsg.MainSightContainerView", "dismiss sight view");
            this.nfH = false;
            this.nft.bwy();
            if (this.nfu != null && z) {
                this.nfu.bwp();
            }
            if (this.nfs != null) {
                MainSightSelectContactView mainSightSelectContactView = this.nfs;
                mainSightSelectContactView.nfB = true;
                bi.hideVKB(mainSightSelectContactView);
                mainSightSelectContactView.ngg.bwt();
                mainSightSelectContactView.ngq.clear();
                mainSightSelectContactView.ngp.clear();
                mainSightSelectContactView.CU.setAdapter(null);
                mainSightSelectContactView.CU.clearAnimation();
                mainSightSelectContactView.setVisibility(8);
            }
            setCameraShadowAlpha(0.85f);
            bwo();
            hP(false);
            this.nfA = "";
            aEI();
        }
    }

    public final void hP(boolean z) {
        if (this.nfF != z) {
            this.nfF = z;
            if (!z) {
                this.nfw.setVisibility(8);
                this.kWn.setVisibility(8);
            } else if (this.nfw.getVisibility() != 0) {
                this.nft.postDelayed(new 4(this), 100);
            }
        }
    }

    public void setIMainSightViewCallback(b bVar) {
        this.nfu = bVar;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = i - 1;
        if (MainSightSelectContactView.wg(i2) && this.mIsPlaying) {
            bwn();
        } else if (c.Ls(this.nfs.jd(i2))) {
            this.nfs.ngg.bws();
        } else if (!c.Lr(this.nfs.jd(i2))) {
            x.d("MicroMsg.MainSightContainerView", "on item click Item : %d", new Object[]{Integer.valueOf(i2)});
            MainSightSelectContactView mainSightSelectContactView = this.nfs;
            if (i2 >= 0 && i2 <= mainSightSelectContactView.ngi.getCount()) {
                com.tencent.mm.ui.contact.a.a FM = mainSightSelectContactView.ngi.FM(i2);
                if (FM != null) {
                    if (mainSightSelectContactView.ngq.contains(FM.guS.field_username)) {
                        mainSightSelectContactView.ngq.remove(FM.guS.field_username);
                    } else {
                        mainSightSelectContactView.ngq.add(FM.guS.field_username);
                    }
                    c.nfQ = mainSightSelectContactView.ngq.isEmpty();
                    c.nfR = !mainSightSelectContactView.ngq.isEmpty();
                }
            }
            mainSightSelectContactView = this.nfs;
            if (mainSightSelectContactView.ngi != null) {
                mainSightSelectContactView.ngi.notifyDataSetChanged();
            }
            if (!BD()) {
                bwn();
            } else if (this.nfs.bwx()) {
                if (this.kWn.getVisibility() == 0) {
                    this.kWn.setVisibility(8);
                    this.kWn.startAnimation(AnimationUtils.loadAnimation(this.nfG, R.a.fast_faded_out));
                }
            } else if (this.kWn.getVisibility() != 0) {
                this.kWn.setVisibility(0);
                this.kWn.startAnimation(AnimationUtils.loadAnimation(this.nfG, R.a.fast_faded_in));
            }
            if (this.nfs.ngg.bwr()) {
                mainSightSelectContactView = this.nfs;
                boolean contains = mainSightSelectContactView.ngi.FM(i2) == null ? false : mainSightSelectContactView.ngi.FM(i2).guS == null ? false : mainSightSelectContactView.ngq.contains(mainSightSelectContactView.ngi.FM(i2).guS.field_username);
                if (contains) {
                    this.nfs.ngg.bws();
                }
            }
        } else if (c.nfQ) {
            this.nfH = true;
            this.nft.bwy();
            MMFragmentActivity mMFragmentActivity = this.nfG;
            String Ll = d.Ll(this.nfC);
            String str = this.nfC;
            String str2 = this.nfA;
            x.i("MicroMsg.SightRecorderHelper", "share video path %s, thumb path %s", new Object[]{str, Ll});
            if (!e.cn(Ll)) {
                try {
                    com.tencent.mm.sdk.platformtools.c.a(d.ad(str, 320, aq.CTRL_BYTE), 60, CompressFormat.JPEG, Ll, true);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SightRecorderHelper", e, "", new Object[0]);
                    x.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
                }
            }
            Intent intent = new Intent();
            intent.putExtra("KSightPath", str);
            intent.putExtra("KSightThumbPath", Ll);
            intent.putExtra("sight_md5", str2);
            intent.putExtra("KSightDraftEntrance", false);
            intent.putExtra("Ksnsupload_source", 0);
            intent.putExtra("KSnsPostManu", true);
            intent.putExtra("KTouchCameraTime", bi.VE());
            com.tencent.mm.bg.d.b(mMFragmentActivity, "sns", ".ui.SightUploadUI", intent, 5985);
            if (this.nfJ) {
                h.mEJ.h(11442, new Object[]{Integer.valueOf(3), Integer.valueOf(3)});
            } else {
                h.mEJ.h(11442, new Object[]{Integer.valueOf(1), Integer.valueOf(3)});
            }
        }
    }

    public final void aTi() {
        String str = "MicroMsg.MainSightContainerView";
        String str2 = "do send to friend, loadingDialog null %B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.nfy == null);
        x.i(str, str2, objArr);
        if (!bi.oW(this.nfC) && !this.nfs.bwx()) {
            String str3;
            boolean z;
            List<String> selectedContact = this.nfs.getSelectedContact();
            h.mEJ.h(11443, new Object[]{Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(selectedContact.size())});
            6 6 = new 6(this, selectedContact);
            if (selectedContact.size() == 1) {
                b bVar = this.nfE;
                String str4 = this.nfC;
                int i = this.mDuration;
                str3 = this.nfA;
                str2 = (String) selectedContact.get(0);
                if (bi.oW(str4)) {
                    x.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                    b.a(6, -1);
                } else if (bi.oW(str2)) {
                    x.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser null");
                    b.a(6, -1);
                } else if (!e.cn(str4) || e.cm(str4) <= 0) {
                    x.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                    com.tencent.mm.ui.base.h.bA(ad.getContext(), ad.getContext().getString(com.tencent.mm.plugin.ak.a.h.short_video_input_file_error));
                } else {
                    x.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[]{str3, g.cu(str4)});
                    if (bi.aG(str3, "").equals(g.cu(str4))) {
                        com.tencent.mm.kernel.g.Ek();
                        if (com.tencent.mm.kernel.g.Em().H(new 3(bVar, str2, 6, str4, i)) < 0) {
                            x.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                            b.a(6, -1);
                        }
                    } else {
                        x.e("MicroMsg.SightRecorderHelper", "error md5, return");
                        b.a(6, -1);
                    }
                }
            } else {
                b bVar2 = this.nfE;
                String str5 = this.nfC;
                int i2 = this.mDuration;
                String str6 = this.nfA;
                if (bi.oW(str5)) {
                    x.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                    b.a(6, -1);
                } else if (selectedContact == null || selectedContact.isEmpty()) {
                    x.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser list empty");
                    b.a(6, -1);
                } else if (!e.cn(str5) || e.cm(str5) <= 0) {
                    x.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                    com.tencent.mm.ui.base.h.bA(ad.getContext(), ad.getContext().getString(com.tencent.mm.plugin.ak.a.h.short_video_input_file_error));
                } else {
                    x.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[]{str6, g.cu(str5)});
                    if (bi.aG(str6, "").equals(g.cu(str5))) {
                        com.tencent.mm.kernel.g.Ek();
                        if (com.tencent.mm.kernel.g.Em().H(new b$4(bVar2, str5, selectedContact, str6, 6, i2)) < 0) {
                            x.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                            b.a(6, -1);
                        }
                    } else {
                        x.e("MicroMsg.SightRecorderHelper", "error md5, return");
                        b.a(6, -1);
                    }
                }
            }
            if (this.nfs.getSelectedContact().size() > 1 || this.nfu == null) {
                z = true;
            } else {
                this.nfu.Lq((String) this.nfs.getSelectedContact().get(0));
                z = false;
            }
            if (this.nfG != null) {
                try {
                    AssetFileDescriptor openFd = this.nfG.getAssets().openFd("sight_send_song.wav");
                    this.nfK = new j();
                    this.nfK.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                    openFd.close();
                    this.nfK.setOnCompletionListener(new 7(this));
                    this.nfK.setLooping(false);
                    this.nfK.prepare();
                    this.nfK.start();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MainSightContainerView", e, "", new Object[0]);
                }
            }
            hO(z);
            for (String str32 : selectedContact) {
                if (str32.toLowerCase().endsWith("@chatroom")) {
                    h.mEJ.h(11442, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
                } else {
                    h.mEJ.h(11442, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
                }
            }
        }
    }

    public final void onPause() {
        if (!this.nfH) {
            this.nft.setVisibility(0);
            hP(false);
            this.nft.bwy();
            this.mIsPause = true;
        }
    }

    public final void onResume() {
        if (!this.nfB) {
            a.sFg.c(this.nfI);
            a.sFg.b(this.nfI);
        } else {
            aEI();
        }
        if (this.mIsPause) {
            bwn();
            this.mIsPause = false;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && !this.nfB && this.nfs != null) {
            x.d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            this.nfs.bww();
        }
    }

    public void setIsForSns(boolean z) {
        this.nfJ = z;
    }

    @TargetApi(11)
    public void setCameraShadowAlpha(float f) {
        float min = Math.min(1.0f, Math.max(0.0f, f));
        if (com.tencent.mm.compatible.util.d.fR(11)) {
            this.nfv.setAlpha(min);
        } else {
            Animation alphaAnimation = new AlphaAnimation(min, min);
            alphaAnimation.setDuration(0);
            alphaAnimation.setFillAfter(true);
            this.nfv.startAnimation(alphaAnimation);
        }
        x.d("MicroMsg.MainSightContainerView", "set alpha: %f", new Object[]{Float.valueOf(min)});
        if (min <= 0.0f) {
            this.nfv.setVisibility(8);
            Animation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(500);
            this.nfv.startAnimation(alphaAnimation2);
            return;
        }
        this.nfv.setVisibility(0);
    }

    public final void bwo() {
        this.nfx.setVisibility(8);
    }

    public final void hN(boolean z) {
        if (z) {
            this.nfx.setVisibility(0);
            setIsMute(true);
            return;
        }
        bwo();
        setIsMute(BD());
    }

    public final void bwl() {
        this.nft.setVisibility(0);
        hP(true);
    }

    public final void bwm() {
        this.nft.setVisibility(4);
        hP(false);
    }

    public int getViewHeight() {
        int height = getHeight();
        if (height <= 0) {
            return getResources().getDisplayMetrics().heightPixels;
        }
        return height;
    }
}
