package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class d extends DataSetObservable {
    private static final String BD = d.class.getSimpleName();
    private static final Object Le = new Object();
    private static final Map<String, d> Lf = new HashMap();
    private Intent Hq;
    final Object Lg;
    final List<a> Lh;
    private final List<c> Li;
    private final String Lj;
    private b Lk;
    private int Ll;
    private boolean Lm;
    private boolean Ln;
    private boolean Lo;
    private boolean Lp;
    private d Lq;
    private final Context mContext;

    public final int eq() {
        int size;
        synchronized (this.Lg) {
            es();
            size = this.Lh.size();
        }
        return size;
    }

    public final ResolveInfo aL(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.Lg) {
            es();
            resolveInfo = ((a) this.Lh.get(i)).resolveInfo;
        }
        return resolveInfo;
    }

    public final int a(ResolveInfo resolveInfo) {
        synchronized (this.Lg) {
            es();
            List list = this.Lh;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((a) list.get(i)).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public final Intent aM(int i) {
        synchronized (this.Lg) {
            if (this.Hq == null) {
                return null;
            }
            es();
            a aVar = (a) this.Lh.get(i);
            ComponentName componentName = new ComponentName(aVar.resolveInfo.activityInfo.packageName, aVar.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.Hq);
            intent.setComponent(componentName);
            if (this.Lq != null) {
                Intent intent2 = new Intent(intent);
                if (this.Lq.ex()) {
                    return null;
                }
            }
            a(new c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public final ResolveInfo er() {
        synchronized (this.Lg) {
            es();
            if (this.Lh.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((a) this.Lh.get(0)).resolveInfo;
            return resolveInfo;
        }
    }

    public final int getHistorySize() {
        int size;
        synchronized (this.Lg) {
            es();
            size = this.Li.size();
        }
        return size;
    }

    final void es() {
        int i;
        int i2 = 1;
        if (!this.Lp || this.Hq == null) {
            i = 0;
        } else {
            this.Lp = false;
            this.Lh.clear();
            List queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.Hq, 0);
            int size = queryIntentActivities.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.Lh.add(new a(this, (ResolveInfo) queryIntentActivities.get(i3)));
            }
            i = 1;
        }
        if (this.Lm && this.Lo && !TextUtils.isEmpty(this.Lj)) {
            this.Lm = false;
            this.Ln = true;
            ev();
        } else {
            i2 = 0;
        }
        i |= i2;
        eu();
        if (i != 0) {
            et();
            notifyChanged();
        }
    }

    private boolean et() {
        if (this.Lk == null || this.Hq == null || this.Lh.isEmpty() || this.Li.isEmpty()) {
            return false;
        }
        Collections.unmodifiableList(this.Li);
        return true;
    }

    final boolean a(c cVar) {
        boolean add = this.Li.add(cVar);
        if (add) {
            this.Lo = true;
            eu();
            if (this.Ln) {
                if (this.Lo) {
                    this.Lo = false;
                    if (!TextUtils.isEmpty(this.Lj)) {
                        e eVar = new e(this, (byte) 0);
                        Object[] objArr = new Object[]{new ArrayList(this.Li), this.Lj};
                        if (VERSION.SDK_INT >= 11) {
                            eVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, objArr);
                        } else {
                            eVar.execute(objArr);
                        }
                    }
                }
                et();
                notifyChanged();
            } else {
                throw new IllegalStateException("No preceding call to #readHistoricalData");
            }
        }
        return add;
    }

    private void eu() {
        int size = this.Li.size() - this.Ll;
        if (size > 0) {
            this.Lo = true;
            for (int i = 0; i < size; i++) {
                this.Li.remove(0);
            }
        }
    }

    private void ev() {
        try {
            InputStream openFileInput = this.mContext.openFileInput(this.Lj);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.Li;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next != 1) {
                            if (!(next == 3 || next == 4)) {
                                if ("historical-record".equals(newPullParser.getName())) {
                                    list.add(new c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                                } else {
                                    throw new XmlPullParserException("Share records file not well-formed.");
                                }
                            }
                        } else if (openFileInput != null) {
                            try {
                                openFileInput.close();
                                return;
                            } catch (IOException e) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (XmlPullParserException e2) {
                new StringBuilder("Error reading historical recrod file: ").append(this.Lj);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                new StringBuilder("Error reading historical recrod file: ").append(this.Lj);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e6) {
                    }
                }
            }
        } catch (FileNotFoundException e7) {
        }
    }
}
