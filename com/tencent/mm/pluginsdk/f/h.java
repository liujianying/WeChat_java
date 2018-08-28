package com.tencent.mm.pluginsdk.f;

import android.content.Context;
import android.text.format.DateFormat;
import android.text.format.Time;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public final class h {
    private static long qBp;
    private static boolean qBq = false;
    private static final Locale qBr = w.Wl(w.chP());
    private static final boolean qBs = w.chM();

    public static String h(String str, long j) {
        return new SimpleDateFormat(str).format(new Date(1000 * j));
    }

    public static String V(Context context, int i) {
        long j = 1000 * ((long) i);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            return "";
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return p(context, timeInMillis) + ";" + an(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_normal_time), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() - 86400000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_yesterday) + " " + p(context, timeInMillis) + ";" + an(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_normal_time), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() - 172800000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_daybeforyesterday) + " " + p(context, timeInMillis) + ";" + an(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_normal_time), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() + 86400000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_tomorrow) + " " + p(context, timeInMillis) + ";" + an(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_normal_time), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() + 172800000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_dayaftertomorrow) + " " + p(context, timeInMillis) + ";" + an(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_normal_time), j);
        }
        gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j);
        int i2 = gregorianCalendar2.get(11);
        if (gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(3) == gregorianCalendar2.get(3)) {
            return W(context, gregorianCalendar2.get(7)) + " " + X(context, i2) + ";" + an(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_normal_time), j);
        } else if (gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(3) + 1 == gregorianCalendar2.get(3)) {
            String string;
            int i3 = gregorianCalendar2.get(7);
            StringBuilder stringBuilder = new StringBuilder();
            switch (i3) {
                case 1:
                    string = context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_next_week_sunday);
                    break;
                case 2:
                    string = context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_next_week_monday);
                    break;
                case 3:
                    string = context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_next_week_tuesday);
                    break;
                case 4:
                    string = context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_next_week_wednesday);
                    break;
                case 5:
                    string = context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_next_week_thursday);
                    break;
                case 6:
                    string = context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_next_week_friday);
                    break;
                case 7:
                    string = context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_next_week_saturday);
                    break;
                default:
                    string = "";
                    break;
            }
            return stringBuilder.append(string).append(" ").append(X(context, i2)).append(";").append(an(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_normal_time), j)).toString();
        } else if (gregorianCalendar.get(1) == gregorianCalendar2.get(1)) {
            return DateFormat.format(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_date), j) + " " + X(context, i2) + ";" + an(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_normal_time), j);
        } else {
            return DateFormat.format(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_longdate), j) + " " + X(context, i2) + ";" + an(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_normal_time), j);
        }
    }

    public static String an(String str, long j) {
        String charSequence = DateFormat.format(str, j).toString();
        if (bi.oW(charSequence)) {
            return "";
        }
        charSequence = charSequence.trim();
        if (charSequence.startsWith("0")) {
            return charSequence.substring(1);
        }
        return charSequence;
    }

    public static String W(Context context, int i) {
        switch (i) {
            case 1:
                return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_week_sunday);
            case 2:
                return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_week_monday);
            case 3:
                return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_week_tuesday);
            case 4:
                return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_week_wednesday);
            case 5:
                return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_week_thursday);
            case 6:
                return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_week_friday);
            case 7:
                return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_week_saturday);
            default:
                return "";
        }
    }

    public static CharSequence n(Context context, long j) {
        return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_voip_longtime_prefix) + DateFormat.format(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_voip_longtime), j);
    }

    public static CharSequence o(Context context, long j) {
        return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_voip_voice_longtime_prefix) + DateFormat.format(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_voip_longtime), j);
    }

    private static CharSequence X(Context context, int i) {
        if (i < 0) {
            return "";
        }
        if (((long) i) < 6) {
            return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_dawn);
        }
        if (((long) i) < 12) {
            return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_morning);
        }
        if (((long) i) < 13) {
            return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_noon);
        }
        if (((long) i) < 18) {
            return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_afternoon);
        }
        return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_evening);
    }

    public static CharSequence p(Context context, long j) {
        if (j < 0) {
            return "";
        }
        if (j < 21600000) {
            return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_dawn);
        }
        if (j < 43200000) {
            return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_morning);
        }
        if (j < 46800000) {
            return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_noon);
        }
        if (j < 64800000) {
            return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_afternoon);
        }
        return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_evening);
    }

    public static boolean ccd() {
        if (System.currentTimeMillis() - qBp > 30000) {
            qBq = DateFormat.is24HourFormat(ad.getContext());
        }
        return qBq;
    }

    public static CharSequence c(Context context, long j, boolean z) {
        CharSequence charSequence;
        if (!qBs) {
            Locale locale = qBr;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                return "";
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
            long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
            if (timeInMillis <= 0 || timeInMillis > 86400000) {
                long timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                if (timeInMillis2 > 0 && timeInMillis2 <= 86400000) {
                    return z ? context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_yesterday) : context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_yesterday) + " " + java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j));
                } else {
                    gregorianCalendar2 = new GregorianCalendar();
                    gregorianCalendar2.setTimeInMillis(j);
                    if (gregorianCalendar.get(1) != gregorianCalendar2.get(1) || gregorianCalendar.get(3) != gregorianCalendar2.get(3)) {
                        return gregorianCalendar.get(1) == gregorianCalendar2.get(1) ? z ? java.text.DateFormat.getDateInstance(3, locale).format(Long.valueOf(j)) : java.text.DateFormat.getDateTimeInstance(3, 3, locale).format(Long.valueOf(j)) : z ? java.text.DateFormat.getDateInstance(3, locale).format(Long.valueOf(j)) : java.text.DateFormat.getDateTimeInstance(3, 3, locale).format(Long.valueOf(j));
                    } else {
                        charSequence = new SimpleDateFormat("E", locale).format(Long.valueOf(j));
                        if (z) {
                            return charSequence;
                        }
                        return charSequence + " " + java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j));
                    }
                }
            }
            return java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j));
        } else if (j < 3600000) {
            return "";
        } else {
            Time time = new Time();
            Time time2 = new Time();
            time.set(j);
            time2.setToNow();
            if (time.year == time2.year && time.yearDay == time2.yearDay) {
                if (ccd()) {
                    return g.a(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_normal_time_24), time);
                }
                return X(context, time.hour) + g.a(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_normal_time), time);
            } else if (time.year == time2.year && time2.yearDay - time.yearDay == 1) {
                boolean ccd = ccd();
                if (z) {
                    return context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_yesterday);
                }
                Object a;
                StringBuilder append = new StringBuilder().append(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_pre_yesterday)).append(" ");
                if (ccd) {
                    a = g.a(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_normal_time_24), time);
                } else {
                    a = X(context, time.hour) + g.a(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_normal_time), time);
                }
                return append.append(a).toString();
            } else if (time.year == time2.year && time.getWeekNumber() == time2.getWeekNumber()) {
                charSequence = g.a("E ", time);
                if (z) {
                    return charSequence;
                }
                return charSequence + g.a(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_patime), time);
            } else if (time.year == time2.year) {
                if (z) {
                    return g.a(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_date), time);
                }
                return g.a(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_datetime, new Object[]{p(context, ((long) time.hour) * 3600000)}).toString(), time);
            } else if (z) {
                return g.a(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_longdate), time);
            } else {
                return g.a(context.getString(com.tencent.mm.plugin.comm.a.h.fmt_longtime, new Object[]{p(context, ((long) time.hour) * 3600000)}).toString(), time);
            }
        }
    }
}
