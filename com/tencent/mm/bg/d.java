package com.tencent.mm.bg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class d {
    private static final Map<String, String> qVd;
    private static HashMap<String, c> qVe = new HashMap();
    private static final HashSet<String> qVf = new 13();

    static {
        Map hashMap = new HashMap();
        qVd = hashMap;
        hashMap.put("location", "talkroom");
        qVd.put("talkroom", "voip");
    }

    public static void a(Context context, String str, String str2, Intent intent) {
        a(str, new 1(intent, str, str2, context), new 6(str));
    }

    public static void a(Context context, String str, String str2, Intent intent, Intent intent2) {
        a(str, new 7(intent, str, str2, context, intent2), new 8(str));
    }

    public static void A(Context context, String str, String str2) {
        c(context, str, str2, null);
    }

    public static void b(Context context, String str, String str2, Intent intent) {
        a(context, str, str2, intent, null);
    }

    public static void a(Context context, String str, String str2, Intent intent, Bundle bundle) {
        if (!com.tencent.mm.compatible.util.d.fS(21)) {
            try {
                if (context.getSharedPreferences(ad.chY(), 0).getBoolean("settings_multi_webview", false) && ".ui.tools.WebViewUI".endsWith(str2)) {
                    x.i("MicroMsg.PluginHelper", "start multi webview!!!!!!!!!");
                    intent.addFlags(134217728);
                    intent.addFlags(524288);
                }
            } catch (Exception e) {
                x.e("MicroMsg.PluginHelper", "%s", new Object[]{e.getMessage()});
            }
        }
        b(context, str, str2, intent, bundle);
    }

    public static void c(Context context, String str, String str2, Intent intent) {
        b(context, str, str2, intent, null);
    }

    private static void b(Context context, String str, String str2, Intent intent, Bundle bundle) {
        x.d("MicroMsg.PluginHelper", "start activity, need try load plugin[%B]", new Object[]{Boolean.valueOf(true)});
        if (context == null) {
            x.e("MicroMsg.PluginHelper", "start activity error, context is null");
        } else {
            a(str, new 9(str, intent, str2, context, bundle), new 10(str));
        }
    }

    public static void e(Context context, String str, Intent intent) {
        c(context, str, intent, null);
    }

    public static void c(Context context, String str, Intent intent, Bundle bundle) {
        if (intent == null) {
            intent = new Intent();
        }
        String chX = ad.chX();
        if (str.startsWith(".")) {
            str = chX + str;
        }
        intent.setClassName(ad.getPackageName(), str);
        if (context instanceof Activity) {
            context.startActivity(intent, bundle);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent, bundle);
    }

    public static void c(Context context, String str, String str2, int i) {
        a(context, str, str2, null, i, true);
    }

    public static void b(Context context, String str, String str2, Intent intent, int i) {
        a(context, str, str2, intent, i, true);
    }

    public static void a(Context context, String str, String str2, Intent intent, int i, boolean z) {
        x.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", new Object[]{Boolean.valueOf(z)});
        a(str, new 11(intent, str, str2, context, i), new 12(str));
    }

    public static void a(Fragment fragment, String str, String str2, Intent intent, int i) {
        x.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", new Object[]{Boolean.valueOf(true)});
        a(str, new 4(intent, str, str2, fragment, i), new 5(str));
    }

    public static void f(Context context, String str, Intent intent) {
        if (intent != null && qVf.contains(str)) {
            intent.putExtra("animation_pop_in", true);
            b.E(context, intent);
        }
    }

    public static void b(Context context, String str, Intent intent, int i) {
        intent.setClassName(ad.getPackageName(), str.startsWith(".") ? ad.chX() + str : str);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            f(context, str, intent);
            return;
        }
        x.f("MicroMsg.PluginHelper", "context not activity, skipped");
    }

    public static void a(MMActivity mMActivity, String str, Intent intent, int i, a aVar) {
        String chX = ad.chX();
        if (str.startsWith(".")) {
            chX = chX + str;
        } else {
            chX = str;
        }
        intent.setClassName(ad.getPackageName(), chX);
        mMActivity.b(aVar, intent, i);
        f(mMActivity, str, intent);
    }

    public static void a(Fragment fragment, String str, Intent intent, int i) {
        intent.setClassName(ad.getPackageName(), str.startsWith(".") ? ad.chX() + str : str);
        if (fragment instanceof Fragment) {
            fragment.startActivityForResult(intent, i);
            f(fragment.getActivity(), str, intent);
            return;
        }
        x.f("MicroMsg.PluginHelper", "fragment not Fragment, skipped");
    }

    public static void a(b bVar, String str, String str2, Intent intent, int i, a aVar) {
        x.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", new Object[]{Boolean.valueOf(true)});
        final Intent intent2 = intent;
        final String str3 = str;
        final String str4 = str2;
        final b bVar2 = bVar;
        final int i2 = i;
        final a aVar2 = aVar;
        a(str, new a() {
            public final void onDone() {
                Intent intent = intent2 == null ? new Intent() : intent2;
                intent.setClassName(ad.getPackageName(), str4.startsWith(".") ? (ad.chX() + ".plugin." + str3) + str4 : str4);
                bVar2.a(intent, i2, aVar2);
                d.f(bVar2.getContext(), str4, intent2);
            }
        }, new 3(str));
    }

    public static void Uo(String str) {
        x.d("MicroMsg.PluginHelper", "-->createSubCore: %s", new Object[]{str});
        c Uq = Uq(str);
        if (Uq == null) {
            x.f("MicroMsg.PluginHelper", "register subcore failed, plugin=%s", new Object[]{str});
        } else if (Uq.createSubCore() == null) {
            x.w("MicroMsg.PluginHelper", "create sub core failed, plugin=%s", new Object[]{str});
        } else {
            x.d("MicroMsg.PluginHelper", "<--createSubCore successfully: %s", new Object[]{str});
        }
    }

    public static ar Up(String str) {
        x.d("MicroMsg.PluginHelper", "-->createSubCore: %s alone", new Object[]{str});
        c Uq = Uq(str);
        if (Uq == null) {
            x.f("MicroMsg.PluginHelper", "register subcore failed, plugin=%s", new Object[]{str});
            return null;
        }
        ar createSubCore = Uq.createSubCore();
        if (createSubCore == null) {
            x.w("MicroMsg.PluginHelper", "create sub core failed, plugin=%s", new Object[]{str});
            return null;
        }
        x.d("MicroMsg.PluginHelper", "<--createSubCore successfully: %s", new Object[]{str});
        return createSubCore;
    }

    public static void a(String str, m mVar, l lVar) {
        x.d("MicroMsg.PluginHelper", "--> registerApplication: %s", new Object[]{str});
        c Uq = Uq(str);
        if (Uq == null) {
            x.f("MicroMsg.PluginHelper", "register application failed, plugin=%s", new Object[]{str});
            return;
        }
        n createApplication = Uq.createApplication();
        if (createApplication == null) {
            x.w("MicroMsg.PluginHelper", "register application failed, plugin=%s", new Object[]{str});
            return;
        }
        createApplication.a(lVar);
        createApplication.a(mVar);
        x.d("MicroMsg.PluginHelper", "<-- registerApplication successfully: %s %s %s", new Object[]{str, mVar, lVar});
    }

    public static com.tencent.mm.pluginsdk.b.a Z(Context context, String str) {
        return B(context, str, null);
    }

    public static com.tencent.mm.pluginsdk.b.a B(Context context, String str, String str2) {
        c Uq = Uq(str);
        if (Uq == null) {
            x.f("MicroMsg.PluginHelper", "create contact widget failed, plugin=%s, type=%s", new Object[]{str, str2});
            return null;
        }
        com.tencent.mm.pluginsdk.b.b contactWidgetFactory = Uq.getContactWidgetFactory();
        if (contactWidgetFactory != null) {
            return contactWidgetFactory.Z(context, str2);
        }
        x.f("MicroMsg.PluginHelper", "create contact widget factory failed, plugin=%s, type=%s", new Object[]{str, str2});
        return null;
    }

    public static boolean cfH() {
        return false;
    }

    public static synchronized boolean QS(String str) {
        boolean z;
        synchronized (d.class) {
            z = qVe.get(str) != null;
        }
        return z;
    }

    private static synchronized c Uq(String str) {
        c Ur;
        synchronized (d.class) {
            try {
                Ur = Ur(str);
            } catch (ClassNotFoundException e) {
                x.f("MicroMsg.PluginHelper", "plugin load failed ClassNotFoundException , plugin=%s, e:%s", new Object[]{str, e.toString()});
            } catch (InstantiationException e2) {
                x.f("MicroMsg.PluginHelper", "plugin load failed InstantiationException , plugin=%s, e:%s", new Object[]{str, e2.toString()});
            } catch (IllegalAccessException e3) {
                x.f("MicroMsg.PluginHelper", "plugin load failed IllegalAccessException , plugin=%s, e:%s", new Object[]{str, e3.toString()});
            }
        }
        return Ur;
        Ur = null;
        return Ur;
    }

    public static synchronized c a(String str, a aVar, b bVar) {
        c cVar;
        synchronized (d.class) {
            if (((String) qVd.get(str)) != null) {
                x.d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", new Object[]{str, (String) qVd.get(str)});
            }
            cVar = (c) qVe.get(str);
            if (cVar != null) {
                aVar.onDone();
            } else {
                try {
                    cVar = Ur(str);
                    if (cVar != null) {
                        aVar.onDone();
                    }
                } catch (Exception e) {
                    try {
                        cVar = Ur(str);
                        if (cVar != null) {
                            aVar.onDone();
                        }
                    } catch (ClassNotFoundException e2) {
                        x.f("MicroMsg.PluginHelper", "plugin load failed ClassNotFoundException , plugin=%s ,e:%s", new Object[]{str, e2.toString()});
                        x.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[]{str});
                        bVar.e(new IllegalArgumentException("Load Plugin Faild"));
                        cVar = null;
                        return cVar;
                    } catch (InstantiationException e3) {
                        x.f("MicroMsg.PluginHelper", "plugin load failed InstantiationException , plugin=%s, e:%s", new Object[]{str, e3.toString()});
                        x.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[]{str});
                        bVar.e(new IllegalArgumentException("Load Plugin Faild"));
                        cVar = null;
                        return cVar;
                    } catch (IllegalAccessException e4) {
                        x.f("MicroMsg.PluginHelper", "plugin load failed IllegalAccessException , plugin=%s, e:%s", new Object[]{str, e4.toString()});
                        x.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[]{str});
                        bVar.e(new IllegalArgumentException("Load Plugin Faild"));
                        cVar = null;
                        return cVar;
                    }
                }
            }
        }
        return cVar;
    }

    private static c Ur(String str) {
        c cVar = (c) qVe.get(str);
        if (cVar != null) {
            return cVar;
        }
        cVar = (c) ad.getContext().getClassLoader().loadClass(ad.chX() + ".plugin." + str + ".Plugin").newInstance();
        qVe.put(str, cVar);
        return cVar;
    }

    public static synchronized Class<?> fI(String str, String str2) {
        Class<?> loadClass;
        synchronized (d.class) {
            if (((String) qVd.get(str)) != null) {
                x.d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", new Object[]{str, (String) qVd.get(str)});
            }
            if (Us(str)) {
                String str3 = ad.chX() + ".plugin." + str;
                if (str2.startsWith(".")) {
                    str2 = str3 + str2;
                }
                try {
                    loadClass = ad.getContext().getClassLoader().loadClass(str2);
                } catch (Exception e) {
                    x.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[]{str});
                    loadClass = null;
                }
            } else {
                x.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[]{str});
                loadClass = null;
            }
        }
        return loadClass;
    }

    public static synchronized boolean Us(String str) {
        boolean z;
        synchronized (d.class) {
            z = Uq(str) != null;
        }
        return z;
    }
}
