package com.tencent.mm.plugin.a;

import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Random;

public final class d {
    private static final int eyB = S(new byte[]{(byte) 102, (byte) 114, (byte) 101, (byte) 101});
    private static final int eyC = S(new byte[]{(byte) 106, (byte) 117, (byte) 110, (byte) 107});
    private static final int eyD = S(new byte[]{(byte) 109, (byte) 100, (byte) 97, (byte) 116});
    private static final int eyE = S(new byte[]{(byte) 109, (byte) 111, (byte) 111, (byte) 118});
    private static final int eyF = S(new byte[]{(byte) 112, (byte) 110, (byte) 111, (byte) 116});
    private static final int eyG = S(new byte[]{(byte) 115, (byte) 107, (byte) 105, (byte) 112});
    private static final int eyH = S(new byte[]{(byte) 119, (byte) 105, (byte) 100, (byte) 101});
    private static final int eyI = S(new byte[]{(byte) 80, (byte) 73, (byte) 67, (byte) 84});
    private static final int eyJ = S(new byte[]{(byte) 102, (byte) 116, (byte) 121, (byte) 112});
    private static final int eyK = S(new byte[]{(byte) 117, (byte) 117, (byte) 105, (byte) 100});
    private static final int eyL = S(new byte[]{(byte) 99, (byte) 109, (byte) 111, (byte) 118});
    private static final int eyM = S(new byte[]{(byte) 115, (byte) 116, (byte) 99, (byte) 111});
    private static final int eyN = S(new byte[]{(byte) 99, (byte) 111, (byte) 54, (byte) 52});

    private static boolean aI(String str, String str2) {
        Exception e;
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(str);
        File file2 = new File(str2);
        if (file.length() != file2.length()) {
            x.w("MicroMsg.FastStart", "check size not right");
            return false;
        }
        long oY = new b().oY(str);
        f fVar = new f();
        fVar.s(str, oY);
        int i = fVar.eyV;
        long oY2 = new b().oY(str2);
        f fVar2 = new f();
        fVar2.s(str2, oY2);
        int i2 = fVar2.eyV;
        if (i2 != i) {
            x.w("MicroMsg.FastStart", "check duration not right");
            return false;
        }
        x.d("MicroMsg.FastStart", "old duration:" + i + " new duration: " + i2);
        i = new Random().nextInt(i2 - 1) + 1;
        if (i + 1 <= i2) {
            i2 = i + 1;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        fVar.a(i, i2, pInt, pInt2);
        PInt pInt3 = new PInt();
        PInt pInt4 = new PInt();
        fVar2.a(i, i2, pInt3, pInt4);
        if (pInt4.value != pInt2.value) {
            x.w("MicroMsg.FastStart", "check len not right");
            return false;
        }
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        try {
            fileInputStream2 = new FileInputStream(file);
            try {
                fileInputStream2.skip((long) pInt.value);
                byte[] bArr = new byte[GLIcon.LEFT];
                fileInputStream2.read(bArr);
                fileInputStream3 = new FileInputStream(file2);
                try {
                    fileInputStream3.skip((long) pInt3.value);
                    byte[] bArr2 = new byte[GLIcon.LEFT];
                    fileInputStream2.read(bArr2);
                    if (Arrays.equals(bArr, bArr2)) {
                        x.w("MicroMsg.FastStart", "check data not right");
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                        }
                        try {
                            fileInputStream3.close();
                        } catch (IOException e3) {
                        }
                        return false;
                    }
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                    }
                    try {
                        fileInputStream3.close();
                    } catch (IOException e5) {
                    }
                    return true;
                } catch (Exception e6) {
                    e = e6;
                    fileInputStream = fileInputStream3;
                    try {
                        x.w("MicroMsg.FastStart", "fast start error: " + e.toString());
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e7) {
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e8) {
                            }
                        }
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream3 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (fileInputStream3 != null) {
                            try {
                                fileInputStream3.close();
                            } catch (IOException e10) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e92) {
                        }
                    }
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                        } catch (IOException e102) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                fileInputStream = null;
                x.w("MicroMsg.FastStart", "fast start error: " + e.toString());
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e72) {
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e82) {
                    }
                }
                return true;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream3 = null;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e922) {
                    }
                }
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                    } catch (IOException e1022) {
                    }
                }
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            fileInputStream = null;
            fileInputStream2 = null;
            x.w("MicroMsg.FastStart", "fast start error: " + e.toString());
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e722) {
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e822) {
                }
            }
            return true;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream3 = null;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e9222) {
                }
            }
            if (fileInputStream3 != null) {
                try {
                    fileInputStream3.close();
                } catch (IOException e10222) {
                }
            }
            throw th;
        }
    }

    private static int S(byte[] bArr) {
        return ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getInt();
    }

    private static int bJ(long j) {
        if (j <= 2147483647L && j >= 0) {
            return (int) j;
        }
        throw new Exception("uint32 value is too large");
    }

    private static boolean a(FileChannel fileChannel, ByteBuffer byteBuffer) {
        byteBuffer.clear();
        int read = fileChannel.read(byteBuffer);
        byteBuffer.flip();
        return read == byteBuffer.capacity();
    }

    private static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                x.w("MicroMsg.FastStart", "Failed to close file: ");
            }
        }
    }

    public static boolean b(String str, String str2, PInt pInt) {
        boolean a;
        Exception e;
        Throwable th;
        boolean z = false;
        File file = new File(str);
        File file2 = new File(str2);
        Closeable fileInputStream;
        Closeable fileOutputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream.getChannel();
                fileOutputStream = new FileOutputStream(file2);
                try {
                    a = a(channel, fileOutputStream.getChannel(), pInt);
                    if (a) {
                        try {
                            a = aI(str, str2);
                        } catch (Exception e2) {
                            e = e2;
                            z = a;
                        }
                    }
                    e(fileInputStream);
                    e(fileOutputStream);
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e32) {
                e = e32;
                fileOutputStream = null;
                try {
                    x.w("MicroMsg.FastStart", "fast start error: " + e.toString());
                    e(fileInputStream);
                    e(fileOutputStream);
                    a = z;
                    if (!a) {
                        file2.delete();
                    }
                    return a;
                } catch (Throwable th2) {
                    th = th2;
                    e(fileInputStream);
                    e(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                e(fileInputStream);
                e(fileOutputStream);
                throw th;
            }
        } catch (Exception e322) {
            e = e322;
            fileOutputStream = null;
            fileInputStream = null;
            x.w("MicroMsg.FastStart", "fast start error: " + e.toString());
            e(fileInputStream);
            e(fileOutputStream);
            a = z;
            if (a) {
                file2.delete();
            }
            return a;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            fileInputStream = null;
            e(fileInputStream);
            e(fileOutputStream);
            throw th;
        }
        if (a) {
            file2.delete();
        }
        return a;
    }

    private static boolean a(FileChannel fileChannel, FileChannel fileChannel2, PInt pInt) {
        long j;
        int bJ;
        int i = 0;
        long j2 = 0;
        ByteBuffer byteBuffer = null;
        ByteBuffer order = ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN);
        long j3 = 0;
        Object obj = null;
        Object obj2 = null;
        long j4 = -1;
        while (a(fileChannel, order)) {
            j = 4294967295L & ((long) order.getInt());
            i = order.getInt();
            if (i == eyJ) {
                obj = 1;
                bJ = bJ(j);
                byteBuffer = ByteBuffer.allocate(bJ).order(ByteOrder.BIG_ENDIAN);
                order.rewind();
                byteBuffer.put(order);
                if (fileChannel.read(byteBuffer) < bJ - 8) {
                    obj2 = null;
                    break;
                }
                byteBuffer.flip();
                j3 = fileChannel.position();
                j2 = j;
            } else if (i == eyE) {
                j2 = fileChannel.position() - 8;
                if (obj2 == null) {
                    x.d("MicroMsg.FastStart", "it moov before mdat, needn't fast start");
                    pInt.value = 1;
                    return false;
                }
                x.d("MicroMsg.FastStart", "it moov after mdat, need fast start");
                j4 = j2;
                obj2 = 1;
            } else {
                if (i == eyD) {
                    obj2 = 1;
                }
                if (j == 1) {
                    order.clear();
                    if (!a(fileChannel, order)) {
                        obj2 = null;
                        break;
                    }
                    j = order.getLong();
                    if (j < 0) {
                        throw new Exception("uint64 value is too large");
                    }
                    fileChannel.position((fileChannel.position() + j) - 16);
                    j2 = j;
                } else {
                    fileChannel.position((fileChannel.position() + j) - 8);
                    j2 = j;
                }
            }
            if (j2 < 8) {
                x.w("MicroMsg.FastStart", "atom size less 8, it error mp4.");
                return false;
            }
        }
        obj2 = null;
        j = j2;
        if (obj == null || r2 == null) {
            x.w("MicroMsg.FastStart", "it can not find moov or ftyp");
            return false;
        } else if (i != eyE || j4 < 0) {
            x.w("MicroMsg.FastStart", "it can not find moov atom");
            return false;
        } else {
            int bJ2 = bJ(j);
            ByteBuffer order2 = ByteBuffer.allocate(bJ2).order(ByteOrder.BIG_ENDIAN);
            order2.clear();
            int read = fileChannel.read(order2, j4);
            order2.flip();
            if ((read == order2.capacity() ? 1 : null) == null) {
                x.w("MicroMsg.FastStart", "failed to read moov atom");
                return false;
            } else if (order2.getInt(12) == eyL) {
                x.w("MicroMsg.FastStart", "this utility does not support compressed moov atoms yet");
                return false;
            } else {
                while (order2.remaining() >= 8) {
                    read = order2.position();
                    i = order2.getInt(read + 4);
                    if (i != eyM && i != eyN) {
                        order2.position(order2.position() + 1);
                    } else if ((((long) order2.getInt(read)) & 4294967295L) > ((long) order2.remaining())) {
                        x.w("MicroMsg.FastStart", "bad atom size");
                        return false;
                    } else {
                        order2.position(read + 12);
                        if (order2.remaining() < 4) {
                            x.w("MicroMsg.FastStart", "malformed atom");
                            return false;
                        }
                        bJ = bJ((long) order2.getInt());
                        if (i == eyM) {
                            if (order2.remaining() < bJ * 4) {
                                x.w("MicroMsg.FastStart", "bad atom size/element count");
                                return false;
                            }
                            for (read = 0; read < bJ; read++) {
                                i = order2.getInt(order2.position());
                                int i2 = i + bJ2;
                                if (i < 0 && i2 >= 0) {
                                    return false;
                                }
                                order2.putInt(i2);
                            }
                            continue;
                        } else if (i != eyN) {
                            continue;
                        } else if (order2.remaining() < bJ * 8) {
                            x.w("MicroMsg.FastStart", "bad atom size/element count");
                            return false;
                        } else {
                            for (read = 0; read < bJ; read++) {
                                order2.putLong(order2.getLong(order2.position()) + ((long) bJ2));
                            }
                        }
                    }
                }
                fileChannel.position(j3);
                if (byteBuffer != null) {
                    byteBuffer.rewind();
                    fileChannel2.write(byteBuffer);
                }
                order2.rewind();
                fileChannel2.write(order2);
                fileChannel.transferTo(j3, j4 - j3, fileChannel2);
                fileChannel.transferTo(j4 + ((long) bJ2), (fileChannel.size() - j4) - ((long) bJ2), fileChannel2);
                return true;
            }
        }
    }
}
