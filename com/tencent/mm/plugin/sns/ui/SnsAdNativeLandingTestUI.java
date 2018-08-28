package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sns.i$d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class SnsAdNativeLandingTestUI extends MMActivity {
    private int duration = 0;
    private ag dvh = new ag();
    private int nFC;
    private VideoSightView nTc;
    SnsAdNativeLandingPagesVideoPlayerLoadingBar nTd;
    private double neb = 0.0d;
    private int videoHeight;
    private int videoWidth;

    static /* synthetic */ void b(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        snsAdNativeLandingTestUI.neb = snsAdNativeLandingTestUI.nTc.getLastProgresstime();
        snsAdNativeLandingTestUI.nTc.pause();
        snsAdNativeLandingTestUI.dvh.post(new Runnable() {
            public final void run() {
                SnsAdNativeLandingTestUI.this.nTd.setIsPlay(false);
            }
        });
    }

    static /* synthetic */ void c(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        snsAdNativeLandingTestUI.nTc.x(snsAdNativeLandingTestUI.neb);
        snsAdNativeLandingTestUI.nTc.start();
        snsAdNativeLandingTestUI.dvh.post(new Runnable() {
            public final void run() {
                SnsAdNativeLandingTestUI.this.nTd.setIsPlay(true);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        getWindow().setFlags(1024, 1024);
        ((Button) findViewById(f.sns_ad_native_landing_pages_test_share_btn)).setOnClickListener(new 1(this));
        ViewGroup viewGroup = (ViewGroup) findViewById(f.sns_ad_native_landing_pages_test_root);
        LayoutInflater layoutInflater = (LayoutInflater) this.mController.tml.getSystemService("layout_inflater");
        WindowManager windowManager = (WindowManager) this.mController.tml.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        String str = "adId";
        String str2 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
        String str3 = str + "_image_" + ac.ce("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
        str = str + "_stream_" + ac.ce("http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400");
        View inflate = layoutInflater.inflate(g.sns_ad_native_landing_pages_item_sight, null);
        inflate.setMinimumHeight(height);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(f.sns_ad_native_landing_pages_item_sight_container);
        this.nTc = new VideoSightView(this.mController.tml);
        this.nTc.setLoop(false);
        viewGroup2.addView(this.nTc, 0, new LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = b.b(this.mController.tml, this.mController.tml.getResources().getDimension(i$d.NoPadding));
        this.nTd = new SnsAdNativeLandingPagesVideoPlayerLoadingBar(this.mController.tml);
        this.nTd.setVisibility(0);
        this.nTc.setPlayProgressCallback(true);
        ((ViewGroup) inflate).addView(this.nTd, layoutParams);
        this.nTd.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b() {
            public final void ajO() {
            }

            public final void kV(int i) {
                x.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "onSeek time " + i);
                SnsAdNativeLandingTestUI.this.neb = (double) i;
                SnsAdNativeLandingTestUI.this.nTc.x((double) i);
            }
        });
        this.nTd.setOnPlayButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (SnsAdNativeLandingTestUI.this.nTc.isPlaying()) {
                    SnsAdNativeLandingTestUI.b(SnsAdNativeLandingTestUI.this);
                } else {
                    SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this);
                }
            }
        });
        this.nTd.setIsPlay(this.nTc.isPlaying());
        this.nTd.setVisibility(0);
        this.nTd.seek(0);
        this.nTc.setVideoCallback(new a() {
            public final void iy() {
                if (SnsAdNativeLandingTestUI.this.nTd.getIsPlay()) {
                    SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this);
                }
            }

            public final void onError(int i, int i2) {
                SnsAdNativeLandingTestUI.this.nTc.stop();
            }

            public final void wd() {
            }

            public final int ck(int i, int i2) {
                ah.A(new 1(this, i, i2));
                return 0;
            }

            public final void cl(int i, int i2) {
                SnsAdNativeLandingTestUI.this.videoWidth = i;
                SnsAdNativeLandingTestUI.this.videoHeight = i2;
            }
        });
        this.nTc.setEnableConfigChanged(false);
        this.nTc.setOnClickListener(new 6(this));
        viewGroup.addView(inflate, new LayoutParams(width, height));
        this.nTc.post(new 7(this));
        new a(str2, str3, af.aRu(), new 8(this)).execute(new String[]{"http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150"});
        new a(str2, str, af.aRu(), new 9(this), Downloads.SPLIT_RANGE_SIZE_WAP).execute(new String[]{"http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400"});
    }

    protected final int getLayoutId() {
        return g.sns_ad_native_landing_pages_test_ui;
    }
}
