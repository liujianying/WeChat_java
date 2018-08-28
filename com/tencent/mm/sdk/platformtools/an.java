package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Looper;
import android.util.LruCache;
import android.util.Xml;
import com.tencent.mm.sdk.f.e;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class an implements SharedPreferences {
    private static ag sHn = null;
    private static final Object sHv = new Object();
    private static final LruCache<String, an> sHx = new LruCache(5);
    private Map<String, Object> dmW = null;
    private boolean dpK = false;
    private File fgV = null;
    private int mMode = 0;
    private FLock sHo = null;
    private File sHp = null;
    private boolean sHq = false;
    private int sHr = 0;
    private long sHs = 0;
    private long sHt = 0;
    private final Object sHu = new Object();
    private final WeakHashMap<OnSharedPreferenceChangeListener, Object> sHw = new WeakHashMap();

    public static class a {
        private static SharedPreferences mPref = ad.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
        public static String sHA = "pref_key_is_disabled_MultiProcSP_manually";
        public static String sHz = "pref_key_is_enable_MultiProcSP";

        public static void lf(boolean z) {
            setValue(sHA, z);
        }

        public static boolean ciu() {
            return !Wt(sHA) && Wt(sHz);
        }

        private static boolean Wt(String str) {
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
            mPref = sharedPreferences;
            if (sharedPreferences == null) {
                x.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
                return false;
            }
            x.d("MicroMsg.MultiProcSharedPreferences", "DynamicConfigStorage, getValue:%b", Boolean.valueOf(mPref.getBoolean(str, false)));
            return mPref.getBoolean(str, false);
        }

        public static void setValue(String str, boolean z) {
            if (mPref == null) {
                x.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
                return;
            }
            Editor edit = mPref.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    private final class b implements Editor {
        private final Map<String, Object> sHB;
        private boolean sHC;

        private b() {
            this.sHB = new HashMap();
            this.sHC = false;
        }

        /* synthetic */ b(an anVar, byte b) {
            this();
        }

        public final Editor putString(String str, String str2) {
            synchronized (this) {
                this.sHB.put(str, str2);
            }
            return this;
        }

        public final Editor putStringSet(String str, Set<String> set) {
            synchronized (this) {
                this.sHB.put(str, set);
            }
            return this;
        }

        public final Editor putInt(String str, int i) {
            synchronized (this) {
                this.sHB.put(str, Integer.valueOf(i));
            }
            return this;
        }

        public final Editor putLong(String str, long j) {
            synchronized (this) {
                this.sHB.put(str, Long.valueOf(j));
            }
            return this;
        }

        public final Editor putFloat(String str, float f) {
            synchronized (this) {
                this.sHB.put(str, Float.valueOf(f));
            }
            return this;
        }

        public final Editor putBoolean(String str, boolean z) {
            synchronized (this) {
                this.sHB.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        public final Editor remove(String str) {
            synchronized (this) {
                this.sHB.put(str, this);
            }
            return this;
        }

        public final Editor clear() {
            synchronized (this) {
                this.sHC = true;
            }
            return this;
        }

        public final boolean commit() {
            c civ = civ();
            a(civ, null);
            try {
                civ.sHK.await();
                a(civ);
                return civ.sHL;
            } catch (InterruptedException e) {
                return false;
            }
        }

        public final void apply() {
            final c civ = civ();
            final Runnable anonymousClass1 = new Runnable() {
                public final void run() {
                    try {
                        civ.sHK.await();
                    } catch (InterruptedException e) {
                    }
                }
            };
            au.O(anonymousClass1);
            a(civ, new Runnable() {
                public final void run() {
                    anonymousClass1.run();
                    au.P(anonymousClass1);
                }
            });
            a(civ);
        }

        private c civ() {
            c cVar = new c();
            synchronized (an.this) {
                if (an.this.sHr > 0) {
                    an.this.dmW = new HashMap(an.this.dmW);
                }
                cVar.sHJ = an.this.dmW;
                an.this.sHr = an.this.sHr + 1;
                byte b = an.this.sHw.size() > 0 ? (byte) 1 : (byte) 0;
                if (b != (byte) 0) {
                    cVar.sHI = new ArrayList();
                    cVar.dba = new HashSet(an.this.sHw.keySet());
                }
                synchronized (this) {
                    if (this.sHC) {
                        if (!an.this.dmW.isEmpty()) {
                            cVar.sHH = true;
                            an.this.dmW.clear();
                        }
                        this.sHC = false;
                    }
                    for (Entry entry : this.sHB.entrySet()) {
                        String str = (String) entry.getKey();
                        b value = entry.getValue();
                        if (value != this) {
                            if (an.this.dmW.containsKey(str)) {
                                Object obj = an.this.dmW.get(str);
                                if (obj != null && obj.equals(value)) {
                                }
                            }
                            an.this.dmW.put(str, value);
                        } else if (an.this.dmW.containsKey(str)) {
                            an.this.dmW.remove(str);
                        }
                        cVar.sHH = true;
                        if (b != (byte) 0) {
                            cVar.sHI.add(str);
                        }
                    }
                    this.sHB.clear();
                }
            }
            return cVar;
        }

        private void a(final c cVar, final Runnable runnable) {
            Object obj = 1;
            Runnable anonymousClass3 = new Runnable() {
                public final void run() {
                    synchronized (an.this.sHu) {
                        b.a(b.this, cVar);
                    }
                    synchronized (an.this) {
                        an.this.sHr = an.this.sHr - 1;
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            };
            if ((runnable == null ? 1 : null) != null) {
                synchronized (an.this) {
                    if (an.this.sHr != 1) {
                        obj = null;
                    }
                }
                if (obj != null) {
                    anonymousClass3.run();
                    return;
                }
            }
            au.ciA().execute(anonymousClass3);
        }

        private FileOutputStream M(File file) {
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                File parentFile = file.getParentFile();
                if (parentFile.mkdir()) {
                    an.e(parentFile, an.this.mMode);
                    try {
                        return new FileOutputStream(file);
                    } catch (FileNotFoundException e2) {
                        x.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create SharedPreferences file " + file, e2);
                        return null;
                    }
                }
                x.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create directory for SharedPreferences file " + file);
                return null;
            }
        }

        private void a(final c cVar) {
            if (cVar.dba != null && cVar.sHI != null && cVar.sHI.size() != 0) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    for (int size = cVar.sHI.size() - 1; size >= 0; size--) {
                        String str = (String) cVar.sHI.get(size);
                        for (OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : cVar.dba) {
                            if (onSharedPreferenceChangeListener != null) {
                                onSharedPreferenceChangeListener.onSharedPreferenceChanged(an.this, str);
                            }
                        }
                    }
                    return;
                }
                an.sHn.post(new Runnable() {
                    public final void run() {
                        b.this.a(cVar);
                    }
                });
            }
        }
    }

    private static class c {
        public Set<OnSharedPreferenceChangeListener> dba;
        public boolean sHH;
        public List<String> sHI;
        public Map<String, Object> sHJ;
        public final CountDownLatch sHK;
        public volatile boolean sHL;

        private c() {
            this.sHH = false;
            this.sHI = null;
            this.dba = null;
            this.sHJ = null;
            this.sHK = new CountDownLatch(1);
            this.sHL = false;
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final void lg(boolean z) {
            this.sHL = z;
            this.sHK.countDown();
        }
    }

    static /* synthetic */ void a(an anVar) {
        XmlPullParserException e;
        Object obj;
        FileNotFoundException e2;
        IOException e3;
        Map obj2 = null;
        if (anVar.sHq) {
            try {
                anVar.sHo.chy();
            } catch (Throwable e4) {
                x.printErrStackTrace("MicroMsg.MultiProcSharedPreferences", e4, "", new Object[0]);
            }
        }
        try {
            if (!anVar.dpK) {
                if (anVar.sHp.exists()) {
                    anVar.fgV.delete();
                    anVar.sHp.renameTo(anVar.fgV);
                }
                if (anVar.fgV.exists() && !anVar.fgV.canRead()) {
                    x.w("MicroMsg.MultiProcSharedPreferences", "Attempt to read preferences file " + anVar.fgV + " without permission");
                }
                if (anVar.fgV.canRead()) {
                    InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(anVar.fgV), 16384);
                    XmlPullParser newPullParser = Xml.newPullParser();
                    newPullParser.setInput(bufferedInputStream, null);
                    HashMap hashMap = (HashMap) bm.a(newPullParser, new String[1]);
                    try {
                        bufferedInputStream.close();
                        obj2 = hashMap;
                    } catch (XmlPullParserException e5) {
                        e = e5;
                        obj2 = hashMap;
                        x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e);
                        anVar.dpK = true;
                        if (obj2 != null) {
                            anVar.dmW = new HashMap();
                        } else {
                            anVar.dmW = obj2;
                            anVar.sHs = anVar.fgV.lastModified();
                            anVar.sHt = anVar.fgV.length();
                        }
                        anVar.notifyAll();
                        if (!anVar.sHq) {
                            try {
                                anVar.sHo.unlock();
                            } catch (Exception e6) {
                            }
                        }
                    } catch (FileNotFoundException e7) {
                        e2 = e7;
                        obj2 = hashMap;
                        x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e2);
                        anVar.dpK = true;
                        if (obj2 != null) {
                            anVar.dmW = obj2;
                            anVar.sHs = anVar.fgV.lastModified();
                            anVar.sHt = anVar.fgV.length();
                        } else {
                            anVar.dmW = new HashMap();
                        }
                        anVar.notifyAll();
                        if (!anVar.sHq) {
                            try {
                                anVar.sHo.unlock();
                            } catch (Exception e62) {
                            }
                        }
                    } catch (IOException e8) {
                        e3 = e8;
                        obj2 = hashMap;
                        x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e3);
                        anVar.dpK = true;
                        if (obj2 != null) {
                            anVar.dmW = new HashMap();
                        } else {
                            anVar.dmW = obj2;
                            anVar.sHs = anVar.fgV.lastModified();
                            anVar.sHt = anVar.fgV.length();
                        }
                        anVar.notifyAll();
                        if (!anVar.sHq) {
                            try {
                                anVar.sHo.unlock();
                            } catch (Exception e622) {
                            }
                        }
                    }
                }
                anVar.dpK = true;
                if (obj2 != null) {
                    anVar.dmW = obj2;
                    anVar.sHs = anVar.fgV.lastModified();
                    anVar.sHt = anVar.fgV.length();
                } else {
                    anVar.dmW = new HashMap();
                }
                anVar.notifyAll();
                if (!anVar.sHq) {
                    try {
                        anVar.sHo.unlock();
                    } catch (Exception e6222) {
                    }
                }
            } else if (anVar.sHq) {
                try {
                    anVar.sHo.unlock();
                } catch (Exception e9) {
                }
            }
        } catch (XmlPullParserException e10) {
            e = e10;
            x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e);
            anVar.dpK = true;
            if (obj2 != null) {
                anVar.dmW = obj2;
                anVar.sHs = anVar.fgV.lastModified();
                anVar.sHt = anVar.fgV.length();
            } else {
                anVar.dmW = new HashMap();
            }
            anVar.notifyAll();
            if (!anVar.sHq) {
                try {
                    anVar.sHo.unlock();
                } catch (Exception e62222) {
                }
            }
        } catch (FileNotFoundException e11) {
            e2 = e11;
            x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e2);
            anVar.dpK = true;
            if (obj2 != null) {
                anVar.dmW = new HashMap();
            } else {
                anVar.dmW = obj2;
                anVar.sHs = anVar.fgV.lastModified();
                anVar.sHt = anVar.fgV.length();
            }
            anVar.notifyAll();
            if (!anVar.sHq) {
                try {
                    anVar.sHo.unlock();
                } catch (Exception e622222) {
                }
            }
        } catch (IOException e12) {
            e3 = e12;
            x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e3);
            anVar.dpK = true;
            if (obj2 != null) {
                anVar.dmW = obj2;
                anVar.sHs = anVar.fgV.lastModified();
                anVar.sHt = anVar.fgV.length();
            } else {
                anVar.dmW = new HashMap();
            }
            anVar.notifyAll();
            if (!anVar.sHq) {
                try {
                    anVar.sHo.unlock();
                } catch (Exception e6222222) {
                }
            }
        } catch (Throwable th) {
            if (anVar.sHq) {
                try {
                    anVar.sHo.unlock();
                } catch (Exception e13) {
                }
            }
        }
    }

    static /* synthetic */ void e(File file, int i) {
        boolean z = false;
        file.setReadable(true, (i & 1) == 0);
        if ((i & 2) == 0) {
            z = true;
        }
        file.setWritable(true, z);
    }

    public static SharedPreferences m(Context context, String str, int i) {
        int i2 = 1;
        if (a.ciu()) {
            x.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use Flock version MultiProcessSP.", str);
            an anVar = (an) sHx.get(str);
            if (anVar == null) {
                SharedPreferences anVar2 = new an(context, str, i);
                sHx.put(str, anVar2);
                return anVar2;
            } else if ((i & 4) == 0) {
                return anVar;
            } else {
                synchronized (anVar) {
                    if (anVar.sHr > 0 || (anVar.sHs == anVar.fgV.lastModified() && anVar.sHt == anVar.fgV.length())) {
                        i2 = 0;
                    }
                    if (i2 == 0) {
                        return anVar;
                    }
                    anVar.cir();
                    return anVar;
                }
            }
        }
        x.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use system sp.", str);
        return context.getSharedPreferences(str, i);
    }

    private an() {
        throw new RuntimeException("Not supported.");
    }

    private an(Context context, String str, int i) {
        boolean z;
        Context applicationContext = context.getApplicationContext();
        if (sHn == null) {
            sHn = new ag(Looper.getMainLooper());
        }
        String str2 = applicationContext.getApplicationInfo().dataDir;
        if (str2 == null || str2.length() == 0) {
            x.w("MicroMsg.MultiProcSharedPreferences", "Failed to retrive data path by ApplicationInfo.dataDir, use prefix hardcoded version instead.");
            str2 = "/data/data/" + applicationContext.getPackageName();
        }
        x.i("MicroMsg.MultiProcSharedPreferences", "Path to store sp data: " + str2);
        File file = new File(str2, "shared_prefs");
        if (!file.exists()) {
            file.mkdirs();
        } else if (!(file.canRead() && file.canWrite())) {
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
        this.fgV = new File(file, str + ".xml");
        this.sHp = new File(this.fgV.getPath() + ".bak");
        this.mMode = i;
        if ((i & 4) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.sHq = z;
        if (this.sHq) {
            this.sHo = new FLock(this.fgV.getPath() + ".lock");
        }
        cir();
    }

    private void cir() {
        synchronized (this) {
            this.dpK = false;
        }
        e.b(new Runnable() {
            public final void run() {
                synchronized (an.this) {
                    an.a(an.this);
                }
            }
        }, "MultiProcessSP-LoadThread").start();
    }

    public final void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            this.sHw.put(onSharedPreferenceChangeListener, sHv);
        }
    }

    public final void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            this.sHw.remove(onSharedPreferenceChangeListener);
        }
    }

    private void cis() {
        while (!this.dpK) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public final Map<String, ?> getAll() {
        Map hashMap;
        synchronized (this) {
            cis();
            hashMap = new HashMap(this.dmW);
        }
        return hashMap;
    }

    public final String getString(String str, String str2) {
        String str3;
        synchronized (this) {
            cis();
            str3 = (String) this.dmW.get(str);
            if (str3 == null) {
                str3 = str2;
            }
        }
        return str3;
    }

    public final Set<String> getStringSet(String str, Set<String> set) {
        Set<String> set2;
        synchronized (this) {
            cis();
            set2 = (Set) this.dmW.get(str);
            if (set2 == null) {
                set2 = set;
            }
        }
        return set2;
    }

    public final int getInt(String str, int i) {
        synchronized (this) {
            cis();
            Integer num = (Integer) this.dmW.get(str);
            if (num != null) {
                i = num.intValue();
            }
        }
        return i;
    }

    public final long getLong(String str, long j) {
        synchronized (this) {
            cis();
            Long l = (Long) this.dmW.get(str);
            if (l != null) {
                j = l.longValue();
            }
        }
        return j;
    }

    public final float getFloat(String str, float f) {
        synchronized (this) {
            cis();
            Float f2 = (Float) this.dmW.get(str);
            if (f2 != null) {
                f = f2.floatValue();
            }
        }
        return f;
    }

    public final boolean getBoolean(String str, boolean z) {
        synchronized (this) {
            cis();
            Boolean bool = (Boolean) this.dmW.get(str);
            if (bool != null) {
                z = bool.booleanValue();
            }
        }
        return z;
    }

    public final boolean contains(String str) {
        boolean containsKey;
        synchronized (this) {
            cis();
            containsKey = this.dmW.containsKey(str);
        }
        return containsKey;
    }

    public final Editor edit() {
        synchronized (this) {
            cis();
        }
        return new b(this, (byte) 0);
    }
}
