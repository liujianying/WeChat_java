package com.tencent.mm.plugin.base.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.aa.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.comm.a;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

public final class b {
    public static final String hdt = ad.getPackageName();
    private static String hdu = "";
    private static char[] hdv = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static boolean U(Context context, String str) {
        hdu = q.GF();
        Intent a = a(context, str, true, hdu);
        Intent intent = (Intent) a.getParcelableExtra("android.intent.extra.shortcut.INTENT");
        if (intent == null) {
            return false;
        }
        a(context, a, intent.getStringExtra("app_shortcut_custom_id"), true);
        return true;
    }

    public static void n(Context context, Intent intent) {
        a(context, intent, null, true);
    }

    public static void a(Context context, Intent intent, String str, boolean z) {
        if (context == null) {
            x.e("MicroMsg.ShortcutManager", "context is null");
        } else if (intent == null) {
            x.e("MicroMsg.ShortcutManager", "intent is null");
        } else {
            Object obj;
            if (VERSION.SDK_INT < 26) {
                context.sendBroadcast(intent);
                d(context, true, true);
            } else {
                ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
                if (shortcutManager == null) {
                    x.e("MicroMsg.ShortcutManager", "shortcut manager is null");
                    obj = null;
                } else if (!shortcutManager.isRequestPinShortcutSupported()) {
                    x.e("MicroMsg.ShortcutManager", "alvinluo not support pin shortcuts");
                    obj = null;
                } else if (intent.getBooleanExtra("is_main_shortcut", false)) {
                    x.i("MicroMsg.ShortcutManager", "alvinluo main icon, do not create shortcut");
                    obj = null;
                } else {
                    Intent intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
                    if (intent2 == null) {
                        x.e("MicroMsg.ShortcutManager", "alvinluo shortcut intent is null");
                        obj = null;
                    } else {
                        Object obj2;
                        int intExtra;
                        if (bi.oW(str)) {
                            str = intent2.getStringExtra("app_shortcut_custom_id");
                        }
                        if (bi.oW(str)) {
                            x.i("MicroMsg.ShortcutManager", "alvinluo shortcutId is null, then use short name as shortcutId");
                            str = intent.getStringExtra("android.intent.extra.shortcut.NAME");
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        x.i("MicroMsg.ShortcutManager", "alvinluo shortcutId: %s", new Object[]{str});
                        String stringExtra = intent.getStringExtra("android.intent.extra.shortcut.NAME");
                        if (((ShortcutIconResource) intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE")) != null) {
                            x.i("MicroMsg.ShortcutManager", "alvinluo icon resource name: %s, %s", new Object[]{((ShortcutIconResource) intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE")).resourceName, ((ShortcutIconResource) intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE")).packageName});
                        }
                        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("android.intent.extra.shortcut.ICON");
                        if (bitmap == null) {
                            x.i("MicroMsg.ShortcutManager", "extra_shortcut_icon is null, use icon resource id");
                            intExtra = intent.getIntExtra("shortcut_icon_resource_id", -1);
                            if (intExtra == -1) {
                                x.e("MicroMsg.ShortcutManager", "icon resource id is null");
                                obj = null;
                            } else {
                                bitmap = BitmapFactory.decodeResource(context.getResources(), intExtra);
                            }
                        }
                        if (bitmap == null) {
                            x.e("MicroMsg.ShortcutManager", "icon bitmap is null");
                            obj = null;
                        } else {
                            boolean booleanExtra = intent.getBooleanExtra("shortcut_is_adaptive_icon", false);
                            Builder intent3 = new Builder(context, str).setShortLabel(intent.getStringExtra("android.intent.extra.shortcut.NAME")).setLongLabel(intent.getStringExtra("android.intent.extra.shortcut.NAME")).setIntent(intent2);
                            if (booleanExtra) {
                                intent3.setIcon(Icon.createWithBitmap(bitmap));
                            } else {
                                intent3.setIcon(Icon.createWithAdaptiveBitmap(bitmap));
                            }
                            ShortcutInfo build = intent3.build();
                            x.i("MicroMsg.ShortcutManager", "alvinluo add shortcut above android o, duplicate: %b", new Object[]{Boolean.valueOf(intent.getBooleanExtra("duplicate", false))});
                            if (intent.getBooleanExtra("duplicate", false)) {
                                shortcutManager.requestPinShortcut(build, null);
                                d(context, true, true);
                            } else {
                                boolean z2;
                                List pinnedShortcuts = shortcutManager.getPinnedShortcuts();
                                int i = 0;
                                while (true) {
                                    intExtra = i;
                                    if (intExtra >= pinnedShortcuts.size()) {
                                        z2 = false;
                                        break;
                                    }
                                    ShortcutInfo shortcutInfo = (ShortcutInfo) pinnedShortcuts.get(intExtra);
                                    if (obj2 == null) {
                                        if (shortcutInfo != null && shortcutInfo.getId().equals(str)) {
                                            z2 = true;
                                            break;
                                        }
                                    } else if (!(shortcutInfo == null || shortcutInfo.getShortLabel() == null || !shortcutInfo.getShortLabel().equals(stringExtra))) {
                                        z2 = true;
                                        break;
                                    }
                                    i = intExtra + 1;
                                }
                                x.i("MicroMsg.ShortcutManager", "alvinluo shortcut exist: %b, shortcutName: %s", new Object[]{Boolean.valueOf(z2), stringExtra});
                                if (z2) {
                                    List arrayList = new ArrayList();
                                    arrayList.add(build);
                                    boolean updateShortcuts = shortcutManager.updateShortcuts(arrayList);
                                    x.i("MicroMsg.ShortcutManager", "alvinluo update shortcuts result: %b", new Object[]{Boolean.valueOf(updateShortcuts)});
                                    d(context, true, true);
                                } else if (z) {
                                    intent2 = shortcutManager.createShortcutResultIntent(build);
                                    intent2.setClass(context, ShortcutBroadCastReceiver.class);
                                    shortcutManager.requestPinShortcut(build, PendingIntent.getBroadcast(context, 0, intent2, 134217728).getIntentSender());
                                } else {
                                    shortcutManager.requestPinShortcut(build, null);
                                }
                            }
                        }
                    }
                }
                if (obj == null && z) {
                    d(context, false, z);
                    return;
                }
            }
            obj = 1;
            if (obj == null) {
            }
        }
    }

    public static void o(Context context, Intent intent) {
        a(context, intent, null, false);
    }

    private static void d(Context context, boolean z, boolean z2) {
        if (z2) {
            h.bA(context, z ? context.getString(a.h.app_added) : context.getString(a.h.app_add_failed));
        }
    }

    public static boolean V(Context context, String str) {
        hdu = q.GF();
        p(context, a(context, str, false, hdu));
        return true;
    }

    public static boolean p(Context context, Intent intent) {
        if (context == null) {
            x.e("MicroMsg.ShortcutManager", "context is null");
            return false;
        } else if (intent == null) {
            x.e("MicroMsg.ShortcutManager", "intent is null");
            return false;
        } else if (VERSION.SDK_INT >= 26) {
            return true;
        } else {
            context.sendBroadcast(intent);
            return true;
        }
    }

    private static Intent a(Context context, String str, boolean z, String str2) {
        if (str == null || context == null) {
            x.e("MicroMsg.ShortcutManager", "getIntent, wrong parameters");
            return null;
        }
        Parcelable parcelable;
        int i = (int) (context.getResources().getDisplayMetrics().density * 48.0f);
        Bitmap a = c.a(str, false, -1);
        if (a == null) {
            x.e("MicroMsg.ShortcutManager", "getScaledBitmap fail, bmp is null");
            a = com.tencent.mm.sdk.platformtools.c.CV(d.default_avatar);
        }
        if (a == null) {
            x.e("MicroMsg.ShortcutManager", "use default avatar, bmp is null");
            parcelable = null;
        } else {
            Object parcelable2 = Bitmap.createScaledBitmap(a, i, i, false);
        }
        if (parcelable2 == null) {
            x.e("MicroMsg.ShortcutManager", "no bmp");
            return null;
        }
        ab Yg = ((i) g.l(i.class)).FR().Yg(str);
        if (Yg == null || ((int) Yg.dhP) <= 0) {
            x.e("MicroMsg.ShortcutManager", "no such user");
            return null;
        }
        String wM = wM(str);
        x.i("MicroMsg.ShortcutManager", "alvinluo encryptShortcutUser: %s", new Object[]{wM});
        if (bi.oW(wM)) {
            return null;
        }
        Parcelable intent = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        intent.putExtra("LauncherUI.Shortcut.Username", wM);
        intent.putExtra("LauncherUI.From.Biz.Shortcut", true);
        intent.putExtra("app_shortcut_custom_id", wM);
        intent.setPackage(context.getPackageName());
        intent.addFlags(67108864);
        Intent intent2 = new Intent(z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT");
        intent2.putExtra("android.intent.extra.shortcut.NAME", s.a(Yg, str));
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON", parcelable2);
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_SOURCE_KEY", hdt);
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_OWNER_ID", wM(str2));
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_UNIQUE_ID", wM);
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_TYPE", z(Yg));
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_CONTAINER", 0);
        return intent2;
    }

    public static int z(ab abVar) {
        if (abVar.ckW()) {
            return 2;
        }
        if (s.hP(abVar.field_username)) {
            return 0;
        }
        return 1;
    }

    public static String bT(String str, String str2) {
        try {
            int i;
            int[] iArr = new int[GLIcon.TOP];
            byte[] bArr = new byte[GLIcon.TOP];
            for (i = 0; i < GLIcon.TOP; i++) {
                iArr[i] = i;
            }
            for (i = 0; i < GLIcon.TOP; i = (short) (i + 1)) {
                bArr[i] = (byte) str2.charAt(i % str2.length());
            }
            int i2 = 0;
            for (i = 0; i < 255; i++) {
                i2 = ((i2 + iArr[i]) + bArr[i]) % GLIcon.TOP;
                int i3 = iArr[i];
                iArr[i] = iArr[i2];
                iArr[i2] = i3;
            }
            char[] toCharArray = str.toCharArray();
            char[] cArr = new char[toCharArray.length];
            i2 = 0;
            int i4 = 0;
            for (i = 0; i < toCharArray.length; i = (short) (i + 1)) {
                i2 = (i2 + 1) % GLIcon.TOP;
                i4 = (i4 + iArr[i2]) % GLIcon.TOP;
                int i5 = iArr[i2];
                iArr[i2] = iArr[i4];
                iArr[i4] = i5;
                cArr[i] = (char) (((char) iArr[(iArr[i2] + (iArr[i4] % GLIcon.TOP)) % GLIcon.TOP]) ^ toCharArray[i]);
            }
            return new String(cArr);
        } catch (Throwable e) {
            x.e("MicroMsg.ShortcutManager", "Exception in rc4, %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.ShortcutManager", e, "", new Object[0]);
            return null;
        }
    }

    public static String wL(String str) {
        String str2 = null;
        if (str == null || str.length() <= 0) {
            return str2;
        }
        String an = bi.an(ad.getContext(), Process.myPid());
        String packageName = ad.getPackageName();
        x.i("MicroMsg.ShortcutManager", "process name: %s", new Object[]{an});
        try {
            int Df;
            if (!packageName.equals(an)) {
                Df = aa.UZ().esl.Df();
            } else if (!g.Eg().Dx()) {
                return str2;
            } else {
                g.Eg();
                Df = com.tencent.mm.kernel.a.Df();
            }
            if (str.startsWith("shortcut_")) {
                return bT(new String(wN(str.substring(9))), String.valueOf(Df));
            }
            return str;
        } catch (Exception e) {
            x.printErrStackTrace("MicroMsg.ShortcutManager", str2, "exception: %s", new Object[]{e.getMessage()});
            return str2;
        }
    }

    public static String wM(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String an = bi.an(ad.getContext(), Process.myPid());
        String packageName = ad.getPackageName();
        if (packageName.equals(an) && !g.Eg().Dx()) {
            return null;
        }
        x.i("MicroMsg.ShortcutManager", "process name: %s", new Object[]{an});
        try {
            if (packageName.equals(an)) {
                StringBuilder stringBuilder = new StringBuilder();
                g.Eg();
                an = bT(str, stringBuilder.append(com.tencent.mm.kernel.a.Df()).toString());
            } else {
                an = bT(str, aa.UZ().esl.Df());
            }
            if (bi.oW(an)) {
                return null;
            }
            return "shortcut_" + aa(an.getBytes());
        } catch (Exception e) {
            x.printErrStackTrace("MicroMsg.ShortcutManager", null, "exception: %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    public static String aa(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append(hdv[(bArr[i] & com.tencent.mm.plugin.appbrand.jsapi.share.d.CTRL_INDEX) >>> 4]);
            stringBuilder.append(hdv[bArr[i] & 15]);
        }
        return stringBuilder.toString();
    }

    public static final byte[] wN(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
        }
        return bArr;
    }
}
