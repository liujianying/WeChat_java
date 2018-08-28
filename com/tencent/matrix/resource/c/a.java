package com.tencent.matrix.resource.c;

import com.tencent.tinker.d.a.f;
import com.tencent.tinker.d.a.g;
import com.tencent.tinker.d.a.h;
import com.tencent.tinker.d.a.i;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.zip.CRC32;

public final class a {
    final Map<com.tencent.matrix.resource.c.a.b, byte[]> brA = new HashMap();
    final Map<com.tencent.matrix.resource.c.a.b, com.tencent.matrix.resource.c.a.b> brB = new HashMap();
    final Set<com.tencent.matrix.resource.c.a.b> brC = new HashSet();
    com.tencent.matrix.resource.c.a.b brD = null;
    com.tencent.matrix.resource.c.a.b brE = null;
    com.tencent.matrix.resource.c.a.b brF = null;
    com.tencent.matrix.resource.c.a.b brG = null;
    com.tencent.matrix.resource.c.a.b brH = null;
    com.tencent.matrix.resource.c.a.b brI = null;
    com.tencent.matrix.resource.c.a.b brJ = null;
    int brK = 0;
    com.tencent.matrix.resource.c.a.b brL = null;
    com.tencent.matrix.resource.c.a.a[] brM = null;
    com.tencent.matrix.resource.c.a.a[] brN = null;
    final Set<com.tencent.matrix.resource.c.a.b> brz = new HashSet();

    private class a extends d {
        public a(e eVar) {
            super(eVar);
        }

        public final b a(int i, int i2, long j) {
            return new b(super.a(i, i2, j)) {
                public final void a(com.tencent.matrix.resource.c.a.b bVar, int i, com.tencent.matrix.resource.c.a.b bVar2, byte[] bArr) {
                    try {
                        if (bVar2.equals(a.this.brE)) {
                            com.tencent.matrix.resource.c.a.b bVar3;
                            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            com.tencent.matrix.resource.c.a.a[] aVarArr = a.this.brM;
                            int length = aVarArr.length;
                            int i2 = 0;
                            int i3 = 0;
                            while (i2 < length) {
                                com.tencent.matrix.resource.c.a.a aVar = aVarArr[i2];
                                com.tencent.matrix.resource.c.a.b bVar4 = aVar.bsb;
                                com.tencent.matrix.resource.c.a.c en = com.tencent.matrix.resource.c.a.c.en(aVar.bsa);
                                if (a.this.brF.equals(bVar4)) {
                                    bVar3 = (com.tencent.matrix.resource.c.a.b) com.tencent.matrix.resource.c.b.a.a(byteArrayInputStream, en, a.this.brK);
                                    break;
                                } else {
                                    i2++;
                                    i3 = com.tencent.matrix.resource.c.b.a.b(byteArrayInputStream, en, a.this.brK) + i3;
                                }
                            }
                            bVar3 = null;
                            if (bVar3 != null) {
                                com.tencent.matrix.resource.c.a.b bVar5 = (com.tencent.matrix.resource.c.a.b) a.this.brB.get(bVar3);
                                if (!(bVar5 == null || bVar3.equals(bVar5) || bVar3.equals(a.this.brL))) {
                                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                                    wrap.position(i3);
                                    wrap.put(bVar5.bsd);
                                }
                            }
                        }
                        super.a(bVar, i, bVar2, bArr);
                    } catch (Throwable th) {
                        RuntimeException runtimeException = new RuntimeException(th);
                    }
                }

                public final void a(int i, com.tencent.matrix.resource.c.a.b bVar, int i2, int i3, int i4, byte[] bArr) {
                    com.tencent.matrix.resource.c.a.b bVar2 = (com.tencent.matrix.resource.c.a.b) a.this.brB.get(bVar);
                    if ((bVar2 != null && bVar.equals(bVar2)) || a.this.brC.contains(bVar)) {
                        super.a(i, bVar, i2, i3, i4, bArr);
                    }
                }
            };
        }
    }

    private class b extends d {
        public b() {
            super(null);
        }

        public final void a(String str, int i, long j) {
            a.this.brK = i;
            a.this.brL = new com.tencent.matrix.resource.c.a.b(new byte[i]);
        }

        public final void a(com.tencent.matrix.resource.c.a.b bVar, String str, int i, long j) {
            if (a.this.brD == null && "android.graphics.Bitmap".equals(str)) {
                a.this.brD = bVar;
            } else if (a.this.brF == null && "mBuffer".equals(str)) {
                a.this.brF = bVar;
            } else if (a.this.brG == null && "mRecycled".equals(str)) {
                a.this.brG = bVar;
            } else if (a.this.brH == null && "java.lang.String".equals(str)) {
                a.this.brH = bVar;
            } else if (a.this.brJ == null && "value".equals(str)) {
                a.this.brJ = bVar;
            }
        }

        public final void a(int i, com.tencent.matrix.resource.c.a.b bVar, int i2, com.tencent.matrix.resource.c.a.b bVar2, int i3, long j) {
            if (a.this.brE == null && a.this.brD != null && a.this.brD.equals(bVar2)) {
                a.this.brE = bVar;
            } else if (a.this.brI == null && a.this.brH != null && a.this.brH.equals(bVar2)) {
                a.this.brI = bVar;
            }
        }

        public final b a(int i, int i2, long j) {
            return new b() {
                public final void a(com.tencent.matrix.resource.c.a.b bVar, int i, com.tencent.matrix.resource.c.a.b bVar2, com.tencent.matrix.resource.c.a.b bVar3, int i2, com.tencent.matrix.resource.c.a.a[] aVarArr, com.tencent.matrix.resource.c.a.a[] aVarArr2) {
                    if (a.this.brM == null && a.this.brE != null && a.this.brE.equals(bVar)) {
                        a.this.brM = aVarArr2;
                    } else if (a.this.brN == null && a.this.brI != null && a.this.brI.equals(bVar)) {
                        a.this.brN = aVarArr2;
                    }
                }
            };
        }
    }

    private class c extends d {
        public c() {
            super(null);
        }

        public final b a(int i, int i2, long j) {
            return new b() {
                public final void a(com.tencent.matrix.resource.c.a.b bVar, int i, com.tencent.matrix.resource.c.a.b bVar2, byte[] bArr) {
                    com.tencent.matrix.resource.c.a.b bVar3 = null;
                    Object obj = null;
                    try {
                        if (a.this.brE != null && a.this.brE.equals(bVar2)) {
                            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            Boolean bool = null;
                            com.tencent.matrix.resource.c.a.b bVar4 = null;
                            for (com.tencent.matrix.resource.c.a.a aVar : a.this.brM) {
                                com.tencent.matrix.resource.c.a.b bVar5 = aVar.bsb;
                                com.tencent.matrix.resource.c.a.c en = com.tencent.matrix.resource.c.a.c.en(aVar.bsa);
                                if (a.this.brF.equals(bVar5)) {
                                    bVar4 = (com.tencent.matrix.resource.c.a.b) com.tencent.matrix.resource.c.b.a.a(byteArrayInputStream, en, a.this.brK);
                                } else if (a.this.brG.equals(bVar5)) {
                                    bool = (Boolean) com.tencent.matrix.resource.c.b.a.a(byteArrayInputStream, en, a.this.brK);
                                } else if (bVar4 == null || bool == null) {
                                    com.tencent.matrix.resource.c.b.a.b(byteArrayInputStream, en, a.this.brK);
                                }
                            }
                            byteArrayInputStream.close();
                            if (bool == null || !bool.booleanValue()) {
                                obj = 1;
                            }
                            if (bVar4 != null && obj != null && !bVar4.equals(a.this.brL)) {
                                a.this.brz.add(bVar4);
                            }
                        } else if (a.this.brI != null && a.this.brI.equals(bVar2)) {
                            InputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                            for (com.tencent.matrix.resource.c.a.a aVar2 : a.this.brN) {
                                com.tencent.matrix.resource.c.a.b bVar6 = aVar2.bsb;
                                com.tencent.matrix.resource.c.a.c en2 = com.tencent.matrix.resource.c.a.c.en(aVar2.bsa);
                                if (!a.this.brJ.equals(bVar6)) {
                                    if (bVar3 != null) {
                                        break;
                                    }
                                    com.tencent.matrix.resource.c.b.a.b(byteArrayInputStream2, en2, a.this.brK);
                                } else {
                                    bVar3 = (com.tencent.matrix.resource.c.a.b) com.tencent.matrix.resource.c.b.a.a(byteArrayInputStream2, en2, a.this.brK);
                                }
                            }
                            byteArrayInputStream2.close();
                            if (bVar3 != null && !bVar3.equals(a.this.brL)) {
                                a.this.brC.add(bVar3);
                            }
                        }
                    } catch (Throwable th) {
                        RuntimeException runtimeException = new RuntimeException(th);
                    }
                }

                public final void a(int i, com.tencent.matrix.resource.c.a.b bVar, int i2, int i3, int i4, byte[] bArr) {
                    a.this.brA.put(bVar, bArr);
                }
            };
        }

        public final void tz() {
            Set<Entry> entrySet = a.this.brA.entrySet();
            Map hashMap = new HashMap();
            for (Entry entry : entrySet) {
                com.tencent.matrix.resource.c.a.b bVar = (com.tencent.matrix.resource.c.a.b) entry.getKey();
                byte[] bArr = (byte[]) entry.getValue();
                if (a.this.brz.contains(bVar)) {
                    String t = com.tencent.matrix.resource.a.a.a.t(bArr);
                    com.tencent.matrix.resource.c.a.b bVar2 = (com.tencent.matrix.resource.c.a.b) hashMap.get(t);
                    if (bVar2 == null) {
                        hashMap.put(t, bVar);
                    } else {
                        a.this.brB.put(bVar2, bVar2);
                        a.this.brB.put(bVar, bVar2);
                    }
                }
            }
            a.this.brA.clear();
        }
    }

    public static boolean a(File file, Properties properties) {
        Object e;
        Closeable closeable;
        Throwable th;
        if (!file.exists()) {
            return false;
        }
        if (properties.isEmpty()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file2 = new File(file.getParentFile(), "extra.info");
        File file3 = new File(file.getAbsolutePath() + "_temp");
        try {
            Closeable bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2, false));
            try {
                properties.store(bufferedOutputStream, null);
                com.tencent.matrix.d.c.b(bufferedOutputStream);
                Closeable hVar;
                try {
                    hVar = new h(new BufferedOutputStream(new FileOutputStream(file3)));
                    try {
                        bufferedOutputStream = new g(file);
                        try {
                            Enumeration entries = bufferedOutputStream.entries();
                            while (entries.hasMoreElements()) {
                                f fVar = (f) entries.nextElement();
                                if (fVar == null) {
                                    throw new RuntimeException("zipEntry is null when get from oldApk");
                                } else if (!fVar.name.contains("../")) {
                                    i.a((g) bufferedOutputStream, fVar, (h) hVar);
                                }
                            }
                            Long i = i(file2);
                            if (i == null) {
                                com.tencent.matrix.d.b.e("Matrix.HprofBufferShrinker", "new crc is null", new Object[0]);
                                com.tencent.matrix.d.c.b(bufferedOutputStream);
                                com.tencent.matrix.d.c.b(hVar);
                                file2.delete();
                                return false;
                            }
                            i.a(new f(file2.getName()), file2, i.longValue(), hVar);
                            com.tencent.matrix.d.c.b(bufferedOutputStream);
                            com.tencent.matrix.d.c.b(hVar);
                            file2.delete();
                            file.delete();
                            if (file3.renameTo(file)) {
                                com.tencent.matrix.d.b.i("Matrix.HprofBufferShrinker", "addExtraInfo end, path: %s, cost time: %d", file.getAbsolutePath(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                return true;
                            }
                            com.tencent.matrix.d.b.e("Matrix.HprofBufferShrinker", "rename error", new Object[0]);
                            return false;
                        } catch (IOException e2) {
                            e = e2;
                            closeable = bufferedOutputStream;
                            try {
                                com.tencent.matrix.d.b.e("Matrix.HprofBufferShrinker", "zip property error:" + e, new Object[0]);
                                com.tencent.matrix.d.c.b(closeable);
                                com.tencent.matrix.d.c.b(hVar);
                                file2.delete();
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedOutputStream = closeable;
                                com.tencent.matrix.d.c.b(bufferedOutputStream);
                                com.tencent.matrix.d.c.b(hVar);
                                file2.delete();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            com.tencent.matrix.d.c.b(bufferedOutputStream);
                            com.tencent.matrix.d.c.b(hVar);
                            file2.delete();
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        closeable = null;
                        com.tencent.matrix.d.b.e("Matrix.HprofBufferShrinker", "zip property error:" + e, new Object[0]);
                        com.tencent.matrix.d.c.b(closeable);
                        com.tencent.matrix.d.c.b(hVar);
                        file2.delete();
                        return false;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream = null;
                        com.tencent.matrix.d.c.b(bufferedOutputStream);
                        com.tencent.matrix.d.c.b(hVar);
                        file2.delete();
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    closeable = null;
                    hVar = null;
                    com.tencent.matrix.d.b.e("Matrix.HprofBufferShrinker", "zip property error:" + e, new Object[0]);
                    com.tencent.matrix.d.c.b(closeable);
                    com.tencent.matrix.d.c.b(hVar);
                    file2.delete();
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = null;
                    hVar = null;
                    com.tencent.matrix.d.c.b(bufferedOutputStream);
                    com.tencent.matrix.d.c.b(hVar);
                    file2.delete();
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                closeable = bufferedOutputStream;
                com.tencent.matrix.d.c.b(closeable);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            closeable = null;
            com.tencent.matrix.d.c.b(closeable);
            throw th;
        }
    }

    private static Long i(File file) {
        Throwable th;
        Closeable closeable;
        Long l = null;
        CRC32 crc32 = new CRC32();
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    crc32.update(bArr, 0, read);
                }
                l = Long.valueOf(crc32.getValue());
                com.tencent.matrix.d.c.b(fileInputStream);
            } catch (IOException e) {
                com.tencent.matrix.d.c.b(fileInputStream);
                return l;
            } catch (Throwable th2) {
                th = th2;
                closeable = fileInputStream;
                com.tencent.matrix.d.c.b(closeable);
                throw th;
            }
        } catch (IOException e2) {
            Object fileInputStream2 = l;
            com.tencent.matrix.d.c.b(fileInputStream2);
            return l;
        } catch (Throwable th3) {
            th = th3;
            closeable = l;
            com.tencent.matrix.d.c.b(closeable);
            throw th;
        }
        return l;
    }
}
