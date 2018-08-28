package com.google.android.gms.tagmanager;

import com.tencent.mm.plugin.appbrand.s$l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c {
    public static final Object bbl = new Object();
    static final String[] bbm = "gtm.lifetime".toString().split("\\.");
    private static final Pattern bbn = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<b, Integer> bbo;
    private final Map<String, Object> bbp;
    private final ReentrantLock bbq;
    private final LinkedList<Map<String, Object>> bbr;
    private final c bbs;
    private final CountDownLatch bbt;

    c() {
        this(new 1());
    }

    c(c cVar) {
        this.bbs = cVar;
        this.bbo = new ConcurrentHashMap();
        this.bbp = new HashMap();
        this.bbq = new ReentrantLock();
        this.bbr = new LinkedList();
        this.bbt = new CountDownLatch(1);
        this.bbs.a(new 2(this));
    }

    private void a(Map<String, Object> map, String str, Collection<a> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                a((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new a(str2, entry.getValue()));
            }
        }
    }

    private void b(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                Object obj = list.get(i2);
                if (obj instanceof List) {
                    if (!(list2.get(i2) instanceof List)) {
                        list2.set(i2, new ArrayList());
                    }
                    b((List) obj, (List) list2.get(i2));
                } else if (obj instanceof Map) {
                    if (!(list2.get(i2) instanceof Map)) {
                        list2.set(i2, new HashMap());
                    }
                    b((Map) obj, (Map) list2.get(i2));
                } else if (obj != bbl) {
                    list2.set(i2, obj);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void b(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                b((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                b((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    private static Long bw(String str) {
        Matcher matcher = bbn.matcher(str);
        if (matcher.matches()) {
            long parseLong;
            try {
                parseLong = Long.parseLong(matcher.group(1));
            } catch (NumberFormatException e) {
                parseLong = 0;
                m.rd();
            }
            if (parseLong <= 0) {
                m.re();
                return null;
            }
            String group = matcher.group(2);
            if (group.length() == 0) {
                return Long.valueOf(parseLong);
            }
            switch (group.charAt(0)) {
                case s$l.AppCompatTheme_buttonStyle /*100*/:
                    return Long.valueOf((((parseLong * 1000) * 60) * 60) * 24);
                case 'h':
                    return Long.valueOf(((parseLong * 1000) * 60) * 60);
                case s$l.AppCompatTheme_seekBarStyle /*109*/:
                    return Long.valueOf((parseLong * 1000) * 60);
                case 's':
                    return Long.valueOf(parseLong * 1000);
                default:
                    m.rd();
                    return null;
            }
        }
        m.re();
        return null;
    }

    private void e(Map<String, Object> map) {
        this.bbq.lock();
        try {
            this.bbr.offer(map);
            if (this.bbq.getHoldCount() == 1) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    Map map2 = (Map) this.bbr.poll();
                    if (map2 == null) {
                        break;
                    }
                    synchronized (this.bbp) {
                        for (String str : map2.keySet()) {
                            b(k(str, map2.get(str)), this.bbp);
                        }
                    }
                    for (b g : this.bbo.keySet()) {
                        g.g(map2);
                    }
                    i = i2 + 1;
                    if (i > 500) {
                        this.bbr.clear();
                        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                    }
                }
            }
            Object f = f(map);
            Long bw = f == null ? null : bw(f.toString());
            if (bw != null) {
                List arrayList = new ArrayList();
                a(map, "", arrayList);
                arrayList.remove("gtm.lifetime");
                this.bbs.a(arrayList, bw.longValue());
            }
            this.bbq.unlock();
        } catch (Throwable th) {
            this.bbq.unlock();
        }
    }

    private static Object f(Map<String, Object> map) {
        Object obj = map;
        for (Object obj2 : bbm) {
            if (!(obj instanceof Map)) {
                return null;
            }
            obj = ((Map) obj).get(obj2);
        }
        return obj;
    }

    static Map<String, Object> k(String str, Object obj) {
        Map hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object map2 = hashMap2;
        }
        map2.put(split[split.length - 1], obj);
        return hashMap;
    }

    final void a(b bVar) {
        this.bbo.put(bVar, Integer.valueOf(0));
    }

    public final void d(Map<String, Object> map) {
        try {
            this.bbt.await();
        } catch (InterruptedException e) {
            m.rd();
        }
        e(map);
    }

    public final String toString() {
        String stringBuilder;
        synchronized (this.bbp) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : this.bbp.entrySet()) {
                stringBuilder2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{entry.getKey(), entry.getValue()}));
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }
}
