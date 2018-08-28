package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class h implements b {
    private Map<String, CollectSession> dmW = new a();
    private Map<String, Set<CollectSession>> foi = new a();

    private boolean a(String str, CollectSession collectSession) {
        if (str == null || str.length() == 0 || collectSession == null) {
            return false;
        }
        Set set = (Set) this.foi.get(str);
        if (set == null) {
            set = new LinkedHashSet();
            this.foi.put(str, set);
        }
        return set.add(collectSession);
    }

    private Set<CollectSession> rD(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return (Set) this.foi.get(str);
    }

    public final void clear() {
        this.dmW.clear();
        this.foi.clear();
    }

    private CollectSession rE(String str) {
        CollectSession collectSession = (CollectSession) this.dmW.get(str);
        if (collectSession != null) {
            return collectSession;
        }
        collectSession = new CollectSession(str);
        this.dmW.put(str, collectSession);
        return collectSession;
    }

    public final void a(CollectSession collectSession) {
        String str = collectSession.id;
        CollectSession collectSession2 = (CollectSession) this.dmW.get(str);
        if (collectSession2 == null) {
            this.dmW.put(str, collectSession);
            a(collectSession.groupId, collectSession);
            return;
        }
        TimePoint timePoint = collectSession.fnY;
        if (collectSession2.fnY == null) {
            collectSession2.fnY = timePoint;
            return;
        }
        while (timePoint != null) {
            String str2 = timePoint.name;
            long j = timePoint.fok.get();
            if (!(str == null || str.length() == 0)) {
                CollectSession rE = rE(str);
                if (rE.fnY == null) {
                    rE.rt(str2);
                    rE.fnY.fok.set(j);
                } else {
                    TimePoint timePoint2 = (TimePoint) rE.foa.get(str2);
                    if (timePoint2 == null) {
                        rE.ru(str2);
                        rE.fnZ.fok.set(j);
                    } else {
                        timePoint2.fok.set((j + (timePoint2.fok.get() * ((long) timePoint2.foj.get()))) / ((long) (timePoint2.foj.get() + 1)));
                        timePoint2.foj.getAndIncrement();
                    }
                }
            }
            timePoint = (TimePoint) timePoint.fol.get();
        }
    }

    public final CollectSession aZ(String str, String str2) {
        if (str == null || str.length() == 0) {
            x.i("MicroMsg.SumCostTimeCollector", "join(%s) failed, sessionId is null or nil.", new Object[]{str2});
            return null;
        }
        CollectSession rE = rE(str);
        if (rE.fnY == null) {
            rE.rt(str2);
            return rE;
        }
        rE.ru(str2);
        return rE;
    }

    public final void c(String str, String str2, boolean z) {
        if (!z) {
            return;
        }
        if (str == null || str.length() == 0) {
            x.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", new Object[]{str2});
            return;
        }
        CollectSession rE = rE(str);
        if (rE.fnY == null) {
            rE.rt(str2);
        } else {
            rE.ru(str2);
        }
    }

    public final void c(String str, String str2, String str3, boolean z) {
        if (!z) {
            return;
        }
        if (str2 == null || str2.length() == 0) {
            x.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", new Object[]{str3});
        } else if (str == null || str.length() == 0) {
            x.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, groupId is null or nil.", new Object[]{str3});
        } else {
            CollectSession rE = rE(str2);
            if (rE.fnY == null) {
                rE.groupId = str;
                a(str, rE);
                rE.rt(str3);
                return;
            }
            rE.ru(str3);
        }
    }

    public final CollectSession rv(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return (CollectSession) this.dmW.get(str);
    }

    public final CollectSession rw(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return (CollectSession) this.dmW.remove(str);
    }

    public final void ba(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            x.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed, sessionId is null or nil.", new Object[]{str, str2});
            return;
        }
        CollectSession collectSession = (CollectSession) this.dmW.get(str);
        if (collectSession == null) {
            x.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed,", new Object[]{str, str2});
            return;
        }
        collectSession.fob = str2;
    }

    public final void print(String str) {
        CollectSession collectSession = (CollectSession) this.dmW.get(str);
        if (collectSession == null) {
            x.i("MicroMsg.SumCostTimeCollector", "print failed, session(%s) is null", new Object[]{str});
            return;
        }
        TimePoint timePoint = collectSession.fnY;
        if (timePoint == null) {
            x.i("MicroMsg.SumCostTimeCollector", "print failed, the session(%s) do not have any point.", new Object[]{str});
            return;
        }
        e.a(timePoint).insert(0, String.format("session : %s\n", new Object[]{collectSession.id}));
        x.i("MicroMsg.SumCostTimeCollector", "%s", new Object[]{r1.toString()});
    }

    public final StringBuilder rx(String str) {
        Collection rD = rD(str);
        if (rD == null || rD.isEmpty()) {
            x.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", new Object[]{str});
            return new StringBuilder().append(String.format("GroupId : %s, size : 0\n", new Object[]{str}));
        }
        Set<CollectSession> linkedHashSet = new LinkedHashSet(rD);
        TimePoint timePoint = new TimePoint();
        for (CollectSession collectSession : linkedHashSet) {
            if (collectSession.fnZ == null || !(collectSession.fob == null || collectSession.fnZ.name.equals(collectSession.fob))) {
                x.e("MicroMsg.SumCostTimeCollector", "error(%s), incorrect point count", new Object[]{collectSession.id});
            } else {
                TimePoint timePoint2 = collectSession.fnY;
                TimePoint timePoint3 = timePoint;
                while (timePoint2 != null) {
                    timePoint3.fok.set(((timePoint3.fok.get() * ((long) timePoint3.foj.get())) + timePoint2.fok.get()) / ((long) timePoint3.foj.incrementAndGet()));
                    timePoint3.name = timePoint2.name;
                    timePoint2 = (TimePoint) timePoint2.fol.get();
                    if (timePoint3.fol.get() == null && timePoint2 != null) {
                        timePoint3.fol.set(new TimePoint());
                    }
                    timePoint3 = (TimePoint) timePoint3.fol.get();
                }
            }
        }
        StringBuilder a = e.a(timePoint);
        a.insert(0, String.format("GroupId : %s, size : %d\n", new Object[]{str, Integer.valueOf(linkedHashSet.size())}));
        return a;
    }

    public final int bb(String str, String str2) {
        Collection rD = rD(str);
        if (rD == null || rD.isEmpty()) {
            x.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", new Object[]{str});
            return 0;
        }
        int i = 0;
        int i2 = 0;
        for (CollectSession collectSession : new LinkedHashSet(rD)) {
            int i3 = collectSession.bQf.getInt(str2);
            if (i3 != 0) {
                i2 += i3;
                i++;
            }
        }
        if (i != 0) {
            return i2 / i;
        }
        return 0;
    }
}
