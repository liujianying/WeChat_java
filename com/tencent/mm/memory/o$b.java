package com.tencent.mm.memory;

public class o$b implements Comparable {
    private String dvr;
    public int height;
    public int width;

    public o$b(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.dvr = String.format("SightBitmapSize: [%s, %s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final int compareTo(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (!(obj instanceof o$b)) {
            return 0;
        }
        if (this.width == ((o$b) obj).width && this.height == ((o$b) obj).height) {
            return 0;
        }
        if (this.height * this.width > ((o$b) obj).width * ((o$b) obj).height) {
            return 1;
        }
        return -1;
    }

    public final String toString() {
        return this.dvr;
    }
}
