package pratice.random;

public class HashAlgorithms {

    public static int additiveHash(String key, int prime) {
        int hash, i;
        for (hash = key.length(), i = 0; i < key.length(); i++)
            hash += key.charAt(i);
        return (hash % prime);
    }

    public static int rotatingHash(String key, int prime) {
        int hash, i;
        for (hash = key.length(), i = 0; i < key.length(); ++i)
            hash = (hash << 4) ^ (hash >> 28) ^ key.charAt(i);
        return (hash % prime);
    }

    static int M_MASK = 0x8765fed1;

    public static int oneByOneHash(String key) {
        int hash, i;
        for (hash = 0, i = 0; i < key.length(); ++i) {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
        // return (hash & M_MASK);
        return hash;
    }

    public static int bernstein(String key) {
        int hash = 0;
        int i;
        for (i = 0; i < key.length(); ++i)
            hash = 33 * hash + key.charAt(i);
        return hash;
    }

    public static int universal(char[] key, int mask, int[] tab) {
        int hash = key.length, i, len = key.length;
        for (i = 0; i < (len << 3); i += 8) {
            char k = key[i >> 3];
            if ((k & 0x01) == 0)
                hash ^= tab[i + 0];
            if ((k & 0x02) == 0)
                hash ^= tab[i + 1];
            if ((k & 0x04) == 0)
                hash ^= tab[i + 2];
            if ((k & 0x08) == 0)
                hash ^= tab[i + 3];
            if ((k & 0x10) == 0)
                hash ^= tab[i + 4];
            if ((k & 0x20) == 0)
                hash ^= tab[i + 5];
            if ((k & 0x40) == 0)
                hash ^= tab[i + 6];
            if ((k & 0x80) == 0)
                hash ^= tab[i + 7];
        }
        return (hash & mask);
    }

    public static int zobrist(char[] key, int mask, int[][] tab) {
        int hash, i;
        for (hash = key.length, i = 0; i < key.length; ++i)
            hash ^= tab[i][key[i]];
        return (hash & mask);
    }

    static int M_SHIFT = 0;

    public static int FNVHash(byte[] data) {
        int hash = (int) 2166136261L;
        for (byte b : data)
            hash = (hash * 16777619) ^ b;
        if (M_SHIFT == 0)
            return hash;
        return (hash ^ (hash >> M_SHIFT)) & M_MASK;
    }

    public static int FNVHash1(byte[] data) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (byte b : data)
            hash = (hash ^ b) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return hash;
    }

    public static int FNVHash1(String data) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < data.length(); i++)
            hash = (hash ^ data.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return hash;
    }
}
