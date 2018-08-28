package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import java.lang.ref.WeakReference;

public final class aw {
    private static final String sIA = Media.EXTERNAL_CONTENT_URI.toString();
    private static final String[] sIB = new String[]{"_display_name", "_data", "date_added"};
    private static ContentObserver sIC;
    private static WeakReference<a> sID;

    public static void a(Context context, a aVar) {
        x.i("MicroMsg.ScreenShotUtil", "summerscreenshot setScreenShotCallback context[%s] callback[%s], stack[%s]", new Object[]{context, aVar, bi.cjd()});
        if (context != null) {
            if (aVar == null) {
                if (sIC != null) {
                    context.getContentResolver().unregisterContentObserver(sIC);
                    sIC = null;
                }
                if (sID != null) {
                    sID.clear();
                    sID = null;
                    return;
                }
                return;
            }
            sID = new WeakReference(aVar);
            if (sIC == null) {
                sIC = new 1(new Handler(Looper.myLooper()), context);
                context.getContentResolver().registerContentObserver(Media.EXTERNAL_CONTENT_URI, true, sIC);
            }
        }
    }
}
