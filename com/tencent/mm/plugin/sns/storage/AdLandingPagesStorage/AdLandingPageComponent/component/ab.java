package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y$a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.f.e;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public final class ab extends a {
    private static final int nFX = Color.parseColor("#26eae9e2");
    private CountDownLatch iyu;
    private RadarChart nFY;
    private Bitmap nFZ;
    private Bitmap nGa;

    static /* synthetic */ void a(ab abVar, Bitmap bitmap, Bitmap bitmap2) {
        y yVar = (y) abVar.bzL();
        RadarChart radarChart = abVar.nFY;
        radarChart.nCw = 0;
        radarChart.nCy = null;
        radarChart.nCp = null;
        radarChart.nCn = null;
        abVar.nFY.setLatitudeNum(5);
        c cVar = new c();
        cVar.nBS = 0;
        int parseColor = Color.parseColor(yVar.nBC);
        int i = 1442840575 & parseColor;
        parseColor &= Integer.MAX_VALUE;
        cVar.backgroundColor = i;
        cVar.nBX = nFX;
        cVar.nCb = 1.0f;
        cVar.nCm = bitmap2;
        cVar.nBY = nFX;
        cVar.nBZ = nFX;
        cVar.nCa = (float) a.fromDPToPix(abVar.context, 1);
        cVar.nCc = -1;
        cVar.nCe = 30.0f;
        cVar.nCd = 40.0f;
        cVar.nCi = bitmap;
        cVar.nCj = yVar.borderWidth;
        cVar.nCk = Color.parseColor("#7feae9e2");
        cVar.nCl = a.fromDPToPix(abVar.context, 1);
        abVar.nFY.setGridStyle(cVar);
        b bVar = new b();
        bVar.nBM = nFX;
        bVar.nBN = 1.0f;
        bVar.nBO = parseColor;
        bVar.nBP = 127;
        bVar.nBQ = Color.parseColor("#00fcff");
        bVar.nBR = a.fromDPToPix(abVar.context, 2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(yVar.nBD);
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(yVar.nBF);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(yVar.nBE);
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(yVar.nBG);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a(bVar);
        StringBuilder stringBuilder = new StringBuilder();
        for (y$a y_a : yVar.mLN) {
            if (y_a != null) {
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(y_a.label).append(":").append(y_a.nBI);
                Spannable spannableString = new SpannableString(stringBuilder.toString());
                a(spannableString, 0, y_a.label.length() + 1, foregroundColorSpan, absoluteSizeSpan);
                a(spannableString, y_a.label.length() + 1, stringBuilder.length(), foregroundColorSpan2, absoluteSizeSpan2);
                aVar.put(spannableString, Float.valueOf(y_a.value));
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        try {
            abVar.nFY.setData((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a[]) arrayList.toArray(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a[arrayList.size()]));
        } catch (Throwable e) {
            Log.getStackTraceString(e);
        }
        abVar.nFY.nCv = 2;
    }

    public ab(Context context, y yVar, ViewGroup viewGroup) {
        super(context, yVar, viewGroup);
    }

    public final View bzM() {
        this.nFY = (RadarChart) this.contentView.findViewById(f.chart);
        return this.contentView;
    }

    protected final void bzQ() {
        this.iyu = new CountDownLatch(2);
        e.b(new 1(this), "AdlandingRadarComp").start();
        y yVar = (y) bzL();
        if (yVar != null) {
            d.a(yVar.nBB, yVar.nAX, new 2(this));
            d.a(yVar.nBH, yVar.nAX, new 3(this));
            return;
        }
        Log.wtf("AdlandingRadarChartComp", "null info");
    }

    protected final int getLayout() {
        return g.sns_ad_native_landing_comp_radarchart;
    }

    private static void a(Spannable spannable, int i, int i2, Object... objArr) {
        for (int i3 = 0; i3 < 2; i3++) {
            spannable.setSpan(objArr[i3], i, i2, 18);
        }
    }
}
