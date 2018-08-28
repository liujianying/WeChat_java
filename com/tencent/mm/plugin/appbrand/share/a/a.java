package com.tencent.mm.plugin.appbrand.share.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.modelappbrand.b.b$f;
import com.tencent.mm.modelappbrand.b.b.e;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class a implements g {
    private final Map<String, SoftReference<e>> gsR = new ConcurrentHashMap();
    private final Map<String, SoftReference<b$f>> gsS = new ConcurrentHashMap();
    private final Map<Integer, a> gsT = new ConcurrentHashMap();
    private final Map<Integer, Bundle> gsU = new ConcurrentHashMap();

    public a() {
        a(1, new 1(this));
    }

    public final View bH(Context context) {
        Assert.assertNotNull(context);
        return new WxaShareMessagePage(context);
    }

    public final boolean a(String str, View view, Bundle bundle) {
        Bitmap bitmap = null;
        Assert.assertNotNull(view);
        Assert.assertNotNull(bundle);
        if (!(view instanceof WxaShareMessagePage)) {
            return false;
        }
        x.i("MicroMsg.WxaShareMessageService", "onBindView(%s, %s)", new Object[]{str, Integer.valueOf(view.hashCode())});
        WxaShareMessagePage wxaShareMessagePage = (WxaShareMessagePage) view;
        boolean z = bundle.getBoolean("is_dynamic_page");
        wxaShareMessagePage.setTitle(bundle.getString(FFmpegMetadataRetriever.METADATA_KEY_TITLE, ""));
        if (z) {
            wxaShareMessagePage.getCoverImageView().setVisibility(4);
            IPCDynamicPageView widgetPageView = wxaShareMessagePage.getWidgetPageView();
            widgetPageView.setVisibility(0);
            bundle.putInt("view_init_width", wxaShareMessagePage.getWidgetWidth());
            bundle.putInt("view_init_height", wxaShareMessagePage.getWidgetHeight());
            ((com.tencent.mm.modelappbrand.e) com.tencent.mm.kernel.g.l(com.tencent.mm.modelappbrand.e.class)).a(str, widgetPageView, bundle, new v(new 2(this, wxaShareMessagePage)));
        } else {
            wxaShareMessagePage.getWidgetPageView().setVisibility(4);
            wxaShareMessagePage.getCoverImageView().setVisibility(0);
            byte[] byteArray = bundle.getByteArray("image_data");
            if (byteArray != null && byteArray.length > 0) {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                if (!(decodeByteArray == null || decodeByteArray.isRecycled())) {
                    wxaShareMessagePage.setImageData(decodeByteArray);
                    return true;
                }
            }
            String string = bundle.getString("delay_load_img_path");
            if (bi.oW(string)) {
                String string2 = bundle.getString("image_url");
                if (string2 == null || !(string2.startsWith("http://") || string2.startsWith("https://"))) {
                    if (string2 != null && string2.startsWith("file://")) {
                        Bitmap a = b.Ka().a(string2, null);
                        if (!(a == null || a.isRecycled())) {
                            wxaShareMessagePage.setImageData(a);
                            return true;
                        }
                    }
                    wxaShareMessagePage.Kd();
                } else {
                    wxaShareMessagePage.setImageUrl(string2);
                }
            } else {
                if (!string.startsWith("delayLoadFile://")) {
                    bitmap = b.Ka().a(string, null);
                    x.i("MicroMsg.WxaShareMessageService", "findCachedLocal(%s)", new Object[]{string});
                } else if (this.gsU.containsKey(Integer.valueOf(2))) {
                    bitmap = c.Wb(string.replace("delayLoadFile://", ""));
                    x.i("MicroMsg.WxaShareMessageService", "getBitmapNative(%s)", new Object[]{string});
                }
                if (bitmap != null) {
                    if (bitmap.isRecycled()) {
                        wxaShareMessagePage.setImageUrl(string);
                    } else {
                        wxaShareMessagePage.setImageData(bitmap);
                    }
                    return true;
                }
                x.i("MicroMsg.WxaShareMessageService", "delay loadImage(%s)", new Object[]{string});
                wxaShareMessagePage.getLoadingView().setVisibility(0);
                wxaShareMessagePage.getErrorImageView().setVisibility(4);
                wxaShareMessagePage.getCoverImageView().setVisibility(4);
                wxaShareMessagePage.getLoadingView().cAG();
                a(2, new 3(this, wxaShareMessagePage));
            }
        }
        return true;
    }

    public final void a(String str, View view) {
        Assert.assertNotNull(view);
        if (view instanceof WxaShareMessagePage) {
            x.i("MicroMsg.WxaShareMessageService", "onUnbindView(%s, %s)", new Object[]{str, Integer.valueOf(view.hashCode())});
            ((com.tencent.mm.modelappbrand.e) com.tencent.mm.kernel.g.l(com.tencent.mm.modelappbrand.e.class)).a(str, ((WxaShareMessagePage) view).getWidgetPageView());
            this.gsT.remove(Integer.valueOf(2));
        }
    }

    public final synchronized void d(int i, Bundle bundle) {
        a aVar = (a) this.gsT.get(Integer.valueOf(i));
        if (aVar != null) {
            aVar.x(bundle);
        }
        this.gsU.put(Integer.valueOf(i), bundle);
        x.i("MicroMsg.WxaShareMessageService", "onAction(%d, %s)", new Object[]{Integer.valueOf(i), bundle});
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.modelappbrand.b.b.e bc(int r5, int r6) {
        /*
        r4 = this;
        r0 = "%d-%d-dp";
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = java.lang.Integer.valueOf(r5);
        r1[r2] = r3;
        r2 = 1;
        r3 = java.lang.Integer.valueOf(r6);
        r1[r2] = r3;
        r1 = java.lang.String.format(r0, r1);
        r0 = r4.gsR;
        r0 = r0.get(r1);
        r0 = (java.lang.ref.SoftReference) r0;
        if (r0 == 0) goto L_0x002a;
    L_0x0022:
        r0 = r0.get();
        r0 = (com.tencent.mm.modelappbrand.b.b.e) r0;
        if (r0 != 0) goto L_0x005d;
    L_0x002a:
        monitor-enter(r4);
        r0 = r4.gsR;	 Catch:{ all -> 0x005e }
        r0 = r0.get(r1);	 Catch:{ all -> 0x005e }
        r0 = (java.lang.ref.SoftReference) r0;	 Catch:{ all -> 0x005e }
        if (r0 == 0) goto L_0x003d;
    L_0x0035:
        r0 = r0.get();	 Catch:{ all -> 0x005e }
        r0 = (com.tencent.mm.modelappbrand.b.b.e) r0;	 Catch:{ all -> 0x005e }
        if (r0 != 0) goto L_0x005c;
    L_0x003d:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x005e }
        r2 = com.tencent.mm.bp.a.fromDPToPix(r0, r5);	 Catch:{ all -> 0x005e }
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x005e }
        r3 = com.tencent.mm.bp.a.fromDPToPix(r0, r6);	 Catch:{ all -> 0x005e }
        r0 = new com.tencent.mm.plugin.appbrand.share.a;	 Catch:{ all -> 0x005e }
        r0.<init>(r2, r3);	 Catch:{ all -> 0x005e }
        r2 = r4.gsR;	 Catch:{ all -> 0x005e }
        r3 = new java.lang.ref.SoftReference;	 Catch:{ all -> 0x005e }
        r3.<init>(r0);	 Catch:{ all -> 0x005e }
        r2.put(r1, r3);	 Catch:{ all -> 0x005e }
    L_0x005c:
        monitor-exit(r4);	 Catch:{ all -> 0x005e }
    L_0x005d:
        return r0;
    L_0x005e:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x005e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.share.a.a.bc(int, int):com.tencent.mm.modelappbrand.b.b$e");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.modelappbrand.b.b$f JO() {
        /*
        r5 = this;
        r3 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r4 = 90;
        r0 = "%d-%d-dp";
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r1[r2] = r3;
        r2 = 1;
        r3 = java.lang.Integer.valueOf(r4);
        r1[r2] = r3;
        r1 = java.lang.String.format(r0, r1);
        r0 = r5.gsS;
        r0 = r0.get(r1);
        r0 = (java.lang.ref.SoftReference) r0;
        if (r0 == 0) goto L_0x002e;
    L_0x0026:
        r0 = r0.get();
        r0 = (com.tencent.mm.modelappbrand.b.b$f) r0;
        if (r0 != 0) goto L_0x0065;
    L_0x002e:
        monitor-enter(r5);
        r0 = r5.gsS;	 Catch:{ all -> 0x0066 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0066 }
        r0 = (java.lang.ref.SoftReference) r0;	 Catch:{ all -> 0x0066 }
        if (r0 == 0) goto L_0x0041;
    L_0x0039:
        r0 = r0.get();	 Catch:{ all -> 0x0066 }
        r0 = (com.tencent.mm.modelappbrand.b.b$f) r0;	 Catch:{ all -> 0x0066 }
        if (r0 != 0) goto L_0x0064;
    L_0x0041:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x0066 }
        r2 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r2 = com.tencent.mm.bp.a.fromDPToPix(r0, r2);	 Catch:{ all -> 0x0066 }
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x0066 }
        r3 = 90;
        r3 = com.tencent.mm.bp.a.fromDPToPix(r0, r3);	 Catch:{ all -> 0x0066 }
        r0 = new com.tencent.mm.plugin.appbrand.share.b;	 Catch:{ all -> 0x0066 }
        r0.<init>(r2, r3);	 Catch:{ all -> 0x0066 }
        r2 = r5.gsS;	 Catch:{ all -> 0x0066 }
        r3 = new java.lang.ref.SoftReference;	 Catch:{ all -> 0x0066 }
        r3.<init>(r0);	 Catch:{ all -> 0x0066 }
        r2.put(r1, r3);	 Catch:{ all -> 0x0066 }
    L_0x0064:
        monitor-exit(r5);	 Catch:{ all -> 0x0066 }
    L_0x0065:
        return r0;
    L_0x0066:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0066 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.share.a.a.JO():com.tencent.mm.modelappbrand.b.b$f");
    }

    private void a(int i, a aVar) {
        this.gsT.put(Integer.valueOf(i), aVar);
        if (this.gsU.containsKey(Integer.valueOf(i))) {
            aVar.x((Bundle) this.gsU.get(Integer.valueOf(i)));
        }
    }
}
