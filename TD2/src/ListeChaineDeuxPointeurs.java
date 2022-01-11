import javax.lang.model.element.Element;


public class ListeChaineDeuxPointeurs {
    private Element tete;
    private Element queue;
    public ListeChaineDeuxPointeurs(int i){
        tete=new Element(i);
        queue=tete;
    }
    public ListeChaineDeuxPointeurs(int i, ListeChainee next){

    }



}
