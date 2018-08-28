package com.tencent.mapsdk.raster.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.tencentmap.mapsdk.a.j;
import com.tencent.tencentmap.mapsdk.a.k;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class BitmapDescriptorFactory {
    public static BitmapDescriptor fromResource(int i) {
        Throwable th;
        Closeable closeable;
        BitmapDescriptor bitmapDescriptor = null;
        Closeable openRawResource;
        try {
            Context a = j.a();
            if (a != null) {
                openRawResource = a.getResources().openRawResource(i);
                try {
                    bitmapDescriptor = fromBitmap(BitmapFactory.decodeStream(openRawResource));
                    k.a(openRawResource);
                } catch (Exception e) {
                    k.a(openRawResource);
                    return bitmapDescriptor;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = openRawResource;
                    k.a(closeable);
                    throw th;
                }
            }
            k.a(bitmapDescriptor);
        } catch (Exception e2) {
            openRawResource = bitmapDescriptor;
            k.a(openRawResource);
            return bitmapDescriptor;
        } catch (Throwable th3) {
            th = th3;
            closeable = bitmapDescriptor;
            k.a(closeable);
            throw th;
        }
        return bitmapDescriptor;
    }

    public static BitmapDescriptor fromView(View view) {
        try {
            Context a = j.a();
            if (a == null) {
                return null;
            }
            View frameLayout = new FrameLayout(a);
            frameLayout.addView(view);
            frameLayout.destroyDrawingCache();
            return fromBitmap(getViewBitmap(frameLayout));
        } catch (Exception e) {
            return null;
        }
    }

    private static Bitmap getViewBitmap(View view) {
        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache().copy(Config.ARGB_8888, false);
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            return fromBitmap(BitmapFactory.decodeFile(str));
        } catch (Exception e) {
            return null;
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        try {
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/" + str);
            Bitmap decodeStream = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return fromBitmap(decodeStream);
        } catch (Exception e) {
            return null;
        }
    }

    public static BitmapDescriptor fromFile(String str) {
        try {
            InputStream fileInputStream = new FileInputStream(new File(str));
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
            return fromBitmap(decodeStream);
        } catch (Exception e) {
            return null;
        }
    }

    public static BitmapDescriptor defaultMarker() {
        return fromAsset("marker.png");
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDescriptor(bitmap);
    }
}
