package ru.vsu.lab1;

public abstract class ARep implements Repository {
    Object[] rep;
    int size;
    int kol;

    @Override
    public void add(Object item) {

        if (kol < size) {
            rep[kol] = item;
            kol++;
        } else {
            size = size + 2;
            Object[] rep2;
            rep2 = new Object[size];

            System.arraycopy(rep, 0, rep2, 0, kol);
            rep2[kol] = item;
            kol++;
            rep = rep2;
        }

    }

    @Override
    public void delete(int index) {
        boolean isFind = false;
        int indexDel = -1;
        for (int j = 0; j < kol && !isFind; j++) {
            if (j==index) {
                isFind = true;
                indexDel = j;
            }
        }
        if (indexDel != -1) {
            for (int j = indexDel; j < kol - 1; j++) {
                rep[j] = rep[j + 1];
            }
            kol--;
            rep[kol] = null;
        } else {
            System.out.println("Такого индекса нет в репозитории");
        }
    }
}
