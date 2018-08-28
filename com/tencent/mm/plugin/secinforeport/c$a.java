package com.tencent.mm.plugin.secinforeport;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.sdk.platformtools.x;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class c$a {
    private static final Map<Integer, Long> mOs = new HashMap();

    private static synchronized void kS() {
        Exception e;
        Throwable th;
        synchronized (c$a.class) {
            DataInputStream dataInputStream;
            try {
                dataInputStream = new DataInputStream(new FileInputStream(new File(g.Ei().cachePath, b.lFJ.IO("!#?'8/f((6(1$\u001f2*>(s826"))));
                try {
                    if (dataInputStream.readShort() != (short) -774) {
                        throw new IllegalStateException("bad magic.");
                    }
                    dataInputStream.readShort();
                    int readInt = dataInputStream.readInt();
                    if (readInt < 0) {
                        throw new IllegalStateException("bad pair count.");
                    }
                    for (int i = 0; i < readInt; i++) {
                        mOs.put(Integer.valueOf(dataInputStream.readInt()), Long.valueOf(dataInputStream.readLong()));
                    }
                    x.i("MicroMsg.SecInfoReporterImpl", "normsg stat load done.");
                    try {
                        dataInputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.e("MicroMsg.SecInfoReporterImpl", "normsg stat load failed, use default.", new Object[]{e});
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                dataInputStream = null;
                x.e("MicroMsg.SecInfoReporterImpl", "normsg stat load failed, use default.", new Object[]{e});
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (Exception e42) {
                    }
                }
                return;
            } catch (Throwable th3) {
                th = th3;
                dataInputStream = null;
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (Exception e52) {
                    }
                }
                throw th;
            }
        }
        return;
    }

    private static synchronized void save() {
        Throwable th;
        synchronized (c$a.class) {
            File file = new File(g.Ei().cachePath, b.lFJ.IO("!#?'8/f((6(1$\u001f2*>(s826"));
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            DataOutputStream dataOutputStream = null;
            DataOutputStream dataOutputStream2;
            try {
                dataOutputStream2 = new DataOutputStream(new FileOutputStream(file));
                try {
                    dataOutputStream2.writeShort(-774);
                    dataOutputStream2.writeShort(1);
                    dataOutputStream2.writeInt(mOs.size());
                    for (Entry entry : mOs.entrySet()) {
                        dataOutputStream2.writeInt(((Integer) entry.getKey()).intValue());
                        dataOutputStream2.writeLong(((Long) entry.getValue()).longValue());
                    }
                    x.i("MicroMsg.SecInfoReporterImpl", "normsg stat save done.");
                    try {
                        dataOutputStream2.close();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    dataOutputStream = dataOutputStream2;
                    try {
                        x.e("MicroMsg.SecInfoReporterImpl", "normsg stat save failed.");
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        dataOutputStream2 = dataOutputStream;
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (Exception e42) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                x.e("MicroMsg.SecInfoReporterImpl", "normsg stat save failed.");
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (Exception e32) {
                    }
                }
                return;
            } catch (Throwable th4) {
                th = th4;
                dataOutputStream2 = null;
                if (dataOutputStream2 != null) {
                    try {
                        dataOutputStream2.close();
                    } catch (Exception e422) {
                    }
                }
                throw th;
            }
        }
        return;
    }

    static synchronized boolean H(int i, long j) {
        boolean z;
        synchronized (c$a.class) {
            if (j < 0) {
                x.w("MicroMsg.SecInfoReporterImpl", "bad interval: %s", new Object[]{Long.valueOf(j)});
                z = false;
            } else {
                if (!mOs.containsKey(Integer.valueOf(i))) {
                    kS();
                }
                Long l = (Long) mOs.get(Integer.valueOf(i));
                long currentTimeMillis = System.currentTimeMillis();
                if (l == null || currentTimeMillis < l.longValue()) {
                    mOs.put(Integer.valueOf(i), Long.valueOf(0));
                    save();
                    z = false;
                } else if (currentTimeMillis - l.longValue() > j) {
                    mOs.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
                    save();
                    z = true;
                } else {
                    z = false;
                }
            }
        }
        return z;
    }
}
