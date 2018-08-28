package com.google.android.gms.common.images;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.google.android.gms.c.l;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
    private static final Object aMB = new Object();
    private static HashSet<Uri> aMC = new HashSet();
    private final ExecutorService aMD;
    private final b aME;
    private final l aMF;
    private final Map<a, ImageReceiver> aMG;
    private final Map<Uri, ImageReceiver> aMH;
    private final Map<Uri, Long> aMI;
    private final Context mContext;
    private final Handler mHandler;

    public interface a {
    }
}
