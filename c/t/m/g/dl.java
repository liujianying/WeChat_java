package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import java.util.LinkedList;
import java.util.ListIterator;

public final class dl {
    private int a = 10;
    private int b = 4;
    private LinkedList<a> c = new LinkedList();
    private db d = new db();

    public final synchronized void a() {
        this.c.clear();
        this.d.a();
    }

    public final synchronized void a(TencentLocation tencentLocation) {
        this.c.add(a.a(tencentLocation));
        if (this.c.size() > this.a) {
            this.c.removeFirst();
        }
    }

    public final synchronized void a(eb ebVar) {
        if (!ebVar.getProvider().equalsIgnoreCase("gps") || cn.a().d("gps_kalman")) {
            if (this.c != null && (this.c == null || this.c.size() != 0)) {
                double d;
                db dbVar = this.d;
                double latitude = ebVar.getLatitude();
                double longitude = ebVar.getLongitude();
                double accuracy = (double) ebVar.getAccuracy();
                long time = ebVar.getTime();
                if (accuracy < 1.0d) {
                    d = 1.0d;
                } else {
                    d = accuracy;
                }
                new StringBuilder("lat_me:").append(latitude).append(",lng_me:").append(longitude).append(",accuracy:").append(d).append(",time:").append(time).append(",lat:").append(dbVar.d).append(",lng:").append(dbVar.e);
                if (time - dbVar.c >= 20000) {
                    dbVar.a();
                    new StringBuilder("Time:").append(time).append(",last_time:").append(dbVar.c);
                }
                dbVar.a = (float) (Math.abs(latitude - dbVar.d) * 1000000.0d);
                dbVar.b = (float) (Math.abs(longitude - dbVar.e) * 1000000.0d);
                new StringBuilder("Q:").append(dbVar.a).append(",QLng:").append(dbVar.b);
                if (dbVar.f < 0.0d) {
                    dbVar.c = time;
                    dbVar.d = latitude;
                    dbVar.e = longitude;
                    dbVar.f = d * d;
                } else {
                    long j = time - dbVar.c;
                    if (j < 1000) {
                        j = 1000;
                    }
                    if (j > 0) {
                        dbVar.f += (double) j;
                        dbVar.g += (double) j;
                    }
                    double d2 = dbVar.f / ((dbVar.f + (d * d)) + ((double) (dbVar.a * 5.0f)));
                    double d3 = dbVar.g / ((dbVar.g + (d * d)) + ((double) (dbVar.b * 5.0f)));
                    new StringBuilder("K:").append(d2).append(",KLng:").append(d3);
                    if (d2 < 0.4d || d3 < 0.4d) {
                        if ((dbVar.h > 0.0d && latitude - dbVar.d > 0.0d) || (dbVar.h < 0.0d && latitude - dbVar.d < 0.0d)) {
                            dbVar.d += dbVar.h * ((double) (j / 1000));
                        }
                        if ((dbVar.i > 0.0d && longitude - dbVar.e > 0.0d) || (dbVar.i < 0.0d && longitude - dbVar.e < 0.0d)) {
                            dbVar.e += dbVar.i * ((double) (j / 1000));
                        }
                        dbVar.f -= (double) j;
                        dbVar.g -= (double) j;
                    } else {
                        double d4 = dbVar.d;
                        if ((dbVar.h > 0.0d && latitude - dbVar.d > 0.0d) || (dbVar.h < 0.0d && latitude - dbVar.d < 0.0d)) {
                            dbVar.d += dbVar.h * ((double) (j / 1000));
                        }
                        dbVar.d += (latitude - dbVar.d) * d2;
                        new StringBuilder("lat:").append(dbVar.d).append(",tmp:").append(d4).append(",timeInc:").append(j);
                        dbVar.h = (dbVar.d - d4) / ((double) (j / 1000));
                        d4 = dbVar.e;
                        if ((dbVar.i > 0.0d && longitude - dbVar.e > 0.0d) || (dbVar.i < 0.0d && longitude - dbVar.e < 0.0d)) {
                            dbVar.e += dbVar.i * ((double) (j / 1000));
                        }
                        dbVar.e += (longitude - dbVar.e) * d3;
                        new StringBuilder("lng:").append(dbVar.e).append(",tmp:").append(d4).append(",timeInc:").append(j);
                        dbVar.i = (dbVar.e - d4) / ((double) (j / 1000));
                        dbVar.f = (1.0d - d2) * dbVar.f;
                        dbVar.g = (1.0d - d3) * dbVar.g;
                        dbVar.c = time;
                        new StringBuilder("last_metres_per_second:").append(dbVar.h).append(",last_metres_per_second_lng:").append(dbVar.i);
                    }
                    new StringBuilder("variance:").append(dbVar.f).append(",vaLng:").append(dbVar.g);
                    if (d == 30.0d && d2 >= 0.5d && d3 >= 0.5d) {
                        dbVar.d = latitude;
                        dbVar.e = longitude;
                        dbVar.h = 0.0d;
                        dbVar.i = 0.0d;
                        dbVar.c = time;
                        dbVar.f = d * d;
                    }
                }
                accuracy = this.d.d;
                d = this.d.e;
                ebVar.b.a = ((double) Math.round(accuracy * 1000000.0d)) / 1000000.0d;
                ebVar.b.b = ((double) Math.round(d * 1000000.0d)) / 1000000.0d;
            }
        }
    }

    public final synchronized boolean a(TencentLocation tencentLocation, ct ctVar, boolean z) {
        return a(a.a(tencentLocation), ctVar, z);
    }

    private synchronized boolean a(a aVar, ct ctVar, boolean z) {
        boolean z2;
        if (ctVar != null) {
            if (!(this.c == null || this.c.size() == 0)) {
                if (aVar.d == 3) {
                    z2 = true;
                } else if (aVar.d == 1 && !ej.a(ctVar) && !ej.b(ctVar) && !z) {
                    z2 = true;
                } else if (aVar.c - ((a) this.c.getLast()).c > 120000) {
                    this.c.clear();
                    z2 = true;
                } else {
                    Object obj;
                    if (this.c.size() >= this.b) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        int i = 0;
                        ListIterator listIterator = this.c.listIterator(this.c.size());
                        while (true) {
                            int i2 = i;
                            if (!listIterator.hasPrevious()) {
                                i = 0;
                                break;
                            }
                            a aVar2 = (a) listIterator.previous();
                            if (ei.a(aVar2.a, aVar2.b, aVar.a, aVar.b) / (((double) (Math.abs(aVar2.c - aVar.c) + 1)) / 1000.0d) > 100.0d) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            if (obj == null) {
                                i = 0 + 1;
                            } else {
                                i = 0;
                            }
                            int i3 = i2 + 1;
                            if (i3 > this.b) {
                                break;
                            }
                            i2 = i3;
                        }
                        if (i > 1) {
                            z2 = false;
                        }
                    }
                    z2 = true;
                }
            }
        }
        z2 = true;
        return z2;
    }
}
