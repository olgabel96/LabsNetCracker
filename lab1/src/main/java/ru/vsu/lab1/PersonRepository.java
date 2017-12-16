package ru.vsu.lab1;

public class PersonRepository extends ARep {
   // Person[] rep;
   // int size;
   // int kolPerson;


    public PersonRepository() {
        this.size = 2;
        this.kol = 0;
        this.rep = new Person[size];
    }

   // public Person[] getRep() {
    //    return rep;
    //}

    public int getSize() {
        return size;
    }

    public int getKolPerson() { return kol; }
/*
    public void addPerson(Person newPerson) {
        if (kolPerson < size) {
            rep[kolPerson] = newPerson;
            kolPerson++;
        } else {
            size = size + 2;
            Person[] rep2;
            rep2 = new Person[size];
            System.arraycopy(rep, 0, rep2, 0, kolPerson);
            rep2[kolPerson] = newPerson;
            kolPerson++;
            rep = rep2;
        }
    }
*/
/*
    public void delPerson(String idDel) {
        boolean isFind = false;
        int indexDel = -1;
        for (int j = 0; j < kolPerson && !isFind; j++) {
            if (rep[j].getId().equals(idDel)) {
                isFind = true;
                indexDel = j;
            }
        }
        if (indexDel != -1) {
            for (int j = indexDel; j < kolPerson - 1; j++) {
                rep[j] = rep[j + 1];
            }
            kolPerson--;
            rep[kolPerson] = null;
        } else {
            System.out.println("Человек с таким id не найден");
        }
    }
*/

    public void printRep(){
        for(int i=0;i<kol;i++){
            System.out.println(rep[i].toString());
        }
    }
}
