package com.tencent.tinker.loader.shareutil;

import com.tencent.wcdb.FileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class ShareElfFile implements Closeable {
    private final FileInputStream vuH;
    private final Map<String, SectionHeader> vuI = new HashMap();
    public ElfHeader vuJ = null;
    public ProgramHeader[] vuK = null;
    public SectionHeader[] vuL = null;

    public static class ElfHeader {
        public final byte[] vuM;
        public final short vuN;
        public final short vuO;
        public final int vuP;
        public final long vuQ;
        public final long vuR;
        public final long vuS;
        public final int vuT;
        public final short vuU;
        public final short vuV;
        public final short vuW;
        public final short vuX;
        public final short vuY;
        public final short vuZ;

        /* synthetic */ ElfHeader(FileChannel fileChannel, byte b) {
            this(fileChannel);
        }

        private ElfHeader(FileChannel fileChannel) {
            this.vuM = new byte[16];
            fileChannel.position(0);
            fileChannel.read(ByteBuffer.wrap(this.vuM));
            if (this.vuM[0] == Byte.MAX_VALUE && this.vuM[1] == (byte) 69 && this.vuM[2] == (byte) 76 && this.vuM[3] == (byte) 70) {
                ShareElfFile.v(this.vuM[4], 2, "bad elf class: " + this.vuM[4]);
                ShareElfFile.v(this.vuM[5], 2, "bad elf data encoding: " + this.vuM[5]);
                ByteBuffer allocate = ByteBuffer.allocate(this.vuM[4] == (byte) 1 ? 36 : 48);
                allocate.order(this.vuM[5] == (byte) 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                ShareElfFile.a(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.vuN = allocate.getShort();
                this.vuO = allocate.getShort();
                this.vuP = allocate.getInt();
                ShareElfFile.v(this.vuP, 1, "bad elf version: " + this.vuP);
                switch (this.vuM[4]) {
                    case (byte) 1:
                        this.vuQ = (long) allocate.getInt();
                        this.vuR = (long) allocate.getInt();
                        this.vuS = (long) allocate.getInt();
                        break;
                    case (byte) 2:
                        this.vuQ = allocate.getLong();
                        this.vuR = allocate.getLong();
                        this.vuS = allocate.getLong();
                        break;
                    default:
                        throw new IOException("Unexpected elf class: " + this.vuM[4]);
                }
                this.vuT = allocate.getInt();
                this.vuU = allocate.getShort();
                this.vuV = allocate.getShort();
                this.vuW = allocate.getShort();
                this.vuX = allocate.getShort();
                this.vuY = allocate.getShort();
                this.vuZ = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", new Object[]{Byte.valueOf(this.vuM[0]), Byte.valueOf(this.vuM[1]), Byte.valueOf(this.vuM[2]), Byte.valueOf(this.vuM[3])}));
        }
    }

    public static class ProgramHeader {
        public final int vva;
        public final int vvb;
        public final long vvc;
        public final long vvd;
        public final long vve;
        public final long vvf;
        public final long vvg;
        public final long vvh;

        /* synthetic */ ProgramHeader(ByteBuffer byteBuffer, int i, byte b) {
            this(byteBuffer, i);
        }

        private ProgramHeader(ByteBuffer byteBuffer, int i) {
            switch (i) {
                case 1:
                    this.vva = byteBuffer.getInt();
                    this.vvc = (long) byteBuffer.getInt();
                    this.vvd = (long) byteBuffer.getInt();
                    this.vve = (long) byteBuffer.getInt();
                    this.vvf = (long) byteBuffer.getInt();
                    this.vvg = (long) byteBuffer.getInt();
                    this.vvb = byteBuffer.getInt();
                    this.vvh = (long) byteBuffer.getInt();
                    return;
                case 2:
                    this.vva = byteBuffer.getInt();
                    this.vvb = byteBuffer.getInt();
                    this.vvc = byteBuffer.getLong();
                    this.vvd = byteBuffer.getLong();
                    this.vve = byteBuffer.getLong();
                    this.vvf = byteBuffer.getLong();
                    this.vvg = byteBuffer.getLong();
                    this.vvh = byteBuffer.getLong();
                    return;
                default:
                    throw new IOException("Unexpected elf class: " + i);
            }
        }
    }

    public static class SectionHeader {
        public final int vvi;
        public final int vvj;
        public final long vvk;
        public final long vvl;
        public final long vvm;
        public final long vvn;
        public final int vvo;
        public final int vvp;
        public final long vvq;
        public final long vvr;
        public String vvs;

        /* synthetic */ SectionHeader(ByteBuffer byteBuffer, int i, byte b) {
            this(byteBuffer, i);
        }

        private SectionHeader(ByteBuffer byteBuffer, int i) {
            switch (i) {
                case 1:
                    this.vvi = byteBuffer.getInt();
                    this.vvj = byteBuffer.getInt();
                    this.vvk = (long) byteBuffer.getInt();
                    this.vvl = (long) byteBuffer.getInt();
                    this.vvm = (long) byteBuffer.getInt();
                    this.vvn = (long) byteBuffer.getInt();
                    this.vvo = byteBuffer.getInt();
                    this.vvp = byteBuffer.getInt();
                    this.vvq = (long) byteBuffer.getInt();
                    this.vvr = (long) byteBuffer.getInt();
                    break;
                case 2:
                    this.vvi = byteBuffer.getInt();
                    this.vvj = byteBuffer.getInt();
                    this.vvk = byteBuffer.getLong();
                    this.vvl = byteBuffer.getLong();
                    this.vvm = byteBuffer.getLong();
                    this.vvn = byteBuffer.getLong();
                    this.vvo = byteBuffer.getInt();
                    this.vvp = byteBuffer.getInt();
                    this.vvq = byteBuffer.getLong();
                    this.vvr = byteBuffer.getLong();
                    break;
                default:
                    throw new IOException("Unexpected elf class: " + i);
            }
            this.vvs = null;
        }
    }

    static /* synthetic */ void v(int i, int i2, String str) {
        if (i <= 0 || i > i2) {
            throw new IOException(str);
        }
    }

    public ShareElfFile(File file) {
        int i;
        int i2 = 0;
        this.vuH = new FileInputStream(file);
        FileChannel channel = this.vuH.getChannel();
        this.vuJ = new ElfHeader(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(FileUtils.S_IWUSR);
        allocate.limit(this.vuJ.vuV);
        allocate.order(this.vuJ.vuM[5] == (byte) 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.vuJ.vuR);
        this.vuK = new ProgramHeader[this.vuJ.vuW];
        for (i = 0; i < this.vuK.length; i++) {
            a(channel, allocate, "failed to read phdr.");
            this.vuK[i] = new ProgramHeader(allocate, this.vuJ.vuM[4], (byte) 0);
        }
        channel.position(this.vuJ.vuS);
        allocate.limit(this.vuJ.vuX);
        this.vuL = new SectionHeader[this.vuJ.vuY];
        for (i = 0; i < this.vuL.length; i++) {
            a(channel, allocate, "failed to read shdr.");
            this.vuL[i] = new SectionHeader(allocate, this.vuJ.vuM[4], (byte) 0);
        }
        if (this.vuJ.vuZ > (short) 0) {
            SectionHeader sectionHeader = this.vuL[this.vuJ.vuZ];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) sectionHeader.vvn);
            this.vuH.getChannel().position(sectionHeader.vvm);
            a(this.vuH.getChannel(), allocate2, "failed to read section: " + sectionHeader.vvs);
            SectionHeader[] sectionHeaderArr = this.vuL;
            int length = sectionHeaderArr.length;
            while (i2 < length) {
                SectionHeader sectionHeader2 = sectionHeaderArr[i2];
                allocate2.position(sectionHeader2.vvi);
                sectionHeader2.vvs = y(allocate2);
                this.vuI.put(sectionHeader2.vvs, sectionHeader2);
                i2++;
            }
        }
    }

    public static int af(File file) {
        Throwable th;
        InputStream inputStream;
        try {
            byte[] bArr = new byte[4];
            InputStream fileInputStream = new FileInputStream(file);
            try {
                fileInputStream.read(bArr);
                if (bArr[0] == (byte) 100 && bArr[1] == (byte) 101 && bArr[2] == (byte) 121 && bArr[3] == (byte) 10) {
                    try {
                        fileInputStream.close();
                        return 0;
                    } catch (Throwable th2) {
                        return 0;
                    }
                } else if (bArr[0] == Byte.MAX_VALUE && bArr[1] == (byte) 69 && bArr[2] == (byte) 76 && bArr[3] == (byte) 70) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                    }
                    return 1;
                } else {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th4) {
                    }
                    return -1;
                }
            } catch (Throwable th5) {
                th = th5;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th6) {
                    }
                }
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th62) {
                }
            }
            throw th;
        }
    }

    public static void a(FileChannel fileChannel, ByteBuffer byteBuffer, String str) {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read != byteBuffer.limit()) {
            throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
        }
        byteBuffer.flip();
    }

    private static String y(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != (byte) 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName("ASCII"));
    }

    public void close() {
        this.vuH.close();
        this.vuI.clear();
        this.vuK = null;
        this.vuL = null;
    }
}
