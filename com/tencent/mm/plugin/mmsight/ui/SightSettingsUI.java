package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.w.a$d;
import com.tencent.mm.plugin.w.a.e;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class SightSettingsUI extends MMActivity {
    private ListView eZb;
    private d iMQ = new d(this);
    private CaptureMMProxy leE;
    private a lqA;
    private LinkedList<b> lqB = new LinkedList();

    class a extends BaseAdapter {
        a() {
        }

        public final int getCount() {
            return SightSettingsUI.this.lqB.size();
        }

        public final Object getItem(int i) {
            return SightSettingsUI.this.lqB.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View textView = new TextView(SightSettingsUI.this);
            b bVar = (b) getItem(i);
            textView.setText(bVar.lqF + "->:" + bVar.te(((Integer) bVar.lqC.leE.get(bVar.lqI, Integer.valueOf(0))).intValue()));
            textView.setGravity(17);
            textView.setTextSize(1, 20.0f);
            textView.setHeight(com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 50));
            if (i % 2 == 1) {
                textView.setBackgroundColor(Color.parseColor("#e2efda"));
            }
            textView.setOnClickListener(new 1(this, bVar));
            return textView;
        }
    }

    static /* synthetic */ void a(SightSettingsUI sightSettingsUI) {
        SightSettingsUI sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.lqB.add(new b(sightSettingsUI2, "打开测试信息", com.tencent.mm.storage.aa.a.sUA, new String[]{"Y", "N"}, new int[]{1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.lqB.add(new b(sightSettingsUI2, "对焦方案", com.tencent.mm.storage.aa.a.sUH, new String[]{"System", "啊..."}, new int[]{1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.lqB.add(new b(sightSettingsUI2, "裁剪方案", com.tencent.mm.storage.aa.a.sUI, new String[]{"default", "mediacodecv21", "mediacodecv", "ffmpeg"}, new int[]{-1, 1, 2, 3}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.lqB.add(new b(sightSettingsUI2, "是否把双通音频压成单通道", com.tencent.mm.storage.aa.a.sUJ, new String[]{"-1", "yes", "no"}, new int[]{-1, 1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.lqB.add(new b(sightSettingsUI2, "Thread", com.tencent.mm.storage.aa.a.sUF, new String[]{"-1", "1", "2", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "4", "5", "6"}, new int[]{-1, 1, 2, 3, 4, 5, 6}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.lqB.add(new b(sightSettingsUI2, "裁剪预览MediaPlayer", com.tencent.mm.storage.aa.a.sUK, new String[]{"default", "系统方案", "MediaCodec解码播放方案"}, new int[]{-1, 1, 2}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.lqB.add(new b(sightSettingsUI2, "音频录制方案", com.tencent.mm.storage.aa.a.sUL, new String[]{"-1", "MediaCodec", "MediaRecorder"}, new int[]{-1, 1, 2}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.lqB.add(new b(sightSettingsUI2, "预设配置", com.tencent.mm.storage.aa.a.sUE, new String[]{"跟后台配置", "MediaCodec+540p录制", "MediaCodec+720p双倍码率录制+后期压缩", "FFMpeg+540p录制", "FFMpeg+720p双倍码率录制+后期压缩", "MediaCodec+720p原码率录制", "FFMpeg+720p原码率录制", "MediaCodec+1080p+实时压缩", "MediaCodec+1080p+实时压缩/旋转", "FFMpeg+1080p+实时压缩", "FFMpeg+1080p+实时压缩/旋转", "MediaCodec+1080p双倍码率+后压+实时压缩"}, new int[]{-1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}));
        sightSettingsUI.eZb = (ListView) sightSettingsUI.findViewById(a$d.listview);
        sightSettingsUI.lqA = new a();
        sightSettingsUI.eZb.setAdapter(sightSettingsUI.lqA);
    }

    protected final int getLayoutId() {
        return e.sight_settings_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.leE = new CaptureMMProxy(this.iMQ);
        this.iMQ.K(new 1(this));
        setBackBtn(new 2(this));
    }

    public void onDestroy() {
        super.onDestroy();
        this.iMQ.release();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }
}
