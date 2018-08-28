package c.t.m.g;

import android.os.Handler;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public final class ce {
    private static Handler a = m.i();
    private static boolean b = true;
    private static boolean c = true;

    private static int a(String str, int i) {
        int i2 = 1;
        if (str.equals("HLDisconnEvent")) {
            return 0;
        }
        String str2;
        if (i != 0) {
            int i3 = (i == -4 || i == -3 || i == -288) ? 1 : 0;
            if (i3 == 0) {
                str2 = "self_report_fail_denominator_value";
                if (i != 0) {
                    if (!(i == -4 || i == -3 || i == -288)) {
                        i2 = 0;
                    }
                    if (i2 == 0) {
                        i2 = 2;
                        return w.a(str2, 0, Integer.MAX_VALUE, i2);
                    }
                }
                i2 = 100;
                return w.a(str2, 0, Integer.MAX_VALUE, i2);
            }
        }
        str2 = "self_report_succ_denominator_value";
        if (i != 0) {
            if (!(i == -4 || i == -3 || i == -288)) {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = 2;
                return w.a(str2, 0, Integer.MAX_VALUE, i2);
            }
        }
        i2 = 100;
        return w.a(str2, 0, Integer.MAX_VALUE, i2);
    }

    public static void a(String str, int i, int i2, String str2, Map<String, String> map, Map<String, String> map2, boolean z) {
        a.post(new cf(str, i, i2, str2, map, map2, z));
    }

    public static void b(String str, int i, int i2, String str2, Map<String, String> map, Map<String, String> map2, boolean z) {
        a.post(new cg(str, i, i2, str2, map, map2, z));
    }

    static /* synthetic */ void a(String str, int i, int i2, String str2, Map map, Map map2, boolean z, boolean z2) {
        int i3;
        Object obj;
        CharSequence str22;
        Iterator it;
        Object obj2;
        Object obj3;
        if (z) {
            try {
                if (p.l()) {
                    i3 = -288;
                    z2 = true;
                    obj = null;
                } else {
                    p.e();
                    int obj4;
                    if (p.h()) {
                        if (!z.a()) {
                            i3 = -3;
                            z2 = true;
                            str22 = "ping failed, " + str22;
                            obj4 = 1;
                        }
                        i3 = i2;
                        obj4 = null;
                    } else {
                        i3 = -4;
                        z2 = true;
                        obj4 = 1;
                    }
                }
            } catch (Throwable th) {
                return;
            }
        }
        Object obj5;
        if (i2 == -4 || i2 == -3 || i2 == -288) {
            obj5 = 1;
        } else {
            obj5 = null;
        }
        if (obj5 != null) {
            z2 = true;
            i3 = i2;
            obj4 = null;
        }
        i3 = i2;
        obj4 = null;
        if (map2 != null) {
            if (map2.containsKey("B83")) {
                map2.put("B83", ci.a(Long.parseLong((String) map2.get("B83")), "yyyy-MM-dd HH:mm:ss.SSS"));
            }
            if (map2.containsKey("B84")) {
                map2.put("B84", ci.a(Long.parseLong((String) map2.get("B84")), "yyyy-MM-dd HH:mm:ss.SSS"));
            }
        }
        if (map != null) {
            it = map.keySet().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (map2 != null) {
            it = map2.keySet().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (i == m.b()) {
            if (b && ("HLReqRspEvent".equals(str) || "HLHttpAgent".equals(str))) {
                b = false;
                obj2 = 1;
                if (z2) {
                    obj3 = 1;
                    r2 = 1;
                } else {
                    Object obj6;
                    if (i == 2) {
                        r2 = a(str, i3);
                    } else {
                        int i4;
                        if ("HLHttpDirect".equals(str) && map != null) {
                            if ("event".equals((String) map.get("B15"))) {
                                r2 = a(str, i3);
                            }
                        }
                        r2 = -1;
                        String str3 = "";
                        if ("HLConnEvent".equals(str)) {
                            if (i3 == 0) {
                                str3 = "report_conn_succ_denominator_value";
                            } else {
                                if (i3 == -4 || i3 == -3 || i3 == -288) {
                                    obj6 = 1;
                                } else {
                                    obj6 = null;
                                }
                                if (obj6 != null) {
                                    str3 = "report_conn_nonet_fail_denominator_value";
                                } else {
                                    str3 = "report_conn_other_fail_denominator_value";
                                }
                            }
                            if (i3 == 0) {
                                r0 = 100;
                            } else {
                                if (i3 == -4 || i3 == -3 || i3 == -288) {
                                    obj6 = 1;
                                } else {
                                    obj6 = null;
                                }
                                if (obj6 != null) {
                                    r0 = 100;
                                } else {
                                    r0 = 1;
                                }
                            }
                            i4 = r0;
                        } else if ("HLSecurityEvent".equals(str)) {
                            str3 = i3 == 0 ? "report_security_req_succ_denominator_value" : "report_security_req_fail_denominator_value";
                            i4 = i3 == 0 ? 100 : 1;
                        } else if ("HLDisconnEvent".equals(str)) {
                            str3 = "report_disconn_denominator_value";
                            i4 = 2;
                        } else if ("HLReqRspEvent".equals(str) || "HLHttpAgent".equals(str) || "HLHttpDirect".equals(str)) {
                            if (obj2 == null || i3 != 0) {
                                if (i3 == 0) {
                                    str3 = "report_req_succ_denominator_value";
                                } else {
                                    if (i3 == -4 || i3 == -3 || i3 == -288) {
                                        obj6 = 1;
                                    } else {
                                        obj6 = null;
                                    }
                                    str3 = obj6 != null ? "report_req_nonet_fail_denominator_value" : "report_req_other_fail_denominator_value";
                                }
                                if (i3 == 0) {
                                    r0 = 100;
                                } else {
                                    if (i3 == -4 || i3 == -3 || i3 == -288) {
                                        obj6 = 1;
                                    } else {
                                        obj6 = null;
                                    }
                                    if (obj6 != null) {
                                        r0 = 100;
                                    } else {
                                        r0 = 1;
                                    }
                                }
                                i4 = r0;
                            } else {
                                str3 = "report_req_ssl_first_denominator_value";
                                i4 = 100;
                            }
                        } else if ("HLPushEvent".equals(str)) {
                            str3 = "report_push_denominator_value";
                            i4 = 10;
                        } else if ("B_DLSDK_Result".equals(str)) {
                            str3 = "report_mass_download_denominator_value";
                            i4 = 1;
                        } else if ("HLDownTiny".equals(str)) {
                            str3 = "report_ease_download_denominator_value";
                            i4 = 10;
                        } else if ("HLHeartBeat".equals(str)) {
                            str3 = i3 == 0 ? "report_heartbeat_succ_denominator_value" : "report_heartbeat_fail_denominator_value";
                            i4 = i3 == 0 ? 10 : 5;
                        } else if ("HLReportEvent".equals(str)) {
                            i4 = 1;
                            str3 = i3 == 0 ? "platform_report_quality_succ_denominator_value" : "platform_report_quality_fail_denominator_value";
                        } else if ("HLMsgClickEvent".equals(str) || "HLMsgProcessEvent".equals(str) || "HLMsgDispatchEvent".equals(str)) {
                            i4 = 1;
                            str3 = i3 == 0 ? "report_msg_push_succ_denominator_value" : "report_msg_push_fail_denominator_value";
                        } else {
                            r2 = 0;
                            i4 = 0;
                        }
                        if (r2 == -1) {
                            r0 = w.a("report_all_events", -1, 1, 0);
                            if (r0 == 1) {
                                r0 = 1;
                            } else if (r0 == -1) {
                                r0 = 0;
                            } else {
                                r0 = w.a(str3, 0, Integer.MAX_VALUE, i4);
                            }
                            r2 = r0;
                        }
                    }
                    obj6 = null;
                    if (r2 > 0 && r2 <= Integer.MAX_VALUE) {
                        obj6 = new Random().nextInt(r2) == 0 ? 1 : null;
                    }
                    obj3 = obj6;
                }
                if (obj3 == null) {
                    boolean z3;
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put("B31", String.valueOf(r2));
                    String str4 = "B7";
                    StringBuilder stringBuilder = new StringBuilder();
                    if (obj4 != null) {
                        r0 = i3;
                    } else {
                        r0 = i2;
                    }
                    map.put(str4, stringBuilder.append(r0).toString());
                    if (obj2 != null) {
                        map.put("B28", "1");
                    }
                    map.put("B1", m.g());
                    map.put("B2", m.b);
                    map.put("B30", m.e());
                    map.put("B3", String.valueOf(i));
                    CharSequence h = m.h();
                    if (!TextUtils.isEmpty(h)) {
                        map.put("B4", h);
                    }
                    map.put("B5", cd.a());
                    h = p.c();
                    if (!TextUtils.isEmpty(h)) {
                        map.put("B29", h);
                    }
                    if (w.a("access_report_detail", 0, 1, 1) == 1) {
                        if (map2 != null) {
                            map.putAll(map2);
                        }
                        map.put("B6", p.b());
                        if (!(i3 == -4 || TextUtils.isEmpty(str22))) {
                            map.put("B8", str22);
                        }
                        map.put("D1", m.c());
                        map.put("D2", m.d());
                        map.put("D3", m.c);
                    }
                    if (i2 == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    w.a(str, z3, map);
                }
            } else if (c && "HLHttpDirect".equals(str)) {
                String str5 = (String) map.get("B15");
                if (!ci.a(str5) && str5.equals("app")) {
                    int i5;
                    int i6;
                    c = false;
                    int obj22 = 1;
                    if (z2) {
                        Object obj62;
                        if (i == 2) {
                            i5 = a(str, i3);
                        } else {
                            int i42;
                            if ("HLHttpDirect".equals(str) && map != null) {
                                if ("event".equals((String) map.get("B15"))) {
                                    i5 = a(str, i3);
                                }
                            }
                            i5 = -1;
                            String str32 = "";
                            if ("HLConnEvent".equals(str)) {
                                if (i3 == 0) {
                                    str32 = "report_conn_succ_denominator_value";
                                } else {
                                    if (i3 == -4 || i3 == -3 || i3 == -288) {
                                        obj62 = 1;
                                    } else {
                                        obj62 = null;
                                    }
                                    if (obj62 != null) {
                                        str32 = "report_conn_nonet_fail_denominator_value";
                                    } else {
                                        str32 = "report_conn_other_fail_denominator_value";
                                    }
                                }
                                if (i3 == 0) {
                                    i6 = 100;
                                } else {
                                    if (i3 == -4 || i3 == -3 || i3 == -288) {
                                        obj62 = 1;
                                    } else {
                                        obj62 = null;
                                    }
                                    if (obj62 != null) {
                                        i6 = 100;
                                    } else {
                                        i6 = 1;
                                    }
                                }
                                i42 = i6;
                            } else if ("HLSecurityEvent".equals(str)) {
                                str32 = i3 == 0 ? "report_security_req_succ_denominator_value" : "report_security_req_fail_denominator_value";
                                i42 = i3 == 0 ? 100 : 1;
                            } else if ("HLDisconnEvent".equals(str)) {
                                str32 = "report_disconn_denominator_value";
                                i42 = 2;
                            } else if ("HLReqRspEvent".equals(str) || "HLHttpAgent".equals(str) || "HLHttpDirect".equals(str)) {
                                if (obj22 == null || i3 != 0) {
                                    if (i3 == 0) {
                                        str32 = "report_req_succ_denominator_value";
                                    } else {
                                        if (i3 == -4 || i3 == -3 || i3 == -288) {
                                            obj62 = 1;
                                        } else {
                                            obj62 = null;
                                        }
                                        str32 = obj62 != null ? "report_req_nonet_fail_denominator_value" : "report_req_other_fail_denominator_value";
                                    }
                                    if (i3 == 0) {
                                        i6 = 100;
                                    } else {
                                        if (i3 == -4 || i3 == -3 || i3 == -288) {
                                            obj62 = 1;
                                        } else {
                                            obj62 = null;
                                        }
                                        if (obj62 != null) {
                                            i6 = 100;
                                        } else {
                                            i6 = 1;
                                        }
                                    }
                                    i42 = i6;
                                } else {
                                    str32 = "report_req_ssl_first_denominator_value";
                                    i42 = 100;
                                }
                            } else if ("HLPushEvent".equals(str)) {
                                str32 = "report_push_denominator_value";
                                i42 = 10;
                            } else if ("B_DLSDK_Result".equals(str)) {
                                str32 = "report_mass_download_denominator_value";
                                i42 = 1;
                            } else if ("HLDownTiny".equals(str)) {
                                str32 = "report_ease_download_denominator_value";
                                i42 = 10;
                            } else if ("HLHeartBeat".equals(str)) {
                                str32 = i3 == 0 ? "report_heartbeat_succ_denominator_value" : "report_heartbeat_fail_denominator_value";
                                i42 = i3 == 0 ? 10 : 5;
                            } else if ("HLReportEvent".equals(str)) {
                                i42 = 1;
                                str32 = i3 == 0 ? "platform_report_quality_succ_denominator_value" : "platform_report_quality_fail_denominator_value";
                            } else if ("HLMsgClickEvent".equals(str) || "HLMsgProcessEvent".equals(str) || "HLMsgDispatchEvent".equals(str)) {
                                i42 = 1;
                                str32 = i3 == 0 ? "report_msg_push_succ_denominator_value" : "report_msg_push_fail_denominator_value";
                            } else {
                                i5 = 0;
                                i42 = 0;
                            }
                            if (i5 == -1) {
                                i6 = w.a("report_all_events", -1, 1, 0);
                                if (i6 == 1) {
                                    i6 = 1;
                                } else if (i6 == -1) {
                                    i6 = 0;
                                } else {
                                    i6 = w.a(str32, 0, Integer.MAX_VALUE, i42);
                                }
                                i5 = i6;
                            }
                        }
                        obj62 = null;
                        if (i5 > 0 && i5 <= Integer.MAX_VALUE) {
                            obj62 = new Random().nextInt(i5) == 0 ? 1 : null;
                        }
                        obj3 = obj62;
                    } else {
                        obj3 = 1;
                        i5 = 1;
                    }
                    if (obj3 == null) {
                        boolean z32;
                        if (map == null) {
                            map = new HashMap();
                        }
                        map.put("B31", String.valueOf(i5));
                        String str42 = "B7";
                        StringBuilder stringBuilder2 = new StringBuilder();
                        if (obj4 != null) {
                            i6 = i3;
                        } else {
                            i6 = i2;
                        }
                        map.put(str42, stringBuilder2.append(i6).toString());
                        if (obj22 != null) {
                            map.put("B28", "1");
                        }
                        map.put("B1", m.g());
                        map.put("B2", m.b);
                        map.put("B30", m.e());
                        map.put("B3", String.valueOf(i));
                        CharSequence h2 = m.h();
                        if (!TextUtils.isEmpty(h2)) {
                            map.put("B4", h2);
                        }
                        map.put("B5", cd.a());
                        h2 = p.c();
                        if (!TextUtils.isEmpty(h2)) {
                            map.put("B29", h2);
                        }
                        if (w.a("access_report_detail", 0, 1, 1) == 1) {
                            if (map2 != null) {
                                map.putAll(map2);
                            }
                            map.put("B6", p.b());
                            if (!(i3 == -4 || TextUtils.isEmpty(str22))) {
                                map.put("B8", str22);
                            }
                            map.put("D1", m.c());
                            map.put("D2", m.d());
                            map.put("D3", m.c);
                        }
                        if (i2 == 0) {
                            z32 = true;
                        } else {
                            z32 = false;
                        }
                        w.a(str, z32, map);
                    }
                }
            }
        }
        obj22 = null;
        if (z2) {
            Object obj622;
            if (i == 2) {
                i5 = a(str, i3);
            } else {
                int i422;
                if ("HLHttpDirect".equals(str) && map != null) {
                    if ("event".equals((String) map.get("B15"))) {
                        i5 = a(str, i3);
                    }
                }
                i5 = -1;
                String str322 = "";
                if ("HLConnEvent".equals(str)) {
                    if (i3 == 0) {
                        str322 = "report_conn_succ_denominator_value";
                    } else {
                        if (i3 == -4 || i3 == -3 || i3 == -288) {
                            obj622 = 1;
                        } else {
                            obj622 = null;
                        }
                        if (obj622 != null) {
                            str322 = "report_conn_nonet_fail_denominator_value";
                        } else {
                            str322 = "report_conn_other_fail_denominator_value";
                        }
                    }
                    if (i3 == 0) {
                        i6 = 100;
                    } else {
                        if (i3 == -4 || i3 == -3 || i3 == -288) {
                            obj622 = 1;
                        } else {
                            obj622 = null;
                        }
                        if (obj622 != null) {
                            i6 = 100;
                        } else {
                            i6 = 1;
                        }
                    }
                    i422 = i6;
                } else if ("HLSecurityEvent".equals(str)) {
                    str322 = i3 == 0 ? "report_security_req_succ_denominator_value" : "report_security_req_fail_denominator_value";
                    i422 = i3 == 0 ? 100 : 1;
                } else if ("HLDisconnEvent".equals(str)) {
                    str322 = "report_disconn_denominator_value";
                    i422 = 2;
                } else if ("HLReqRspEvent".equals(str) || "HLHttpAgent".equals(str) || "HLHttpDirect".equals(str)) {
                    if (obj22 == null || i3 != 0) {
                        if (i3 == 0) {
                            str322 = "report_req_succ_denominator_value";
                        } else {
                            if (i3 == -4 || i3 == -3 || i3 == -288) {
                                obj622 = 1;
                            } else {
                                obj622 = null;
                            }
                            str322 = obj622 != null ? "report_req_nonet_fail_denominator_value" : "report_req_other_fail_denominator_value";
                        }
                        if (i3 == 0) {
                            i6 = 100;
                        } else {
                            if (i3 == -4 || i3 == -3 || i3 == -288) {
                                obj622 = 1;
                            } else {
                                obj622 = null;
                            }
                            if (obj622 != null) {
                                i6 = 100;
                            } else {
                                i6 = 1;
                            }
                        }
                        i422 = i6;
                    } else {
                        str322 = "report_req_ssl_first_denominator_value";
                        i422 = 100;
                    }
                } else if ("HLPushEvent".equals(str)) {
                    str322 = "report_push_denominator_value";
                    i422 = 10;
                } else if ("B_DLSDK_Result".equals(str)) {
                    str322 = "report_mass_download_denominator_value";
                    i422 = 1;
                } else if ("HLDownTiny".equals(str)) {
                    str322 = "report_ease_download_denominator_value";
                    i422 = 10;
                } else if ("HLHeartBeat".equals(str)) {
                    str322 = i3 == 0 ? "report_heartbeat_succ_denominator_value" : "report_heartbeat_fail_denominator_value";
                    i422 = i3 == 0 ? 10 : 5;
                } else if ("HLReportEvent".equals(str)) {
                    i422 = 1;
                    str322 = i3 == 0 ? "platform_report_quality_succ_denominator_value" : "platform_report_quality_fail_denominator_value";
                } else if ("HLMsgClickEvent".equals(str) || "HLMsgProcessEvent".equals(str) || "HLMsgDispatchEvent".equals(str)) {
                    i422 = 1;
                    str322 = i3 == 0 ? "report_msg_push_succ_denominator_value" : "report_msg_push_fail_denominator_value";
                } else {
                    i5 = 0;
                    i422 = 0;
                }
                if (i5 == -1) {
                    i6 = w.a("report_all_events", -1, 1, 0);
                    if (i6 == 1) {
                        i6 = 1;
                    } else if (i6 == -1) {
                        i6 = 0;
                    } else {
                        i6 = w.a(str322, 0, Integer.MAX_VALUE, i422);
                    }
                    i5 = i6;
                }
            }
            obj622 = null;
            if (i5 > 0 && i5 <= Integer.MAX_VALUE) {
                obj622 = new Random().nextInt(i5) == 0 ? 1 : null;
            }
            obj3 = obj622;
        } else {
            obj3 = 1;
            i5 = 1;
        }
        if (obj3 == null) {
            boolean z322;
            if (map == null) {
                map = new HashMap();
            }
            map.put("B31", String.valueOf(i5));
            String str422 = "B7";
            StringBuilder stringBuilder22 = new StringBuilder();
            if (obj4 != null) {
                i6 = i3;
            } else {
                i6 = i2;
            }
            map.put(str422, stringBuilder22.append(i6).toString());
            if (obj22 != null) {
                map.put("B28", "1");
            }
            map.put("B1", m.g());
            map.put("B2", m.b);
            map.put("B30", m.e());
            map.put("B3", String.valueOf(i));
            CharSequence h22 = m.h();
            if (!TextUtils.isEmpty(h22)) {
                map.put("B4", h22);
            }
            map.put("B5", cd.a());
            h22 = p.c();
            if (!TextUtils.isEmpty(h22)) {
                map.put("B29", h22);
            }
            if (w.a("access_report_detail", 0, 1, 1) == 1) {
                if (map2 != null) {
                    map.putAll(map2);
                }
                map.put("B6", p.b());
                if (!(i3 == -4 || TextUtils.isEmpty(str22))) {
                    map.put("B8", str22);
                }
                map.put("D1", m.c());
                map.put("D2", m.d());
                map.put("D3", m.c);
            }
            if (i2 == 0) {
                z322 = true;
            } else {
                z322 = false;
            }
            w.a(str, z322, map);
        }
    }
}
