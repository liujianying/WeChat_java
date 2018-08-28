package com.davemorrissey.labs.subscaleview.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class e implements d {
    private final ReadWriteLock YA;
    private final Config Yx;
    private BitmapRegionDecoder Yz;

    public e() {
        this((byte) 0);
    }

    private e(byte b) {
        this.YA = new ReentrantReadWriteLock(true);
        Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (preferredBitmapConfig != null) {
            this.Yx = preferredBitmapConfig;
        } else {
            this.Yx = Config.RGB_565;
        }
    }

    public final Point b(Context context, Uri uri) {
        String uri2 = uri.toString();
        if (uri2.startsWith("android.resource://")) {
            Resources resources;
            int identifier;
            String authority = uri.getAuthority();
            if (context.getPackageName().equals(authority)) {
                resources = context.getResources();
            } else {
                resources = context.getPackageManager().getResourcesForApplication(authority);
            }
            List pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && ((String) pathSegments.get(0)).equals("drawable")) {
                identifier = resources.getIdentifier((String) pathSegments.get(1), "drawable", authority);
            } else {
                if (size == 1 && TextUtils.isDigitsOnly((CharSequence) pathSegments.get(0))) {
                    try {
                        identifier = bi.getInt((String) pathSegments.get(0), 0);
                    } catch (NumberFormatException e) {
                    }
                }
                identifier = 0;
            }
            this.Yz = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(identifier), false);
        } else if (uri2.startsWith("file:///android_asset/")) {
            this.Yz = BitmapRegionDecoder.newInstance(context.getAssets().open(uri2.substring(22), 1), false);
        } else if (uri2.startsWith("file://")) {
            this.Yz = BitmapRegionDecoder.newInstance(uri2.substring(7), false);
        } else {
            InputStream inputStream = null;
            try {
                inputStream = context.getContentResolver().openInputStream(uri);
                this.Yz = BitmapRegionDecoder.newInstance(inputStream, false);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e2) {
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                    }
                }
            }
        }
        return new Point(this.Yz.getWidth(), this.Yz.getHeight());
    }

    public final Bitmap b(Rect rect, int i) {
        hw().lock();
        try {
            if (this.Yz == null || this.Yz.isRecycled()) {
                throw new IllegalStateException("Cannot decode region after decoder has been recycled");
            }
            Options options = new Options();
            options.inSampleSize = i;
            options.inPreferredConfig = this.Yx;
            Bitmap decodeRegion = this.Yz.decodeRegion(rect, options);
            if (decodeRegion != null) {
                return decodeRegion;
            }
            throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
        } finally {
            hw().unlock();
        }
    }

    public final synchronized boolean hv() {
        boolean z;
        z = (this.Yz == null || this.Yz.isRecycled()) ? false : true;
        return z;
    }

    public final synchronized void recycle() {
        this.YA.writeLock().lock();
        try {
            this.Yz.recycle();
            this.Yz = null;
            this.YA.writeLock().unlock();
        } catch (Throwable th) {
            this.YA.writeLock().unlock();
        }
    }

    private Lock hw() {
        if (VERSION.SDK_INT < 21) {
            return this.YA.writeLock();
        }
        return this.YA.readLock();
    }
}
