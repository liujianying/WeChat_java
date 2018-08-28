package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.mm.plugin.sns.i.b;
import com.tencent.mm.plugin.sns.i.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class az {
    private static HashMap<Long, Long> hsA = new HashMap();
    private static HashMap<Long, String> hsB = new HashMap();
    private static Map<String, List<String>> kdg = new HashMap();
    private static Map<String, List<String>> kdh = new HashMap();

    private static CharSequence h(Context context, long j) {
        return DateFormat.format(context.getString(j.fmt_normal_time_24), j);
    }

    public static String k(Context context, long j) {
        int i;
        int i2;
        int i3 = 0;
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j);
        int i4 = instance.get(1) == instance2.get(1) ? 1 : 0;
        if (i4 == 0 || instance.get(2) != instance2.get(2)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i4 == 0 || i == 0 || instance.get(5) != instance2.get(5)) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i4 == 0 || i == 0 || instance.get(5) - 1 != instance2.get(5)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            int i5;
            if (i4 != 0 && instance.get(2) - 1 == instance2.get(2)) {
                i5 = 1;
            } else if (instance.get(1) - instance2.get(1) == 1) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (i5 != 0) {
                instance.add(5, -1);
                if (instance.get(1) == instance2.get(1) && instance.get(2) == instance2.get(2) && instance.get(5) == instance2.get(5)) {
                    i3 = 1;
                }
                if (i2 != 0) {
                    return (String) h(context, j);
                }
                if (i3 != 0) {
                    return context.getString(j.fmt_pre_yesterday) + " " + ((String) h(context, j));
                }
                String str;
                if (i4 != 0) {
                    str = (String) DateFormat.format(context.getString(j.fmt_date), j);
                } else {
                    str = (String) DateFormat.format(context.getString(j.fmt_longdate), j);
                }
                if (str.indexOf("-") > 0) {
                    i3 = instance2.get(2) + 1;
                    str = instance2.get(5) + " " + M(context, i3);
                    if (i4 == 0) {
                        str = str + " " + instance2.get(1);
                    }
                }
                return str + " " + ((String) h(context, j));
            }
        }
        i3 = i;
        if (i2 != 0) {
            return (String) h(context, j);
        }
        if (i3 != 0) {
            return context.getString(j.fmt_pre_yesterday) + " " + ((String) h(context, j));
        }
        String str2;
        if (i4 != 0) {
            str2 = (String) DateFormat.format(context.getString(j.fmt_date), j);
        } else {
            str2 = (String) DateFormat.format(context.getString(j.fmt_longdate), j);
        }
        if (str2.indexOf("-") > 0) {
            i3 = instance2.get(2) + 1;
            str2 = instance2.get(5) + " " + M(context, i3);
            if (i4 == 0) {
                str2 = str2 + " " + instance2.get(1);
            }
        }
        return str2 + " " + ((String) h(context, j));
    }

    public static String l(Context context, long j) {
        int i;
        int i2;
        int i3 = 0;
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j);
        int i4 = instance.get(1) == instance2.get(1) ? 1 : 0;
        if (i4 == 0 || instance.get(2) != instance2.get(2)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i4 == 0 || i == 0 || instance.get(5) != instance2.get(5)) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i4 == 0 || i == 0 || instance.get(5) - 1 != instance2.get(5)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            int i5;
            if (i4 != 0 && instance.get(2) - 1 == instance2.get(2)) {
                i5 = 1;
            } else if (instance.get(1) - instance2.get(1) == 1) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (i5 != 0) {
                instance.add(5, -1);
                if (instance.get(1) == instance2.get(1) && instance.get(2) == instance2.get(2) && instance.get(5) == instance2.get(5)) {
                    i3 = 1;
                }
                if (i2 != 0) {
                    return (String) h(context, j);
                }
                if (i3 != 0) {
                    return context.getString(j.fmt_pre_yesterday) + " " + ((String) h(context, j));
                }
                String str = (String) DateFormat.format(context.getString(j.fmt_longdate), j);
                if (str.indexOf("-") > 0) {
                    i3 = instance2.get(2) + 1;
                    str = instance2.get(5) + " " + M(context, i3);
                    if (i4 == 0) {
                        str = str + " " + instance2.get(1);
                    }
                }
                return str + " " + ((String) h(context, j));
            }
        }
        i3 = i;
        if (i2 != 0) {
            return (String) h(context, j);
        }
        if (i3 != 0) {
            return context.getString(j.fmt_pre_yesterday) + " " + ((String) h(context, j));
        }
        String str2 = (String) DateFormat.format(context.getString(j.fmt_longdate), j);
        if (str2.indexOf("-") > 0) {
            i3 = instance2.get(2) + 1;
            str2 = instance2.get(5) + " " + M(context, i3);
            if (i4 == 0) {
                str2 = str2 + " " + instance2.get(1);
            }
        }
        return str2 + " " + ((String) h(context, j));
    }

    public static synchronized void clean() {
        synchronized (az.class) {
            hsA.clear();
            hsB.clear();
        }
    }

    public static synchronized String g(Context context, long j) {
        String str;
        synchronized (az.class) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                str = "";
            } else {
                long timeInMillis = gregorianCalendar.getTimeInMillis();
                if (hsA.containsKey(Long.valueOf(j))) {
                    if (timeInMillis - ((Long) hsA.get(Long.valueOf(j))).longValue() >= 60000) {
                        hsA.remove(Long.valueOf(j));
                    } else if (hsB.containsKey(Long.valueOf(j))) {
                        str = (String) hsB.get(Long.valueOf(j));
                    }
                }
                int i;
                if ((timeInMillis - j) / 3600000 == 0) {
                    i = (int) ((timeInMillis - j) / 60000);
                    if (i <= 0) {
                        i = 1;
                    }
                    str = context.getResources().getQuantityString(h.fmt_in60min, i, new Object[]{Integer.valueOf(i)});
                    hsB.put(Long.valueOf(j), str);
                    hsA.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                } else {
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                    long timeInMillis2 = j - gregorianCalendar2.getTimeInMillis();
                    if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                        timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                        if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                            i = (int) (((gregorianCalendar2.getTimeInMillis() + 86400000) - j) / 86400000);
                            if (i <= 0) {
                                i = 1;
                            }
                            str = context.getResources().getQuantityString(h.fmt_indayh, i, new Object[]{Integer.valueOf(i)});
                            hsB.put(Long.valueOf(j), str);
                            hsA.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                        } else {
                            str = context.getString(j.fmt_pre_yesterday);
                            hsB.put(Long.valueOf(j), str);
                            hsA.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                        }
                    } else {
                        i = (int) ((timeInMillis - j) / 3600000);
                        if (i <= 0) {
                            i = 1;
                        }
                        str = context.getResources().getQuantityString(h.fmt_in24h, i, new Object[]{Integer.valueOf(i)});
                        hsB.put(Long.valueOf(j), str);
                        hsA.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                    }
                }
            }
        }
        return str;
    }

    private static void aI(Context context, String str) {
        String[] stringArray = context.getResources().getStringArray(b.time_month);
        List arrayList = new ArrayList();
        arrayList.add("");
        for (Object add : stringArray) {
            arrayList.add(add);
        }
        kdh.put(str, arrayList);
    }

    private static String M(Context context, int i) {
        String[] stringArray = context.getResources().getStringArray(b.time_month);
        List arrayList = new ArrayList();
        arrayList.add("");
        for (Object add : stringArray) {
            arrayList.add(add);
        }
        if (i >= arrayList.size()) {
            return "";
        }
        return (String) arrayList.get(i);
    }

    public static String v(Context context, String str, String str2) {
        if (kdh.get(str2) == null) {
            aI(context, str2);
        }
        int i = bi.getInt(str, 0);
        List list = (List) kdh.get(str2);
        if (i >= list.size() || list.get(i) == null || ((String) list.get(i)).equals("")) {
            aI(context, str2);
        }
        list = (List) kdh.get(str2);
        if (i < list.size()) {
            return (String) list.get(i);
        }
        return "";
    }

    public static CharSequence a(Context context, long j, boolean z) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            return "";
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis > 0 && timeInMillis <= 86400000 && z) {
            return context.getString(j.fmt_pre_nowday);
        }
        long timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
        if (timeInMillis2 > 0 && timeInMillis2 <= 86400000 && z) {
            return context.getString(j.fmt_pre_yesterday);
        }
        new GregorianCalendar().setTimeInMillis(j);
        return DateFormat.format(context.getString(j.fmt_date_split), j);
    }
}
