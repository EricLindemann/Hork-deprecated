package eric.hork.expandListView.Classes;

import java.util.ArrayList;

/**
 * Created by eric on 4/12/15.
 */
public class ExpandListGroup {
    private String name;
    private ArrayList<ExpandListChild> items;

    public String getName(){
        return name;
    }

    public void setName(String nameToSet){
        this.name = nameToSet;
    }

    public ArrayList<ExpandListChild>  getItems(){
        return items;
    }

    public void setItems(ArrayList<ExpandListChild> itemsToSet){
        this.items = itemsToSet;
    }



}
