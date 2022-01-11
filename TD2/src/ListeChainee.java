import javax.lang.model.element.Element;

public class ListeChainee {
    private Element first;

    public ListeChainee() {
        first = null;
    }

    public int getFirst() {
        return first.getInfo();
    }

    public int size() {
        int cpt = 0;
        Element tmp = first;
        while (tmp != null) {
            cpt++;
            tmp = tmp.getSuivant();
        }
        return cpt;
    }

    public void print() {
        Element tmp = first;
        if (first == null)
            System.out.println("Liste vide");
        else
            while (tmp != null) {
                System.out.println(tmp.getInfo());
                tmp = tmp.getSuivant();
            }
    }

    public boolean search(int i) {
        Element tmp = first;
        while (tmp != null) {
            if (tmp.getInfo() == i)
                return true;
            tmp = tmp.getSuivant();
        }
        return false;
    }

    public boolean remove(int i) {
        Element p, prec, suiv;
        if (first == null) return false;
        if (first.getInfo() == i) {
            first = first.getSuivant();
            return true;
        }
        prec = first;
        p = first.getSuivant();
        while (p != null && p.getInfo() != i) {
            prec = p;
            p = p.getSuivant();

        }
        if (p != null) {
            suiv = p.getSuivant();
            prec.setSuivant(suiv);
            return true;
        }
        return false;
    }

    public boolean removeAll(int i) {
       /* boolean supprime=false;
        while (search(i)){
            supprime=remove(i);
        }
        return true;*/

        boolean existe = search(i);
        if (existe == true) {
            while (remove(i)) {
                ;
            }
        }
        return existe;
    }

    public boolean removePosition(int pos) {
        Element p, prec;
        int i = 0;
        if (first == null) return false;
        if (pos == 0) {
            first = first.getSuivant();
            return true;
        }
        prec = first;
        p = first.getSuivant();
        while (i < pos && p != null) {
            i++;
            prec = p;
            p = p.getSuivant();
        }
        if (p != null) {
            prec.setSuivant(p.getSuivant());
            return true;
        }
        return false;
    }

    public void ajouteTete(int i) {
        Element p;
        p = new Element(i, first);
        first = p;
    }

    public void ajouteQueue(int i) {
        Element p, nouv;
        if (first == null) {
            ajouteTete(i);
        } else {
            p = first;

            while (p.getSuivant() != null) {
                p = p.getSuivant();
            }
            nouv = new Element(i);
            p.setSuivant(nouv);
        }
    }

    public ListeChainee duplicate(){
        ListeChainee copie=new ListeChainee();
        Element p=first;
        while (p != null) {
            copie.ajouteQueue(p.getInfo());
            p=p.getSuivant();
        }
        return copie;
    }

    //public ListeChainee duplicateReverse(){}


}
