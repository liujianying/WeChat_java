package com.tencent.matrix.resource.c;

import com.tencent.matrix.resource.c.a.b;
import com.tencent.matrix.resource.c.a.c;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class e extends d {
    int brK = 0;
    final OutputStream brV;
    final ByteArrayOutputStream brW = new ByteArrayOutputStream();

    private class a extends b {
        private final int brX;
        private final long brY;
        private final int mTag;

        a(int i, int i2, long j) {
            super(null);
            this.mTag = i;
            this.brX = i2;
            this.brY = j;
        }

        public final void a(int i, b bVar) {
            try {
                e.this.brW.write(254);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i);
                e.this.brW.write(bVar.bsd);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void b(int i, b bVar) {
            try {
                e.this.brW.write(i);
                e.this.brW.write(bVar.bsd);
                if (i == 1) {
                    com.tencent.matrix.resource.c.b.a.b(e.this.brW, (long) e.this.brK);
                }
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void a(b bVar, int i, int i2) {
            try {
                e.this.brW.write(2);
                e.this.brW.write(bVar.bsd);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i2);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void b(b bVar, int i, int i2) {
            try {
                e.this.brW.write(3);
                e.this.brW.write(bVar.bsd);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i2);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void a(b bVar, int i) {
            try {
                e.this.brW.write(4);
                e.this.brW.write(bVar.bsd);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void b(b bVar, int i) {
            try {
                e.this.brW.write(6);
                e.this.brW.write(bVar.bsd);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void c(b bVar, int i, int i2) {
            try {
                e.this.brW.write(8);
                e.this.brW.write(bVar.bsd);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i2);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void a(b bVar, int i, b bVar2, b bVar3, int i2, com.tencent.matrix.resource.c.a.a[] aVarArr, com.tencent.matrix.resource.c.a.a[] aVarArr2) {
            try {
                e.this.brW.write(32);
                e.this.brW.write(bVar.bsd);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i);
                e.this.brW.write(bVar2.bsd);
                e.this.brW.write(bVar3.bsd);
                com.tencent.matrix.resource.c.b.a.b(e.this.brW, (long) (e.this.brK << 2));
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i2);
                com.tencent.matrix.resource.c.b.a.b(e.this.brW, 0);
                com.tencent.matrix.resource.c.b.a.b(e.this.brW, aVarArr.length);
                for (com.tencent.matrix.resource.c.a.a aVar : aVarArr) {
                    com.tencent.matrix.resource.c.b.a.a(e.this.brW, aVar.bsb);
                    e.this.brW.write(aVar.bsa);
                    OutputStream outputStream = e.this.brW;
                    Object obj = aVar.bsc;
                    if (obj == null) {
                        throw new IllegalArgumentException("value is null.");
                    }
                    if (obj instanceof b) {
                        com.tencent.matrix.resource.c.b.a.a(outputStream, (b) obj);
                    } else if ((obj instanceof Boolean) || Boolean.TYPE.isAssignableFrom(obj.getClass())) {
                        outputStream.write(((Boolean) obj).booleanValue() ? 1 : 0);
                    } else if ((obj instanceof Character) || Character.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.b(outputStream, ((Character) obj).charValue());
                    } else if ((obj instanceof Float) || Float.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.c(outputStream, Float.floatToRawIntBits(((Float) obj).floatValue()));
                    } else if ((obj instanceof Double) || Double.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.a(outputStream, Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                    } else if ((obj instanceof Byte) || Byte.TYPE.isAssignableFrom(obj.getClass())) {
                        outputStream.write(((Byte) obj).byteValue());
                    } else if ((obj instanceof Short) || Short.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.b(outputStream, ((Short) obj).shortValue());
                    } else if ((obj instanceof Integer) || Integer.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.c(outputStream, ((Integer) obj).intValue());
                    } else if ((obj instanceof Long) || Long.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.a(outputStream, ((Long) obj).longValue());
                    } else {
                        throw new IllegalArgumentException("bad value type: " + obj.getClass().getName());
                    }
                }
                com.tencent.matrix.resource.c.b.a.b(e.this.brW, aVarArr2.length);
                for (com.tencent.matrix.resource.c.a.a aVar2 : aVarArr2) {
                    com.tencent.matrix.resource.c.b.a.a(e.this.brW, aVar2.bsb);
                    e.this.brW.write(aVar2.bsa);
                }
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void a(b bVar, int i, b bVar2, byte[] bArr) {
            try {
                e.this.brW.write(33);
                e.this.brW.write(bVar.bsd);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i);
                e.this.brW.write(bVar2.bsd);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, bArr.length);
                e.this.brW.write(bArr);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void a(b bVar, int i, int i2, b bVar2, byte[] bArr) {
            try {
                e.this.brW.write(34);
                e.this.brW.write(bVar.bsd);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i2);
                e.this.brW.write(bVar2.bsd);
                e.this.brW.write(bArr, 0, e.this.brK * i2);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void a(int i, b bVar, int i2, int i3, int i4, byte[] bArr) {
            try {
                e.this.brW.write(i);
                e.this.brW.write(bVar.bsd);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i2);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i3);
                e.this.brW.write(i4);
                e.this.brW.write(bArr, 0, c.en(i4).getSize(e.this.brK) * i3);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void d(b bVar, int i, int i2) {
            try {
                e.this.brW.write(142);
                e.this.brW.write(bVar.bsd);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i);
                com.tencent.matrix.resource.c.b.a.c(e.this.brW, i2);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void tz() {
            try {
                e.this.brV.write(this.mTag);
                com.tencent.matrix.resource.c.b.a.c(e.this.brV, this.brX);
                com.tencent.matrix.resource.c.b.a.c(e.this.brV, e.this.brW.size());
                e.this.brV.write(e.this.brW.toByteArray());
                e.this.brW.reset();
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }
    }

    public e(OutputStream outputStream) {
        super(null);
        this.brV = outputStream;
    }

    public final void a(String str, int i, long j) {
        try {
            this.brK = i;
            OutputStream outputStream = this.brV;
            outputStream.write(str.getBytes(Charset.forName("UTF-8")));
            outputStream.write(0);
            com.tencent.matrix.resource.c.b.a.c(this.brV, i);
            com.tencent.matrix.resource.c.b.a.a(this.brV, j);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    public final void a(b bVar, String str, int i, long j) {
        try {
            this.brV.write(1);
            com.tencent.matrix.resource.c.b.a.c(this.brV, i);
            com.tencent.matrix.resource.c.b.a.c(this.brV, (int) j);
            this.brV.write(bVar.bsd);
            this.brV.write(str.getBytes(Charset.forName("UTF-8")), 0, str.length());
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    public final void a(int i, b bVar, int i2, b bVar2, int i3, long j) {
        try {
            this.brV.write(2);
            com.tencent.matrix.resource.c.b.a.c(this.brV, i3);
            com.tencent.matrix.resource.c.b.a.c(this.brV, (int) j);
            com.tencent.matrix.resource.c.b.a.c(this.brV, i);
            this.brV.write(bVar.bsd);
            com.tencent.matrix.resource.c.b.a.c(this.brV, i2);
            this.brV.write(bVar2.bsd);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    public final void a(b bVar, b bVar2, b bVar3, b bVar4, int i, int i2, int i3, long j) {
        try {
            this.brV.write(4);
            com.tencent.matrix.resource.c.b.a.c(this.brV, i3);
            com.tencent.matrix.resource.c.b.a.c(this.brV, (int) j);
            this.brV.write(bVar.bsd);
            this.brV.write(bVar2.bsd);
            this.brV.write(bVar3.bsd);
            this.brV.write(bVar4.bsd);
            com.tencent.matrix.resource.c.b.a.c(this.brV, i);
            com.tencent.matrix.resource.c.b.a.c(this.brV, i2);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    public final void a(int i, int i2, b[] bVarArr, int i3, long j) {
        try {
            this.brV.write(5);
            com.tencent.matrix.resource.c.b.a.c(this.brV, i3);
            com.tencent.matrix.resource.c.b.a.c(this.brV, (int) j);
            com.tencent.matrix.resource.c.b.a.c(this.brV, i);
            com.tencent.matrix.resource.c.b.a.c(this.brV, i2);
            com.tencent.matrix.resource.c.b.a.c(this.brV, bVarArr.length);
            for (b bVar : bVarArr) {
                this.brV.write(bVar.bsd);
            }
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    private a b(int i, int i2, long j) {
        try {
            return new a(i, i2, j);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    public final void a(int i, int i2, long j, byte[] bArr) {
        try {
            this.brV.write(i);
            com.tencent.matrix.resource.c.b.a.c(this.brV, i2);
            com.tencent.matrix.resource.c.b.a.c(this.brV, (int) j);
            this.brV.write(bArr, 0, (int) j);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    public final void tz() {
        try {
            this.brV.flush();
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }
}
